package Entidades;

import java.time.LocalDate;


public class Dieta {
    
    int idDieta = -1;
    String nombre;
    Paciente paciente;
    LocalDate fechaInicio;
    double pesoInicial;
    double pesoFinal;
    LocalDate fechaFinal;

    public Dieta() {
    }

    public Dieta(String nombre, Paciente paciente) {
        this.nombre = nombre;
        this.paciente = paciente;
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicio, double pesoInicial) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
    }

    public Dieta(int idDieta, String nombre, Paciente paciente, LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
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
    
    
    
    
}
