package com.sparta.northwingapi.controller;

import com.sparta.northwingapi.entity.EmployeeEntity;
import com.sparta.northwingapi.repository.EmployeeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeEntityRepository repo;

    @GetMapping("/employee/{id}")
    public EmployeeEntity getemployee(@PathVariable int id)
{
    EmployeeEntity result = repo.findById(id).get();
    return result;
    //return ("This is an employee");

}

}
