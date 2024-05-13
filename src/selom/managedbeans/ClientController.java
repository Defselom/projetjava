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
import selom.entities.ClientParticulier;
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

        try {
            List<Client> clients = new ArrayList<>();
            clients.add(new Client("John", "Cross", "+228997"));
            clients.add(new Client("Elon", "Musk", "+2289494745"));
            clients.add(new Client("Pirali", "Bibi", "+2287985143558"));
            clients.add(new Client("Cristal", "Kokou", "+3376528155"));
            for (Client client : clients) {
                clientService.save(client);
            }
            System.out.println("Client enregistré avec succès !");
        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void saveClient(Client client) {
        try {
            if (client instanceof ClientParticulier) {
                clientService.saveClientParticulier((ClientParticulier) client);
            } else {
                clientService.save(client);
            }
            System.out.println("Client enregistré avec succès !");
        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getAllClient() {
        try {
            List<Client> clients = clientService.findAll();
            System.out.println("Client recuperé avec succès !");
            for (Client client : clients) {
                System.out.println("ID : " + client.getId());
                System.out.println("Nom : " + client.getNom());
                System.out.println("Prénom : " + client.getPrenom());
                System.out.println("Téléphone : " + client.getTelephone());
                System.out.println();
            }
        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getById(int clientId) {
        try {
            Client client = clientService.findById(clientId);
            if (client != null) {
                // Afficher les informations du client
                System.out.println("Client récupéré avec succès !");
                System.out.println("ID : " + client.getId());
                System.out.println("Nom : " + client.getNom());
                System.out.println("Prénom : " + client.getPrenom());
                System.out.println("Téléphone : " + client.getTelephone());
            } else {
                System.out.println("Aucun client trouvé avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void update(Client updateclient) {
        try {
            Client client = clientService.findById(updateclient.getId());
            if (client != null) {
                int rowsUpdated = clientService.update(client);
                if (rowsUpdated > 0) {
                    System.out.println("Client mis à jour avec succès !");
                } else {
                    System.out.println("La mise à jour du client a échoué.");
                }
            } else {
                System.out.println("Aucun client trouvé avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteById(int clientId) {
        try {
            Client client = clientService.findById(clientId);
            if (client != null) {
                clientService.deleteById(clientId);
                System.out.println("Client supprimé avec succès !");
            } else {
                System.out.println("Aucun client trouvé avec cet ID.");
            }

        } catch (Exception e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
