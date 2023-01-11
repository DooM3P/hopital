package com.example.Hopital.controller;

import com.example.Hopital.models.Specialite;
import com.example.Hopital.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/specialite") // This means URL's start with /demo (after Application path)
public class SpecialiteController {
    @Autowired // This means to get the bean called SpecialiteService
    private SpecialiteService specialiteService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Specialite>> getSpecialite() {
        try {
            List<Specialite> specialites = specialiteService.getSpecialites();
            return new ResponseEntity<>(specialites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<Specialite> saveSpecialite(@RequestBody Specialite specialite) {
        try {
            return new ResponseEntity<>(specialiteService.saveSpecialite(specialite), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public Specialite getSpecialiteById(@PathVariable Long id) {
        return specialiteService.getSpecialiteByID(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        specialiteService.deleteByID(id);
    }

    @DeleteMapping(path = "/")
    public void deleteAll() {
        specialiteService.deleteAll();
    }
}

