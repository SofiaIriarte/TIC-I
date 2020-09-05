package com.example.Client;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name="Clientes")
public class Cliente {

    @Id
    private int cedula;
    private String firstName;
    private String lastName;
    private String userName;
    private String passworld;

}
