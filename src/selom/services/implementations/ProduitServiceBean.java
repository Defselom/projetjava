/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.services.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public List<Produit> findAll() {
         List<Produit> produits = new ArrayList<>();
        try {
            //
            cn.makeConnection();
            //
            String RequeteGetAll = "SELECT * FROM `Produit`";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteGetAll);

            ResultSet rs = PreparedStmt.executeQuery();

            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId(rs.getInt("id"));
                produit.setLibelle(rs.getString("libelle"));
                produit.setActif(rs.getString("actif"));
                
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    public Produit findById(int produitId) {
        
         Produit produit = null;
        try {
            cn.makeConnection();

            String requeteGetById = "SELECT * FROM `Produit` WHERE id = ?";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(requeteGetById);
            PreparedStmt.setInt(1, produitId);
            ResultSet rs = PreparedStmt.executeQuery();

            while (rs.next()) {
                produit = new Produit();
                produit.setId(rs.getInt("id"));
                produit.setLibelle(rs.getString("libelle"));
                produit.setActif(rs.getString("actif"));
            }
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int update(Produit produit) {
          try {
            cn.makeConnection();
            String requeteUpdate = "UPDATE `Produit` SET libelle = ?, actif = ? WHERE id = ?";
            PreparedStatement preparedStmt = cn.makeConnection().prepareStatement(requeteUpdate);
            preparedStmt.setString(1, produit.getLibelle());
            preparedStmt.setString(2, produit.getActif());
            preparedStmt.setInt(3, produit.getId());
             int rowsUpdated = preparedStmt.executeUpdate();
             return rowsUpdated;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public void deleteById(int produitId) {
        try {
            cn.makeConnection();

            String requeteDelete = "DELETE FROM `Produit` WHERE id = ?";
            PreparedStatement preparedStmt = cn.makeConnection().prepareStatement(requeteDelete);
            preparedStmt.setInt(1, produitId);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
  
    
}
