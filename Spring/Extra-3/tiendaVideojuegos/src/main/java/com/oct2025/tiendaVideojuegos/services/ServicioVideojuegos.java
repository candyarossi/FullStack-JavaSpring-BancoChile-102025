package com.oct2025.tiendaVideojuegos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.oct2025.tiendaVideojuegos.models.Videojuego;
import com.oct2025.tiendaVideojuegos.repositories.RepositorioVideojuegos;

@Service
public class ServicioVideojuegos {

    @Autowired
    private RepositorioVideojuegos repositorioVideojuegos;

    public Page<Videojuego> obtenerTodosLosVideojuegos(int nroPagina, String orden) {
        PageRequest pageRequest = PageRequest.of(nroPagina - 1, 3);
        if (orden != null) {
            Sort sort = null;
            if (orden.equalsIgnoreCase("ASC")) {
                sort = Sort.by(Sort.Direction.ASC, "nombre");
            } else if (orden.equalsIgnoreCase("DESC")) {
                sort = Sort.by(Sort.Direction.DESC, "nombre");
            }
            pageRequest = PageRequest.of(nroPagina - 1, 3, sort);
        }
        return this.repositorioVideojuegos.findAll(pageRequest);
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

    public Videojuego obtenerVideojuegoPorUsuario(Long idUsuario) {
        return this.repositorioVideojuegos.obtenerVideojuegoPorIdUsuarioSQL(idUsuario).orElse(null);
    }
}
