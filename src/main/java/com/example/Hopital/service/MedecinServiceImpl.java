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
        return _Medecin.orElse(null);
    }

    @Override
    public List<Medecin> getMedecinsBySpecialite(Specialite specialite) {
        Optional<Specialite> specialite1 = specialiteDAO.findByName(specialite.getName());
        if(specialite1.isPresent()){
            return MedecinDAO.findBySpecialite(specialite1.get());
        }else {
            return MedecinDAO.findBySpecialite(specialite);
        }
    }

    @Override
    public Medecin saveMedecin(Medecin medecin){
        Medecin medecin1 = new Medecin();
        medecin1.setNom(medecin.getNom());
        medecin1.setprenom(medecin.getPrenom());
        medecin1.setSalaire(medecin.getSalaire());
        medecin1.setDateNaissance(medecin.getDateNaissance());
        Optional<Specialite> specialite1 = specialiteDAO.findByName(medecin.getSpecialite().getName());
        if(specialite1.isPresent()){
            medecin1.setSpecialite(specialite1.get());// Si la specialité est passée en JSON par "name"
        }else {
            medecin1.setSpecialite(medecin.getSpecialite());// Si la specialité est passée en JSON par "code"
        }
        MedecinDAO.save(medecin1);
        return medecin1;
//        return MedecinDAO.save(medecin);
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
