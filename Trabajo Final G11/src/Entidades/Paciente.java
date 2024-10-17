package Entidades;


public class Paciente {
    
    private int idPaciente;
    private String nombre;
    private int dni;
    private int edad; 
    private int telefono;
    private double pesoActual;
    private double pesoBuscado;
    private boolean estado;

    public Paciente() {
    }

    public Paciente(String nombre, int dni, int edad, int telefono, double pesoActual, double pesoBuscado) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
    }

    public Paciente(String nombre, int dni, int edad, int telefono, double pesoActual, double pesoBuscado, boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.estado = estado;
    }

    public Paciente(int idPaciente, String nombre, int dni, int edad, int telefono, double pesoActual, double pesoBuscado, boolean estado) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.estado = estado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public double getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(double pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean seAcercaAlPeso(Dieta dieta){

        boolean seAcercaPesoBuscado = (dieta.getPesoInicial() > pesoBuscado && pesoActual <= pesoBuscado) ||
                              (dieta.getPesoFinal() < pesoBuscado && pesoActual >= pesoBuscado);
        return seAcercaPesoBuscado;
    }
    @Override
    public String toString() {
        return "Paciente= " + "idPaciente=" + idPaciente + ", nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", telefono=" + telefono + ", pesoActual=" + pesoActual + ", pesoBuscado=" + pesoBuscado + ", estado=" + estado ;
    }

   
    
    

    

    
    
    
    
    
}
