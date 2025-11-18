package com.oct2025.tiendaVideojuegos.models;

import java.time.LocalDate;

import com.oct2025.tiendaVideojuegos.interfaces.ManejoDeFechas;

public class Videojuego implements ManejoDeFechas {
    private Long id;
    private String nombre;
    private String descripcion;
    private String portada;
    private LocalDate fecha_lanzamiento;
    private Double rating;

    public Videojuego() {
    }

    public Videojuego(Long id, String nombre, String descripcion, String portada, LocalDate fecha_lanzamiento,
            Double rating) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.portada = portada;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getFecha_lanzamiento() {
        return fecha_lanzamiento.format(formatter);
    }

    public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Videojuego [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", portada=" + portada
                + ", fecha_lanzamiento=" + fecha_lanzamiento + ", rating=" + rating + "]";
    }

}
