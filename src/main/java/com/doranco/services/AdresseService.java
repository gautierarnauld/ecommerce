package com.doranco.services;

import com.doranco.models.Adresse;
import com.doranco.models.Utilisateur;
import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseService {
    
    //Méthode pour ajouter une adresse dans la base de données
    public void ajouterAdresse(Adresse adresse) {
        String query = "INSERT INTO Adresse (id, numero, rue, ville, codePostal) " +
                       "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, adresse.getId());
            statement.setString(2, adresse.getNumero());
            statement.setString(3, adresse.getRue());
            statement.setString(4, adresse.getVille());
            statement.setString(5, adresse.getCodePostal());

            statement.executeUpdate();
            System.out.println("L'adresse a été ajoutée à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'adresse : " + e.getMessage());
        }
    }

    public Adresse getAdresseById(int id) {
        String query = "SELECT * FROM Adresse WHERE id = ?";
        Adresse adresse = null;

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int adresseId = resultSet.getInt("id");
                    String numero = resultSet.getString("numero");
                    String rue = resultSet.getString("rue");
                    String codePostal = resultSet.getString("codePostal");
                    String ville = resultSet.getString("ville");
                    int utilisateurId = resultSet.getInt("utilisateurId");
                    
                    UtilisateurService utilisateurService = new UtilisateurService();
                    Utilisateur utilisateur = utilisateurService.getUtilisateurById(utilisateurId);

                    adresse = new Adresse(adresseId, numero, rue, ville, codePostal, utilisateur);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'adresse : " + e.getMessage());
        }

        return adresse;
    }    
}