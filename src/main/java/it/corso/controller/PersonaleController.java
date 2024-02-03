package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Cliente;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/personale")
public class PersonaleController {

    @GetMapping
    public String areaPersonale(HttpSession session, Model model) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        if (cliente == null) {
            // Se l'utente non è autenticato, reindirizza alla pagina di login
            return "redirect:/login";
        }

        // Passa il nome utente alla pagina dell'area riservata
        model.addAttribute("username", cliente.getUsername());

        return "personale";
    }
}
