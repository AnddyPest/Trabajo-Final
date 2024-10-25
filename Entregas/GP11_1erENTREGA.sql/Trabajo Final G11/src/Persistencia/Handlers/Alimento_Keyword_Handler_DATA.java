
package Persistencia.Handlers;

import Entidades.Alimento;
import Entidades.Handlers.Alimento_Keyword_Handler;

import Entidades.Keywords;

import Utilities.FuncionDe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class Alimento_Keyword_Handler_DATA {
    
    private final Connection conexion;

    public Alimento_Keyword_Handler_DATA(Connection conexion) {
        this.conexion = conexion;
    }
    
    public int createAlimento_Keyword_Handler( Keywords idKeyword, Alimento idAlimentoEnviado)  {
        boolean validado = false;   
        int codigoDevuelto = 1;
        System.out.println("ID RECIBIDO POR EL CREADOR DE RELACIONES ALIM//KEY "+idKeyword.getIdKeyword()+"ID ALIM: "+idAlimentoEnviado.getIdAlimento());
        //UNA VEZ CREADO EL METODO HAY QUE ACTUALIZAR ESTO Y AÑADIR UN IF AL TRY DE ABAJO
        List<Alimento_Keyword_Handler> listadoDeHandlers = this.listarAlimento_Keyword_Handler();

//        if(listadoDeHandlers.isEmpty()){           
//            validado = true;
//        } else{
//            for(Alimento_Keyword_Handler handlerRevisado: listadoDeHandlers){
//
//                if(handlerRevisado.getIdKeyword().getIdKeyword() != idKeyword.getIdKeyword() && handlerRevisado.getIdAlimento().getIdAlimento() != idAlimentoEnviado.getIdAlimento() ){                                       
//                    validado = true;
//
//                }else{
//                    validado = false;
//                    System.out.println("Validacion Metodo: createAlimento_Keyword_Handler|| Mensaje: Handlers ya relacionados no son admitidos\n");                    
//                    break;
//                }
//            }
//        }
        if(!validado){


            try {
                String query = "Insert into alimento_keyword_handler( idKeyword, idAlimento ) values( ? , ?  )";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, idKeyword.getIdKeyword());
                ps.setInt(2, idAlimentoEnviado.getIdAlimento());

                ps.executeUpdate();


                FuncionDe.mostrarMensajeCorrecto("createAlimento_Keyword_Handler", "El handler (relacion) entre Alimento y sus keywords ha sido creado");
                ps.close();
            }   catch (SQLException ex) {
                FuncionDe.mostrarMensajeError(ex, "createAlimento_Keyword_Handler", "Alimento_Keyword_Handler_DATA", "29");
                codigoDevuelto = ex.getErrorCode();
            }

        }
        return codigoDevuelto;

    }

    //READ
    //Listar Todos Los Pacientes

    public ArrayList<Alimento_Keyword_Handler> listarAlimento_Keyword_Handler(){
        ArrayList<Alimento_Keyword_Handler> handlersDevueltos = new ArrayList<>();
        try {            

            String Query= "Select * from alimento_keyword_handler";            
            PreparedStatement ps = conexion.prepareStatement(Query);

            ResultSet resultados = ps.executeQuery();

            while(resultados.next()){
                Alimento_Keyword_Handler handlerCreado = FuncionDe.crearAlimento_Keyword_Handler(resultados);

                handlersDevueltos.add(handlerCreado);
            }
            FuncionDe.mostrarMensajeCorrecto("listarAlimento_Keyword_Handler", "Todos los handlers (relaciones) han sido enviados correctamente");

            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError(ex, "listarAlimento_Keyword_Handler", "Alimento_Keyword_Handler_DATA", "80");
        }

        return handlersDevueltos;
    }

    //Listar Paciente por id

    public Alimento_Keyword_Handler buscarAlimento_Keyword_HandlerIDS(int idKeyword, int idAlimento){
        Alimento_Keyword_Handler handlerDevuelto = null;
        try {
            String query = "Select * from alimento_keyword_handler where idKeyword = ? AND idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt( 1, idKeyword );
            ps.setInt(2, idAlimento);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()){
                handlerDevuelto = FuncionDe.crearAlimento_Keyword_Handler(resultados);                
            }
            if(handlerDevuelto == null){
                throw new SQLException();
            }else{
                FuncionDe.mostrarMensajeCorrecto("buscarAlimento_Keyword_HandlerIDS", "Handler-Keyword-Alimento encontrado correctamente");
            }
            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo encontrar el registro Handler-Keyword-Alimento",ex, "buscarAlimento_Keyword_HandlerIDS", "Alimento_Keyword_Handler_DATA", "107");
        }

        return handlerDevuelto;
    }

    //UPDATE
    //actualizar paciente por id

    public void actualizarHandler_Keyword_AlimentoPorIDS(Alimento_Keyword_Handler handlerEnviado, Alimento_Keyword_Handler handlerViejo){
        //ANDRES: EN ESTOS METODOS AL ACTUALIZAR SOLAMENTE SUS IDS ES NECESARIO QUE ME ENVIES LAS VIEJAS PARA PODER BUSCAR CUAL ES LA QUE QUERES ACTUALZIAR
        try {
            if(FuncionDe.validarSiExisteId(this, handlerEnviado.getIdKeyword().getIdKeyword(), handlerEnviado.getIdAlimento().getIdAlimento())){
                throw new SQLException("Validacion linea 130: Ya existe una relacion con dichos ids y no se puede modificar ");
            }
            if(!FuncionDe.validarSiExisteId(this, handlerEnviado.getIdKeyword().getIdKeyword(), handlerEnviado.getIdAlimento().getIdAlimento())){
                throw new SQLException("Validacion linea 133: No se encontro handler con dichos ids");
            }else{
                String Query = "UPDATE alimento_keyword_handler SET alimento_keyword_handler.idKeyword = ? , alimento_keyword_handler.idAlimento = ? WHERE alimento_keyword_handler.idKeyword = ? AND alimento_keyword_handler.idAlimento = ?";
                PreparedStatement ps = conexion.prepareStatement(Query);
                ps.setInt(1, handlerEnviado.getIdKeyword().getIdKeyword());
                ps.setInt(2, handlerEnviado.getIdAlimento().getIdAlimento());
                ps.setInt(3, handlerViejo.getIdKeyword().getIdKeyword());
                ps.setInt(4, handlerViejo.getIdAlimento().getIdAlimento());
                ps.executeUpdate();
                ps.close();

                FuncionDe.mostrarMensajeCorrecto("actualizarHandler_Keyword_AlimentoPorIDS", "Handler actualizado con exito");
            }


        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo actualizar al Handler_Keyword_Alimento PorIDS por sus Id",ex , "actualizarHandler_Keyword_AlimentoPorIDS", "Alimento_Keyword_Handler_DATA", "160");

        }
    }


    //DELETE



    //borrar paciente por id
    public void borrarAlimento_Keyword_HandlerPorIds(int idKeyword, int idAlimento){

        try {
            FuncionDe.validarSiExisteId(this, idKeyword,idAlimento);

            String Query = "DELETE FROM alimento_keyword_handler WHERE alimento_keyword_handler.idKeyword = ? AND alimento_keyword_handler.idAlimento = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, idKeyword);
            ps.setInt(2, idAlimento);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("borrarAlimento_Keyword_HandlerPorIds", "Alimento_Keyword_Handler eliminado con exito");


        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo borrar el Alimento_Keyword_Handler",ex, "borrarAlimento_Keyword_HandlerPorIds", "Alimento_Keyword_Handler_DATA", "246");
        }

    }
}
