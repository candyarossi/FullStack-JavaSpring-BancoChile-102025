package com.oct2025.tiendaVideojuegos.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oct2025.tiendaVideojuegos.interfaces.ManejoDeFechas;
import com.oct2025.tiendaVideojuegos.models.Usuario;
import com.oct2025.tiendaVideojuegos.models.Videojuego;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorVideojuegos implements ManejoDeFechas {

    private ArrayList<Videojuego> videojuegos;

    public ControladorVideojuegos() {
        this.videojuegos = new ArrayList<>();
        Videojuego v1 = new Videojuego(1l, "Silent Hill 2",
                "Having received a letter from his deceased wife, James heads to where they shared so many memories, in the hope of seeing her one more time: Silent Hill.",
                "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2124490/capsule_616x353.jpg?t=1744248682",
                formatearFecha("08/10/2024"), 4.8);
        Videojuego v2 = new Videojuego(2l, "Outlast",
                "Outlast follows the story of investigative journalist Miles Upshur, that got the lead on the inhuman experiments, performed on the asylum patients.",
                "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/238320/capsule_616x353.jpg?t=1666817106",
                formatearFecha("03/09/2013"), 4.5);
        Videojuego v3 = new Videojuego(3l, "Resident Evil 2",
                "The story follows the survivors of a zombie virus outbreak in the fictional Raccoon City.",
                "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/883710/header.jpg?t=1728438541",
                formatearFecha("25/01/2019"), 4.3);
        this.videojuegos.add(v1);
        this.videojuegos.add(v2);
        this.videojuegos.add(v3);
    }

    @GetMapping("/getAll")
    public String getVideojuegos(Model modelo, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("videojuegos", this.videojuegos);
        return "videojuegos.jsp";
    }

    private Videojuego buscar(Long id) {
        Videojuego v = null;
        for (Videojuego videojuego : this.videojuegos) {
            if (videojuego.getId() == id)
                v = videojuego;
        }
        return v;
    }

    @GetMapping("/form/add")
    public String formAgregar(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        return "agregar.jsp";
    }

    @PostMapping("/add")
    public String guardar(@RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam String portada,
            @RequestParam String fecha_lanzamiento,
            @RequestParam String rating, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        long nuevoId = this.videojuegos.size() + 1;
        Videojuego juego = new Videojuego(nuevoId,
                nombre,
                descripcion,
                portada,
                LocalDate.parse(fecha_lanzamiento, formatter2),
                Double.parseDouble(rating));
        this.videojuegos.add(juego);
        return "redirect:/getAll";
    }

    @GetMapping("/detail/{id}")
    public String detalle(@PathVariable("id") Long id, Model modelo, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        Videojuego juego = buscar(id);
        modelo.addAttribute("videojuego", juego);
        return "detalle.jsp";
    }

}
