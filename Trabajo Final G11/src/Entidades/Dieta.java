package Entidades;

import java.time.LocalDate;
import java.util.List;


public class Dieta {
    
    private int idDieta;
    private String nombre;
    private Paciente idPaciente;
    private List<MenuDiario> menus;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private double pesoInicial;
    private double pesoFinal;
    private int totalCalorias;
    private boolean estadoDieta;

    public Dieta() {
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
    public Dieta(String nombre, Paciente idPaciente,List<MenuDiario> menus ,int totalCalorias, LocalDate fechaInicio, double pesoInicial, boolean estadoDieta) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.menus = menus;
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.estadoDieta = estadoDieta;
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
    public Dieta(String nombre, Paciente idPaciente,List<MenuDiario> menus ,int totalCalorias, LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estadoDieta) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.menus = menus;
        this.totalCalorias = totalCalorias;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estadoDieta = estadoDieta;
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
    public Dieta(int idDieta, String nombre, Paciente idPaciente,int totalCalorias ,List<MenuDiario> menus ,LocalDate fechaInicio, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estadoDieta) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.menus = menus;
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

    public List<MenuDiario> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDiario> menus) {
        this.menus = menus;
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
        return "Dieta= " + "\n\tidDieta=" + idDieta + " \n\tnombre=" + nombre + " \n\tidPaciente=" + idPaciente + " \n\tmenus=" + menus + " \n\tfechaInicio=" + fechaInicio + " \n\tfechaFinal=" + fechaFinal + ", \n\tpesoInicial=" + pesoInicial + ", \n\tpesoFinal=" + pesoFinal + ", \n\ttotalCalorias=" + totalCalorias + ", \n\testadoDieta=" + estadoDieta ;
    }

   
   
    
}
