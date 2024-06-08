package com.tn.esprit.edtech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Enseignant {
    @Id
    @GeneratedValue
    Long id;
    String nom_enseignat;
    String prenom_enseignat;
    private String email;
    private String telephone;

    private String adresse;
    @ManyToOne
    private cours cours;
}
