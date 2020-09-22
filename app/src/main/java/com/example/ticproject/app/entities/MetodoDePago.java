package com.example.ticproject.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="pago")
public class MetodoDePago {

    @Id
    private int nTarjeta;
    private String titular;

    public MetodoDePago(int nTarjeta, String titular) {
        this.nTarjeta = nTarjeta;
        this.titular = titular;
    }

    public MetodoDePago() {

    }

    public int getnTarjeta() {
        return nTarjeta;
    }

    public void setnTarjeta(int nTarjeta) {
        this.nTarjeta = nTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

}