package com.sparta.northwingapi.controller;


import com.sparta.northwingapi.dto.OrderEntityDto;
import com.sparta.northwingapi.entity.EmployeeEntity;
import com.sparta.northwingapi.entity.OrderEntity;
import com.sparta.northwingapi.repository.OrderEntityRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrderEntityRepository repo;

    @GetMapping("/orders_old/{id}")
    public OrderEntity getOrderEntityByID(@PathVariable int id) {
        return repo.getReferenceById(id);
    }

    @GetMapping("/orders/{id}")
    public OrderEntityDto getOrderByID(@PathVariable int id) {
        return new OrderEntityDto(repo.getReferenceById(id));
    }

    @GetMapping("/orders/all")
    public List<OrderEntityDto> getAllOrders() {
        List<OrderEntity> list = repo.findAll();
        List<OrderEntityDto> listToReturn = new ArrayList<>();
        for (OrderEntity e : list) {
            listToReturn.add(new OrderEntityDto(e));
        }
        return listToReturn;
    }

    @GetMapping("/orders/employee/{id}")
    public List<OrderEntity> getAllOrdersByEmployeeID(@PathVariable EmployeeEntity id) {
        List<OrderEntity> list = repo.findAllByEmployeeID(id);
        List<OrderEntityDto> listToReturn = new ArrayList<>();
        for (OrderEntity e : list) {
            listToReturn.add(new OrderEntityDto(e));
        }
        //return listToReturn;
        return repo.findAllByEmployeeID(id);
    }

    @GetMapping("/orders/ship_city/{city}")
    public List<OrderEntityDto> getAllOrdersByCity(@PathVariable String city) {
        List<OrderEntity> list = repo.findOrderEntitiesByShipCity(city);
        List<OrderEntityDto> listToReturn = new ArrayList<>();
        for (OrderEntity e : list) {
            listToReturn.add(new OrderEntityDto(e));
        }
        return listToReturn;
    }

    @GetMapping("/orders/ship_country/{country}")
    public List<OrderEntityDto> getAllOrdersByShippingCountry(@PathVariable String country) {
        List<OrderEntity> list = repo.findOrderEntitiesByShipCountry(country);
        List<OrderEntityDto> listToReturn = new ArrayList<>();
        for (OrderEntity e : list) {
            listToReturn.add(new OrderEntityDto(e));
        }
        return listToReturn;
    }

    //doesn't work
    @DeleteMapping("orders/delete/{id}")
    public void deleteOrderByID(@PathVariable int id) {
        OrderEntity orderToDelete = getOrderEntityByID(id);
        repo.delete(orderToDelete);
    }

    @PostMapping("orders/add/")
    public String addNewOrder(@RequestBody OrderEntity order) {
        if (repo.existsById(order.getId())) {
            return "Record already in";
        } else {
            repo.save(order);
            return "Successful";
        }
    }

    @PutMapping("/orders/add/new")
    public void addOrReplaceOrder(@RequestBody OrderEntity order) {
        repo.save(order);
    }


    @PatchMapping("/orders/update/{id}/{freight}")
    public void updateFreightByID(@PathVariable int id, @PathVariable BigDecimal freight) {
        OrderEntity orderToUpdate = getOrderEntityByID(id);
        orderToUpdate.setFreight(freight);
        repo.save(orderToUpdate);
    }

}
