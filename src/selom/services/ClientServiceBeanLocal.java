/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package selom.services;

import java.util.List;
import selom.entities.Client;
import selom.entities.ClientParticulier;

/**
 *
 * @author m2pro
 */
public interface ClientServiceBeanLocal {
    
    void save(final Client client);
    
    void saveClientParticulier(final ClientParticulier client);
     
    List<Client> findAll();
    
    Client findById(int clientId);
    
    int update(final Client Client);
    
    void deleteById(int clientId);
}
