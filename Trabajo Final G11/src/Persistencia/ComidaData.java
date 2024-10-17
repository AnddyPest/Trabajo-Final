//package Persistencia;
//
//import Entidades.Comida;
//import Entidades.FuncionDe;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//
////OBSOLETO 
//public class ComidaData {
//    
//    Connection conexion ;
//    public ComidaData(Connection conexion){
//        this.conexion = conexion;
//    }
//    
//     public int crearComida(Comida comidaEnviada)  {
//        boolean validado = false;   
//        int codigoDevuelto = 1;
//        //UNA VEZ CREADO EL METODO HAY QUE ACTUALIZAR ESTO Y AÑADIR UN IF AL TRY DE ABAJO
//        List<Comida> comidas = this.listarComidas();
//        
//        if(comidas.isEmpty()){           
//            validado = true;
//        } else{
//            for(Comida comidaRevisada: comidas){
//                
//                if(!comidaRevisada.getNombre().equals(comidaEnviada.getNombre()) ){                                       
//                    validado = true;
//                    
//                }else{
//                    validado = false;
//                    System.out.println("Validacion Metodo: CrearComida || Mensaje: Comidas con nombres identicos no son admitidas\n");                    
//                    break;
//                }
//            }
//        }
//        if(validado){
//           
//        
//            try {
//                String query = "Insert into comida( nombre, detalle, cantCalorias,estado) values( ? , ? , ? , ? )";
//
//                PreparedStatement ps = conexion.prepareStatement(query);
//                ps.setString(1, comidaEnviada.getNombre());
//                ps.setString(2, comidaEnviada.getDetalle());
//                ps.setInt(3, comidaEnviada.getCantidadCalorias());
//                ps.setBoolean(4, true);                
//                ps.executeUpdate();
//
//                FuncionDe.mostrarMensajeCorrecto("Crear Comida", "La comida ha sido añadida");
//                ps.close();
//            }   catch (SQLException ex) {
//                FuncionDe.mostrarMensajeError(ex, "Crear comida", "ComidaData", "20");
//                codigoDevuelto = ex.getErrorCode();
//            }
//        
//        }
//        return codigoDevuelto;
//       
//    }
//    
//    //READ
//    //Listar Todos Los Pacientes
//    
//    public ArrayList<Comida> listarComidas(){
//        ArrayList<Comida> comidasDevueltas = new ArrayList<>();
//        try {            
//            
//            String Query= "Select * from comida";            
//            PreparedStatement ps = conexion.prepareStatement(Query);
//            
//            ResultSet resultados = ps.executeQuery();
//            
//            while(resultados.next()){
//                Comida comidaCreada = FuncionDe.crearComida(resultados);
//                
//                comidasDevueltas.add(comidaCreada);
//            }
//            FuncionDe.mostrarMensajeCorrecto("Listar Comidas", "Todas las comidas han sido enviados correctamente");
//            
//            resultados.close();
//            ps.close();
//        } catch (SQLException ex) {
//            FuncionDe.mostrarMensajeError(ex, "Listar Comidas", "ComidaData", "69");
//        }
//        
//        return comidasDevueltas;
//    }
//    
//    //Listar Paciente por id
//    
//    public Comida buscarComidaPorID(int id){
//        Comida comidaDevuelta = null;
//        try {
//            String query = "Select * from comida where idComida = ?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt( 1, id );
//            ResultSet resultados = ps.executeQuery();
//            while(resultados.next()){
//                comidaDevuelta = FuncionDe.crearComida(resultados);                
//            }
//            if(comidaDevuelta == null){
//                throw new SQLException();
//            }else{
//                FuncionDe.mostrarMensajeCorrecto("buscarComidaPorId", "Comida encontrada correctamente");
//            }
//            resultados.close();
//            ps.close();
//        } catch (SQLException ex) {
//            FuncionDe.mostrarMensajeError("No se pudo encontrar el registro",ex, "buscarComidaPorId", "ComidaData", "96");
//        }
//        
//        return comidaDevuelta;
//    }
//    //Listar Paciente por nombre
//    public ArrayList<Comida> buscarComidasPorNombre(String nombreEnviado){
//        ArrayList<Comida> comidasEncontradas = new ArrayList<>();
//        try {            
//            String query = "Select * from comida where comida.nombre = ?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setString(1, nombreEnviado.trim().toLowerCase());
//            ResultSet resultados = ps.executeQuery();
//            while(resultados.next()){
//                Comida comida = FuncionDe.crearComida(resultados);
//                comidasEncontradas.add(comida);
//            }
//            if(!comidasEncontradas.isEmpty()){
//                FuncionDe.mostrarMensajeCorrecto("buscarComidasPorNombre", "Comidas con nombre: " + nombreEnviado + " enviadas correctamente");
//            } else{
//                throw new SQLException();
//            }
//            resultados.close();
//            ps.close();
//            
//        } catch (SQLException ex) {
//            FuncionDe.mostrarMensajeError("No se encontraron comidas con dicho nombre",ex, "buscarComidasPorNombre", "ComidaData", "120");
//        }
//        
//        return comidasEncontradas;
//        
//    }
//    //UPDATE
//    //actualizar paciente por id
//    
//    public void actualizarComidaPorId(Comida comidaEnviada){
//        
//        try {
//            //REVISAR SI FUNCIONA
//            FuncionDe.validarSiExisteId(this, comidaEnviada.getIdComida());
//            
//            String Query = "UPDATE comida SET comida.nombre = ?,comida.detalle = ? ,comida.cantCalorias = ?,comida.estado = ? WHERE comida.idComida = ?";
//            PreparedStatement ps = conexion.prepareStatement(Query);
//            ps.setString(1, comidaEnviada.getNombre());
//            ps.setString(2, comidaEnviada.getDetalle());
//            ps.setInt(3, comidaEnviada.getCantidadCalorias());
//            ps.setBoolean(4, comidaEnviada.isEstadoComida());
//            ps.setInt(5, comidaEnviada.getIdComida());
//
//            ps.executeUpdate();
//            ps.close();
//
//            FuncionDe.mostrarMensajeCorrecto("actualizarComidaPorId", "Comida actualizada con exito");
//                    
//                        
//        } catch (SQLException ex) {
//            FuncionDe.mostrarMensajeError(ex, "actualizarComidaPorId", "ComidaData", "149");
//        }
//    }
//    
//        
//    //DELETE    
//     //buscar por estado individual
//    public boolean buscarEstadoPorId(int id){
//        Comida resultadoEstado = null;
//        try {
//            FuncionDe.validarSiExisteId(this, id);
//            String query = "SELECT comida.estado FROM comida WHERE comida.idComida = ?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, id);
//            ResultSet resultados = ps.executeQuery();
//            while(resultados.next()){
//                resultadoEstado = new Comida();
//                resultadoEstado.setEstadoComida(resultados.getBoolean("estado"));
//            }
//            FuncionDe.mostrarMensajeCorrecto("BuscarEstadoPorId", "Estado Logico de la comida enviada correctamente");
//        } catch (SQLException ex) {
//           FuncionDe.mostrarMensajeError("No se pudo enviar el estado logico de la comida", ex, "BuscarEstadoPorID", "ComidaData", "177");
//        }
//        return resultadoEstado.isEstadoComida();
//    }
//    //Alta logica
//    public void altaLogicaComida(int id){
//        
//        try {
//            FuncionDe.validarSiExisteId(this, id);
//            FuncionDe.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, true);
//            String Query = "UPDATE comida SET comida.estado = ? WHERE comida.idComida = ?";
//            PreparedStatement ps = conexion.prepareStatement(Query);
//            ps.setBoolean(1, true);
//            ps.setInt(2, id);
//            ps.executeUpdate();
//            ps.close();
//            FuncionDe.mostrarMensajeCorrecto("AltaLogicaComida", "Comida dada de Alta correctamente");
//        } catch (SQLException ex) {
//            FuncionDe.mostrarMensajeError("No se pudo dar el alta logica", ex, "AltaLogicaComida", "ComidaData", "196");
//        }
//    }
//   
//    //baja logica 
//    public void bajaLogicaComida(int id){
//        
//        try {
//            FuncionDe.validarSiExisteId(this, id);
//            FuncionDe.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, false);
//            String Query = "UPDATE comida SET comida.estado = ? WHERE comida.idComida = ?";
//            PreparedStatement ps = conexion.prepareStatement(Query);
//            ps.setBoolean(1, false);
//            ps.setInt(2, id);
//            ps.executeUpdate();
//            ps.close();
//            FuncionDe.mostrarMensajeCorrecto("BajaLogicaComida", "Comida dada de Baja correctamente");
//        } catch (SQLException ex) {
//            FuncionDe.mostrarMensajeError("No se pudo dar la baja logica", ex, "BajaLogicaComida", "ComidaData", "214");
//        }
//    }
//   
//    
//    //borrar paciente por id
//    public void borrarComidaPorId(int id){
//        
//        try {
//            FuncionDe.validarSiExisteId(this, id);
//            
//            String Query = "DELETE FROM comida WHERE comida.idComida = ?";
//            PreparedStatement ps = conexion.prepareStatement(Query);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//            ps.close();
//            FuncionDe.mostrarMensajeCorrecto("borrarComidaPorId", "Comida eliminada con exito");
//                
//            
//        } catch (SQLException ex) {
//            FuncionDe.mostrarMensajeError("No se pudo borrar la comida",ex, "BorrarComidaPorId", "ComidaData", "233");
//        }
//        
//    }
//    
//    
//    
//}
