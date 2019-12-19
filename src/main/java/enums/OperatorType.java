package enums;

public enum OperatorType {

    GOODS("lcat_gv"),
    PUBLIC("lcat_psv");

    private final String operatorTypes;

    private OperatorType(String operatorType) {
        this.operatorTypes = operatorType;
    }

    public String asString() {
        return operatorTypes;
    }
}