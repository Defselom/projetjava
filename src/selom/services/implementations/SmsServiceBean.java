/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.services.implementations;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.Sms;
import selom.services.SmsServiceBeanLocal;
import selom.utils.ConnectDB;

/**
 *
 * @author m2pro
 */
public class SmsServiceBean implements SmsServiceBeanLocal {

    private final ConnectDB cn;

    public SmsServiceBean() {
        this.cn = new ConnectDB();
    }

    @Override
    public List<Sms> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Sms sms) {
        try {
            //
            cn.makeConnection();
            //
            String RequeteAjout = "INSERT INTO `sms`(`idClient`,`libelle`,`status`) "
                    + "VALUES (?,?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout);
            PreparedStmt.setInt(1, sms.getIdClient().getId());
            PreparedStmt.setString(2, sms.getLibelle());
            PreparedStmt.setString(3, sms.getStatus());
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
