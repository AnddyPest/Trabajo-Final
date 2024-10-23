
package Entidades.Handlers;

import Entidades.Alimento;
import Entidades.Keywords;


public class Alimento_Keyword_Handler {
    
    private Keywords idKeyword;
    private Alimento idAlimento;

    public Alimento_Keyword_Handler() {
    }

    public Alimento_Keyword_Handler(Keywords idKeyword, Alimento idAlimento) {
        this.idKeyword = idKeyword;
        this.idAlimento = idAlimento;
    }

    public Keywords getIdKeyword() {
        return idKeyword;
    }

    public void setIdKeyword(Keywords idKeyword) {
        this.idKeyword = idKeyword;
    }

    public Alimento getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Alimento idAlimento) {
        this.idAlimento = idAlimento;
    }

   
    
    
}
