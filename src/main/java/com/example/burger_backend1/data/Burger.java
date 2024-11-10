package com.example.burger_backend1.data;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String ingredients;
    public double price;
    public String photoName;

    public Burger (String name, String ingredients, double price, String photoName) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.photoName = photoName;
    }

    public Burger() {

    }
}
