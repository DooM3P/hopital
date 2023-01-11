package com.example.Hopital.DAO;

import com.example.Hopital.models.Consultation;
import com.example.Hopital.models.Medecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationDAO extends CrudRepository<Consultation, Long> {

}