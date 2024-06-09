package com.tn.esprit.edtech.controler;

import com.tn.esprit.edtech.entity.Examen;
import com.tn.esprit.edtech.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examens")
public class ExamenController {
    private final ExamenService examenService;
    @Autowired
    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }
    @GetMapping
    public List<Examen> getAllExamens() {
        return examenService.findAll();
    }
    @PostMapping
    public Examen createExamen(@RequestBody Examen examen) {
        return examenService.save(examen);
    }
    @GetMapping("/{id}")
    public Examen getExamenById(@PathVariable Long id) {
        return examenService.findById(id);
    }
    @PutMapping("/{id}")
    public Examen updateExamen(@PathVariable Long id, @RequestBody Examen updatedExamen) {
        return examenService.update(id, updatedExamen);
    }

    @DeleteMapping("/{id}")
    public void deleteExamen(@PathVariable Long id) {
        examenService.delete(id);
    }

}
