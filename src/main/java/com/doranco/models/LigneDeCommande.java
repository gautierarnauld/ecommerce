package com.doranco.models;

public class LigneDeCommande {
    //Variables
    private int id;
    private int quantite;
    private double prixUnitaire;
    private double remiseArticle;
    private Commande commande;
    private Article article;
    
    //Constructeur
    public LigneDeCommande(int id, int quantite, double prixUnitaire, double remiseArticle, Commande commande, Article article) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.remiseArticle = remiseArticle;
        this.commande = commande;
        this.article = article;
    }
    
    public LigneDeCommande(){}
    
    //Getter & setter
    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public double getRemiseArticle() {
        return remiseArticle;
    }

    public Commande getCommande() {
        return commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setRemiseArticle(double remiseArticle) {
        this.remiseArticle = remiseArticle;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    
}
