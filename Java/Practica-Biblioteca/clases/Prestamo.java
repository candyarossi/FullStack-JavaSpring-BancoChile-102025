package clases;

import java.util.ArrayList;

public class Prestamo {
    private String nombre;
    private ArrayList<Libro> libros;
    private boolean estatus;

    public Prestamo() {
        this.nombre = "Invitado";
        this.libros = new ArrayList<>();
        this.estatus = true;
    }

    public Prestamo(String nombre, boolean estatus) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public String mostrarEstatus() {
        /*
         * if (estatus) {
         * return "Préstamo Activo";
         * }else{
         * return "Préstamo Inactivo";
         * }
         */
        return (estatus) ? "Préstamo Activo" : "Préstamo Inactivo";
    }

    public String mostrarDetallesDelPrestamo() {
        return "Préstamo: Usuario -> " + nombre + ", Libros -> " + libros + ", " + mostrarEstatus();
    }

    public Double calcularTotalDeReemplazo() {
        Double total = 0.0;
        for (Libro libro : libros) {
            total += libro.getPrecioDeReemplazo();
        }
        return total;
    }
}
