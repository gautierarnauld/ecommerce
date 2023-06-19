package com.doranco.models;

public class Categorie {
    // Variables
    private int id;
    private String nom;
    private double remise; // en pourcentage (%)
    private boolean isRemiseCumulable;
    private String photo;
    private Article article;

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
}
