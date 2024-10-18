
package Persistencia;

import Entidades.Dieta;
import Entidades.FuncionDe;
import Entidades.MenuDiario;
import Entidades.RenglonDelMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RenglonDelMenuData {
    //MARQUITOS DEJAME LA BD AMI (MAXI) HACE UNA VISTA
    
    
    private Connection conexion;
    public RenglonDelMenuData(Connection conexion){
        this.conexion = conexion;
    }
    
    public int crearRenglonDelMenu(RenglonDelMenu renglonDelMenuEnviada)  {
        //CAMBIAR A FALSE SI SE LLEGA A VALIDAR
        boolean validado = true;   
        int codigoDevuelto = 1;
        if(validado){ 
            try {
                String query = "Insert into renglondelmenu(idAlimento, cantidadGramos, subTotalCalorias	) values(  ? , ? , ?)";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, renglonDelMenuEnviada.getAlimento().getIdAlimento());
                ps.setDouble(2, renglonDelMenuEnviada.getCantidadGramos());
                ps.setInt(3, renglonDelMenuEnviada.getSubTotalCalorias());
                ps.executeUpdate();

                FuncionDe.mostrarMensajeCorrecto("Crear RenglonDelMenu", "El RenglonDelMenu ha sido añadido");
                ps.close();
            }   catch (SQLException ex) {
                FuncionDe.mostrarMensajeError(ex, "Crear RenglonDelMenu", "RenglonDelMenuData", "24");
                codigoDevuelto = ex.getErrorCode();
            }
        
        }
        return codigoDevuelto;
       
    }
    
    //READ
    //Listar Todos Los Pacientes
    
    public ArrayList<RenglonDelMenu> listarRenglonDelMenu(){
        ArrayList<RenglonDelMenu> renglonDelMenuDevueltos = new ArrayList<>();
        try {            
            
            String Query= "SELECT * FROM renglondelmenu";            
            PreparedStatement ps = conexion.prepareStatement(Query);
            
            ResultSet resultados = ps.executeQuery();
            
            while(resultados.next()){
                RenglonDelMenu renglonDeMenuCreado = FuncionDe.crearRengloDeMenu(resultados);
                
                renglonDelMenuDevueltos.add(renglonDeMenuCreado);
            }
            FuncionDe.mostrarMensajeCorrecto("Listar RenglonDelMenu", "Todos los RenglonDelMenu han sido enviados correctamente");
            
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se puede listar los RenglonDelMenu",ex, "Listar RenglonDelMenu", "RenglonDelMenuData", "53");
        }
        
        return renglonDelMenuDevueltos;
    }
    
    //Listar Paciente por id
    
    public RenglonDelMenu buscarRenglonDelMenuPorID(int id){
        RenglonDelMenu renglonDelMenuDevuelto = null;
        try {
            String query = "SELECT * FROM renglondelmenu WHERE idRenglonDelMenu = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt( 1, id );
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                renglonDelMenuDevuelto = FuncionDe.crearRengloDeMenu(resultados);                
            }
            if(renglonDelMenuDevuelto == null){
                throw new SQLException();
            }else{
                FuncionDe.mostrarMensajeCorrecto("buscarRenglonDelMenuPorId", "RenglonDelMenu encontrado correctamente");
            }
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo encontrar el registro",ex, "buscarRenglonDelMenuPorId", "RenglonDelMenuData", "80");
        }
        
        return renglonDelMenuDevuelto;
    }
    
    
    //UPDATE
    //actualizar paciente por id
    
    public void actualizarRenglonDeMenuPorId(RenglonDelMenu renglonDelMenuEnviado){
        
        try {
            //REVISAR SI FUNCIONA
            FuncionDe.validarSiExisteId(this, renglonDelMenuEnviado.getIdRenglonDelMenu());
                                                           
            String Query = "UPDATE renglondelmenu SET renglondelmenu.idAlimento = ?, renglondelmenu.cantidadGramos = ?, renglondelmenu.subTotalCalorias = ?  WHERE renglondelmenu.idRenglonDelMenu = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, renglonDelMenuEnviado.getAlimento().getIdAlimento());
            ps.setDouble(2,renglonDelMenuEnviado.getCantidadGramos());
            ps.setInt(3, renglonDelMenuEnviado.getSubTotalCalorias());
            ps.setInt(4, renglonDelMenuEnviado.getIdRenglonDelMenu());
            ps.executeUpdate();
            ps.close();

            FuncionDe.mostrarMensajeCorrecto("actualizarRenglonDelMenuPorId", "RenglonDelMenu actualizado con exito");
                    
                        
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo actualizar el RenglonDelMenu",ex, "actualizarRenglonDelMenuPorId", "RenglonDelMenuData", "108");
        }
    }
    
        
    //DELETE    
      
    //borrar paciente por id
    public void borrarRenglonDeMenuPorId(int id){
        
        try {
            FuncionDe.validarSiExisteId(this, id);
            
            String Query = "DELETE FROM renglondelmenu WHERE renglondelmenu.idRenglonDelMenu = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("borrarRenglonDelMenuPorId", "RenglonDelMenu eliminado con exito");
                
            
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo borrar el RenglonDelMenu",ex, "borrarRenglonDelMenuPorId", "RenglonDelMenuData", "135");
        }
        
    }
}
