package apiCalls.enums;

public enum LicenceType {

    RESTRICTED("ltyp_r"),
    STANDARD_NATIONAL("ltyp_sn"),
    STANDARD_INTERNATIONAL("ltyp_si"),
    STANDARD_RESTRICTED("ltyp_sr");

    private final String licenceTypes;

    private LicenceType(String licenceTypes){
        this.licenceTypes = licenceTypes;
    }

    public String asString() {
        return licenceTypes;
    }
}