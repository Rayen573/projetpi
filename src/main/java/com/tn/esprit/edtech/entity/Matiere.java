package com.tn.esprit.edtech.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Matiere{
    @Id
    @GeneratedValue
    private long id;
    private String nomMatiere;
    private String descMatiere;

    @OneToMany(mappedBy = "matiere")
    private List<Enseignant> enseignants;







}
