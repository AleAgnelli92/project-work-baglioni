package it.corso.service;

import java.util.List;
import it.corso.model.Album;

public interface AlbumService {
	
	Album getAlbumById(int id);
	List<Album> getAlbums();
}