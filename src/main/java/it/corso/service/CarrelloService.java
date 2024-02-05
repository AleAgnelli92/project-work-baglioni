package it.corso.service;

import jakarta.servlet.http.HttpSession;

public interface CarrelloService {

	void aggiungiAlbum(HttpSession session, int id);
	void rimuoviAlbum(HttpSession session, int id);

}
