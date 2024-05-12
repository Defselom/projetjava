/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.services.implementations;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.Souscription;
import selom.services.SouscriptionServiceBeanLocal;
import selom.utils.ConnectDB;

/**
 *
 * @author m2pro
 */
public class SousciptionServiceBean implements SouscriptionServiceBeanLocal {

    private final ConnectDB cn;

    public SousciptionServiceBean() {
        this.cn = new ConnectDB();
    }

    @Override
    public List<Souscription> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Souscription souscription) {
        try {
            // traitement de la date 
            java.sql.Date myDateData = new java.sql.Date(souscription.getDateHeureSous().getTime());
          
            
            cn.makeConnection();
            //
            String RequeteAjout = "INSERT INTO `souscription`(`dateHeureSous`,`actif`,`idClient`,`idProduit`) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout);
            PreparedStmt.setDate(1, myDateData);
            PreparedStmt.setString(2, souscription.getActif());
            PreparedStmt.setInt(3, souscription.getIdClient().getId());
            PreparedStmt.setInt(4, souscription.getIdProduit().getId());
            PreparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceBean.class.getName()).log(Level.SEVERE, null, ex);
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
