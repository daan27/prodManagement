package com.java.productManagement.service;

import com.java.productManagement.dto.CategoryDTO;
import com.java.productManagement.entities.Category;

import java.util.List;

public interface CategoryService {

    void save (Category category) throws Exception;
    void saveAll(List<CategoryDTO> categoryDTOList) throws Exception;
}
