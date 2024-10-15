package Persistencia;

import Entidades.Herramientas;
import java.sql.Connection;
import Entidades.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PacienteData {
    
    Connection conexion;
    
    public PacienteData(Connection conexion){
        this.conexion = conexion;
    }
    
   // C - R - U - D 
    
    //Create
    //crear Paciente

    public int crearPaciente(Paciente pacienteEnviado)  {
        boolean validado = false;   
        int codigoDevuelto = 1;
        //UNA VEZ CREADO EL METODO HAY QUE ACTUALIZAR ESTO Y AÑADIR UN IF AL TRY DE ABAJO
        List<Paciente> pacientes = this.listarPacientes();
        
        if(pacientes.isEmpty()){           
            validado = true;
        } else{
            for(Paciente pacienteRevisado: pacientes){
                
                if(pacienteRevisado.getDni() != pacienteEnviado.getDni() ){                                       
                    validado = true;
                    
                }else{
                    validado = false;
                    System.out.println("Validacion Metodo: CrearPaciente || Mensaje: Pacientes con dni identicos no son admitidos\n");                    
                    break;
                }
            }
        }
        if(validado){
           
        
            try {
                String query = "Insert into paciente( nombre, dni, domicilio, telefono, estado ) values( ? , ? , ? , ?, ? )";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1,pacienteEnviado.getNombre().trim() );
                ps.setInt(2, pacienteEnviado.getDni());
                ps.setString(3, pacienteEnviado.getDomicilio().trim());
                ps.setString(4, pacienteEnviado.getTelefono().trim());
                ps.setBoolean(5, true);

                ps.executeUpdate();

                Herramientas.mostrarMensajeCorrecto("Crear Paciente", "El paciente ha sido creado");
                ps.close();
            }   catch (SQLException ex) {
                Herramientas.mostrarMensajeError(ex, "Crear Paciente", "PacienteData", "29");
                codigoDevuelto = ex.getErrorCode();
            }
        
        }
        return codigoDevuelto;
       
    }
    
    //READ
    //Listar Todos Los Pacientes
    
    public ArrayList<Paciente> listarPacientes(){
        ArrayList<Paciente> pacientesDevueltos = new ArrayList<>();
        try {            
            
            String Query= "Select * from paciente";            
            PreparedStatement ps = conexion.prepareStatement(Query);
            
            ResultSet resultados = ps.executeQuery();
            
            while(resultados.next()){
                Paciente pacienteCreado = Herramientas.crearPaciente(resultados);
                
                pacientesDevueltos.add(pacienteCreado);
            }
            Herramientas.mostrarMensajeCorrecto("Listar Pacientes", "Todos los pacientes han sido enviados correctamente");
            
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError(ex, "listarPacientes", "PacienteData", "80");
        }
        
        return pacientesDevueltos;
    }
    
    //Listar Paciente por id
    
    public Paciente buscarPacientePorID(int id){
        Paciente pacienteDevuelto = null;
        try {
            String query = "Select * from paciente where idPaciente = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt( 1, id );
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                pacienteDevuelto = Herramientas.crearPaciente(resultados);                
            }
            if(pacienteDevuelto == null){
                throw new SQLException();
            }else{
                Herramientas.mostrarMensajeCorrecto("buscarPacientePorid", "Paciente encontrado correctamente");
            }
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError("No se pudo encontrar el registro",ex, "buscarPacientePorId", "PacienteData", "107");
        }
        
        return pacienteDevuelto;
    }
    //Listar Paciente por nombre
    public ArrayList<Paciente> buscarPacientesPorNombre(String nombreEnviado){
        ArrayList<Paciente> pacientesEncontrados = new ArrayList<>();
        try {            
            String query = "Select * from paciente where paciente.nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombreEnviado.trim().toLowerCase());
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                Paciente paciente = Herramientas.crearPaciente(resultados);
                pacientesEncontrados.add(paciente);
            }
            if(!pacientesEncontrados.isEmpty()){
                Herramientas.mostrarMensajeCorrecto("buscarPacientesPorNombre", "Pacientes con nombre: " + nombreEnviado + " enviados correctamente");
            } else{
                throw new SQLException();
            }
            resultados.close();
            ps.close();
            
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError("No se encontraron pacientes con dicho nombre",ex, "buscarPacientesPorNombre", "PacienteData", "131");
        }
        
        return pacientesEncontrados;
        
    }
    //UPDATE
    //actualizar paciente por id
    
    public void actualizarPacientePorId(Paciente pacienteEnviado){
        
        try {
            //REVISAR SI FUNCIONA
            Herramientas.validarSiExisteId(this, pacienteEnviado.getIdPaciente());
            
            String Query = "UPDATE paciente SET paciente.nombre = ?, paciente.dni = ?, paciente.domicilio = ?, paciente.telefono = ?,paciente.estado = ? WHERE paciente.idPaciente = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setString(1, pacienteEnviado.getNombre());
            ps.setInt(2, pacienteEnviado.getDni());
            ps.setString(3, pacienteEnviado.getDomicilio());
            ps.setString(4, pacienteEnviado.getTelefono());
            ps.setBoolean(5, pacienteEnviado.isEstado());
            ps.setInt(6, pacienteEnviado.getIdPaciente());

            ps.executeUpdate();
            ps.close();

            Herramientas.mostrarMensajeCorrecto("actualizarPacientePorId", "Paciente actualizado con exito");
                    
                        
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError(ex, "actualizarPacientePorId", "PacienteData", "160");
        }
    }
    
        
    //DELETE
    
     //buscar por estado individual
    public boolean buscarEstadoPorId(int id){
        Paciente resultadoEstado = null;
        try {
            Herramientas.validarSiExisteId(this, id);
            String query = "SELECT paciente.estado FROM paciente WHERE paciente.idPaciente = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                resultadoEstado = new Paciente();
                resultadoEstado.setEstado(resultados.getBoolean("estado"));
            }
            Herramientas.mostrarMensajeCorrecto("BuscarEstadoPorId", "Estado Logico del paciente enviado correctamente");
        } catch (SQLException ex) {
           Herramientas.mostrarMensajeError("No se pudo enviar el estado logico del paciente", ex, "BuscarEstadoPorID", "PacienteData", "190");
        }
        return resultadoEstado.isEstado();
    }
    //Alta logica
    public void altaLogicaPaciente(int id){
        
        try {
            Herramientas.validarSiExisteId(this, id);
            Herramientas.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, true);
            String Query = "UPDATE paciente SET paciente.estado = ? WHERE paciente.idPaciente = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            Herramientas.mostrarMensajeCorrecto("AltaLogicaPaciente", "Paciente dado de Alta correctamente");
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError("No se pudo dar el alta logica", ex, "AltaLogicaPaciente", "PacienteData", "209");
        }
    }
   
    //baja logica 
    public void bajaLogicaPaciente(int id){
        
        try {
            Herramientas.validarSiExisteId(this, id);
            Herramientas.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, false);
            String Query = "UPDATE paciente SET paciente.estado = ? WHERE paciente.idPaciente = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            Herramientas.mostrarMensajeCorrecto("BajaLogicaPaciente", "Paciente dado de Baja correctamente");
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError("No se pudo dar la baja logica", ex, "BajaLogicaPaciente", "PacienteData", "227");
        }
    }
   
    
    //borrar paciente por id
    public void borrarPacientePorId(int id){
        
        try {
            Herramientas.validarSiExisteId(this, id);
            
            String Query = "DELETE FROM paciente WHERE paciente.idPaciente = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            Herramientas.mostrarMensajeCorrecto("borrarPacientePorId", "Paciente eliminado con exito");
                
            
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError("No se pudo borrar el paciente",ex, "BorrarPacientePorId", "PacienteData", "246");
        }
        
    }
    
    
    
}
