package com.doranco.services;

import com.doranco.models.Adresse;
import com.doranco.models.ArticlePanier;
import com.doranco.models.CartePaiement;
import com.doranco.models.Commande;
import com.doranco.models.Commentaire;
import com.doranco.models.Utilisateur;
import com.doranco.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UtilisateurService {
    
    // Méthode pour vérifier le mot de passe
    public boolean verifierMotDePasse(Utilisateur utilisateur, String motDePasse) {
        // Création d'une instance de BCryptPasswordEncoder, qui est un 
        // algorithme de hachage fort utilisé pour le hachage sécurisé des mdp
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // Appel de la méthode matches de l'objet encoder pour comparer le 
        // mdp fourni en paramètre avec le mdp haché stocké dans l'objet Utilisateur
        // La méthode matches renvoie true si les deux mots de passe correspondent, et false sinon
        return encoder.matches(motDePasse, utilisateur.getMotDePasse());
    }
    
    /*Méthode pour ajouter un user dans la base de données*/
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String query = "INSERT INTO Utilisateur (id, nom, prenom, dateNaissance, actif, email, motDePasse, numeroTelephone, adresseId) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, utilisateur.getId());
            statement.setString(2, utilisateur.getNom());
            statement.setString(3, utilisateur.getPrenom());
            statement.setDate(4, new java.sql.Date(utilisateur.getDateNaissance().getTime()));
            statement.setBoolean(5, utilisateur.isActif());
            statement.setString(6, utilisateur.getEmail());
            statement.setString(7, utilisateur.getMotDePasse());
            statement.setString(8, utilisateur.getNumeroTelephone());
            statement.setInt(9, utilisateur.getAdresse().getId());

            statement.executeUpdate();
            System.out.println("L'utilisateur a été ajouté à la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    public Utilisateur getUtilisateurById(int id) {
        String query = "SELECT * FROM Utilisateur WHERE id = ?";
        Utilisateur utilisateur = null;

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int utilisateurId = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    Date dateNaissance = resultSet.getDate("dateNaissance");
                    boolean actif = resultSet.getBoolean("actif");
                    String email = resultSet.getString("email");
                    String motDePasse = resultSet.getString("motDePasse");
                    String numeroTelephone = resultSet.getString("numeroTelephone");

                    AdresseService adresseService = new AdresseService();
                    Adresse adresse = adresseService.getAdresseById(resultSet.getInt("adresseId"));
                                        
                    List<Commande> commandes = getCommandesByUtilisateurId(utilisateurId);
                    
                    CartePaiementService cartePaiementSercice = new CartePaiementService();
                    CartePaiement cartePaiement = cartePaiementSercice.getCartePaiementByUtilisateurId(utilisateurId);
                    
                    CommentaireService commentaireService = new CommentaireService();
                    Commentaire commentaire = commentaireService.getCommentaireByUtilisateurId(utilisateurId);
                    
                    ArticlePanierService articlePanierService = new ArticlePanierService();
                    List<ArticlePanier> panier = articlePanierService.getPanierByUtilisateurId(utilisateurId);

                    utilisateur = new Utilisateur(utilisateurId, nom, prenom, dateNaissance, actif, email, motDePasse, numeroTelephone,
                            adresse, commandes, cartePaiement, commentaire, panier);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'utilisateur : " + e.getMessage());
        }

        return utilisateur;
    }

    private List<Commande> getCommandesByUtilisateurId(int utilisateurId) {
        String query = "SELECT * FROM Commande WHERE utilisateurId = ?";
        List<Commande> commandes = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, utilisateurId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int commandeId = resultSet.getInt("id");
                    String numero = resultSet.getString("numero");
                    String dateCreation = resultSet.getString("dateCreation");
                    String dateLivraison = resultSet.getString("dateLivraison");
                    double totaleRemise = resultSet.getDouble("totaleRemise");
                    double fraisExpedition = resultSet.getDouble("fraisExpedition");
                    double totalGeneral = resultSet.getDouble("totalGeneral");

                    // Dans votre cas, vous pouvez ignorer les informations d'adresse
                    // Créer l'objet Commande avec les informations récupérées
                    Commande commande = new Commande(commandeId, numero, dateCreation, dateLivraison, totaleRemise,
                            fraisExpedition, totalGeneral, null, null, null, null, null);

                    commandes.add(commande);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des commandes : " + e.getMessage());
        }

        return commandes;
    }

    

}
