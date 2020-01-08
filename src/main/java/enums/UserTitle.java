package enums;

public enum UserTitle {

    MR("title_mr"),
    MRS("title_mrs"),
    MS("title_ms");

    private final String userTitles;

    private UserTitle(String userTitles) {
        this.userTitles = userTitles;
    }

    public String asString() {
        return userTitles;
    }
}