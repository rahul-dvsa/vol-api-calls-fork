package apiCalls.actions;

import activesupport.dates.DateState;
import activesupport.faker.FakerUtils;
import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.builders.*;
import apiCalls.Utils.generic.BaseAPI;
import apiCalls.Utils.generic.Headers;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.junit.Assert;

import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrantLicence extends BaseAPI{

    private static final Logger LOGGER = LogManager.getLogger(GrantLicence.class);
    private EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));
    private ValidatableResponse apiResponse;
    private List outstandingFeesIds;
    private int feeId;
    private FakerUtils faker = new FakerUtils();
    private Headers apiHeaders = new Headers();

    private String organisationId;
    private String applicationNumber;


    private List<Double> feesToPay = new ArrayList<>();
    private String dateState;

    private void setFeeId(int feeId){
        this.feeId = feeId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getDateState() {
        return dateState;
    }

    public void setDateState(String dateState) {
        this.dateState = dateState;
    }

    public ValidatableResponse grantLicence() {
        createOverview(applicationNumber);
        getOutstandingFees(applicationNumber);
        payOutstandingFees(organisationId, applicationNumber);
        grant(applicationNumber);
        return apiResponse;
    }

    public void createOverview(String volApplicationNumber) {
        this.applicationNumber = applicationNumber == null ? volApplicationNumber : applicationNumber;

        String overviewResource = URL.build(env, String.format("application/%s/overview/", applicationNumber)).toString();
        apiHeaders.headers.put("x-pid", Headers.getAPI_HEADER());
        String status = "1";
        String overrideOption = "Y";
        String transportArea = "D";
        String trackingId = fetchApplicationInformation(applicationNumber, "applicationTracking.id", null);
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));
        int applicationTrackingVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "applicationTracking.version", "1"));

        TrackingBuilder tracking = new TrackingBuilder().withId(trackingId).withVersion(applicationTrackingVersion).withAddressesStatus(status).withBusinessDetailsStatus(status).withBusinessTypeStatus(status)
                .withCommunityLicencesStatus(status).withConditionsUndertakingsStatus(status).withConvictionsPenaltiesStatus(status).withFinancialEvidenceStatus(status)
                .withFinancialHistoryStatus(status).withLicenceHistoryStatus(status).withOperatingCentresStatus(status).withPeopleStatus(status).withSafetyStatus(status)
                .withTransportManagersStatus(status).withTypeOfLicenceStatus(status).withDeclarationsInternalStatus(status).withVehiclesDeclarationsStatus(status).withVehiclesStatus(status).withVehiclesPsvStatus(status)
                .withTaxiPhvStatus(status);
        OverviewBuilder overview = new OverviewBuilder().withId(applicationNumber).withVersion(applicationVersion).withLeadTcArea(transportArea).withOverrideOppositionDate(overrideOption)
                .withTracking(tracking);
        apiResponse = RestUtils.put(overview, overviewResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void getOutstandingFees(String volApplicationNumber) {
        this.applicationNumber = applicationNumber == null ? volApplicationNumber : applicationNumber;

        String getOutstandingFeesResource = URL.build(env, String.format("application/%s/outstanding-fees/", applicationNumber)).toString();
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

    public void payOutstandingFees(String organisationNumber, String volApplicationNumber) {
        String payer = faker.generateFirstName() + faker.generateLastName();
        String paymentMethod = "fpm_cash";
        String slipNo = "123456";

        this.organisationId = organisationId == null ? organisationNumber : organisationId;
        this.applicationNumber = applicationNumber == null ? volApplicationNumber : applicationNumber;

        String payOutstandingFeesResource = URL.build(env, "transaction/pay-outstanding-fees/").toString();
        FeesBuilder feesBuilder = new FeesBuilder().withFeeIds(outstandingFeesIds).withOrganisationId(organisationId).withApplicationId(applicationNumber)
                .withPaymentMethod(paymentMethod).withReceived(feesToPay.stream().mapToDouble(Double::doubleValue).sum()).withReceiptDate(getDateState().toString()).withPayer(payer).withSlipNo(slipNo);
        apiResponse = RestUtils.post(feesBuilder, payOutstandingFeesResource, apiHeaders.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void grant(String volApplicationNumber) {
        this.applicationNumber = applicationNumber == null ? volApplicationNumber : applicationNumber;

        String grantApplicationResource = URL.build(env, String.format("application/%s/grant/", applicationNumber)).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(applicationNumber).withDuePeriod("9")
                .withAuthority("grant_authority_dl").withCaseworkerNotes("This notes are from the API");
        apiResponse = RestUtils.put(grantApplication, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        } else if (apiResponse.extract().response().asString().contains("fee")) {
            feeId = apiResponse.extract().response().jsonPath().getInt("id.fee");
            try {
                String apiMessages = apiResponse.extract().jsonPath().get("messages").toString();
                Assert.assertTrue(apiMessages.contains("Application status updated"));
                Assert.assertTrue(apiMessages.contains("Licence status updated"));
            } catch (AssertionError e) {
                throw new AssertionError("Licence failed to grant through the API.");
            }
        }
    }

    public ValidatableResponse payGrantFees() {
        String payer = faker.generateFirstName() + faker.generateLastName();
        Double grantFees = 401.00;
        String paymentMethod = "fpm_cash";
        String slipNo = "123456";

        String payOutstandingFeesResource = URL.build(env, "transaction/pay-outstanding-fees/").toString();

        FeesBuilder feesBuilder = new FeesBuilder().withFeeIds(Collections.singletonList(feeId)).withOrganisationId(organisationId).withApplicationId(applicationNumber)
                .withPaymentMethod(paymentMethod).withReceived(grantFees).withReceiptDate(getDateState().toString()).withPayer(payer).withSlipNo(slipNo);
        apiResponse = RestUtils.post(feesBuilder, payOutstandingFeesResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    private void variationGrant(String volApplicationNumber) {
        this.applicationNumber = applicationNumber == null ? volApplicationNumber : applicationNumber;

        String grantApplicationResource = URL.build(env, String.format("variation/%s/grant/", applicationNumber)).toString();
        GenericBuilder grantVariationBuilder = new GenericBuilder().withId(applicationNumber);
        apiResponse = RestUtils.put(grantVariationBuilder, grantApplicationResource, apiHeaders.getHeaders());
        apiResponse = RestUtils.put(grantVariationBuilder, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void refuse(String volApplicationNumber) {
        this.applicationNumber = applicationNumber == null ? volApplicationNumber : applicationNumber;

        String grantApplicationResource = URL.build(env, String.format("application/%s/refuse/", applicationNumber)).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(applicationNumber).withCaseworkerNotes("This notes are from the API");
        apiResponse = RestUtils.put(grantApplication, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        } else if (apiResponse.extract().response().asString().contains("fee")) {
            feeId = apiResponse.extract().response().jsonPath().getInt("id.fee");
        }
    }

    public void withdraw(String volApplicationNumber) {
        this.applicationNumber = applicationNumber == null ? volApplicationNumber : applicationNumber;

        String grantApplicationResource = URL.build(env, String.format("application/%s/withdraw/", applicationNumber)).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(applicationNumber).withReason("reg_in_error");
        apiResponse = RestUtils.put(grantApplication, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        } else if (apiResponse.extract().response().asString().contains("fee")) {
            feeId = apiResponse.extract().response().jsonPath().getInt("id.fee");
        }
    }
}