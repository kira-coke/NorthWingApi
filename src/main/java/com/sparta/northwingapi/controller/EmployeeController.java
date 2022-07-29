package com.sparta.northwingapi.controller;

import com.sparta.northwingapi.entity.EmployeeEntity;
import com.sparta.northwingapi.repository.EmployeeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/employees")
    public List<EmployeeEntity>getemployee()
    {
        List<EmployeeEntity> result = repo.findAll();
        return result;
    }
    @PostMapping("/employee/post")
    public String postEmployee(@RequestBody EmployeeEntity employee)
    {
        if(repo.existsById(employee.getId()))
        {
            return "Fail";
        }
        else
        {
            repo.save(employee);
            return "Safe";
        }
    }
    @PutMapping("/employee/put")
    public String putEmployee(@RequestBody EmployeeEntity employee)
    {
        repo.save(employee);
        return "success";
    }



}
