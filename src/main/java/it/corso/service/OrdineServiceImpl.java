package it.corso.service;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.OrdineDao;
import it.corso.model.Album;
import it.corso.model.Cliente;
import it.corso.model.Ordine;

@Service
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineDao ordineDao;
	
	@Override
	public List<Ordine> getOrdini() {
		return (List<Ordine>) ordineDao.findAll();
	}
	
	@Override
	public void registraOrdine(Cliente cliente, List<Album> albumsNelCarrello) {
		
		Ordine ordine = new Ordine();
		ordine.setAlbums(albumsNelCarrello);
		
		double importo = albumsNelCarrello
				.stream()
				.mapToDouble(Album::getPrezzo)
				.reduce(0.0, (p1,p2) -> p1 + p2);
		ordine.setImporto(importo);
		
		System.out.println(cliente.getId());
		ordine.setCliente(cliente);
		ordine.setData(LocalDateTime.now());
		ordineDao.save(ordine);
	}
	
	@Override
	public Ordine getOrdineById(int id) {
		return ordineDao.findById(id).get();
	}

}
