package com.java.productManagement.dao;

import com.java.productManagement.entities.ProductMerchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMerchantDao extends JpaRepository<ProductMerchant, String> {
}
