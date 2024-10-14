
package Entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
public class Herramientas {

    public static void mostrarMensajeCorrecto( String nombreMetodo , String mensajeEnviado ){
        String mensaje = "\nMetodo: " + nombreMetodo + "\tDice: " + mensajeEnviado;
        System.out.println(mensaje);
    }
    public static void mostrarMensajeError(SQLException ex,String nombreMetodo,String nombreClase,String linea){
        String mensaje = "\nError: " + nombreClase + " || Metodo: " + nombreMetodo + " || Linea: " + linea;
        System.out.println(mensaje);
                
        System.out.println("\nMensaje de error: " + ex.getMessage());
        System.out.println("\nCodigo de error: " + ex.getErrorCode());
    }
    
    public static Paciente crearPaciente(ResultSet resultados) throws SQLException{

        Paciente pacienteCreado = new Paciente();
        pacienteCreado.setIdPaciente(resultados.getInt("idPaciente"));
        pacienteCreado.setNombre(resultados.getString("nombre"));
        pacienteCreado.setDni(resultados.getInt("dni"));
        pacienteCreado.setDomicilio(resultados.getString("domicilio"));
        pacienteCreado.setTelefono(resultados.getString("telefono"));
        pacienteCreado.setEstado(resultados.getBoolean("estado"));
        
        return pacienteCreado;
    }
    
}
