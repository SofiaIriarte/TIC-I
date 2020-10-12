package com.example.ticproject.app.server.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="shopping_cart")
public class ShoppingCart {

    @Id
    private int iD;
    private long precio;
    @ManyToMany(mappedBy = "shoppingCarts")
    private List<Product> products;

    public ShoppingCart(int iD, long precio) {
        this.iD = iD;
        this.precio = precio;
        this.products = new ArrayList<>();
    }

    public ShoppingCart() {

    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}