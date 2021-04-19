package apiCalls.Utils.eupaBuilders.external.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import org.jetbrains.annotations.NotNull;

public enum BusinessType {
    LimitedCompany("org_t_rc"),
    SoleTrader("org_t_st"),
    Partnership("org_t_p"),
    LimitedPartnership("org_t_llp"),
    Other("org_t_pa");

    private String name;

    BusinessType(String name){
        this.name = name;
    }

    @Override
    @JsonValue
    public String toString() {
        return name;
    }

    public static BusinessType getEnum(@NotNull String businessType){
        BusinessType businessTypeEnum;

        switch(businessType.toLowerCase()){
            case "org_t_rc":
                businessTypeEnum = LimitedCompany;
                break;
            case "org_t_st":
                businessTypeEnum = SoleTrader;
                break;
            case "org_t_p":
                businessTypeEnum = Partnership;
                break;
            case "org_t_llp":
                businessTypeEnum = LimitedPartnership;
                break;
            case "org_t_pa":
                businessTypeEnum = Other;
                break;
            default:
                throw new IllegalArgumentException("[ERROR] Unable to convert " + businessType + " into a BusinessType enum");
        }

        return businessTypeEnum;
    }
}
