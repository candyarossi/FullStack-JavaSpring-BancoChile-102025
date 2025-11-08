package clases;

import java.time.LocalDate;
import java.time.Period;

import interfaces.ManejoDeFechas;

public abstract class Usuario implements ManejoDeFechas {
    // ATRIBUTOS
    public static int incrementId = 1;
    private int id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private int edad;
    private String email;

    // METODOS CONTRUCTORES
    public Usuario() {
        this("", "1910-01-01", "");
    }

    public Usuario(String nombre, String fechaNacimiento) {
        this(nombre, fechaNacimiento, "");
    }

    public Usuario(String nombre, String fechaNacimiento, String email) {
        this.nombre = nombre;
        this.fechaNacimiento = formatearFecha(fechaNacimiento);
        this.edad = this.calcularEdad();
        this.email = email;
        this.id = Usuario.incrementId;
        Usuario.incrementId++;
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
        this.fechaNacimiento = formatearFecha(fechaNacimiento);
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

    public abstract String verCalificaciones();

    // METODOS DE INSTANCIA
    private int calcularEdad() {
        Period diferencia = Period.between(this.fechaNacimiento, LocalDate.now());
        int edadCalculada = diferencia.getYears();
        return edadCalculada;
    }

    @Override
    public String toString() {
        return "Usuario: " + id + ", " + nombre + ", " + fechaNacimiento + ", " + edad + ", " + email + ".";
    }

}
