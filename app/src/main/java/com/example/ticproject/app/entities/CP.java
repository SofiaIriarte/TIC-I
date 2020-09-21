package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="cp")

public class CP {
    @Id
    private int iD;
    @ManyToMany
    @JoinColumn(name="CP_iD")
    List<ShoppingCart> sP;
    @ManyToMany
    @JoinColumn(name="CP_iD")
    List<Product> products;
}
