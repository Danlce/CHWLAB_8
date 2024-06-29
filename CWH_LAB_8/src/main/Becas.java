package main;
//Integrantes: William Concepcion, Wilson Wang, Emmanuel Hernandez
import java.util.ArrayList;


public class Becas {
    private static final int MAX_ESTUDIANTES = 100;
    private ArrayList<Estudiantes> estudiantes;

    public Becas() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("No se puede agregar más estudiantes. Límite alcanzado.");
        }
    }

    public ArrayList<Estudiantes> obtenerEstudiantesBecados() {
        ArrayList<Estudiantes> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0) {
                estudiantesBecados.add(estudiante);
            }
        }

        return estudiantesBecados;
    }

    public ArrayList<Estudiantes> obtenerEstudiantesBecadosPorCarreraYSexo(String carrera, String sexo) {
        ArrayList<Estudiantes> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0 && estudiante.getCarrera().equals(carrera)
                    && estudiante.getSexo().equals(sexo)) {
                estudiantesBecados.add(estudiante);
            }
        }

        return estudiantesBecados;
    }
}
