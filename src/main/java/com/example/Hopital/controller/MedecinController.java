package com.example.Hopital.controller;


import com.example.Hopital.models.Medecin;
import com.example.Hopital.service.MedecinService;
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
    private SpecialiteService specialiteService;

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
//        if (!medecin.getSpecialite().getName().isBlank()){
//            medecin.setSpecialite(specialiteService.getSpecialiteByName(medecin.getSpecialite().getName()));
//        }
        try {
            return new ResponseEntity<>(medecinService.saveMedecin(medecin), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public Medecin getMedecinById(@PathVariable Long id) {
        return medecinService.getMedecinByID(id);
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
