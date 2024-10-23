package Entidades;

import java.util.ArrayList;


public class MenuDiario {
    //SE ELIMINÓ DIETA DIETA Y SE MIDIFICO EL LIST PARA QUE SEA UN ALIMENTO
    private int idMenuDiario;
    private String nombreMenu;
    private int dia; //LO ELIMINARIA Y DIRECTAMENTE AGREGAR DIA A DIA EN EL CALENDAR EN DIETA
    private int caloriasDelMenu;
    private boolean estado;

    public MenuDiario() {
    }

    public MenuDiario(String nombreMenu, int dia, int caloriasDelMenu) {
        this.nombreMenu = nombreMenu;
        this.dia = dia;
        this.caloriasDelMenu = caloriasDelMenu;
        
    }

    public MenuDiario(int idMenuDiario, String nombreMenu, int dia, int caloriasDelMenu, boolean estado) {
        this.idMenuDiario = idMenuDiario;
        this.nombreMenu = nombreMenu;
        this.dia = dia;
        this.caloriasDelMenu = caloriasDelMenu;        
        this.estado = estado;
    }

    public MenuDiario(int idMenuDiario, String nombreMenu, int dia, int caloriasDelMenu) {
        this.idMenuDiario = idMenuDiario;
        this.nombreMenu = nombreMenu;
        this.dia = dia;
        this.caloriasDelMenu = caloriasDelMenu;
        
    }

    public int getIdMenuDiario() {
        return idMenuDiario;
    }

    public void setIdMenuDiario(int idMenuDiario) {
        this.idMenuDiario = idMenuDiario;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getCaloriasDelMenu() {
        return caloriasDelMenu;
    }

    public void setCaloriasDelMenu(int caloriasDelMenu) {
        this.caloriasDelMenu = caloriasDelMenu;
    }

  
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }




    
}






    
    
    
    
