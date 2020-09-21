package com.example.ticproject.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="cartS")

public class ShoppingCart {

    @Id
    private int iD;
    private long precio;

}