/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom;

import java.util.logging.Logger;
import selom.entities.Client;
import selom.entities.Produit;
import selom.entities.Sms;
import selom.entities.Souscription;
import selom.managedbeans.ClientController;
import selom.managedbeans.ProduitController;
import selom.managedbeans.SmsController;
import selom.managedbeans.SouscriptionController;
import selom.services.implementations.ClientServiceBean;
import selom.services.implementations.ProduitServiceBean;
import selom.services.implementations.SmsServiceBean;
import selom.services.implementations.SouscriptionServiceBean;

/**
 *
 * @author m2pro
 */
public class Ppoo_sadzomla {

    public static void main(String[] args) {
        // initialisation de tous les services et controlleur
        // service
        ClientServiceBean monClientService = new ClientServiceBean();
        ProduitServiceBean monProduitService = new ProduitServiceBean();
        SmsServiceBean monSmsService = new SmsServiceBean();
        SouscriptionServiceBean maSouscriptionService = new SouscriptionServiceBean();

        // controller
        ClientController clientController = new ClientController(monClientService);
        ProduitController produitController = new ProduitController(monProduitService);
        SmsController smsController = new SmsController(monSmsService);
        SouscriptionController souscriptionController = new SouscriptionController(maSouscriptionService);

        // Create a Logger with class name GFG 
        Logger logger
                = Logger.getLogger(Ppoo_sadzomla.class.getName());

        // Call info method 
        logger.info("Message 1");
        logger.info("Message 2");

        // create client
        Client def = new Client();
        def.setNom("defselom");
        def.setPrenom("elolo");
        def.setTelephone("99780518");

        // create produit
        Produit cafe = new Produit();
        cafe.setLibelle("Coca cola");
        cafe.setActif("T");

        // create sms
        Sms mySms = new Sms();
        mySms.setIdClient(def);
        mySms.setLibelle("Merci pour votre achat");
        mySms.setStatus("en Attente");

        // create souscription
        Souscription mySouscription = new Souscription();
        mySouscription.setIdClient(def);
        mySouscription.setIdProduit(cafe);
        mySouscription.setActif("T");

       
       
// Set other properties of the client as needed
        try {
            // Call the save method to save the client
            clientController.saveClient(def);
          //  produitController.saveProduit(cafe);
          //  souscriptionController.save(mySouscription);
          //  smsController.save(mySms);
          //  clientController.getAllClient();
          //  clientController.getById(2);
             //clientController.deleteById(2);
             def.setId(2098);
clientController.update(def);
        } catch (Exception e) {
            // Handle any exceptions that may occur during the saving process
            System.err.println("Error saving : " + e.getMessage());
        }

    }
}
