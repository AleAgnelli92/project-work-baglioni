package it.corso.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ordine")
public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private LocalDateTime data;
	@Column
	private double importo;
	
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_id_cliente", referencedColumnName = "id")
    private Cliente cliente;
    
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable
    (
    	name = "ordine_catalogo",
    	joinColumns = @JoinColumn(name = "fk_id_ordine", referencedColumnName = "id"),
    	inverseJoinColumns = @JoinColumn(name = "fk_id_album", referencedColumnName = "id")
    )
    private List<Album> albums = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

    public List<Album> getProdotti() {
		return albums;
	}
	public void setProdotti(List<Album> prodotti) {
		this.albums = prodotti;
	}
}
