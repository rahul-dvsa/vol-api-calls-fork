package apiCalls.actions;


import activesupport.MissingRequiredArgument;
import activesupport.dates.Dates;
import activesupport.dates.LocalDateCalendar;
import activesupport.faker.FakerUtils;
import activesupport.http.RestUtils;
import activesupport.number.Int;
import apiCalls.Utils.builders.*;
import apiCalls.Utils.generic.*;
import apiCalls.enums.LicenceType;
import apiCalls.enums.OperatorType;
import apiCalls.enums.UserRoles;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.exceptions.MalformedURLException;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import activesupport.system.Properties;
import org.hamcrest.Matchers;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UpdateLicence extends BaseAPI {
    private final CreateApplication application;
    private ValidatableResponse apiResponse;
    private Dates date = new Dates(new LocalDateCalendar());
    private FakerUtils faker = new FakerUtils();
    private String variationType;





    private String goodOrPsv;
    private String trafficAreaName;
    public String adminUserForeName;
    public String adminUserFamilyName;
    public String adminUserEmailAddress;
    public String adminUserLogin;
    private String adminUserId;
    private String licenceStatus;
    private String businessType;
    private String licenceType;
    private String startNumber;
    private String endNumber;
    private String queueId;
    private String caseType;
    private String caseDescription;


    private String defendantType;
    private String defendantFirstname;
    private String defendantLastname;
    private String defendantBirthDate;
    private String offenceDate;
    private String convictionDate;
    private String convictionCategory;
    private String categoryText;
    private String court;
    private String penalty;
    private String costs;
    private String convictionNotes;


    private List<String> caseCategories = new ArrayList<>();;
    private List<String> caseOutcomes = new ArrayList<>();;

    private int caseNoteId;
    private int complaintId;
    private int convictionId;
    private int conditionUndertaking;
    private int submissionsId;
    private int caseId;




    private String driverForename = faker.generateFirstName();
    private String driverFamilyName = faker.generateLastName();

    private static String variationApplicationNumber;
    private static int version = 1;

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    private void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public String getVariationApplicationNumber() {
        return variationApplicationNumber;
    }

    public void setVariationApplicationNumber(String variationApplicationNumber) {
        UpdateLicence.variationApplicationNumber = variationApplicationNumber;
    }

    public String getVariationType() {
        return variationType;
    }

    public void setVariationType(String variationType) {
        this.variationType = variationType;
    }

    private void setAdminUserId(String adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getAdminUserId() {
        return this.adminUserId;
    }

    public String getAdminUserForeName() {
        return adminUserForeName;
    }

    public void setAdminUserForeName(String adminUserForeName) {
        this.adminUserForeName = adminUserForeName;
    }

    public String getAdminUserFamilyName() {
        return adminUserFamilyName;
    }

    public void setAdminUserFamilyName(String adminUserFamilyName) {
        this.adminUserFamilyName = adminUserFamilyName;
    }

    public String getTrafficAreaName() {
        return trafficAreaName;
    }

    private void setTrafficAreaName(String trafficAreaName) {
        this.trafficAreaName = trafficAreaName;
    }

    public int getCaseId() {
        return caseId;
    }

    private void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getComplaintId() {
        return complaintId;
    }

    private void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getConvictionId() {
        return convictionId;
    }

    private void setConvictionId(int convictionId) {
        this.convictionId = convictionId;
    }

    public int getConditionUndertaking() {
        return conditionUndertaking;
    }

    private void setConditionUndertaking(int conditionUndertaking) {
        this.conditionUndertaking = conditionUndertaking;
    }

    public int getSubmissionsId() {
        return submissionsId;
    }

    private void setSubmissionsId(int submissionsId) {
        this.submissionsId = submissionsId;
    }

    public int getCaseNoteId() {
        return caseNoteId;
    }

    private void setCaseNoteId(int caseNoteId) {
        this.caseNoteId = caseNoteId;
    }

    private void setLicenceStatus(String licenceStatus) {
        this.licenceStatus = licenceStatus;
    }

    public String getGoodOrPsv() { return goodOrPsv; }

    public String getAdminUserEmailAddress() { return adminUserEmailAddress; }

    public void setAdminUserEmailAddress(String adminUserEmailAddress) { this.adminUserEmailAddress = adminUserEmailAddress; }

    public String getAdminUserLogin() {
        return adminUserLogin;
    }

    public void setAdminUserLogin(String adminUserLogin) {
        this.adminUserLogin = adminUserLogin;
    }

    private void setGoodOrPsv(String goodOrPsv) {
        this.goodOrPsv = goodOrPsv;
    }

    public String getStartNumber() {
        return startNumber;
    }

    private void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    public String getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(String endNumber) {
        this.endNumber = endNumber;
    }

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public String getDriverForename() { return driverForename; }

    public void setDriverForename(String driverForename) { this.driverForename = driverForename; }

    public String getDriverFamilyName() { return driverFamilyName; }

    public void setDriverFamilyName(String driverFamilyName) { this.driverFamilyName = driverFamilyName; }

    public String getDefendantType() {
        return defendantType;
    }

    public void setDefendantType(String defendantType) {
        this.defendantType = defendantType;
    }

    public String getDefendantFirstname() {
        return defendantFirstname;
    }

    public void setDefendantFirstname(String defendantFirstname) {
        this.defendantFirstname = defendantFirstname;
    }

    public String getDefendantLastname() {
        return defendantLastname;
    }

    public void setDefendantLastname(String defendantLastname) {
        this.defendantLastname = defendantLastname;
    }

    public String getDefendantBirthDate() {
        return defendantBirthDate;
    }

    public void setDefendantBirthDate(String defendantBirthDate) {
        this.defendantBirthDate = defendantBirthDate;
    }

    public String getOffenceDate() {
        return offenceDate;
    }

    public void setOffenceDate(String offenceDate) {
        this.offenceDate = offenceDate;
    }

    public String getConvictionDate() {
        return convictionDate;
    }

    public void setConvictionDate(String convictionDate) {
        this.convictionDate = convictionDate;
    }

    public String getConvictionCategory() {
        return convictionCategory;
    }

    public void setConvictionCategory(String convictionCategory) {
        this.convictionCategory = convictionCategory;
    }

    public String getConvictionNotes() {
        return convictionNotes;
    }

    public void setConvictionNotes(String convictionNotes) {
        convictionNotes = convictionNotes;
    }

    public String getCategoryText() {
        return categoryText;
    }

    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs;
    }

    private static EnvironmentType env;
    private static final Logger LOGGER = LogManager.getLogger(UpdateLicence.class);

    private Headers apiHeaders = new Headers();

    static {
        try {
            env = EnvironmentType.getEnum(Properties.get("env", false));
        } catch (MissingRequiredArgument missingRequiredArgument) {
            missingRequiredArgument.printStackTrace();
        }
    }

    public UpdateLicence(CreateApplication application) {
        this.application = application;
        setAdminUserForeName( faker.generateFirstName() );
        setAdminUserFamilyName( faker.generateLastName() );
        setAdminUserLogin( String.format("%s%s%s", getAdminUserForeName(), getAdminUserFamilyName(), Int.random(10000, 99999)) );
        setAdminUserEmailAddress( getAdminUserLogin().concat("AsTheAdminUser@dvsavol.org") );
        setVariationType(null);

        // Case Details
        setCaseType("case_t_lic");
        setCaseDescription("Sent through the API");
        caseCategories.add("case_cat_compl_conv");
        caseCategories.add("case_cat_compl_proh");
        caseOutcomes.add("case_o_other");
        caseOutcomes.add("case_o_cur");

        // Conviction Details
        setDefendantType("def_t_dir");
        setDefendantFirstname(faker.generateFirstName());
        setDefendantLastname(faker.generateLastName());
        setDefendantBirthDate("99-6-10");
        setOffenceDate("18-4-1");
        setConvictionDate("18-6-10");
        setConvictionCategory("conv_c_cat_1065");
        setCategoryText("Driver correcting entry in driver's record book in wrong fashion");
        setCourt("CourtAPI");
        setPenalty("Heavy");
        setCosts("1000");
        setConvictionNotes("This has been submitted");

    }

    public void createVariation() {
        String licenceHistoryResource = URL.build(env, String.format("licence/%s/variation", application.getLicenceId())).toString();

        VariationBuilder variation = new VariationBuilder().withId(application.getLicenceId()).withFeeRequired("N").withAppliedVia("applied_via_phone").withVariationType(getVariationType());
        apiResponse = RestUtils.post(variation, licenceHistoryResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);

        setVariationApplicationNumber(String.valueOf(apiResponse.extract().jsonPath().getInt("id.application")));
    }

    public void updateLicenceType() {
        String typeOfLicenceResource = URL.build(env, String.format("variation/%s/type-of-licence", application.getLicenceId())).toString();
        Integer variationApplicationVersion = Integer.parseInt(fetchApplicationInformation(variationApplicationNumber, "version", "1"));

        GenericBuilder genericBuilder = new GenericBuilder().withId(variationApplicationNumber).withVersion(variationApplicationVersion).withLicenceType(application.getLicenceType());
        apiResponse = RestUtils.put(genericBuilder, typeOfLicenceResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
    }

    public void createCase() throws MalformedURLException {
        String caseResource = URL.build(env, "cases").toString();

        CaseBuilder caseBuilder = new CaseBuilder().withId(application.getLicenceId()).withCaseType(caseType).
                withCategorys(caseCategories).withDescription(getCaseDescription()).withOutcomes(caseOutcomes).withApplication(application.getApplicationId());
        apiResponse = RestUtils.post(caseBuilder, caseResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);

        setCaseId(apiResponse.extract().body().jsonPath().get("id.case"));
    }

    public void addConviction() throws MalformedURLException {

        String convictionResource = URL.build(env, "conviction").toString();

        CaseConvictionBuilder caseConvictionBuilder = new CaseConvictionBuilder().withCase(getCaseId()).withConvictionCategory(getConvictionCategory()).withConvictionDate(getConvictionDate()).withBirthDate(getDefendantBirthDate()).withCategoryText(getCategoryText()).withCosts(getCosts())
                .withCourt(getCourt()).withMsi("Y").withPenalty(getPenalty()).withNotes(getConvictionNotes()).withTakenIntoConsideration("Y").withIsDeclared("Y").withIsDealtWith("Y").withDefendantType(getDefendantType())
                .withPersonFirstname(getDefendantFirstname()).withPersonLastname(getDefendantLastname()).withOffenceDate(getOffenceDate());
        apiResponse = RestUtils.post(caseConvictionBuilder, convictionResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);

        setConvictionId(apiResponse.extract().jsonPath().getInt("id.conviction"));
    }

    public void addComplaint() {
        String complainantForename = faker.generateFirstName();
        String complainantFamilyName = faker.generateLastName();
        String complaintType = "ct_cov";
        String status = "cs_yst";
        String isCompliance = "true";
        String complaintDate = "18-4-1";
        String infringementDate = "17-4-1";
        String description = "Driver correcting entry in driver's record book in wrong fashion";

        String complaintResource = URL.build(env, "complaint").toString();
        CaseComplaintBuilder complaintBuilder = new CaseComplaintBuilder().withCase(caseId).withComplainantForename(complainantForename).withComplainantFamilyName(complainantFamilyName).withComplaintType(complaintType).withStatus(status).withIsCompliance(isCompliance)
                .withComplaintDate(complaintDate).withInfringementDate(infringementDate).withDescription(description).withDriverForename(getDriverForename()).withDriverFamilyName(getDriverFamilyName());
        apiResponse = RestUtils.post(complaintBuilder, complaintResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);

        setComplaintId(apiResponse.extract().jsonPath().getInt("id.complaint"));
    }

    public void addConditionsUndertakings() throws MalformedURLException {
        String type = "cdt_con";
        String conditionCategory = "cu_cat_fin";
        String fulfilled = "N";
        String attachedTo = "cat_lic";
        String description = "This undertaken has not been fulfilled";
        String conditionsUndertaking = URL.build(env, "condition-undertaking").toString();
        CaseConditionsBuilder conditionsBuilder = new CaseConditionsBuilder().withLicence(application.getLicenceId()).withApplication(application.getApplicationId()).withCase(Integer.toString(caseId)).withType(type).withConditionCategory(conditionCategory)
                .withFulfilled(fulfilled).withAttachedTo(attachedTo).withNotes(description);
        apiResponse = RestUtils.post(conditionsBuilder, conditionsUndertaking, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);

        setConditionUndertaking(apiResponse.extract().jsonPath().getInt("id.conditionUndertaking"));
    }

    public void createSubmission() throws MalformedURLException {
        String submissionType = "submission_type_o_env";
        String submissionResource = URL.build(env, "submission").toString();
        CaseSubmissionBuilder submissionBuilder = new CaseSubmissionBuilder().withCase(Integer.toString(caseId)).withSubmissionType(submissionType);
        apiResponse = RestUtils.post(submissionBuilder, submissionResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);

        setSubmissionsId(apiResponse.extract().jsonPath().getInt("id.submission"));
    }

    public void createCaseNote() throws MalformedURLException {
        String comment = "case note submitted through the API";
        String priority = "Y";
        String caseNoteResource = URL.build(env, "processing/note").toString();
        CaseNotesBuilder caseNotesBuilder = new CaseNotesBuilder().withCase(Integer.toString(caseId)).withLicence(application.getLicenceId()).withApplication(application.getApplicationId())
                .withComment(comment).withPriority(priority);
        apiResponse = RestUtils.post(caseNotesBuilder, caseNoteResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);

        setCaseNoteId(apiResponse.extract().jsonPath().getInt("id.note"));
    }

    public ValidatableResponse getCaseDetails(String resource, int id) {
        String caseResource = URL.build(env, String.format("%s/%s", resource, id)).toString();
        apiResponse = RestUtils.get(caseResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }

    public ValidatableResponse variationUpdateOperatingCentre() {
        if (application.getLicenceType().equals("special_restricted")) {
            throw new IllegalArgumentException("Cannot update operating centre for special_restricted licence");
        }
        String noOfVehiclesRequired = "5";
        String licenceId = application.getLicenceId();
        String updateOperatingCentreResource = URL.build(env, String.format("application/%s/variation-operating-centre/%s", licenceId, variationApplicationNumber)).toString();
        OperatingCentreVariationBuilder updateOperatingCentre = new OperatingCentreVariationBuilder();

        if (application.getOperatorType().equals(OperatorType.GOODS.asString())) {
            updateOperatingCentre.withId(variationApplicationNumber).withApplication(variationApplicationNumber)
                    .withNoOfVehiclesRequired(noOfVehiclesRequired).withVersion(version);
        }
        if (application.getOperatorType().equals(OperatorType.PUBLIC.asString())) {
            updateOperatingCentre.withId(variationApplicationNumber).withApplication(variationApplicationNumber)
                    .withNoOfVehiclesRequired(noOfVehiclesRequired).withVersion(version);
        }
        if (application.getOperatorType().equals(OperatorType.PUBLIC.asString()) && (application.getLicenceType().equals(LicenceType.RESTRICTED.asString()))) {
            updateOperatingCentre.withId(variationApplicationNumber).withApplication(variationApplicationNumber)
                    .withNoOfVehiclesRequired(noOfVehiclesRequired).withVersion(version);
        }
        apiResponse = RestUtils.put(updateOperatingCentre, updateOperatingCentreResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }

    public ValidatableResponse updateInternalUserODetails(String userId, String osType, String header) {
        String team = "1";
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());

        String version = fetchInternalUserInformation(userId, "version", "1");

        String internalAdminUserResource = URL.build(env, String.format("user/internal/%s", userId)).toString();

        AddressBuilder addressBuilder = new AddressBuilder().withAddressLine1("AXIS Building").withTown("Nottingham").withPostcode("LS28 5LY").withCountryCode("GB");
        HashMap<String, Integer> internalUserDOB = date.getDateHashMap(0, 0, -30);
        PersonBuilder personBuilder = new PersonBuilder().withForename("Long").withFamilyName("Ash").withBirthDate(internalUserDOB.get("year") + "-" + internalUserDOB.get("month") + "-" + internalUserDOB.get("day"));

        ContactDetailsBuilder contactDetails = new ContactDetailsBuilder().withEmailAddress(adminUserEmailAddress).withAddress(addressBuilder).withPerson(personBuilder);
        CreateInternalAdminUser internalAdminUser = new CreateInternalAdminUser().withContactDetails(contactDetails).withLoginId(adminUserLogin).withTeam(team)
                .withUserType(UserRoles.INTERNAL.asString()).withVersion(version).withOSType(osType).withId(userId);
        apiResponse = RestUtils.put(internalAdminUser, internalAdminUserResource, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }

    public String createInternalUser(String userRole, String userType) {
        List<String> roles = new ArrayList<>();
        roles.add(userRole);
        String team = "1";
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String internalAdminUserResource = URL.build(env, "user/internal").toString();

        AddressBuilder addressBuilder = new AddressBuilder().withAddressLine1("AXIS Building").withTown("Nottingham").withPostcode("LS28 5LY").withCountryCode("GB");
        HashMap<String, Integer> internalUserDOB = date.getDateHashMap(0, 0, -30);
        PersonBuilder personBuilder = new PersonBuilder().withForename(faker.generateFirstName()).withFamilyName(faker.generateLastName()).withBirthDate((internalUserDOB.get("year") + "-" + internalUserDOB.get("month") + "-" + internalUserDOB.get("day")));

        ContactDetailsBuilder contactDetails = new ContactDetailsBuilder().withEmailAddress(adminUserEmailAddress).withAddress(addressBuilder).withPerson(personBuilder);
        CreateInternalAdminUser internalAdminUser = new CreateInternalAdminUser().withContactDetails(contactDetails).withLoginId(adminUserLogin).withRoles(roles).withTeam(team).withUserType(userType);
        apiResponse = RestUtils.post(internalAdminUser, internalAdminUserResource, application.apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);
        setAdminUserId(apiResponse.extract().response().jsonPath().getString("id.user"));
        return getAdminUserId();
    }

    public ValidatableResponse grantVariation(String resource) throws MalformedURLException {
        String grantVariation = URL.build(env, String.format("variation/%s/%s", variationApplicationNumber, resource)).toString();

        GenericBuilder genericBuilder = new GenericBuilder().withId(variationApplicationNumber);
        apiResponse = RestUtils.put(genericBuilder, grantVariation, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        return apiResponse;
    }

    public String getLicenceTrafficArea() {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String getApplicationResource = URL.build(env, String.format("licence/%s", application.getLicenceId())).toString();

        apiResponse = RestUtils.get(getApplicationResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        setTrafficAreaName(apiResponse.extract().jsonPath().getString("trafficArea.name"));
        return trafficAreaName;
    }

    public String getLicenceStatusDetails() {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String getApplicationResource = URL.build(env, String.format("licence/%s", application.getLicenceId())).toString();

        apiResponse = RestUtils.get(getApplicationResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        setLicenceStatus(apiResponse.extract().jsonPath().getString("status.description"));
        return licenceStatus;
    }

    public String getOperatorTypeDetails() {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String getApplicationResource = URL.build(env, String.format("licence/%s", application.getLicenceId())).toString();

        apiResponse = RestUtils.get(getApplicationResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        setGoodOrPsv(apiResponse.extract().jsonPath().getString("goodsOrPsv.description"));
        return goodOrPsv;
    }

    public String getBusinessTypeDetails() {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String getApplicationResource = URL.build(env, String.format("licence/%s", application.getLicenceId())).toString();

        apiResponse = RestUtils.get(getApplicationResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        setBusinessType(apiResponse.extract().jsonPath().getString("organisation.type.description"));

        return businessType;

    }

    public String getLicenceTypeDetails() {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String getApplicationResource = URL.build(env, String.format("licence/%s", application.getLicenceId())).toString();

        apiResponse = RestUtils.get(getApplicationResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        setLicenceType(apiResponse.extract().jsonPath().getString("licenceType.description"));
        return licenceType;
    }

    public void updateLicenceStatus(String licenceId, String status) {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String typeOfLicenceResource = URL.build(env, String.format("licence/%s/decisions/%s", licenceId, status)).toString();

        GenericBuilder genericBuilder = new GenericBuilder().withId(licenceId);
        apiResponse = RestUtils.post(genericBuilder, typeOfLicenceResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);
    }

    public ValidatableResponse surrenderLicence(String licenceId, String userPid) {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String surrenderLicence = URL.build(env, String.format("licence/%s/surrender", licenceId)).toString();

        SurrendersBuilder surrendersBuilder = new SurrendersBuilder().withLicence(licenceId);
        apiResponse = RestUtils.post(surrendersBuilder, surrenderLicence, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);
        return apiResponse;
    }

    public ValidatableResponse updateSurrender(String licenceId, String userPid, Integer surrenderId) {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String updateSurrender = URL.build(env, String.format("licence/%s/surrender", licenceId)).toString();

        SurrendersBuilder surrendersBuilder = new SurrendersBuilder().withLicence(licenceId);
        surrendersBuilder.setId(surrenderId.toString());
        surrendersBuilder.setDiscStolen("2");
        surrendersBuilder.setVersion(1);
        apiResponse = RestUtils.put(surrendersBuilder, updateSurrender, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        return apiResponse;
    }

    public ValidatableResponse deleteSurrender(String licenceId, String userPid, Integer surrenderId) {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String deleteSurrender = URL.build(env, String.format("licence/%s/surrender", licenceId)).toString();

        GenericBuilder genericBuilder = new GenericBuilder().withLicence(licenceId);
        genericBuilder.setId(surrenderId.toString());


        apiResponse = RestUtils.delete(genericBuilder, deleteSurrender, apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        return apiResponse;
    }

    public void enableDisableVerify(String toggle) {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String enableDisableVerifyResource = URL.build(env, "system-parameter/DISABLE_GDS_VERIFY_SIGNATURES/").toString();

        GenericBuilder genericBuilder = new GenericBuilder().withId("DISABLE_GDS_VERIFY_SIGNATURES").withParamValue(toggle).
                withDescription("Disable GDS verify digital signature functionality");

        apiResponse = RestUtils.put(genericBuilder, enableDisableVerifyResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
    }

    public void updateFeatureToggle(String id, String friendlyName, String configName, String status) {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String updateFeatureToggleResource = URL.build(env, String.format("feature-toggle/%s/", id)).toString();

        FeatureToggleBuilder featureToggleBuilder = new FeatureToggleBuilder().withId(id).withFriendlyName(friendlyName).withConfigName(configName)
                .withStatus(status);

        apiResponse = RestUtils.put(featureToggleBuilder, updateFeatureToggleResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        apiResponse.statusCode(HttpStatus.SC_OK);
    }

    private void getDiscInformation() {
        Map<String, String> queryParams = new HashMap<>();
        {
            queryParams.put("niFlag", "N");
            queryParams.put("licenceType", String.valueOf(application.getLicenceType()));
            queryParams.put("operatorType", String.valueOf(application.getOperatorType()));
            queryParams.put("discSequence", "6");
        }
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String discNumberingResource = URL.build(env, "disc-sequence/discs-numbering").toString();
        apiResponse = RestUtils.getWithQueryParams(discNumberingResource, queryParams, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
        setStartNumber(apiResponse.extract().jsonPath().get("results.startNumber").toString());
        setEndNumber(apiResponse.extract().jsonPath().get("results.endNumber").toString());
        // Seems to print regardless of start and end number. Need to refactor to get specific licence start and end number for psv disc test.
    }

    public void printLicenceDiscs() {
        String operator;
        getDiscInformation();
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        if (getOperatorTypeDetails().equals("Goods Vehicle")) {
            operator = "goods";
        } else {
            operator = "psv";
        }
        String discPrintResource = URL.build(env, String.format("%s-disc/print-discs/", operator)).toString();
        PrintDiscBuilder printDiscBuilder = new PrintDiscBuilder().withDiscSequence("6").withLicenceType(application.getLicenceType()).withNiFlag(application.getNiFlag())
                .withStartNumber(String.valueOf(getStartNumber()));
        apiResponse = RestUtils.post(printDiscBuilder, discPrintResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);
        assertThat(apiResponse.extract().body().jsonPath().get("id.queue"), Matchers.notNullValue());
        setQueueId(apiResponse.extract().jsonPath().get("id.queue").toString());
        confirmDiscPrint();
    }

    private void confirmDiscPrint() {
        String operator;
        if (getOperatorTypeDetails().equals("Goods Vehicle")) {
            operator = "goods";
        } else {
            operator = "psv";
        }
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String discConfirmResource = URL.build(env, String.format("%s-disc/confirm-printing/", operator)).toString();
        ConfirmPrintBuilder confirmPrintBuilder = new ConfirmPrintBuilder().withDiscSequence("6").withEndNumber(getEndNumber()).withStartNumber(getStartNumber()).withIsSuccessfull(true)
                .withLicenceType(String.valueOf(application.getLicenceType())).withNiFlag(application.getNiFlag()).withQueueId(getQueueId());
        apiResponse = RestUtils.post(confirmPrintBuilder, discConfirmResource, application.apiHeaders.getHeaders());
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);
    }

    public void submitInterimApplication() {
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String interimApplicationResource = URL.build(env, String.format("application/%s/interim/", application.getApplicationId())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(application.getApplicationId(), "version", "1"));

        InterimApplicationBuilder interimApplicationBuilder = new InterimApplicationBuilder().withAuthVehicles(String.valueOf(application.getNoOfVehiclesRequested())).withAuthTrailers(String.valueOf(application.getNoOfVehiclesRequested()))
                .withRequested("Y").withReason("Interim granted through the API").withStartDate(date.getFormattedDate(0, 0, 0, "yyyy-MM-dd")).withEndDate(date.getFormattedDate(0, 5, 0, "yyyy-MM-dd"))
                .withAction("grant").withId(application.getApplicationId()).withVersion(applicationVersion);
        apiResponse = RestUtils.put(interimApplicationBuilder, interimApplicationResource, application.apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);
    }

    public void grantInterimApplication() {
        submitInterimApplication();
        apiHeaders.headers.put("x-pid", application.getUserDetails().getPid());
        String interimApplicationResource = URL.build(env, String.format("application/%s/interim/grant/", application.getApplicationId())).toString();

        InterimApplicationBuilder interimApplicationBuilder = new InterimApplicationBuilder().withId(application.getApplicationId());
        apiResponse = RestUtils.post(interimApplicationBuilder, interimApplicationResource, application.apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_CREATED);
    }

}
