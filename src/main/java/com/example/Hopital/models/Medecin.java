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

    //Constructeurs
    public Medecin() {
    }

    public Medecin(Long id) {
        super(id);
    }

    public Medecin(String nom) {
        super(nom);
    }

    public Medecin(int salaire, Specialite specialite) {
        this.salaire = salaire;
        this.specialite = specialite;
    }

    // Getters et Setters
    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
}
