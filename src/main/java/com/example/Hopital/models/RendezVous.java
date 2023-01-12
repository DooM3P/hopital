package com.example.Hopital.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="rendezvous")
public class RendezVous {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRendezvous;

    @Column(name = "dateRendezVous")
    private LocalDate dateRendezVous;

    @Column(name = "consultationValid")
    private boolean consultationValid=false;

    @ManyToOne
    @JoinColumn(name="code_patient", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="code_medecin", nullable = false)
    private Medecin medecin;

    //Constructeur
    public RendezVous() {
    }


    //Getters et setters

    public Long getId() {
        return idRendezvous;
    }

    public void setId(Long id) {
        this.idRendezvous = id;
    }

    public LocalDate getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(LocalDate dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public boolean isConsultationValid() {
        return consultationValid;
    }

    public void setConsultationValid(boolean consultationValid) {
        this.consultationValid = consultationValid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
}
