package com.example.Hopital.service;

import com.example.Hopital.DAO.MedecinDAO;
import com.example.Hopital.models.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MedecinServiceImpl implements MedecinService{

    @Autowired
    private MedecinDAO MedecinDAO;



    @Override
    public List<Medecin> getMedecins() {
        List<Medecin> Medecins = (List<Medecin>) MedecinDAO.findAll();
        if(!Medecins.isEmpty()){
            return Medecins;
        }else {
            return null;
        }
    }

    @Override
    public Medecin getMedecinByID(Long id) {
        Optional<Medecin> _Medecin = MedecinDAO.findById(id);
        if(_Medecin.isPresent()) {
            return _Medecin.get();
        }else {
            return null;
        }
    }
    @Override
    public Medecin saveMedecin(Medecin Medecin){
        //Medecin _Medecin = new Medecin();
        //_Medecin.setTitle(Medecin.getTitle());
        //_Medecin.setAuthor(Medecin.getAuthor());
        //_Medecin.setPrice(Medecin.getPrice());
        //_Medecin.setCategory(Medecin.getCategory());
        //MedecinDAO.save(_Medecin);
        //return _Medecin;
        return MedecinDAO.save(Medecin); // plus rapide mais bon...
    }

    @Override
    public Medecin updateMedecin(Long id, Medecin Medecin) {
        Optional<Medecin> retrievedMedecin = MedecinDAO.findById(id);
        MedecinDAO.save(retrievedMedecin.get());
        return retrievedMedecin.get();
    }

    @Override
    public void deleteByID(Long id) {
        MedecinDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        MedecinDAO.deleteAll();
    }


}
