package com.doranco.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
    @GetMapping("/")
    public String accueil() {
        org.springframework.security.core.Authentication authentication = 
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_MAGASINIER"))) {
            return "redirect:/gestion-articles";
        }

        return "redirect:/accueil";
    }

    @GetMapping("/gestion-articles")
    public String gestionArticles() {
        // Logique de gestion des articles
        // Retourne le nom de la vue à afficher (gestion-articles.xhtml)
        return "gestion-articles";
    }

}
