package com.java.productManagement.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private long id;
    private String label;


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
}
