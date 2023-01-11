package com.example.Hopital.models;

import jakarta.persistence.*;

@Entity
@Table(name="medecin")
public class Medecin extends Personne{
    @Column(name = "salaire")
    private int salaire;

    @ManyToOne
    @JoinColumn(name="code_specialite", nullable = false)
    private Specialite specialite;
}
