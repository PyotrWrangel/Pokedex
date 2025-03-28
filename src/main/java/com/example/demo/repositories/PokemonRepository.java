package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
