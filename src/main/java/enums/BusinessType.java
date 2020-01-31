package enums;

public enum BusinessType {

    LIMITED_COMPANY("org_t_rc"),
    SOLE_TRADER("org_t_st"),
    PARTNERSHIP("org_t_p"),
    LIMITED_PARTNERSHIP("org_t_llp"),
    OTHER(" org_t_pa");

    private final String businessTypes;

    private BusinessType(String businessTypes){
        this.businessTypes = businessTypes;
    }

    public String asString() {
        return businessTypes;
    }
}