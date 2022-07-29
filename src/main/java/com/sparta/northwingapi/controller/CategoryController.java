package com.sparta.northwingapi.controller;

import com.sparta.northwingapi.entity.CategoryEntity;
import com.sparta.northwingapi.repository.CategoryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// Mustafa - added this last minute for some practise, the others have more comprehensive api features
@RestController
public class CategoryController {
    @Autowired
    CategoryEntityRepository repo;

    @GetMapping("/category/all")
    public List<CategoryEntity> getAll(){
        return repo.findAll();
    }

    @GetMapping("/category/id/{id}")
    public CategoryEntity getById(@PathVariable int id){
        return repo.findById(id).get();
    }

    @GetMapping("/category/name/{name}")
    public CategoryEntity getByName(@PathVariable String name){
        return repo.findByCategoryName(name);
    }

}
