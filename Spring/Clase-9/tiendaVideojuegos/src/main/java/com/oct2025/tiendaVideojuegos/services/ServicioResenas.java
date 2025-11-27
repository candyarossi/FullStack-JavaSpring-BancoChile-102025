package com.oct2025.tiendaVideojuegos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oct2025.tiendaVideojuegos.models.Resena;
import com.oct2025.tiendaVideojuegos.repositories.RepositorioResenas;

@Service
public class ServicioResenas {

    @Autowired
    private RepositorioResenas repositorioResenas;

    public Resena crear(Resena resena) {
        return this.repositorioResenas.save(resena);
    }
}
