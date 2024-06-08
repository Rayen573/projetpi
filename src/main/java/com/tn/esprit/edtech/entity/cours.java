package com.tn.esprit.edtech.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class cours {
    @Id
    @GeneratedValue
    private long id;
    private String nomCours;
    private String descCours;

    @OneToMany(mappedBy = "cours")
    private List<Enseignant> enseignants;







}
