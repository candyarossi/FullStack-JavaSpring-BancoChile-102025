package com.oct2025.tiendaVideojuegos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.oct2025.tiendaVideojuegos.models.LoginUsuario;
import com.oct2025.tiendaVideojuegos.models.Usuario;
import com.oct2025.tiendaVideojuegos.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/")
    public String inicio(HttpSession session, Model modelo) {
        session.invalidate();
        modelo.addAttribute("usuario", new Usuario());
        modelo.addAttribute("loginUsuario", new LoginUsuario());
        return "login.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
            BindingResult validaciones,
            HttpSession session, Model modelo) {

        Usuario usuario = this.servicioUsuarios.obtenerUsuarioPorEmail(loginUsuario.getEmail());
        if (usuario != null) {
            validaciones = this.servicioUsuarios.validarLogin(validaciones, loginUsuario);
            if (validaciones.hasErrors()) {
                modelo.addAttribute("usuario", new Usuario());
                return "login.jsp";
            }
            usuario.setPassword("");
            usuario.setComprados(null);
            session.setAttribute("usuario", usuario);
            return "redirect:/getAll?pagina=1";
        }
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("usuario") Usuario usuarioRegistro,
            BindingResult validaciones,
            HttpSession session, Model modelo) {

        Usuario usuario = this.servicioUsuarios.obtenerUsuarioPorEmail(usuarioRegistro.getEmail());
        if (usuario == null) {
            validaciones = this.servicioUsuarios.validarRegistro(validaciones, usuarioRegistro);
            if (validaciones.hasErrors()) {
                modelo.addAttribute("loginUsuario", new LoginUsuario());
                return "login.jsp";
            }
            usuario = this.servicioUsuarios.crearUsuario(usuarioRegistro);
        }
        usuario.setPassword("");
        usuario.setComprados(null);
        session.setAttribute("usuario", usuario);
        return "redirect:/getAll?pagina=1";
    }
}
