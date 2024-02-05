package it.corso.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.ClienteDao;
import it.corso.model.Cliente;
import jakarta.servlet.http.HttpSession;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
    private ClienteDao clienteDao;

    @Override
    public boolean controlloLogin(String username, String password, HttpSession session) {
        // Cerca il cliente nel database per username
        Cliente cliente = clienteDao.findByUsernameAndPassword(username, password);
        if (cliente != null) {
        	session.setAttribute("cliente", cliente);
            return true;
        }
        return false; 
    }
    
    @Override
    public void registrazioneCliente(Cliente cliente) {

        clienteDao.save(cliente);
    }

	@Override
	public Cliente getClienteById(Integer id) {
		
		Optional<Cliente> clienteOptional = clienteDao.findById(id);
		if(clienteOptional.isPresent())
			return clienteOptional.get();
		return null;
	}

}

