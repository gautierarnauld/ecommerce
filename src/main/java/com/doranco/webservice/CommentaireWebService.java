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

    @GetMapping("/article/{id}")
    public ResponseEntity<List<Commentaire>> getCommentairesByArticleId(@PathVariable("id") int articleId) {
        List<Commentaire> commentaires = commentaireService.getCommentairesByArticleId(articleId);

        if (commentaires == null || commentaires.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(commentaires);
    }
}



