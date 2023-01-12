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
        if(_Specialite.isPresent()) {
            return _Specialite.get();
        }else {
            return null;
        }
    }

    @Override
    public Specialite getSpecialiteByName(String name) {
        Optional<Specialite> specialite = SpecialiteDAO.findByName(name);
        if(specialite.isPresent()) {
            return specialite.get();
        }else {
            return null;
        }
    }

    @Override
    public Specialite saveSpecialite(Specialite Specialite){
        //Specialite _Specialite = new Specialite();
        //_Specialite.setTitle(Specialite.getTitle());
        //_Specialite.setAuthor(Specialite.getAuthor());
        //_Specialite.setPrice(Specialite.getPrice());
        //_Specialite.setCategory(Specialite.getCategory());
        //SpecialiteDAO.save(_Specialite);
        //return _Specialite;
        return SpecialiteDAO.save(Specialite); // plus rapide mais bon...
    }

    @Override
    public Specialite updateSpecialite(Long id, Specialite Specialite) {
        Optional<Specialite> retrievedSpecialite = SpecialiteDAO.findById(id);
        SpecialiteDAO.save(retrievedSpecialite.get());
        return retrievedSpecialite.get();
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
