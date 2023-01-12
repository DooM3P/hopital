package com.example.Hopital.DAO;

import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Patient;
import com.example.Hopital.models.RendezVous;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousDAO extends CrudRepository<RendezVous, Long> {
    List<RendezVous> findByPatient(Patient patient);
    List<RendezVous> findByMedecin(Medecin medecin);
}