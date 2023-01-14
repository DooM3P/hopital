package com.example.Hopital.controller;


import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.RendezVous;
import com.example.Hopital.models.Specialite;
import com.example.Hopital.service.MedecinService;
import com.example.Hopital.service.RendezVousService;
import com.example.Hopital.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/medecin") // This means URL's start with /demo (after Application path)
public class MedecinController {
    @Autowired // This means to get the bean called MedecinService
    private MedecinService medecinService;

    @Autowired
    private RendezVousService rendezVousService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Medecin>> getMedecin() {
        try {
            List<Medecin> medecins = medecinService.getMedecins();
            return new ResponseEntity<>(medecins, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin) {
        try {
            return new ResponseEntity<>(medecinService.saveMedecin(medecin), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/specialite")
    public List<Medecin> getMedecinBySpecialite(@RequestBody Specialite specialite) {
        return medecinService.getMedecinsBySpecialite(specialite);
    }

    @GetMapping(path = "/{id}")
    public Medecin getMedecinById(@PathVariable Long id) {
        return medecinService.getMedecinByID(id);
    }

    @GetMapping(path = "/{id}/rendezvous")
    public List<RendezVous> getRvByMedecinId(@PathVariable Long id) {
        return rendezVousService.getRendezVousByMedecin(medecinService.getMedecinByID(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        medecinService.deleteByID(id);
    }

    @DeleteMapping(path = "/")
    public void deleteAll() {
        medecinService.deleteAll();
    }

}
