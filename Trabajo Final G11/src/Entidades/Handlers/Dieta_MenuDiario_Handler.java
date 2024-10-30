
package Entidades.Handlers;

import Entidades.Dieta;
import Entidades.MenuDiario;
import java.time.LocalDate;
import java.util.Date;


public class Dieta_MenuDiario_Handler {
    
    private Dieta idDieta;
    private MenuDiario idMenuDiario;
    private LocalDate fecha;
    public Dieta_MenuDiario_Handler() {
    }

    public Dieta_MenuDiario_Handler(Dieta idDieta, MenuDiario idMenuDiario, LocalDate fecha) {
        this.idDieta = idDieta;
        this.idMenuDiario = idMenuDiario;
        this.fecha = fecha;
    }
    public Dieta_MenuDiario_Handler(Dieta idDieta, MenuDiario idMenuDiario) {
        this.idDieta = idDieta;
        this.idMenuDiario = idMenuDiario;
    }

    public Dieta getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Dieta idDieta) {
        this.idDieta = idDieta;
    }

    public MenuDiario getIdMenuDiario() {
        return idMenuDiario;
    }

    public void setIdMenuDiario(MenuDiario idMenuDiario) {
        this.idMenuDiario = idMenuDiario;
    }

    public LocalDate getFecha(){
        return fecha;
    }
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
    
    
}
