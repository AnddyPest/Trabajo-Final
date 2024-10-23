
package Entidades.Handlers;

import Entidades.Dieta;
import Entidades.MenuDiario;


public class Dieta_MenuDiario_Handler {
    
    private Dieta idDieta;
    private MenuDiario idMenuDiario;

    public Dieta_MenuDiario_Handler() {
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

 
    
    
}
