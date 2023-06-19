package com.doranco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
    @GetMapping("/")
    public String accueil(){
        return "accueil"; // Retourne le nom de la vue à afficher (accueil.xhtml)
    }

}
