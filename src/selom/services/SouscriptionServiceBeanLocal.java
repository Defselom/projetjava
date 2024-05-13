/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package selom.services;

import java.util.List;
import selom.entities.Souscription;

/**
 *
 * @author m2pro
 */
public interface SouscriptionServiceBeanLocal {
    
    public List<Souscription> findAll();

    public void save(Souscription souscription);

    Souscription findById(int souscriptionId);

    int update(final Souscription souscription);

    void deleteById(int souscriptionId);
}
