package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.model.Album;
import jakarta.servlet.http.HttpSession;

@Service
public class CarrelloServiceImpl implements CarrelloService {
	
	@Autowired
	private AlbumService albumService;

	@SuppressWarnings("unchecked")
	@Override
	public void aggiungiAlbum(HttpSession session, int id) {
		List<Album> carrello = session.getAttribute("carrello") == null ? 
				new ArrayList<>() : 
				(List<Album>) session.getAttribute("carrello");
		carrello.add(albumService.getAlbumById(id));
		session.setAttribute("carrello", carrello);
	}

}
