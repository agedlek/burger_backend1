package com.example.burger_backend1.controller;

import com.example.burger_backend1.data.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.burger_backend1.data.Burger;
import java.util.List;
@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:3000")
public class BurgerController {

    @Autowired
private BurgerRepository burgerRepo;
    @Autowired
private ResourceLoader resourceLoader;

    @GetMapping("/all")
    public List<Burger> getMenu(){


        return burgerRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));

    }

    @GetMapping("/image/{name}")
  public ResponseEntity<Resource> getBurgerImage(@PathVariable String name){
        Resource resource = resourceLoader.getResource("classpath:burgers/"+name+".JPG");
        return ResponseEntity.ok().body(resource);
  }



}
