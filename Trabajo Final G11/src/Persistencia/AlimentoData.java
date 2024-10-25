
package Persistencia;
import Entidades.Alimento;
import Utilities.FuncionDe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlimentoData {
    
    private final Connection conexion;
    
    public AlimentoData(Connection conexion){
        this.conexion = conexion;
    }
    
     public int crearAlimento(Alimento alimentoEnviado)  {
        boolean validado = false;   
        int codigoDevuelto = 1;
       
        List<Alimento> alimentos = this.listarAlimentos();
        
        if(alimentos.isEmpty()){           
            validado = true;
        } else{
            for(Alimento alimentoRevisado: alimentos){
                
                if(!alimentoRevisado.getNombre().trim().equals(alimentoEnviado.getNombre().trim())){                                       
                    validado = true;
                    
                }else{
                    validado = false;
                    System.out.println("Validacion Metodo: CrearAlimento || Mensaje: Alimentos con nombres identicos no son admitidos\n");                    
                    break;
                }
            }
        }
        if(validado){
           
        
            try {
                String query = "Insert into alimento( nombre, tipoComida, caloriasPor100g, detalle, estado ) values( ? , ? , ? , ? , ? )";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, alimentoEnviado.getNombre().trim());
                ps.setString(2, alimentoEnviado.getTipoComida().trim());
                ps.setInt(3, alimentoEnviado.getCaloriasPor100g());
                ps.setString(4, alimentoEnviado.getDetalle().trim());
                ps.setBoolean(5, true);
                ps.executeUpdate();

                FuncionDe.mostrarMensajeCorrecto("Crear Alimento", "El alimento ha sido creado");
                ps.close();
            }   catch (SQLException ex) {
                FuncionDe.mostrarMensajeError(ex, "Crear Alimento", "AlimentoData", "21");
                codigoDevuelto = ex.getErrorCode();
            }
        
        }
        return codigoDevuelto;
       
    }
    
    //READ
    //Listar Todos Los alimentos
    
    public ArrayList<Alimento> listarAlimentos(){
        ArrayList<Alimento> alimentosDevueltos = new ArrayList<>();
        try {            
            
            String Query= "Select * from alimento";            
            PreparedStatement ps = conexion.prepareStatement(Query);
            
            ResultSet resultados = ps.executeQuery();
            
            while(resultados.next()){
                Alimento alimentoCreado = FuncionDe.crearAlimento(resultados);
                
                alimentosDevueltos.add(alimentoCreado);
            }
            FuncionDe.mostrarMensajeCorrecto("Listar Alimentos", "Todos los alimentos han sido enviados correctamente");
            
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError(ex, "listarAlimentos", "AlimentoData", "71");
        }
        
        return alimentosDevueltos;
    }
    
    //Listar Alimentos por id
    
    public Alimento buscarAlimentoPorID(int id){
        
        Alimento alimentoDevuelto = null;
        try {
            String query = "Select * from alimento where idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt( 1, id );
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                alimentoDevuelto = FuncionDe.crearAlimento(resultados);                
            }
            if(alimentoDevuelto == null){
                throw new SQLException();
            }else{
                FuncionDe.mostrarMensajeCorrecto("buscarAlimentoPorid", "Alimento encontrado correctamente");
            }
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo encontrar el registro",ex, "buscarAlimentoPorId", "AlimentoData", "98");
        }
        
        return alimentoDevuelto;
    }
 
    public Alimento buscarAlimentoPorNombre(String nombreEnviado){
       
        
        Alimento alimentoDevuelto =null;
        try {            
            String query = "Select * from alimento where alimento.nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombreEnviado.trim().toLowerCase());
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                alimentoDevuelto = FuncionDe.crearAlimento(resultados);
                
            }
            if(alimentoDevuelto != null){
                FuncionDe.mostrarMensajeCorrecto("buscarAlimentosPorNombre", "Alimento con nombre: " + nombreEnviado + " enviados correctamente");
            } else{
                throw new SQLException();
            }
            resultados.close();
            ps.close();
            
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se encontraron alimentos con dicho nombre",ex, "buscarAlimentoPorNombre", "AlimentoData", "122");
        }
        
        return alimentoDevuelto;
        
    }
    //UPDATE
    //actualizar alimento por id
    
    public void actualizarAlimentoPorId(Alimento alimentoEnviado){
        
        try {
             
            //MAXI: Eliminé el campo para cambiar el "ESTADO" ya que este se modifica solo por ALTA/BAJA Lógica -- ANDRES
            FuncionDe.validarSiExisteId(this, alimentoEnviado.getIdAlimento());
            
            String Query = "UPDATE alimento SET alimento.nombre = ?, alimento.tipoComida = ?, alimento.caloriasPor100g = ?,alimento.detalle = ? , alimento.estado = ? WHERE alimento.idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setString(1, alimentoEnviado.getNombre().trim());
            ps.setString(2, alimentoEnviado.getTipoComida().trim());
            ps.setInt(3, alimentoEnviado.getCaloriasPor100g());
            ps.setString(4, alimentoEnviado.getDetalle());
            ps.setBoolean(5, alimentoEnviado.isEstado());
            ps.setInt(6, alimentoEnviado.getIdAlimento());
            ps.executeUpdate();
            ps.close();

            FuncionDe.mostrarMensajeCorrecto("actualizarAlimentoPorId", "Alimento actualizado con exito");
                    
                        
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError(ex, "actualizarAlimentoPorId", "AlimentoData", "151");
        }
    }
    
        
    //DELETE
    
     //buscar por estado individual
    public boolean buscarEstadoPorId(int id){
        Alimento resultadoEstado = null;
        try {
            FuncionDe.validarSiExisteId(this, id);
            String query = "SELECT alimento.estado FROM alimento WHERE alimento.idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                resultadoEstado = new Alimento();
                resultadoEstado.setEstado(resultados.getBoolean("estado"));
            }
            FuncionDe.mostrarMensajeCorrecto("BuscarEstadoPorId", "Estado Logico del Alimento enviado correctamente");
        } catch (SQLException ex) {
           FuncionDe.mostrarMensajeError("No se pudo enviar el estado logico del Alimento", ex, "BuscarEstadoPorID", "AlimentoData", "181");
        }
        return resultadoEstado.isEstado();
    }
    //Alta logica
    public void altaLogicaAlimento(int id){
        
        try {
            FuncionDe.validarSiExisteId(this, id);
            FuncionDe.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, true);
            String Query = "UPDATE alimento SET alimento.estado = ? WHERE alimento.idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("AltaLogicaAlimento", "Alimento dado de Alta correctamente");
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo dar el alta logica", ex, "AltaLogicaAlimento", "AlimentoData", "200");
        }
    }
   
    //baja logica 
    public void bajaLogicaAlimento(int id){
        
        try {
            FuncionDe.validarSiExisteId(this, id);
            FuncionDe.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, false);
            String Query = "UPDATE alimento SET alimento.estado = ? WHERE alimento.idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("BajaLogicaAlimento", "Alimento dado de Baja correctamente");
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo dar la baja logica", ex, "BajaLogicaAlimento", "AlimentoData", "218");
        }
    }
   
    
    //borrar paciente por id
    public void borrarAlimentoPorId(int id){
        
        try {
            FuncionDe.validarSiExisteId(this, id);
            
            String Query = "DELETE FROM alimento WHERE alimento.idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("borrarAlimentoPorId", "Alimento eliminado con exito");
                
            
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo borrar el alimento",ex, "BorrarAlimentoPorId", "AlimentoData", "237");
        }
        
    }
    
    
    
}
    

