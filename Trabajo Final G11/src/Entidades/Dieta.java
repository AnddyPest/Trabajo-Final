package Entidades;

import java.time.LocalDate;


public class Dieta {
    
    int idDieta;
    String nombre;
    Paciente paciente;
    LocalDate fechaInicio;
    double pesoInicial;
    double pesoFinal;
    LocalDate fechaFinal;
    boolean estadoDieta;

    public Dieta() {
    }

    public Dieta(String nombre, Paciente paciente, boolean esrtadoDieta) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.estadoDieta = esrtadoDieta;
    }

    
    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicio, double pesoInicial, boolean estadoDieta) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.estadoDieta = estadoDieta;
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estadoDieta) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estadoDieta = estadoDieta;
    }

    public Dieta(int idDieta, String nombre, Paciente paciente, LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estadoDieta) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estadoDieta = estadoDieta;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isEstadoDieta() {
        return estadoDieta;
    }

    public void setEstadoDieta(boolean estadoDieta) {
        this.estadoDieta = estadoDieta;
    }
    
    
    
    
}
