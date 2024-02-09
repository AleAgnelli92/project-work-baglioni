package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Cliente;
import it.corso.service.ClienteService;
import jakarta.validation.Valid;

@RequestMapping("/registrazione")
@Controller
public class RegistrazioneController
{
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public String getPage(Model model) {
	    model.addAttribute("cliente", new Cliente());
	    return "registrazione"; 
	}

	
	@PostMapping("/registrazionecliente")
	public String formManager(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result) {
		
		if(result.hasErrors())
			return "/registrazione";
		
		clienteService.registrazioneCliente(cliente);
		return "redirect:/personale";
	}
}
