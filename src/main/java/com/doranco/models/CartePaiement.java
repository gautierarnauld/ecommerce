package com.doranco.models;

import com.doranco.services.CartePaiementService;
import java.util.Date;

public class CartePaiement {
    //Variables
    private int id;
    private String nomProprietaire;
    private String prenomProprietaire;
    private String numero; /*Numéro crypter*/
    private Date dateFinValidite;
    private String cryptogramme; /*Cryptogramme crypter*/
    private Utilisateur utilisateur;
    
    //Constructeur
    public CartePaiement(int id, String nomProprietaire, String prenomProprietaire, String numero, Date dateFinValidite, String cryptogramme, Utilisateur utilisateur) {
        this.id = id;
        this.nomProprietaire = nomProprietaire;
        this.prenomProprietaire = prenomProprietaire;
        this.numero = numero;
        this.dateFinValidite = dateFinValidite;
        this.cryptogramme = cryptogramme;
        this.utilisateur = utilisateur;
    }
    
    public CartePaiement(){}

    //Getter & Setter
    public int getId() {
        return id;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public String getPrenomProprietaire() {
        return prenomProprietaire;
    }

    public String getNumero() {
        return numero;
    }

    public Date getDateFinValidite() {
        return dateFinValidite;
    }

    public String getCryptogramme() {
        return cryptogramme;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    public void setPrenomProprietaire(String prenomProprietaire) {
        this.prenomProprietaire = prenomProprietaire;
    }

    public void setNumero(String numero) throws Exception {
        //Cryptage du numéro de carte
        try {
            String secretKey = "MaCleSecrete1234";
            this.numero = CartePaiementService.encrypt(numero, secretKey);
        } catch (Exception e) {
            throw new Exception("Erreur lors du cryptage du numéro de carte : " + e.getMessage());
        }
    }

    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public void setCryptogramme(String cryptogramme) throws Exception {
        //Cryptage du cryptogramme
        try {
            String secretKey = "MaCleSecrete5678";
            this.cryptogramme = CartePaiementService.encrypt(cryptogramme, secretKey);
        } catch (Exception e) {
            throw new Exception("Erreur lors du cryptage du cryptogramme de carte : " + e.getMessage());
        }
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }    
}
