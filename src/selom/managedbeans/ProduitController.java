/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.managedbeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.Produit;
import selom.services.implementations.ProduitServiceBean;

/**
 *
 * @author m2pro
 */
public class ProduitController {
     private ProduitServiceBean produitService;

    public ProduitController(ProduitServiceBean monProduitService) {
        this.produitService = monProduitService;
    }

    public ProduitController() {
        this.produitService = new ProduitServiceBean();
    }
    
    
    public void saveProduit(Produit produit){
     try {
            produitService.save(produit);
            System.out.println("Produit enregistré avec succès !");
        } catch (Exception e) {
            Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
