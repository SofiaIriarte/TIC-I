package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.util.List;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="brand")

public class Brand {

    @Id
    private int iD;
    private String name;
    @OneToMany
    @JoinColumn(name="brand_name")
    List<Products> products;

}