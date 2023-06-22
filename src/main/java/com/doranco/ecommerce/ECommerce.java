package com.doranco.ecommerce;

import ch.qos.logback.core.CoreConstants;
import com.doranco.models.Adresse;
import com.doranco.models.Article;
import com.doranco.models.ArticlePanier;
import com.doranco.models.Utilisateur;
import com.doranco.models.Commentaire;
import com.doranco.models.CartePaiement;
import com.doranco.models.Categorie;
import com.doranco.models.Commande;
import com.doranco.models.LigneDeCommande;
import com.doranco.services.AdresseService;
import com.doranco.services.ArticlePanierService;
import com.doranco.services.ArticleService;
import com.doranco.services.CartePaiementService;
import com.doranco.services.CategorieService;
import com.doranco.services.CommandeService;
import com.doranco.services.CommentaireService;
import com.doranco.services.LigneDeCommandeService;
import com.doranco.services.UtilisateurService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ECommerce {
    public static void main(String[] args) throws Exception {
        //- - - - - - - - Création d'un nouvel article - - - - - - - - 
        /*ArticleService articleService = new ArticleService();
        
        Article article = new Article();
        article.setId(9);
        article.setNom("Poulet roti");
        article.setPrix(9.99);
        article.setVendu(true);
        article.setPhoto("https://www.undejeunerdesoleil.com/wp-content/uploads/2023/01/Reussir_poulet_roti_secret_recette.jpg");
        article.setRemise(0.2); // 20% de remise
        article.setStock(10);
        article.setDescription("au barbecue");
        article.setCommentaire("");
        
        // Ajout de l'article à la base de données
        articleService.ajouterArticle(article);*/
                
        //- - - - - - - -  Création d'un objet adresse - - - - - - - - 
        /*AdresseService adresseService = new AdresseService();
        
        Adresse adresse = new Adresse();
        adresse.setId(10);
        adresse.setNumero("1213");
        adresse.setRue("Rue de la Paix");
        adresse.setVille("Toulouse");
        adresse.setCodePostal("31000");

        adresseService.ajouterAdresse(adresse);*/
        
        //- - - - - - - - Création d'un objet utilisateur - - - - - - - - 
        /*UtilisateurService utilisateurService = new UtilisateurService();
        
        Adresse adresse1 = new Adresse();
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

        utilisateurService.ajouterUtilisateur(utilisateur1);*/
        
        //- - - - - - - - Création d'un nouveau commentaire - - - - - - - - 
        /*CommentaireService commentaireService = new CommentaireService();
        
        Commentaire commentaire = new Commentaire();
        commentaire.setId(4);
        commentaire.setTexte("Vraiment incroyable !");
        commentaire.setNote(4);
        
        int articleId = 6;
        int utilisateurId = 1;
        
        commentaireService.ajouterCommentaire(commentaire, articleId, utilisateurId);*/

        //- - - - - - - - Création d'une carte de paiement - - - - - - - - 
        /*CartePaiementService cartePaiementService = new CartePaiementService();
        
        CartePaiement cartePaiement = new CartePaiement();
        cartePaiement.setId(6);
        cartePaiement.setNomProprietaire("Martine");
        cartePaiement.setPrenomProprietaire("Anne");
        cartePaiement.setNumero("9119480800223456");
        cartePaiement.setDateFinValidite(new java.sql.Date(2024, 2, 1));
        cartePaiement.setCryptogramme("349");
        
        int userId = 6;
        
        cartePaiementService.ajouterCartePaiement(cartePaiement, userId);*/

        //- - - - - - - - Création d'une commande - - - - - - - - 
        /*CommandeService commandeService = new CommandeService();
        
        Commande nouvelleCommande = new Commande();
        nouvelleCommande.setId(3);
        nouvelleCommande.setNumero("CMD003");
        nouvelleCommande.setDateCreation("21.06.2023");
        nouvelleCommande.setDateLivraison("06.07.2023");
        nouvelleCommande.setTotaleRemise(12.0);
        nouvelleCommande.setFraisExpedition(3.4);
        nouvelleCommande.setTotalGeneral(19.0);
        
        Adresse adresseFacturation = new Adresse();
        adresseFacturation.setId(6);
        
        Adresse adresseLivraison = new Adresse();
        adresseLivraison.setId(6);
        
        CartePaiement cartePaiementCommande = new CartePaiement();
        cartePaiementCommande.setId(6);
        
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(6);
        
        nouvelleCommande.setAdresseFacturation(adresseFacturation);
        nouvelleCommande.setAdresseLivraison(adresseLivraison);
        nouvelleCommande.setCartePaiementDefaut(cartePaiementCommande);
        nouvelleCommande.setUtilisateur(utilisateur);
        
        commandeService.ajouterCommande(nouvelleCommande);*/
               
        //- - - - - - - - Création d'une categorie - - - - - - - - 
        /*Categorie nouvelleCategorie = new Categorie();
        nouvelleCategorie.setId(3);
        nouvelleCategorie.setNom("Nouriture");
        nouvelleCategorie.setRemise(0.0);
        nouvelleCategorie.setRemiseCumulable(true);
        nouvelleCategorie.setPhoto("");

        // Ajout des IDs des articles associés
        List<Integer> articleIds = Arrays.asList(9, 7, 8);

        nouvelleCategorie.setArticleIds(articleIds);

        // Appel du service pour ajouter la catégorie
        CategorieService categorieService = new CategorieService();
        categorieService.ajouterCategorie(nouvelleCategorie);*/
        
        //- - - - - - - - Création d'un article panier - - - - - - - - 
        /*ArticlePanierService articlePanierService = new ArticlePanierService();
        
        ArticlePanier nouvelArticlePanier = new ArticlePanier();
        nouvelArticlePanier.setId(5);
        
        Article article = new Article();
        article.setId(3); // ID de l'article à ajouter au panier
        
        nouvelArticlePanier.setArticle(article);
        nouvelArticlePanier.setQuantite(7);
        
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(8); // ID de l'utilisateur associé au panier
        
        nouvelArticlePanier.setUtilisateur(utilisateur);
        
        // Appel de la méthode ajouterArticlePanier pour ajouter l'article panier
        articlePanierService.ajouterArticlePanier(nouvelArticlePanier);*/
        
        //- - - - - - - - Création d'une ligne de commande - - - - - - - - 
        /*LigneDeCommandeService ligneDeCommandeService = new LigneDeCommandeService();
        
        // Création d'une nouvelle ligne de commande
        LigneDeCommande nouvelleLigne = new LigneDeCommande();
        nouvelleLigne.setId(3);
        nouvelleLigne.setQuantite(1);
        nouvelleLigne.setPrixUnitaire(8.0);
        nouvelleLigne.setRemiseArticle(0.0);
        
        Commande commande = new Commande();
        commande.setId(3); // ID de la commande associée
        nouvelleLigne.setCommande(commande);
        
        Article articleLigne = new Article();
        articleLigne.setId(4); // ID de l'article associé
        nouvelleLigne.setArticle(articleLigne);
        
        // Ajout de la ligne de commande
        ligneDeCommandeService.ajouterLigneDeCommande(nouvelleLigne);*/
        
        
    }
}
