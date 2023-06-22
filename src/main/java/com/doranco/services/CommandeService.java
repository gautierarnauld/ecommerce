package com.doranco.services;

import com.doranco.models.Article;
import com.doranco.models.Commande;
import com.doranco.models.LigneDeCommande;
import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommandeService {
    /*Méthode pour ajouter une commande dans la base de données*/
    public void ajouterCommande(Commande commande) {
        String query = "INSERT INTO Commande (id, numero, dateCreation, dateLivraison, totaleRemise, fraisExpedition, totalGeneral, adresseFacturationId, adresseLivraisonId, cartePaiementDefautId, utilisateurId) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, commande.getId());
            statement.setString(2, commande.getNumero());
            statement.setString(3, commande.getDateCreation());
            statement.setString(4, commande.getDateLivraison());
            statement.setDouble(5, commande.getTotaleRemise());
            statement.setDouble(6, commande.getFraisExpedition());
            statement.setDouble(7, commande.getTotalGeneral());
            statement.setInt(8, commande.getAdresseFacturation().getId());
            statement.setInt(9, commande.getAdresseLivraison().getId());
            statement.setInt(10, commande.getCartePaiementDefaut().getId());
            statement.setInt(11, commande.getUtilisateur().getId());

            statement.executeUpdate();
            System.out.println("La commande a été ajoutée à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la commande : " + e.getMessage());
        }
    }

    public boolean effectuerAchat(Commande commande) {
        // Ajouter la commande à la base de données
        ajouterCommande(commande);            

        // Vérifier si l'achat a réussi
        boolean achatReussi = true;  // Supposons que l'achat réussit par défaut  
        
        // Créer les lignes de commande, mettre à jour les stocks, etc.
        try {
            // Créer les lignes de commande
            for (LigneDeCommande ligne : commande.getLignesDeCommande()) {
                LigneDeCommandeService ligneDeCommandeService = new LigneDeCommandeService();
                ligneDeCommandeService.ajouterLigneDeCommande(ligne);
            }

            // Mettre à jour les stocks
            for (LigneDeCommande ligne : commande.getLignesDeCommande()) {
                ArticleService articleService = new ArticleService();
                Article article = ligne.getArticle();
                int quantiteCommandee = ligne.getQuantite();
                articleService.mettreAJourStock(article, quantiteCommandee);
            }

            // Si toutes les opérations se sont déroulées correctement, l'achat est réussi
            achatReussi = true;
            
        } catch (Exception e) {
            // En cas d'erreur, afficher un message d'erreur ou enregistrer les erreurs dans les journaux
            System.err.println("Erreur lors de l'achat : " + e.getMessage());
            achatReussi = false;
        }

        return achatReussi;
    }   
}