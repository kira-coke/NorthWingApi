package com.sparta.northwingapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwingapi.entity.OrderEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URL;


class OrdersControllerTest {



    @Test
    void idCheckTest(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            OrderEntity test = mapper.readValue(new URL("http://localhost:8080/orders/10265"),OrderEntity.class);
            System.out.println(test.toString());
            Assertions.assertEquals(10265,test.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}