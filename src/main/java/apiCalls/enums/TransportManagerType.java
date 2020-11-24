package apiCalls.enums;

public enum TransportManagerType {
    INTERNAL("tm_t_e"),
    EXTERNAL("tm_t_i");

    private final String transportManagerType;

    private TransportManagerType(String transportManagerType){
        this.transportManagerType = transportManagerType;
    }

    public String asString(){
        return transportManagerType;
    }
}