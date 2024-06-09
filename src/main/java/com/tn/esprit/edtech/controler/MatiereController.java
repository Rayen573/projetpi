package com.tn.esprit.edtech.controler;

import com.tn.esprit.edtech.entity.Matiere;
import com.tn.esprit.edtech.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/matieres")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    // Endpoint pour ajouter une nouvelle matière
    @PostMapping("/ajouter")
    public ResponseEntity<Matiere> ajouterMatiere(@RequestBody Matiere matiere) {
        Matiere nouvelleMatiere = matiereService.ajouterMatiere(matiere);
        return new ResponseEntity<>(nouvelleMatiere, HttpStatus.CREATED);
    }
}
