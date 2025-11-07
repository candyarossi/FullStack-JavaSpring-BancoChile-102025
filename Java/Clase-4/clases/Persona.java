package clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
    // ATRIBUTOS
    public static int incrementId = 1;
    private int id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private int edad;
    private String email;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // METODOS CONTRUCTORES
    public Persona() {
        this("", "1910-01-01", "");
    }

    public Persona(String nombre, String fechaNacimiento) {
        this(nombre, fechaNacimiento, "");
    }

    public Persona(String nombre, String fechaNacimiento, String email) {
        this.nombre = nombre;
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatter);
        this.edad = this.calcularEdad();
        this.email = email;
        this.id = Persona.incrementId;
        Persona.incrementId++;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public static int getIncrementId() {
        return incrementId;
    }

    // METODOS DE INSTANCIA
    private int calcularEdad() {
        Period diferencia = Period.between(this.fechaNacimiento, LocalDate.now());
        int edadCalculada = diferencia.getYears();
        return edadCalculada;
    }

    @Override
    public String toString() {
        return "Persona: " + id + ", " + nombre + ", " + fechaNacimiento + ", " + edad + ", " + email + ".";
    }

}
