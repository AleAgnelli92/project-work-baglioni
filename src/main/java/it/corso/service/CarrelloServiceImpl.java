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

	@SuppressWarnings("unchecked")
	@Override
	public void rimuoviAlbum(HttpSession session, int id) {
		List<Album> carrello = (List<Album>) session.getAttribute("carrello");
        if (carrello != null) {
            int indexToRemove = -1;
            for (int i = 0; i < carrello.size(); i++) {
                if (carrello.get(i).getId() == id) {
                    indexToRemove = i;
                    break;
                }
            }
            if (indexToRemove != -1) {
                carrello.remove(indexToRemove);
            }
        }
        session.setAttribute("carrello", carrello);
	}
	
	public void svuotaCarrello(HttpSession session) {
	    session.removeAttribute("carrello");
	}

}
