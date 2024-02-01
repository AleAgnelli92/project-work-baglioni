package it.corso.service;

import it.corso.model.Cliente;

public interface ClienteService {

	void registrazioneCliente(Cliente cliente);
	void cancellazioneCliente(Cliente cliente);
	Cliente getClienteById(int id);
}
