package apiCalls.actions;

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



    private List<Double> feesToPay = new ArrayList<>();
    private String dateState;

    private void setFeeId(int feeId){
        this.feeId = feeId;
    }

    public String getDateState() {
        return dateState;
    }

    public void setDateState(String dateState) {
        this.dateState = dateState;
    }

    public ValidatableResponse grantLicence(String applicationId, String organisationId) {
        createOverview(applicationId);
        getOutstandingFees(applicationId);
        payOutstandingFees(organisationId, applicationId);
        grant(applicationId);
        return apiResponse;
    }

    public void createOverview(String volApplicationId) {

        String overviewResource = URL.build(env, String.format("application/%s/overview/", volApplicationId)).toString();
        apiHeaders.headers.put("x-pid", Headers.getAPI_HEADER());
        String status = "1";
        String overrideOption = "Y";
        String transportArea = "D";
        String trackingId = fetchApplicationInformation(volApplicationId, "applicationTracking.id", null);
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(volApplicationId, "version", "1"));
        int applicationTrackingVersion = Integer.parseInt(fetchApplicationInformation(volApplicationId, "applicationTracking.version", "1"));

        TrackingBuilder tracking = new TrackingBuilder().withId(trackingId).withVersion(applicationTrackingVersion).withAddressesStatus(status).withBusinessDetailsStatus(status).withBusinessTypeStatus(status)
                .withCommunityLicencesStatus(status).withConditionsUndertakingsStatus(status).withConvictionsPenaltiesStatus(status).withFinancialEvidenceStatus(status)
                .withFinancialHistoryStatus(status).withLicenceHistoryStatus(status).withOperatingCentresStatus(status).withPeopleStatus(status).withSafetyStatus(status)
                .withTransportManagersStatus(status).withTypeOfLicenceStatus(status).withDeclarationsInternalStatus(status).withVehiclesDeclarationsStatus(status).withVehiclesStatus(status).withVehiclesPsvStatus(status)
                .withTaxiPhvStatus(status);
        OverviewBuilder overview = new OverviewBuilder().withId(volApplicationId).withVersion(applicationVersion).withLeadTcArea(transportArea).withOverrideOppositionDate(overrideOption)
                .withTracking(tracking);
        apiResponse = RestUtils.put(overview, overviewResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void getOutstandingFees(String volApplicationId) {

        String getOutstandingFeesResource = URL.build(env, String.format("application/%s/outstanding-fees/", volApplicationId)).toString();
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

    public void payOutstandingFees(String volOrganisationId, String volApplicationId) {
        String payer = faker.generateFirstName() + faker.generateLastName();
        String paymentMethod = "fpm_cash";
        String slipNo = "123456";

        String payOutstandingFeesResource = URL.build(env, "transaction/pay-outstanding-fees/").toString();
        FeesBuilder feesBuilder = new FeesBuilder().withFeeIds(outstandingFeesIds).withOrganisationId(volOrganisationId).withApplicationId(volApplicationId)
                .withPaymentMethod(paymentMethod).withReceived(feesToPay.stream().mapToDouble(Double::doubleValue).sum()).withReceiptDate(getDateState()).withPayer(payer).withSlipNo(slipNo);
        apiResponse = RestUtils.post(feesBuilder, payOutstandingFeesResource, apiHeaders.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void grant(String volApplicationId) {
        String grantApplicationResource = URL.build(env, String.format("application/%s/grant/", volApplicationId)).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(volApplicationId).withDuePeriod("9")
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

    public ValidatableResponse payGrantFees(String volApplicationId, String volOrganisationId) {
        String payer = faker.generateFirstName() + faker.generateLastName();
        Double grantFees = 401.00;
        String paymentMethod = "fpm_cash";
        String slipNo = "123456";

        String payOutstandingFeesResource = URL.build(env, "transaction/pay-outstanding-fees/").toString();

        FeesBuilder feesBuilder = new FeesBuilder().withFeeIds(Collections.singletonList(feeId)).withOrganisationId(volOrganisationId).withApplicationId(volApplicationId)
                .withPaymentMethod(paymentMethod).withReceived(grantFees).withReceiptDate(getDateState()).withPayer(payer).withSlipNo(slipNo);
        apiResponse = RestUtils.post(feesBuilder, payOutstandingFeesResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    private void variationGrant(String volApplicationId) {
        String grantApplicationResource = URL.build(env, String.format("variation/%s/grant/", volApplicationId)).toString();
        GenericBuilder grantVariationBuilder = new GenericBuilder().withId(volApplicationId);
        apiResponse = RestUtils.put(grantVariationBuilder, grantApplicationResource, apiHeaders.getHeaders());
        apiResponse = RestUtils.put(grantVariationBuilder, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void refuse(String volApplicationId) {
        String grantApplicationResource = URL.build(env, String.format("application/%s/refuse/", volApplicationId)).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(volApplicationId).withCaseworkerNotes("This notes are from the API");
        apiResponse = RestUtils.put(grantApplication, grantApplicationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info(apiResponse.extract().statusCode());
            LOGGER.info(apiResponse.extract().response().asString());
            throw new HTTPException(apiResponse.extract().statusCode());
        } else if (apiResponse.extract().response().asString().contains("fee")) {
            feeId = apiResponse.extract().response().jsonPath().getInt("id.fee");
        }
    }

    public void withdraw(String volApplicationId) {
        String grantApplicationResource = URL.build(env, String.format("application/%s/withdraw/", volApplicationId)).toString();
        GrantApplicationBuilder grantApplication = new GrantApplicationBuilder().withId(volApplicationId).withReason("reg_in_error");
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