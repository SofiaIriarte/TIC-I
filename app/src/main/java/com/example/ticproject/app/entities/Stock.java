package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name="stock")
public class Stock {

    @Id
    private int iD;
    private int quantity;

    public Stock (int id, int quantity){
        this.iD = id;
        this.quantity = quantity;
    }

    public Stock() {

    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}