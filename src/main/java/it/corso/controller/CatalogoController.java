package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Album;
import it.corso.service.AlbumService;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

	@Autowired
	private AlbumService albumService;
	
	@GetMapping
	public String getPage(
			@RequestParam(name = "tipologia", required = false) String filtroTtipologia,
			@RequestParam(name = "anno", required = false) String filtroAnno,
			@RequestParam(name = "disponibile", required = false) String filtroDisponibile,
			Model model) {
		
		model.addAttribute("tipologiaFiltro", filtroTtipologia);
		model.addAttribute("annoFiltro", filtroAnno);
		model.addAttribute("disponibileFiltro", filtroDisponibile);
		
		String tipologia = filtroTtipologia != null && filtroTtipologia.length() > 0 ? filtroTtipologia : null;
		String disponibile = filtroDisponibile != null && filtroDisponibile.length() > 0 ? filtroDisponibile : null;
		
		int annoFrom = filtroAnno != null && filtroAnno.length() > 0 ? Integer.parseInt(filtroAnno) : 0;
		int annoTo = filtroAnno != null && filtroAnno.length() > 0 ? (annoFrom + 9) : 0;
		
		List<Album> albumsFiltrati = 
				albumService.getAlbumsByTipologiaAndAnnoFromToAndDisponibile(tipologia, annoFrom, annoTo, disponibile);
		model.addAttribute("albums", albumsFiltrati);

		return "catalogo";
	}
	
}
