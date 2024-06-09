package com.tn.esprit.edtech.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String adresse;



    @Column(name = "phone_number") // Utilisation de @Column pour spécifier le nom de la colonne dans la base de données
    private String phoneNumber;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id") // Colonne qui référence le rôle dans la table des utilisateurs
    private Role role;

}

