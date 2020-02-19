package com.assel.backendassignment.product;

/**
 * Product DTO
 */
public class ProductDTO {

    private long id;
    private String name;
    private String currentPrice;
    private String lastUpdate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "ProductDTO [id=" + id + ", name=" + name + ", current price=" + currentPrice + ", last updat=" + lastUpdate
                + "]";
    }
}