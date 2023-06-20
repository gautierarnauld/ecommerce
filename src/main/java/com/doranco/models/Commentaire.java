package com.doranco.models;

import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Commentaire {
    //Variables
    private int id;
    private String texte;
    private int note;
    private Article article;
    private Utilisateur utilisateur;
    
    //Constructeurs
    public Commentaire(int id, String texte, int note, Article article, Utilisateur utilisateur) {
        this.id = id;
        this.texte = texte;
        this.note = note;
        this.article = article;
        this.utilisateur = utilisateur;
    }
    
    public Commentaire(){}
    
    //Getter & Setter
    public int getId() {
        return id;
    }

    public String getTexte() {
        return texte;
    }

    public int getNote() {
        return note;
    }

    public Article getArticle() {
        return article;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setNote(int note) {
        if (note >= 0 && note <= 5) {
            this.note = note;
        } else {
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 5");
        }
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
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
}
