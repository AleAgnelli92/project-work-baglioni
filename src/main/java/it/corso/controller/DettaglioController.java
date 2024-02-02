package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Album;
import it.corso.service.AlbumService;


// localhost:8080/dettaglio_album_prova
@Controller
@RequestMapping("/dettaglio")
public class DettaglioController
{
	@Autowired
	private AlbumService albumService;
	
	@GetMapping
	public String getPage(
			@RequestParam("id") int id,
			Model model)
	{
		Album album = albumService.getAlbumById(id);
		model.addAttribute("album", album);
		model.addAttribute("dettagli", album.getDettagli());
		return "dettaglio";
	}
}
