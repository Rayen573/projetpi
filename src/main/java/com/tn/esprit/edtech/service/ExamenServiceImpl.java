package com.tn.esprit.edtech.service;

import com.tn.esprit.edtech.entity.Examen;
import com.tn.esprit.edtech.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService {
    @Autowired
    private ExamenRepository examenRepository;
    @Autowired
    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    public List<Examen> findAll() {
        return examenRepository.findAll();
    }


    public Examen save(Examen examen) {
        return examenRepository.save(examen);
    }
    public Examen findById(Long id) {
        return examenRepository.findById(id).orElse(null);
    }
    public Examen update(Long id, Examen updatedExamen) {
        Examen existingExamen = examenRepository.findById(id).orElse(null);
        if (existingExamen != null) {
            // Mettre à jour les champs modifiables de l'examen existant avec les valeurs de l'examen mis à jour
            existingExamen.setNom(updatedExamen.getNom());
            existingExamen.setDate(updatedExamen.getDate());
            existingExamen.setNote(updatedExamen.getNote());
            existingExamen.setMatiere(updatedExamen.getMatiere());
            // Enregistrer les modifications
            return examenRepository.save(existingExamen);
        }
        return null;
    }
    public void delete(Long id) {
        examenRepository.deleteById(id);
    }

}
