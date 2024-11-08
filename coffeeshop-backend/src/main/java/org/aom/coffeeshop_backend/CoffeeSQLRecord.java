package org.aom.coffeeshop_backend;

import jakarta.persistence.Column;

import java.math.BigDecimal;

/**
 * @author : abhishekomprakash
 * @since : Thu, 2024-Nov-07
 * Created with IntelliJ IDEA
 */

public class CoffeeSQLRecord {
    private String code;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;


    public CoffeeSQLRecord() {
    }

    public CoffeeSQLRecord(String code, String name, String description, String imageUrl, BigDecimal price) {
        this.code = code;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return code + ',' + description + ',' + imageUrl + ',' + price + ',' + name;
    }
}
