package com.example.Hopital.service;

import com.example.Hopital.DAO.SpecialiteDAO;
import com.example.Hopital.models.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SpecialiteServiceImpl implements SpecialiteService{

    @Autowired
    private SpecialiteDAO SpecialiteDAO;



    @Override
    public List<Specialite> getSpecialites() {
        List<Specialite> Specialites = (List<Specialite>) SpecialiteDAO.findAll();
        if(!Specialites.isEmpty()){
            return Specialites;
        }else {
            return null;
        }
    }

    @Override
    public Specialite getSpecialiteByID(Long id) {
        Optional<Specialite> _Specialite = SpecialiteDAO.findById(id);
        return _Specialite.orElse(null);
    }

    @Override
    public Specialite saveSpecialite(Specialite Specialite){
        return SpecialiteDAO.save(Specialite); // plus rapide mais bon...
    }

    @Override
    public void deleteByID(Long id) {
        SpecialiteDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        SpecialiteDAO.deleteAll();
    }


}
