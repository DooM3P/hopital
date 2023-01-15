package com.example.Hopital.service;

import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Patient;
import com.example.Hopital.models.RendezVous;

import java.util.List;

public interface RendezVousService {
    List<RendezVous> getRendezVous();

    RendezVous getRendezVousByID(Long id);

    RendezVous saveRendezVous(RendezVous RendezVous);

    List<RendezVous> getRendezVousByMedecin(Medecin medecin);

    List<RendezVous> getRendezVousByPatient(Patient patient);

    RendezVous consultationCheckById(Long id);

    void deleteByID(Long id);

    void deleteAll();

}
