package com.doranco.services;

import com.doranco.models.CartePaiement;
import com.doranco.models.Utilisateur;
import com.doranco.utils.DatabaseConnector;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CartePaiementService {
    // Méthode pour crypter une chaîne de caractères
    public static String encrypt(String data, String secretKey) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    /*Méthode pour ajouter une carte de paiement dans la base de données*/
    public void ajouterCartePaiement(CartePaiement cartePaiement, int utilisateurId) {
        String query = "INSERT INTO CartePaiement (id, nomProprietaire, prenomProprietaire, numero, dateFinValidite, cryptogramme, utilisateurId) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cartePaiement.getId());
            statement.setString(2, cartePaiement.getNomProprietaire());
            statement.setString(3, cartePaiement.getPrenomProprietaire());
            statement.setString(4, cartePaiement.getNumero());
            statement.setDate(5, new java.sql.Date(cartePaiement.getDateFinValidite().getTime()));
            statement.setString(6, cartePaiement.getCryptogramme());
            statement.setInt(7, utilisateurId);

            statement.executeUpdate();
            System.out.println("La carte de paiement a été ajoutée à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la carte de paiement : " + e.getMessage());
        }
    }

    public CartePaiement getCartePaiementById(int cartePaiementId) {
        String query = "SELECT * FROM CartePaiement WHERE id = ?";
        CartePaiement cartePaiement = null;

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cartePaiementId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Récupérer les informations de la carte de paiement depuis le résultat de la requête
                    int id = resultSet.getInt("id");
                    String nomProprietaire = resultSet.getString("nomProprietaire");
                    String prenomProprietaire = resultSet.getString("prenomProprietaire");
                    String numero = resultSet.getString("numero");
                    Date dateFinValidite = resultSet.getDate("dateFinValidite");
                    String cryptogramme = resultSet.getString("cryptogramme");

                    // Créer l'objet CartePaiement avec les informations récupérées
                    cartePaiement = new CartePaiement(id, nomProprietaire, prenomProprietaire, numero, dateFinValidite, cryptogramme, null);
                }
            }
        } catch (SQLException e) {
            // Gérer les erreurs de connexion à la base de données
            System.err.println("Erreur lors de la récupération de la carte de paiement : " + e.getMessage());
        }

        // Renvoyer l'objet CartePaiement (ou null si aucune carte correspondant à l'identifiant n'a été trouvée)
        return cartePaiement;
    }

    public CartePaiement getCartePaiementByUtilisateurId(int utilisateurId) {
        CartePaiement cartePaiement = null;
        String query = "SELECT * FROM CartePaiement WHERE utilisateurId = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, utilisateurId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nomProprietaire = resultSet.getString("nomProprietaire");
                    String prenomProprietaire = resultSet.getString("prenomProprietaire");
                    String numero = resultSet.getString("numero");
                    Date dateFinValidite = resultSet.getDate("dateFinValidite");
                    String cryptogramme = resultSet.getString("cryptogramme");

                    UtilisateurService utilisateurService = new UtilisateurService();
                    Utilisateur utilisateur = utilisateurService.getUtilisateurById(resultSet.getInt("utilisateurId"));

                    cartePaiement = new CartePaiement(id, nomProprietaire, prenomProprietaire, numero,
                            dateFinValidite, cryptogramme, utilisateur);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la carte de paiement : " + e.getMessage());
        }

        return cartePaiement;
    }

}
