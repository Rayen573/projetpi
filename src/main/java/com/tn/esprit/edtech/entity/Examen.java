package com.tn.esprit.edtech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Examen {
    @Id
    @GeneratedValue
    public long id ;
    @NotNull(message = "Le nom de l'examen est obligatoire")
    @Size(max = 15, message = "Le nom de l'examen ne doit pas dépasser 15 caractères")
    private String nom;
    @NotNull(message = "Le date de l'examen est obligatoire")
    private Date date;
    @NotNull(message = "La note de l'examen est obligatoire")
    @DecimalMin(value = "0.0", message = "La note de l'examen doit être supérieure ou égale à 0")
    @DecimalMax(value = "20.0", message = "La note de l'examen doit être inférieure ou égale à 20")
    private Double note;

    @ManyToOne
    @JoinColumn(name = "matiere_id")

    private Matiere matiere;
}
