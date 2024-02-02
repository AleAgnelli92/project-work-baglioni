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

}
