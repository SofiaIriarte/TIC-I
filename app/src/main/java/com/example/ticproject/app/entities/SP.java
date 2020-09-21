package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="sp")

public class SP {
    @Id
    private int iD;
    @ManyToMany
    @JoinColumn(name="SP_iD")
    List<Store> store;
    @ManyToMany
    @JoinColumn(name="SP_iD")
    List<Product> products;
}
