package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "classifica")

public class Classifica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classificaId;
	
	@Column(nullable = false)
	private int posizione;
	
	//relazione 
	@ManyToOne	// OGNI posizione della classifica permette UN solo allenatore alla volta
	@JoinColumn(name = "allenatoreId")
	
	private Allenatori allenatori; //dato che abbiamo un unico allenatore a posizione passiamo allenatore

	public Long getClassificaId() {
		return classificaId;
	}

	public void setClassificaId(Long classificaId) {
		this.classificaId = classificaId;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public Allenatori getAllenatori() {
		return allenatori;
	}

	public void setAllenatori(Allenatori allenatori) {
		this.allenatori = allenatori;
	}
	
	
}
