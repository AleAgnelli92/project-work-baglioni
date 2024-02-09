package it.corso.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.AlbumDao;
import it.corso.model.Album;


@Service
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
	
	@Override
    public void salvaAlbum(Album album) {
        albumDao.save(album);
    }


	@Override
	public List<Album> getAlbumByTipologia(String string) {
		return albumDao.findByTipologia(string);
	}
//
//
//	@Override
//	public List<Album> getAlbumFromTo(int annoFrom, int annoTo) {
//		return albumDao.findAnnoFromTo(annoFrom, annoTo);
//	}
//	
//	
//	@Override
//	public List<Album> getAlbumDisponibili() {
//		return albumDao.findDisponibili();
//	}


	@Override
	public List<Album> getAlbumsByTipologiaAndAnnoFromToAndDisponibile(
			String tipologia, 
			int annoFrom, 
			int annoTo,
			String disponibile) {
		
		return albumDao.findByTipologiaAndAnnoFromToAndDisponibile(
				tipologia,
				annoFrom,
				annoTo,
				disponibile
		);
	}

}