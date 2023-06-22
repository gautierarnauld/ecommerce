package com.doranco.services;

import com.doranco.models.Article;
import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleService {
    
    /*Méthode pour ajouter un article dans la base de données*/
    public void ajouterArticle(Article article) {
        String query = "INSERT INTO Article (id, nom, prix, vendu, photo, remise, stock, description, commentaire) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, article.getId());
            statement.setString(2, article.getNom());
            statement.setDouble(3, article.getPrix());
            statement.setBoolean(4, article.isVendu());
            statement.setString(5, article.getPhoto());
            statement.setDouble(6, article.getRemise());
            statement.setInt(7, article.getStock());
            statement.setString(8, article.getDescription());
            statement.setString(9, article.getCommentaire());

            statement.executeUpdate();
            System.out.println("L'article a été ajouté à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'article : " + e.getMessage());
        }
    }
    
    public Article getArticleById(int articleId) {
        Article article = null;
        String query = "SELECT * FROM Article WHERE id = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, articleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    double prix = resultSet.getDouble("prix");
                    boolean vendu = resultSet.getBoolean("vendu");
                    String photo = resultSet.getString("photo");
                    double remise = resultSet.getDouble("remise");
                    int stock = resultSet.getInt("stock");
                    String description = resultSet.getString("description");
                    String commentaire = resultSet.getString("commentaire");

                    article = new Article(id, nom, prix, vendu, photo, remise, stock, description, commentaire);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'article : " + e.getMessage());
        }

        return article;
    }

    public void mettreAJourStock(Article article, int quantiteCommandee) {
        int ancienStock = article.getStock();
        int nouveauStock = ancienStock - quantiteCommandee;
        article.setStock(nouveauStock);

        // Mettre à jour l'article dans la base de données
        mettreAJourArticle(article);
    }
    
    private void mettreAJourArticle(Article article) {
        String query = "UPDATE Article SET stock = ? WHERE id = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, article.getStock());
            statement.setInt(2, article.getId());

            statement.executeUpdate();
            System.out.println("Stock de l'article mis à jour avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du stock de l'article : " + e.getMessage());
        }
    }
}