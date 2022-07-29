package com.sparta.northwingapi.controller;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwingapi.entity.CustomerEntity;
import com.sparta.northwingapi.entity.OrderEntity;
import com.sparta.northwingapi.entity.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
    void getIndex2() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductEntity result = mapper.readValue(
                    new URL("http://localhost:8080/product/2"),
                    ProductEntity.class);
            int id = result.getId();
            Assertions.assertTrue(id==2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



//    @Test
//    void addingNewOrdersTest() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.findAndRegisterModules();
//
//        var values = new HashMap<String, String>();
//        values.put("id", "666");
//        values.put("orderDate", "1996-07-03T23:00:00Z");
//        values.put("requiredDate", "1996-07-31T23:00:00Z");
//        values.put("shippedDate", "1996-07-31T23:00:00Z");
//        values.put("freight", "23.3232");
//        values.put("shipName", "Vins et alcools Chevalier");
//        values.put("shipAddress", "59 rue de l-Abbaye");
//        values.put("shipCity", "Reims");
//        values.put("shipRegion", "null");
//        values.put("shipPostalCode", "51100");
//        values.put("shipCountry", "France");
//        try {
//            List<OrderEntity> test = Arrays.asList(mapper.readValue(new URL("http://localhost:8080/products/all"), OrderEntity[].class));
//            String requestBody = mapper.writeValueAsString(values);
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("http://localhost:8080/orders/add/"))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();
//            client.send(request, HttpResponse.BodyHandlers.ofString());
//            List<OrderEntity> test2 = Arrays.asList(mapper.readValue(new URL("http://localhost:8080/orders/all"), OrderEntity[].class));
//
//            Assertions.assertEquals(test.size()+1,test2.size());
//
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}