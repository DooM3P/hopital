package com.example.Hopital.DAO;

import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Patient;
import com.example.Hopital.models.RendezVous;
import com.example.Hopital.models.Specialite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin, Long> {
    List<Medecin> findBySpecialite(Specialite specialite);
}