package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.AlbumService;

@Controller
@RequestMapping("/catalogo_prova.html")
public class CatalogoController {

	@Autowired
	private AlbumService albumService;
	
	@GetMapping
	public String getPage(Model model)
	{
		model.addAttribute("albums", albumService.getAlbums());	
		return "catalogo_prova.html";
	}
}
