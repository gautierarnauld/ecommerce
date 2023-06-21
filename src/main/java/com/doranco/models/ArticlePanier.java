package com.doranco.models;

public class ArticlePanier {
    //Variables
    private int id;
    private Article article;
    private int quantite;
    private Utilisateur utilisateur;
    
    //Constructeur
    public ArticlePanier(){}
    
    public ArticlePanier(int id, Article article, int quantite, Utilisateur utilisateur) {
        this.id = id;
        this.article = article;
        this.quantite = quantite;
        this.utilisateur = utilisateur;
    }
    
    //Getter  
    public int getId() {
        return id;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    //Setter  
    public void setId(int id) {
        this.id = id;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
