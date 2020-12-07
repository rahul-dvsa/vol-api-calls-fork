package apiCalls.actions;

import activesupport.faker.FakerUtils;
import apiCalls.Utils.builders.*;
import apiCalls.Utils.generic.BaseAPI;
import apiCalls.Utils.generic.Headers;
import activesupport.http.RestUtils;
import activesupport.number.Int;
import activesupport.string.Str;
import activesupport.system.Properties;
import apiCalls.enums.*;
import io.restassured.response.ValidatableResponse;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
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
    private String partnerForeName;
    private String partnerFamilyName;
    private String partnerDOB;
    private String town;
    private String postCodeByTrafficArea;
    private String postcode;
    private String safetyInspectorForeName;
    private String safetyInspectorFamilyName;
    private String safetyInspectorDOB;
    private String safetyInspectorAddressLine1;
    private String safetyInspectorAddressLine2;
    private String safetyInspectorAddressLine3;
    private String safetyInspectorAddressLine4;
    private String safetyInspectorTown;
    private String safetyInspectorPostCode;
    private String countryCode;
    private String transportManagerEmailAddress;
    private String applicationId;
    private String userId;
    private String tmUserName;
    private String username;
    private String loginId;
    private String pid;
    private String organisationId;
    private String natureOfBusiness;
    private String licenceNumber;
    private String transportManagerApplicationId;
    private String companyNumber;
    private String licenceType;
    private String businessType;
    private String operatorType;
    private String niFlag = System.getProperty("ni");
    private String trafficArea;
    private String enforcementArea;
    private Integer restrictedVehicles;
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
    private String registeredAddressLine1;
    private String registeredAddressLine2;
    private String registeredAddressLine3;
    private String registeredAddressLine4;
    private String registeredTown;
    private String registeredPostCode;
    private String correspondenceAddressLine1;
    private String correspondenceAddressLine2;
    private String correspondenceAddressLine3;
    private String correspondenceAddressLine4;
    private String correspondenceTown;
    private String correspondencePostCode;
    private String businessPostCode;
    private String establishmentAddressLine1;
    private String establishmentAddressLine2;
    private String establishmentAddressLine3;
    private String establishmentAddressLine4;
    private String establishmentTown;
    private String establishmentPostCode;
    private String transportManagerFirstName;
    private String transportManagerLastName;
    private String transportManagerDOB;
    private String transportManagerAddressLine1;
    private String transportManagerAddressLine2;
    private String transportManagerAddressLine3;
    private String transportManagerAddressLine4;
    private String transportManagerTown;
    private String transportManagerPostCode;
    private String operatingCentreAddressLine1;
    private String operatingCentreAddressLine2;
    private String operatingCentreAddressLine3;
    private String operatingCentreAddressLine4;
    private String operatingCentreTown;
    private String operatingCentrePostCode;
    private String transportConsultantPhone;
    private String transportConsultantName;
    private String transportConsultantEmail;
    private String transportConsultantAddressLine1;
    private String transportConsultantAddressLine2;
    private String transportConsultantAddressLine3;
    private String transportConsultantAddressLine4;
    private String transportConsultantTown;
    private String transportConsultantPostCode;
    private int operatingCentreVehicleCap;
    private int operatingCentreTrailerCap;
    private int noOfVehiclesRequested;
    private double hours;


    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public int getOperatingCentreVehicleCap() {
        return operatingCentreVehicleCap;
    }

    public void setOperatingCentreVehicleCap(int operatingCentreVehicleCap) {
        this.operatingCentreVehicleCap = operatingCentreVehicleCap;
    }

    public int getOperatingCentreTrailerCap() {
        return operatingCentreTrailerCap;
    }

    public void setOperatingCentreTrailerCap(int operatingCentreTrailerCap) {
        this.operatingCentreTrailerCap = operatingCentreTrailerCap;
    }

    public int getNoOfVehiclesRequested() {
        return noOfVehiclesRequested;
    }

    public void setNoOfVehiclesRequested(int noOfVehiclesRequested) {
        this.noOfVehiclesRequested = noOfVehiclesRequested;
    }

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

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationId() {
        return applicationId;
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

    public String getTransportManagerEmailAddress() {
        return transportManagerEmailAddress;
    }

    public Integer getRestrictedVehicles() {
        return restrictedVehicles;
    }

    public void setTransportManagerEmailAddress(String transportManagerEmailAddress) {
        this.transportManagerEmailAddress = transportManagerEmailAddress;
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

    public void setRestrictedVehicles(Integer restrictedVehicles) {
        this.restrictedVehicles = restrictedVehicles;
    }

    public String getIsInterim() {
        return isInterim;
    }

    public void setIsInterim(String isInterim) {
        this.isInterim = isInterim;
    }

    public String getIsOwner() {
        return isOwner;
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

    public String getTransportManagerApplicationId() {
        return transportManagerApplicationId;
    }

    public void setTransportManagerApplicationId(String transportManagerApplicationId) {
        this.transportManagerApplicationId = transportManagerApplicationId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
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

    public String getPartnerForeName() {
        return partnerForeName;
    }

    public void setPartnerForeName(String partnerForeName) {
        this.partnerForeName = partnerForeName;
    }

    public String getPartnerFamilyName() {
        return partnerFamilyName;
    }

    public void setPartnerFamilyName(String partnerFamilyName) {
        this.partnerFamilyName = partnerFamilyName;
    }

    public String getPartnerDOB() {
        return partnerDOB;
    }

    public void setPartnerDOB(String partnerDOB) {
        this.partnerDOB = partnerDOB;
    }

    public double getHours() {
        return hours;
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

    public String getRegisteredAddressLine1() {
        return registeredAddressLine1;
    }

    public void setRegisteredAddressLine1(String registeredAddressLine1) {
        this.registeredAddressLine1 = registeredAddressLine1;
    }

    public String getRegisteredAddressLine2() {
        return registeredAddressLine2;
    }

    public void setRegisteredAddressLine2(String registeredAddressLine2) {
        this.registeredAddressLine2 = registeredAddressLine2;
    }

    public String getRegisteredAddressLine3() {
        return registeredAddressLine3;
    }

    public void setRegisteredAddressLine3(String registeredAddressLine3) {
        this.registeredAddressLine3 = registeredAddressLine3;
    }

    public String getRegisteredAddressLine4() {
        return registeredAddressLine4;
    }

    public void setRegisteredAddressLine4(String registeredAddressLine4) {
        this.registeredAddressLine4 = registeredAddressLine4;
    }

    public String getRegisteredPostCode() {
        return registeredPostCode;
    }

    public void setRegisteredPostCode(String registeredPostCode) {
        this.registeredPostCode = registeredPostCode;
    }

    public String getRegisteredTown() {
        return registeredTown;
    }

    public void setRegisteredTown(String registeredTown) {
        this.registeredTown = registeredTown;
    }



    public String getCorrespondenceAddressLine1() {
        return correspondenceAddressLine1;
    }

    public void setCorrespondenceAddressLine1(String correspondenceAddressLine1) {
        this.correspondenceAddressLine1 = correspondenceAddressLine1;
    }

    public String getCorrespondenceAddressLine2() {
        return correspondenceAddressLine2;
    }

    public void setCorrespondenceAddressLine2(String correspondenceAddressLine2) {
        this.correspondenceAddressLine2 = correspondenceAddressLine2;
    }

    public String getCorrespondenceAddressLine3() {
        return correspondenceAddressLine3;
    }

    public void setCorrespondenceAddressLine3(String correspondenceAddressLine3) {
        this.correspondenceAddressLine3 = correspondenceAddressLine3;
    }

    public String getCorrespondenceAddressLine4() {
        return correspondenceAddressLine4;
    }

    public void setCorrespondenceAddressLine4(String correspondenceAddressLine4) {
        this.correspondenceAddressLine4 = correspondenceAddressLine4;
    }

    public String getCorrespondenceTown() {
        return correspondenceTown;
    }

    public void setCorrespondenceTown(String correspondenceTown) {
        this.correspondenceTown = correspondenceTown;
    }

    public String getCorrespondencePostCode() {
        return correspondencePostCode;
    }

    public void setCorrespondencePostCode(String correspondencePostCode) {
        this.correspondencePostCode = correspondencePostCode;
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

    public String getTransportManagerAddressLine1() {
        return transportManagerAddressLine1;
    }

    public void setTransportManagerAddressLine1(String transportManagerAddressLine1) {
        this.transportManagerAddressLine1 = transportManagerAddressLine1;
    }

    public String getTransportManagerAddressLine2() {
        return transportManagerAddressLine2;
    }

    public void setTransportManagerAddressLine2(String transportManagerAddressLine2) {
        this.transportManagerAddressLine2 = transportManagerAddressLine2;
    }

    public String getTransportManagerAddressLine3() {
        return transportManagerAddressLine3;
    }

    public void setTransportManagerAddressLine3(String transportManagerAddressLine3) {
        this.transportManagerAddressLine3 = transportManagerAddressLine3;
    }

    public String getTransportManagerAddressLine4() {
        return transportManagerAddressLine4;
    }

    public void setTransportManagerAddressLine4(String transportManagerAddressLine4) {
        this.transportManagerAddressLine4 = transportManagerAddressLine4;
    }

    public String getTransportManagerTown() {
        return transportManagerTown;
    }

    public void setTransportManagerTown(String transportManagerTown) {
        this.transportManagerTown = transportManagerTown;
    }

    public String getTransportManagerPostCode() {
        return transportManagerPostCode;
    }

    public void setTransportManagerPostCode(String transportManagerPostCode) {
        this.transportManagerPostCode = transportManagerPostCode;
    }

    public String getOperatingCentreAddressLine1() {
        return operatingCentreAddressLine1;
    }

    public void setOperatingCentreAddressLine1(String operatingCentreAddressLine1) {
        this.operatingCentreAddressLine1 = operatingCentreAddressLine1;
    }

    public String getOperatingCentreAddressLine2() {
        return operatingCentreAddressLine2;
    }

    public void setOperatingCentreAddressLine2(String operatingCentreAddressLine2) {
        this.operatingCentreAddressLine2 = operatingCentreAddressLine2;
    }

    public String getOperatingCentreAddressLine3() {
        return operatingCentreAddressLine3;
    }

    public void setOperatingCentreAddressLine3(String operatingCentreAddressLine3) {
        this.operatingCentreAddressLine3 = operatingCentreAddressLine3;
    }

    public void setOperatingCentreAddressLine4(String operatingCentreAddressLine4) {
        this.operatingCentreAddressLine4 = operatingCentreAddressLine4;
    }

    public String getOperatingCentreAddressLine4() {
        return operatingCentreAddressLine4;
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

    public String getEstablishmentAddressLine1() {
        return establishmentAddressLine1;
    }

    public void setEstablishmentAddressLine1(String establishmentAddressLine1) {
        this.establishmentAddressLine1 = establishmentAddressLine1;
    }

    public String getEstablishmentAddressLine2() {
        return establishmentAddressLine2;
    }

    public void setEstablishmentAddressLine2(String establishmentAddressLine2) {
        this.establishmentAddressLine2 = establishmentAddressLine2;
    }

    public String getEstablishmentAddressLine3() {
        return establishmentAddressLine3;
    }

    public void setEstablishmentAddressLine3(String establishmentAddressLine3) {
        this.establishmentAddressLine3 = establishmentAddressLine3;
    }

    public String getEstablishmentAddressLine4() {
        return establishmentAddressLine4;
    }

    public void setEstablishmentAddressLine4(String establishmentAddressLine4) {
        this.establishmentAddressLine4 = establishmentAddressLine4;
    }

    public void setTransportManagerFirstName(String transportManagerFirstName) {
        this.transportManagerFirstName = transportManagerFirstName;
    }

    public String getTransportManagerFirstName() {
        return transportManagerFirstName;
    }

    public void setTransportManagerLastName(String transportManagerLastName) {
        this.transportManagerLastName = transportManagerLastName;
    }

    public String getTransportManagerDOB() {
        return transportManagerDOB;
    }

    public void setTransportManagerDOB(String transportManagerDOB) {
        this.transportManagerDOB = transportManagerDOB;
    }

    public String getTransportManagerLastName() {
        return transportManagerLastName;
    }

    public String getTransportConsultantAddressLine1() {
        return transportConsultantAddressLine1;
    }

    public void setTransportConsultantAddressLine1(String transportConsultantAddressLine1) {
        this.transportConsultantAddressLine1 = transportConsultantAddressLine1;
    }

    public String getTransportConsultantAddressLine2() {
        return transportConsultantAddressLine2;
    }

    public void setTransportConsultantAddressLine2(String transportConsultantAddressLine2) {
        this.transportConsultantAddressLine2 = transportConsultantAddressLine2;
    }

    public String getTransportConsultantAddressLine3() {
        return transportConsultantAddressLine3;
    }

    public void setTransportConsultantAddressLine3(String transportConsultantAddressLine3) {
        this.transportConsultantAddressLine3 = transportConsultantAddressLine3;
    }

    public String getTransportConsultantAddressLine4() {
        return transportConsultantAddressLine4;
    }

    public void setTransportConsultantAddressLine4(String transportConsultantAddressLine4) {
        this.transportConsultantAddressLine4 = transportConsultantAddressLine4;
    }

    public String getTransportConsultantTown() {
        return transportConsultantTown;
    }

    public void setTransportConsultantTown(String transportConsultantTown) {
        this.transportConsultantTown = transportConsultantTown;
    }

    public String getTransportConsultantPhone() {
        return transportConsultantPhone;
    }

    public void setTransportConsultantPhone(String transportConsultantPhone) {
        this.transportConsultantPhone = transportConsultantPhone;
    }

    public String getTransportConsultantName() {
        return transportConsultantEmail;
    }

    public void setTransportConsultantName(String transportConsultantName) {
        this.transportConsultantName = transportConsultantName;
    }

    public String getTransportConsultantEmail() {
        return transportConsultantEmail;
    }

    public void setTransportConsultantEmail(String transportConsultantEmail) {
        this.transportConsultantEmail = transportConsultantEmail;
    }

    public String getSafetyInspectorForeName() {
        return safetyInspectorForeName;
    }

    public void setSafetyInspectorForeName(String safetyInspectorForeName) {
        this.safetyInspectorForeName = safetyInspectorForeName;
    }

    public String getSafetyInspectorFamilyName() {
        return safetyInspectorFamilyName;
    }

    public void setSafetyInspectorFamilyName(String safetyInspectorFamilyName) {
        this.safetyInspectorFamilyName = safetyInspectorFamilyName;
    }

    public String getSafetyInspectorDOB() {
        return safetyInspectorDOB;
    }

    public void setSafetyInspectorDOB(String safetyInspectorDOB) {
        this.safetyInspectorDOB = safetyInspectorDOB;
    }

    public String getSafetyInspectorAddressLine1() {
        return safetyInspectorAddressLine1;
    }

    public void setSafetyInspectorAddressLine1(String safetyInspectorAddressLine1) {
        this.safetyInspectorAddressLine1 = safetyInspectorAddressLine1;
    }

    public String getSafetyInspectorAddressLine2() {
        return safetyInspectorAddressLine2;
    }

    public void setSafetyInspectorAddressLine2(String safetyInspectorAddressLine2) {
        this.safetyInspectorAddressLine2 = safetyInspectorAddressLine2;
    }

    public String getSafetyInspectorAddressLine3() {
        return safetyInspectorAddressLine3;
    }

    public void setSafetyInspectorAddressLine3(String safetyInspectorAddressLine3) {
        this.safetyInspectorAddressLine3 = safetyInspectorAddressLine3;
    }

    public String getSafetyInspectorAddressLine4() {
        return safetyInspectorAddressLine4;
    }

    public void setSafetyInspectorAddressLine4(String safetyInspectorAddressLine4) {
        this.safetyInspectorAddressLine4 = safetyInspectorAddressLine4;
    }

    public String getSafetyInspectorTown() {
        return safetyInspectorTown;
    }

    public void setSafetyInspectorTown(String safetyInspectorTown) {
        this.safetyInspectorTown = safetyInspectorTown;
    }

    public void setSafetyInspectorPostCode(String safetyInspectorPostCode) {
        this.safetyInspectorPostCode = safetyInspectorPostCode;
    }

    public String getSafetyInspectorPostCode() {
        return safetyInspectorPostCode;
    }

    public void setTransportConsultantPostCode(String transportConsultantPostCode) {
        this.transportConsultantPostCode = transportConsultantPostCode;
    }

    public String getTransportConsultantPostCode() {
        return transportConsultantPostCode;
    }

    public String getPostCodeByTrafficArea() {
        return postCodeByTrafficArea;
    }

    public void setPostCodeByTrafficArea(String postCodeByTrafficArea) {
        this.postCodeByTrafficArea = postCodeByTrafficArea;
    }

    private Headers apiHeaders = new Headers();

    public CreateApplication() {

        // Application details
        setOperatorType( OperatorType.valueOf("goods".toUpperCase()).asString() );
        setLicenceType( LicenceType.valueOf("standard_international".toUpperCase()).asString() );
        setBusinessType( BusinessType.valueOf("limited_company".toUpperCase()).asString() );
        setNiFlag( "N" );
        setIsInterim( "N" );
        setNoOfVehiclesRequested( 5 );
        setPostCodeByTrafficArea( TrafficArea.getPostCode(TrafficArea.valueOf(TrafficArea.NORTH_EAST.name())));
        setCountryCode( "GB" );

        // PSV details
        setPsvVehicleSize( "psvvs_both" );
        setPsvNoSmallVhlConfirmation( "Y" );
        setPsvOperateSmallVhl( "Y" );
        setPsvSmallVhlNotes( "submitted through the API" );
        setPsvLimousines( "Y" );
        setPsvNoLimousineConfirmation( "Y" );
        setPsvOnlyLimousinesConfirmation( "Y" );

        // Business details

        // // Business general details
        setBusinessName( faker.generateCompanyName() );
        setCompanyNumber( String.valueOf(Int.random(00000000, 99999999)) );
        setNatureOfBusiness( faker.generateNatureOfBusiness() );
        setBusinessEmailAddress( getBusinessName().replace(" ", "_").replace(",", "").concat(".volBusiness@dvsa.com") );
        setPhoneNumber( "0712345678" );

        // // Registered Business Address details
        LinkedHashMap<String, String> generatedRegisteredAddress = faker.generateAddress();
        setRegisteredAddressLine1( generatedRegisteredAddress.get("addressLine1") );
        setRegisteredAddressLine2( generatedRegisteredAddress.get("addressLine2") );
        setRegisteredAddressLine3( generatedRegisteredAddress.get("addressLine3") );
        setRegisteredAddressLine4( generatedRegisteredAddress.get("addressLine4") );
        setRegisteredTown( generatedRegisteredAddress.get("town") );
        setRegisteredPostCode( faker.getRandomRealUKPostcode() );

        // // Correspondence Address details
        LinkedHashMap<String, String> generatedCorrespondenceAddress = faker.generateAddress();
        setCorrespondenceAddressLine1( generatedCorrespondenceAddress.get("addressLine1") );
        setCorrespondenceAddressLine2( generatedCorrespondenceAddress.get("addressLine2") );
        setCorrespondenceAddressLine3( generatedCorrespondenceAddress.get("addressLine3") );
        setCorrespondenceAddressLine4( generatedCorrespondenceAddress.get("addressLine4") );
        setCorrespondenceTown( generatedCorrespondenceAddress.get("town") );
        setCorrespondencePostCode( faker.getRandomRealUKPostcode() );

        // // Establishment Address details
        LinkedHashMap<String, String> generatedEstablishmentAddress = faker.generateAddress();
        setEstablishmentAddressLine1( generatedEstablishmentAddress.get("addressLine1") );
        setEstablishmentAddressLine2( generatedEstablishmentAddress.get("addressLine2") );
        setEstablishmentAddressLine3( generatedEstablishmentAddress.get("addressLine3") );
        setEstablishmentAddressLine4( generatedEstablishmentAddress.get("addressLine4") );
        setEstablishmentTown( generatedEstablishmentAddress.get("town") );
        setEstablishmentPostCode( faker.getRandomRealUKPostcode() );

        // Partner details
        setPartnerForeName( faker.generateFirstName().concat(String.valueOf(Int.random(100, 999))) );
        setPartnerFamilyName( faker.generateLastName().concat(String.valueOf(Int.random(100, 999))) );
        setPartnerDOB( Int.random(1900, 2018) + "-" + Int.random(1, 12) + "-" + Int.random(1, 28) );

        // Operating Centre details
        LinkedHashMap<String, String> generatedOperatingCentreAddress = faker.generateAddress();
        setOperatingCentreAddressLine1( generatedOperatingCentreAddress.get("addressLine1") );
        setOperatingCentreAddressLine2( generatedOperatingCentreAddress.get("addressLine2") );
        setOperatingCentreAddressLine3( generatedOperatingCentreAddress.get("addressLine3") );
        setOperatingCentreAddressLine4( generatedOperatingCentreAddress.get("addressLine4") );
        setOperatingCentreTown( generatedOperatingCentreAddress.get("town") );
        setOperatingCentrePostCode( faker.getRandomRealUKPostcode() );
        setOperatingCentreVehicleCap( 5 );
        setOperatingCentreTrailerCap( 5 );
        setRestrictedVehicles( 2 );
        setTrafficArea( TrafficArea.NORTH_EAST.asString() );
        setEnforcementArea( EnforcementArea.NORTH_EAST.asString() );

        // Transport Manager details
        String generatedTransportManagerFirstName = faker.generateFirstName().concat(String.valueOf(Int.random(100, 999)));
        String generatedTransportManagerLastName = faker.generateLastName().concat(String.valueOf(Int.random(100, 999)));
        LinkedHashMap<String, String> generatedTransportManagerAddress = faker.generateAddress();
        setTransportManagerFirstName( generatedTransportManagerFirstName );
        setTransportManagerLastName( generatedTransportManagerLastName );
        setTransportManagerEmailAddress( String.format("%s %s", generatedTransportManagerFirstName, generatedTransportManagerLastName)
                .replace(" ", "_").replace(",", "").concat(".volTransportManager@dvsa.com") );
        setTransportManagerDOB( Int.random(1900, 2018) + "-" + Int.random(1, 12) + "-" + Int.random(1, 28) );
        setHours( 2.0 );
        setIsOwner( getIsOwner() == null ? "Y" : getIsOwner() );
        setTransportManagerAddressLine1( generatedTransportManagerAddress.get("AddressLine1") );
        setTransportManagerAddressLine2( generatedTransportManagerAddress.get("AddressLine2") );
        setTransportManagerAddressLine3( generatedTransportManagerAddress.get("AddressLine3") );
        setTransportManagerAddressLine4( generatedTransportManagerAddress.get("AddressLine4") );
        setTransportManagerTown( generatedTransportManagerAddress.get("town") );
        setTransportManagerPostCode( faker.getRandomRealUKPostcode() );

        // Safety Inspector Address details
        LinkedHashMap<String, String> generatedSafetyInspectorAddress = faker.generateAddress();
        setSafetyInspectorForeName( faker.generateFirstName().concat(String.valueOf(Int.random(100, 999))) );
        setSafetyInspectorFamilyName( faker.generateFirstName().concat(String.valueOf(Int.random(100, 999))) );
        setSafetyInspectorAddressLine1( generatedSafetyInspectorAddress.get("addressLine1") );
        setSafetyInspectorAddressLine2( generatedSafetyInspectorAddress.get("addressLine2") );
        setSafetyInspectorAddressLine3( generatedSafetyInspectorAddress.get("addressLine3") );
        setSafetyInspectorAddressLine4( generatedSafetyInspectorAddress.get("addressLine4") );
        setSafetyInspectorTown( generatedSafetyInspectorAddress.get("addressLine4") );
        setSafetyInspectorPostCode( faker.getRandomRealUKPostcode() );

        // Transport Consultant details
        String generatedTransportConsultantName = String.format("%s %s", faker.generateFirstName(), faker.generateLastName());
        setTransportConsultantName( getTransportConsultantName() == null ? generatedTransportConsultantName : getTransportConsultantName() );
        setTransportConsultantEmail( generatedTransportConsultantName.replace(" ", "_").replace(",", "")
                .concat(".volTransportConsultant@dvsa.com") );

        // Transport Consultant Address details
        LinkedHashMap<String, String> transportConsultantAddress = faker.generateAddress();
        setTransportConsultantAddressLine1( transportConsultantAddress.get("addressLine1") );
        setTransportConsultantAddressLine2( transportConsultantAddress.get("addressLine2") );
        setTransportConsultantAddressLine3( transportConsultantAddress.get("addressLine3") );
        setTransportConsultantAddressLine4( transportConsultantAddress.get("addressLine4") );
        setTransportConsultantTown( faker.generateAddress().get("town") );
        setTransportConsultantPostCode( faker.getRandomRealUKPostcode() );
    }

    public ValidatableResponse startApplication() {
        String createApplicationResource = URL.build(env, "application").toString();
        apiHeaders.headers.put("x-pid", pid);

        ApplicationBuilder applicationBuilder = new ApplicationBuilder().withOperatorType(getOperatorType())
                .withLicenceType(getLicenceType()).withNiFlag(getNiFlag()).withOrganisation(getOrganisationId());
        apiResponse = RestUtils.post(applicationBuilder, createApplicationResource, apiHeaders.getHeaders());
        setApplicationId(apiResponse.extract().jsonPath().getString("id.application"));
        setLicenceId(apiResponse.extract().jsonPath().getString("id.licence"));

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addBusinessType() {
        String organisationVersion = fetchApplicationInformation(getApplicationId(), "licence.organisation.version", "1");
        String updateBusinessTypeResource = URL.build(env, String.format("organisation/%s/business-type/", getOrganisationId())).toString();

        BusinessTypeBuilder businessTypeBuilder = new BusinessTypeBuilder().withBusinessType(getBusinessType()).withVersion(organisationVersion)
                .withId(getOrganisationId()).withApplication(getApplicationId());
        apiResponse = RestUtils.put(businessTypeBuilder, updateBusinessTypeResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addBusinessDetails() {
        String organisationVersion = fetchApplicationInformation(getApplicationId(), "licence.organisation.version", "1");
        String updateBusinessDetailsResource = URL.build(env, String.format("organisation/business-details/application/%s", getApplicationId())).toString();

        AddressBuilder address = new AddressBuilder().withAddressLine1(registeredAddressLine1).withAddressLine2(registeredAddressLine2).withAddressLine3(registeredAddressLine3)
                .withAddressLine4(registeredAddressLine4).withTown(registeredTown).withPostcode(registeredPostCode);
        UpdateBusinessDetailsBuilder businessDetails = new UpdateBusinessDetailsBuilder()
                .withId(getApplicationId()).withCompanyNumber(getCompanyNumber()).withNatureOfBusiness(getNatureOfBusiness()).withLicence(getLicenceId())
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
        String applicationAddressResource = URL.build(env, String.format("application/%s/addresses/", getApplicationId())).toString();

        ContactDetailsBuilder contactDetailsBuilder = new ContactDetailsBuilder().withPhoneNumber(getPhoneNumber()).withEmailAddress(getBusinessEmailAddress());

        AddressBuilder correspondenceAddress = new AddressBuilder().withAddressLine1(getCorrespondenceAddressLine1()).withAddressLine2(getCorrespondenceAddressLine2()).withAddressLine3(getCorrespondenceAddressLine3())
                .withAddressLine4(getCorrespondenceAddressLine4()).withTown(getCorrespondenceTown()).withPostcode(correspondencePostCode).withCountryCode(countryCode);

        AddressBuilder establishmentAddress = new AddressBuilder().withAddressLine1(establishmentAddressLine1).withAddressLine2(establishmentAddressLine2).withAddressLine3(establishmentAddressLine3)
                .withAddressLine4(establishmentAddressLine4).withTown(establishmentTown).withPostcode(establishmentPostCode).withCountryCode(countryCode);

        AddressBuilder transportConsultantAddress = new AddressBuilder().withAddressLine1(transportConsultantAddressLine1).withAddressLine2(transportConsultantAddressLine2).withAddressLine3(transportConsultantAddressLine3)
                .withAddressLine4(transportConsultantAddressLine4).withTown(transportConsultantTown).withPostcode(postcode).withCountryCode(countryCode);

        ContactDetailsBuilder transportConsultantContact = new ContactDetailsBuilder().withPhoneNumber(transportConsultantPhone).withEmailAddress(transportConsultantEmail);

        TransportConsultantBuilder transportConsultant = new TransportConsultantBuilder().withConfirmation("Y").withAddress(transportConsultantAddress).withName(transportConsultantName)
                .withWrittenPermissionToEngage("Y").withContact(transportConsultantContact);

        ApplicationAddressBuilder addressBuilder = new ApplicationAddressBuilder().withId(applicationId).withContact(contactDetailsBuilder)
                .withCorrespondenceAddress(correspondenceAddress).withEstablishmentAddress(establishmentAddress).withConsultant(transportConsultant);

        apiResponse = RestUtils.put(addressBuilder, applicationAddressResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addPartners() {
        String addPersonResource = URL.build(env, String.format("application/%s/people/", getApplicationId())).toString();
        PersonBuilder addPerson = new PersonBuilder().withId(getApplicationId()).withTitle(getTitle())
                .withForename(getPartnerForeName()).withFamilyName(getPartnerFamilyName()).withBirthDate(getPartnerDOB());
        apiResponse = RestUtils.post(addPerson, addPersonResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }

    public ValidatableResponse addOperatingCentre() {
        if (licenceType.equals(LicenceType.SPECIAL_RESTRICTED.asString())) {
            return null;
        }
        String operatingCentreResource = URL.build(env, String.format("application/%s/operating-centre/", getApplicationId())).toString();
        String permissionOption = "Y";

        AddressBuilder address = new AddressBuilder().withAddressLine1(getOperatingCentreAddressLine1()).withAddressLine2(getOperatingCentreAddressLine2()).
                withAddressLine3(getOperatingCentreAddressLine3()).withAddressLine4(getOperatingCentreAddressLine4()).withTown(getOperatingCentreTown())
                .withPostcode(getOperatingCentrePostCode()).withCountryCode(getCountryCode());

        OperatingCentreBuilder operatingCentreBuilder = new OperatingCentreBuilder().withApplication(getApplicationId()).withPermission(permissionOption).withAddress(address);

        if (operatorType.equals("goods")) {
            operatingCentreBuilder.withNoOfVehiclesRequired(String.valueOf(getOperatingCentreVehicleCap()))
                    .withNoOfTrailersRequired(String.valueOf(getOperatingCentreTrailerCap()));
        }
        if (operatorType.equals("public") && (licenceType.contains("standard"))) {
            operatingCentreBuilder.withNoOfVehiclesRequired(String.valueOf(getOperatingCentreVehicleCap()));
        }
        if (operatorType.equals("public") && (licenceType.equals("restricted"))) {
            operatingCentreBuilder.withNoOfVehiclesRequired(String.valueOf(getRestrictedVehicles()));
        }
        apiResponse = RestUtils.post(operatingCentreBuilder, operatingCentreResource, apiHeaders.getHeaders());

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
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationId(), "version", "1"));
        String updateOperatingCentreResource = URL.build(env, String.format("application/%s/operating-centres", getApplicationId())).toString();
        OperatingCentreUpdater updateOperatingCentre = new OperatingCentreUpdater().withId(getApplicationId())
                .withTrafficArea(getTrafficArea()).withEnforcementArea(getEnforcementArea()).withVersion(applicationVersion);

        if (operatorType.equals(OperatorType.GOODS.asString())) {
            updateOperatingCentre.withTotAuthVehicles(getOperatingCentreVehicleCap())
                    .withTotCommunityLicences(1)
                    .withTAuthTrailers(getOperatingCentreVehicleCap());
        }
        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (!licenceType.equals(LicenceType.RESTRICTED.asString()))) {
            updateOperatingCentre.withTotAuthVehicles(getOperatingCentreVehicleCap())
                    .withTotCommunityLicences(1);
        }

        if (operatorType.equals(OperatorType.PUBLIC.asString()) && (licenceType.equals(LicenceType.RESTRICTED.asString()))) {
            updateOperatingCentre.withTotAuthVehicles(getRestrictedVehicles());
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

        String financialEvidenceResource = URL.build(env, String.format("application/%s/financial-evidence", getApplicationId())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationId(), "version", "1"));

        FinancialEvidenceBuilder financialEvidenceBuilder = new FinancialEvidenceBuilder().withId(getApplicationId())
                .withVersion(applicationVersion).withFinancialEvidenceUploaded(0);
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
        tmUserName = "apiTM".concat(faker.generateFirstName()).concat(String.valueOf(Int.random(0, 2000)));
        String hasEmail = "Y";
        String addTransportManager = URL.build(env, "transport-manager/create-new-user/").toString();
        TransportManagerBuilder transportManagerBuilder = new TransportManagerBuilder().withApplication(getApplicationId()).withFirstName(transportManagerFirstName)
                .withFamilyName(transportManagerLastName).withHasEmail(hasEmail).withUsername(getTmUserName()).withEmailAddress(getTransportManagerEmailAddress())
                .withBirthDate(getTransportManagerDOB());
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
        int TMApplicationVersion = Integer.parseInt(fetchTMApplicationInformation(getTransportManagerApplicationId(), "version", "1"));
        String submitTransportManager = URL.build(env, String.format("transport-manager-application/%s/submit", getTransportManagerApplicationId())).toString();
        GenericBuilder genericBuilder = new GenericBuilder().withId(transportManagerApplicationId).withVersion(TMApplicationVersion);
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
        String addTMresp = URL.build(env, String.format("transport-manager-application/%s/update-details/", getTransportManagerApplicationId())).toString();
        int TMApplicationVersion = Integer.parseInt(fetchTMApplicationInformation(getTransportManagerApplicationId(), "version", "1"));
        AddressBuilder Address = new AddressBuilder().withAddressLine1(getTransportManagerAddressLine1()).withAddressLine2(getTransportManagerAddressLine2()).withAddressLine3(getTransportManagerAddressLine3())
                .withAddressLine4(getTransportManagerAddressLine4()).withTown(getTransportManagerTown()).withPostcode(getTransportManagerPostCode()).withCountryCode(countryCode);
        TmRespBuilder tmRespBuilder = new TmRespBuilder().withEmail(getTransportManagerEmailAddress()).withPlaceOfBirth(getTown()).withHomeAddress(Address).withWorkAddress(Address).withTmType(getTmType()).withIsOwner(isOwner)
                .withHoursMon(hours).withHoursTue(hours).withHoursWed(hours).withHoursThu(hours).withHoursThu(hours).withHoursFri(hours).withHoursSat(hours).withHoursSun(hours).withDob(getTransportManagerDOB())
                .withId(getTransportManagerApplicationId()).withVersion(TMApplicationVersion);

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
        String submitTmResp = URL.build(env, String.format("transport-manager-application/%s/submit", getTransportManagerApplicationId())).toString();
        int TMApplicationVersion = Integer.parseInt(fetchTMApplicationInformation(getTransportManagerApplicationId(), "version", "1"));

        GenericBuilder genericBuilder = new GenericBuilder().withId(transportManagerApplicationId).withVersion(TMApplicationVersion);
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
        if (getNoOfVehiclesRequested() > getOperatingCentreVehicleCap()) {
            throw new ValueException("Cannot have more than the specified amount of vehicles on an operating centre.");
        }
        String vehiclesResource = null;
        String vrm;

        String operatorType = getOperatorType().equals(OperatorType.GOODS.asString()) ? "goods" : "psv";
        vehiclesResource = URL.build(env, String.format("application/%s/%s-vehicles", getApplicationId(), operatorType)).toString();

        // TODO: Might need to add 'make' to the API builder because DVLA pulls this as well
        do {
            for (int i = 0; i < noOfVehiclesRequested; i++) {
                vrm = Str.randomWord(2).concat(String.valueOf(Int.random(10, 99)).concat(Str.randomWord(3)))
                        .toLowerCase();
                VehiclesBuilder vehiclesDetails = new VehiclesBuilder().withId(getApplicationId()).withApplication(getApplicationId()).withHasEnteredReg("Y").withVrm(vrm)
                        .withPlatedWeight(String.valueOf(Int.random(1, 9999))).withVersion(version);
                assert vehiclesResource != null;
                apiResponse = RestUtils.post(vehiclesDetails, vehiclesResource, apiHeaders.getHeaders());
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

        String vehicleDeclarationResource = URL.build(env, String.format(String.format("application/%s/vehicle-declaration", applicationId))).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationId(), "version", "1"));

        VehicleDeclarationBuilder vehicleDeclarationBuilder = new VehicleDeclarationBuilder().withId(getApplicationId()
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
        String financialHistoryResource = URL.build(env, String.format("application/%s/financial-history", getApplicationId())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationId(), "version", "1"));

        FinancialHistoryBuilder financialHistoryBuilder = new FinancialHistoryBuilder().withId(getApplicationId()).withVersion(String.valueOf(applicationVersion)).withBankrupt(financialHistoryAnswer)
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
        String applicationSafetyResource = URL.build(env, String.format("application/%s/safety", getApplicationId())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationId(), "version", "1"));

        LicenceBuilder licence = new LicenceBuilder().withId(getLicenceId()).withVersion(version).withSafetyInsVaries(safetyInsVaries).withSafetyInsVehicles(String.valueOf(operatingCentreVehicleCap))
                .withSafetyInsTrailers(String.valueOf(operatingCentreVehicleCap)).withTachographIns(tachographIns);
        ApplicationSafetyBuilder applicationSafetyBuilder = new ApplicationSafetyBuilder().withId(getApplicationId()).withVersion(applicationVersion)
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
        String safetyInspectorResource = URL.build(env, String.format("application/%s/workshop", getApplicationId())).toString();
        AddressBuilder addressBuilder = new AddressBuilder().withAddressLine1(safetyInspectorAddressLine1).withAddressLine2(safetyInspectorAddressLine2).withAddressLine3(safetyInspectorAddressLine3)
                .withAddressLine4(safetyInspectorAddressLine4).withTown(safetyInspectorTown).withPostcode(safetyInspectorPostCode).withCountryCode(countryCode);
        ContactDetailsBuilder contactDetailsBuilder = new ContactDetailsBuilder().withFullName(String.format("%s %s", safetyInspectorForeName, safetyInspectorFamilyName)).withAddress(addressBuilder);
        SafetyInspectorBuilder safetyInspectorBuilder = new SafetyInspectorBuilder().withApplication(applicationId).withLicence(getLicenceId()).withIsExternal("N")
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
        String previousConvictionsResource = URL.build(env, String.format("application/%s/previous-convictions", applicationId)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationId, "version", "1"));

        CaseConvictionsPenaltiesBuilder convictionsPenaltiesBuilder = new CaseConvictionsPenaltiesBuilder().withId(applicationId).withConvictionsConfirmation("Y")
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
        String licenceHistoryResource = URL.build(env, String.format("application/%s/licence-history", applicationId)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationId, "version", "1"));

        LicenceHistoryBuilder licenceHistoryBuilder = new LicenceHistoryBuilder().withId(applicationId).withPrevHadLicence(optionResponse).withPrevHasLicence(optionResponse)
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
            String submitResource = URL.build(env, String.format("application/%s/taxi-phv", getApplicationId())).toString();
            AddressBuilder addressBuilder = new AddressBuilder().withAddressLine1(correspondenceAddressLine1).withTown(town).withPostcode(postCodeByTrafficArea).withCountryCode(countryCode);
            PhvTaxiBuilder taxiBuilder = new PhvTaxiBuilder().withId(applicationId).withPrivateHireLicenceNo(phLicenceNumber).withCouncilName(councilName).withLicence(getLicenceId()).withAddress(addressBuilder);
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
        String reviewResource = URL.build(env, String.format("application/%s/declaration/", getApplicationId())).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(getApplicationId(), "version", "1"));

        if (operatorType.equals("goods") && (getIsInterim().equals("Y"))) {
            undertakings.withId(getApplicationId()).withVersion(String.valueOf(applicationVersion)).withInterimRequested(getIsInterim())
                    .withInterimReason(interimReason).withSignatureType(signatureRequired).withDeclarationConfirmation(declarationConfirmation);
        } else {
            undertakings.withId(getApplicationId()).withVersion(String.valueOf(applicationVersion))
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
        String submitResource = URL.build(env, String.format("application/%s/submit", applicationId)).toString();
        int applicationVersion = Integer.parseInt(fetchApplicationInformation(applicationId, "version", "1"));

        GenericBuilder genericBuilder = new GenericBuilder().withId(applicationId).withVersion(applicationVersion);
        apiResponse = RestUtils.put(genericBuilder, submitResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }
}