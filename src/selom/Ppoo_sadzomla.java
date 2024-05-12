/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom;

import java.util.logging.Logger;
import selom.entities.Client;
import selom.managedbeans.ClientController;
import selom.services.implementations.ClientServiceBean;

/**
 *
 * @author m2pro
 */
public class Ppoo_sadzomla {
     public static void main(String[] args) 
    { 
  
        // Create a Logger with class name GFG 
        Logger logger 
            = Logger.getLogger(Ppoo_sadzomla.class.getName()); 
  
        // Call info method 
        logger.info("Message 1"); 
        logger.info("Message 2"); 
        
        Client def = new Client();
        def.setNom("defselom");
        def.setPrenom("elolo");
        def.setTelephone("99780518");
        
        
ClientServiceBean monService = new ClientServiceBean();
        ClientController clientController = new ClientController(monService);
// Set other properties of the client as needed

try {
    // Call the save method to save the client
clientController.addInitCLient();

clientController.addInitCLient();
clientController.saveClient(def);

    System.out.println("Client saved successfully!");
} catch (Exception e) {
    // Handle any exceptions that may occur during the saving process
    System.err.println("Error saving client: " + e.getMessage());
}

    } 
}
