package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="store")
public class Store {

    @Id
    private int iD;
    private Time hours;
    private String user;
    private String address;
    private String password;
    @OneToMany
    @JoinColumn(name="stock_iD")
    private List<Stock> stock;
    @ManyToMany(mappedBy = "stores")
    private List<Product> products;
    @ManyToMany(mappedBy = "storesBrand")
    private List<Brand> brands;

    public Store(int iD, Time hours, String user, String address, String password) {
        this.iD = iD;
        this.hours = hours;
        this.user = user;
        this.address = address;
        this.password = password;
        this.stock = new ArrayList<>();
        this.products = new ArrayList<>();
        this.brands = new ArrayList<>();
    }

    public Store() {

    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Time getHours() {
        return hours;
    }

    public void setHours(Time hours) {
        this.hours = hours;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

}