package it.corso.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi nel campo nome")
    private String nome;
	@Column
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi nel campo cognome")
    private String cognome;
	@Column
	@Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message = "L'email deve essere in un formato valido")
    private String email;
	@Column
	@Pattern(regexp = "[a-zA-Z0-9.]{1,20}", message = "Caratteri non ammessi per lo username")
    private String username;
	@Column
    private String password;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data_di_nascita;
	@Column
    private String numero_di_telefono;
	@Column
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi nel campo nazione")
    private String nazione;
	@Column
	@Pattern(regexp = "[a-zA-Z\\s']{2}", message = "Scrivi la provincia in questo formato 'XX'")
    private String provincia;
	@Column
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi nel campo indirizzo")
    private String indirizzo;
	@Column
	@Pattern(regexp = "[a-zA-Z0-9/]{1,5}", message = "Il campo civico può contenere da 1 a 5 caratteri")
    private String civico;
	@Column
	@Pattern(regexp = "\\d{5}", message = "Il CAP deve contenere esattamente 5 numeri")
    private String cap;
	@Column
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi nel campo città")
    private String citta;
	
	@OneToMany
    (
    		mappedBy = "cliente",
    		cascade = CascadeType.ALL,
    		fetch = FetchType.EAGER,
    		orphanRemoval = true
    	)
    private List<Ordine> ordini = new ArrayList<>(); // contenitore pronto a ricevere oggetti
	
    public List<Ordine> getOrdini() {
		return ordini;
	}
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getData_di_nascita() {
		return data_di_nascita;
	}
	public void setData_di_nascita(LocalDate data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}	
	
	public String getNumero_di_telefono() {
		return numero_di_telefono;
	}
	public void setNumero_di_telefono(String numero_di_telefono) {
		this.numero_di_telefono = numero_di_telefono;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
}
