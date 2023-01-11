package com.example.Hopital.DAO;

import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin, Long> {

}