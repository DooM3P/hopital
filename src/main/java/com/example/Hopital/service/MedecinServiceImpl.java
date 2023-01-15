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
        Optional<Specialite> specialite1 = specialiteDAO.findByName(specialite.getName());
        if(!specialite1.isEmpty()){
            List<Medecin> medecinsBySpecialite = MedecinDAO.findBySpecialite(specialite1.get()); // Si la specialité est passée en JSON par "name"
            return medecinsBySpecialite;
        }else {
            List<Medecin> medecinsBySpecialite2 = MedecinDAO.findBySpecialite(specialite);// Si la specialité est passée en JSON par "code"
            return medecinsBySpecialite2;
        }
    }

    @Override
    public Medecin saveMedecin(Medecin medecin){
        Medecin medecin2 = new Medecin();
        medecin2.setNom(medecin.getNom());
        medecin2.setprenom(medecin.getPrenom());
        medecin2.setSalaire(medecin.getSalaire());
        medecin2.setDateNaissance(medecin.getDateNaissance());
        Optional<Specialite> specialite = specialiteDAO.findByName(medecin.getSpecialite().getName());
        
        MedecinDAO.save(_Medecin);
        return _Medecin;
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
