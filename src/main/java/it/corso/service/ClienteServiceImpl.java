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
	
	public void modificareDatiPersonali(Cliente cliente) {
	    // Recupera il cliente esistente dal database
	    Cliente clienteEsistente = clienteDao.findById(cliente.getId()).orElse(null);
	    
	    // Verifica se il cliente esistente è stato trovato
	    if (clienteEsistente != null) {
	        clienteEsistente.setNome(cliente.getNome());
	        clienteEsistente.setCognome(cliente.getCognome());
	        clienteEsistente.setEmail(cliente.getEmail());
	        clienteEsistente.setUsername(cliente.getUsername());
	        clienteEsistente.setPassword(cliente.getPassword());
	        clienteEsistente.setData_di_nascita(cliente.getData_di_nascita());
	        clienteEsistente.setNumero_di_telefono(cliente.getNumero_di_telefono());
	        clienteEsistente.setNazione(cliente.getNazione());
	        clienteEsistente.setProvincia(cliente.getProvincia());
	        clienteEsistente.setIndirizzo(cliente.getIndirizzo());
	        clienteEsistente.setCivico(cliente.getCivico());
	        clienteEsistente.setCap(cliente.getCap());
	        clienteEsistente.setCitta(cliente.getCitta());
	        
	        // Salva i dati aggiornati nel database
	        clienteDao.save(clienteEsistente);
	    }
	}


}

