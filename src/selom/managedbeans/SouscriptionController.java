/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.managedbeans;

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
}
