package com.sparta.northwingapi.repository;

import com.sparta.northwingapi.entity.EmployeeEntity;
import com.sparta.northwingapi.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findAllByEmployeeID(EmployeeEntity employeeID);

    List<OrderEntity> findOrderEntitiesByShipCity(String city);

    List<OrderEntity>findOrderEntitiesByShipCountry(String country);

}