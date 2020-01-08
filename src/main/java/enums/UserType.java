package enums;

public enum UserType {

    INTERNAL("internal"),
    EXTERNAL("selfserve");

    private final String userTypes;

    private UserType(String userType) {
        this.userTypes = userType;
    }

    public String asString() {
        return userTypes;
    }
}