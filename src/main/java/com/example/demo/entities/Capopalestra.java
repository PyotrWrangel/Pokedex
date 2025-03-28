package com.example.demo.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "capopalestra")

public class Capopalestra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long capopalestraId;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String backstory;
	
	
	//relazione palestra capopalestra
	@OneToOne(mappedBy = "capopalestra")
	private Palestra palestra;

	public Long getCapopalestraId() {
		return capopalestraId;
	}

	public void setCapopalestraId(Long capopalestraId) {
		this.capopalestraId = capopalestraId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBackstory() {
		return backstory;
	}

	public void setBackstory(String backstory) {
		this.backstory = backstory;
	}

	public Palestra getCapopalestra() {
		return palestra;
	}

	public void setCapopalestra(Palestra palestra) {
		this.palestra = palestra;
	}
	
	
}
