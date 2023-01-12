package com.example.Hopital.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "specialite")
public class Specialite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(name = "name")
    private String name;

    //Constructeur
    public Specialite() {
    }

    public Specialite(Long code) {
        this.code = code;
    }

    public Specialite(String name) {
        this.name = name;
    }

    //Getters et setters
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
