package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
@Data
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "nom must be not null")
    private String nom;
    @NotNull(message = "prenom must be not null")
    @Size(min = 3,message = "min caractere are 3")
    private String prenom;

    public Employe(String nom, String prenom) {

        this.nom = nom;
        this.prenom = prenom;
    }

    public Employe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
