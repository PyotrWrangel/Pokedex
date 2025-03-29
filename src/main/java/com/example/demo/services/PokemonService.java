package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Evoluzioni;
import com.example.demo.entities.Pokemon;
import com.example.demo.repositories.PokemonRepository;

import jakarta.transaction.Transactional;

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

	@Transactional
	public void deletePokemon(long pokemonId) { // qui chiamo l'id che poi passo nell'if
		if (pokemonRepository.existsById(pokemonId)) { // accertiamo che l'id sia presente
			pokemonRepository.deleteById(pokemonId); // eliminiamo
			pokemonRepository.resetAutoIncrement();
		} else {
			throw new RuntimeException("Pokemon non trovato con ID: " + pokemonId);
		}
	}

	public void modifyPokemon(long pokemonId, Pokemon updatedPokemon) {
		List<Evoluzioni> evoluzioniList = new ArrayList<>();//inseriamo sia l'id che l'oggetto pokemon che dobbiamo modificare
		if (pokemonRepository.existsById(pokemonId)) {	//controlliamo se il pokemon esiste nel database
			  Pokemon existingPokemon = pokemonRepository.findById(pokemonId).orElseThrow(() ->
	            new RuntimeException("Pokemon non trovato con ID: " + pokemonId));
			  //aggiorniamo le proprieta esistenti con quelle del nuovo pokemon
			existingPokemon.setNome(updatedPokemon.getNome());
			existingPokemon.setDescr(updatedPokemon.getDescr());
			existingPokemon.setType(updatedPokemon.getType());
			existingPokemon.setEvoluzioni(updatedPokemon.getEvoluzioni());
			//salviamo il pokemon nel database
			pokemonRepository.save(existingPokemon);
		} else {
			throw new RuntimeException("Pokemon non trovato con ID: " + pokemonId);
		}

	}

}
