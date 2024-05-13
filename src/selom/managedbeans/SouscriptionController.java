/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.managedbeans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.Souscription;
import selom.services.implementations.SouscriptionServiceBean;

/**
 *
 * @author m2pro
 */
public class SouscriptionController {

    private SouscriptionServiceBean souscriptionService;

    public SouscriptionController(SouscriptionServiceBean maSouscriptionService) {
        this.souscriptionService = maSouscriptionService;
    }

    public SouscriptionController() {
        this.souscriptionService = new SouscriptionServiceBean();
    }

    public void save(Souscription souscription) {
        try {
            souscriptionService.save(souscription);
            System.out.println("Souscription enregistré avec succès !");
        } catch (Exception e) {
            Logger.getLogger(SouscriptionController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getAllSouscription() {
        try {
            List<Souscription> allSouscription = souscriptionService.findAll();
            System.out.println(" Souscription recuperé avec succès !");
            for (Souscription souscription : allSouscription) {
                System.out.println("ID : " + souscription.getId());
                System.out.println("id Client : " + souscription.getIdClient().getId());
                System.out.println("id Produit : " + souscription.getIdProduit().getId());
                System.out.println("Actif : " + souscription.getActif());
                System.out.println("Date souscription : " + souscription.getDateHeureSous());
                System.out.println();
            }
        } catch (Exception e) {
            Logger.getLogger(SouscriptionController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getById(int souscriptionId) {
        try {
            Souscription souscription = souscriptionService.findById(souscriptionId);
            if (souscription != null) {
                System.out.println("ID : " + souscription.getId());
                System.out.println("id Client : " + souscription.getIdClient().getId());
                System.out.println("id Produit : " + souscription.getIdProduit().getId());
                System.out.println("Actif : " + souscription.getActif());
                System.out.println("Date souscription : " + souscription.getDateHeureSous());
            } else {
                System.out.println("Aucune souscription trouvée avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(SouscriptionController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void update(Souscription updateSouscription) {
        try {
            Souscription souscription = souscriptionService.findById(updateSouscription.getId());
            if (souscription != null) {
                int rowsUpdated = souscriptionService.update(updateSouscription);
                if (rowsUpdated > 0) {
                    System.out.println("Souscription mis à jour avec succès !");
                } else {
                    System.out.println("La mise à jour de la Souscription a échoué.");
                }
            } else {
                System.out.println("Aucune Souscription trouvée avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(SouscriptionController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteById(int souscriptionId) {
        try {
            Souscription souscription = souscriptionService.findById(souscriptionId);
            if (souscription != null) {
                souscriptionService.deleteById(souscriptionId);
                System.out.println("Souscription supprimée avec succès !");
            } else {
                System.out.println("Aucune Souscription trouvée avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(SouscriptionController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
