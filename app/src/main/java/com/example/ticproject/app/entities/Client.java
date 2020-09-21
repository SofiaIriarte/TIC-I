package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="client")
public class Client {

    @Id
    private String cI;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String address;
    private String userName;
    private String passworld;
    @OneToMany
    @JoinColumn(name="client_userName")
    List<MetodoDePago> metodoDePagos;
    @OneToOne
    @JoinColumn(name="client_userName")
    List<ShoppingCart> cartS;

    @Override
    public String toString() {
        return String.format(
                "Client[id=%d, firstName='%s', lastName='%s']",
                cI, firstName, lastName);
    }

    public String getcI() {
        return cI;
    }

    public void setcI(String cI) {
        this.cI = cI;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

}

