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
    
    public List<Souscription> getAll();
    
    public void save(Souscription souscription);
    
    public void modifier();
    
    public void supprimer();
}
