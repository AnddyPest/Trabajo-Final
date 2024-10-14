package Entidades;


public class DietaComida {
    
    int idDietaComida;
    Comida comida;
    Dieta dieta;
    boolean estado;

    public DietaComida() {
    }

    public DietaComida(Comida comida, Dieta dieta, boolean estado) {
        this.comida = comida;
        this.dieta = dieta;
        this.estado = estado;
    }

    public DietaComida(int idDietaComida, Comida comida, Dieta dieta, boolean estado) {
        this.idDietaComida = idDietaComida;
        this.comida = comida;
        this.dieta = dieta;
        this.estado = estado;
    }

        

    public int getId() {
        return idDietaComida;
    }

    public void setId(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
    
    
}
