package com.doranco.models;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    // Variables
    private int id;
    private String nom;
    private double remise; // en pourcentage (%)
    private boolean isRemiseCumulable;
    private String photo;
    private Article article;
    
    private List<Article> articles = new ArrayList<>();
    private List<Integer> articleIds = new ArrayList<>();    

    // Constructeurs
    public Categorie(int id, String nom, double remise, boolean isRemiseCumulable, String photo, Article article) {
        this.id = id;
        this.nom = nom;
        this.remise = remise;
        this.isRemiseCumulable = isRemiseCumulable;
        this.photo = photo;
        this.article = article;
    }

    public Categorie() {
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getRemise() {
        return remise;
    }

    public boolean isRemiseCumulable() {
        return isRemiseCumulable;
    }

    public String getPhoto() {
        return photo;
    }

    public Article getArticle() {
        return article;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public void setRemiseCumulable(boolean isRemiseCumulable) {
        this.isRemiseCumulable = isRemiseCumulable;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    // Méthode pour obtenir la remise en pourcentage
    public double getRemiseEnPourcentage() {
        return remise * 100; // Multiplier par 100 pour obtenir le pourcentage
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }
    
    public List<Integer> getArticleIds() {
        return articleIds;
    }

    public void setArticleIds(List<Integer> articleIds) {
        this.articleIds = articleIds;
    }
}
