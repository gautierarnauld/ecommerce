package com.doranco.models;

import java.util.Date;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utilisateur {
    //Variables
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private boolean actif;
    private String email;
    private String motDePasse; /*mdp crypter*/
    private String numeroTelephone;
    private Adresse adresse; /* - - - Liste d'adresse à faire - - -*/
    private List<Commande> commandes;
    private CartePaiement cartePaiement;
    private Commentaire commentaire;
    private List<ArticlePanier> panier;
    
    //Constructeurs
    public Utilisateur(int id, String nom, String prenom, Date dateNaissance, boolean actif, String email, String motDePasse, String numeroTelephone, Adresse adresse, List<Commande> commandes, CartePaiement cartePaiement, Commentaire commentaire, List<ArticlePanier> panier) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.actif = actif;
        this.email = email;
        this.motDePasse = motDePasse;
        this.numeroTelephone = numeroTelephone;
        this.adresse = adresse;
        this.commandes = commandes;
        this.cartePaiement = cartePaiement;
        this.commentaire = commentaire;
        this.panier = panier;
    }

    public Utilisateur(){
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public boolean isActif() {
        return actif;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public CartePaiement getCartePaiement() {
        return cartePaiement;
    }
    
    public Commentaire getCommentaire(){
        return commentaire;
    }

    public List<ArticlePanier> getPanier() {
        return panier;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String motDePasseCrypte = encoder.encode(motDePasse);
        this.motDePasse = motDePasseCrypte;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public void setCartePaiement(CartePaiement cartePaiement) {
        this.cartePaiement = cartePaiement;
    }
    
    public void setCommentaire(Commentaire commentaire){
        this.commentaire = commentaire;
    }

    public void setPanier(List<ArticlePanier> panier) {
        this.panier = panier;
    }   
}
