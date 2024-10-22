
package Entidades.Handlers;


public class Dieta_MenuDiario_Handler {
    
    private int idDieta;
    private int idMenuDiario;

    public Dieta_MenuDiario_Handler(int idDieta, int idMenuDiario) {
        this.idDieta = idDieta;
        this.idMenuDiario = idMenuDiario;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public int getIdMenuDiario() {
        return idMenuDiario;
    }

    public void setIdMenuDiario(int idMenuDiario) {
        this.idMenuDiario = idMenuDiario;
    }
    
    
}
