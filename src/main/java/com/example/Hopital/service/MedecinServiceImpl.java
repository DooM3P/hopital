package com.example.Hopital.service;

import com.example.Hopital.DAO.MedecinDAO;
import com.example.Hopital.DAO.SpecialiteDAO;
import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MedecinServiceImpl implements MedecinService{

    @Autowired
    private MedecinDAO MedecinDAO;

    @Autowired
    private SpecialiteDAO specialiteDAO;

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
    public List<Medecin> getMedecinsBySpecialite(Specialite specialite) {
        if(specialite.getName()!= null){
            List<Medecin> medecinsBySpecialite = MedecinDAO.findBySpecialite(specialiteDAO.findByName(specialite.getName()).get());
            if(!medecinsBySpecialite.isEmpty()){
                return medecinsBySpecialite;
            }else {
                return null;
            }
        }
        else {
            List<Medecin> medecinsBySpecialite = MedecinDAO.findBySpecialite(specialite);
            if(!medecinsBySpecialite.isEmpty()) {
                return medecinsBySpecialite;
            }else {
                return null;
            }
        }
    }

    @Override
    public Medecin saveMedecin(Medecin medecin){
        Medecin medecin1 = new Medecin();
        medecin1.setNom(medecin.getNom());
        medecin1.setprenom(medecin.getPrenom());
        medecin1.setSalaire(medecin.getSalaire());
        if(medecin.getSpecialite().getName()!= null){
            medecin1.setSpecialite(specialiteDAO.findByName(medecin.getSpecialite().getName()).get());
        }else {
            medecin1.setSpecialite(medecin.getSpecialite());
        }
        MedecinDAO.save(medecin1);
        return medecin1;
//        return MedecinDAO.save(medecin);
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
