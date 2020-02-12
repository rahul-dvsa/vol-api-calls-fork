package Utils.actions;

import Utils.Builders.*;
import Utils.generic.BaseAPI;
import Utils.generic.Headers;
import activesupport.http.RestUtils;
import activesupport.number.Int;
import activesupport.string.Str;
import activesupport.system.Properties;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

import javax.xml.ws.http.HTTPException;

public class CreateApplication {

    private static int version = 1;

    private String title;
    private String foreName;
    private String familyName;
    private String birthDate;
    private String addressLine1;
    private String town;
    private String postcode;
    private String countryCode;
    private String organisationName;
    private String emailAddress;
    private String transManEmailAddress;
    private String applicationNumber;
    private String userId;
    private String tmUserName;
    private String username;
    private String loginId;
    private String pid;
    private String organisationId;
    private String licenceNumber;
    private String transportManagerApplicationId;
    private String companyNumber = String.valueOf(Int.random(00000000, 99999999));
    private String licenceType;
    private String businessType;
    private String operatorType;
    private String niFlag = System.getProperty("ni");
    private String trafficArea;
    private String enforcementArea;
    private String restrictedVehicles;
    private String applicationStatus;
    private String licenceId;
    private String businessName;
    private String isInterim;
    private String isOwner;
    private String tmType = "tm_t_i";
    private String hours = "2.0";
    private String phoneNumber;
    private String businessEmailAddress;

    private int noOfVehiclesRequired = 5;

    private static final Logger LOGGER = LogManager.getLogger(RegisterUser.class);

    private EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    private ValidatableResponse apiResponse;

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getNiFlag() {
        return niFlag;
    }

    public void setNiFlag(String niFlag) {
        this.niFlag = niFlag;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    private Headers apiHeaders = new Headers();
    private BaseAPI baseAPI = new BaseAPI();

    public void startApplication() {
        String createApplicationResource = URL.build(env, "application").toString();
        apiHeaders.headers.put("x-pid", pid);

        ApplicationBuilder applicationBuilder = new ApplicationBuilder().withOperatorType(getOperatorType())
                .withLicenceType(getLicenceType()).withNiFlag(getNiFlag()).withOrganisation(getOrganisationId());
        apiResponse = RestUtils.post(applicationBuilder, createApplicationResource, apiHeaders.getHeaders());
        applicationNumber = apiResponse.extract().jsonPath().getString("id.application");
        licenceNumber = apiResponse.extract().jsonPath().getString("id.licence");
        setApplicationNumber(applicationNumber);

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addBusinessType() {
        String organisationVersion = baseAPI.fetchApplicationInformation(applicationNumber, "licence.organisation.version", "1");
        String updateBusinessTypeResource = URL.build(env, String.format("organisation/%s/business-type/", getOrganisationId())).toString();

        BusinessTypeBuilder businessTypeBuilder = new BusinessTypeBuilder().withBusinessType(getBusinessType()).withVersion(organisationVersion)
                .withId(getOrganisationId()).withApplication(getApplicationNumber());
        apiResponse = RestUtils.put(businessTypeBuilder, updateBusinessTypeResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addBusinessDetails() {
        String organisationVersion = baseAPI.fetchApplicationInformation(applicationNumber, "licence.organisation.version", "1");
        String natureOfBusiness = "apiTesting";
        String updateBusinessDetailsResource = URL.build(env, String.format("organisation/business-details/application/%s", getApplicationNumber())).toString();

        AddressBuilder address = new AddressBuilder().withAddressLine1(getAddressLine1()).withTown(getTown()).withPostcode(getPostCode());
        UpdateBusinessDetailsBuilder businessDetails = new UpdateBusinessDetailsBuilder()
                .withId(getApplicationNumber()).withCompanyNumber(companyNumber).withNatureOfBusiness(natureOfBusiness).withLicence(getLicenceNumber())
                .withVersion(organisationVersion).withName(getBusinessName()).withAddress(address);
        apiResponse = RestUtils.put(businessDetails, updateBusinessDetailsResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addAddressDetails() {
        String applicationAddressResource = URL.build(env, String.format("application/%s/addresses/", applicationNumber)).toString();
        AddressBuilder address = new AddressBuilder().withAddressLine1(getAddressLine1()).withTown(getTown()).withPostcode(getPostCode()).withCountryCode(getCountryCode());
        ContactDetailsBuilder contactDetailsBuilder = new ContactDetailsBuilder().withPhoneNumber(getPhoneNumber()).withEmailAddress(getBusinessEmailAddress());
        ApplicationAddressBuilder addressBuilder = new ApplicationAddressBuilder().withId(applicationNumber).withConsultant("Consult").withContact(contactDetailsBuilder)
                .withCorrespondenceAddress(address).withEstablishmentAddress(address);
        apiResponse = RestUtils.put(addressBuilder, applicationAddressResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addPartners() {
        String addPersonResource = URL.build(env, String.format("application/%s/people/", applicationNumber)).toString();
        PersonBuilder addPerson = new PersonBuilder().withId(applicationNumber).withTitle(getTitle()).withForename(getForeName()).withFamilyName(getFamilyName()).withBirthDate(getBirthDate());
        apiResponse = RestUtils.post(addPerson, addPersonResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addOperatingCentre() {
        String operatingCentreResource = URL.build(env, String.format("application/%s/operating-centre/", applicationNumber)).toString();
        int buildingNumber = Int.random(0, 1000);
        String permissionOption = "Y";
        String operatingCentreAddress;
        operatingCentreAddress = String.valueOf(buildingNumber).concat(" API_Operating_Centre");
        OperatingCentreBuilder operatingCentreBuilder = new OperatingCentreBuilder();

        if (operatorType.equals("goods")) {
            AddressBuilder address = new AddressBuilder().withAddressLine1(operatingCentreAddress).withTown(getTown()).withPostcode(getPostCode()).withCountryCode(getCountryCode());
            operatingCentreBuilder.withApplication(getApplicationNumber()).withNoOfVehiclesRequired(String.valueOf(noOfVehiclesRequired))
                    .withNoOfTrailersRequired(String.valueOf(noOfVehiclesRequired)).withPermission(permissionOption).withAddress(address);
        }
        if (operatorType.equals("public") && (!licenceType.equals("special_restricted"))) {
            AddressBuilder address = new AddressBuilder().withAddressLine1(operatingCentreAddress).withTown(getTown()).withPostcode(getPostCode()).withCountryCode(getCountryCode());
            operatingCentreBuilder.withApplication(applicationNumber).withNoOfVehiclesRequired(String.valueOf(noOfVehiclesRequired)).withPermission(permissionOption).withAddress(address);
        }
        if (operatorType.equals("public") && (licenceType.equals("restricted"))) {
            AddressBuilder address = new AddressBuilder().withAddressLine1(operatingCentreAddress).withTown(town).withPostcode(getPostCode()).withCountryCode(getCountryCode());
            operatingCentreBuilder.withApplication(getApplicationNumber()).withNoOfVehiclesRequired(String.valueOf(restrictedVehicles)).withPermission(permissionOption).withAddress(address);
        }
        if (!licenceType.equals("special_restricted")) {
            apiResponse = RestUtils.post(operatingCentreBuilder, operatingCentreResource, apiHeaders.getHeaders());
        }

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void updateOperatingCentre() {
        if (licenceType.equals("special_restricted")) {
            return;
        }
        String updateOperatingCentreResource = URL.build(env, String.format("application/%s/operating-centres", applicationNumber)).toString();
        OperatingCentreUpdater updateOperatingCentre = new OperatingCentreUpdater();
        int applicationVersion = Integer.parseInt(baseAPI.fetchApplicationInformation(applicationNumber, "version", "1"));

        if (operatorType.equals("goods")) {
            updateOperatingCentre.withId(applicationNumber).withTotAuthVehicles(noOfVehiclesRequired)
                    .withTrafficArea(getTrafficArea()).withEnforcementArea(getEnforcementArea()).withTotCommunityLicences(1)
                    .withTAuthTrailers(Integer.parseInt(String.valueOf(noOfVehiclesRequired))).withVersion(applicationVersion);
        }
        if (operatorType.equals("public") && (!licenceType.equals("restricted"))) {
            updateOperatingCentre.withId(getApplicationNumber()).withTotAuthVehicles(noOfVehiclesRequired)
                    .withTrafficArea(getTrafficArea()).withEnforcementArea(getEnforcementArea()).withTotCommunityLicences(1).withVersion(applicationVersion);
        }

        if (operatorType.equals("public") && (licenceType.equals("restricted"))) {
            updateOperatingCentre.withId(getApplicationNumber()).withTotAuthVehicles(Integer.valueOf(String.valueOf(restrictedVehicles)))
                    .withTrafficArea(getTrafficArea()).withEnforcementArea(getEnforcementArea()).withVersion(applicationVersion);
        }

        apiResponse = RestUtils.put(updateOperatingCentre, updateOperatingCentreResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addFinancialEvidence() {
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            return;
        }

        String financialEvidenceResource = URL.build(env, String.format("application/%s/financial-evidence", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(baseAPI.fetchApplicationInformation(applicationNumber, "version", "1"));

        FinancialEvidenceBuilder financialEvidenceBuilder = new FinancialEvidenceBuilder().withId(applicationNumber).withVersion(applicationVersion).withFinancialEvidenceUploaded(0);
        apiResponse = RestUtils.put(financialEvidenceBuilder, financialEvidenceResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addTransportManager() {
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            return;
        }
        int randNumber = Int.random(0, 2000);
        tmUserName = "apiTM".concat(getLoginId()).concat(String.valueOf(randNumber));
        String hasEmail = "Y";
        String addTransportManager = URL.build(env, "transport-manager/create-new-user/").toString();
        TransportManagerBuilder transportManagerBuilder = new TransportManagerBuilder().withApplication(getApplicationNumber()).withFirstName(getForeName())
                .withFamilyName(getFamilyName()).withHasEmail(hasEmail).withUsername(getTmUserName()).withEmailAddress(getTransManEmailAddress()).withBirthDate(getBirthDate());
        apiResponse = RestUtils.post(transportManagerBuilder, addTransportManager, apiHeaders.getHeaders());
        setTransportManagerApplicationId(apiResponse.extract().jsonPath().getString("id.transportManagerApplicationId"));

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void submitTransport() {
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            return;
        }
        String submitTransportManager = URL.build(env, String.format("transport-manager-application/%s/submit", getApplicationNumber())).toString();
        GenericBuilder genericBuilder = new GenericBuilder().withId(transportManagerApplicationId).withVersion(1);
        apiResponse = RestUtils.put(genericBuilder, submitTransportManager, apiHeaders.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addTmResponsibilities() {
        if (getOperatorType().equals("public") && (getLicenceType().equals("special_restricted"))) {
            return;
        }
        String tmApplicationNo = transportManagerApplicationId;
        String addTMresp = URL.build(env, String.format("transport-manager-application/%s/update-details/", tmApplicationNo)).toString();
        int applicationVersion = Integer.parseInt(baseAPI.fetchTMApplicationInformation(tmApplicationNo, "version", "1"));
        AddressBuilder Address = new AddressBuilder().withAddressLine1(getAddressLine1()).withPostcode(getPostCode()).withTown(getTown()).withCountryCode(getCountryCode());
        TmRespBuilder tmRespBuilder = new TmRespBuilder().withEmail(getTransManEmailAddress()).withPlaceOfBirth(getTown()).withHomeAddress(Address).withWorkAddress(Address).withTmType(tmType).withIsOwner(isOwner)
                .withHoursMon(hours).withHoursTue(hours).withHoursWed(hours).withHoursThu(hours).withHoursThu(hours).withHoursFri(hours).withHoursSat(hours).withHoursSun(hours).withDob(birthDate)
                .withId(tmApplicationNo).withVersion(applicationVersion);
        apiResponse = RestUtils.put(tmRespBuilder, addTMresp, apiHeaders.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void submitTmResponsibilities() {
        if (getOperatorType().equals("public") && (getLicenceType().equals("special_restricted"))) {
            return;
        }
        String tmApplicationNo = transportManagerApplicationId;
        String submitTmResp = URL.build(env, String.format("transport-manager-application/%s/submit", tmApplicationNo)).toString();
        int applicationVersion = Integer.parseInt(baseAPI.fetchTMApplicationInformation(tmApplicationNo, "version", "1"));

        GenericBuilder genericBuilder = new GenericBuilder().withId(transportManagerApplicationId).withVersion(applicationVersion);
        apiResponse = RestUtils.put(genericBuilder, submitTmResp, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addVehicleDetails() {
        if (getOperatorType().equals("special_restricted")) {
            return;
        }
        String vehiclesResource = null;
        String vrm;

        if (getOperatorType().equals("goods")) {
            vehiclesResource = URL.build(env, String.format("application/%s/goods-vehicles", getApplicationNumber())).toString();
        }
        if (getOperatorType().equals("public")) {
            vehiclesResource = URL.build(env, String.format("application/%s/psv-vehicles", getApplicationNumber())).toString();
        }
        do {
            for (int i = 0; i < noOfVehiclesRequired; i++) {
                vrm = Str.randomWord(2).concat(String.valueOf(Int.random(99, 99)).concat(Str.randomWord(3)))
                        .toLowerCase();
                VehiclesBuilder vehiclesDetails = new VehiclesBuilder().withId(getApplicationNumber()).withApplication(getApplicationNumber()).withHasEnteredReg("Y").withVrm(vrm)
                        .withPlatedWeight(String.valueOf(Int.random(0, 9999))).withVersion(version);
                assert vehiclesResource != null;
                apiResponse = RestUtils.post(vehiclesDetails, vehiclesResource, apiHeaders.getHeaders());
                System.out.println("This is the VRM: ".concat(vrm));
            }
        }
        while ((apiResponse.extract().statusCode() == HttpStatus.SC_CONFLICT) || (apiResponse.extract().statusCode() == HttpStatus.SC_BAD_REQUEST)
                || (apiResponse.extract().statusCode() == HttpStatus.SC_UNPROCESSABLE_ENTITY));

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void submitVehicleDeclaration() {
        if (licenceType.equals("special_restricted")) {
            return;
        }
        String psvVehicleSize = "psvvs_both";
        String psvNoSmallVhlConfirmation = "Y";
        String psvOperateSmallVhl = "Y";
        String psvSmallVhlNotes = "submitted through the API";
        String psvLimousines = "Y";
        String psvNoLimousineConfirmation = "Y";
        String psvOnlyLimousinesConfirmation = "Y";
        String vehicleDeclarationResource = URL.build(env, String.format(String.format("application/%s/vehicle-declaration", applicationNumber))).toString();
        int applicationVersion = Integer.parseInt(baseAPI.fetchApplicationInformation(applicationNumber, "version", "1"));

        VehicleDeclarationBuilder vehicleDeclarationBuilder = new VehicleDeclarationBuilder().withId(applicationNumber).withPsvVehicleSize(psvVehicleSize)
                .withPsvLimousines(psvLimousines).withPsvNoSmallVhlConfirmation(psvNoSmallVhlConfirmation).withPsvOperateSmallVhl(psvOperateSmallVhl).withPsvSmallVhlNotes(psvSmallVhlNotes)
                .withPsvNoLimousineConfirmation(psvNoLimousineConfirmation).withPsvOnlyLimousinesConfirmation(psvOnlyLimousinesConfirmation).withVersion(applicationVersion);
        apiResponse = RestUtils.put(vehicleDeclarationBuilder, vehicleDeclarationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addFinancialHistory() {
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            return;
        }
        String financialHistoryAnswer = "N";
        String insolvencyAnswer = "false";
        String financialHistoryResource = URL.build(env, String.format("application/%s/financial-history", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        FinancialHistoryBuilder financialHistoryBuilder = new FinancialHistoryBuilder().withId(applicationNumber).withVersion(String.valueOf(applicationVersion)).withBankrupt(financialHistoryAnswer)
                .withLiquidation(financialHistoryAnswer).withReceivership(financialHistoryAnswer).withAdministration(financialHistoryAnswer).withAdministration(financialHistoryAnswer)
                .withDisqualified(financialHistoryAnswer).withInsolvencyDetails(insolvencyAnswer).withInsolvencyConfirmation(insolvencyAnswer);
        apiResponse = RestUtils.put(financialHistoryBuilder, financialHistoryResource, getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addApplicationSafetyAndComplianceDetails() {
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            return;
        }
        String tachographIns = "tach_na";
        String safetyInsVaries = "N";
        String safetyConfirmationOption = "Y";
        String applicationSafetyResource = URL.build(env, String.format("application/%s/safety", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        LicenceBuilder licence = new LicenceBuilder().withId(licenceNumber).withVersion(version).withSafetyInsVaries(safetyInsVaries).withSafetyInsVehicles(String.valueOf(noOfVehiclesRequired))
                .withSafetyInsTrailers(String.valueOf(noOfVehiclesRequired)).withTachographIns(tachographIns);
        ApplicationSafetyBuilder applicationSafetyBuilder = new ApplicationSafetyBuilder().withId(applicationNumber).withVersion(applicationVersion)
                .withSafetyConfirmation(safetyConfirmationOption).withLicence(licence);
        apiResponse = RestUtils.put(applicationSafetyBuilder, applicationSafetyResource, getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addSafetyInspector() {
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            return;
        }
        String safetyInspectorResource = URL.build(env, String.format("application/%s/workshop", applicationNumber)).toString();
        AddressBuilder addressBuilder = new AddressBuilder().withAddressLine1(addressLine1).withTown(town).withPostcode(postcode).withCountryCode(countryCode);
        ContactDetailsBuilder contactDetailsBuilder = new ContactDetailsBuilder().withFao(foreName).withAddress(addressBuilder);
        SafetyInspectorBuilder safetyInspectorBuilder = new SafetyInspectorBuilder().withApplication(applicationNumber).withLicence(licenceNumber).withIsExternal("N")
                .withContactDetails(contactDetailsBuilder);
        apiResponse = RestUtils.post(safetyInspectorBuilder, safetyInspectorResource, getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addConvictionsDetails() {
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            return;
        }
        String previousConvictionsResource = URL.build(env, String.format("application/%s/previous-convictions", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        CaseConvictionsPenaltiesBuilder convictionsPenaltiesBuilder = new CaseConvictionsPenaltiesBuilder().withId(applicationNumber).withConvictionsConfirmation("Y")
                .withPrevConviction("N").withVersion(applicationVersion);
        apiResponse = RestUtils.put(convictionsPenaltiesBuilder, previousConvictionsResource, getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void addLicenceHistory() {
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            return;
        }
        String optionResponse = "N";
        String licenceHistoryResource = URL.build(env, String.format("application/%s/licence-history", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        LicenceHistoryBuilder licenceHistoryBuilder = new LicenceHistoryBuilder().withId(applicationNumber).withPrevHadLicence(optionResponse).withPrevHasLicence(optionResponse)
                .withPrevBeenAtPi(optionResponse).withPrevBeenDisqualifiedTc(optionResponse).withPrevBeenRefused(optionResponse).withPrevBeenRevoked(optionResponse).withPrevPurchasedAssets(optionResponse)
                .withVersion(applicationVersion);
        apiResponse = RestUtils.put(licenceHistoryBuilder, licenceHistoryResource, getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void submitTaxiPhv() {
        String phLicenceNumber = "phv123456";
        String councilName = "nottinghamshire";
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            String submitResource = URL.build(env, String.format("application/%s/taxi-phv", applicationNumber)).toString();
            AddressBuilder addressBuilder = new AddressBuilder().withAddressLine1(addressLine1).withTown(town).withPostcode(postcode).withCountryCode(countryCode);
            PhvTaxiBuilder taxiBuilder = new PhvTaxiBuilder().withId(applicationNumber).withPrivateHireLicenceNo(phLicenceNumber).withCouncilName(councilName).withLicence(licenceNumber).withAddress(addressBuilder);
            apiResponse = RestUtils.post(taxiBuilder, submitResource, getHeaders());
            if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
                LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
                LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
                throw new HTTPException(apiResponse.extract().statusCode());
            }
        }
    }

    public void applicationReviewAndDeclare() {
        String interimReason = "Testing through the API";
        String declarationConfirmation = "Y";
        String signatureRequired = "sig_physical_signature";
        DeclarationsAndUndertakings undertakings = new DeclarationsAndUndertakings();
        String reviewResource = URL.build(env, String.format("application/%s/declaration/", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        if (operatorType.equals("goods") && (getIsInterim().equals("Y"))) {
            undertakings.withId(applicationNumber).withVersion(String.valueOf(applicationVersion)).withInterimRequested(getIsInterim())
                    .withInterimReason(interimReason).withSignatureType(signatureRequired).withDeclarationConfirmation(declarationConfirmation);
        } else {
            undertakings.withId(applicationNumber).withVersion(String.valueOf(applicationVersion))
                    .withSignatureType(signatureRequired).withDeclarationConfirmation(declarationConfirmation);
        }
        apiResponse = RestUtils.put(undertakings, reviewResource, getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void submitApplication() {
        String submitResource = URL.build(env, String.format("application/%s/submit", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        GenericBuilder genericBuilder = new GenericBuilder().withId(applicationNumber).withVersion(applicationVersion);
        apiResponse = RestUtils.put(genericBuilder, submitResource, getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public void getApplicationLicenceDetails() {
        apiHeaders.headers.put("x-pid", adminApiHeader());

        String getApplicationResource = URL.build(env, String.format("application/%s", applicationNumber)).toString();
        apiResponse = RestUtils.get(getApplicationResource, getHeaders());
        setLicenceId(apiResponse.extract().jsonPath().getString("licence.id"));
        setLicenceNumber(apiResponse.extract().jsonPath().getString("licence.licNo"));
        setApplicationStatus(apiResponse.extract().jsonPath().getString("licenceType.status.olbsKey"));
        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostCode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTransManEmailAddress() {
        return transManEmailAddress;
    }

    public void setTransManEmailAddress(String transManEmailAddress) {
        this.transManEmailAddress = transManEmailAddress;
    }

    public String getTrafficArea() {
        return trafficArea;
    }

    public void setTrafficArea(String trafficArea) {
        this.trafficArea = trafficArea;
    }

    public String getEnforcementArea() {
        return enforcementArea;
    }

    public void setEnforcementArea(String enforcementArea) {
        this.enforcementArea = enforcementArea;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public void setRestrictedVehicles(String restrictedVehicles) {
        this.restrictedVehicles = restrictedVehicles;
    }

    public String getIsInterim() {
        return isInterim;
    }

    public void setIsInterim(String isInterim) {
        this.isInterim = isInterim;
    }

    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBusinessEmailAddress() {
        return businessEmailAddress;
    }

    public void setBusinessEmailAddress(String businessEmailAddress) {
        this.businessEmailAddress = businessEmailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTransportManagerApplicationId(String transportManagerApplicationId) {
        this.transportManagerApplicationId = transportManagerApplicationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTmUserName() {
        return tmUserName;
    }

    public void setTmUserName(String tmUserName) {
        this.tmUserName = tmUserName;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}