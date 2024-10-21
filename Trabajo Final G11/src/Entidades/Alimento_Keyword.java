package Entidades;


public class Alimento_Keyword {
    
    Alimento idAlimento;
    Keywords idKeyword;

    public Alimento_Keyword(Alimento idAlimento, Keywords idKeyword) {
        this.idAlimento = idAlimento;
        this.idKeyword = idKeyword;
    }

    public Alimento getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Alimento idAlimento) {
        this.idAlimento = idAlimento;
    }

    public Keywords getIdKeyword() {
        return idKeyword;
    }

    public void setIdKeyword(Keywords idKeyword) {
        this.idKeyword = idKeyword;
    }
        
    
}
