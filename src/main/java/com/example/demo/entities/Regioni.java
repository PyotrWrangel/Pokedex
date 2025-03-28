package com.example.demo.entities;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "regioni")

public class Regioni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regionId;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int numeroPalestre;
	
	@OneToMany(mappedBy = "regioni")
	private List <Allenatori> allenatori;

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroPalestre() {
		return numeroPalestre;
	}

	public void setNumeroPalestre(int numeroPalestre) {
		this.numeroPalestre = numeroPalestre;
	}

	public List<Allenatori> getAllenatori() {
		return allenatori;
	}

	public void setAllenatori(List<Allenatori> allenatori) {
		this.allenatori = allenatori;
	}
	
	
}
