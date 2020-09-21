package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.util.List;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="product")

public class Product {

    @Id
    private int iD;
    private long price;
    private String description;
    private String name;
    private String cathegory;
    @OneToMany
    @JoinColumn(name="product_iD")
    List<Stock> stock;
}