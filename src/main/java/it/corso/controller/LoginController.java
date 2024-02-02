package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Cliente;
import it.corso.service.ClienteService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
    public String login() {
        return "login";
    }
	
	@PostMapping
	public String formManager(@ModelAttribute("cliente") Cliente cliente)
	{
		clienteService.registrazioneCliente(cliente);
		return "redirect:/personale";
	}

}