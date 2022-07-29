package com.sparta.northwingapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwingapi.entity.OrderEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


class OrdersControllerTest {


    @Test
    void idCheckTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            OrderEntity test = mapper.readValue(new URL("http://localhost:8080/orders/10265"), OrderEntity.class);
            Assertions.assertEquals(10265, test.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void searchByCityTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            List<OrderEntity> test = Arrays.asList(mapper.readValue(new URL("http://localhost:8080/orders/ship_city/paris"), OrderEntity[].class));

            for (OrderEntity e : test) {
                Assertions.assertEquals("Paris", e.getShipCity());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllOrdersByEmployeeIDTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            List<OrderEntity> test = Arrays.asList(mapper.readValue(new URL("http://localhost:8080/orders/employee/1"), OrderEntity[].class));

            for (OrderEntity e : test) {
                Assertions.assertEquals(1,e.getEmployeeID().getId());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllOrdersByShipCountry(){

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            List<OrderEntity> test = Arrays.asList(mapper.readValue(new URL("http://localhost:8080/orders/ship_country/USA"), OrderEntity[].class));

            for (OrderEntity e : test) {
                Assertions.assertEquals("USA", e.getShipCountry());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}