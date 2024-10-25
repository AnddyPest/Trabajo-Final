package Persistencia;

import Entidades.Keywords;
import Utilities.FuncionDe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                //PROBAR
                if (!listedKeys.getKeyword().equals(nwKey.getKeyword())) {
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
                FuncionDe.mostrarMensajeError("No se pudo crear la keyWord", ex, "crearKeyword", "KeywordData", "22");
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
        FuncionDe.mostrarMensajeError(ex.getMessage(), ex, "listarKeywords", "KeywordData", "54");
    }
    return listadoKeys;
}
    
    //Listar keyWords
    
    public Keywords buscarKeyporId(int id){
        Keywords keyDevuelta = null;
        System.out.println(id+ " ID ENVIADO AL METODO DE BUSCAR EN LA BD");
        try{
            
        String query = "select * from keywords where idKeyword = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, id);
        
        ResultSet resultados = ps.executeQuery();
        
        while(resultados.next()){
           keyDevuelta = FuncionDe.crearKeyword(resultados); //Hecho el crear el metodo en funcionDe
        }
        if(keyDevuelta == null){
            throw new SQLException();
        }else{
            FuncionDe.mostrarMensajeCorrecto("buscarKeyporId", "Keyword encontrada");
        }
        resultados.close();
        ps.close();
    } catch (SQLException ex){
        FuncionDe.mostrarMensajeError("No se pudo encontrar la key", ex, "buscarKeyporId", "KeywordData", "84");
    }
        return keyDevuelta;
    }
    
    //Actualizar keyWords ¿Es necesario? Por las dudas lo hago
    //Si marquitos, se pudo haber cargado una key mal escrita y seria necesario poder rectificarla
    
    public void actualizarKeywordPorId (Keywords keySent){//Hecho "validarSiExiste" para la keywords
    
        try{
        FuncionDe.validarSiExisteId(this, keySent.getIdKeyword());
        
        String Query = "UPDATE keywords SET keyword = ? WHERE idKeyword = ?";
        PreparedStatement ps = conexion.prepareStatement(Query);
        ps.setString(1, keySent.getKeyword());
        ps.setInt(2, keySent.getIdKeyword());
        ps.executeUpdate();
        ps.close();
        
        FuncionDe.mostrarMensajeCorrecto("actualizarKeywordporId", "Keyword actualizada!");
        
    
    } catch (SQLException ex){
        FuncionDe.mostrarMensajeError("No se pudo actualizar el Keyword", ex, "actualizarKeywordporId", "KeywordData", "160");
    }
    }
    
    //Borrar Keyword 
    
    public boolean borrarKeyword(int idKeyword) {
             
        try {
            FuncionDe.validarSiExisteId(this, idKeyword);
            
            String Query = "DELETE FROM keywords WHERE idKeyword = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);

            ps.setInt(1, idKeyword);
            ps.executeUpdate();
            
            FuncionDe.mostrarMensajeCorrecto("borrarKeyword", "Keyword borrado con exito");
            ps.close();

        } catch (SQLException e) {
          FuncionDe.mostrarMensajeError("No se pudo borrar la Keyword", e, "borrarKeyword", "KeywordData", "138");
        }
        return true;
    }
}


