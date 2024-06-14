package app.resources.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    // formatar horario
    private Instant moment; // antes era o Date apartir das versoes superiors a 8 do java o instant e melhor

    private Integer orderStatus;
    @ManyToOne //
    // deps de dizer que o client e uma chave estrangeira na base de dados ou na tabela user
    // agora definimos o nome da coluna
    @JoinColumn(name = "client_id")
    private User client; // cria uma tabela "client_id" com chave estrangeira nesta tabela, Order.

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment; // um pedido tem um pagamento;

    @OneToMany(mappedBy = "id.order") // é id.order pq o orterItem possui um Id linha 15, e por sua vez o OrderItemPk possui o order linha 18...
    private Set<OrderItem> items = new HashSet<>();

    public Order() {

    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
