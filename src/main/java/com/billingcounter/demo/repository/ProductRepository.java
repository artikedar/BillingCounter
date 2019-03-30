package com.billingcounter.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingcounter.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findProductByProductCode(String productCode);
}
