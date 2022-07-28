package com.sparta.northwingapi.repository;

import com.sparta.northwingapi.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {
}