package com.tn.esprit.edtech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Modules {
    @Id
    @GeneratedValue
    long id_module;
    String nom_module;
    @OneToMany
    List<cours> Cours;

    String module_desc;
}
