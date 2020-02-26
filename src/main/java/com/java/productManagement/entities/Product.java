package com.java.productManagement.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findById", query = "select p from Product p join fetch p.category join fetch p.productImages where p.id = :productId")
})
public class Product implements Serializable {
    private Long id;
    private String label;
    private String title;
    private BigDecimal price;
    private String description;
    private Long categoryId;
    private Category category;
    private List<Images> productImages;

    @Id
    @Column(name = "_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "category_id")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "product")
    public List<Images> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<Images> productImages) {
        this.productImages = productImages;
    }
}
