package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "allenatore")

public class Allenatori {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long allenatoreId;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private int numeroPokemon;
	
	@Column(nullable = false)
	private String pokemonPreferito;
	
	@OneToMany(mappedBy = "allenatori") //UN solo allenatore per ogni posizione
	private List<Classifica> classifica;
	
	@OneToOne	//
	@JoinColumn(name = "palestraId")
	private Palestra palestra;
	
	//ogni allenatore MANY può essere associato ad una sola regione ONE
	//al contrario una regione ONE puo avere tanti allenatori MANY
	@ManyToOne
	@JoinColumn(name = "regioneId")
	private Regioni regioni;

	public Long getAllenatoreId() {
		return allenatoreId;
	}

	public void setAllenatoreId(Long allenatoreId) {
		this.allenatoreId = allenatoreId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getNumeroPokemon() {
		return numeroPokemon;
	}

	public void setNumeroPokemon(int numeroPokemon) {
		this.numeroPokemon = numeroPokemon;
	}

	public String getPokemonPreferito() {
		return pokemonPreferito;
	}

	public void setPokemonPreferito(String pokemonPreferito) {
		this.pokemonPreferito = pokemonPreferito;
	}

	public List<Classifica> getClassifica() {
		return classifica;
	}

	public void setClassifica(List<Classifica> classifica) {
		this.classifica = classifica;
	}

	public Palestra getPalestra() {
		return palestra;
	}

	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
	}

	public Regioni getRegioni() {
		return regioni;
	}

	public void setRegioni(Regioni regioni) {
		this.regioni = regioni;
	}
	
	

}
