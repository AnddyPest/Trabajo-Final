
package Persistencia;

import Entidades.Alimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import Utilities.FuncionDe;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alimento_KeywordData {
    
    private final Connection conexion;
    
    public Alimento_KeywordData( Connection conexion ){
        this.conexion = conexion;
    }
    
    public Alimento obtenerAlimentoPorKeywordId(int id){
        Alimento alimentoDevuelto = null ;
        try {
            String Query = " SELECT alimento.idAlimento,alimento.nombre,alimento.tipoComida,alimento.caloriasPor100g,alimento.detalle,alimento.estado "
                    + "FROM alimento , keywords , alimento_keyword "
                    + "WHERE keywords.idKeyword = ? "
                    + "AND  keywords.idKeyword = alimento_keyword.idKeyword "
                    + "AND alimento_keyword.idAlimento = alimento.idAlimento";
            
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, id);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                alimentoDevuelto = FuncionDe.crearAlimento(resultados);
            }
            FuncionDe.mostrarMensajeCorrecto("obtenerAlimentoPorKeywordId", "Alimento solicitado por keywordID enviado correctamente");
        } catch (SQLException ex) {
           FuncionDe.mostrarMensajeError("No se pudo enviar el alimento por keywordID", ex, "obtenerAlimentoPorKeywordId", "Alimento_KeywordData", "19");
        }
        return alimentoDevuelto;
    }
    public Alimento obtenerAlimentoPorKeywordName(String keywordName){
        Alimento alimentoDevuelto = null ;
        try {
            String Query = " SELECT alimento.idAlimento,alimento.nombre,alimento.tipoComida,alimento.caloriasPor100g,alimento.detalle,alimento.estado "
                    + "FROM alimento , keywords , alimento_keyword "
                    + "WHERE keywords.keyword = ? "
                    + "AND  keywords.idKeyword = alimento_keyword.idKeyword "
                    + "AND alimento_keyword.idAlimento = alimento.idAlimento";
            
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setString(1, keywordName);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                alimentoDevuelto = FuncionDe.crearAlimento(resultados);
            }
            FuncionDe.mostrarMensajeCorrecto("obtenerAlimentoPorKeywordName", "Alimento solicitado por keywordName enviado correctamente");
        } catch (SQLException ex) {
           FuncionDe.mostrarMensajeError("No se pudo enviar el alimento por keywordName", ex, "obtenerAlimentoPorKeywordName", "Alimento_KeywordData", "41");
        }
        return alimentoDevuelto;
    }
    
    public ArrayList<Alimento> obtenerAlimentosPorKeywordsYaEspecificadas(ArrayList<String> elementosQueSi , ArrayList<String> elementosQueNo){
        ArrayList<Alimento> alimentosDevueltos = new ArrayList<Alimento>();
        Alimento alimento = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(FuncionDe.construirSQLParaBuscarAlimentos(elementosQueSi, elementosQueNo));            
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                alimento = FuncionDe.crearAlimento(resultados);
                alimentosDevueltos.add(alimento);
            }
            FuncionDe.mostrarMensajeCorrecto("obtenerAlimentosPorKeywordsYaEspecificadas", "Alimentos por keywords enviados correctamente");
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo obtener los alimentos keywords", ex, "obtenerAlimentosPorKeywordsYaEspecificadas", "Alimento_KeywordData", "66");
        }
        return alimentosDevueltos;
    }
    
}
