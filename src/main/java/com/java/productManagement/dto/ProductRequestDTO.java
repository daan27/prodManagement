package com.java.productManagement.dto;

import com.java.productManagement.entities.Category;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductRequestDTO implements Serializable {

    private long id;
    private String label;
    private String title;
    private BigDecimal price;
    private String description;
    private List<ImagesDTO> imagesDTOList;
    private long categoryId;
    private Category category;
    private long merchantId;
    private boolean available;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImagesDTO> getImagesDTOList() {
        return imagesDTOList;
    }

    public void setImagesDTOList(List<ImagesDTO> imagesDTOList) {
        this.imagesDTOList = imagesDTOList;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
