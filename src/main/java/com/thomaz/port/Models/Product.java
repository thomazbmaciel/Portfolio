package com.thomaz.port.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable=false)
    private String productName;
    @Column(nullable=false)
    private Integer inStock;
    @Column(nullable=false)
    private String productOwner;

    public Integer getId() {
        return id;
    }
    
    public String getProductName() {
        return productName;
    }

    public Integer getInStock() {
        return inStock;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }
}
