
package Persistencia.Handlers;
import Entidades.Alimento;
import Entidades.Handlers.MenuDiario_Alimento_Handler;
import Entidades.MenuDiario;
import Entidades.Paciente;
import Utilities.FuncionDe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDiario_Alimento_Handler_DATA {
    Connection conexion;
    
    public MenuDiario_Alimento_Handler_DATA(Connection conexion){
        this.conexion = conexion;
    }
    
    
    public int createHandler_MenuDiario_Alimento(MenuDiario idMenuDiarioEnviado, Alimento idAlimentoEnviado)  {
        boolean validado = false;   
        int codigoDevuelto = 1;
        //UNA VEZ CREADO EL METODO HAY QUE ACTUALIZAR ESTO Y AÑADIR UN IF AL TRY DE ABAJO
        List<MenuDiario_Alimento_Handler> listadoDeHandlers = this.listarHandler_MenuDiario_Alimento();
        
        if(listadoDeHandlers.isEmpty()){           
            validado = true;
        } else{
            for(MenuDiario_Alimento_Handler handlerRevisado: listadoDeHandlers){
                
                if(handlerRevisado.getIdMenuDiario().getIdMenuDiario() != idMenuDiarioEnviado.getIdMenuDiario() && handlerRevisado.getIdAlimento().getIdAlimento() != idAlimentoEnviado.getIdAlimento() ){                                       
                    validado = true;
                    
                }else{
                    validado = false;
                    System.out.println("Validacion Metodo: createHandler_MenuDiario_Alimento|| Mensaje: Handlers ya relacionados no son admitidos\n");                    
                    break;
                }
            }
        }
        if(validado){
          
        
            try {
                String query = "Insert into menudiario_alimento_handler( idMenuDiario, idAlimento ) values( ? , ?  )";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, idMenuDiarioEnviado.getIdMenuDiario());
                ps.setInt(2, idAlimentoEnviado.getIdAlimento());

                ps.executeUpdate();
                

                FuncionDe.mostrarMensajeCorrecto("createHandler_MenuDiario_Alimento", "El handler (relacion) entre MenuDiario y Alimento ha sido creado");
                ps.close();
            }   catch (SQLException ex) {
                FuncionDe.mostrarMensajeError(ex, "createHandler_MenuDiario_Alimento", "MenuDiario_Alimento_Handler_DATA", "29");
                codigoDevuelto = ex.getErrorCode();
            }
        
        }
        return codigoDevuelto;
       
    }
    
    //READ
    //Listar Todos Los Pacientes
    
    public ArrayList<MenuDiario_Alimento_Handler> listarHandler_MenuDiario_Alimento(){
        ArrayList<MenuDiario_Alimento_Handler> handlersDevueltos = new ArrayList<>();
        try {            
            
            String Query= "Select * from menudiario_alimento_handler";            
            PreparedStatement ps = conexion.prepareStatement(Query);
            
            ResultSet resultados = ps.executeQuery();
            
            while(resultados.next()){
                MenuDiario_Alimento_Handler handlerCreado = FuncionDe.crearMenuDiario_Alimento_Handler(resultados);
                
                handlersDevueltos.add(handlerCreado);
            }
            FuncionDe.mostrarMensajeCorrecto("listarHandler_MenuDiario_Alimento", "Todos los handlers (relaciones) han sido enviados correctamente");
            
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError(ex, "listarHandler_MenuDiario_Alimento", "MenuDiario_Alimento_Handler_DATA", "80");
        }
        
        return handlersDevueltos;
    }
    
    //Listar Paciente por id
    
    public MenuDiario_Alimento_Handler buscarHandler_MenuDiario_AlimentoPorIDS(int idMenuDiario, int idAlimento){
        MenuDiario_Alimento_Handler handlerDevuelto = null;
        try {
            String query = "Select * from menudiario_alimento_handler where idMenuDiario = ? AND idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt( 1, idMenuDiario );
            ps.setInt(2, idAlimento);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                handlerDevuelto = FuncionDe.crearMenuDiario_Alimento_Handler(resultados);                
            }
            if(handlerDevuelto == null){
                throw new SQLException();
            }else{
                FuncionDe.mostrarMensajeCorrecto("buscarHandler_MenuDiario_AlimentoPorIDS", "Handler-MenuDiario-Alimento encontrado correctamente");
            }
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo encontrar el registro Handler-MenuDiario-Alimento",ex, "buscarHandler_MenuDiario_AlimentoPorIDS", "MenuDiario_Alimento_Handler_DATA", "107");
        }
        
        return handlerDevuelto;
    }
    
    //UPDATE
    //actualizar paciente por id
    
    public void actualizarHandler_MenuDiario_AlimentoPorIDS(MenuDiario_Alimento_Handler handlerEnviado, MenuDiario_Alimento_Handler handlerViejo){
        //ANDRES: EN ESTOS METODOS AL ACTUALIZAR SOLAMENTE SUS IDS ES NECESARIO QUE ME ENVIES LAS VIEJAS PARA PODER BUSCAR CUAL ES LA QUE QUERES ACTUALZIAR
        try {
            if(FuncionDe.validarSiExisteId(this, handlerEnviado.getIdMenuDiario().getIdMenuDiario(), handlerEnviado.getIdAlimento().getIdAlimento())){
                throw new SQLException("Validacion linea 130: Ya existe una relacion con dichos ids y no se puede modificar ");
            }
            if(!FuncionDe.validarSiExisteId(this, handlerViejo.getIdMenuDiario().getIdMenuDiario(), handlerViejo.getIdAlimento().getIdAlimento())){
                throw new SQLException("Validacion linea 133: No se encontro handler con dichos ids");
            }else{
                String Query = "UPDATE menudiario_alimento_handler SET menudiario_alimento_handler.idMenuDiario = ? , menudiario_alimento_handler.idAlimento = ? WHERE menudiario_alimento_handler.idMenuDiario = ? AND menudiario_alimento_handler.idAlimento = ?";
                PreparedStatement ps = conexion.prepareStatement(Query);
                ps.setInt(1, handlerEnviado.getIdMenuDiario().getIdMenuDiario());
                ps.setInt(2, handlerEnviado.getIdAlimento().getIdAlimento());
                ps.setInt(3, handlerViejo.getIdMenuDiario().getIdMenuDiario());
                ps.setInt(4, handlerViejo.getIdAlimento().getIdAlimento());
                ps.executeUpdate();
                ps.close();

                FuncionDe.mostrarMensajeCorrecto("actualizarHandler_MenuDiario_AlimentoPorIDS", "Handler actualizado con exito");
            }
             
                        
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo actualizar al Handler_MenuDiario_Alimento por sus Id",ex , "actualizarHandler_MenuDiario_AlimentoPorIDS", "MenuDiario_Alimento_Handler_DATA", "160");
            
        }
    }
    
        
    //DELETE
   
   
    
    //borrar paciente por id
    public void borrarHandler_MenuDiario_AlimentoPorIds(int idMenuDiario, int idAlimento){
        
        try {
            FuncionDe.validarSiExisteId(this, idMenuDiario,idAlimento);
            
            String Query = "DELETE FROM menudiario_alimento_handler WHERE menudiario_alimento_handler.idMenuDiario = ? AND menudiario_alimento_handler.idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, idMenuDiario);
            ps.setInt(2, idAlimento);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("borrarHandler_MenuDiario_AlimentoPorIds", "Handler_MenuDiario_Alimento eliminado con exito");
                
            
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo borrar el Handler_MenuDiario_Alimento",ex, "borrarHandler_MenuDiario_AlimentoPorIds", "MenuDiario_Alimento_Handler_DATA ", "246");
        }
        
    }
    
    
    
}
