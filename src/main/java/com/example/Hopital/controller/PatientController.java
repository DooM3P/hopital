package com.example.Hopital.controller;


import com.example.Hopital.models.Patient;
import com.example.Hopital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/patient") // This means URL's start with /demo (after Application path)
public class PatientController {
    @Autowired // This means to get the bean called PatientService
    private PatientService patientService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Patient>> getPatient() {
        try {
            List<Patient> Patients = patientService.getPatients();
            return new ResponseEntity<>(Patients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientByID(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        patientService.deleteByID(id);
    }

    @DeleteMapping(path = "/")
    public void deleteAll() {
        patientService.deleteAll();
    }

}
