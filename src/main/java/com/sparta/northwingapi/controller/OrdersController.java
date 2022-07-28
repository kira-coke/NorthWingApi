package com.sparta.northwingapi.controller;


import com.sparta.northwingapi.entity.OrderEntity;
import com.sparta.northwingapi.repository.OrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    OrderEntityRepository repo;


    @GetMapping("/orders/{id}")
    public OrderEntity getOrderByID(@PathVariable int id){
        return repo.getReferenceById(id);

    }

}
