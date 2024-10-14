package Entidades;


public class Comida {
    
    int idComida = -1;
    String nombre;
    String detalle;
    int cantidadCalorias;

    public Comida() {
    }

    public Comida(String nombre, String detalle, int cantidadCalorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantidadCalorias = cantidadCalorias;
    }

    public Comida(int idComida, String nombre, String detalle, int cantidadCalorias) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantidadCalorias = cantidadCalorias;
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
    
    
    
}
