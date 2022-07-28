package com.sparta.northwingapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @PostMapping("/product/post")
    public ResponseEntity<String> addProduct(@RequestBody ProductEntity product){
        if (!repo.existsById(product.getId())){
            repo.save(product);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type", "application/json");
            try {
                return new ResponseEntity<String>(mapper.writeValueAsString(product), headers, HttpStatus.ACCEPTED);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/product/put")
    public ResponseEntity<String> putProduct(@RequestBody ProductEntity product) throws JsonProcessingException {
        repo.save(product);
        return new ResponseEntity<>(mapper.writeValueAsString(product), HttpStatus.ACCEPTED);
    }




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
