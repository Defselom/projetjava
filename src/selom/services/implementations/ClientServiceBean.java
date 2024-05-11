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
public class ClientServiceBean implements ClientServiceBeanLocal  {
    
    
    private final ConnectDB cn;

    public ClientServiceBean() {
        this.cn = new ConnectDB();
    }
    
       @Override
    public void save(Client client) {
        PreparedStatement ps=null;
         Connection connexion= ConnectBD.seConnecter();
        if(!VerifierDoublonClient(client.getNom())){
            String InsertSql="insert into Client(idClient,nom,prenom,telephone) values(?,?,?,?)";
           
            try {
                ps=connexion.prepareStatement(InsertSql);
                ps.setInt(1,client.getIdClient());
                ps.setString(2,client.getNom());
                ps.setString(3,client.getPrenom());
                ps.setString(4,client.getTelephone());
                ps.executeUpdate();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
            
        }else{
            String req="update client set nom=? , prenom=? , telephone=? where idClient=(select idClient from client where nom=?)";
                Scanner sc= new Scanner(System.in);
            try {
                ps=connexion.prepareStatement(req);
                 System.out.println(" un nouveau nom sous peu pour modifier le client!");
                ps.setString(1, sc.nextLine());
                System.out.println("un nouveau preom");
                ps.setString(2, sc.nextLine());
                System.out.println("un nouveau telephone");
                ps.setString(3, sc.nextLine());
                ps.setString(4, client.getNom());
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
             
        }
        if(connexion!=null){
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
           
        
    }


     public void save2(Client client) {
        try {
            //
            cn.makeConnection();
            //
            String RequeteAjout = "INSERT INTO `client`(`nom`,`prenom`,`telephone`) "
                    + "VALUES (?,?,?)";
            PreparedStatement PreparedStmt = cn.makeConnection().prepareStatement(RequeteAjout);
            PreparedStmt.setString(1, client.getNom());
            PreparedStmt.setString(2, client.getPrenom());
            PreparedStmt.setString(3, client.getTelephone());
            PreparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Client findById(int k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
