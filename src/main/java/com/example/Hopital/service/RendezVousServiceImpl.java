package com.example.Hopital.service;

import com.example.Hopital.DAO.RendezVousDAO;
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
    public List<RendezVous> getRendezVouss() {
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
    public RendezVous saveRendezVous(RendezVous RendezVous){
        //RendezVous _RendezVous = new RendezVous();
        //_RendezVous.setTitle(RendezVous.getTitle());
        //_RendezVous.setAuthor(RendezVous.getAuthor());
        //_RendezVous.setPrice(RendezVous.getPrice());
        //_RendezVous.setCategory(RendezVous.getCategory());
        //RendezVousDAO.save(_RendezVous);
        //return _RendezVous;
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
