package com.example.Hopital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient extends Personne{
    @Column(name = "firstConsult")
    private boolean firstConsult=false;

    //Constructeur
    public Patient() {
    }



    public Patient(boolean firstConsult) {
        this.firstConsult = firstConsult;
    }

    public boolean isFirstConsult() {
        return firstConsult;
    }

    public void setFirstConsult(boolean firstConsult) {
        this.firstConsult = firstConsult;
    }
}
