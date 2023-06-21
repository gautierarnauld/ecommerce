package com.doranco.services;

import com.doranco.models.LigneDeCommande;
import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LigneDeCommandeService {
    public void ajouterLigneDeCommande(LigneDeCommande ligneDeCommande) {
        String query = "INSERT INTO LigneDeCommande (id, quantite, prixUnitaire, remiseArticle, commandeId, articleId) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ligneDeCommande.getId());
            statement.setInt(2, ligneDeCommande.getQuantite());
            statement.setDouble(3, ligneDeCommande.getPrixUnitaire());
            statement.setDouble(4, ligneDeCommande.getRemiseArticle());
            statement.setInt(5, ligneDeCommande.getCommande().getId());
            statement.setInt(6, ligneDeCommande.getArticle().getId());

            statement.executeUpdate();
            System.out.println("La ligne de commande a été ajoutée à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la ligne de commande : " + e.getMessage());
        }
    }
}
