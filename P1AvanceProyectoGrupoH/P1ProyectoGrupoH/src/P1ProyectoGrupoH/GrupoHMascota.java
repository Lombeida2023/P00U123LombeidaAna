package P1ProyectoGrupoH;

import java.util.List;
import java.util.Scanner;

public class GrupoHMascota {

    ////// Atributos 
    private String tipoMascota;
    private String nombre;
    private String genero;
    private String raza;
    private int nVacunas;

    ////// Constructor
    public GrupoHMascota(String tipoMascota, String nombre, String genero, String raza, int nVacunas) {
        this.tipoMascota = tipoMascota;
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.nVacunas = nVacunas;
    }

    // Getters y Setters
    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNVacunas() {
        return nVacunas;
    }

    public void setNVacunas(int nVacunas) {
        this.nVacunas = nVacunas;
    }

    @Override
    public String toString() {
        return "===========================\n" +
               "MOSTRAR DATOS DE LA MASCOTA:\n" +
               "===========================\n" +
               "TIPO DE MASCOTA : " + tipoMascota + "\n" +
               "NOMBRE : " + nombre + "\n" +
               "GENERO : " + genero + "\n" +
               "RAZA : " + raza + "\n" +
               "NUMERO DE VACUNAS : " + nVacunas + "\n";
    }
    
  
}
