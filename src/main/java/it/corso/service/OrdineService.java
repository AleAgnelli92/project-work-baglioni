package it.corso.service;

import java.util.List;

import it.corso.model.Album;
import it.corso.model.Cliente;
import it.corso.model.Ordine;

public interface OrdineService {
	
	List<Ordine> getOrdini();
	void registraOrdine(Cliente cliente, List<Album> albumsNelCarrello);
	Ordine getOrdineById(int id);

}