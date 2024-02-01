package it.corso.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Dettaglio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String brano;
	@Column
	private String durata;
	@ManyToOne(cascade = CascadeType.REFRESH) // rendiamo le tabelle album e dettaglio indipendenti l'una dall'altra
	@JoinColumn(name = "fk_id_album", referencedColumnName = "id") // Uniamo la tabella dettaglio alla tabella album attraverso la foreign key fk_id_album
	private Album album; // reference per collegare la foreign key
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrano() {
		return brano;
	}
	public void setBrano(String brano) {
		this.brano = brano;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}

}
