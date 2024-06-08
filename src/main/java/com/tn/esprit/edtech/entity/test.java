package com.tn.esprit.edtech.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class test {
    @Id
    @GeneratedValue
    Long id ;

    String name ;
}
