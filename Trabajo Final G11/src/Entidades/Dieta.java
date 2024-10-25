package Entidades;

import java.time.LocalDate;


public class Dieta {
    
    private int idDieta;
    private String nombre;
    private Paciente idPaciente;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private double pesoInicial;
    private double pesoFinal;
    private int totalCalorias;
    private boolean estadoDieta;

    public Dieta() {
    }
    public Dieta(String nombre,int totalCalorias, boolean estadoDieta) {
        this.nombre = nombre;        
        this.totalCalorias = totalCalorias;
        this.estadoDieta = estadoDieta;
    }
    public Dieta(String nombre, Paciente idPaciente ,int totalCalorias, boolean estadoDieta) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;        
        this.totalCalorias = totalCalorias;
        this.estadoDieta = estadoDieta;
    }  

    
    public Dieta(String nombre, Paciente idPaciente ,int totalCalorias, LocalDate fechaInicio, double pesoInicial, boolean estadoDieta) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;        
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.estadoDieta = estadoDieta;
    }
    public Dieta(String nombre, Paciente idPaciente ,int totalCalorias, LocalDate fechaInicio, double pesoInicial) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;        
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        
    }
     public Dieta(String nombre, Paciente idPaciente,int totalCalorias, LocalDate fechaInicio, double pesoInicial, double pesoFinal) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        
       
    }
     public Dieta(String nombre, Paciente idPaciente,int totalCalorias, LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
       
    }

    public Dieta(String nombre, Paciente idPaciente,int totalCalorias, LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estadoDieta) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estadoDieta = estadoDieta;
    }
   
    public Dieta(int idDieta, String nombre, Paciente idPaciente,int totalCalorias ,LocalDate fechaInicio, double pesoInicial, double pesoFinal) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.idPaciente = idPaciente;      
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
       
        
    }
    public Dieta(int idDieta, String nombre, Paciente idPaciente,int totalCalorias ,LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.idPaciente = idPaciente;      
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        
    }
    public Dieta(int idDieta, String nombre, Paciente idPaciente,int totalCalorias ,LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estadoDieta) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.idPaciente = idPaciente;      
        this.totalCalorias = totalCalorias;
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

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
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

    
    
    @Override
    public String toString() {
        return "Dieta= " + "\n\tidDieta=" + idDieta + " \n\tnombre=" + nombre + " \n\tidPaciente=" + idPaciente +  "\n\tfechaInicio=" + fechaInicio + " \n\tfechaFinal=" + fechaFinal + ", \n\tpesoInicial=" + pesoInicial + ", \n\tpesoFinal=" + pesoFinal + ", \n\ttotalCalorias=" + totalCalorias + ", \n\testadoDieta=" + estadoDieta ;
    }

   
   
    
}
