package com.example.ticproject.app.entities;

import javax.persistence.*;
import java.util.List;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="stock")

public class Stock {

    @Id
    private int iD;
    private int quantity;
}