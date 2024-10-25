
package Entidades.Handlers;

import Entidades.Alimento;
import Entidades.MenuDiario;


public class MenuDiario_Alimento_Handler {
    
    private MenuDiario idMenuDiario;
    private Alimento idAlimento;

    public MenuDiario_Alimento_Handler() {
    }

    public MenuDiario_Alimento_Handler(MenuDiario idMenuDiario, Alimento idAlimento) {
        this.idMenuDiario = idMenuDiario;
        this.idAlimento = idAlimento;
    }

    public MenuDiario getIdMenuDiario() {
        return idMenuDiario;
    }

    public void setIdMenuDiario(MenuDiario idMenuDiario) {
        this.idMenuDiario = idMenuDiario;
    }

    public Alimento getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Alimento idAlimento) {
        this.idAlimento = idAlimento;
    }

    
    
}
