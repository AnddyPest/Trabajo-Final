package VistasInicio;

import Entidades.Alimento;
import Entidades.Dieta;
import Utilities.Conexion;
import java.sql.Connection;
import Entidades.Paciente;
import Persistencia.AlimentoData;
import Persistencia.DietaData;

import Persistencia.PacienteData;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


public class TestClass {

    public static void main(String args[]) {
        
        Connection conexion = Conexion.getConexion();
        
        ////////////////////////////
        //////Testeo Pacientes//////
        ////////////////////////////
        
        PacienteData pacienteData = new PacienteData(conexion);
//
        Paciente paciente1 = new Paciente(1,"maximo", 44, 21, "446503175",75, 78);
        Paciente paciente2 = new Paciente("ramon", 33, 25, "33411",75, 79);
        Paciente paciente3 = new Paciente("tomas", 45, 23, "4465033",72, 71);
        Paciente paciente4 = new Paciente(4,"maximoasdsd", 4667, 11, "546503175",65, 78);
       
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
        
//        Paciente pacienteEncontrado = pacienteData.buscarPacientePorID(12);
//        if(!(pacienteEncontrado == null)){
//            System.out.println(pacienteEncontrado.toString());
//        }       
        
        //Buscar paciente por nombre || FUNCIONA CORRECTAMENTE || NOTA: Mismo caso que el anterior, validar si llega null
        
//        ArrayList<Paciente> pacientesRecibidos = pacienteData.buscarPacientesPorNombre(" maximo sd");
//        if(!pacientesRecibidos.isEmpty()){
//            for(Paciente paciente: pacientesRecibidos){
//                System.out.println(paciente.toString());
//            }
//        }
        
        
        //Actualizar paciente por id || FUNCIONA CORRECTAMENTE || Nota: Hay que enviarle todos los datos nuevos y viejos, porque si no, los  datos viejos no enviados, los borra
//        Paciente pacientePrueba = new Paciente();
//        Paciente pacienteActualizado = new Paciente(2,"ramon", 33, 25, "33411",75, 79);
//        pacientePrueba.setIdPaciente(2);
//        pacientePrueba.setNombre("ramon");
//        pacientePrueba.setDni(461132111);        
//        pacientePrueba.setTelefono("244232");
//        pacientePrueba.setEstado(true);
//        
//        pacienteData.actualizarPacientePorId(pacientePrueba);


        //Alta Logica FUNCIONA CORRECTAMENTE
//        pacienteData.altaLogicaPaciente(2);
        
        //Baja Logica FUNCIONA CORRECTAMENTE
//        pacienteData.bajaLogicaPaciente(2);

        //Borrar paciente por id || FUNCIONA CORRECTAMENTE || NOTA: Valida si el usuario no existe
        
        //pacienteData.borrarPacientePorId(5);
        
        //////////////////////////
        //////Testeo Alimentos////
        //////////////////////////
        
        AlimentoData alimentoData = new AlimentoData(conexion);
        
        //CREAR ALIMENTO || Correcto
//        Alimento alimento1 = new Alimento("Ensalada rusa", "Almuerzo", 230, "PAPA zanahoria y nose que mas");
//        alimentoData.crearAlimento(alimento1);
        
        //Listar alimentos || Correcto
//        for(Alimento alimento : alimentoData.listarAlimentos()){
//            System.out.println(alimento.toString());
//        }
        
        //BUSCAR ALIMENTOS POR ID || Correcto
        //System.out.println(alimentoData.buscarAlimentoPorID(3));
        
        //Buscar Alimento Por Nombre || Correcto
//        System.out.println(alimentoData.buscarAlimentoPorNombre("Ensalada rusa "));
        
        //Actualizar Alimneto Por Id || Correcto
        
//        Alimento alimentoActualizado = new Alimento(2,"Ensalada Rusa", "Cena", 120, "Una simple ensalada con papa, zanahoria y mayonesa", true);
//        alimentoData.actualizarAlimentoPorId(alimentoActualizado);
        
        //Buscar Estado Por ID || Correcto
        
//        System.out.println(alimentoData.buscarEstadoPorId(2));
        
        
        //Alta logica ALimentos || Correcto
        
      //  alimentoData.altaLogicaAlimento(9);
        
        //Baja logica ALimentos || Correcto
        
       // alimentoData.bajaLogicaAlimento(9);
        
        //Borrar Alimento por id || Correcto
        
       // alimentoData.borrarAlimentoPorId(10);
        
        ////////////////////////////
        //////Testeo Dietas/////////
        ////////////////////////////
        
        DietaData dietaData = new DietaData(conexion);
        //Crear Dieta || CORRECTO
//        
//        Dieta dieta1 = new Dieta("arvejas2", paciente3, LocalDate.of(2024, Month.MARCH, 3), LocalDate.of(2025, Month.MARCH, 1), 73.4 , 1400);
//        dietaData.crearDieta(dieta1);
        
        //Listar dietas || Correcto
//        ArrayList<Dieta> dietasEnviadas = dietaData.listarDietas();
//        for(Dieta dieta: dietasEnviadas){
//            System.out.println(dieta);
//        }

        //buscar dietas por id || Correcto
        
//        Dieta dieta = dietaData.buscarDietaPorID(12);
//        System.out.println(dieta);

        //buscar dietas por nombre || Correcto
        
//        ArrayList<Dieta> dieta = dietaData.buscarDietasPorNombre("arvejass ");
//        for(Dieta dieta1 : dieta){
//            System.out.println(dieta1);
//        }
        //actualizar dieta por id || Correcto
//        
//        Dieta dieta1 = new Dieta(2,"arvejas2 Con arroz", paciente4, LocalDate.of(2024, Month.MARCH, 3), LocalDate.of(2025, Month.MARCH, 1), 73.4,20.0, 1700);
//        dietaData.actualizarDietaPorId(dieta1);

        //alta logica || Correcto
        //dietaData.altaLogicaDieta(1);
        
        
        //baja logica || Correcto
        
        //dietaData.bajaLogicaDieta(1);
                
        //borrar dieta || Correcto
        
       // dietaData.borrarDietaPorId(1);
       
       ////////////////////////////
       //////Testeo menuDiario/////
       ////////////////////////////
       
       
       
       
        ///////////////////////////
        //////Testeo Keywords//////
        ///////////////////////////
       
        
        
        
        ///////////////////////////////////////////
        //////Testeo dieta-menudiario-handler//////
        ///////////////////////////////////////////
        
       
        
        
        ///////////////////////////////////////////
        //////Testeo menudiario-alimento-handler///
        ///////////////////////////////////////////
        
        
        ////////////////////////////////////////
        //////Testeo alimento-keyword-handler///
        ////////////////////////////////////////
    }
}
