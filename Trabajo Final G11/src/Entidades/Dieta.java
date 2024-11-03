package Entidades;

import java.time.LocalDate;


public class Dieta {
    
    private int idDieta;
    private String nombre;
    private int idPaciente;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private Double pesoInicial;
    private Double pesoFinal;
    private int totalCalorias;
    private boolean estadoDieta;

    public Dieta() {
    }

    public Dieta(String nombre, int idPaciente, LocalDate fechaInicio, LocalDate fechaFinal, Double pesoInicial, Double pesoFinal, int totalCalorias) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
    }

    public Dieta(int idDieta, String nombre, int idPaciente, LocalDate fechaInicio, LocalDate fechaFinal, Double pesoInicial, Double pesoFinal, int totalCalorias, boolean estadoDieta) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
        this.estadoDieta = estadoDieta;
    }

    public Dieta(int idDieta, String nombre, int idPaciente, LocalDate fechaInicio, LocalDate fechaFinal, Double pesoInicial, Double pesoFinal, int totalCalorias) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
    }
    
     public Dieta(int idDieta, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, int totalCalorias, boolean estadoDieta) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.totalCalorias = totalCalorias;
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

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(Double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public int getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(int totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public boolean isEstadoDieta() {
        return estadoDieta;
    }

    public void setEstadoDieta(boolean estadoDieta) {
        this.estadoDieta = estadoDieta;
    }


    




}