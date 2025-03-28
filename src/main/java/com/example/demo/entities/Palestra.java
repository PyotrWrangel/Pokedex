package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "palestra")

public class Palestra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long palestraId;
	private String nome;
	private String tipologia;
	private String difficoltà;
	
	@OneToOne()
	@JoinColumn(name = "capopalestraId")
	private Capopalestra capopalestra;
	
	@OneToMany
	@JoinColumn(name = "regioneId")
	private List <Regioni> regioni;
	
	@OneToOne (mappedBy = "palestra")
	private Allenatori allenatori;

	public Long getPalestraId() {
		return palestraId;
	}

	public void setPalestraId(Long palestraId) {
		this.palestraId = palestraId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getDifficoltà() {
		return difficoltà;
	}

	public void setDifficoltà(String difficoltà) {
		this.difficoltà = difficoltà;
	}

	public Capopalestra getCapopalestra() {
		return capopalestra;
	}

	public void setCapopalestra(Capopalestra capopalestra) {
		this.capopalestra = capopalestra;
	}

	public List<Regioni> getRegioni() {
		return regioni;
	}

	public void setRegioni(List<Regioni> regioni) {
		this.regioni = regioni;
	}
}
