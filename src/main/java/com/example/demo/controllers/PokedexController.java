package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Evoluzioni;
import com.example.demo.entities.Pokemon;
import com.example.demo.repositories.EvoluzioniRepository;
import com.example.demo.services.PokemonService;

@RestController
@RequestMapping("/Pokedex")

public class PokedexController {

	@Autowired
	private PokemonService pokemonService;

	@Autowired
	private EvoluzioniRepository evoluzioniRepository;

	@GetMapping("/visualizzapokemon")
	public List<Pokemon> getAllPokemon() {
		return pokemonService.getAllPokemon();
	}

	
	@PostMapping("/aggiungipokemon")
	public Pokemon addPokemon(@RequestBody Pokemon pokemon) { // chiamo metodo aggiungi un pokemon alla volta
		List<Evoluzioni> evoluzioniList = new ArrayList<>(); // prende la lista con gli id evoluzioni
		if (pokemon.getEvoluzioni() != null) {
			for (Evoluzioni evoluzioni : pokemon.getEvoluzioni()) {
				if (evoluzioni.getNome() != null && !evoluzioni.getNome().trim().isEmpty()) {
				    try {
				        // Cerca l'evoluzione
				        Evoluzioni e = evoluzioniRepository.findByNome(evoluzioni.getNome()).orElseThrow(() -> new RuntimeException("Evoluzione non trovata: " + evoluzioni.getNome()));
				        evoluzioniList.add(e);
				    } catch (RuntimeException e) {
				        System.out.println("Evoluzione non trovata, creando una nuova evoluzione: " + evoluzioni.getNome());
				        Evoluzioni nuovaEvoluzione = evoluzioniRepository.save(evoluzioni);  // Salva la nuova evoluzione
				        evoluzioniList.add(nuovaEvoluzione);
				    }
				} 

			}

		}
		pokemon.setEvoluzioni(evoluzioniList);
		return pokemonService.addPokemon(pokemon);
	}

	@DeleteMapping("/deletepokemon/{pokemonId}") // metodo che risponde alle richieste http delete, ("/{id}") significa
													// che l'endpoint include un id nell'url che passiamo
	public ResponseEntity<String> deletePokemon(@PathVariable Long pokemonId) { // response entity costruisce la  risposta e chiamiamo il metodo  deletePokemon
		// (@PathVariable Long pokemonId) il pathvariable indica l'estrazione del'valore{id} dalla URL e lo passiamo come parametro
		try { // metodo try per prevedere errore nel caso di mancato successo
			pokemonService.deletePokemon(pokemonId); // chiamiamo il metodo dentro pokemonService

			return ResponseEntity.ok("Pokemon eliminato con successo"); // risposta di ritorno
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // risposta nel caso di errore
		}
	}

	@PutMapping("/modificapokemon/{pokemonId}")

	public ResponseEntity<Pokemon> modifyPokemon(@PathVariable Long pokemonId, @RequestBody Pokemon updatedPokemon) {
		try {
			pokemonService.modifyPokemon(pokemonId, updatedPokemon);
			return ResponseEntity.ok(updatedPokemon);
		} catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // In caso di errore
		}
		}
	}
