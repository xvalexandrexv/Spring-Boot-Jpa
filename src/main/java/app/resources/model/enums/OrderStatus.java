package app.resources.model.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    // como estamos a difinir index a pata como podemos ver acima, temos que criar um contrutor.

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    // agora precisamos converter um valor numerico para enumerado.

    public static OrderStatus valueOf(int code) {
        for(OrderStatus value: OrderStatus.values()) { // esser OrderSatues.values percorre todos os valors do
            // orderstatus sendo eles WAITING_PAYMENT, PAID, etc...
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid order status code!");
    }
}
