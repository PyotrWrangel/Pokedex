package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@GetMapping
//	public String welcome() {
//		return "benvenuto nel pokedex!";
//	}
	
	@GetMapping("/visualizzapokemon")
	public List<Pokemon> getAllPokemon() {
		return pokemonService.getAllPokemon();
	}
	
	@PostMapping("/aggiungipokemon")
	public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
		//gestisco le evoluzioni
		if(pokemon.getEvoluzioni() != null) {
			 List<Evoluzioni> evoluzioniList = new ArrayList<>();
			for (Evoluzioni evoluzioni : pokemon.getEvoluzioni()) {
				Evoluzioni e = evoluzioniRepository.findById(evoluzioni.getEvoluzioneId()).orElseThrow(() -> new RuntimeException("Evoluzione non trovata"));
				evoluzioniList.add(e);
			}
			pokemon.setEvoluzioni(evoluzioniList);
		}
		return pokemonService.addPokemon(pokemon);
	}
	
	

}
