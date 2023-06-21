package com.doranco.models;

public class CategorieArticle {
    private int categorieId;
    private int articleId;

    public CategorieArticle(int categorieId, int articleId) {
        this.categorieId = categorieId;
        this.articleId = articleId;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
