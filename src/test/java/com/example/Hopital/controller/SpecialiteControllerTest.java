package com.example.Hopital.controller;

import com.example.Hopital.models.Medecin;
import com.example.Hopital.models.Patient;
import com.example.Hopital.models.RendezVous;
import com.example.Hopital.models.Specialite;
import com.example.Hopital.service.RendezVousService;
import com.example.Hopital.service.SpecialiteService;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class SpecialiteControllerTest {
    @InjectMocks
    private SpecialiteController specialiteController;

    @Mock
    private SpecialiteService specialiteService;

    @Test
    public void getSpecialite_withoutException(){

        //Given
        List<Specialite> list = new ArrayList<>();

        Specialite specialite = new Specialite();
        Specialite specialite1 = new Specialite();

        list.add(specialite);
        list.add(specialite);

        //When
        when(specialiteService.getSpecialites()).thenReturn(list);
        ResponseEntity<List<Specialite>> resultat = specialiteController.getSpecialite();

        //Then
        assertEquals(2, resultat.getBody().size());
        assertEquals(HttpStatus.OK, resultat.getStatusCode());

    }
    @Test(expected = NullPointerException.class)
    public void getSpecialite_withException(){
        when(specialiteService.getSpecialites()).thenThrow(new NullPointerException("Error occurred"));

        //then
        assertSame(specialiteController.getSpecialite().getStatusCode(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void deleteSpecialiteTest() throws Exception {
        //given
        Specialite specialite = new Specialite();

        specialite.setCode(2L);
        specialite.setName("Egyptologue");

        //when

        Mockito.when(specialiteService.saveSpecialite(specialite)).thenReturn(specialite);
        specialiteController.saveSpecialite(specialite);
        specialiteController.deleteAll();

        ResponseEntity<Specialite> response = specialiteController.getSpecialiteById(2L);

        //then
        assertThat(response.getBody()).isNull();

    }
}
