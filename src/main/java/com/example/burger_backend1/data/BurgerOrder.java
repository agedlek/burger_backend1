package com.example.burger_backend1.data;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Entity
public class BurgerOrder {
    @Id
    @GeneratedValue()
    public UUID id;
    public String orderName;
    public String orderSurname;
    public String orderPhone;
    public String orderAddress;
    public String orderComments;

    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderLine> orderLines = new ArrayList<OrderLine>();

    public BurgerOrder(String orderName, String orderSurname, String orderPhone, String orderAddress, String orderComments) {
        this.orderName = orderName;
        this.orderSurname = orderSurname;
        this.orderPhone = orderPhone;
        this.orderAddress = orderAddress;
        this.orderComments = orderComments;
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
        orderLine.setOrder(this);
    }

    public BurgerOrder() {

    }
}