package com.example.Hopital.service;

import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Specialite;

import java.util.List;

public interface MedecinService {
    List<Medecin> getMedecins();

    Medecin getMedecinByID(Long id);


    List<Medecin> getMedecinsBySpecialite(Specialite specialite);

    Medecin saveMedecin(Medecin Medecin);


    void deleteByID(Long id);

    void deleteAll();
}
