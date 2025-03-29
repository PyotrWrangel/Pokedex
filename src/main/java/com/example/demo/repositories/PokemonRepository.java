package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	//query per resettare auto_increment
	@Modifying
	@Query(value = "ALTER TABLE pokemon AUTO_INCREMENT = 1", nativeQuery = true)	//query che resetta
	void resetAutoIncrement();
}
