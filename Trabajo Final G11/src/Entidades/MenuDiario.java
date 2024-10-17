package Entidades;

import java.util.List;


public class MenuDiario {
    
    private int idMenuDiario;
    private int dia;
    private List<RenglonDeMenu> comidas;
    private int caloriasDelMenu;
    private Dieta dieta;
    private boolean estado;

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

    public MenuDiario(int dia, List<RenglonDeMenu> comidas, int caloriasDelMenu, Dieta dieta, boolean estado) {
        this.dia = dia;
        this.comidas = comidas;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
        this.estado = estado;
    }

    public MenuDiario(int idMenuDiario, int dia, List<RenglonDeMenu> comidas, int caloriasDelMenu, Dieta dieta, boolean estado) {
        this.idMenuDiario = idMenuDiario;
        this.dia = dia;
        this.comidas = comidas;
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

    public List<RenglonDeMenu> getComidas() {
        return comidas;
    }

    public void setComidas(List<RenglonDeMenu> comidas) {
        this.comidas = comidas;
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
