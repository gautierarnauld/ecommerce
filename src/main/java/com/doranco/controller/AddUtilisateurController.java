package com.doranco.controller;

import com.doranco.models.Utilisateur;
import com.doranco.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class AddUtilisateurController {
    //Variables
    private UtilisateurService utilisateurService;
    
    //permet à Spring d'injecter automatiquement une instance de 
    // UtilisateurService dans le constructeur de la classe
    @Autowired
    public AddUtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/add")
    public String showAddUtilisateurForm() {
        return "add-utilisateur-form";
    }
    
    @PostMapping("/add")
    public String addUtilisateur(@RequestParam("nom") String nom,
                                 @RequestParam("email") String email,
                                 @RequestParam("motDePasse") String motDePasse,
                                 Model model) {
        // Créer un nouvel utilisateur avec les informations fournies
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setMotDePasse(motDePasse);

        // Ajouter l'utilisateur à la base de données
        utilisateurService.ajouterUtilisateur(utilisateur);

        // Ajouter l'utilisateur au modèle pour affichage sur la page de confirmation
        model.addAttribute("utilisateur", utilisateur);

        // Rediriger vers la page de confirmation
        return "confirmation-page";
    }
}
