package com.example.Hopital.controller;

import com.example.Hopital.models.RendezVous;
import com.example.Hopital.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/rendezvous") // This means URL's start with /demo (after Application path)
public class RendezVousController {
    @Autowired // This means to get the bean called RendezVousService
    private RendezVousService rendezVousService;

    @GetMapping(path = "/")
    public ResponseEntity<List<RendezVous>> getRendezVous() {
        try {
            List<RendezVous> rendezVous = rendezVousService.getRendezVouss();
            return new ResponseEntity<>(rendezVous, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<RendezVous> saveRendezVous(@RequestBody RendezVous rendezVous) {
        try {
            return new ResponseEntity<>(rendezVousService.saveRendezVous(rendezVous), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(rendezVousService.getRendezVousByID(id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        rendezVousService.deleteByID(id);
    }

    @DeleteMapping(path = "/")
    public void deleteAll() {
        rendezVousService.deleteAll();
    }

}
