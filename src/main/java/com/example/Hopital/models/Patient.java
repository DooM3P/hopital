package com.example.Hopital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient extends Personne{
    @Column(name = "dejaConsult")
    private boolean dejaConsult =false;

    //Constructeur
    public Patient() {
    }

    public Patient(Long id) {
        super(id);
    }

    public Patient(String nom) {
        super(nom);
    }

    public Patient(boolean dejaConsult) {
        this.dejaConsult = dejaConsult;
    }

    public boolean isDejaConsult() {
        return dejaConsult;
    }

    public void setDejaConsult(boolean dejaConsult) {
        this.dejaConsult = dejaConsult;
    }
}
