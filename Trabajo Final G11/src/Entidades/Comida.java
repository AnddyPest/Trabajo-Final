package Entidades;


public class Comida {
    
    int idComida;
    String nombre;
    String detalle;
    int cantidadCalorias;
    boolean estadoComida;

    public Comida() {
    }

    public Comida(String nombre, String detalle, int cantidadCalorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantidadCalorias = cantidadCalorias;
        
    }

    public Comida(int idComida, String nombre, String detalle, int cantidadCalorias, boolean estadoComida) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantidadCalorias = cantidadCalorias;
        this.estadoComida = estadoComida;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantidadCalorias() {
        return cantidadCalorias;
    }

    public void setCantidadCalorias(int cantidadCalorias) {
        this.cantidadCalorias = cantidadCalorias;
    }

    public boolean isEstadoComida() {
        return estadoComida;
    }

    public void setEstadoComida(boolean estadoComida) {
        this.estadoComida = estadoComida;
    }

    @Override
    public String toString() {
        return "Datos de Comida:" + "idComida=" + idComida + ", nombre=" + nombre + ", detalle=" + detalle + ", cantidadCalorias=" + cantidadCalorias + ", estadoComida=" + estadoComida ;
    }
    
    
    
}
