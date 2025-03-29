package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Evoluzioni;

public interface EvoluzioniRepository extends JpaRepository<Evoluzioni, Long> {
	Optional<Evoluzioni> findByNome(String nome);

}
