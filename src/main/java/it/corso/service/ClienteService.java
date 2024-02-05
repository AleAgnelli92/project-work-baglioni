package it.corso.service;

import it.corso.model.Cliente;
import jakarta.servlet.http.HttpSession;

public interface ClienteService {

	boolean controlloLogin(String username, String password, HttpSession session);

	void registrazioneCliente(Cliente cliente);

	Cliente getClienteById(Integer id);

	void modificareDatiPersonali(Cliente cliente);

}
