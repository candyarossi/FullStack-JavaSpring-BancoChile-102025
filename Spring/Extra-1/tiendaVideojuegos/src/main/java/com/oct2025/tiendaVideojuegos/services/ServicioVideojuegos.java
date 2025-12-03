package com.oct2025.tiendaVideojuegos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oct2025.tiendaVideojuegos.models.Videojuego;
import com.oct2025.tiendaVideojuegos.repositories.RepositorioVideojuegos;

@Service
public class ServicioVideojuegos {

    @Autowired
    private RepositorioVideojuegos repositorioVideojuegos;

    public List<Videojuego> obtenerTodosLosVideojuegos() {
        return (List<Videojuego>) this.repositorioVideojuegos.findAll();
    }

    public Videojuego obtenerPorId(Long id) {
        return this.repositorioVideojuegos.findById(id).orElse(null);
    }

    public Videojuego crear(Videojuego videojuego) {
        return this.repositorioVideojuegos.save(videojuego);
    }

    public Videojuego actualizar(Videojuego videojuego) {
        return this.repositorioVideojuegos.save(videojuego);
    }

    public void eliminar(Long id) {
        this.repositorioVideojuegos.deleteById(id);
    }
}
