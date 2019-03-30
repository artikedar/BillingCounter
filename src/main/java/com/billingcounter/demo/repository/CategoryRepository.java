package com.billingcounter.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingcounter.demo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findTaxById(Long id);
}
