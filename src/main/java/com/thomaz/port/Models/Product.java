package com.thomaz.port.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productName;
    private Integer inStock;
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
