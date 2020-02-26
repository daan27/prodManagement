package com.java.productManagement.controller;

import com.java.productManagement.dto.ApiResponse;
import com.java.productManagement.dto.ProductDto;
import com.java.productManagement.entities.Product;
import com.java.productManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long productId) {
        try {
            return ResponseEntity.ok(productService.findById(productId));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.ok(new ProductDto());
        }
    }

    @PostMapping("/product/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestBody ProductDto productDto) {
        try {
            return ResponseEntity.ok(productService.searchProducts(productDto));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.ok(new ArrayList<>());
        }
    }
}
