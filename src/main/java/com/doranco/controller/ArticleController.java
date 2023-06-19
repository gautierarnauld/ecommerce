package com.doranco.controller;

import java.util.List;
import com.doranco.models.Article;
import org.springframework.stereotype.Controller;

@Controller
public class ArticleController {
    //- - - - - - - Variables - - - - - - - 
    private List<Article> articles; // Liste des articles
    private Article nouvelArticle; // Nouvel article à ajouter
    private int articleIdToDelete; // ID de l'article à supprimer
    
    //- - - - - - - Constructeurs - - - - - - - 
    public ArticleController() {
    }

    public ArticleController(List<Article> articles, Article nouvelArticle, int articleIdToDelete) {
        this.articles = articles;
        this.nouvelArticle = nouvelArticle;
        this.articleIdToDelete = articleIdToDelete;
    }
    
    //- - - - - - - Getter & Setter - - - - - - - 
    public Article getNouvelArticle() {
        return nouvelArticle;
    }

    public int getArticleIdToDelete() {
        return articleIdToDelete;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setNouvelArticle(Article nouvelArticle) {
        this.nouvelArticle = nouvelArticle;
    }

    public void setArticleIdToDelete(int articleIdToDelete) {
        this.articleIdToDelete = articleIdToDelete;
    }
       
    //- - - - - - - Méthode pour ajouter un nouvel article - - - - - - - 
    public String ajouterArticle() {
        // Logique pour ajouter l'article à la source
        return "gestion-articles.xhtml?faces-redirect=true";
    }
    
    //- - - - - - - Méthode pour supprimer un article - - - - - - - 
    public String supprimerArticle() {
        // Logique pour supprimer l'article de la source de données
        return "gestion-articles.xhtml?faces-redirect=true";
    }

    //- - - - - - - Méthode pour récupérer la liste des articles - - - - - - - 
    public List<Article> getArticles() {
        // Récupérez la liste des articles 
        return articles;
    }
    
}
