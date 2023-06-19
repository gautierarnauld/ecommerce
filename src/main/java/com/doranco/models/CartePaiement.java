package com.doranco.models;

import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

class CartePaiement {
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

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public void setCryptogramme(String cryptogramme) {
        this.cryptogramme = cryptogramme;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    // Méthode pour crypter le numéro de carte
    public void crypterNumero(String cleSecrete) throws Exception {
        try {
            // Création de la clé secrète pour le chiffrement AES
            SecretKeySpec secretKey = new SecretKeySpec(cleSecrete.getBytes(), "AES");

            // Création de l'objet Cipher avec l'algorithme de chiffrement AES en mode ECB avec le padding PKCS5
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Initialisation du chiffrement en mode chiffrement avec la clé secrète
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Conversion du numéro de la carte en tableau de bytes
            byte[] numeroBytes = this.numero.getBytes();

            // Chiffrement du numéro de la carte
            byte[] numeroCrypteBytes = cipher.doFinal(numeroBytes);

            // Conversion du numéro de la carte chiffré en une chaîne encodée en Base64
            this.numero = Base64.getEncoder().encodeToString(numeroCrypteBytes);
            
        } catch (Exception e) {
            // En cas d'erreur lors du chiffrement, on lance une exception avec un message d'erreur personnalisé
            throw new Exception("Erreur lors du chiffrement du numéro de la carte : " + e.getMessage());
        }
    }
    
    // Méthode pour crypter le cryptogramme
    public void crypterCryptogramme(String cleSecrete) throws Exception {
        try {
            // Création de la clé secrète pour le chiffrement AES
            SecretKeySpec secretKey = new SecretKeySpec(cleSecrete.getBytes(), "AES");

            // Création de l'objet Cipher avec l'algorithme de chiffrement AES en mode ECB avec le padding PKCS5
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Initialisation du chiffrement en mode chiffrement avec la clé secrète
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Conversion du cryptogramme en tableau de bytes
            byte[] cryptogrammeBytes = this.cryptogramme.getBytes();

            // Chiffrement du cryptogramme
            byte[] cryptogrammeCrypteBytes = cipher.doFinal(cryptogrammeBytes);

            // Conversion du cryptogramme chiffré en une chaîne encodée en Base64
            this.cryptogramme = Base64.getEncoder().encodeToString(cryptogrammeCrypteBytes);
            
        } catch (Exception e) {
            // En cas d'erreur lors du chiffrement, on lance une exception avec un message d'erreur personnalisé
            throw new Exception("Erreur lors du chiffrement du cryptogramme : " + e.getMessage());
        }
    }
    
}
