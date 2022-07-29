package com.sparta.northwingapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwingapi.entity.CustomerEntity;
import com.sparta.northwingapi.entity.ProductEntity;
import com.sparta.northwingapi.repository.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ObjectMapper mapper;

    @Autowired
    ProductEntityRepository repo;

    @GetMapping("/")
    public String getIndex(){
        return "Hello from ProductController";
    }

    @GetMapping("/products")
    public List<ProductEntity> getProducts(){
        return repo.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductEntity getProductById(@PathVariable int id){
        return repo.getReferenceById(id);
    }

    //works
    @PostMapping("/product/post")
    public String addProduct(@RequestBody ProductEntity product){
        if (!repo.existsById(product.getId())) {
            repo.save(product);
            return "success";
        } else
            return "fail";
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("content-type", "application/json");
//            try {
//                return new ResponseEntity<String>(mapper.writeValueAsString(product), headers, HttpStatus.ACCEPTED);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        } else{
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
    }


    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id){
        repo.delete(repo.getReferenceById(id));
        return "Success";
    }


    //works
    @PutMapping("/product/put")
    public String putProduct(@RequestBody ProductEntity product) {
        repo.save(product);
        return "success";
//        return new ResponseEntity<>(mapper.writeValueAsString(product), HttpStatus.ACCEPTED);
    }



    @PatchMapping("product/patch")
    public String patchProduct(@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.readValue(json, CustomerEntity.class)
        return json;

    }

//    @PatchMapping("/product/patch")
//    public ResponseEntity<String> patchProduct(@RequestBody String json){
//        repo.getReferenceById()
//    }

//    @GetMapping("/actors/{fname}/{lname}")
//    public ResponseEntity<String> getActoryByName (@PathVariable String fname, @PathVariable String lname){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("content-type", "application/json");
//        Actor result = dao.getActor(fname,lname);
//        try {
//            return new ResponseEntity<String>(mapper.writeValueAsString(result),headers, HttpStatus.ACCEPTED);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }



}
