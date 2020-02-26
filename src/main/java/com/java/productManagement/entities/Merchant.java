package com.java.productManagement.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "merchant")
public class Merchant implements Serializable {
    private long id;
    private String label;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
