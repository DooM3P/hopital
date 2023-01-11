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
}
