package Persistencia;

import Utilities.FuncionDe;
import Entidades.MenuDiario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class MenuDiarioData {

    private final Connection conexion;

    public MenuDiarioData(Connection conexion) {
        this.conexion = conexion;
    }

    public int crearMenuDiario(MenuDiario menuDiarioEnviada) {
        //CAMBIAR A FALSE SI SE LLEGA A VALIDAR
        boolean validado = true;
        int codigoDevuelto = 1;
        if (validado) {
            try {
                String query = "Insert into menudiario( nombreMenu, caloriasDelMenu, estado ) values(  ? , ? , ? )";

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, menuDiarioEnviada.getNombreMenu());
                //ps.setInt(2, menuDiarioEnviada.getDia());
                ps.setInt(2, menuDiarioEnviada.getCaloriasDelMenu());
                ps.setBoolean(3, true);
                ps.executeUpdate();

                FuncionDe.mostrarMensajeCorrecto("Crear Menu Diario", "El menu ha sido añadida");
                ps.close();
            } catch (SQLException ex) {
                FuncionDe.mostrarMensajeError(ex, "Crear Menu Diario", "MenuDiarioData", "22");
                codigoDevuelto = ex.getErrorCode();
            }

        }
        return codigoDevuelto;

    }

    //READ
    //Listar Todos Los Pacientes
    public ArrayList<MenuDiario> listarMenus() {
        ArrayList<MenuDiario> menusDevueltos = new ArrayList<>();
        try {

            String Query = "SELECT * FROM menudiario";
            PreparedStatement ps = conexion.prepareStatement(Query);

            ResultSet resultados = ps.executeQuery();

            while (resultados.next()) {
                MenuDiario menuCreado = FuncionDe.crearMenu(resultados);

                menusDevueltos.add(menuCreado);
            }
            FuncionDe.mostrarMensajeCorrecto("Listar Menus", "Todos los menus han sido enviados correctamente");

            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se puede listar los menus", ex, "Listar Menus", "MenuDiarioData", "51");
        }

        return menusDevueltos;
    }
    
    public ArrayList<MenuDiario> listarMenusActivos() {
        ArrayList<MenuDiario> menusDevueltos = new ArrayList<>();
        try {

            String Query = "SELECT * FROM menudiario WHERE estado = 1";
            PreparedStatement ps = conexion.prepareStatement(Query);

            ResultSet resultados = ps.executeQuery();

            while (resultados.next()) {
                MenuDiario menuCreado = FuncionDe.crearMenu(resultados);

                menusDevueltos.add(menuCreado);
            }
            FuncionDe.mostrarMensajeCorrecto("Listar Menus", "Todos los menus han sido enviados correctamente");

            resultados.close();
            ps.close();
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se puede listar los menus", ex, "Listar Menus", "MenuDiarioData", "51");
        }

        return menusDevueltos;
    }

    //Listar Paciente por id
    public MenuDiario buscarMenuPorID(int id) {
    MenuDiario MenuDevuelto = null;
    try {
        String query = "SELECT * FROM menudiario WHERE menudiario.idMenuDiario = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet resultados = ps.executeQuery();
        
        if (resultados.next()) {
            MenuDevuelto = FuncionDe.crearMenu(resultados);
        }

        resultados.close();
        ps.close();

        if (MenuDevuelto != null) {
            FuncionDe.mostrarMensajeCorrecto("buscarMenuPorId", "Menu encontrado correctamente");
        } else {
            throw new SQLException("No se pudo encontrar el registro");
        }

    } catch (SQLException ex) {
        FuncionDe.mostrarMensajeError("No se pudo encontrar el registro", ex, "buscarMenuPorId", "MenuData", "78");
    }
    return MenuDevuelto;
}


    public MenuDiario buscarMenuPorNombre(String nombreEnviado) {
        MenuDiario menuEncontrado = null;
        try {
            String query = "Select * from menudiario where menudiario.nombreMenu = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombreEnviado.trim());
            ResultSet resultados = ps.executeQuery();
            while (resultados.next()) {
                menuEncontrado = FuncionDe.crearMenu(resultados);

            }
            if (menuEncontrado == null) {
                FuncionDe.mostrarMensajeCorrecto("buscarMenuPorNombre", "Menu con nombre: " + nombreEnviado + " enviado correctamente");
            } else {
                throw new SQLException();
            }
            resultados.close();
            ps.close();

        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se encontraron Menus con dicho nombre", ex, "buscarMenuPorNombre", "MenuDiarioData", "131");
        }

        return menuEncontrado;
    }
    //UPDATE
    //actualizar paciente por id

    public void actualizarMenuPorId(MenuDiario menuEnviado) {

        try {
            //REVISAR SI FUNCIONA
            FuncionDe.validarSiExisteId(this, menuEnviado.getIdMenuDiario());
            String Query = "UPDATE menudiario SET   menudiario.caloriasDelMenu = ?, menudiario.estado = ? WHERE menuDiario.idMenu = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            //ps.setInt(1, menuEnviado.getDia());
            ps.setInt(1, menuEnviado.getCaloriasDelMenu());
            //ps.setInt(3, menuEnviado.getDieta().getIdDieta());
            ps.setBoolean(2, menuEnviado.isEstado());
            ps.setInt(3, menuEnviado.getIdMenuDiario());
            ps.executeUpdate();
            ps.close();

            FuncionDe.mostrarMensajeCorrecto("actualizarMenuPorId", "Menu actualizado con exito");

        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo actualizar el menu", ex, "actualizarMenuPorId", "MenuDiarioData", "105");
        }
    }

    //DELETE    
    //buscar por estado individual
    public boolean buscarEstadoPorId(int id) {
        MenuDiario resultadoEstado = null;
        try {
            FuncionDe.validarSiExisteId(this, id);
            String query = "SELECT estado FROM menudiario WHERE menudiario.idMenuDiario= ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultados = ps.executeQuery();
            while (resultados.next()) {
                resultadoEstado = new MenuDiario();
                resultadoEstado.setEstado(resultados.getBoolean("estado"));
            }
            FuncionDe.mostrarMensajeCorrecto("BuscarEstadoPorId", "Estado Logico del menu enviado correctamente");
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo enviar el estado logico del menu", ex, "BuscarEstadoPorID", "MenuDiarioData", "132");
        }
        return resultadoEstado.isEstado();
    }

    //Alta logica
    public void altaLogicaMenuDiario(int id) {

        try {
            FuncionDe.validarSiExisteId(this, id);
            FuncionDe.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, true);
            String Query = "UPDATE menudiario SET menudiario.estado = ? WHERE menudiario.idMenuDiario= ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("altaLogicaMenuDiario", "Menu diario dado de Alta correctamente");
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo dar el alta logica", ex, "altaLogicaMenuDiario", "MenuDiarioData", "151");
        }
    }

    //baja logica 
    public void bajaLogicaMenuDiario(int id) {

        try {
            FuncionDe.validarSiExisteId(this, id);
            FuncionDe.validarSiYaEstabaLogicamenteEnDichoEstado(this, id, false);
            String Query = "UPDATE menudiario SET menudiario.estado = ? WHERE menudiario.idMenuDiario = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("BajaLogicaMenuDiario", "Menu Diario dado de Baja correctamente");
        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo dar la baja logica", ex, "BajaLogicaMenuDiario", "MenuDiarioData", "169");
        }
    }

    //borrar paciente por id
    public void borrarMenuDiarioPorId(int id) {

        try {
            FuncionDe.validarSiExisteId(this, id);

            String Query = "DELETE FROM menudiario WHERE menudiario.idMenuDiario = ?";
            PreparedStatement ps = conexion.prepareStatement(Query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            FuncionDe.mostrarMensajeCorrecto("borrarMenuDiarioPorId", "Menu Diario eliminado con exito");

        } catch (SQLException ex) {
            FuncionDe.mostrarMensajeError("No se pudo borrar el menu diario", ex, "borrarMenuDiarioPorId", "MenuDiarioData", "187");
        }

    }
}
