package com.java.productManagement.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "images")
public class Images implements Serializable {
    private Integer id;
    private String url;
    private Product product;
    private long productId;


    @Id
    @Column(name = "_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "product_id")
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
