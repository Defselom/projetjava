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
import java.util.ArrayList;
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

    @Override
    public void save(Client client) {
        try {
            //
            cn.makeConnection();
            //
            String RequeteAjout = "INSERT INTO `client`(`nom`,`prenom`,`telephone`) "
                    + "VALUES (?,?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout, Statement.RETURN_GENERATED_KEYS);
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
        List<Client> clients = new ArrayList<>();
        try {
            //
            cn.makeConnection();
            //
            String RequeteGetAll = "SELECT * FROM `Client`";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteGetAll);

            ResultSet rs = PreparedStmt.executeQuery();

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setTelephone(rs.getString("telephone"));

                clients.add(client);
            }
            return clients;
        } catch (SQLException ex) {
            Logger.getLogger(ClientServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Client findById(int clientId
    ) {
        Client client = null;
        try {
            cn.makeConnection();

            String requeteGetById = "SELECT * FROM `Client` WHERE id = ?";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(requeteGetById);
            PreparedStmt.setInt(1, clientId);
            ResultSet rs = PreparedStmt.executeQuery();

            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setTelephone(rs.getString("telephone"));
            }
            return client;
        } catch (SQLException ex) {
            Logger.getLogger(ClientServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deleteById(int clientId
    ) {
        try {
            cn.makeConnection();

            String requeteDelete = "DELETE FROM `Client` WHERE id = ?";
            PreparedStatement preparedStmt = cn.makeConnection().prepareStatement(requeteDelete);
            preparedStmt.setInt(1, clientId);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
