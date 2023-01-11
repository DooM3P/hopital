package com.example.Hopital.service;

import com.example.Hopital.models.Consultation;

import java.util.List;

public interface ConsultationService {
    List<Consultation> getConsultations();

    Consultation getConsultationByID(Long id);

    Consultation saveConsultation(Consultation Consultation);

    Consultation updateConsultation(Long id, Consultation Consultation);

    void deleteByID(Long id);

    void deleteAll();
}
