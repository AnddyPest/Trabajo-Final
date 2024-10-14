package Entidades;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Connection {
    private static Connection conexion = null;
    
    private Connection(){
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver");
        }
    }
    
    public static java.sql.Connection getConexion(){
        java.sql.Connection con = null;
        if(conexion == null){
            
            conexion = new Connection();
        }
        
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost/nutricionista", "root", "");
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return con;
    }

}
