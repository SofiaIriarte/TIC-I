package com.example.ticproject.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="pago")

public class MetodoDePago {

    @Id
    private int nTarjeta;
    private String titular;

}
