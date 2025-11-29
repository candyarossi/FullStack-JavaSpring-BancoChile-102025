package com.javaSpring.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaSpring.examen.models.Frase;
import com.javaSpring.examen.services.ServicioFrases;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorFrases {

    @Autowired
    private ServicioFrases servicioFrases;

    @GetMapping("/frases") // Pantalla ver todas las frases
    public String mostrarFrases(HttpSession session, Model modelo) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        List<Frase> frases = this.servicioFrases.obtenerTodasLasFrases();
        modelo.addAttribute("frases", frases);
        return "frases.jsp";
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
}
