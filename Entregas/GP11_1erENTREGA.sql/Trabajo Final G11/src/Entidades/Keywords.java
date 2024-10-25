
package Entidades;


public class Keywords {
    
    private int idKeyword;
    private String keyword;

    public Keywords() {
    }

    public Keywords(String keyword) {
        this.keyword = keyword;
    }

    public Keywords(int idKeyword, String keyword) {
        this.idKeyword = idKeyword;
        this.keyword = keyword;
    }

    public int getIdKeyword() {
        return idKeyword;
    }

    public void setIdKeyword(int idKeyword) {
        this.idKeyword = idKeyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
}
