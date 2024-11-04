
package Persistencia.Handlers;


import Entidades.Handlers.Dieta_MenuDiario_Handler;

import Utilities.FuncionDe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.time.LocalDate;



public class Dieta_MenuDiario_Handler_DATA {
    
    Connection conexion;
    
    public Dieta_MenuDiario_Handler_DATA(Connection conexion){
        this.conexion = conexion;
    }
    
    public int createDieta_MenuDiario_Handler( int idDieta, int idMenuDiario, LocalDate fecha)  {
        boolean validado = false;   
        int codigoDevuelto = 1;
        //UNA VEZ CREADO EL METODO HAY QUE ACTUALIZAR ESTO Y AÑADIR UN IF AL TRY DE ABAJO
        
        
        if(!validado){
          
        
            try {
                String query = "Insert into dieta_menudiario_handler( idDieta, idMenuDiario, fecha ) values ( ? , ? , ? )";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, idDieta);
                ps.setInt(2, idMenuDiario);
                ps.setDate(3, java.sql.Date.valueOf(fecha));

                ps.executeUpdate();
                

                FuncionDe.mostrarMensajeCorrecto("createDieta_MenuDiario_Handler", "El handler (relacion) entre Dieta y sus menuDiario ha sido creado");
                ps.close();
            }   catch (SQLException ex) {
                FuncionDe.mostrarMensajeError(ex, "createDieta_MenuDiario_Handler", "Dieta_MenuDiario_Handler_DATA", "27");
                codigoDevuelto = ex.getErrorCode();
            }
        
        }
        return codigoDevuelto;
       
    }
    
    //READ
    //Listar Todos Los Pacientes
    
    public ArrayList<Dieta_MenuDiario_Handler> listarDieta_MenuDiario_Handler(){
        ArrayList<Dieta_MenuDiario_Handler> handlersDevueltos = new ArrayList<>();
        try {            
            
            String Query= "Select * from dieta_menudiario_handler";            
            PreparedStatement ps = conexion.prepareStatement(Query);
            
            ResultSet resultados = ps.executeQuery();
            
            while(resultados.next()){
                Dieta_MenuDiario_Handler handlerCreado = FuncionDe.crearDieta_MenuDiario_Handler(resultados);
                
                handlersDevueltos.add(handlerCreado);
            }
            FuncionDe.mostrarMensajeCorrecto("listarDieta_MenuDiario_Handler", "Todos los handlers (relaciones) han sido enviados correctamente");
            
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError(ex, "listarDieta_MenuDiario_Handler", "Dieta_MenuDiario_Handler_DATA", "76");
        }
        
        return handlersDevueltos;
    }
    
    //Listar Paciente por id
    
    public Dieta_MenuDiario_Handler buscarDieta_MenuDiario_HandlerIDS(int idDieta, int idMenuDiario){
        Dieta_MenuDiario_Handler handlerDevuelto = null;
        try {
            String query = "Select * from dieta_menudiario_handler where idDieta = ? AND idMenuDiario = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt( 1, idDieta );
            ps.setInt(2, idMenuDiario);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                handlerDevuelto = FuncionDe.crearDieta_MenuDiario_Handler(resultados);                
            }
            if(handlerDevuelto == null){
                throw new SQLException();
            }else{
                FuncionDe.mostrarMensajeCorrecto("buscarDieta_MenuDiario_HandlerIDS", "Dieta_MenuDiario_Handler encontrado correctamente");
            }
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo encontrar el registro Dieta_MenuDiario_Handler",ex, "buscarDieta_MenuDiario_HandlerIDS", "Dieta_MenuDiario_Handler_DATA", "103");
        }
        
        return handlerDevuelto;
    }
    
        public ArrayList<Integer> listarMenuDiario_DietaID(int idDieta) {
    ArrayList<Integer> menuDiarioIdHandler = new ArrayList<>();
    try {
        String query = "SELECT idMenuDiario FROM dieta_menudiario_handler WHERE idDieta = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idDieta);
        ResultSet resultados = ps.executeQuery();
        while (resultados.next()) {
            menuDiarioIdHandler.add(resultados.getInt("idMenuDiario"));
        }
        resultados.close();
        ps.close();
    } catch (SQLException ex) {
        FuncionDe.mostrarMensajeError("No se pudo encontrar el registro Dieta_MenuDiario_Handler", ex, "listarMenuDiario_DietaID", "Dieta_MenuDiario_Handler_DATA", "103");
    }
    return menuDiarioIdHandler;
}

    
    //UPDATE
    //actualizar paciente por id
    
    public void actualizarDieta_MenuDiario_HandlerPorIDS(Dieta_MenuDiario_Handler handlerEnviado, Dieta_MenuDiario_Handler handlerViejo){
        //ANDRES: EN ESTOS METODOS AL ACTUALIZAR SOLAMENTE SUS IDS ES NECESARIO QUE ME ENVIES LAS VIEJAS PARA PODER BUSCAR CUAL ES LA QUE QUERES ACTUALZIAR
        try {
            if(FuncionDe.validarSiExisteId(this, handlerEnviado.getIdDieta().getIdDieta(), handlerEnviado.getIdMenuDiario().getIdMenuDiario())){
                throw new SQLException("Validacion linea 130: Ya existe una relacion con dichos ids y no se puede modificar ");
            }
            if(!FuncionDe.validarSiExisteId(this, handlerEnviado.getIdDieta().getIdDieta(), handlerEnviado.getIdMenuDiario().getIdMenuDiario())){
                throw new SQLException("Validacion linea 133: No se encontro handler con dichos ids");
            }else{
                String Query = "UPDATE dieta_menudiario_handler SET dieta_menudiario_handler.idDieta = ? , dieta_menudiario_handler.idMenuDiario = ? , dieta_menudiario_handler.fecha = ? WHERE dieta_menudiario_handler.idDieta = ? AND dieta_menudiario_handler.idMenuDiario = ?";
                PreparedStatement ps = conexion.prepareStatement(Query);
                ps.setInt(1, handlerEnviado.getIdDieta().getIdDieta());
                ps.setInt(2, handlerEnviado.getIdMenuDiario().getIdMenuDiario());
                ps.setDate(3, java.sql.Date.valueOf(handlerEnviado.getFecha()));
                ps.setInt(4, handlerViejo.getIdDieta().getIdDieta());
                ps.setInt(5, handlerViejo.getIdMenuDiario().getIdMenuDiario());
                ps.executeUpdate();
                ps.close();

                FuncionDe.mostrarMensajeCorrecto("actualizarDieta_MenuDiario_HandlerPorIDS", "Handler actualizado con exito");
            }
             
                        
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo actualizar al Dieta_MenuDiario_HandlerPorIDS por sus Id",ex , "actualizarDieta_MenuDiario_HandlerPorIDS", "Dieta_MenuDiario_Handler_DATA", "131");
            
        }
    }
    
        
    //DELETE
   
   
    
    //borrar paciente por id
    public void borrarDieta_MenuDiario_HandlerPorIds(int idDieta, int idMenuDiario){
        
        try {
            FuncionDe.validarSiExisteId(this, idMenuDiario,idDieta);
            
            String Query = "DELETE FROM dieta_menudiario_handler WHERE dieta_menudiario_handler.idDieta = ? AND dieta_menudiario_handler.idMenuDiario = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, idDieta);
            ps.setInt(2, idMenuDiario);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("borrarDieta_MenuDiario_HandlerPorIds", "Dieta_MenuDiario_Handler eliminado con exito");
                
            
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo borrar el Dieta_MenuDiario_Handler",ex, "borrarDieta_MenuDiario_HandlerPorIds", "Dieta_MenuDiario_Handler_DATA", "165");
        }
        
    }
    
    public String obtenerFechaPorMenuYDieta(int idDieta, int idMenuDiario) {
    String fecha = "";
    try {
        String query = "SELECT fecha FROM dieta_menudiario_handler WHERE idDieta = ? AND idMenuDiario = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idDieta);
        ps.setInt(2, idMenuDiario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            fecha = rs.getString("fecha");
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        FuncionDe.mostrarMensajeError("No se pudo encontrar la fecha", ex, "obtenerFechaPorMenuYDieta", "Dieta_MenuDiario_Handler_DATA", "104");
    }
    return fecha;
}
    
    public ArrayList<Dieta_MenuDiario_Handler> obtenerFechaYMenuPorIdDieta(int idDieta) {
    ArrayList<Dieta_MenuDiario_Handler> idMnuFechas = new ArrayList();
    try {
        String query = "SELECT * FROM dieta_menudiario_handler WHERE idDieta = ? ";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idDieta);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
             Dieta_MenuDiario_Handler handlerCreado = FuncionDe.crearDieta_MenuDiario_Handler(rs);
             idMnuFechas.add(handlerCreado);
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        FuncionDe.mostrarMensajeError("No se pudo encontrar la fecha", ex, "obtenerFechaPorMenuYDieta", "Dieta_MenuDiario_Handler_DATA", "104");
    }
    return idMnuFechas;
    }
}
    

