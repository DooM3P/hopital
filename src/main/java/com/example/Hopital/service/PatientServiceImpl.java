package com.example.Hopital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Hopital.models.Patient;
import com.example.Hopital.DAO.PatientDAO;

import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientDAO PatientDAO;



    @Override
    public List<Patient> getPatients() {
        List<Patient> Patients = (List<Patient>) PatientDAO.findAll();
        if(!Patients.isEmpty()){
            return Patients;
        }else {
            return null;
        }
    }

    @Override
    public Patient getPatientByID(Long id) {
        Optional<Patient> _Patient = PatientDAO.findById(id);
        if(_Patient.isPresent()) {
            return _Patient.get();
        }else {
            return null;
        }
    }
    @Override
    public Patient savePatient(Patient Patient){
        return PatientDAO.save(Patient); // plus rapide mais bon...
    }

    @Override
    public Patient updatePatient(Long id, Patient Patient) {
        Optional<Patient> retrievedPatient = PatientDAO.findById(id);
        PatientDAO.save(retrievedPatient.get());
        return retrievedPatient.get();
    }

    @Override
    public void deleteByID(Long id) {
        PatientDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        PatientDAO.deleteAll();
    }


}
