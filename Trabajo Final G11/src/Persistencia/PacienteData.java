package Persistencia;

import Entidades.Herramientas;
import java.sql.Connection;
import Entidades.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PacienteData {
    
    Connection conexion;
    
    public PacienteData(Connection conexion){
        this.conexion = conexion;
    }
    
   // C - R - U - D 
    
    //Create
    //crear Paciente

    public int crearPaciente(Paciente pacienteEnviado) throws Exception {
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
        if(!validado){
            throw new Exception("Error en validacion");
        } else{
            try {
                String query = "Insert into paciente( nombre, dni, domicilio, telefono, estado ) values( ? , ? , ? , ?, ? )";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1,pacienteEnviado.getNombre() );
                ps.setInt(2, pacienteEnviado.getDni());
                ps.setString(3, pacienteEnviado.getDomicilio());
                ps.setString(4, pacienteEnviado.getTelefono());
                ps.setBoolean(5, true);

                ps.executeUpdate();

                Herramientas.mostrarMensajeCorrecto("Crear Paciente", "El paciente ha sido creado");
                ps.close();
            }   catch (SQLException ex) {
                Herramientas.mostrarMensajeError(ex, "Crear Paciente", "PacienteData", "28");
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
            
            
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError(ex, "listarPacientes", "PacienteData", "78");
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
            Herramientas.mostrarMensajeCorrecto("buscarPacientePorid", "Paciente encontrado correctamente");
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError(ex, "buscarPacientePorId", "PacienteData", "104");
        }
        
        return pacienteDevuelto;
    }
    //Listar Paciente por nombre
    public ArrayList<Paciente> buscarPacientesPorNombre(String nombreEnviado){
        ArrayList<Paciente> pacientesEncontrados = new ArrayList<>();
        try {            
            String query = "Select * from paciente where paciente.nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombreEnviado);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                Paciente paciente = Herramientas.crearPaciente(resultados);
                pacientesEncontrados.add(paciente);
            }
            Herramientas.mostrarMensajeCorrecto("buscarPacientesPorNombre", "Pacientes con nombre: " + nombreEnviado + " enviados correctamente");
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError(ex, "buscarPacientesPorNombre", "PacienteData", "122");
        }
        
        return pacientesEncontrados;
        
    }
    //UPDATE
    //actualizar paciente por id
    
    public void actualizarPacientePorId(Paciente pacienteEnviado){
        
        try {
            String Query = "UPDATE paciente SET paciente.nombre = ?, paciente.dni = ?, paciente.domicilio = ?, paciente.telefono = ?,paciente.estado = ? WHERE paciente.idPaciente = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setString(1, pacienteEnviado.getNombre());
            ps.setString(2, pacienteEnviado.getDomicilio());
            ps.setString(3, pacienteEnviado.getTelefono());
            ps.setBoolean(4, pacienteEnviado.isEstado());
            ps.setInt(5, pacienteEnviado.getIdPaciente());
            
            ps.executeUpdate();
            ps.close();
                    
            Herramientas.mostrarMensajeCorrecto("actualizarPacientePorId", "Paciente actualizado con exito");
                    
            
        } catch (SQLException ex) {
            Herramientas.mostrarMensajeError(ex, "actualizarPacientePorId", "PacienteData", "144");
        }
    }
    
    //DELETE
    //borrar paciente por id
       
    
    
}
