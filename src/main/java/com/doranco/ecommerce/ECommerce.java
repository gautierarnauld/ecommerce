package com.doranco.ecommerce;

import com.doranco.models.Article;

public class ECommerce {
    public static void main(String[] args) {
        // Création d'un nouvel article
        Article nouvelArticle = new Article();
        nouvelArticle.setId(3);
        nouvelArticle.setNom("Nounours viking");
        nouvelArticle.setPrix(19.90);
        nouvelArticle.setVendu(false);
        nouvelArticle.setPhoto("https://boutique.puydufou.com/media/catalog/product/p/e/peluche-ours-viking-2_1.png");
        nouvelArticle.setRemise(0.2); // 20% de remise
        nouvelArticle.setStock(2);
        nouvelArticle.setDescription("Ce petit ours Viking vous protègera contre les attaques de barbares !");
        nouvelArticle.setCommentaire("J'adore");

        // Ajout de l'article à la base de données
        nouvelArticle.ajouterArticle();
    }
}