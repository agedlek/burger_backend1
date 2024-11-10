package com.example.burger_backend1.data;

import jakarta.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    public long id;
    public String name;
    public double price;
    public int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    public BurgerOrder order;

    public OrderLine() {
    }

    public OrderLine(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setOrder(BurgerOrder order) {
        this.order = order;
    }
}
