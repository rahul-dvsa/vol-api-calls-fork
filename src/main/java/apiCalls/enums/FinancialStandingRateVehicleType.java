package apiCalls.enums;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public enum FinancialStandingRateVehicleType {
    NA("fin_sta_veh_typ_na"),
    HGV("fin_sta_veh_typ_hgv"),
    LGV("fin_sta_veh_typ_lgv");

    private final String vehicleTypes;

    FinancialStandingRateVehicleType(String vehicleTypes){
        this.vehicleTypes = vehicleTypes;
    }

    public String asString() {
        return vehicleTypes;
    }

    public static FinancialStandingRateVehicleType getEnum(@NotNull String name) {
        return Arrays.stream(FinancialStandingRateVehicleType.values()).filter(status -> status.asString().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Unable to convert to enum, name: ".concat(name)));
    }
}
