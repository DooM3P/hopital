package com.example.Hopital.DAO;

import com.example.Hopital.models.RendezVous;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousDAO extends CrudRepository<RendezVous, Long> {

}