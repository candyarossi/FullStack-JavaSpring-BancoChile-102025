package com.javaSpring.examen.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.javaSpring.examen.models.Frase;
import com.javaSpring.examen.services.ServicioFrases;
import com.javaSpring.examen.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorFrases {

    @Autowired
    private ServicioFrases servicioFrases;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/frases") // Pantalla ver todas las frases
    public String mostrarFrases(HttpSession session, Model modelo) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        List<Frase> frases = this.servicioFrases.obtenerTodasLasFrases();
        List<Frase> frasesFavoritas = this.servicioUsuarios.obtenerPorId(idUsuario).getFrasesFavoritas();
        Collections.sort(frases);
        modelo.addAttribute("frases", frases);
        modelo.addAttribute("favsUsuarios", frasesFavoritas);
        return "frases.jsp";
    }

    @GetMapping("/detail/{id}") // Detalle de frase
    public String detalle(@PathVariable("id") Long id, HttpSession session, Model modelo) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("frase", this.servicioFrases.obtenerFrasePorId(id));
        return "detalle.jsp";
    }

    @GetMapping("/form/add") // Form agregar
    public String formAgregar(HttpSession session, Model modelo) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("frase", new Frase());
        return "agregar.jsp";
    }

    @GetMapping("/form/edit/{id}") // Form editar
    public String formEditar(@PathVariable("id") Long id, HttpSession session, Model modelo) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("frase", this.servicioFrases.obtenerFrasePorId(id));
        return "editar.jsp";
    }

    @PostMapping("/add") // Procesamiento info agregar
    public String agregar(HttpSession session,
            @Valid @ModelAttribute("frase") Frase frase,
            BindingResult validaciones) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        if (validaciones.hasErrors()) {
            return "agregar.jsp";
        }
        this.servicioFrases.crearFrase(frase);
        return "redirect:/frases";
    }

    @PutMapping("/edit") // Procesamiento info editar
    public String editar(HttpSession session,
            @Valid @ModelAttribute("frase") Frase frase,
            BindingResult validaciones) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        if (validaciones.hasErrors()) {
            return "editar.jsp";
        }
        this.servicioFrases.actualizarFrase(frase);
        return "redirect:/frases";
    }

    @DeleteMapping("/delete/{id}") // Eliminar frase
    public String eliminar(@PathVariable("id") Long id, HttpSession session) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        this.servicioFrases.eliminarFrasePorId(id);
        return "redirect:/frases";
    }

    // Favoritos -> Medalla ORO

    @GetMapping("/favoritos")
    public String favoritos(HttpSession session, Model modelo) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        List<Frase> frasesFavoritas = this.servicioUsuarios.obtenerPorId(idUsuario).getFrasesFavoritas();
        modelo.addAttribute("favsUsuario", frasesFavoritas);
        return "favoritos.jsp";
    }

    @PutMapping("/addFav/{id}")
    public String agregarFav(@PathVariable("id") Long idFrase, HttpSession session) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        this.servicioFrases.agregarFavorito(idUsuario, idFrase);
        return "redirect:/frases";
    }

    @PutMapping("/removeFav/{id}")
    public String quitarFav(@PathVariable("id") Long idFrase, HttpSession session) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        this.servicioFrases.quitarFavorito(idUsuario, idFrase);
        return "redirect:/frases";
    }
}
