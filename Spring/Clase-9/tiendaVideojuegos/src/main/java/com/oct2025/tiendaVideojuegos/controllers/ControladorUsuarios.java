package com.oct2025.tiendaVideojuegos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oct2025.tiendaVideojuegos.models.Usuario;
import com.oct2025.tiendaVideojuegos.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorUsuarios {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/")
    public String inicio(HttpSession session) {
        session.invalidate();
        return "login.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            RedirectAttributes flash) {

        Usuario usuario = this.servicioUsuarios.obtenerUsuarioPorEmail(email);
        if (usuario == null) {
            return "login.jsp";
        }
        if (!usuario.getPassword().equals(password)) {
            flash.addFlashAttribute("errorPassword1", "Contraseña incorrecta.");
            return "redirect:/";
        }
        usuario.setPassword("");
        usuario.setComprados(null);
        session.setAttribute("usuario", usuario);
        return "redirect:/getAll";
    }

    @PostMapping("/register")
    public String register(@RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            RedirectAttributes flash) {

        if (password.length() < 4) {
            flash.addFlashAttribute("errorLongitudPassword", "La contraseña debe contener más de 4 caracteres.");
            return "redirect:/";
        }
        Usuario usuario = this.servicioUsuarios.obtenerUsuarioPorEmail(email);
        if (usuario == null) {
            Usuario newUser = new Usuario(nombre, apellido, email, password);
            usuario = this.servicioUsuarios.crearUsuario(newUser);
        }
        usuario.setPassword("");
        usuario.setComprados(null);
        session.setAttribute("usuario", usuario);
        return "redirect:/getAll";
    }
}
