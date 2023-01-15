package com.example.Hopital.DAO;

import com.example.Hopital.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long> {
    List<Patient> findByNom(String nom);

}
