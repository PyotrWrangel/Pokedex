package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pokemon;
import com.example.demo.repositories.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	public List<Pokemon> getAllPokemon() {
		return pokemonRepository.findAll();
	}
	
	public Pokemon addPokemon(Pokemon pokemon) {
		if (pokemon.getPokemonId() == null) {
			return pokemonRepository.save(pokemon);
		}
		return null;
	}
}
