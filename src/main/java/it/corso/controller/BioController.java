package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bio")
public class BioController {
	@GetMapping
    public String bio() {
        return "/bio";
    }
}
