package com.sparta.northwingapi.repository;

import com.sparta.northwingapi.entity.CustomerEntity;
import com.sparta.northwingapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, String> {


}