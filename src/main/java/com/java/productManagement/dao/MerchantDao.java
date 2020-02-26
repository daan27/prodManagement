package com.java.productManagement.dao;

import com.java.productManagement.entities.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDao extends JpaRepository<Merchant, String> {
}
