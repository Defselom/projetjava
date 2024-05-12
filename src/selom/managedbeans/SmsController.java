/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.managedbeans;

import java.util.logging.Level;
import java.util.logging.Logger;
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
}
