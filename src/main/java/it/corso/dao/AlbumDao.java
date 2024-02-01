package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Album;

public interface AlbumDao extends CrudRepository<Album, Integer>
{

}
