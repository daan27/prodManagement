package com.java.productManagement.service;

import com.java.productManagement.dto.ProductDto;
import com.java.productManagement.dto.ProductRequestDTO;
import com.java.productManagement.entities.Product;

import java.util.List;

public interface ProductService {

    void save(Product product) throws Exception;
    void saveAll(List<ProductRequestDTO> requestDTOList) throws Exception;

    ProductDto findById(Long id) throws Exception;

    List<ProductDto> searchProducts(ProductDto productDto);
}
