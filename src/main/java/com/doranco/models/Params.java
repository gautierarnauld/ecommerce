package com.doranco.models;

public class Params {
    private int id;
    private String cleCryptagePwd;
    private String cleCryptageCp;

    // Constructeur
    public Params(int id, String cleCryptagePwd, String cleCryptageCp) {
        this.id = id;
        this.cleCryptagePwd = cleCryptagePwd;
        this.cleCryptageCp = cleCryptageCp;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCleCryptagePwd() {
        return cleCryptagePwd;
    }

    public void setCleCryptagePwd(String cleCryptagePwd) {
        this.cleCryptagePwd = cleCryptagePwd;
    }

    public String getCleCryptageCp() {
        return cleCryptageCp;
    }

    public void setCleCryptageCp(String cleCryptageCp) {
        this.cleCryptageCp = cleCryptageCp;
    }
    
}

