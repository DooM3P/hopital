package com.example.Hopital.service;

import com.example.Hopital.models.RendezVous;

import java.util.List;

public interface RendezVousService {
    List<RendezVous> getRendezVouss();

    RendezVous getRendezVousByID(Long id);

    RendezVous saveRendezVous(RendezVous RendezVous);

    RendezVous updateRendezVous(Long id, RendezVous RendezVous);

    void deleteByID(Long id);

    void deleteAll();
}
