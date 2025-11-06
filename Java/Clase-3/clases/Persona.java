package clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
    // ATRIBUTOS
    private String nombre;
    private LocalDate fechaNacimiento;
    private int edad;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // METODOS CONTRUCTORES
    public Persona() {
        this.nombre = "";
        this.fechaNacimiento = LocalDate.parse("1910-01-01");
        this.edad = 0;
    }

    public Persona(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatter);
        this.edad = calcularEdad();
    }

    // GETTERS y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.toString();
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatter);
        this.edad = calcularEdad();
    }

    public int getEdad() {
        return edad;
    }

    // METODOS DE INSTANCIA
    private int calcularEdad() {
        Period diferencia = Period.between(this.fechaNacimiento, LocalDate.now());
        int edadCalculada = diferencia.getYears();
        return edadCalculada;
    }

    @Override
    public String toString() {
        return "Persona: " + nombre + ", " + fechaNacimiento + ", " + edad + ".";
    }

}
