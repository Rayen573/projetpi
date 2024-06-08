package com.tn.esprit.edtech.service;

import com.tn.esprit.edtech.entity.Matiere;
import com.tn.esprit.edtech.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    // Méthode pour ajouter une nouvelle matière
    public Matiere ajouterMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    // Méthode pour obtenir toutes les matières
    public List<Matiere> obtenirToutesLesMatieres() {
        return matiereRepository.findAll();
    }

    // Méthode pour obtenir une matière par son identifiant
    public Optional<Matiere> obtenirMatiereParId(Long id) {
        return matiereRepository.findById(id);
    }

    // Méthode pour supprimer une matière
    public void supprimerMatiere(Long id) {
        matiereRepository.deleteById(id);
    }
}
