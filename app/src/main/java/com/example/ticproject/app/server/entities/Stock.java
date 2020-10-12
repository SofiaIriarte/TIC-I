package com.example.ticproject.app.server.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity(name="stock")
@IdClass(Stock.class)
public class Stock implements Serializable {

    @Id
    private int productId;
    @Id
    private int storeId;
    @Id
    private String talle;
    private int quantity;

    public Stock (int productId, int storeId,String talle, int quantity){
        this.productId = productId;
        this.storeId = storeId;
        this.talle=talle;
        this.quantity = quantity;
    }

    public Stock() {

    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}