/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.services.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.entities.Client;
import selom.entities.Produit;
import selom.entities.Souscription;
import selom.services.SouscriptionServiceBeanLocal;
import selom.utils.ConnectDB;

/**
 *
 * @author m2pro
 */
public class SouscriptionServiceBean implements SouscriptionServiceBeanLocal {

    private final ConnectDB cn;

    public SouscriptionServiceBean() {
        this.cn = new ConnectDB();
    }

    @Override
    public List<Souscription> findAll() {
        List<Souscription> souscriptions = new ArrayList<>();
        try {
            //
            cn.makeConnection();
            //
            String RequeteGetAll = "SELECT * FROM `Souscription`";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteGetAll);

            ResultSet rs = PreparedStmt.executeQuery();

            while (rs.next()) {
                Souscription souscription = new Souscription();
                souscription.setId(rs.getInt("id"));
                souscription.setActif(rs.getString("actif"));
                souscription.setDateHeureSous(rs.getDate("dateHeureSous"));
                Client client = new Client();
                client.setId(rs.getInt("idClient"));
                Produit produit = new Produit();
                souscription.setIdClient(client);
                souscription.setIdProduit(produit);

                souscriptions.add(souscription);
            }
            return souscriptions;
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public void save(Souscription souscription) {
        try {
            // traitement de la date 
            java.util.Date instantDate = new java.util.Date();
            java.sql.Date nowDate = new java.sql.Date(instantDate.getTime());

            cn.makeConnection();
            //
            String RequeteAjout = "INSERT INTO `souscription`(`dateHeureSous`,`actif`,`idClient`,`idProduit`) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout, Statement.RETURN_GENERATED_KEYS);
            PreparedStmt.setDate(1, nowDate);
            PreparedStmt.setString(2, souscription.getActif());
            PreparedStmt.setInt(3, souscription.getIdClient().getId());
            PreparedStmt.setInt(4, souscription.getIdProduit().getId());
            PreparedStmt.executeUpdate();

            ResultSet res = PreparedStmt.getGeneratedKeys();
            while (res.next()) {
                int souscriptionId = res.getInt(1);
                souscription.setId(souscriptionId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Souscription findById(int souscriptionId) {
        Souscription souscription = null;
        try {
            cn.makeConnection();

            String requeteGetById = "SELECT * FROM `Souscription` WHERE id = ?";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(requeteGetById);
            PreparedStmt.setInt(1, souscriptionId);
            ResultSet rs = PreparedStmt.executeQuery();

            while (rs.next()) {
                souscription = new Souscription();
                souscription.setId(rs.getInt("id"));
                souscription.setDateHeureSous(rs.getDate("dateHeureSous"));
                souscription.setActif(rs.getString("actif"));
                Client client = new Client(rs.getInt("idClient"));
                Produit produit = new Produit(rs.getInt("idProduit"));
                souscription.setIdProduit(produit);

            }
            return souscription;
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int update(Souscription souscription) {
        try {
            cn.makeConnection();
            String requeteUpdate = "UPDATE `Souscription` SET idClient = ?, idProduit = ?, actif = ? WHERE id = ?";
            PreparedStatement preparedStmt = cn.makeConnection().prepareStatement(requeteUpdate);
            preparedStmt.setInt(1, souscription.getIdClient().getId());
            preparedStmt.setInt(2, souscription.getIdProduit().getId());
            preparedStmt.setString(3, souscription.getActif());
            preparedStmt.setInt(4, souscription.getId());

            int rowsUpdated = preparedStmt.executeUpdate();
            return rowsUpdated;
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public void deleteById(int souscriptionId) {
        try {
            cn.makeConnection();

            String requeteDelete = "DELETE FROM `Souscription` WHERE id = ?";
            PreparedStatement preparedStmt = cn.makeConnection().prepareStatement(requeteDelete);
            preparedStmt.setInt(1, souscriptionId);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
