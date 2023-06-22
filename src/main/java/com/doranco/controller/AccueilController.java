package com.doranco.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*contrôleur Spring chargé de gérer les requêtes relatives à la page d'accueil 
et à la gestion des articles*/

@Controller
public class AccueilController {
    
    /*GetMapping signifie que la classe répond aux requêtes GET sur la racine du contexte de l'application*/
    @GetMapping("/")
    public String accueil() {
    // Récupérer l'objet d'authentification de l'utilisateur actuel
    org.springframework.security.core.Authentication authentication =
    SecurityContextHolder.getContext().getAuthentication();
    
    // Vérifier si l'utilisateur est authentifié et possède le rôle "ROLE_MAGASINIER"
    if (authentication != null && authentication.getAuthorities().stream()
    .map(GrantedAuthority::getAuthority)
    .anyMatch(role -> role.equals("ROLE_MAGASINIER"))) {
    // Rediriger l'utilisateur vers la page de gestion des articles
    return "redirect:/gestion-articles";
    }
    
    // Rediriger l'utilisateur vers la page d'accueil par défaut
    return "redirect:/accueil";
    }
    
    @GetMapping("/gestion-articles")
    public String gestionArticles() {
    // Logique de gestion des articles à implémenter ici
    // Retourne le nom de la vue à afficher (dans ce cas, "gestion-articles.xhtml")
    return "gestion-articles";
    }
}