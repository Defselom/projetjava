/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.managedbeans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.Client;
import selom.entities.Sms;
import selom.services.implementations.SmsServiceBean;

/**
 *
 * @author m2pro
 */
public class SmsController {

    private SmsServiceBean smsService;

    public SmsController(SmsServiceBean monProduitService) {
        this.smsService = monProduitService;
    }

    public SmsController() {
        this.smsService = new SmsServiceBean();
    }

    public void save(Sms sms) {
        try {
            smsService.save(sms);
            System.out.println("SMS enregistré avec succès !");
        } catch (Exception e) {
            Logger.getLogger(SmsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getAllSms() {
        try {
            List<Sms> allSms = smsService.findAll();
            System.out.println(" SMS recuperé avec succès !");
            for (Sms sms : allSms) {
                System.out.println("ID : " + sms.getId());
                System.out.println("id Client : " + sms.getIdClient().getId());
                System.out.println("libellé : " + sms.getLibelle());
                System.out.println("status : " + sms.getStatus());
                System.out.println();
            }
        } catch (Exception e) {
            Logger.getLogger(SmsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getById(int smsId) {
        try {
            Sms sms = smsService.findById(smsId);
            if (sms != null) {
                // Afficher les informations du client
                System.out.println("SMS récupéré avec succès !");
                System.out.println("ID : " + sms.getId());
                System.out.println("client id : " + sms.getIdClient().getId());
                System.out.println("libellé : " + sms.getLibelle());
                System.out.println("status : " + sms.getStatus());
            } else {
                System.out.println("Aucun SMS trouvé avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(SmsController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    
     public void update(Sms updateSms){
         try {
            Sms sms = smsService.findById(updateSms.getId());
            if (sms != null) {
              int rowsUpdated = smsService.update(updateSms);
               if (rowsUpdated > 0) {
            System.out.println("SMS mis à jour avec succès !");
                } else {
                    System.out.println("La mise à jour du SMS a échoué.");
                }
            } else {
                System.out.println("Aucun SMS trouvé avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(SmsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
