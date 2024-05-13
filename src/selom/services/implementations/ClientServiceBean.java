/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.services.implementations;

import selom.entities.Client;
import selom.services.ClientServiceBeanLocal;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.ClientParticulier;
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

            // checker le type de client            
            if (client.getNom() == null || client.getPrenom() == null
                    || client.getTelephone() == null) {
                throw new IllegalArgumentException("Tous les champs sont obligatoires!");
            }

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
    public void saveClientParticulier(ClientParticulier client) {
        try {
            //
            cn.makeConnection();

            if (client.getNom() == null || client.getPrenom() == null || client.getDateNaissance() == null || client.getTelephone() == null || client.getLieuNaissance() == null) {
                throw new IllegalArgumentException("Tous les champs sont obligatoires!");
            }
            // Convertir java.util.Date en java.sql.Date
            java.sql.Date date = new java.sql.Date(client.getDateNaissance().getTime());
            String RequeteAjout = "INSERT INTO `client`(`nom`,`prenom`,`telephone`,`dateNaissance`,`lieuNaissance`) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout, Statement.RETURN_GENERATED_KEYS);
            PreparedStmt.setString(1, client.getNom());
            PreparedStmt.setString(2, client.getPrenom());
            PreparedStmt.setString(3, client.getTelephone());
            PreparedStmt.setDate(4, date);
            PreparedStmt.setString(5, client.getLieuNaissance());
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
    public int update(Client client
    ) {
        try {
            cn.makeConnection();
            String requeteUpdate = "UPDATE `Client` SET nom = ?, prenom = ?, telephone = ? WHERE id = ?";
            PreparedStatement preparedStmt = cn.makeConnection().prepareStatement(requeteUpdate);
            preparedStmt.setString(1, client.getNom());
            preparedStmt.setString(2, client.getPrenom());
            preparedStmt.setString(3, client.getTelephone());
            preparedStmt.setInt(4, client.getId());
            int rowsUpdated = preparedStmt.executeUpdate();
            return rowsUpdated;
        } catch (SQLException ex) {
            Logger.getLogger(ClientServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

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
