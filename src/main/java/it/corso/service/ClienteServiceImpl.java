package it.corso.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dao.ClienteDao;
import it.corso.model.Cliente;

public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public void registrazioneCliente(Cliente cliente) {
		
		clienteDao.save(cliente);
	}

	@Override
	public void cancellazioneCliente(Cliente cliente) {
		
		clienteDao.delete(cliente);
	}

	@Override
	public Cliente getClienteById(int id) {

		return clienteDao.findById(id).get();
	}
}
