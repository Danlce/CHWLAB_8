package main;

import java.lang.String;

public class Estudiantes {
	private String nombre;
    private String cedula;
    private String carrera;
    private String sexo;
    private double indiceAcademico;

    public Estudiantes(String nombre, String cedula, String carrera, double indiceAcademico, String sexo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.carrera = carrera;
        this.indiceAcademico = indiceAcademico;
        this.sexo = sexo;
    }
    public double getIndiceAcademico() {
        return indiceAcademico;
    }
    public String getSexo() {
        return sexo;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCarrera() {
        return carrera;
    }
    public String getCedula() {
        return cedula;
    }

}
