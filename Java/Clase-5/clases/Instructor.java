package clases;

import java.util.ArrayList;

public class Instructor extends Usuario {
    private ArrayList<String> bootcamps;
    private ArrayList<Estudiante> alumnos;

    public Instructor(String nombre, String fechaNacimiento, String email) {
        super(nombre, fechaNacimiento, email);
        this.bootcamps = new ArrayList<String>();
        this.alumnos = new ArrayList<Estudiante>();
    }

    public ArrayList<String> getBootcamp() {
        return bootcamps;
    }

    public void setBootcamp(ArrayList<String> bootcamp) {
        this.bootcamps = bootcamp;
    }

    public ArrayList<Estudiante> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Estudiante> alumnos) {
        this.alumnos = alumnos;
    }

    public void agregarBootcamp(String bootcamp) {
        this.bootcamps.add(bootcamp);
    }

    public void agregarAlumno(Estudiante alumno) {
        this.alumnos.add(alumno);
    }

    @Override
    public String verCalificaciones() {
        String str = "Estudiantes: \n";
        for (Estudiante alumno : alumnos) {
            str += alumno.verCalificaciones() + "\n";
        }
        return str;
    }

    @Override
    public String toString() {
        return super.toString() + " (Instructor) -> [" + bootcamps + "], [" + alumnos + "].";
    }
}