package com.doranco.ecommerce;

import com.doranco.models.Adresse;
import com.doranco.models.Article;
import com.doranco.models.Utilisateur;
import com.doranco.models.Commentaire;
import java.util.Date;

public class ECommerce {
    public static void main(String[] args) {
        //- - - - - - - - Création d'un nouvel article - - - - - - - - 
        /*Article nouvelArticle = new Article();
        nouvelArticle.setId(3);
        nouvelArticle.setNom("Nounours viking");
        nouvelArticle.setPrix(19.90);
        nouvelArticle.setVendu(false);
        nouvelArticle.setPhoto("https://boutique.puydufou.com/media/catalog/product/p/e/peluche-ours-viking-2_1.png");
        nouvelArticle.setRemise(0.2); // 20% de remise
        nouvelArticle.setStock(2);
        nouvelArticle.setDescription("Ce petit ours Viking vous protègera contre les attaques de barbares !");
        nouvelArticle.setCommentaire("J'adore");

        // Ajout de l'article à la base de données
        nouvelArticle.ajouterArticle();*/
                
        //- - - - - - - -  Création d'un objet adresse - - - - - - - - 
        /*Adresse adresse = new Adresse();
        adresse.setId(10);
        adresse.setNumero("1213");
        adresse.setRue("Rue de la Paix");
        adresse.setVille("Toulouse");
        adresse.setCodePostal("31000");

        adresse.ajouterAdresse();*/
        
        //- - - - - - - - Création d'un objet utilisateur - - - - - - - - 
        /*Adresse adresse1 = new Adresse();
        adresse1.setId(8);        

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setId(8);
        utilisateur1.setNom("Martin");
        utilisateur1.setPrenom("Sophie");
        utilisateur1.setDateNaissance(new java.sql.Date(95, 5, 10));
        utilisateur1.setActif(true);
        utilisateur1.setEmail("sophie.martin@example.com");
        utilisateur1.setMotDePasse("password123");
        utilisateur1.setNumeroTelephone("9876543210");     
        utilisateur1.setAdresse(adresse1);

        utilisateur1.ajouterUtilisateur(utilisateur1);*/
        
        //- - - - - - - - Création d'un nouveau commentaire - - - - - - - - 
        Commentaire commentaire = new Commentaire();
        commentaire.setId(3); 
        commentaire.setTexte("Vraiment pas ouf !!!!");
        commentaire.setNote(1);

        int articleId = 3;
        int utilisateurId = 5; 

        commentaire.ajouterCommentaire(commentaire, articleId, utilisateurId);


    }
}