package com.java.productManagement.controller;

import com.java.productManagement.dto.ApiResponse;
import com.java.productManagement.dto.CategoryDTO;
import com.java.productManagement.dto.MerchantDTO;
import com.java.productManagement.dto.ProductRequestDTO;
import com.java.productManagement.service.CategoryService;
import com.java.productManagement.service.MerchantService;
import com.java.productManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Configuration

@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MerchantService merchantService;

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse uploadProduct(@RequestBody List<ProductRequestDTO> requestDTOList, HttpServletResponse response){
        ApiResponse apiResponse = new ApiResponse();
        try {
            productService.saveAll(requestDTOList);
            apiResponse.setSuccessful(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

        @PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ApiResponse uploadCategory(@RequestBody List<CategoryDTO> categoryDTOList, HttpServletResponse response) {
            ApiResponse apiResponse = new ApiResponse();
            try {
                categoryService.saveAll(categoryDTOList);
                apiResponse.setSuccessful(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return apiResponse;
        }

    @PostMapping(value = "/merchant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse uploadMerchant(@RequestBody List<MerchantDTO> merchantDTOList, HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            merchantService.saveAll(merchantDTOList);
            apiResponse.setSuccessful(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

}
