package com.example.Hopital.service;

import com.example.Hopital.DAO.MedecinDAO;
import com.example.Hopital.DAO.PatientDAO;
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

    @Autowired
    private MedecinDAO medecinDAO;

    @Autowired
    private PatientDAO patientDAO;



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
        return _RendezVous.orElse(null);
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
        if(rendezVous.isPresent() & !rendezVous.get().isConsultationValid()) {
            rendezVous.get().setConsultationValid(true);
            rendezVous.get().getPatient().setDejaConsult(true);
            return rendezVousDAO.save(rendezVous.get());
        }
        else {
            return null;
        }
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous){
        RendezVous rendezVous1 = new RendezVous();

        List<Patient> patient = patientDAO.findByNom(rendezVous.getPatient().getNom());//Récupère le patient passé en nom ou en code
        if(!patient.isEmpty()){
            rendezVous1.setPatient(patient.get(0));
        }else{
            rendezVous1.setPatient(rendezVous.getPatient());
        }

        List<Medecin> medecin = medecinDAO.findByNom(rendezVous.getMedecin().getNom());//Récupère le medecin passé en nom ou en code
        if(!medecin.isEmpty()){
            rendezVous1.setMedecin(medecin.get(0));
        }else{
            rendezVous1.setMedecin(rendezVous.getMedecin());
        }

        rendezVous1.setDateRendezVous(rendezVous.getDateRendezVous());
        rendezVous1.setConsultationValid(rendezVous.isConsultationValid());
        return rendezVousDAO.save(rendezVous1);
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
