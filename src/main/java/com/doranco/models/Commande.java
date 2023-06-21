package com.doranco.models;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Commande {
    //Variables
    private int id;
    private String numero;
    private String dateCreation;
    private String dateLivraison;
    private double totaleRemise;
    private double fraisExpedition;
    private double totalGeneral;
    private Adresse adresseFacturation;
    private Adresse adresseLivraison;
    private CartePaiement cartePaiementDefaut;
    private Utilisateur utilisateur;
    private List<LigneDeCommande> lignesDeCommande;
    
    //Constructeur
    public Commande(int id, String numero, String dateCreation, String dateLivraison, double totaleRemise, double fraisExpedition, double totalGeneral, Adresse adresseFacturation, Adresse adresseLivraison, CartePaiement cartePaiementDefaut, Utilisateur utilisateur, List<LigneDeCommande> lignesDeCommande) {
        this.id = id;
        this.numero = numero;
        this.dateCreation = dateCreation;
        this.dateLivraison = dateLivraison;
        this.totaleRemise = totaleRemise;
        this.fraisExpedition = fraisExpedition;
        this.totalGeneral = totalGeneral;
        this.adresseFacturation = adresseFacturation;
        this.adresseLivraison = adresseLivraison;
        this.cartePaiementDefaut = cartePaiementDefaut;
        this.utilisateur = utilisateur;
        this.lignesDeCommande = lignesDeCommande;
    }
    
    public Commande(){}

    //Getter & Setter
    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public double getTotaleRemise() {
        return totaleRemise;
    }

    public double getFraisExpedition() {
        return fraisExpedition;
    }

    public double getTotalGeneral() {
        return totalGeneral;
    }

    public Adresse getAdresseFacturation() {
        return adresseFacturation;
    }

    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }

    public CartePaiement getCartePaiementDefaut() {
        return cartePaiementDefaut;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public List<LigneDeCommande> getLignesDeCommande() {
        return lignesDeCommande;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void setTotaleRemise(double totaleRemise) {
        this.totaleRemise = totaleRemise;
    }

    public void setFraisExpedition(double fraisExpedition) {
        this.fraisExpedition = fraisExpedition;
    }

    public void setTotalGeneral(double totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public void setAdresseFacturation(Adresse adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public void setAdresseLivraison(Adresse adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public void setCartePaiementDefaut(CartePaiement cartePaiementDefaut) {
        this.cartePaiementDefaut = cartePaiementDefaut;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setLignesDeCommande(List<LigneDeCommande> lignesDeCommande) {
        this.lignesDeCommande = lignesDeCommande;
    }    
}
