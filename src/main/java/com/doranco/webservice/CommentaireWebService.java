package com.doranco.webservice;

import com.doranco.models.Commentaire;
import com.doranco.services.CommentaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commentaires")
public class CommentaireWebService {
    
    private CommentaireService commentaireService;

    public CommentaireWebService() {
        commentaireService = new CommentaireService();
    }

    // Endpoint pour récupérer les commentaires d'un article spécifié par son ID
    @GetMapping("/article/{id}")
    public ResponseEntity<List<Commentaire>> getCommentairesByArticleId(@PathVariable("id") int articleId) {
        // Appel à la méthode du service pour obtenir les commentaires par ID de l'article
        List<Commentaire> commentaires = commentaireService.getCommentairesByArticleId(articleId);

        // Vérifier si aucun commentaire n'a été trouvé
        if (commentaires == null || commentaires.isEmpty()) {
            // Retourner une réponse indiquant que les commentaires n'ont pas été trouvés (code 404)
            return ResponseEntity.notFound().build();
        }

        // Retourner les commentaires trouvés dans une réponse avec un code 200 (OK)
        return ResponseEntity.ok(commentaires);
    }
}



