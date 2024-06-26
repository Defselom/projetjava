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

/**
 *
 * @author m2pro
 */
public class ConnectDB {

    static Connection conn = null;

    public ConnectDB() {
    }

    public final Connection makeConnection() throws SQLException {
        if (conn == null) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                String bd_url = "jdbc:mysql://localhost:3306/bd_tppoo_sadzomla";
                String user = "root";
                String pwd = "";
                conn = DriverManager.getConnection(bd_url, user, pwd);
            } catch (SQLException e) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);

            }

        }
        return conn;
    }
}
