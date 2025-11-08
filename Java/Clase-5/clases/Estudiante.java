package clases;

import java.util.ArrayList;
import java.util.Random;

import interfaces.Calculos;
import interfaces.ManejoDeFechas;

public class Estudiante extends Usuario implements Calculos, ManejoDeFechas {
    private int idEstudiante;
    private String bootcamp;
    private String generacion;
    private ArrayList<Integer> calificaciones;
    private static ArrayList<Integer> ids = new ArrayList<>();

    public Estudiante(String nombre, String fechaNacimiento, String email, String bootcamp, String generacion) {
        super(nombre, fechaNacimiento, email);
        this.idEstudiante = this.generarIdEstudiante();
        this.bootcamp = bootcamp;
        this.generacion = generacion;
        this.calificaciones = new ArrayList<>();
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

    public ArrayList<Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Integer> calificaciones) {
        this.calificaciones = calificaciones;
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
    public double calcularPromedio() {
        int suma = 0;
        for (int i = 0; i < this.calificaciones.size(); i++) {
            suma += this.calificaciones.get(i);
        }
        return suma / this.calificaciones.size();
    }

    @Override
    public String verCalificaciones() {
        return this.getNombre() + ": " + this.calificaciones;
    }

    @Override
    public String toString() {
        return super.toString() + " (Estudiante) -> " + idEstudiante + ", " + bootcamp + ", " + generacion + ".";
    }

}
