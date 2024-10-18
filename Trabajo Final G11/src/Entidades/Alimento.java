
package Entidades;


public class Alimento {
    
    private int idAlimento;
    private String nombre;
    private String tipoComida;
    private int caloriasPor100g;
    private String detalle;
    private boolean estado;

    public Alimento() {
    }

    public Alimento(String nombre, String tipoComida, int caloriasPor100g, String detalle) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
    }
    
    

    public Alimento(String nombre, String tipoComida, int caloriasPor100g, String detalle, boolean estado) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
        this.estado = estado;
    }

    public Alimento(int idAlimento, String nombre, String tipoComida, int caloriasPor100g, String detalle, boolean estado) {
        this.idAlimento = idAlimento;
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
        this.estado = estado;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public int getCaloriasPor100g() {
        return caloriasPor100g;
    }

    public void setCaloriasPor100g(int caloriasPor100g) {
        this.caloriasPor100g = caloriasPor100g;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alimento= " + "idAlimento=" + idAlimento + ", nombre=" + nombre + ", tipoComida=" + tipoComida + ", caloriasPor100g=" + caloriasPor100g + ", detalle=" + detalle + ", estado=" + estado + '}';
    }
            
    
}
