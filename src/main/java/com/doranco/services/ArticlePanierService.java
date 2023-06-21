package com.doranco.services;

import com.doranco.models.Article;
import com.doranco.models.ArticlePanier;
import com.doranco.models.Utilisateur;
import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticlePanierService {
    
    public void ajouterArticlePanier(ArticlePanier articlePanier) {
        String query = "INSERT INTO ArticlePanier (id, articleId, quantite, utilisateurId) " +
                       "VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, articlePanier.getId());
            statement.setInt(2, articlePanier.getArticle().getId());
            statement.setInt(3, articlePanier.getQuantite());
            statement.setInt(4, articlePanier.getUtilisateur().getId());

            statement.executeUpdate();
            System.out.println("L'article a été ajouté au panier.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'article au panier : " + e.getMessage());
        }
    }
        
    public List<ArticlePanier> getPanierByUtilisateurId(int utilisateurId) {
        List<ArticlePanier> panier = new ArrayList<>();
        String query = "SELECT * FROM ArticlePanier WHERE utilisateurId = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, utilisateurId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int articleId = resultSet.getInt("articleId");
                    int quantite = resultSet.getInt("quantite");
                  
                    ArticleService articleService = new ArticleService();
                    Article article = articleService.getArticleById(articleId);
                    
                    UtilisateurService utilisateurService = new UtilisateurService();
                    Utilisateur utilisateur = utilisateurService.getUtilisateurById(utilisateurId);

                    ArticlePanier articlePanier = new ArticlePanier(id, article, quantite, utilisateur);
                    panier.add(articlePanier);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du panier : " + e.getMessage());
        }

        return panier;
    }
}
