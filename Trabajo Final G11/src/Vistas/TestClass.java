package Vistas;
import Entidades.Comida;
import Entidades.Conexion;
import java.sql.Connection;
import Entidades.Paciente;
import Persistencia.ComidaData;
import Persistencia.PacienteData;
import java.util.ArrayList;


public class TestClass {

    public static void main(String args[]) {
        
        Connection conexion = Conexion.getConexion();
        
        ////////////////////////////
        //////Testeo Pacientes//////
        ////////////////////////////
        
        PacienteData pacienteData = new PacienteData(conexion);
//        
//        Paciente paciente1 = new Paciente("maximo", 44332211, "b 123 cc122", "2552331", true);
//        Paciente paciente2 = new Paciente("ramon", 46532211, "b 126 cc122", "9952331", true);
//        Paciente paciente3 = new Paciente("andres", 41332211, "b 121 cc122", "2752331", true);
//        Paciente paciente4 = new Paciente("marquitos", 31332211, "b 333 cc122", "232331", true);
//        Paciente paciente5 = new Paciente("maximo", 443322211, "b 1 cc122", "2552331", true);
       
        //Crear || FUNCIONA CORRECTAMENTE ||   Nota Hay que VALIDAR el telefono, para saber si es un numero y no contiene letras
//        
//        pacienteData.crearPaciente(paciente1);
//        pacienteData.crearPaciente(paciente1);
//        pacienteData.crearPaciente(paciente2);
//        pacienteData.crearPaciente(paciente3);
//        pacienteData.crearPaciente(paciente4);
        //pacienteData.crearPaciente(paciente5);
        
        //listar Pacientes || FUNCIONA CORRECTAMENTE ||
//        ArrayList<Paciente> pacientesListados = pacienteData.listarPacientes();
//        for(Paciente paciente: pacientesListados){
//            System.out.println(paciente.toString());
//        }

        //buscar Paciente por Id || FUNCIONA CORRECTAMENTE || NOTA: Puede que haya que validar null al recibir el dato
        
//        Paciente pacienteEncontrado = pacienteData.buscarPacientePorID(2);
//        if(!(pacienteEncontrado == null)){
//            System.out.println(pacienteEncontrado.toString());
//        }       
        
        //Buscar paciente por nombre || FUNCIONA CORRECTAMENTE || NOTA: Mismo caso que el anterior, validar si llega null
        
//        ArrayList<Paciente> pacientesRecibidos = pacienteData.buscarPacientesPorNombre(" maximo");
//        if(!pacientesRecibidos.isEmpty()){
//            for(Paciente paciente: pacientesRecibidos){
//                System.out.println(paciente.toString());
//            }
//        }
        
        
        //Actualizar paciente por id || FUNCIONA CORRECTAMENTE || Nota: Hay que enviarle todos los datos nuevos y viejos, porque si no, los  datos viejos no enviados, los borra
//        Paciente pacientePrueba = new Paciente();
//        Paciente pacienteActualizado = new Paciente(2,"Ramon", 43532211, "Casa Termo", "2952331", true);
//        pacientePrueba.setIdPaciente(2);
//        pacientePrueba.setNombre("ramon");
//        pacientePrueba.setDni(461132111);
//        pacientePrueba.setDomicilio("CasaLCOA");
//        pacientePrueba.setTelefono("244232");
//        pacientePrueba.setEstado(true);
//        
//        pacienteData.actualizarPacientePorId(pacientePrueba);
//

        //Alta Logica FUNCIONA CORRECTAMENTE
      //  pacienteData.altaLogicaPaciente(10);
        
        //Baja Logica FUNCIONA CORRECTAMENTE
       // pacienteData.bajaLogicaPaciente(10);

        //Borrar paciente por id || FUNCIONA CORRECTAMENTE || NOTA: Valida si el usuario no existe
        
        //pacienteData.borrarPacientePorId(5);
        
        //////////////////////////
        //////Testeo Comidas//////
        //////////////////////////
        
        ComidaData comidaData = new ComidaData(conexion);
        
        Comida comida1 = new Comida(1, "Ensalada", "Simple ensalada de tomate y lechuga", 500, true);
        Comida comida2 = new Comida(2, "Ensalada Rusa", "Simple ensalada de papa, zanahoria, arvejas y mayonesa", 600, true);
        Comida comida3 = new Comida(3, "Chorizo a la pomarola", "Mortal cuando hace frio", 700, true);
        Comida comida4 = new Comida(4, "Asado", "Nunca puede faltar un domingo", 1200, true);
        Comida comida5 = new Comida(5, "Ensalada de Aveeee", "Simple ensalada de papa y pollo", 450, true);
        
        //Crear //FUNCIONA
        
//        comidaData.crearComida(comida1);
//        comidaData.crearComida(comida2);
//        comidaData.crearComida(comida3);
//        comidaData.crearComida(comida4);
//        comidaData.crearComida(comida5);

        //Listar Comida //FUNCIONA
        
        
//        ArrayList<Comida> comidasBD =comidaData.listarComidas();
//        for(Comida comida: comidasBD){
//            System.out.println(comida.toString());
//        }
        //Buscar Comida por Id //FUNCIONA
        
//        Comida comidasBD =comidaData.buscarComidaPorID(4);
//        if(!(comidasBD == null) ){
//            System.out.println(comidasBD.toString());
//        }
        
        //Buscar Comida por nombre // FUNCIONA
        
//       ArrayList<Comida>  comidasBD = comidaData.buscarComidasPorNombre("Ensalada Rusa");
//        for(Comida comida : comidasBD){
//            System.out.println(comida.toString());
//        }
      
        //Actualizar comida por id

//        comidaData.actualizarComidaPorId(comida5);
        
        //Alta Logica // FUNCIONA
        //comidaData.altaLogicaComida(13);
        
        //Baja Logica // FUNCIONA
        //comidaData.bajaLogicaComida(3);
        
        //Borrar Comida por id // FUNCIONA
        //comidaData.borrarComidaPorId(3);
        
    }
}
