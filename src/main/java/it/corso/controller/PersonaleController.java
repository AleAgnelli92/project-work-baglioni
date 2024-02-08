package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Album;
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


    @SuppressWarnings("unchecked")
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
        

        // Recupera gli ordini dell'utente loggato
		List<Ordine> ordini = (List<Ordine>) ordineService.getOrdini();
        model.addAttribute("ordini", ordini);
        
        // Recuperare gli album nel carrello
        List<Album> carrello = (List<Album>) session.getAttribute("carrello");
		model.addAttribute("albumNelCarrello", carrello);
        
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
    
    
//    @SuppressWarnings("unchecked")
//	@GetMapping("/visualizzaOrdini")
//	  public String visualizzaOrdini(Model model, HttpSession session) {
//    	
//    	List<Album> carrello = (List<Album>) session.getAttribute("carrello");
//		model.addAttribute("albumNelCarrello", carrello);
//	      
//		double totaleOrdine = calcolaTotaleOrdine(carrello);
//        model.addAttribute("totaleOrdineNelCarrello", String.format("%.2f", totaleOrdine));
//	      
//        return "personale";
//  }
//    
//    private double calcolaTotaleOrdine(List<Album> carrello) {
//        double totale = 0;
//        if (carrello != null) {
//            for (Album album : carrello) {
//                totale += album.getPrezzo();
//            }
//        }
//		return totale;
//
//    }
}