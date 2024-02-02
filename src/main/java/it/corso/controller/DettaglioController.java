package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.AlbumService;

// localhost:8080/dettaglio_album_prova
@Controller
@RequestMapping("/dettaglio_album_prova")
public class DettaglioController
{
	@Autowired
	private AlbumService albumService;
	
	@GetMapping
	public String getPage(
			@RequestParam("id") int id,
			Model model)
	{
		model.addAttribute("album", albumService.getAlbumById(id));
		return "dettaglio_album_prova";
	}
}
