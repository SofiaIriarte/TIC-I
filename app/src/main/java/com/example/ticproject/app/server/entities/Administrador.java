package com.example.ticproject.app.server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="administrador")
public class Administrador {

    @Id
    private String userName;
    private String passworld;
    private String name;

    public Administrador(){    }

    public Administrador(String userName, String passworld, String name){
        this.userName = userName;
        this.passworld = passworld;
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
