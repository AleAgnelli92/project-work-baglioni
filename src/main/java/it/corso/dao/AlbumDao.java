package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import it.corso.model.Album;

public interface AlbumDao extends CrudRepository<Album, Integer>
{
	List<Album> findByTipologia(String tipologia);
}
