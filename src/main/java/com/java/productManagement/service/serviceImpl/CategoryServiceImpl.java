package com.java.productManagement.service.serviceImpl;

import com.java.productManagement.dao.CategoryDao;
import com.java.productManagement.dto.CategoryDTO;
import com.java.productManagement.entities.Category;
import com.java.productManagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public void save(Category category) throws Exception {
        categoryDao.save(category);
    }

    @Override
    public void saveAll(List<CategoryDTO> categoryDTOList) throws Exception {
        List<Category> categoryList = new ArrayList<>();
        for(CategoryDTO categoryDTO: categoryDTOList){
            Category category = new Category();
            category.setId(categoryDTO.getId());
            category.setLabel(categoryDTO.getLabel());
            categoryList.add(category);
            categoryDao.saveAll(categoryList);
        }
    }
}
