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
import selom.entities.Client;
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
    public List<Sms> findAll() {
        List<Sms> allSms = new ArrayList<>();
        try {
            //
            cn.makeConnection();
            //
            String RequeteGetAll = "SELECT * FROM `Sms`";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteGetAll);

            ResultSet rs = PreparedStmt.executeQuery();

            while (rs.next()) {
                Sms sms = new Sms();
                Client client = new Client();
                client.setId(rs.getInt("idClient"));
                sms.setId(rs.getInt("id"));
                sms.setLibelle(rs.getString("libelle"));
                sms.setIdClient(client);
                sms.setStatus(rs.getString("status"));

                allSms.add(sms);
            }
            return allSms;
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void save(Sms sms) {
        try {
            //
            cn.makeConnection();
            //
            String RequeteAjout = "INSERT INTO `sms`(`idClient`,`libelle`,`status`) "
                    + "VALUES (?,?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout, Statement.RETURN_GENERATED_KEYS);
            PreparedStmt.setInt(1, sms.getIdClient().getId());
            PreparedStmt.setString(2, sms.getLibelle());
            PreparedStmt.setString(3, sms.getStatus());
            PreparedStmt.executeUpdate();

            ResultSet res = PreparedStmt.getGeneratedKeys();
            while (res.next()) {
                int smsId = res.getInt(1);
                sms.setId(smsId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Sms findById(int smsId) {
         Sms sms = null;
        try {
            cn.makeConnection();

            String requeteGetById = "SELECT * FROM `Sms` WHERE id = ?";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(requeteGetById);
            PreparedStmt.setInt(1, smsId);
            ResultSet rs = PreparedStmt.executeQuery();

            while (rs.next()) {
                sms = new Sms();
                sms.setId(rs.getInt("id"));
                 Client client = new Client();
                client.setId(rs.getInt("idClient"));
                sms.setIdClient(client);
                sms.setLibelle(rs.getString("libelle"));
                sms.setStatus(rs.getString("status"));
            }
            return sms;
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int update(Sms sms) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int smsId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
