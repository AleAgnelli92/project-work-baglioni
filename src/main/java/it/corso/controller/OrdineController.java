package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Album;
import it.corso.model.Cliente;
import it.corso.service.CarrelloService;
import it.corso.service.OrdineService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ordine")
@SuppressWarnings("unchecked")
public class OrdineController {
	
	@Autowired
	private OrdineService ordineService;
	@Autowired
	private CarrelloService carrelloService;
	
	@GetMapping("/registraordine")
	public String registraOrdine(HttpSession session)
	{
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		List<Album> albumsNelCarrello = (List<Album>) session.getAttribute("carrello");
		
		carrelloService.svuotaCarrello(session);
		ordineService.registraOrdine(cliente, albumsNelCarrello);
		return "redirect:/personale";
	}
}