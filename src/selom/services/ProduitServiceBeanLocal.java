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
      public List<Produit> findAll();
    
    public void save(Produit produit);
    
    Produit findById(int produitId);
    
    int update(final Produit Client);
    
    void deleteById(int produitId);

}
