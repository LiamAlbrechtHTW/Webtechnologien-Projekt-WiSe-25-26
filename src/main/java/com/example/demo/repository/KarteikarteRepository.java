package com.example.demo.repository;

import com.example.demo.entity.Karteikarte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KarteikarteRepository extends JpaRepository<Karteikarte, Long> {

    List<Karteikarte> findBySessionId(String sessionId);

    Optional<Karteikarte> findByIdAndSessionId(Long id, String sessionId);

    void deleteByIdAndSessionId(Long id, String sessionId);
}
