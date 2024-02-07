package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Cliente;
import it.corso.service.ClienteService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// localhost:8080/login
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ClienteService clienteService;
	

	@GetMapping
    public String getPage(HttpSession session, Model model) {
        boolean loggedIn = session.getAttribute("cliente") != null;
        if (loggedIn)
	        return "redirect:/ordine/registraordine";
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("cliente", new Cliente()); 
        return "login";
    }
	
	@PostMapping("/controllo")
	public String loginManager(@RequestParam("username") String username,
							  @RequestParam("password") String password,
							  HttpSession session) { 
		
		if(!clienteService.controlloLogin(username, password, session))
			return "redirect:/login";
		
		return "redirect:/personale";
	}
	
	
	@PostMapping("/registrazione")
	public String formManager(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.registrazioneCliente(cliente);
		return "redirect:/personale";
	}
	

	@GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalida la sessione
        session.invalidate();

        return "redirect:/login";
    }
}
