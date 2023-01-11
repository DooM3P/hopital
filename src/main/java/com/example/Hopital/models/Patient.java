package com.example.Hopital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient extends Personne{
    @Column(name = "firstConsult")
    private boolean firstConsult;
}
