package com.sparta.northwingapi.controller;

import com.sparta.northwingapi.entity.CustomerEntity;
import com.sparta.northwingapi.entity.OrderEntity;
import com.sparta.northwingapi.repository.CustomerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerEntityRepository repo;
    @GetMapping("/customers")
    public List<CustomerEntity> getCustomers(){
        return repo.findAll();
    }
    @GetMapping("/customer/{id}")
    public CustomerEntity getById(@PathVariable String id){
        return repo.findById(id).get();
    }
    @GetMapping("/customer/company/{companyName}")
    public List<CustomerEntity> getByCompanyName(@PathVariable String companyName){
        List<CustomerEntity> result = repo.findCustomerEntitiesByCompanyName(companyName);
        return result;
    }
    @GetMapping("/customer/contactName/{name}")
    public CustomerEntity getByName(@PathVariable String name){
        return repo.findCustomerEntityByContactName(name);
    }
    @GetMapping("/customer/postcode/{postcode}")
    public List<CustomerEntity> getByPostalCode(@PathVariable String postcode){
        return repo.findCustomerEntitiesByPostalCode(postcode);
    }
    @GetMapping("/customer/country/{country}")
    public List<CustomerEntity> getByCountry(@PathVariable String country){
        return repo.findCustomerEntitiesByCountry(country);
    }
    @GetMapping("/customer/city/{city}")
    public List<CustomerEntity> getByCity(@PathVariable String city){
        return repo.findCustomerEntitiesByCity(city);
    }
    @GetMapping("/customer/address/{address}")
    public CustomerEntity getByAddress(@PathVariable String address){
        return repo.findCustomerEntityByAddress(address);
    }
    @GetMapping("/customer/contactTitle/{contactTitle}")
    public List<CustomerEntity> getByContactTitle(@PathVariable String contactTitle){
        return repo.findCustomerEntitiesByContactTitle(contactTitle);
    }
    @GetMapping("/customer/region/{region}")
    public List<CustomerEntity> getByRegion(@PathVariable String region){
        return repo.findCustomerEntitiesByRegion(region);
    }
    @GetMapping("/customer/phone/{phone}")
    public CustomerEntity getByPhone(@PathVariable String phone){
        return repo.findCustomerEntityByPhone(phone);
    }
    @GetMapping("/customer/fax/{fax}")
    public CustomerEntity getByFax(@PathVariable String fax){
        return repo.findCustomerEntityByFax(fax);
    }
    @GetMapping("/customer/{country}/{contactTitle}")
    public List<CustomerEntity> getByCountryAndContactTitle(@PathVariable String country, @PathVariable String contactTitle){
        return repo.findCustomerEntitiesByContactTitleAndCountry(contactTitle, country);
    }

    /*@DeleteMapping("/customer/{id}/delete")
    @OneToOne(fetch = FetchType.LAZY)
    public void deleteById(@PathVariable String id){
        //CustomerEntity result = repo.findById(id).get();
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new RuntimeException("No record found for given id: "+id);
        }
    }*/

    @PostMapping("customer/add/")
    public void addNewCustomer(@RequestBody CustomerEntity customer){
        if(!repo.existsById(customer.getId())){
            repo.save(customer);
        }else{
            System.out.println("Already Exists");
        }
    }

    @PostMapping("customer/change/address/{id}")
    public void changeCustomerAddress(@PathVariable String id, @RequestBody CustomerEntity customer){
        repo.getReferenceById(id).setAddress(customer.getAddress());
        repo.save(repo.findById(id).get());
    }
    @PostMapping("customer/change/contactTitle/{id}")
    public void changeContactTitle(@PathVariable String id, @RequestBody CustomerEntity customer){
        repo.getReferenceById(id).setContactTitle(customer.getContactTitle());
        repo.save(repo.findById(id).get());
    }
    @PostMapping("customer/change/companyName/{id}")
    public void changeCompanyName(@PathVariable String id, @RequestBody CustomerEntity customer){
        repo.getReferenceById(id).setCompanyName(customer.getCompanyName());
        repo.save(repo.findById(id).get());
    }
}
