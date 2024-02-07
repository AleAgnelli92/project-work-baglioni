package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Cliente;
import it.corso.model.Ordine;
import it.corso.service.ClienteService;
import it.corso.service.OrdineService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/personale")
public class PersonaleController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private OrdineService ordineService;


    @GetMapping
    public String areaPersonale(HttpSession session, Model model) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        if (cliente == null) {
            // Se l'utente non è autenticato, reindirizza alla pagina di login
            return "redirect:/login";
        }

        cliente = clienteService.getClienteById(cliente.getId());
        // Passa il nome utente alla pagina dell'area riservata
        model.addAttribute("username", cliente.getUsername());
        model.addAttribute("cliente", cliente);
        

//        System.out.println(cliente);
//        System.out.println(clienteService.getClienteById(cliente.getId()));
        
        // Recupera gli ordini dell'utente loggato
		List<Ordine> ordini = (List<Ordine>) ordineService.getOrdini();
        model.addAttribute("ordini", ordini);
        
        return "personale";
    }
    
    
    @PostMapping
    public String modificaDatiPersonali(@ModelAttribute("cliente") Cliente cliente, HttpSession session) {
        // Recupera il cliente attualmente loggato dalla sessione
        Cliente clienteLoggato = (Cliente) session.getAttribute("cliente");
        
        // Imposta l'ID del cliente che si sta modificando con quello del cliente loggato
        cliente.setId(clienteLoggato.getId());
        
        clienteService.modificareDatiPersonali(cliente);
        
        // Aggiorna il cliente nella sessione con i nuovi dati
        session.setAttribute("cliente", cliente);
        
        return "redirect:/personale"; 
    }

}