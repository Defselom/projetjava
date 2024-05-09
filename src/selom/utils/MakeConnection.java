/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import selom.MainClass;

/**
 *
 * @author m2pro
 */
public class MakeConnection {

    static Connection conn = null;

    public MakeConnection() {
    }

    public final Connection makeConnection() throws SQLException {
        if (conn == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {                
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/bd_tppoo_sadzomla", "root", "");
        }
        return conn;
    }
}
