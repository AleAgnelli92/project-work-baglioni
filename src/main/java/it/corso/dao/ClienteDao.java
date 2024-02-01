package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Integer>
{

}
