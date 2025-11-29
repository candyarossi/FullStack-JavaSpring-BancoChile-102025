package com.javaSpring.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaSpring.examen.models.Frase;
import com.javaSpring.examen.repositories.RepositorioFrases;

@Service
public class ServicioFrases {

    @Autowired
    private RepositorioFrases repositorioFrases;

    // CRUD

    // C -> Create
    public Frase crearFrase(Frase frase) {
        return this.repositorioFrases.save(frase);
    }

    // R -> Read
    public List<Frase> obtenerTodasLasFrases() {
        return (List<Frase>) this.repositorioFrases.findAll();
    }

    public Frase obtenerFrasePorId(Long id) {
        return this.repositorioFrases.findById(id).orElse(null);
    }

    // U -> Update
    public Frase actualizarFrase(Frase frase) {
        return this.repositorioFrases.save(frase);
    }

    // D -> Delete
    public void eliminarFrasePorId(Long id) {
        this.repositorioFrases.deleteById(id);
    }
}
