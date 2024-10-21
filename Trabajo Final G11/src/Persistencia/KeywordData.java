package Persistencia;

import Entidades.Keywords;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeywordData {

     private final Connection conexion;

    public KeywordData(Connection conexion) {
        this.conexion = conexion;
    }

    public void crearKeyword(Keywords nwKey) {
        List<Keywords> keys = this.listarKeywords();
        boolean validado = false;
        if (keys.isEmpty()) {
            validado = true;
        } else {
            for (Keywords listedKeys : keys) {

                if (listedKeys.getKeyword() != nwKey.getKeyword()) {
                    validado = true;

                } else {
                    validado = false;
                    System.out.println("No pueden haber dos keywords identicas");
                    break;
                }
            }
        }

        if (validado) {
            try {
                String query = "INSERT INTO keywords (keyword) VALUES (?)";
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, nwKey.getKeyword().trim());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(KeywordData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Keywords> listarKeywords() {
    ArrayList<Keywords> listadoKeys = new ArrayList<>();
    try {
        String query = "SELECT * FROM keywords";
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("idKeyword") + ", Keyword: " + rs.getString("keyword"));
            Keywords key = new Keywords(rs.getString("keyword")); 
            key.setIdKeyword(rs.getInt("idKeyword")); 
            listadoKeys.add(key);
        }
       
        rs.close();
        ps.close();

        if (listadoKeys.isEmpty()) {
            throw new SQLException("No se encontraron palabras clave.");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(KeywordData.class.getName()).log(Level.SEVERE, null, ex);
    }
    return listadoKeys;
}

}


