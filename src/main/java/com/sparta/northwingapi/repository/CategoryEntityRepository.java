package com.sparta.northwingapi.repository;

import com.sparta.northwingapi.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {
    CategoryEntity findByCategoryName(String name);
}