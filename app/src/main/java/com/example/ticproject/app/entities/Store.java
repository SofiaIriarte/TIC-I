package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="store")

public class Store {

    @Id
    private int iD;
    private Time hours;
    private String user;
    private String address;
    private String password;
    @OneToMany
    @JoinColumn(name="store_iD")
    List<Stock> stock;
}