package com.example.demo.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
@Data
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "nom must be not null")
    private String nom;
    @NotNull(message = "prenom must be not null")
    @Size(min = 3,message = "min caractere are 3")
    private String prenom;
}
