package com.doranco.models;

public class Article {
    //Variables
    private int id;
    private String nom;
    private double prix;
    private boolean vendu;
    private String photo;
    private double tauxRemise;
    private int stock;
    
    //Constructeur

    public Article() {
    }

    public Article(int id, String nom, double prix, boolean vendu, String photo, double tauxRemise, int stock) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.vendu = vendu;
        this.photo = photo;
        this.tauxRemise = tauxRemise;
        this.stock = stock;
    }
    
    //Getter & Setter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isVendu() {
        return vendu;
    }

    public String getPhoto() {
        return photo;
    }

    public double getTauxRemise() {
        return tauxRemise;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setVendu(boolean vendu) {
        this.vendu = vendu;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setTauxRemise(double tauxRemise) {
        this.tauxRemise = tauxRemise;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
