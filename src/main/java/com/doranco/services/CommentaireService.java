package com.doranco.services;

import com.doranco.models.Article;
import com.doranco.models.Commentaire;
import com.doranco.models.Utilisateur;
import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentaireService {
    
    /*Méthode pour ajouter un commentaire dans la base de données*/
    public void ajouterCommentaire(Commentaire commentaire, int articleId, int utilisateurId) {
        String query = "INSERT INTO Commentaire (id, texte, note, articleId, utilisateurId) " +
                       "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, commentaire.getId());
            statement.setString(2, commentaire.getTexte());
            statement.setInt(3, commentaire.getNote());
            statement.setInt(4, articleId);
            statement.setInt(5, utilisateurId);

            statement.executeUpdate();
            System.out.println("Le commentaire "+ commentaire.getId() +" a été ajouté à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du commentaire : " + e.getMessage());
        }
    }
    
    public Commentaire getCommentaireByUtilisateurId(int utilisateurId) {
        Commentaire commentaire = null;
        String query = "SELECT * FROM Commentaire WHERE utilisateurId = ?";

        try (Connection connection = DatabaseConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, utilisateurId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String texte = resultSet.getString("texte");
                    int note = resultSet.getInt("note");
                    // Récupérer les autres attributs nécessaires

                    // Récupérer l'article associé au commentaire (à partir de l'ID de l'article)
                    ArticleService articleService = new ArticleService();
                    Article article = articleService.getArticleById(resultSet.getInt("articleId"));

                    // Récupérer l'utilisateur associé au commentaire (à partir de l'ID de l'utilisateur)
                    UtilisateurService utilisateurService = new UtilisateurService();
                    Utilisateur utilisateur = utilisateurService.getUtilisateurById(resultSet.getInt("utilisateurId"));

                    commentaire = new Commentaire(id, texte, note, article, utilisateur);
                    // Définir les autres attributs de l'objet Commentaire
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du commentaire : " + e.getMessage());
        }

        return commentaire;
    }

    // Méthode pour récupérer les commentaires d'un article par son ID
    public List<Commentaire> getCommentairesByArticleId(int articleId) {
        // Implémentez ici votre logique pour récupérer les commentaires d'un article en fonction de son ID
        // Assurez-vous d'adapter cette logique en fonction de votre modèle de données et de votre système de persistance
        
        List<Commentaire> commentaires = new ArrayList<>();

        // Exemple de logique pour récupérer les commentaires d'un article depuis une source de données
        for (Commentaire commentaire : getAllCommentaires()) {
            if (commentaire.getArticle().getId() == articleId) {
                commentaires.add(commentaire);
            }
        }

        return commentaires;
    }
    
    // Méthode fictive pour récupérer tous les commentaires depuis une source de données
    private List<Commentaire> getAllCommentaires() {
        List<Commentaire> commentaires = new ArrayList<>();

        // Connexion à la base de données
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT id, texte, note, articleId FROM Commentaire";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String texte = resultSet.getString("texte");
                int note = resultSet.getInt("note");
                int articleId = resultSet.getInt("articleId");
                int utilisateurId = resultSet.getInt("utilisateurId");

                // Récupération de l'article associé au commentaire (à adapter selon votre modèle de données)
                ArticleService as = new ArticleService();
                Article article = as.getArticleById(articleId);
                
                UtilisateurService us = new UtilisateurService();
                Utilisateur utilisateur = us.getUtilisateurById(utilisateurId);

                Commentaire commentaire = new Commentaire(id, texte, note, article, utilisateur);
                commentaires.add(commentaire);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des commentaires : " + e.getMessage());
        }

        return commentaires;
    }
    
}
