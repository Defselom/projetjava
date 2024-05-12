/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.managedbeans;

import java.util.List;
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

    public void saveProduit(Produit produit) {
        try {
            produitService.save(produit);
            System.out.println("Produit enregistré avec succès !");
        } catch (Exception e) {
            Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getAllProduit() {
        try {
            List<Produit> produits = produitService.findAll();
            System.out.println("Produit recuperé avec succès !");
            for (Produit produit : produits) {
                System.out.println("ID : " + produit.getId());
                System.out.println("Libellé : " + produit.getLibelle());
                System.out.println("Actif : " + produit.getActif());
                System.out.println();
            }
        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getById(int produitId) {
        try {
            Produit produit = produitService.findById(produitId);
            if (produit != null) {
                // Afficher les informations du client
                System.out.println("Produit récupéré avec succès !");
                System.out.println("ID : " + produit.getId());
                System.out.println("Libelle : " + produit.getLibelle());
                System.out.println("Actif : " + produit.getActif());
            } else {
                System.out.println("Aucun Produit trouvé avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void update(Produit updateProduit) {
        try {
            Produit produit = produitService.findById(updateProduit.getId());
            if (produit != null) {
                int rowsUpdated = produitService.update(updateProduit);
                if (rowsUpdated > 0) {
                    System.out.println("Produit mis à jour avec succès !");
                } else {
                    System.out.println("La mise à jour du produit a échoué.");
                }
            } else {
                System.out.println("Aucun produit trouvé avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
