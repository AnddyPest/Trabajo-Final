package Persistencia;

import java.sql.Connection;
import Entidades.Paciente;


public class PacienteData {
    
    Connection conexion;
    
    public PacienteData(Connection conexion){
        this.conexion = conexion;
    }
    
   // C - R - U - D 
    
    //Create
    //crear Paciente

    public void crearPaciente(Paciente pacienteEnviado){
        
        String query = "Insert into paciente( nombre, dni, domicilio, telefono ) values( ? , ? , ? , ? )";
        
        
    }
    
    //READ
    //Listar Todos Los Pacientes
    //Listar Paciente por id
    //Listar Paciente por nombre
    
    //UPDATE
    //actualizar paciente por id
    
    //DELETE
    //borrar paciente por id
       
    
    
}
