package com.example.Hopital.service;

import com.example.Hopital.models.Medecin;

import java.util.List;

public interface MedecinService {
    List<Medecin> getMedecins();

    Medecin getMedecinByID(Long id);

    Medecin saveMedecin(Medecin Medecin);

    Medecin updateMedecin(Long id, Medecin Medecin);

    void deleteByID(Long id);

    void deleteAll();
}
