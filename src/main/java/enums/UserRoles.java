package enums;

public enum UserRoles {

    INTERNAL_ADMIN("internal-admin"),
    INTERNAL_LIMITED_READ_ONLY("internal-limited-read-only"),
    INTERNAL_READ_ONLY("internal-read-only"),
    INTERNAL_CASE_WORKER("internal-case-worker");

    private final String userRoles;

    private UserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    public String asString() {
        return userRoles;
    }
}