package com.java.productManagement.dao;

import com.java.productManagement.entities.Images;
import com.java.productManagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesDao extends JpaRepository<Images, String> {
}
