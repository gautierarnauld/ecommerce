package com.doranco.models;

import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Article {
    //Variables
    private int id;
    private String nom;
    private double prix;
    private boolean vendu;
    private String photo;
    private double remise; // en pourcentage (%)
    private int stock;
    private String description;
    private String commentaire;
    
    //Constructeur
    public Article() {
    }

    public Article(int id, String nom, double prix, boolean vendu, String photo, 
            double remise, int stock, String description, String commentaire) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.vendu = vendu;
        this.photo = photo;
        this.remise = remise;
        this.stock = stock;
        this.description = description;
        this.commentaire = commentaire;
    }
    
    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isVendu() {
        return vendu;
    }

    public String getPhoto() {
        return photo;
    }

    public double getRemise() {
        return remise;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public String getCommentaire() {
        return commentaire;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setVendu(boolean vendu) {
        this.vendu = vendu;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    public double getRemiseEnPourcentage() {
        return remise * 100; // Multiplier par 100 pour obtenir le pourcentage
    }
    
    /*Méthode pour ajouter un article dans la base de données*/
    public void ajouterArticle() {
        String query = "INSERT INTO Article (id, nom, prix, vendu, photo, remise, stock, description, commentaire) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setString(2, nom);
            statement.setDouble(3, prix);
            statement.setBoolean(4, vendu);
            statement.setString(5, photo);
            statement.setDouble(6, remise);
            statement.setInt(7, stock);
            statement.setString(8, description);
            statement.setString(9, commentaire);

            statement.executeUpdate();
            System.out.println("L'article a été ajouté à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'article : " + e.getMessage());
        }
    }
}
