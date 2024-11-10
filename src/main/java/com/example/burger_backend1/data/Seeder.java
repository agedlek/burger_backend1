package com.example.burger_backend1.data;
import com.example.burger_backend1.data.Burger;
import com.example.burger_backend1.data.BurgerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    private BurgerRepository burgerRepository;

    @Override
    public void run(String... args) throws Exception {

        if (burgerRepository.count() == 0) {

            Burger[] burgers = {
                    new Burger(
                            "Classic Burger",
                            "wołowina 100% 200g, sałata lodowa, pomidor malinowy, czerwona cebula, ogórek piklowany",
                            35,
                            "http://localhost:8081/menu/image/classicburger"
                    ),
                    new Burger(
                            "Cheeseburger",
                            "wołowina 100% 200g, sałata lodowa, pomidor malinowy, czerwona cebula, ogórek piklowany, ser cheddar",
                            37,
                            "http://localhost:8081/menu/image/cheeseburger"
                    ),
                    new Burger(
                            "Bacon Burger",
                            "wołowina 100% 200g, krążki cebulowe 3szt. (onion rings), 2x ser cheddar, 2x bekon, prażona cebulka",
                            44,
                            "http://localhost:8081/menu/image/baconburger"
                    ),
                    new Burger(
                            "Crispy Chicken",
                            "kurczak 100% 200g w panierze, sałata lodowa, pomidor malinowy, czerwona cebula, ogórek piklowany, ser cheddar, bekon, prażona cebulka",
                            41,
                            "http://localhost:8081/menu/image/crispychicken"
                    ),
                    new Burger(
                            "Mexico Burger",
                            "wołowina 100% 200g, sałata lodowa, pomidor malinowy, czerwona cebula, nachos, jalapeno",
                            39,
                            "http://localhost:8081/menu/image/mexicoburger"
                    ),
                    new Burger(
                            "Vege Burger",
                            "kotlet z grillowanych warzyw, sałata lodowa, pomidor malinowy, czerwona cebula, ogórek piklowany, dodatkowy ser cheddar",
                            49,
                            "http://localhost:8081/menu/image/wegeburger"
                    ),
            };
            burgerRepository.saveAll(Arrays.asList(burgers));
        }
    }
}