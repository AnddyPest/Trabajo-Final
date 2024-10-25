package Persistencia;

import Entidades.Dieta;
import Utilities.FuncionDe;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DietaData {
    private final Connection conexion;
    public DietaData(Connection conexion){
        this.conexion = conexion;
    }    
    public int crearDieta(Dieta dietaEnviada)  {
        boolean validado = false;   
        int codigoDevuelto = 1;
       
        List<Dieta> dietas = this.listarDietas();
        
        if(dietas.isEmpty()){           
            validado = true;
        } else{
            for(Dieta dietaRevisada: dietas){
                
                if(!dietaRevisada.getNombre().equals(dietaEnviada.getNombre()) ){                                       
                    validado = true;
                    
                }else{
                    validado = false;
                    System.out.println("Validacion Metodo: CrearDieta || Mensaje: Dietas con nombres identicos no son admitidas\n");                    
                    break;
                }
            }
        }
        if(validado){
           
        
            try {
                String query = "Insert into dieta( nombre, fechaInicio, fechaFinal, pesoInicial, pesoFinal,totalCalorias ,estado ) values( ? , ? , ? , ? , ?,? , ? )";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, dietaEnviada.getNombre());
                ps.setDate(2, Date.valueOf(dietaEnviada.getFechaInicio()));
                ps.setDate(3, Date.valueOf(dietaEnviada.getFechaFinal()));
                ps.setDouble(4, dietaEnviada.getPesoInicial());
                ps.setDouble(5, dietaEnviada.getPesoFinal());
                ps.setInt(6, dietaEnviada.getTotalCalorias());
                ps.setBoolean(7, true);
                ps.executeUpdate();

                FuncionDe.mostrarMensajeCorrecto("Crear Dieta", "La dieta ha sido añadida");
                ps.close();
            }   catch (SQLException ex) {
                FuncionDe.mostrarMensajeError(ex, "Crear Dieta", "DietaData", "20");
                codigoDevuelto = ex.getErrorCode();
            }
        
        }
        return codigoDevuelto;
       
    }
    
    public ArrayList<Dieta> listarDietas(){
        ArrayList<Dieta> dietasDevueltas = new ArrayList<>();
        try {            
            
            String Query= "SELECT * FROM dieta";            
            PreparedStatement ps = conexion.prepareStatement(Query);
            
            ResultSet resultados = ps.executeQuery();
            
            while(resultados.next()){
                Dieta dietaCreada = FuncionDe.crearDieta(resultados);
                
                dietasDevueltas.add(dietaCreada);
            }
            FuncionDe.mostrarMensajeCorrecto("Listar Dietas", "Todas las dietas han sido enviadas correctamente");
            
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se puede listar las dietas",ex, "Listar Dietas", "DietasData", "71");
        }
        
        return dietasDevueltas;
    }
    

    
    public Dieta buscarDietaPorID(int id){
        Dieta dietaDevuelta = null;
        try {
            String query = "SELECT * FROM dieta WHERE idDieta = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt( 1, id );
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                dietaDevuelta = FuncionDe.crearDieta(resultados);                
            }
            if(dietaDevuelta == null){
                throw new SQLException();
            }else{
                FuncionDe.mostrarMensajeCorrecto("buscarDietaPorId", "Dieta encontrada correctamente");
            }
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo encontrar el registro",ex, "buscarDietaPorId", "DietaData", "98");
        }
        
        return dietaDevuelta;
    }
    
    public ArrayList<Dieta> buscarDietasPorNombre(String nombreEnviado){
        ArrayList<Dieta> dietasEncontradas = new ArrayList<>();
        try {            
            String query = "SELECT * FROM dieta WHERE dieta.nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombreEnviado.trim().toLowerCase());
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                Dieta dieta = FuncionDe.crearDieta(resultados);
                dietasEncontradas.add(dieta);
            }
            if(!dietasEncontradas.isEmpty()){
                FuncionDe.mostrarMensajeCorrecto("buscarDietasPorNombre", "Dietas con nombre: " + nombreEnviado + " enviadas correctamente");
            } else{
                throw new SQLException();
            }
            resultados.close();
            ps.close();
            
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se encontraron dietas con dicho nombre",ex, "buscarDietasPorNombre", "DietaData", "122");
        }
        
        return dietasEncontradas;
        
    }
    //UPDATE
    
    
    public void actualizarDietaPorId(Dieta dietaEnviada){
        
        try {
            //REVISAR SI FUNCIONA
            FuncionDe.validarSiExisteId(this, dietaEnviada.getIdDieta());
            
            String Query = "UPDATE dieta SET dieta.nombre = ?,dieta.idPaciente = ?, dieta.fechaInicio = ?, dieta.fechaFinal = ? , dieta.pesoInicial = ? ,dieta.pesoFinal = ? , dieta.totalCalorias = ? , dieta.estado = ? WHERE dieta.idDieta = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setString(1, dietaEnviada.getNombre());
            ps.setInt(2, dietaEnviada.getIdPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dietaEnviada.getFechaInicio()));
            ps.setDate(4, Date.valueOf(dietaEnviada.getFechaFinal()));
            ps.setDouble(5, dietaEnviada.getPesoInicial());
            ps.setDouble(6, dietaEnviada.getPesoFinal());
            ps.setInt(7, dietaEnviada.getTotalCalorias());
            ps.setBoolean(8, dietaEnviada.isEstadoDieta());
            ps.setInt(9, dietaEnviada.getIdDieta());
            ps.executeUpdate();
            ps.close();

            FuncionDe.mostrarMensajeCorrecto("actualizarDietaPorId", "Dieta actualizada con exito");
                    
                        
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo actualizar la dieta",ex, "actualizarDietaPorId", "DietaData", "151");
        }
    }
    
        
    //DELETE    
    //buscar por estado individual AUXILIAR DE ALTA Y BAJA LOGICA
    public boolean buscarEstadoPorId(int id){
        Dieta resultadoEstado = null;
        try {
            FuncionDe.validarSiExisteId(this, id);
            String query = "SELECT dieta.estado FROM dieta WHERE dieta.idDieta = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                resultadoEstado = new Dieta();
                resultadoEstado.setEstadoDieta(resultados.getBoolean("estado"));
            }
            FuncionDe.mostrarMensajeCorrecto("BuscarEstadoPorId", "Estado Logico de la dieta enviada correctamente");
        } catch (SQLException ex) {
           FuncionDe.mostrarMensajeError("No se pudo enviar el estado logico de la dieta", ex, "BuscarEstadoPorID", "DietaData", "181");
        }
        return resultadoEstado.isEstadoDieta();
    }
    //Alta logica
    public void altaLogicaDieta(int id){
        
        try {
            FuncionDe.validarSiExisteId(this, id);
            FuncionDe.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, true);
            String Query = "UPDATE dieta SET dieta.estado = ? WHERE dieta.idDieta = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("AltaLogicaDieta", "Dieta dada de Alta correctamente");
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo dar el alta logica", ex, "AltaLogicaDieta", "DietaData", "200");
        }
    }
   
    //baja logica 
    public void bajaLogicaDieta(int id){
        
        try {
            FuncionDe.validarSiExisteId(this, id);
            FuncionDe.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, false);
            String Query = "UPDATE dieta SET dieta.estado = ? WHERE dieta.idDieta = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("BajaLogicaDieta", "Dieta dada de Baja correctamente");
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo dar la baja logica", ex, "BajaLogicaDieta", "DietaData", "218");
        }
    }
   
    
    //borrar paciente por id
    public void borrarDietaPorId(int id){
        
        try {
            FuncionDe.validarSiExisteId(this, id);
            
            String Query = "DELETE FROM dieta WHERE dieta.idDieta = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("borrarDietaPorId", "Dieta eliminada con exito");
                
            
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo borrar la dieta",ex, "BorrarDietaPorId", "DietaData", "233");
        }
        
    }
}
