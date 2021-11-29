package tec.bd.blockbuster;

import javax.swing.*;
import java.sql.*;


public class Conexion {
    /*
    public static final String URL = "jdbc:mysql://localhost:3306/blockbuster";
    public static final String USERNAME = "blockbusterappuser";
    public static final String PASSWORD = "blockbusterapppass";
    */
    public Connection getConexion() {
        Connection con=null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockbuster","blockbusterappuser","blockbusterapppass");
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");

        } catch ( SQLException e) {
            JOptionPane.showMessageDialog(null, "Sin Conexion: " + e);
        }
        return con;
    }

}