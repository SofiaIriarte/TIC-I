package com.example.Client;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name="Marcas")
public class Marca {

    @Id
    private int id;
    private String name;

}
