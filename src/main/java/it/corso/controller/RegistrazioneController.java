package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/registrazione")
@Controller
public class RegistrazioneController
{
    @GetMapping
    public String getPage()
    {
        return "registrazione";
    }
}
