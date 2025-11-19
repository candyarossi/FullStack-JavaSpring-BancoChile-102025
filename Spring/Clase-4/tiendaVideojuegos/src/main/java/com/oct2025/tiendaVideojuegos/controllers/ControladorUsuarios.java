package com.oct2025.tiendaVideojuegos.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oct2025.tiendaVideojuegos.models.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorUsuarios {

    private ArrayList<Usuario> usuarios;

    public ControladorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

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

        Usuario usuario = buscar(email);
        if (usuario == null) {
            return "login.jsp";
        }
        if (!usuario.getPassword().equals(password)) {
            flash.addFlashAttribute("errorPassword1", "Contraseña incorrecta.");
            return "redirect:/";
        }
        usuario.setPassword("");
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
        Usuario usuario = buscar(email);
        if (usuario == null) {
            long nuevoId = this.usuarios.size() + 1;
            Usuario newUser = new Usuario(nuevoId, nombre, apellido, email, password);
            this.usuarios.add(newUser);
            usuario = newUser;
        }
        usuario.setPassword("");
        session.setAttribute("usuario", usuario);
        return "redirect:/getAll";
    }

    private Usuario buscar(String email) {
        Usuario user = null;
        for (Usuario u : this.usuarios) {
            if (u.getEmail().equalsIgnoreCase(email))
                user = u;
        }
        return user;
    }
}
