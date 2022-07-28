package com.sparta.northwingapi.controller;


import com.sparta.northwingapi.dto.OrderEntityDto;
import com.sparta.northwingapi.entity.EmployeeEntity;
import com.sparta.northwingapi.entity.OrderEntity;
import com.sparta.northwingapi.repository.OrderEntityRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrderEntityRepository repo;


    @GetMapping("/orders/{id}")
    public OrderEntityDto getOrderByID(@PathVariable int id){
        OrderEntityDto dto = new OrderEntityDto(repo.getReferenceById(id));
        return dto;
    }

    @GetMapping("/orders/all")
    public List<OrderEntityDto> getAllOrders(){
        List<OrderEntity> list = repo.findAll();
        List<OrderEntityDto> listToReturn = new ArrayList<>();
        for(OrderEntity e : list){
            listToReturn.add(new OrderEntityDto(e));
        }
        return listToReturn;
    }

    @GetMapping("/orders/employee/{id}")
    public List<OrderEntityDto> getAllOrdersByEmployeeID(@PathVariable EmployeeEntity id){
        List<OrderEntity> list = repo.findAllByEmployeeID(id);
        List<OrderEntityDto> listToReturn = new ArrayList<>();
        for(OrderEntity e : list){
            listToReturn.add(new OrderEntityDto(e));
        }
        return listToReturn;
    }

    @GetMapping("/orders/ship_city/{city}")
    public List<OrderEntityDto> getAllOrdersByCity(@PathVariable String city){
        List<OrderEntity> list = repo.findOrderEntitiesByShipCity(city);
        List<OrderEntityDto> listToReturn = new ArrayList<>();
        for(OrderEntity e : list){
            listToReturn.add(new OrderEntityDto(e));
        }
        return listToReturn;
    }

    @GetMapping("/orders/ship_country/{country}")
    public List<OrderEntityDto> getAllOrdersByShippingCountry(@PathVariable String country){
        List<OrderEntity> list = repo.findOrderEntitiesByShipCountry(country);
        List<OrderEntityDto> listToReturn = new ArrayList<>();
        for(OrderEntity e : list){
            listToReturn.add(new OrderEntityDto(e));
        }
        return  listToReturn;
    }

}
