package com.tn.esprit.edtech.service;

import com.tn.esprit.edtech.entity.Examen;

import java.util.List;

public interface ExamenService {
    List<Examen> findAll();
    Examen save(Examen examen);
    Examen findById(Long id);
    Examen update(Long id, Examen updatedExamen);
    void delete(Long id);
}
