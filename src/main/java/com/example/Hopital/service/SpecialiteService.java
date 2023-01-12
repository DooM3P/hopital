package com.example.Hopital.service;

import com.example.Hopital.models.Specialite;

import java.util.List;

public interface SpecialiteService {
    List<Specialite> getSpecialites();

    Specialite getSpecialiteByID(Long id);

    Specialite getSpecialiteByName(String name);

    Specialite saveSpecialite(Specialite Specialite);

    Specialite updateSpecialite(Long id, Specialite Specialite);

    void deleteByID(Long id);

    void deleteAll();
}
