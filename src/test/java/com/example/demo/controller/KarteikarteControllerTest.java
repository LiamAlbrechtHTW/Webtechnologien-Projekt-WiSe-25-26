package com.example.demo.controller;

import com.example.demo.entity.Karteikarte;
import com.example.demo.service.KarteikarteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(KarteikarteController.class)
class KarteikarteControllerTest {

    @Autowired MockMvc mvc;

    @MockBean KarteikarteService service;

    @Test
    void getAll_returnsList() throws Exception {
        when(service.getAll("S1")).thenReturn(List.of(
                new Karteikarte(1L, "F1", "A1", "S1"),
                new Karteikarte(2L, "F2", "A2", "S1")
        ));

        mvc.perform(get("/api/sessions/S1/cards"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].frage").value("F1"))
                .andExpect(jsonPath("$[1].antwort").value("A2"));
    }

    @Test
    void create_returnsCreatedCard() throws Exception {
        var created = new Karteikarte(10L, "F", "A", "S1");
        when(service.create(org.mockito.ArgumentMatchers.eq("S1"), org.mockito.ArgumentMatchers.any()))
                .thenReturn(created);

        mvc.perform(post("/api/sessions/S1/cards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"frage\":\"F\",\"antwort\":\"A\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.sessionId").value("S1"));
    }
}
