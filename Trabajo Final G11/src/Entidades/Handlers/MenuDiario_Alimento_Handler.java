
package Entidades.Handlers;


public class MenuDiario_Alimento_Handler {
    
    private int idMenuDiario;
    private int idAlimento;

    public MenuDiario_Alimento_Handler(int idMenuDiario, int idAlimento) {
        this.idMenuDiario = idMenuDiario;
        this.idAlimento = idAlimento;
    }

    public int getIdMenuDiario() {
        return idMenuDiario;
    }

    public void setIdMenuDiario(int idMenuDiario) {
        this.idMenuDiario = idMenuDiario;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }
    
    
}
