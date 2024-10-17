
package Entidades;


public class RenglonDeMenu {
    
    private int idRenglonDeMenu;
    private Alimento alimento;
    private double cantidadGramos;
    private int subtotalCalorias;

    public RenglonDeMenu() {
    }

    public RenglonDeMenu(double cantidadGramos, int subtotalCalorias) {
        this.cantidadGramos= cantidadGramos;
        this.subtotalCalorias = subtotalCalorias;
    }

    public RenglonDeMenu(Alimento alimento, double cantidadGramos, int subtotalCalorias) {
        this.alimento = alimento;
        this.cantidadGramos = cantidadGramos;
        this.subtotalCalorias = subtotalCalorias;
    }

    public RenglonDeMenu(int idRenglonDeMenu, Alimento alimento, double cantdidadGramos, int subtotalCalorias) {
        this.idRenglonDeMenu = idRenglonDeMenu;
        this.alimento = alimento;
        this.cantidadGramos = cantidadGramos;
        this.subtotalCalorias = subtotalCalorias;
    }

    public int getIdRenglonDeMenu() {
        return idRenglonDeMenu;
    }

    public void setIdRenglonDeMenu(int idRenglonDeMenu) {
        this.idRenglonDeMenu = idRenglonDeMenu;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public double getCantidadGramos() {
        return cantidadGramos;
    }

    public void setCantidadGramos(double cantidadGramos) {
        this.cantidadGramos = cantidadGramos;
    }

    public int getSubtotalCalorias() {
        return subtotalCalorias;
    }

    public void setSubtotalCalorias(int subtotalCalorias) {
        this.subtotalCalorias = subtotalCalorias;
    }

    @Override
    public String toString() {
        return "RenglonDeMenu = " + "idRenglonDeMenu=" + idRenglonDeMenu + ", alimento=" + alimento + ", cantidadGramos=" + cantidadGramos + ", subtotalCalorias=" + subtotalCalorias ;
    }

    
    
    
    
}
