package com.example.Hopital.service;

import com.example.Hopital.DAO.ConsultationDAO;
import com.example.Hopital.models.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConsultationServiceImpl implements ConsultationService{

    @Autowired
    private ConsultationDAO consultationDAO;



    @Override
    public List<Consultation> getConsultations() {
        List<Consultation> Consultations = (List<Consultation>) consultationDAO.findAll();
        if(!Consultations.isEmpty()){
            return Consultations;
        }else {
            return null;
        }
    }

    @Override
    public Consultation getConsultationByID(Long id) {
        Optional<Consultation> _Consultation = consultationDAO.findById(id);
        if(_Consultation.isPresent()) {
            return _Consultation.get();
        }else {
            return null;
        }
    }
    @Override
    public Consultation saveConsultation(Consultation Consultation){
        //Consultation _Consultation = new Consultation();
        //_Consultation.setTitle(Consultation.getTitle());
        //_Consultation.setAuthor(Consultation.getAuthor());
        //_Consultation.setPrice(Consultation.getPrice());
        //_Consultation.setCategory(Consultation.getCategory());
        //ConsultationDAO.save(_Consultation);
        //return _Consultation;
        return consultationDAO.save(Consultation); // plus rapide mais bon...
    }

    @Override
    public Consultation updateConsultation(Long id, Consultation Consultation) {
        Optional<Consultation> retrievedConsultation = consultationDAO.findById(id);
        consultationDAO.save(retrievedConsultation.get());
        return retrievedConsultation.get();
    }

    @Override
    public void deleteByID(Long id) {
        consultationDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        consultationDAO.deleteAll();
    }


}
