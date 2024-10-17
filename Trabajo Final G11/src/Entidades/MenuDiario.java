package Entidades;

import java.util.List;


public class MenuDiario {
    
    private int idMenuDiario;
    private int dia;
    private int caloriasDelMenu;
    private Dieta dieta;
    private boolean estado;
    private List<RenglonDeMenu> idRenglonDeMenus;

    public MenuDiario() {
    }

    public MenuDiario(int dia, int caloriasDelMenu) {
        this.dia = dia;
        this.caloriasDelMenu = caloriasDelMenu;
    }

    public MenuDiario(int dia, int caloriasDelMenu, Dieta dieta) {
        this.dia = dia;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
    }

    public MenuDiario(int dia, int caloriasDelMenu, Dieta dieta, boolean estado) {
        this.dia = dia;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
        this.estado = estado;
    }

    public MenuDiario(int dia, List<RenglonDeMenu> idRenglonDeMenus, int caloriasDelMenu, Dieta dieta, boolean estado) {
        this.dia = dia;
        this.idRenglonDeMenus = idRenglonDeMenus;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
        this.estado = estado;
    }

    public MenuDiario(int idMenuDiario, int dia, List<RenglonDeMenu> idRenglonDeMenus, int caloriasDelMenu, Dieta dieta, boolean estado) {
        this.idMenuDiario = idMenuDiario;
        this.dia = dia;
        this.idRenglonDeMenus = idRenglonDeMenus;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
        this.estado = estado;
    }

    public int getIdMenuDiario() {
        return idMenuDiario;
    }

    public void setIdMenuDiario(int idMenuDiario) {
        this.idMenuDiario = idMenuDiario;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public List<RenglonDeMenu> getIdRenglonDeMenus() {
        return idRenglonDeMenus;
    }

    public void setIdRenglonDeMenus(List<RenglonDeMenu> idRenglonDeMenus) {
        this.idRenglonDeMenus = idRenglonDeMenus;
    }

    public int getCaloriasDelMenu() {
        return caloriasDelMenu;
    }

    public void setCaloriasDelMenu(int caloriasDelMenu) {
        this.caloriasDelMenu = caloriasDelMenu;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

//    public void alterarDietaDiaria(){
//        
//    }
//    public void generarDietaDiaria(){
//        
//    }
//    public void armarDietaDiaria(){
//        
//    }
//    public void addRenglon(){
//        
//    }
            
    
}
