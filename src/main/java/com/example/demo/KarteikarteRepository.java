package com.example.demo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KarteikarteRepository extends CrudRepository<Karteikarte, Long> {
}
