/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package selom.services;

import java.util.List;
import selom.entities.Client;

/**
 *
 * @author m2pro
 */
public interface ClientServiceBeanLocal {
    
    void save(final Client client);
     
    List<Client> findAll();
    
    Client findById(int clientId);
    
    void deleteById(int clientId);
}
