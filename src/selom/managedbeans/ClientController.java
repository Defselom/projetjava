/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.Client;
import selom.services.implementations.ClientServiceBean;

/**
 *
 * @author m2pro
 */
public class ClientController {

    private ClientServiceBean clientService;

    public ClientController(ClientServiceBean monClientService) {
        this.clientService = monClientService;
    }

    public ClientController() {
        this.clientService = new ClientServiceBean();
    }

    public void addInitCLient() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("John", "Cross", "+228997"));
        clients.add(new Client("Elon", "Musk", "+2289494745"));
        clients.add(new Client("Pirali", "Bibi", "+2287985143558"));
        clients.add(new Client("Cristal", "Kokou", "+3376528155"));
        for (Client client : clients) {
            clientService.save(client);
        }
    }

    public void saveClient(Client client) {
        try {
            clientService.save(client);
            System.out.println("Client saved successfully!");
        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
