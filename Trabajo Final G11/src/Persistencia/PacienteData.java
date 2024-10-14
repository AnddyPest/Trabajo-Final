package Persistencia;

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

    public int crearPaciente(Paciente pacienteEnviado) {
        boolean validado = false;   
        int codigoDevuelto = 1;
        //UNA VEZ CREADO EL METODO HAY QUE ACTUALIZAR ESTO Y AÑADIR UN IF AL TRY DE ABAJO
//        List<Paciente> alumnos = this.listarPacientes();
//        
//        if(alumnos.isEmpty()){           
//            validado = true;
//        } else{
//            for(Alumno alumno: alumnos){
//                
//                if(alumno.getDni() != a.getDni() ){                                       
//                    validado = true;
//                    
//                }else{
//                    validado = false;
//                    System.out.println("Usuarios con dni identicos no son admitidos");                    
//                    break;
//                }
//            }
//        }
            
        try {
            String query = "Insert into paciente( nombre, dni, domicilio, telefono ) values( ? , ? , ? , ? )";
            
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1,pacienteEnviado.getNombre() );
            ps.setInt(2, pacienteEnviado.getDni());
            ps.setString(3, pacienteEnviado.getDomicilio());
            ps.setString(4, pacienteEnviado.getTelefono());
            
            ps.executeUpdate();
            
            System.out.println("Alumno guardado");
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error Paciente Data || Metodo: CrearPaciente || Linea 26 ");
            System.out.println("No se ha podido guardar el paciente ");
            System.out.println("Mensaje de error: " + ex.getMessage());
            System.out.println("Codigo de error: " + ex.getErrorCode());
            codigoDevuelto = ex.getErrorCode();
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
                Paciente pacienteCreado = new Paciente();
                pacienteCreado.setIdPaciente(resultados.getInt("idPaciente"));
                pacienteCreado.setDni(resultados.getInt("dni"));
                pacienteCreado.setDomicilio(resultados.getString("domicilio"));
                pacienteCreado.setTelefono(resultados.getString("telefono"));
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error Paciente Data || Metodo: Listar Pacientes || Linea 74");
        }
        
        return pacientesDevueltos;
    }
    
    //Listar Paciente por id
    //Listar Paciente por nombre
    
    //UPDATE
    //actualizar paciente por id
    
    //DELETE
    //borrar paciente por id
       
    
    
}
