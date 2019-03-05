package other.Enum枚举对象;

public enum OrderTypeEnum {
    MAIN_ORDER(1, "主订单"),
    ORDER_PRODUCT(2, "订单商品单"),
    RELET_ORDER(3, "续租单"),
    RETURN_ORDER(4, "退/还货单");

    private Integer type;
    private String name;

    private OrderTypeEnum(Integer type, String b) {
        this.type = type;
        this.name = b;
    }
}
