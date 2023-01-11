package com.example.Hopital.DAO;

import com.example.Hopital.models.Specialite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialiteDAO extends CrudRepository<Specialite, Long> {
    Optional<Specialite> findByName(String name);
}
