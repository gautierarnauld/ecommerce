package com.doranco.services;

import com.doranco.models.Article;
import com.doranco.models.Categorie;
import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieService {
    
    public void ajouterCategorie(Categorie categorie) {
        String query = "INSERT INTO Categorie (id, nom, remise, isRemiseCumulable, photo) " +
                       "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categorie.getId());
            statement.setString(2, categorie.getNom());
            statement.setDouble(3, categorie.getRemise());
            statement.setBoolean(4, categorie.isRemiseCumulable());
            statement.setString(5, categorie.getPhoto());

            statement.executeUpdate();
            System.out.println("La catégorie " + categorie.getNom() + " a été ajoutée à la base de données.");

            // Récupérer les articles à partir de la liste des IDs
            List<Article> articles = new ArrayList<>();
            List<Integer> articleIds = categorie.getArticleIds();
            if (articleIds != null && !articleIds.isEmpty()) {
                for (Integer articleId : articleIds) {
                    ArticleService as = new ArticleService();
                    Article article = as.getArticleById(articleId);
                    if (article != null) {
                        articles.add(article);
                    }
                }
            }

            // Ajouter les articles associés à la catégorie
            if (!articles.isEmpty()) {
                String articleQuery = "INSERT INTO Categorie_Article (categorieId, articleId) VALUES (?, ?)";
                PreparedStatement articleStatement = connection.prepareStatement(articleQuery);
                articleStatement.setInt(1, categorie.getId());
                for (Article article : articles) {
                    articleStatement.setInt(2, article.getId());
                    articleStatement.addBatch();
                }
                articleStatement.executeBatch();
                articleStatement.close();
                System.out.println("Les articles ont été associés à la catégorie.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la catégorie : " + e.getMessage());
        }
    }

}
