package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "evoluzioni")

public class Evoluzioni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long evoluzioneId;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int stadio;
	
	@ManyToMany(mappedBy = "evoluzioni")
	@JsonIgnore
	private List <Pokemon> pokemon;

	public Long getEvoluzioneId() {
		return evoluzioneId;
	}

	public void setEvoluzioneId(Long evoluzioneId) {
		this.evoluzioneId = evoluzioneId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStadio() {
		return stadio;
	}

	public void setStadio(int stadio) {
		this.stadio = stadio;
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}
	
	
}
