package com.sparta.northwingapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwingapi.entity.CustomerEntity;
import com.sparta.northwingapi.entity.OrderEntity;
import com.sparta.northwingapi.repository.CustomerEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class CustomersControllerTest {
    @Test
    void idTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity id = mapper.readValue(new URL("http://localhost:8080/customer/WOLZA"), CustomerEntity.class);
            Assertions.assertEquals("WOLZA", id.getId());
            CustomerEntity wrong = mapper.readValue(new URL("http://localhost:8080/customer/WOLZA"), CustomerEntity.class);
            Assertions.assertFalse(wrong.getId().equals("RASKO"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void companyTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity company = mapper.readValue(new URL("http://localhost:8080/customer/company/Eastern%20Connection"), CustomerEntity.class);
            Assertions.assertEquals("EASTC", company.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void nameTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity name = mapper.readValue(new URL("http://localhost:8080/customer/contactName/Carine%20Schmitt"), CustomerEntity.class);
            Assertions.assertEquals("FRANR", name.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void postCodeTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity postCode = mapper.readValue(new URL("http://localhost:8080/customer/postcode/08022"), CustomerEntity.class);
            System.out.println(postCode);
            Assertions.assertEquals("GALED", postCode.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void countryTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity[] country = mapper.readValue(new URL("http://localhost:8080/customer/country/UK"), CustomerEntity[].class);
            for (CustomerEntity customerEntity : country) {
                Assertions.assertEquals("UK", customerEntity.getCountry());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void cityTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity[] city = mapper.readValue(new URL("http://localhost:8080/customer/city/London"), CustomerEntity[].class);
            for (CustomerEntity customerEntity : city) {
                Assertions.assertEquals("London", customerEntity.getCity());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void regionTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity[] region = mapper.readValue(new URL("http://localhost:8080/customer/region/SP"), CustomerEntity[].class);
            for (CustomerEntity customerEntity : region) {
                Assertions.assertEquals("SP", customerEntity.getRegion());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void contactTitleTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity[] contactTitle = mapper.readValue(new URL("http://localhost:8080/customer/city/Owner"), CustomerEntity[].class);
            for (CustomerEntity customerEntity : contactTitle) {
                Assertions.assertEquals("Owner", customerEntity.getContactTitle());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void phoneNumberTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity phoneNo = mapper.readValue(new URL("http://localhost:8080/customer/phone/30.59.84.10"), CustomerEntity.class);
            Assertions.assertEquals("30.59.84.10", phoneNo.getPhone());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void faxTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity fax = mapper.readValue(new URL("http://localhost:8080/customer/fax/069-0245874"), CustomerEntity.class);
            Assertions.assertEquals("069-0245874", fax.getFax());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void titleAndCountryTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            CustomerEntity tAndCTest = mapper.readValue(new URL("http://localhost:8080/customer/Italy/Marketing%20Manager"), CustomerEntity.class);
            Assertions.assertEquals("Italy", tAndCTest.getCountry());
            Assertions.assertEquals("Marketing Manager", tAndCTest.getContactTitle());
            Assertions.assertEquals("MAGAA", tAndCTest.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addCustomerTest() {
        CustomerController cs = new CustomerController();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        CustomerEntity temp = new CustomerEntity("LODAS", "Wartian Herkku", "Pirkko Koskitalo", "Accounting Manager", "Torikatu 38",
                "Oulu", "SP", "90110", "Finland", "981-443655", "981-443655");
        try{
            List<CustomerEntity> addCust = Arrays.asList(mapper.readValue(new URL("http://localhost:8080/customers"), CustomerEntity[].class));
            String requestBody = mapper.writeValueAsString(temp);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/customer/add/"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
            List<CustomerEntity> addCust2 = Arrays.asList(mapper.readValue(new URL("http://localhost:8080/customers"), CustomerEntity[].class));
            Assertions.assertEquals(addCust.size()+1,addCust2.size());
            Assertions.assertTrue(cs.addNewCustomer(temp) == true);
        }catch(IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

