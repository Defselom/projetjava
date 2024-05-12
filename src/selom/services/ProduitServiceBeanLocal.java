/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package selom.services;

import java.util.List;
import selom.entities.Produit;

/**
 *
 * @author m2pro
 */
public interface ProduitServiceBeanLocal {
      public List<Produit> getAll();
    
    public void save(Produit produit);
    
    public void modifier();
    
    public void supprimer();
}
