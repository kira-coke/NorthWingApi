package com.sparta.northwingapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwingapi.entity.CategoryEntity;
import com.sparta.northwingapi.entity.OrderEntity;
import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CategoryControllerTest {


    @Test
    void idCheckTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            CategoryEntity test = mapper.readValue(new URL("http://localhost:8080/category/id/1"), CategoryEntity.class);
            Assertions.assertEquals(1, test.getId());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void idCheckTest2(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CategoryEntity test = mapper.readValue(new URL("http://localhost:8080/category/id/2"), CategoryEntity.class);
            Assertions.assertEquals(2, test.getId());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getByName() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CategoryEntity test = mapper.readValue(new URL("http://localhost:8080/category/name/beverages"), CategoryEntity.class);
            Assertions.assertEquals("beverages",test.getCategoryName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}