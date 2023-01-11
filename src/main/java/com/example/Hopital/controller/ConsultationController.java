package com.example.Hopital.controller;

import com.example.Hopital.models.Consultation;
import com.example.Hopital.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/consultation") // This means URL's start with /demo (after Application path)
public class ConsultationController {
    @Autowired // This means to get the bean called ConsultationService
    private ConsultationService consultationService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Consultation>> getConsultation() {
        try {
            List<Consultation> consultations = consultationService.getConsultations();
            return new ResponseEntity<>(consultations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<Consultation> saveConsultation(@RequestBody Consultation consultation) {
        try {
            return new ResponseEntity<>(consultationService.saveConsultation(consultation), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public Consultation getConsultationById(@PathVariable Long id) {
        return consultationService.getConsultationByID(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        consultationService.deleteByID(id);
    }

    @DeleteMapping(path = "/")
    public void deleteAll() {
        consultationService.deleteAll();
    }

}
