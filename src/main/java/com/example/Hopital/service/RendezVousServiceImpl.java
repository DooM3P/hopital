package com.example.Hopital.service;

import com.example.Hopital.DAO.RendezVousDAO;
import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Patient;
import com.example.Hopital.models.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RendezVousServiceImpl implements RendezVousService {

    @Autowired
    private RendezVousDAO rendezVousDAO;



    @Override
    public List<RendezVous> getRendezVous() {
        List<RendezVous> rendezVous = (List<RendezVous>) rendezVousDAO.findAll();
        if(!rendezVous.isEmpty()){
            return rendezVous;
        }else {
            return null;
        }
    }

    @Override
    public RendezVous getRendezVousByID(Long id) {
        Optional<RendezVous> _RendezVous = rendezVousDAO.findById(id);
        if(_RendezVous.isPresent()) {
            return _RendezVous.get();
        }else {
            return null;
        }
    }

    @Override
    public List<RendezVous> getRendezVousByMedecin(Medecin medecin) {
        List<RendezVous> rendezVousMedecin = rendezVousDAO.findByMedecin(medecin);
        if(!rendezVousMedecin.isEmpty()) {
            return rendezVousMedecin;
        }else {
            return null;
        }
    }

    @Override
    public List<RendezVous> getRendezVousByPatient(Patient patient) {
        List<RendezVous> rendezVousPatient = rendezVousDAO.findByPatient(patient);
        if(!rendezVousPatient.isEmpty()) {
            return rendezVousPatient;
        }else {
            return null;
        }
    }
    @Override
    public RendezVous consultationCheckById(Long id) {
        Optional<RendezVous> rendezVous = rendezVousDAO.findById(id);
        if(rendezVous.isPresent() & rendezVous.get().isConsultationValid()==false) {
            rendezVous.get().setConsultationValid(true);
            rendezVous.get().getPatient().setDejaConsult(true);
            return rendezVousDAO.save(rendezVous.get());
        }
        else {
            return null;
        }
    }

    @Override
    public RendezVous saveRendezVous(RendezVous RendezVous){
        return rendezVousDAO.save(RendezVous); // plus rapide mais bon...
    }

    @Override
    public RendezVous updateRendezVous(Long id, RendezVous RendezVous) {
        Optional<RendezVous> retrievedRendezVous = rendezVousDAO.findById(id);
        rendezVousDAO.save(retrievedRendezVous.get());
        return retrievedRendezVous.get();
    }

    @Override
    public void deleteByID(Long id) {
        rendezVousDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        rendezVousDAO.deleteAll();
    }


}
