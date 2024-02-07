package it.corso.dao;


import org.springframework.data.repository.CrudRepository;
import it.corso.model.Ordine;

public interface OrdineDao extends CrudRepository<Ordine, Integer>
{
	
}
