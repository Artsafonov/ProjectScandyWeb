package com.example.projectscandiweb.model;


import com.example.projectscandiweb.entity.ProductParameters;
import com.example.projectscandiweb.entity.ProductType;
import com.example.projectscandiweb.entity.Scu;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Scu scu;
    private String productName;
    private Integer price;
    private ProductType productType;
    private ProductParameters productParameters;
    private Integer parameterValue;

    public Product() {
    }

    public Product(Long id, Scu scu, String productName, Integer price, ProductType productType, ProductParameters productParameters) {
        this.id = id;
        this.scu = scu;
        this.productName = productName;
        this.price = price;
        this.productType = productType;
        this.productParameters = productParameters;

    }

    public Product(String scu, String productName, Integer price, String productType, String productParameters,  Integer parameterValue) {
        this.scu = Scu.valueOf(scu);
        this.productName = productName;
        this.price = price;
        this.productType = ProductType.valueOf(productType);
        this.productParameters = ProductParameters.valueOf(productParameters);
        this.parameterValue = parameterValue;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Scu getScu() {
        return scu;
    }

    public void setScu(Scu scu) {
        this.scu = scu;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductParameters getProductParameters() {
        return productParameters;
    }

    public void setProductParameters(ProductParameters productParameters) {
        this.productParameters = productParameters;
    }

    public Integer getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(Integer parameterValue) {
        this.parameterValue = parameterValue;
    }
}
