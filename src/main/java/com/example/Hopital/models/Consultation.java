package com.example.Hopital.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="consultation")
public class Consultation {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateRendezVous")
    private LocalDate dateRendezVous;

    @Column(name = "consultationValid")
    private boolean consultationValid;

    @ManyToOne
    @JoinColumn(name="code_patient", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="code_medecin", nullable = false)
    private Medecin medecin;

    public Consultation() {
    }
}
