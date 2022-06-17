package apiCalls.enums;

public enum Realm {
    SELF_SERVE("selfserve"),
    INTERNAL("internal");

    private final String serviceType;

    private Realm(String serviceType){
        this.serviceType = serviceType;
    }

    public String asString() {
        return serviceType;
    }
}