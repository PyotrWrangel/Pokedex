package com.example.demo.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;



@Entity
@Table(name = "pokemon")
	

public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pokemonId;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String descr;
	
	@ManyToMany
	@JoinTable(name = "pokemon_evoluzioni", //nome tabella intermedia
		joinColumns = @JoinColumn(name = "pokemonId"),
		inverseJoinColumns = @JoinColumn(name = "evoluzioneId"))
	
	private List<Evoluzioni> evoluzioni;

	public Long getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(Long pokemonId) {
		this.pokemonId = pokemonId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<Evoluzioni> getEvoluzioni() {
		return evoluzioni;
	}

	public void setEvoluzioni(List<Evoluzioni> evoluzioni) {
		this.evoluzioni = evoluzioni;
	}
	
	
}
