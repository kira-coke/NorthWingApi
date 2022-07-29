package com.sparta.northwingapi.controller;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwingapi.entity.CustomerEntity;
import com.sparta.northwingapi.entity.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @Test
    void getIndex() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductEntity result = mapper.readValue(
                    new URL("http://localhost:8080/product/1"),
                    ProductEntity.class);
            int id = result.getId();
            Assertions.assertTrue(id==1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getProducts() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductEntity result = mapper.readValue(
                    new URL("http://localhost:8080/product/1"),
                    ProductEntity.class);
            int id = result.getId();
            Assertions.assertTrue(id==1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    }

    @Test
    void getProductById() {
    }

    @Test
    void getProductByName() {
    }

    @Test
    void addProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void putProduct() {
    }

    @Test
    void patchProduct() {
    }
}