
package Entidades;

import Persistencia.ComidaData;
import Persistencia.DietaData;
import Persistencia.PacienteData;
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
        System.out.println("\n==========================================");
    }
    public static void mostrarMensajeError(String mensajeEnviado,SQLException ex,String nombreMetodo,String nombreClase,String linea){
        String mensaje = "\nError: " + nombreClase + " || Metodo: " + nombreMetodo + " || Linea: " + linea;
        System.out.println(mensaje);
        System.out.println("\nMensaje: " + mensajeEnviado);
                
        System.out.println("\nMensaje de error: " + ex.getMessage());
        System.out.println("\nCodigo de error: " + ex.getErrorCode());
        System.out.println("\n==========================================");
    }
    
    public static Paciente crearPaciente(ResultSet resultados) throws SQLException{

        Paciente pacienteCreado = new Paciente();
        pacienteCreado.setIdPaciente(resultados.getInt("idPaciente"));
        pacienteCreado.setNombre(resultados.getString("nombre").trim());
        pacienteCreado.setDni(resultados.getInt("dni"));
        pacienteCreado.setDomicilio(resultados.getString("domicilio").trim());
        pacienteCreado.setTelefono(resultados.getString("telefono").trim());
        pacienteCreado.setEstado(resultados.getBoolean("estado"));
        
        return pacienteCreado;
    }
    public static Comida crearComida(ResultSet resultados) throws SQLException{
        Comida comidaCreada = new Comida();
        comidaCreada.setIdComida(resultados.getInt("idComida"));
        comidaCreada.setNombre(resultados.getString("nombre"));
        comidaCreada.setDetalle(resultados.getString("detalle"));
        comidaCreada.setCantidadCalorias(resultados.getInt("cantCalorias"));
        comidaCreada.setEstadoComida(resultados.getBoolean("estado"));
        return comidaCreada;
    }
    public static Dieta crearDieta(ResultSet resultados) throws SQLException{
        Dieta dietaCreada = new Dieta();
        dietaCreada.setIdDieta(resultados.getInt("idDieta"));
        dietaCreada.setNombre(resultados.getString("nombre"));
        dietaCreada.setFechaInicio(resultados.getDate("fechaInicial").toLocalDate());
        dietaCreada.setFechaFinal(resultados.getDate("fechaFinal").toLocalDate());
        dietaCreada.setPesoInicial(resultados.getDouble("pesoInicial"));
        dietaCreada.setPesoInicial(resultados.getDouble("pesoFinal"));
        dietaCreada.setIdPaciente(resultados.getInt("idPaciente"));
        dietaCreada.setEstadoDieta(resultados.getBoolean("estado"));
        return dietaCreada;
    }
    public static void validarSiExisteId(PacienteData metodo, int id) throws SQLException{
        if(metodo.buscarPacientePorID(id) == null){
                throw new SQLException();
            }
    }
    public static void validarSiExisteId(ComidaData metodo, int id) throws SQLException{
        if(metodo.buscarComidaPorID(id) == null){
                throw new SQLException();
            }
    }
    public static void validarSiExisteId(DietaData metodo, int id) throws SQLException{
        if(metodo.buscarDietaPorID(id) == null){
                throw new SQLException();
            }
    }
    public static void validarSiYaEstabaLogicamenteEnDichoEstado(PacienteData metodo, int id,boolean estadoAValidar) throws SQLException{
        if(estadoAValidar){
            if(metodo.buscarEstadoPorId(id) == true){
                throw new SQLException("El paciente ya está dado de ALTA");
            }
        }else{
            if(metodo.buscarEstadoPorId(id) == false){
                throw new SQLException("El paciente ya está dado de BAJA");
            }
        }
        
        
    }
    public static void validarSiYaEstabaLogicamenteEnDichoEstado(ComidaData metodo, int id,boolean estadoAValidar) throws SQLException{
        if(estadoAValidar){
            if(metodo.buscarEstadoPorId(id) == true){
                throw new SQLException("La comida ya está dada de ALTA");
            }
        }else{
            if(metodo.buscarEstadoPorId(id) == false){
                throw new SQLException("La comida ya está dada de BAJA");
            }
        }       
        
    }
    public static void validarSiYaEstabaLogicamenteEnDichoEstado(DietaData metodo, int id,boolean estadoAValidar) throws SQLException{
        if(estadoAValidar){
            if(metodo.buscarEstadoPorId(id) == true){
                throw new SQLException("La dieta ya está dada de ALTA");
            }
        }else{
            if(metodo.buscarEstadoPorId(id) == false){
                throw new SQLException("La dieta ya está dada de BAJA");
            }
        }       
        
    }
}
