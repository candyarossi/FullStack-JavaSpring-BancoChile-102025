package com.oct2025.tiendaVideojuegos.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oct2025.tiendaVideojuegos.interfaces.ManejoDeFechas;
import com.oct2025.tiendaVideojuegos.models.Videojuego;

@RestController
public class ControladorVideojuegos implements ManejoDeFechas {

    private ArrayList<Videojuego> videojuegos;

    public ControladorVideojuegos() {
        this.videojuegos = new ArrayList<>();
        Videojuego v1 = new Videojuego("Silent Hill 2",
                "Having received a letter from his deceased wife, James heads to where they shared so many memories, in the hope of seeing her one more time: Silent Hill.",
                "", formatearFecha("2024-10-08"), 4.8);
        Videojuego v2 = new Videojuego("Outlast",
                "Outlast follows the story of investigative journalist Miles Upshur, that got the lead on the inhuman experiments, performed on the asylum patients.",
                "", formatearFecha("2013-09-03"), 4.5);
        Videojuego v3 = new Videojuego("Resident Evil",
                "The story follows the survivors of a zombie virus outbreak in the fictional Raccoon City.", "",
                formatearFecha("2019-01-25"), 4.3);
        this.videojuegos.add(v1);
        this.videojuegos.add(v2);
        this.videojuegos.add(v3);
    }

    @RequestMapping(value = "/saludo", method = RequestMethod.GET)
    public String inicio() {
        return "Hola Spring Boot!";
    }

    @GetMapping("/getAll")
    public String getVideojuegos() {
        String str = "";
        for (Videojuego v : this.videojuegos) {
            str += v.toString();
        }
        return str;
    }

    // Párametros de consulta -> Query String
    // localhost:8080/get/nombre?nombre=Outlast
    @GetMapping("/get/nombre")
    public String getVideojuegoXnombreV1(@RequestParam("nombre") String nombre) {
        String str = buscar(nombre).toString();
        return str;
    }

    // Variables de ruta -> Path Variable
    // localhost:8080/get/nombre/Outlast
    @GetMapping("/get/nombre/{nombre}")
    public String getVidejuegoXnombreV2(@PathVariable("nombre") String nombre) {
        String str = buscar(nombre).toString();
        return str;
    }

    private Videojuego buscar(String nombre) {
        Videojuego v = null;
        for (Videojuego videojuego : this.videojuegos) {
            if (videojuego.getNombre().equalsIgnoreCase(nombre))
                v = videojuego;
        }
        return v;
    }
}
