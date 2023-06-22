package com.doranco.controller;

import com.doranco.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/gestion-achats")
public class GestionAchatsController {
    
    /*private CommandeService commandeService;
    
    @Autowired
    public GestionAchatsController(CommandeService commandeService) {
    this.commandeService = commandeService;
    }
    
    @PostMapping("/achats")
    public ResponseEntity<String> effectuerAchat(@RequestBody Commande commande) {
    boolean achatReussi = achatService.effectuerAchat(commande);
    if (achatReussi) {
    return ResponseEntity.ok("Achat effectué avec succès.");
    } else {
    return ResponseEntity.badRequest().body("Impossible de finaliser l'achat.");
    }
    }*/
    
}
