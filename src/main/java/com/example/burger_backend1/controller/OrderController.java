package com.example.burger_backend1.controller;
import com.example.burger_backend1.data.*;
import com.example.burger_backend1.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.burger_backend1.dto.LineDto;

import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    private BurgerOrderRepository burgerOrderRepo;

    @PostMapping("/new")
    public ResponseEntity<String> addOrder(@RequestBody OrderDto dto){

        BurgerOrder order = new BurgerOrder(dto.orderName, dto.orderSurname, dto.orderPhone, dto.orderAddress, dto.orderComments);
        for (LineDto lineDto:  dto.orderLines){
            OrderLine line = new OrderLine(lineDto.name, lineDto.price, lineDto.quantity);
            order.addOrderLine(line);
        }
        burgerOrderRepo.save(order);

        return ResponseEntity.ok(order.id.toString());
    }

    @GetMapping("/{id}")
    public Optional<BurgerOrder> getOrder(@PathVariable UUID id){
        return  burgerOrderRepo.findById(id);

    }


}
