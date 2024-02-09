package it.corso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.corso.model.Album;

@Service
public interface AlbumService {
	
	Album getAlbumById(int id);
	List<Album> getAlbums();
	void salvaAlbum(Album album);
	
	public List<Album> getAlbumByTipologia(String string);
//	public List<Album> getAlbumFromTo(int annoFrom, int annoTo);
//	public List<Album> getAlbumDisponibili();
	
	public List<Album> getAlbumsByTipologiaAndAnnoFromToAndDisponibile(
			String tipologia,
			int annoFrom,
			int annoTo,
			String disponibile
	);

}