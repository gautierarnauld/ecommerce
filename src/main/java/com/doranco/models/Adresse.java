package com.doranco.models;

public class Adresse {
    //Variables
    private int id;
    private String numero;
    private String rue;
    private String ville;
    private String codePostal;
    private Utilisateur utilisateur;
    
    //Constructeur
    public Adresse(int id, String numero, String rue, String ville, String codePostal, Utilisateur utilisateur) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.utilisateur = utilisateur;
    }
    
    public Adresse(){}
    
    //Getter
    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }    
}
