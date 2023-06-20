package com.doranco.models;

import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Adresse {
    //Variables
    private int id;
    private String numero;
    private String rue;
    private String ville;
    private String codePostal;
    private Utilisateur utilisateur;
    
    //Constructeur
    public Adresse(int id, String numero, String rue, String ville, String codePostal, Utilisateur utilisateur) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.utilisateur = utilisateur;
    }
    
    public Adresse(){}
    
    //Getter
    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    //Méthode pour ajouter une adresse dans la base de données
    public void ajouterAdresse() {
        String query = "INSERT INTO Adresse (id, numero, rue, ville, codePostal) " +
                       "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setString(2, numero);
            statement.setString(3, rue);
            statement.setString(4, ville);
            statement.setString(5, codePostal);

            statement.executeUpdate();
            System.out.println("L'adresse a été ajoutée à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'adresse : " + e.getMessage());
        }
    }

}
