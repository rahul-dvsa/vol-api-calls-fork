package apiCalls.actions;

import activesupport.dates.Dates;
import activesupport.faker.FakerUtils;
import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.volBuilders.*;
import apiCalls.Utils.generic.BaseAPI;
import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import apiCalls.enums.UserRoles;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.joda.time.LocalDate;
import org.junit.Assert;

import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrantLicence extends BaseAPI {

    private static final Logger LOGGER = LogManager.getLogger(GrantLicence.class);
    private final EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));
    private final FakerUtils faker = new FakerUtils();
    private final Headers apiHeaders = new Headers();
    private final Dates date = new Dates(LocalDate::new);
    private ValidatableResponse apiResponse;
    private final CreateApplication application;
    private List outstandingFeesIds;
    private final List<Double> feesToPay = new ArrayList<>();
    private int feeId;
    private String dateState;
    private final AccessToken jwtToken = new AccessToken();

    private void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public String getDateState() {
        return dateState;
    }

    public void setDateState(String dateState) {
        this.dateState = dateState;
    }

    public GrantLicence(CreateApplication application) {
        this.application = application;
        setDateState(date.getFormattedDate(0, 0, 0, "yyyy-MM-dd"));
        apiHeaders.getHeaders().put("Authorization", "Bearer " + AccessToken.getToken(Utils.config.getString("adminUser"), Utils.config.getString("adminPassword"), UserRoles.INTERNAL.asString()));
    }

    public ValidatableResponse grantLicence() {
        createOverview();
        getOutstandingFees();
        payOutstandingFees();
        grant();
        return apiResponse;
    }

    /***
     * To use the following methods:
     * First Pass in a GetUserDetails object into a CreateApplication object and set the organisationId within GetUserDetails.
     * Second set applicationId within your CreateApplication object and then call the methods within GrantLicence.
     */

    public void createOverview() {

        String overviewResource = URL.build(env, String.format("application/%s/overview/", application.getApplicationId())).toString();
        String status = "1";
        String overrideOption = "Y";
        String transportArea = "D";
        String trackingId = fetchApplicationInformation(application.getApplicationId(), "applicationTracking.id", null);
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(application.getApplicationId(), "version", "1"));
        int applicationTrackingVersion = Integer.parseInt(fetchApplicationInformation(application.getApplicationId(), "applicationTracking.version", "1"));

        TrackingBuilder tracking = new TrackingBuilder().withId(trackingId).withVersion(applicationTrackingVersion).withAddressesStatus(status).withBusinessDetailsStatus(status).withBusinessTypeStatus(status)
                .withCommunityLicencesStatus(status).withConditionsUndertakingsStatus(status).withConvictionsPenaltiesStatus(status).withFinancialEvidenceStatus(status)
                .withFinancialHistoryStatus(status).withLicenceHistoryStatus(status).withOperatingCentresStatus(status).withPeopleStatus(status).withSafetyStatus(status)
                .withTransportManagersStatus(status).withTypeOfLicenceStatus(status).withDeclarationsInternalStatus(status).withVehiclesDeclarationsStatus(status).withVehiclesStatus(status).withVehiclesPsvStatus(status)
                .withTaxiPhvStatus(status);
        OverviewBuilder overview = new OverviewBuilder().withId(application.getApplicationId()).withVersion(applicationVersion).withLeadTcArea(transportArea).withOverrideOppositionDate(overrideOption)
                .withTracking(tracking);
        apiResponse = RestUtils.put(overview, overviewResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
    }

    public void getOutstandingFees() {

        String getOutstandingFeesResource = URL.build(env, String.format("application/%s/outstanding-fees/", application.getApplicationId())).toString();
        apiResponse = RestUtils.get(getOutstandingFeesResource, apiHeaders.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        } else if (!apiResponse.extract().response().body().jsonPath().getList("outstandingFees.id").isEmpty()) {
            outstandingFeesIds = apiResponse.extract().response().body().jsonPath().getList("outstandingFees.id");
            List<String> fees = apiResponse.extract().response().body().jsonPath().get("outstandingFees.grossAmount");
            for (String d : fees) {
                try {
                    feesToPay.add(Double.parseDouble(d));
                } catch (NumberFormatException e) {
                    e.fillInStackTrace();
                }
            }
        }
    }

    public void payOutstandingFees() {
        String payer = faker.generateFirstName() + faker.generateLastName();
        String paymentMethod = "fpm_cash";
        String slipNo = "123456";

        String payOutstandingFeesResource = URL.build(env, "transaction/pay-outstanding-fees/").toString();
        FeesBuilder feesBuilder = new FeesBuilder().withFeeIds(outstandingFeesIds).withOrganisationId(application.getUserDetails().getOrganisationId()).withApplicationId(application.getApplicationId())
                .withPaymentMethod(paymentMethod).withReceived(feesToPay.stream().mapToDouble(Double::doubleValue).sum()).withReceiptDate(getDateState()).withPayer(payer).withSlipNo(slipNo);
        apiResponse = RestUtils.post(feesBuilder, payOutstandingFeesResource, apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);
    }

    public void grant() {
        String grantApplicationResource = URL.build(env, String.format("application/%s/grant/", application.getApplicationId())).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(application.getApplicationId()).withDuePeriod("9")
                .withAuthority("grant_authority_dl").withCaseworkerNotes("This notes are from the API");
        apiResponse = RestUtils.put(grantApplication, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        } else if (apiResponse.extract().response().asString().contains("fee")) {
            setFeeId(apiResponse.extract().response().jsonPath().getInt("id.fee"));
            try {
                String apiMessages = apiResponse.extract().jsonPath().get("messages").toString();
                Assert.assertTrue(apiMessages.contains("Application status updated"));
                Assert.assertTrue(apiMessages.contains("Licence status updated"));
            } catch (AssertionError e) {
                throw new AssertionError("Licence failed to grant through the API.");
            }
        }
    }

    public ValidatableResponse payGrantFees(String NIFlag) {
        String payer = faker.generateFirstName() + faker.generateLastName();
        Double grantFees = NIFlag.equals("Y") ? 449.00 : 401.00;
        String paymentMethod = "fpm_cash";
        String slipNo = "123456";

        String payOutstandingFeesResource = URL.build(env, "transaction/pay-outstanding-fees/").toString();

        FeesBuilder feesBuilder = new FeesBuilder().withFeeIds(Collections.singletonList(feeId)).withOrganisationId(application.getUserDetails().getOrganisationId()).withApplicationId(application.getApplicationId())
                .withPaymentMethod(paymentMethod).withReceived(grantFees).withReceiptDate(getDateState()).withPayer(payer).withSlipNo(slipNo);
        apiResponse = RestUtils.post(feesBuilder, payOutstandingFeesResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);

        return apiResponse;
    }

    private void variationGrant() {
        String grantApplicationResource = URL.build(env, String.format("variation/%s/grant/", application.getApplicationId())).toString();
        GenericBuilder grantVariationBuilder = new GenericBuilder().withId(application.getApplicationId());
        apiResponse = RestUtils.put(grantVariationBuilder, grantApplicationResource, apiHeaders.getHeaders());
        apiResponse = RestUtils.put(grantVariationBuilder, grantApplicationResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

    }

    public void refuse(String applicationId) {
        String grantApplicationResource = URL.build(env, String.format("application/%s/refuse/", applicationId)).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(applicationId).withCaseworkerNotes("This notes are from the API");
        apiResponse = RestUtils.put(grantApplication, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        } else if (apiResponse.extract().response().asString().contains("fee")) {
            setFeeId(apiResponse.extract().response().jsonPath().getInt("id.fee"));
        }
    }

    public void withdraw(String applicationId) {
        String grantApplicationResource = URL.build(env, String.format("application/%s/withdraw/", applicationId)).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(applicationId).withReason("reg_in_error");
        apiResponse = RestUtils.put(grantApplication, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        } else if (apiResponse.extract().response().asString().contains("fee")) {
            setFeeId(apiResponse.extract().response().jsonPath().getInt("id.fee"));
        }
    }
}