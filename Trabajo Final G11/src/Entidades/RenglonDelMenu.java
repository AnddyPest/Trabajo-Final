
package Entidades;


public class RenglonDelMenu {
    
    private int idRenglonDeMenu;
    private Alimento alimento;
    private double cantidadGramos;
    private int subTotalCalorias;

    public RenglonDelMenu() {
    }

    public RenglonDelMenu(double cantidadGramos, int subTotalCalorias	) {
        this.cantidadGramos= cantidadGramos;
        this.subTotalCalorias	 = subTotalCalorias	;
    }

    public RenglonDelMenu(Alimento alimento, double cantidadGramos, int subTotalCalorias	) {
        this.alimento = alimento;
        this.cantidadGramos = cantidadGramos;
        this.subTotalCalorias	 = subTotalCalorias	;
    }

    public RenglonDelMenu(int idRenglonDeMenu, Alimento alimento, double cantdidadGramos, int subTotalCalorias	) {
        this.idRenglonDeMenu = idRenglonDeMenu;
        this.alimento = alimento;
        this.cantidadGramos = cantidadGramos;
        this.subTotalCalorias	 = subTotalCalorias	;
    }

    public int getIdRenglonDelMenu() {
        return idRenglonDeMenu;
    }

    public void setIdRenglonDelMenu(int idRenglonDeMenu) {
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

    public int getSubTotalCalorias() {
        return subTotalCalorias	;
    }

    public void setSubtotalCalorias(int subTotalCalorias) {
        this.subTotalCalorias	 = subTotalCalorias;
    }

    @Override
    public String toString() {
        return "RenglonDelMenu = " + "idRenglonDelMenu=" + idRenglonDeMenu + ", alimento=" + alimento + ", cantidadGramos=" + cantidadGramos + ", subTotalCalorias=" + subTotalCalorias ;
    }

    
    
    
    
}
