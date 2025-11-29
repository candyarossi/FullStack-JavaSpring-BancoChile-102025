package com.javaSpring.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaSpring.examen.models.LoginUsuario;
import com.javaSpring.examen.models.Usuario;
import com.javaSpring.examen.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/") // Form login
    public String formLogin(Model modelo) {
        modelo.addAttribute("loginUsuario", new LoginUsuario());
        return "login.jsp";
    }

    @GetMapping("/form/registro") // Form registro
    public String formRegistro(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "register.jsp";
    }

    @GetMapping("/logout") // Cierre de sesión
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login") // Procesa info form login
    public String login(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
            BindingResult validaciones,
            HttpSession session) {
        validaciones = this.servicioUsuarios.validarCorreoYPassword(validaciones, loginUsuario);
        if (validaciones.hasErrors()) {
            return "login.jsp";
        }
        Usuario usuario = this.servicioUsuarios.obtenerPorCorreo(loginUsuario.getCorreo());
        session.setAttribute("nombreCompletoUsuario", usuario.getNombre() + " " + usuario.getApellido());
        session.setAttribute("idUsuario", usuario.getId());
        return "redirect:/frases";
    }

    @PostMapping("/register") // Procesa info form registro
    public String register(@Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult validaciones,
            HttpSession session) {
        validaciones = this.servicioUsuarios.validarPasswords(validaciones, usuario);
        if (validaciones.hasErrors()) {
            return "register.jsp";
        }
        Usuario usuarioCreado = this.servicioUsuarios.crearUsuario(usuario);
        session.setAttribute("nombreCompletoUsuario", usuarioCreado.getNombre() + " " + usuarioCreado.getApellido());
        session.setAttribute("idUsuario", usuarioCreado.getId());
        return "redirect:/frases";
    }

}
