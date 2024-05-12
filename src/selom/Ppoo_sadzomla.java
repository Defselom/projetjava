/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom;

import java.util.logging.Logger;
import selom.entities.Client;
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
        
        
       // Assuming you have instantiated ClientServiceBean somewhere in your application context
ClientServiceBean clientService = new ClientServiceBean();

// Create a new client object
Client client = new Client();
client.setNom("bezos ");
client.setPrenom("jeff");
client.setTelephone("90959090");
// Set other properties of the client as needed

try {
    // Call the save method to save the client
    clientService.save2(client);
    System.out.println("Client saved successfully!");
} catch (Exception e) {
    // Handle any exceptions that may occur during the saving process
    System.err.println("Error saving client: " + e.getMessage());
}

    } 
}
