package other.joda;

public enum NOEnum {
    /**
     * 主订单流水号
     */
    RENT(1, "ON"),
    /**
     * 收支明细流水号
     */
    BALANCE(2, "BN");

    private int type;
    private String value;

    NOEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
