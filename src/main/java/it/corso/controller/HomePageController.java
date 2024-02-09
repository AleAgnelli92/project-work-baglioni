package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import it.corso.service.AlbumService; 
import it.corso.model.Album; 
import java.util.List; 
import java.util.Random; 
import java.util.ArrayList;


@Controller
@RequestMapping("/")
public class HomePageController {
	@Autowired
	private AlbumService albumService;
	private static final int numeriProdottiHomePage = 4;
	@GetMapping
    public String home(Model model) {
		//recuperiamo l elenco di tutti gli album dal service
		List<Album>tuttiAlbum=albumService.getAlbums();
		List<Album>albumVinile=albumService.getAlbumByTipologia("Vinile");
		List<Album>albumCD=albumService.getAlbumByTipologia("CD");
		
		//serve ad estrarre casualmente i tre dischi per home page 
		List<Album>albumHomePage=getRandomAlbum(tuttiAlbum,numeriProdottiHomePage);
		model.addAttribute("albumInHomePage",albumHomePage);
		
		
		List<Album>vinileInHomePage=getRandomAlbum(albumVinile,numeriProdottiHomePage);
		model.addAttribute("vinileHomePage", vinileInHomePage);
		
		List<Album>cdInHomePage=getRandomAlbum(albumCD,numeriProdottiHomePage);
		model.addAttribute("CDHomePage", cdInHomePage);
		
		return "homepage";
       
    }
	
	private List<Album> getRandomAlbum(List<Album> tuttiAlbum, int numAlbum) {
		// metodo per estrarre
		Random random = new Random();
		
		List<Album>randomAlbums = new ArrayList<>();
		while(randomAlbums.size()<numAlbum) {
			Album randomAlbum= tuttiAlbum.get(random.nextInt(tuttiAlbum.size()));
			if(!randomAlbums.contains(randomAlbum)) {
				randomAlbums.add(randomAlbum);
			}
		}
		return randomAlbums;
	}
}
