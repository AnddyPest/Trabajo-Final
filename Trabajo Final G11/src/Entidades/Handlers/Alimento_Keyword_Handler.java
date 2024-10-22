
package Entidades.Handlers;


public class Alimento_Keyword_Handler {
    
    private int idKeyword;
    private int idAlimento;

    public Alimento_Keyword_Handler(int idKeyword, int idAlimento) {
        this.idKeyword = idKeyword;
        this.idAlimento = idAlimento;
    }

    public int getIdKeyword() {
        return idKeyword;
    }

    public void setIdKeyword(int idKeyword) {
        this.idKeyword = idKeyword;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }
    
    
}
