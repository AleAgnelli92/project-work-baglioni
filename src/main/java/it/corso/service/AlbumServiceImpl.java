package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dao.AlbumDao;
import it.corso.model.Album;

public class AlbumServiceImpl implements AlbumService {

	
	@Autowired
	private AlbumDao albumDao;
	
	@Override
	public Album getAlbumById(int id) {
		return albumDao.findById(id).get();
	}

	@Override
	public List<Album> getAlbums() {
		return (List<Album>) albumDao.findAll();
	}
	
}
