package com.sparta.northwingapi.repository;

import com.sparta.northwingapi.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, String> {
    List<CustomerEntity> findCustomerEntitiesByCompanyName(String companyName);

    CustomerEntity findCustomerEntityByContactName(String contantName);

    List<CustomerEntity> findCustomerEntitiesByPostalCode(String postCode);

    List<CustomerEntity> findCustomerEntitiesByCountry(String country);

    List<CustomerEntity> findCustomerEntitiesByCity(String city);

    CustomerEntity findCustomerEntityByAddress(String address);

    List<CustomerEntity> findCustomerEntitiesByContactTitle(String contactTitle);

    List<CustomerEntity> findCustomerEntitiesByRegion(String region);
    CustomerEntity findCustomerEntityByPhone(String phone);
    CustomerEntity findCustomerEntityByFax(String fax);

    List<CustomerEntity> findCustomerEntitiesByContactTitleAndCountry(String title, String country);


}