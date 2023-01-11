package com.example.Hopital.controller;


import com.example.Hopital.models.Medecin;
import com.example.Hopital.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/medecin") // This means URL's start with /demo (after Application path)
public class MedecinController {
    @Autowired // This means to get the bean called MedecinService
    private MedecinService medecinService;

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
