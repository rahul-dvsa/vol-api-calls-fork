package apiCalls.actions;

import activesupport.faker.FakerUtils;
import apiCalls.Utils.builders.*;
import apiCalls.Utils.generic.BaseAPI;
import apiCalls.Utils.generic.Headers;
import activesupport.http.RestUtils;
import activesupport.number.Int;
import activesupport.string.Str;
import activesupport.system.Properties;
import apiCalls.enums.BusinessType;
import apiCalls.enums.LicenceType;
import apiCalls.enums.OperatorType;
import apiCalls.enums.TrafficArea;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

import javax.xml.ws.http.HTTPException;
import java.util.LinkedHashMap;

public class CreateApplication extends BaseAPI {

    FakerUtils faker = new FakerUtils();

    private static int version = 1;

    private String title;
    private String foreName;
    private String familyName;
    private String birthDate;
    private String town;
    private TrafficArea postCodeByTrafficArea;
    private String postcode;
    private String safetInspectorPostCode;
    private String countryCode;
    private String organisationName;
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
    private String companyNumber;
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
    private String tmType;
    private String phoneNumber;
    private String businessEmailAddress;
    private String psvVehicleSize;
    private String psvNoSmallVhlConfirmation;
    private String psvOperateSmallVhl;
    private String psvSmallVhlNotes;
    private String psvLimousines;
    private String psvNoLimousineConfirmation;
    private String psvOnlyLimousinesConfirmation;
    private String businessAddressLine1;
    private String businessAddressLine2;
    private String businessTown;
    private String businessPostCode;
    private String establishmentAddressLine1;
    private String establishmentAddressLine2;
    private String establishmentTown;
    private String establishmentPostCode;
    private String operatingCentreTown;
    private String operatingCentrePostCode;
    private String operatingCentreAddressLine1;
    private String transportConsultantAddressLine1;
    private String transportConsultantTown;
    private String transportConsultantPhone;
    private String transportConsultantName;
    private String transportConsultantPostCode;
    private String transportConsultantEmail;
    private String transportManagerFirstName;
    private String transportManagerLastName;

    private double hours;

    public int getNoOfVehiclesRequired() {
        return noOfVehiclesRequired;
    }

    public void setNoOfVehiclesRequired(int noOfVehiclesRequired) {
        this.noOfVehiclesRequired = noOfVehiclesRequired;
    }

    private int noOfVehiclesRequired;

    private static final Logger LOGGER = LogManager.getLogger(RegisterUser.class);

    private EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    private ValidatableResponse apiResponse;

    public String getTmType() {
        return tmType;
    }

    public void setTmType(String tmType) {
        this.tmType = tmType;
    }

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

    public String getBusinessAddressLine1() {
        return businessAddressLine1;
    }

    public void setBusinessAddressLine1(String businessAddressLine1) {
        this.businessAddressLine1 = businessAddressLine1;
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

    public String getTransManEmailAddress() {
        return transManEmailAddress;
    }

    public String getRestrictedVehicles() {
        return restrictedVehicles;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public String getPsvVehicleSize() {
        return psvVehicleSize;
    }

    public void setPsvVehicleSize(String psvVehicleSize) {
        this.psvVehicleSize = psvVehicleSize;
    }

    public String getPsvNoSmallVhlConfirmation() {
        return psvNoSmallVhlConfirmation;
    }

    public void setPsvNoSmallVhlConfirmation(String psvNoSmallVhlConfirmation) {
        this.psvNoSmallVhlConfirmation = psvNoSmallVhlConfirmation;
    }

    public String getPsvOperateSmallVhl() {
        return psvOperateSmallVhl;
    }

    public void setPsvOperateSmallVhl(String psvOperateSmallVhl) {
        this.psvOperateSmallVhl = psvOperateSmallVhl;
    }

    public String getPsvSmallVhlNotes() {
        return psvSmallVhlNotes;
    }

    public void setPsvSmallVhlNotes(String psvSmallVhlNotes) {
        this.psvSmallVhlNotes = psvSmallVhlNotes;
    }

    public String getPsvLimousines() {
        return psvLimousines;
    }

    public void setPsvLimousines(String psvLimousines) {
        this.psvLimousines = psvLimousines;
    }

    public String getPsvNoLimousineConfirmation() {
        return psvNoLimousineConfirmation;
    }

    public void setPsvNoLimousineConfirmation(String psvNoLimousineConfirmation) {
        this.psvNoLimousineConfirmation = psvNoLimousineConfirmation;
    }

    public String getPsvOnlyLimousinesConfirmation() {
        return psvOnlyLimousinesConfirmation;
    }

    public void setPsvOnlyLimousinesConfirmation(String psvOnlyLimousinesConfirmation) {
        this.psvOnlyLimousinesConfirmation = psvOnlyLimousinesConfirmation;
    }

    public String getEstablishmentAddressLine1() {
        return establishmentAddressLine1;
    }

    public void setEstablishmentAddressLine1(String establishmentAddressLine1) {
        this.establishmentAddressLine1 = establishmentAddressLine1;
    }

    public String getBusinessTown() {
        return businessTown;
    }

    public void setBusinessTown(String businessTown) {
        this.businessTown = businessTown;
    }

    public String getBusinessPostCode() {
        return businessPostCode;
    }

    public void setBusinessPostCode(String businessPostCode) {
        this.businessPostCode = businessPostCode;
    }

    public String getEstablishmentTown() {
        return establishmentTown;
    }

    public void setEstablishmentTown(String establishmentTown) {
        this.establishmentTown = establishmentTown;
    }

    public String getEstablishmentPostCode() {
        return establishmentPostCode;
    }

    public void setEstablishmentPostCode(String establishmentPostCode) {
        this.establishmentPostCode = establishmentPostCode;
    }

    public String getOperatingCentreTown() {
        return operatingCentreTown;
    }

    public void setOperatingCentreTown(String operatingCentreTown) {
        this.operatingCentreTown = operatingCentreTown;
    }

    public String getOperatingCentrePostCode() {
        return operatingCentrePostCode;
    }

    public void setOperatingCentrePostCode(String operatingCentrePostCode) {
        this.operatingCentrePostCode = operatingCentrePostCode;
    }

    public void setOperatingCentreAddressLine1(String operatingCentreAddressLine1) {
        this.operatingCentreAddressLine1 = operatingCentreAddressLine1;
    }

    public String getBusinessAddressLine2() {
        return businessAddressLine2;
    }

    public void setBusinessAddressLine2(String businessAddressLine2) {
        this.businessAddressLine2 = businessAddressLine2;
    }

    public String getEstablishmentAddressLine2() {
        return establishmentAddressLine2;
    }

    public void setEstablishmentAddressLine2(String establishmentAddressLine2) {
        this.establishmentAddressLine2 = establishmentAddressLine2;
    }

    public void setTransportConsultantAddressLine1(String transportConsultantAddressLine1) {
        this.transportConsultantAddressLine1 = transportConsultantAddressLine1;
    }

    public void setTransportConsultantTown(String transportConsultantTown) {
        this.transportConsultantTown = transportConsultantTown;
    }

    public void setTransportConsultantPhone(String transportConsultantPhone) {
        this.transportConsultantPhone = transportConsultantPhone;
    }

    public void setTransportConsultantName(String transportConsultantName) {
        this.transportConsultantName = transportConsultantName;
    }

    public void setTransportConsultantEmail(String transportConsultantEmail) {
        this.transportConsultantEmail = transportConsultantEmail;
    }

    public void setSafetInspectorPostCode(String safetInspectorPostCode) {
        this.safetInspectorPostCode = safetInspectorPostCode;
    }

    public void setTransportConsultantPostCode(String transportConsultantPostCode) {
        this.transportConsultantPostCode = transportConsultantPostCode;
    }

    public void setPostCodeByTrafficArea(TrafficArea postCodeByTrafficArea) {
        this.postCodeByTrafficArea = postCodeByTrafficArea;
    }

    private Headers apiHeaders = new Headers();

    public CreateApplication() {
        this.businessName = businessName == null ? faker.generateCompanyName() : businessName;
        this.organisationName = organisationName == null ? faker.generateCompanyName() : organisationName;
        this.companyNumber = companyNumber == null ? String.valueOf(Int.random(00000000, 99999999)) : companyNumber;

        this.phoneNumber = phoneNumber == null ? "0712345678" : phoneNumber;
        this.businessEmailAddress = businessEmailAddress == null ? String.format("%s.volBusiness@dvsa.com", organisationName.replace(" ", "_").replace(",", "")) : businessEmailAddress;

        this.foreName = foreName == null ? faker.generateFirstName().concat(String.valueOf(Int.random(100, 999))) : foreName;
        this.familyName = familyName == null ? faker.generateLastName().concat(String.valueOf(Int.random(100, 999))) : familyName;
        this.birthDate = birthDate == null ? Int.random(1900, 2018) + "-" + Int.random(1, 12) + "-" + Int.random(1, 28) : birthDate;

        this.safetInspectorPostCode = safetInspectorPostCode == null ? faker.getRandomRealUKPostcode() : safetInspectorPostCode;
        this.transportConsultantPostCode = transportConsultantPostCode == null ? faker.getRandomRealUKPostcode() : transportConsultantPostCode;

        this.hours = hours == 0.0 ? 2.0 : hours;
        this.restrictedVehicles = restrictedVehicles == null ? "2" : restrictedVehicles;
        this.noOfVehiclesRequired = noOfVehiclesRequired == 0 ? 5 : noOfVehiclesRequired;
        this.psvVehicleSize = psvVehicleSize == null ? "psvvs_both" : psvVehicleSize;
        this.psvNoSmallVhlConfirmation = psvNoSmallVhlConfirmation == null ? "Y" : psvNoSmallVhlConfirmation;
        this.psvOperateSmallVhl = psvOperateSmallVhl == null ? "Y" : psvOperateSmallVhl;
        this.psvSmallVhlNotes = psvSmallVhlNotes == null ? "submitted through the API" : psvSmallVhlNotes;
        this.psvLimousines = psvLimousines == null ? "Y" : psvLimousines;
        this.psvNoLimousineConfirmation = psvNoLimousineConfirmation == null ? "Y" : psvNoLimousineConfirmation;
        this.psvOnlyLimousinesConfirmation = psvOnlyLimousinesConfirmation == null ? "Y" : psvOnlyLimousinesConfirmation;
        this.operatorType = operatorType == null ? OperatorType.valueOf("goods".toUpperCase()).asString() : operatorType;
        this.licenceType = licenceType == null ? LicenceType.valueOf("standard_international".toUpperCase()).asString() : licenceType;
        this.businessType = businessType == null ? BusinessType.valueOf("limited_company".toUpperCase()).asString() : businessType;
        this.niFlag = niFlag == null ? "N" : niFlag;
        this.isInterim = isInterim == null ? "N" : isInterim;
        this.isOwner = isOwner == null ? "Y" : isOwner;
        this.countryCode = countryCode == null ? "GB" : countryCode;

        this.transportManagerFirstName = transportManagerFirstName == null ? String.format("%s %s", faker.generateFirstName(), faker.generateLastName()) : transportManagerFirstName;
        this.transportManagerLastName = transportManagerLastName == null ? faker.generateFirstName() : transportManagerLastName;
        this.transManEmailAddress = transManEmailAddress == null ? String.format("%s.volTransportManager@dvsa.com", transportManagerFirstName.replace(" ", "_").replace(",", "")) : transportConsultantEmail;

        this.transportConsultantName = transportConsultantName == null ? String.format("%s %s", faker.generateFirstName(), faker.generateLastName()) : transportConsultantName;
        this.transportConsultantEmail = transportConsultantEmail == null ? String.format("%s.volTConsultant@dvsa.com", transportConsultantName.replace(" ", "_").replace(",", "")) : transportConsultantEmail;

        LinkedHashMap<String, String> operatingCentreAddress = faker.generateAddress();
        this.operatingCentreAddressLine1 = operatingCentreAddressLine1 == null ? operatingCentreAddress.get("addressLine1") : operatingCentreAddressLine1;
        this.operatingCentreTown = operatingCentreTown == null ? operatingCentreAddress.get("town") : operatingCentreTown;

        LinkedHashMap<String, String> registeredAddress = faker.generateAddress();
        this.businessAddressLine1 = businessAddressLine1 == null ? registeredAddress.get("addressLine1") : businessAddressLine1;
        this.businessAddressLine2 = businessAddressLine2 == null ? registeredAddress.get("addressLine2") : businessAddressLine2;
        this.businessTown = businessTown == null ? faker.generateAddress().get("town") : businessTown;

        LinkedHashMap<String, String> establishmentAddress = faker.generateAddress();
        this.establishmentAddressLine1 = establishmentAddressLine1 == null ? establishmentAddress.get("addressLine1") : establishmentAddressLine1;
        this.establishmentAddressLine2 = establishmentAddressLine2 == null ? establishmentAddress.get("addressLine2") : establishmentAddressLine2;
        this.establishmentTown = establishmentTown == null ? faker.generateAddress().get("town") : establishmentTown;

        LinkedHashMap<String, String> transportConsultantAddress = faker.generateAddress();
        this.transportConsultantAddressLine1 = transportConsultantAddressLine1 == null ? transportConsultantAddress.get("addressLine1") : transportConsultantAddressLine1;
        this.transportConsultantTown = transportConsultantTown == null ? faker.generateAddress().get("town") : transportConsultantTown;
    }

    public ValidatableResponse startApplication() {
        String createApplicationResource = URL.build(env, "application").toString();
        apiHeaders.headers.put("x-pid", pid);

        ApplicationBuilder applicationBuilder = new ApplicationBuilder().withOperatorType(getOperatorType())
                .withLicenceType(getLicenceType()).withNiFlag(getNiFlag()).withOrganisation(getOrganisationId());
        apiResponse = RestUtils.post(applicationBuilder, createApplicationResource, apiHeaders.getHeaders());
        setApplicationNumber(apiResponse.extract().jsonPath().getString("id.application"));
        licenceNumber = apiResponse.extract().jsonPath().getString("id.licence");
        setApplicationNumber(applicationNumber);

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addBusinessType() {
        String organisationVersion = fetchApplicationInformation(getApplicationNumber(), "licence.organisation.version", "1");
        String updateBusinessTypeResource = URL.build(env, String.format("organisation/%s/business-type/", getOrganisationId())).toString();

        BusinessTypeBuilder businessTypeBuilder = new BusinessTypeBuilder().withBusinessType(getBusinessType()).withVersion(organisationVersion)
                .withId(getOrganisationId()).withApplication(getApplicationNumber());
        apiResponse = RestUtils.put(businessTypeBuilder, updateBusinessTypeResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addBusinessDetails() {
        String organisationVersion = fetchApplicationInformation(getApplicationNumber(), "licence.organisation.version", "1");
        String natureOfBusiness = faker.generateNatureOfBusiness();
        String updateBusinessDetailsResource = URL.build(env, String.format("organisation/business-details/application/%s", getApplicationNumber())).toString();

        AddressBuilder address = new AddressBuilder().withAddressLine1(getBusinessAddressLine1()).withTown(getBusinessTown()).withPostcode(TrafficArea.getPostCode(postCodeByTrafficArea));
        UpdateBusinessDetailsBuilder businessDetails = new UpdateBusinessDetailsBuilder()
                .withId(getApplicationNumber()).withCompanyNumber(companyNumber).withNatureOfBusiness(natureOfBusiness).withLicence(getLicenceNumber())
                .withVersion(organisationVersion).withName(getBusinessName()).withAddress(address);

        apiResponse = RestUtils.put(businessDetails, updateBusinessDetailsResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addAddressDetails() {
        String applicationAddressResource = URL.build(env, String.format("application/%s/addresses/", getApplicationNumber())).toString();

        AddressBuilder establishmentAddress = new AddressBuilder().withAddressLine1(getEstablishmentAddressLine1()
        ).withTown(getEstablishmentTown()).withPostcode(TrafficArea.getPostCode(postCodeByTrafficArea)).withCountryCode(getCountryCode());

        AddressBuilder correspondenceAddress = new AddressBuilder().withAddressLine1(getBusinessAddressLine1()).withAddressLine2(getBusinessAddressLine2()
        ).withTown(getBusinessTown()).withPostcode(TrafficArea.getPostCode(postCodeByTrafficArea)).withCountryCode(getCountryCode());

        AddressBuilder transportConsultantAddress = new AddressBuilder().withAddressLine1(transportConsultantAddressLine1).withTown(transportConsultantTown).withPostcode(transportConsultantPostCode).withCountryCode(countryCode);

        ContactDetailsBuilder transportConsultantContact = new ContactDetailsBuilder().withPhoneNumber(transportConsultantPhone).withEmailAddress(transportConsultantEmail);

        TransportConsultantBuilder transportConsultant = new TransportConsultantBuilder().withConfirmation("Y").withAddress(transportConsultantAddress).withName(transportConsultantName)
                .withWrittenPermissionToEngage("Y").withContact(transportConsultantContact);

        ContactDetailsBuilder contactDetailsBuilder = new ContactDetailsBuilder().withPhoneNumber(getPhoneNumber()).withEmailAddress(getBusinessEmailAddress());

        ApplicationAddressBuilder addressBuilder = new ApplicationAddressBuilder().withId(applicationNumber).withConsultant(transportConsultant).withContact(contactDetailsBuilder)
                .withCorrespondenceAddress(correspondenceAddress).withEstablishmentAddress(establishmentAddress);

        apiResponse = RestUtils.put(addressBuilder, applicationAddressResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addPartners() {
        String addPersonResource = URL.build(env, String.format("application/%s/people/", getApplicationNumber())).toString();
        PersonBuilder addPerson = new PersonBuilder().withId(getApplicationNumber()).withTitle(getTitle()).withForename(getForeName()).withFamilyName(getFamilyName()).withBirthDate(getBirthDate());
        apiResponse = RestUtils.post(addPerson, addPersonResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addOperatingCentre() {
        String operatingCentreResource = URL.build(env, String.format("application/%s/operating-centre/", getApplicationNumber())).toString();
        String permissionOption = "Y";

        OperatingCentreBuilder operatingCentreBuilder = new OperatingCentreBuilder();

        if (operatorType.equals(OperatorType.GOODS.asString())) {
            AddressBuilder address = new AddressBuilder().withAddressLine1(operatingCentreAddressLine1).withTown(getOperatingCentreTown()
            ).withPostcode(TrafficArea.getPostCode(postCodeByTrafficArea)).withCountryCode(getCountryCode());
            operatingCentreBuilder.withApplication(getApplicationNumber()).withNoOfVehiclesRequired(String.valueOf(getNoOfVehiclesRequired()))
                    .withNoOfTrailersRequired(String.valueOf(getNoOfVehiclesRequired())).withPermission(permissionOption).withAddress(address);
        }
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (!licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            AddressBuilder address = new AddressBuilder().withAddressLine1(operatingCentreAddressLine1).withTown(getTown()).withPostcode(TrafficArea.getPostCode(postCodeByTrafficArea)).withCountryCode(getCountryCode());
            operatingCentreBuilder.withApplication(getApplicationNumber()
            ).withNoOfVehiclesRequired(String.valueOf(getNoOfVehiclesRequired())).withPermission(permissionOption).withAddress(address);
        }
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.RESTRICTED.asString()))) {
            AddressBuilder address = new AddressBuilder().withAddressLine1(operatingCentreAddressLine1).withTown(getTown()).withPostcode(TrafficArea.getPostCode(postCodeByTrafficArea)).withCountryCode(getCountryCode());
            operatingCentreBuilder.withApplication(getApplicationNumber()).withNoOfVehiclesRequired(String.valueOf(getRestrictedVehicles())).withPermission(permissionOption).withAddress(address);
        }
        if (!licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString())) {
            apiResponse = RestUtils.post(operatingCentreBuilder, operatingCentreResource, apiHeaders.getHeaders());
        }

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }

        return apiResponse;
    }

    public ValidatableResponse updateOperatingCentre() {
        if (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString())) {
            return null;
        }
        String updateOperatingCentreResource = URL.build(env, String.format("application/%s/operating-centres", getApplicationNumber())).toString();
        OperatingCentreUpdater updateOperatingCentre = new OperatingCentreUpdater();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationNumber(), "version", "1"));

        if (operatorType.equals(OperatorType.GOODS.asString())) {
            updateOperatingCentre.withId(getApplicationNumber()).withTotAuthVehicles(getNoOfVehiclesRequired())
                    .withTrafficArea(getTrafficArea()).withEnforcementArea(getEnforcementArea()).withTotCommunityLicences(1)
                    .withTAuthTrailers(Integer.parseInt(String.valueOf(getNoOfVehiclesRequired()))).withVersion(applicationVersion);
        }
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (!licenceType.equals(LicenceType.RESTRICTED.asString()))) {
            updateOperatingCentre.withId(getApplicationNumber()).withTotAuthVehicles(getNoOfVehiclesRequired())
                    .withTrafficArea(getTrafficArea()).withEnforcementArea(getEnforcementArea()).withTotCommunityLicences(1).withVersion(applicationVersion);
        }

        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.RESTRICTED.asString()))) {
            updateOperatingCentre.withId(getApplicationNumber()).withTotAuthVehicles(Integer.valueOf(String.valueOf(getRestrictedVehicles())))
                    .withTrafficArea(getTrafficArea()).withEnforcementArea(getEnforcementArea()).withVersion(applicationVersion);
        }

        apiResponse = RestUtils.put(updateOperatingCentre, updateOperatingCentreResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }

        return apiResponse;
    }

    public ValidatableResponse addFinancialEvidence() {
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.RESTRICTED.asString()))) {
            return null;
        }

        String financialEvidenceResource = URL.build(env, String.format("application/%s/financial-evidence", getApplicationNumber())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationNumber(), "version", "1"));

        FinancialEvidenceBuilder financialEvidenceBuilder = new FinancialEvidenceBuilder().withId(getApplicationNumber()).withVersion(applicationVersion).withFinancialEvidenceUploaded(0);
        apiResponse = RestUtils.put(financialEvidenceBuilder, financialEvidenceResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }

        return apiResponse;
    }

    public ValidatableResponse addTransportManager() {
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.RESTRICTED.asString()))) {
            return null;
        }
        int randNumber = Int.random(0, 2000);
        tmUserName = "apiTM".concat(faker.generateFirstName()).concat(String.valueOf(randNumber));
        String hasEmail = "Y";
        String addTransportManager = URL.build(env, "transport-manager/create-new-user/").toString();
        TransportManagerBuilder transportManagerBuilder = new TransportManagerBuilder().withApplication(getApplicationNumber()).withFirstName(transportManagerFirstName)
                .withFamilyName(transportManagerLastName).withHasEmail(hasEmail).withUsername(getTmUserName()).withEmailAddress(getTransManEmailAddress()).withBirthDate(getBirthDate());
        apiResponse = RestUtils.post(transportManagerBuilder, addTransportManager, apiHeaders.getHeaders());
        setTransportManagerApplicationId(apiResponse.extract().jsonPath().getString("id.transportManagerApplicationId"));

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse submitTransport() {
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            return null;
        }
        String submitTransportManager = URL.build(env, String.format("transport-manager-application/%s/submit", getApplicationNumber())).toString();
        GenericBuilder genericBuilder = new GenericBuilder().withId(transportManagerApplicationId).withVersion(1);
        apiResponse = RestUtils.put(genericBuilder, submitTransportManager, apiHeaders.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addTmResponsibilities() {
        if (getOperatorType().equals(OperatorType.PUBLIC.asString()) && (getLicenceType().equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            return null;
        }
        String tmApplicationNo = transportManagerApplicationId;
        String addTMresp = URL.build(env, String.format("transport-manager-application/%s/update-details/", tmApplicationNo)).toString();
        int applicationVersion = Integer.parseInt(fetchTMApplicationInformation(tmApplicationNo, "version", "1"));
        AddressBuilder Address = new AddressBuilder().withAddressLine1(getBusinessAddressLine1()).withPostcode(TrafficArea.getPostCode(postCodeByTrafficArea)).withTown(getTown()).withCountryCode(getCountryCode());
        TmRespBuilder tmRespBuilder = new TmRespBuilder().withEmail(getTransManEmailAddress()).withPlaceOfBirth(getTown()).withHomeAddress(Address).withWorkAddress(Address).withTmType(getTmType()).withIsOwner(isOwner)
                .withHoursMon(hours).withHoursTue(hours).withHoursWed(hours).withHoursThu(hours).withHoursThu(hours).withHoursFri(hours).withHoursSat(hours).withHoursSun(hours).withDob(birthDate)
                .withId(tmApplicationNo).withVersion(applicationVersion);

        apiResponse = RestUtils.put(tmRespBuilder, addTMresp, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse submitTmResponsibilities() {
        if (getOperatorType().equals(OperatorType.PUBLIC.asString()) && (getLicenceType().equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            return null;
        }
        String tmApplicationNo = transportManagerApplicationId;
        String submitTmResp = URL.build(env, String.format("transport-manager-application/%s/submit", tmApplicationNo)).toString();
        int applicationVersion = Integer.parseInt(fetchTMApplicationInformation(tmApplicationNo, "version", "1"));

        GenericBuilder genericBuilder = new GenericBuilder().withId(transportManagerApplicationId).withVersion(applicationVersion);
        apiResponse = RestUtils.put(genericBuilder, submitTmResp, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addVehicleDetails() {
        if (getOperatorType().equals(LicenceType.SPECIAL_RESTRICTED.asString())) {
            return null;
        }
        String vehiclesResource = null;
        String vrm;

        if (getOperatorType().equals(OperatorType.GOODS.asString())) {
            vehiclesResource = URL.build(env, String.format("application/%s/goods-vehicles", getApplicationNumber())).toString();
        }
        if (getOperatorType().equals(OperatorType.PUBLIC.asString())) {
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
        return apiResponse;
    }

    public ValidatableResponse submitVehicleDeclaration() {
        if (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString())) {
            return null;
        }

        String vehicleDeclarationResource = URL.build(env, String.format(String.format("application/%s/vehicle-declaration", applicationNumber))).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationNumber(), "version", "1"));

        VehicleDeclarationBuilder vehicleDeclarationBuilder = new VehicleDeclarationBuilder().withId(getApplicationNumber()
        ).withPsvVehicleSize(psvVehicleSize)
                .withPsvLimousines(psvLimousines).withPsvNoSmallVhlConfirmation(psvNoSmallVhlConfirmation).withPsvOperateSmallVhl(psvOperateSmallVhl).withPsvSmallVhlNotes(psvSmallVhlNotes)
                .withPsvNoLimousineConfirmation(psvNoLimousineConfirmation).withPsvOnlyLimousinesConfirmation(psvOnlyLimousinesConfirmation).withVersion(applicationVersion);
        apiResponse = RestUtils.put(vehicleDeclarationBuilder, vehicleDeclarationResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addFinancialHistory() {
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            return null;
        }
        String financialHistoryAnswer = "N";
        String insolvencyAnswer = "false";
        String financialHistoryResource = URL.build(env, String.format("application/%s/financial-history", getApplicationNumber())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationNumber(), "version", "1"));

        FinancialHistoryBuilder financialHistoryBuilder = new FinancialHistoryBuilder().withId(getApplicationNumber()).withVersion(String.valueOf(applicationVersion)).withBankrupt(financialHistoryAnswer)
                .withLiquidation(financialHistoryAnswer).withReceivership(financialHistoryAnswer).withAdministration(financialHistoryAnswer).withAdministration(financialHistoryAnswer)
                .withDisqualified(financialHistoryAnswer).withInsolvencyDetails(insolvencyAnswer).withInsolvencyConfirmation(insolvencyAnswer);
        apiResponse = RestUtils.put(financialHistoryBuilder, financialHistoryResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addApplicationSafetyAndComplianceDetails() {
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            return null;
        }
        String tachographIns = "tach_na";
        String safetyInsVaries = "N";
        String safetyConfirmationOption = "Y";
        String applicationSafetyResource = URL.build(env, String.format("application/%s/safety", getApplicationNumber())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationNumber(), "version", "1"));

        LicenceBuilder licence = new LicenceBuilder().withId(licenceNumber).withVersion(version).withSafetyInsVaries(safetyInsVaries).withSafetyInsVehicles(String.valueOf(noOfVehiclesRequired))
                .withSafetyInsTrailers(String.valueOf(noOfVehiclesRequired)).withTachographIns(tachographIns);
        ApplicationSafetyBuilder applicationSafetyBuilder = new ApplicationSafetyBuilder().withId(getApplicationNumber()).withVersion(applicationVersion)
                .withSafetyConfirmation(safetyConfirmationOption).withLicence(licence);
        apiResponse = RestUtils.put(applicationSafetyBuilder, applicationSafetyResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addSafetyInspector() {
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            return null;
        }
        String safetyInspectorResource = URL.build(env, String.format("application/%s/workshop", getApplicationNumber()
        )).toString();
        AddressBuilder addressBuilder = new AddressBuilder().withAddressLine1(businessAddressLine1).withTown(town).withPostcode(safetInspectorPostCode).withCountryCode(countryCode);
        ContactDetailsBuilder contactDetailsBuilder = new ContactDetailsBuilder().withFao(foreName).withAddress(addressBuilder);
        SafetyInspectorBuilder safetyInspectorBuilder = new SafetyInspectorBuilder().withApplication(applicationNumber).withLicence(licenceNumber).withIsExternal("N")
                .withContactDetails(contactDetailsBuilder);
        apiResponse = RestUtils.post(safetyInspectorBuilder, safetyInspectorResource, apiHeaders.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addConvictionsDetails() {
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            return null;
        }
        String previousConvictionsResource = URL.build(env, String.format("application/%s/previous-convictions", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        CaseConvictionsPenaltiesBuilder convictionsPenaltiesBuilder = new CaseConvictionsPenaltiesBuilder().withId(applicationNumber).withConvictionsConfirmation("Y")
                .withPrevConviction("N").withVersion(applicationVersion);
        apiResponse = RestUtils.put(convictionsPenaltiesBuilder, previousConvictionsResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addLicenceHistory() {
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString()))) {
            return null;
        }
        String optionResponse = "N";
        String licenceHistoryResource = URL.build(env, String.format("application/%s/licence-history", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        LicenceHistoryBuilder licenceHistoryBuilder = new LicenceHistoryBuilder().withId(applicationNumber).withPrevHadLicence(optionResponse).withPrevHasLicence(optionResponse)
                .withPrevBeenAtPi(optionResponse).withPrevBeenDisqualifiedTc(optionResponse).withPrevBeenRefused(optionResponse).withPrevBeenRevoked(optionResponse).withPrevPurchasedAssets(optionResponse)
                .withVersion(applicationVersion);
        apiResponse = RestUtils.put(licenceHistoryBuilder, licenceHistoryResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse submitTaxiPhv() {
        String phLicenceNumber = "phv123456";
        String councilName = "Volhampton";
        if (operatorType.equals("public") && (licenceType.equals("special_restricted"))) {
            String submitResource = URL.build(env, String.format("application/%s/taxi-phv", getApplicationNumber())).toString();
            AddressBuilder addressBuilder = new AddressBuilder().withAddressLine1(businessAddressLine1).withTown(town).withPostcode(TrafficArea.getPostCode(postCodeByTrafficArea)).withCountryCode(countryCode);
            PhvTaxiBuilder taxiBuilder = new PhvTaxiBuilder().withId(applicationNumber).withPrivateHireLicenceNo(phLicenceNumber).withCouncilName(councilName).withLicence(licenceNumber).withAddress(addressBuilder);
            apiResponse = RestUtils.post(taxiBuilder, submitResource, apiHeaders.getHeaders());
            if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
                LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
                LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
                throw new HTTPException(apiResponse.extract().statusCode());
            }
        }
        return apiResponse;
    }

    public ValidatableResponse applicationReviewAndDeclare() {
        String interimReason = "Testing through the API";
        String declarationConfirmation = "Y";
        String signatureRequired = "sig_physical_signature";
        DeclarationsAndUndertakings undertakings = new DeclarationsAndUndertakings();
        String reviewResource = URL.build(env, String.format("application/%s/declaration/", getApplicationNumber())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationNumber(), "version", "1"));

        if (operatorType.equals("goods") && (getIsInterim().equals("Y"))) {
            undertakings.withId(getApplicationNumber()).withVersion(String.valueOf(applicationVersion)).withInterimRequested(getIsInterim())
                    .withInterimReason(interimReason).withSignatureType(signatureRequired).withDeclarationConfirmation(declarationConfirmation);
        } else {
            undertakings.withId(getApplicationNumber()).withVersion(String.valueOf(applicationVersion))
                    .withSignatureType(signatureRequired).withDeclarationConfirmation(declarationConfirmation);
        }
        apiResponse = RestUtils.put(undertakings, reviewResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse submitApplication() {
        String submitResource = URL.build(env, String.format("application/%s/submit", applicationNumber)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationNumber, "version", "1"));

        GenericBuilder genericBuilder = new GenericBuilder().withId(applicationNumber).withVersion(applicationVersion);
        apiResponse = RestUtils.put(genericBuilder, submitResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }
}