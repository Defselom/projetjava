/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.services.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.Produit;
import selom.services.ProduitServiceBeanLocal;
import selom.utils.ConnectDB;

/**
 *
 * @author m2pro
 */
public class ProduitServiceBean implements ProduitServiceBeanLocal {

      private final ConnectDB cn;

    public ProduitServiceBean() {
        this.cn = new ConnectDB();
    }
    
    
    @Override
    public List<Produit> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Produit produit) {
        
         try {
            //
            cn.makeConnection();
            //
            String RequeteAjout = "INSERT INTO `produit`(`libelle`,`actif`) "
                    + "VALUES (?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout,Statement.RETURN_GENERATED_KEYS);
            PreparedStmt.setString(1, produit.getLibelle());
            PreparedStmt.setString(2, produit.getActif());
            PreparedStmt.executeUpdate();
             ResultSet res = PreparedStmt.getGeneratedKeys();
            while (res.next()) {
                int produitId = res.getInt(1);
                produit.setId(produitId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}
