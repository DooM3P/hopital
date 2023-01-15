package com.example.Hopital.service;

import com.example.Hopital.models.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getPatients();

    Patient getPatientByID(Long id);

    Patient savePatient(Patient Patient);

    void deleteByID(Long id);

    void deleteAll();
}
