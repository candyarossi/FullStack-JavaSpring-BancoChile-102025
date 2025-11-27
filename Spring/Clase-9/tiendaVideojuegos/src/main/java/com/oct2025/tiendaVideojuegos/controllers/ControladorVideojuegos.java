package com.oct2025.tiendaVideojuegos.controllers;

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

import com.oct2025.tiendaVideojuegos.interfaces.ManejoDeFechas;
import com.oct2025.tiendaVideojuegos.models.Resena;
import com.oct2025.tiendaVideojuegos.models.Usuario;
import com.oct2025.tiendaVideojuegos.models.Videojuego;
import com.oct2025.tiendaVideojuegos.services.ServicioResenas;
import com.oct2025.tiendaVideojuegos.services.ServicioUsuarios;
import com.oct2025.tiendaVideojuegos.services.ServicioVideojuegos;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorVideojuegos implements ManejoDeFechas {

    @Autowired
    private ServicioVideojuegos servicioVideojuegos;

    @Autowired
    private ServicioResenas servicioResenas;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/getAll")
    public String getVideojuegos(Model modelo, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        List<Videojuego> misVideojuegos = this.servicioUsuarios.obtenerUsuarioPorId(usuario.getId()).getComprados();
        modelo.addAttribute("misVideojuegos", misVideojuegos);
        modelo.addAttribute("videojuegos", this.servicioVideojuegos.obtenerTodosLosVideojuegos());
        return "videojuegos.jsp";
    }

    @GetMapping("/form/add")
    public String formAgregar(HttpSession session, Model modelo) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("videojuego", new Videojuego());
        return "agregar.jsp";
    }

    @PostMapping("/add")
    public String guardar(@Valid @ModelAttribute("videojuego") Videojuego videojuego,
            BindingResult validaciones,
            HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        if (validaciones.hasErrors()) {
            return "agregar.jsp";
        }
        this.servicioVideojuegos.crear(videojuego);
        return "redirect:/getAll";
    }

    @GetMapping("/detail/{id}")
    public String detalle(@PathVariable("id") Long id, Model modelo, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        Videojuego juego = this.servicioVideojuegos.obtenerPorId(id);
        modelo.addAttribute("videojuego", juego);
        modelo.addAttribute("resena", new Resena());
        return "detalle.jsp";
    }

    @GetMapping("/form/edit/{id}")
    public String formEditar(HttpSession session, Model model, @PathVariable("id") Long id) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        model.addAttribute("videojuego", this.servicioVideojuegos.obtenerPorId(id));
        return "editar.jsp";
    }

    @PutMapping("/edit")
    public String actualizar(@Valid @ModelAttribute("videojuego") Videojuego videojuego,
            BindingResult validaciones,
            HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        if (validaciones.hasErrors()) {
            return "editar.jsp";
        }
        this.servicioVideojuegos.actualizar(videojuego);
        return "redirect:/getAll";
    }

    @DeleteMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        this.servicioVideojuegos.eliminar(id);
        return "redirect:/getAll";
    }

    @PostMapping("/comment")
    public String comentar(@Valid @ModelAttribute("resena") Resena resena,
            BindingResult validaciones,
            HttpSession session, Model modelo) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        if (validaciones.hasErrors()) {
            Videojuego juego = this.servicioVideojuegos.obtenerPorId(resena.getVideojuego().getId());
            modelo.addAttribute("videojuego", juego);
            return "detalle.jsp";
        }
        this.servicioResenas.crear(resena);
        return "redirect:/detail/" + resena.getVideojuego().getId();
    }

    @GetMapping("/buy/{id}")
    public String comprar(HttpSession session, Model modelo, @PathVariable("id") Long idJuego) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }

        Usuario usuarioModificar = this.servicioUsuarios.obtenerUsuarioPorId(usuario.getId());
        Videojuego juegoComprar = this.servicioVideojuegos.obtenerPorId(idJuego);

        List<Videojuego> juegosUsuario = usuarioModificar.getComprados();
        juegosUsuario.add(juegoComprar);
        usuarioModificar.setComprados(juegosUsuario);

        Double coinsUsuario = usuarioModificar.getCoins();
        Double restante = coinsUsuario - juegoComprar.getPrecio();
        usuarioModificar.setCoins(restante);
        usuario.setCoins(restante);
        session.setAttribute("usuario", usuario);

        this.servicioUsuarios.actualizarUsuario(usuarioModificar);

        return "redirect:/getAll";
    }
}
