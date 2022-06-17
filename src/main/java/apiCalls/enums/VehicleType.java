package apiCalls.enums;

public enum VehicleType {
    MIXED_FLEET("app_veh_type_mixed"),
    LGV_ONLY_FLEET("app_veh_type_lgv");

    private final String vehicleTypes;

    private VehicleType(String vehicleTypes){
        this.vehicleTypes = vehicleTypes;
    }

    public String asString() {
        return vehicleTypes;
    }
}