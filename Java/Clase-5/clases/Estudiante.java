package clases;

import java.util.ArrayList;
import java.util.Random;

public class Estudiante extends Usuario {
    private int idEstudiante;
    private String bootcamp;
    private String generacion;
    private static ArrayList<Integer> ids = new ArrayList<>();

    public Estudiante(String nombre, String fechaNacimiento, String email, String bootcamp, String generacion) {
        super(nombre, fechaNacimiento, email);
        this.idEstudiante = this.generarIdEstudiante();
        this.bootcamp = bootcamp;
        this.generacion = generacion;
        Estudiante.ids.add(this.idEstudiante);
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(String bootcamp) {
        this.bootcamp = bootcamp;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    private int generarIdEstudiante() {
        Random random = new Random();
        int numeroRandom = 1000 + random.nextInt(9000);
        if (Estudiante.ids.contains(numeroRandom)) {
            this.generarIdEstudiante();
        }
        return numeroRandom;
    }

    @Override
    public String toString() {
        return super.toString() + " (Estudiante) -> " + idEstudiante + ", " + bootcamp + ", " + generacion + ".";
    }
}
