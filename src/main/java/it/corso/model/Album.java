package it.corso.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String titolo;
	@Column
	private Year anno;
	@Column
	private double prezzo;
	@Column
	private String copertina;
	@Column
	private int quantita;
	@Column
	private String tipologia;
	@Column
	private String descrizione;
	
	@OneToMany
    (
    		mappedBy = "album",
    		cascade = CascadeType.ALL,
    		fetch = FetchType.EAGER,
    		orphanRemoval = true
    )
    private List<Dettaglio> dettagli = new ArrayList<>(); // contenitore pronto a ricevere oggetti
	
	public List<Dettaglio> getDettagli() {
		return dettagli;
	}
	public void setDettagli(List<Dettaglio> dettagli) {
		this.dettagli = dettagli;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Year getAnno() {
		return anno;
	}
	public void setAnno(Year anno) {
		this.anno = anno;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getCopertina() {
		return copertina;
	}
	public void setCopertina(String copertina) {
		this.copertina = copertina;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
