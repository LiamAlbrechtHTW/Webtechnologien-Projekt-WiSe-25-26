package com.example.demo.service;

import com.example.demo.entity.Karteikarte;
import com.example.demo.repository.KarteikarteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class KarteikarteServiceTest {

    @Mock KarteikarteRepository repo;
    @InjectMocks KarteikarteService service;

    @Test
    void create_setsSessionId_andNullsId_andSaves() {
        var input = new Karteikarte();
        input.setId(999L);
        input.setFrage("F?");
        input.setAntwort("A!");

        when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        var saved = service.create("S1", input);

        // Rückgabe prüfen
        assertNull(saved.getId(), "id muss vor dem Save null gesetzt werden");
        assertEquals("S1", saved.getSessionId());
        assertEquals("F?", saved.getFrage());
        assertEquals("A!", saved.getAntwort());

        // Argument an save() prüfen
        ArgumentCaptor<Karteikarte> captor = ArgumentCaptor.forClass(Karteikarte.class);
        verify(repo, times(1)).save(captor.capture());

        Karteikarte toSave = captor.getValue();
        assertNull(toSave.getId());
        assertEquals("S1", toSave.getSessionId());
        assertEquals("F?", toSave.getFrage());
        assertEquals("A!", toSave.getAntwort());
    }

    @Test
    void getAll_callsRepoFindBySessionId() {
        when(repo.findBySessionId("S1")).thenReturn(List.of(
                new Karteikarte(1L, "F", "A", "S1")
        ));

        var list = service.getAll("S1");

        assertEquals(1, list.size());
        verify(repo, times(1)).findBySessionId("S1");
    }

    @Test
    void update_updatesFields_andSaves() {
        var existing = new Karteikarte(7L, "alt", "alt", "S1");
        when(repo.findByIdAndSessionId(7L, "S1")).thenReturn(Optional.of(existing));
        when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        var input = new Karteikarte();
        input.setFrage("neuF");
        input.setAntwort("neuA");

        var updated = service.update("S1", 7L, input);

        assertEquals("neuF", updated.getFrage());
        assertEquals("neuA", updated.getAntwort());
        assertEquals("S1", updated.getSessionId());

        verify(repo, times(1)).findByIdAndSessionId(7L, "S1");
        verify(repo, times(1)).save(existing);
    }

    @Test
    void update_throwsIfNotFound() {
        when(repo.findByIdAndSessionId(7L, "S1")).thenReturn(Optional.empty());

        var input = new Karteikarte();
        input.setFrage("neuF");
        input.setAntwort("neuA");

        assertThrows(NoSuchElementException.class, () -> service.update("S1", 7L, input));
        verify(repo, times(1)).findByIdAndSessionId(7L, "S1");
        verify(repo, never()).save(any());
    }

    @Test
    void create_throwsOnBlankFields() {
        var input = new Karteikarte();
        input.setFrage(" ");
        input.setAntwort("");

        assertThrows(IllegalArgumentException.class, () -> service.create("S1", input));
        verify(repo, never()).save(any());
    }
}
