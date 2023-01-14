package com.example.Hopital.controller;

import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Patient;
import com.example.Hopital.models.RendezVous;
import com.example.Hopital.service.RendezVousService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RendezVousControllerTest {
    @InjectMocks
    private RendezVousController rendezVousController;

    @Mock
    private RendezVousService rendezVousService;

    @Test
    public void getRendezVous_withoutException(){

        //Given
        List<RendezVous> list = new ArrayList<>();

        RendezVous firstRendezVous = new RendezVous();
        RendezVous secondRendezVous = new RendezVous();

        list.add(secondRendezVous);
        list.add(firstRendezVous);

        //When
        when(rendezVousService.getRendezVous()).thenReturn(list);
        ResponseEntity<List<RendezVous>> resultat = rendezVousController.getRendezVous();

        //Then
        assertEquals(2, resultat.getBody().size());
        assertEquals(HttpStatus.OK, resultat.getStatusCode());

    }
    @Test(expected = NullPointerException.class)
    public void getRendezVous_withException(){
        when(rendezVousService.getRendezVous()).thenThrow(new NullPointerException("Error occurred"));

        //then
        assertSame(rendezVousController.getRendezVous().getStatusCode(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void deleteRendezVousTest() throws Exception {
        //given
        RendezVous rendezVous = new RendezVous();
        Medecin medecin = new Medecin();
        Patient patient = new Patient();
        rendezVous.setId(2L);
        rendezVous.setConsultationValid(true);
        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);

        //when

        Mockito.when(rendezVousService.saveRendezVous(rendezVous)).thenReturn(rendezVous);
        rendezVousController.saveRendezVous(rendezVous);
        rendezVousController.deleteAll();

        ResponseEntity<RendezVous> response = rendezVousController.getRendezVousById(2L);

        //then
        assertThat(response.getBody()).isNull();

    }
}
