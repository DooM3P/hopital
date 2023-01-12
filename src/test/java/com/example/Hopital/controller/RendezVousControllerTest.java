package com.example.Hopital.controller;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.when;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RendezVousControllerTest {
    @InjectMocks
    private RendezVousController rendezVousController;

    @Mock
    private RendezVousService rendezVousService;

    @Test
    public void getRendezVouss_withoutException(){

        //Given
        List<RendezVous> list = new ArrayList<>();

        RendezVous firstRendezVous = new RendezVous();
        RendezVous secondRendezVous = new RendezVous();

        list.add(secondRendezVous);
        list.add(firstRendezVous);

        //When
        when(rendezVousService.getRendezVouss()).thenReturn(list);
        ResponseEntity<List<RendezVous>> resultat = rendezVousController.getRendezVous();

        //Then
        assertEquals(2, resultat.getBody().size());
        assertEquals(HttpStatus.OK, resultat.getStatusCode());

    }
    @Test(expected = NullPointerException.class)
    public void getRendezVouss_withException(){
        when(rendezVousService.getRendezVouss()).thenThrow(new NullPointerException("Error occurred"));

        //then
        assertTrue(rendezVousController.getRendezVous().getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @Test
//    public void deleteRendezVoussTest() throws Exception {
//        //given
//        RendezVous rendezVous = new RendezVous();
//        rendezVous.setId(2L);
////        rendezVous.setTitle("Hhhh");
////        rendezVous.setAuthor("Gilles H");
////        rendezVous.setPrice(30);
//
//        //when
//
//        Mockito.when(rendezVousService.saveRendezVous(rendezVous)).thenReturn(rendezVous);
//        rendezVousController.saveRendezVous(rendezVous);
//        rendezVousController.deleteAll();
//
//        ResponseEntity<RendezVous> response = rendezVousController.getRendezVousById(2L);
//
//        //then
//        assertThat(response.getBody()).isNull();
//
//    }
}
