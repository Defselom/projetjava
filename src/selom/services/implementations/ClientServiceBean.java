/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.services.implementations;

import com.sun.jdi.connect.spi.Connection;
import selom.entities.Client;
import selom.services.ClientServiceBeanLocal;
import java.util.List;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.utils.ConnectDB;

/**
 *
 * @author m2pro
 */
public class ClientServiceBean implements ClientServiceBeanLocal {

    private final ConnectDB cn;

    public ClientServiceBean() {
        this.cn = new ConnectDB();
    }

    public void save(Client client) {
        try {
            //
            cn.makeConnection();
            //
            String RequeteAjout = "INSERT INTO `client`(`nom`,`prenom`,`telephone`) "
                    + "VALUES (?,?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout,Statement.RETURN_GENERATED_KEYS);
            PreparedStmt.setString(1, client.getNom());
            PreparedStmt.setString(2, client.getPrenom());
            PreparedStmt.setString(3, client.getTelephone());
            PreparedStmt.executeUpdate();

            ResultSet res = PreparedStmt.getGeneratedKeys();
            while (res.next()) {
                int userId = res.getInt(1);
                client.setId(userId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Client findById(int k
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int k
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
