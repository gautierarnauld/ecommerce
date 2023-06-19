package com.doranco.controller;

import enumeration.ProfilUtilisateur;
import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping("/utilisateur")
public class LoginUtilisateurController {

    private ProfilUtilisateur getProfilUtilisateur(String username) {
        /* Méthode pour obtenir le profil de l'utilisateur à partir de la base de données
        Elle devrait retourner le profil de l'utilisateur en fonction de son nom d'utilisateur
        ou renvoyer une valeur par défaut si le profil n'est pas trouvé*/

        // Retourne un profil en fonction du nom d'utilisateur
        if (username.equals("magasinier")) {
            return ProfilUtilisateur.MAGASINIER;
        } else {
            return ProfilUtilisateur.CLIENT;
        }
    }
}