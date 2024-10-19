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

    Connection conexion;

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
            Keywords key;
            String query = "SELECT * FROM keywords";

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                key = new Keywords();
                key.setIdKeyword(rs.getInt("idKeyword"));
                key.setKeyword("keyword");
                listadoKeys.add(key);
            }
            ps.close();
            if(listadoKeys== null){
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(KeywordData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoKeys;
    }

}

//Hay que hacer las funciones 

// Listar alimentos con keywords: SELECT alimentos a JOINT alimento_keyword ON idAlimento, JOINT keywords ON idKeyword
// Seleccionar alimentos por keywords: SELECT alimentos a JOINT alimento_keyword ON idAlimento, JOINT keywords ON idKeyword WHERE keyword =  ?
// Agregar keywords a un alimento: INSERT INTO alimento_keyword (idAlimento, idKeyword) WHERE idAlimento = ?, idKeyword = ?

