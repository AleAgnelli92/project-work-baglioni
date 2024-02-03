package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Album;
import it.corso.service.CarrelloService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/carrello")
public class CarrelloController {
	
	@Autowired
	private CarrelloService carrelloService;

	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(
			Model model,
			HttpSession session)
	{
		List<Album> carrello = (List<Album>) session.getAttribute("carrello");
		model.addAttribute("albumNelCarrello", carrello);
		return "carrello";
	}
	
	@GetMapping("/aggiungi")
	public String aggiungi(
			@RequestParam("id") int id,
			HttpSession session)
	{
		carrelloService.aggiungiAlbum(session, id);
		return "redirect:/carrello";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/rimuovi")
	public String rimuoviAlbum(@RequestParam("id") int id, HttpSession session) {
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
	    return "redirect:/carrello";
	}
}
