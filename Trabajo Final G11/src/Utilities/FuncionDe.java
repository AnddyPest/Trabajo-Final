
package Utilities;
//
//import Persistencia.ComidaData;

import Entidades.Alimento;
import Entidades.Dieta;
import Entidades.Handlers.Alimento_Keyword_Handler;
import Entidades.Handlers.Dieta_MenuDiario_Handler;
import Entidades.Handlers.MenuDiario_Alimento_Handler;
import Entidades.MenuDiario;
import Entidades.Paciente;

import Persistencia.AlimentoData;
import Entidades.Keywords;
import Persistencia.DietaData;
import Persistencia.Handlers.Alimento_Keyword_Handler_DATA;
import Persistencia.Handlers.Dieta_MenuDiario_Handler_DATA;
import Persistencia.Handlers.MenuDiario_Alimento_Handler_DATA;
import Persistencia.KeywordData;
import Persistencia.MenuDiarioData;
import Persistencia.PacienteData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
public class FuncionDe {

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
        pacienteCreado.setEdad(resultados.getInt("edad"));
        pacienteCreado.setPesoActual(resultados.getDouble("pesoActual"));
        pacienteCreado.setPesoBuscado(resultados.getDouble("pesoBuscado"));
        pacienteCreado.setTelefono(resultados.getString("telefono"));
        pacienteCreado.setEstado(resultados.getBoolean("estado"));
        
        return pacienteCreado;
    } 
    public static MenuDiario_Alimento_Handler crearMenuDiario_Alimento_Handler(ResultSet resultados) throws SQLException{

        MenuDiario_Alimento_Handler handlerCreado = new MenuDiario_Alimento_Handler();
        Alimento alimento = new Alimento();
        MenuDiario menuDiario = new MenuDiario();
        alimento.setIdAlimento(resultados.getInt("idAlimento"));
        menuDiario.setIdMenuDiario(resultados.getInt("idMenuDiario"));
        handlerCreado.setIdAlimento(alimento);
        handlerCreado.setIdMenuDiario(menuDiario);
        
        return handlerCreado;
    } 
    public static Dieta_MenuDiario_Handler crearDieta_MenuDiario_Handler(ResultSet resultados) throws SQLException{

        Dieta_MenuDiario_Handler handlerCreado = new Dieta_MenuDiario_Handler();
        Dieta dieta = new Dieta();
        MenuDiario menuDiario = new MenuDiario();
        dieta.setIdDieta(resultados.getInt("idDieta"));
        menuDiario.setIdMenuDiario(resultados.getInt("idMenuDiario"));
        handlerCreado.setIdDieta(dieta);
        handlerCreado.setIdMenuDiario(menuDiario);
        handlerCreado.setFecha(resultados.getDate("fecha").toLocalDate());
        
        return handlerCreado;
    } 
    public static Alimento_Keyword_Handler crearAlimento_Keyword_Handler(ResultSet resultados) throws SQLException{

        Alimento_Keyword_Handler handlerCreado = new Alimento_Keyword_Handler();
        Alimento alimento = new Alimento();
        Keywords keywords = new Keywords();
        alimento.setIdAlimento(resultados.getInt("idAlimento"));
        keywords.setIdKeyword(resultados.getInt("idKeyword"));
        handlerCreado.setIdAlimento(alimento);
        handlerCreado.setIdKeyword(keywords);
        
        return handlerCreado;
    } 
   
    public static MenuDiario crearMenu(ResultSet resultados) throws SQLException{

        MenuDiario menuCreado = new MenuDiario();
        menuCreado.setIdMenuDiario(resultados.getInt("idMenuDiario"));
        menuCreado.setNombreMenu(resultados.getString("nombreMenu")); 
        //menuCreado.setDia(resultados.getInt("dia"));
        menuCreado.setCaloriasDelMenu(resultados.getInt("caloriasDelMenu"));
        menuCreado.setEstado(resultados.getBoolean("estado"));
        return menuCreado;
    }

    
    public static Keywords crearKeyword(ResultSet resultados) throws SQLException{
        Keywords keyCreada = new Keywords();
        keyCreada.setIdKeyword(resultados.getInt("idKeyword"));
        keyCreada.setKeyword(resultados.getString("keyword"));
        return keyCreada;
    }
    
    public static Alimento crearAlimento(ResultSet resultados) throws SQLException{
        Alimento alimentoCreado = new Alimento();
        alimentoCreado.setIdAlimento(resultados.getInt("idAlimento"));
        alimentoCreado.setNombre(resultados.getString("nombre"));
        alimentoCreado.setTipoComida(resultados.getString("tipoComida"));
        alimentoCreado.setCaloriasPor100g(resultados.getInt("caloriasPor100g"));
        alimentoCreado.setDetalle(resultados.getString("detalle"));
        alimentoCreado.setEstado(resultados.getBoolean("estado"));
        return alimentoCreado;
    }
    public static Dieta crearDieta(ResultSet resultados) throws SQLException{
        Dieta dietaCreada = new Dieta();
        dietaCreada.setIdDieta(resultados.getInt("idDieta"));
        dietaCreada.setNombre(resultados.getString("nombre"));
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(resultados.getInt("idPaciente"));
        dietaCreada.setIdPaciente(resultados.getInt("idPaciente"));  
        dietaCreada.setFechaInicio(resultados.getDate("fechaInicio").toLocalDate());
        dietaCreada.setFechaFinal(resultados.getDate("fechaFinal").toLocalDate());
        dietaCreada.setPesoInicial(resultados.getDouble("pesoInicial"));
        dietaCreada.setPesoFinal(resultados.getDouble("pesoFinal"));
        dietaCreada.setTotalCalorias(resultados.getInt("totalCalorias"));        
        dietaCreada.setEstadoDieta(resultados.getBoolean("estado"));
        return dietaCreada;
    }
    public static void validarSiExisteId(PacienteData metodo, int id) throws SQLException{
        if(metodo.buscarPacientePorID(id) == null){
                throw new SQLException();
            }
    }
    public static boolean validarSiExisteId(MenuDiario_Alimento_Handler_DATA metodo, int idMenuDiario, int idAlimento) throws SQLException{
        if(metodo.buscarHandler_MenuDiario_AlimentoPorIDS(idMenuDiario, idAlimento) == null){
                return false;
        } else{
            return true;
        }
    }
    public static boolean validarSiExisteId(Dieta_MenuDiario_Handler_DATA metodo, int idMenuDiario, int idDieta) throws SQLException{
        if(metodo.buscarDieta_MenuDiario_HandlerIDS(idDieta, idMenuDiario ) == null){
                return false;
        } else{
            return true;
        }
    }
    public static boolean validarSiExisteId(Alimento_Keyword_Handler_DATA metodo, int idKeyword, int idAlimento) throws SQLException{
        if(metodo.buscarAlimento_Keyword_HandlerIDS(idKeyword, idAlimento) == null){
                return false;
        } else{
            return true;
        }
    }
    
    public static void validarSiExisteId(MenuDiarioData metodo, int id) throws SQLException{
        if(metodo.buscarMenuPorID(id) == null){
                throw new SQLException();
            }
    }
    public static void validarSiExisteId(AlimentoData metodo, int id) throws SQLException{
        if(metodo.buscarAlimentoPorID(id) == null){
                throw new SQLException();
            }
    }
    public static void validarSiExisteId(DietaData metodo, int id) throws SQLException{
        if(metodo.buscarDietaPorID(id) == null){
                throw new SQLException();
            }
    }
    
    public static void validarSiExisteId(KeywordData metodo, int id) throws SQLException{
            if(metodo.buscarKeyporId(id) == null){
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
        
    public static void validarSiYaEstabaLogicamenteEnDichoEstado(MenuDiarioData metodo, int id,boolean estadoAValidar) throws SQLException{
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
    public static void validarSiYaEstabaLogicamenteEnDichoEstado(AlimentoData metodo, int id,boolean estadoAValidar) throws SQLException{
        if(estadoAValidar){
            if(metodo.buscarEstadoPorId(id) == true){
                throw new SQLException("El alimento ya está dada de ALTA");
            }
        }else{
            if(metodo.buscarEstadoPorId(id) == false){
                throw new SQLException("El alimento ya está dada de BAJA");
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
    
    public static ArrayList<String> sacarEspaciosYElementosVacios(ArrayList<String> elementos){
        ArrayList<String> elementosDevueltos = new ArrayList<>();
        
        for(String elemento : elementos){
            if (elemento != null && !elemento.trim().isEmpty()) {
                elementosDevueltos.add(elemento.trim());
            }
        }           
        return elementosDevueltos;        
        
    }
    public static String auxiliarParaArmarConsultaSQL(ArrayList<String> elementos){
        if (elementos.isEmpty()) {
             return ""; 
        }
        String armadorDeMensaje = "(";
        Iterator<String> iterador = elementos.iterator();
        while(iterador.hasNext()){
            armadorDeMensaje += "'" + iterador.next() + "'";
            if (iterador.hasNext()) {
                armadorDeMensaje += ", ";
            }
            
        }
        armadorDeMensaje += " )";
        return armadorDeMensaje;
        
    }
    //MEJORAR EL NOMBRE
    public static String construirSQLParaBuscarAlimentos(ArrayList<String> elementosQueSi, ArrayList<String> elementosQueNo) {
    ArrayList<String> elementosValidadosUtilizados = sacarEspaciosYElementosVacios(elementosQueSi);
    ArrayList<String> elementosNoUtilizadosValidados = sacarEspaciosYElementosVacios(elementosQueNo);
    
    String query = "";
    
    if (!elementosValidadosUtilizados.isEmpty()) {
        query = "SELECT\n" +
                "    a.idAlimento,\n" +
                "    a.nombre,\n" +
                "    a.tipoComida,\n" +
                "    a.caloriasPor100g,\n" +
                "    a.detalle,\n" +
                "    a.estado,\n" +
                "    GROUP_CONCAT(DISTINCT k_incluida.keyword SEPARATOR ', ') AS Incluye\n" +
                " FROM \n" +
                "    alimento a\n " +
                " JOIN\n " +
                "    alimento_keyword_handler ak_incluida ON a.idAlimento = ak_incluida.idAlimento\n " +
                " JOIN\n " +
                "    keywords k_incluida ON ak_incluida.idKeyword = k_incluida.idKeyword\n " +
                " WHERE k_incluida.keyword IN ";
        
        query += auxiliarParaArmarConsultaSQL(elementosValidadosUtilizados);
        
        if (!elementosNoUtilizadosValidados.isEmpty()) {
            query += " AND a.idAlimento NOT IN (\n" +
                    "         SELECT\n" +
                    "             ak_excluida.idAlimento\n" +
                    "        FROM\n" +
                    "            alimento_keyword_handler ak_excluida\n" +
                    "        JOIN\n" +
                    "            keywords k_excluida ON ak_excluida.idKeyword = k_excluida.idKeyword\n" +
                    "        WHERE\n" +
                    "            k_excluida.keyword IN ";
            query += auxiliarParaArmarConsultaSQL(elementosNoUtilizadosValidados);
            query += ")";
        }
        
        query += "\nGROUP BY\n " +
                "    a.idAlimento\n " +
                "HAVING\n " +
                "    COUNT(DISTINCT k_incluida.keyword) = " + elementosValidadosUtilizados.size() + ";";
    } else if (!elementosNoUtilizadosValidados.isEmpty()) {
        query = "SELECT\n" +
                "    a.idAlimento,\n" +
                "    a.nombre,\n" +
                "    a.tipoComida,\n" +
                "    a.caloriasPor100g,\n" +
                "    a.detalle,\n" +
                "    a.estado\n" +
                " FROM \n" +
                "    alimento a\n " +
                " WHERE a.idAlimento NOT IN (\n" +
                "         SELECT\n" +
                "             ak_excluida.idAlimento\n" +
                "        FROM\n" +
                "            alimento_keyword_handler ak_excluida\n" +
                "        JOIN\n" +
                "            keywords k_excluida ON ak_excluida.idKeyword = k_excluida.idKeyword\n" +
                "        WHERE\n" +
                "            k_excluida.keyword IN ";
        query += auxiliarParaArmarConsultaSQL(elementosNoUtilizadosValidados);
        query += ")";
    }
    
    return query;
}

}
