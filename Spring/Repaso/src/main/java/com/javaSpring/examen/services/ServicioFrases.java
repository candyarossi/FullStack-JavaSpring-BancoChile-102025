package com.javaSpring.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaSpring.examen.models.Frase;
import com.javaSpring.examen.models.Usuario;
import com.javaSpring.examen.repositories.RepositorioFrases;
import com.javaSpring.examen.repositories.RepositorioUsuarios;

@Service
public class ServicioFrases {

    @Autowired
    private RepositorioFrases repositorioFrases;

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

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

    // Favoritos
    public void agregarFavorito(Long idUsuario, Long idFrase) {
        Usuario usuario = this.repositorioUsuarios.findById(idUsuario).orElse(null);
        Frase frase = this.repositorioFrases.findById(idFrase).orElse(null);
        usuario.getFrasesFavoritas().add(frase);
        this.repositorioUsuarios.save(usuario);
    }

    public void quitarFavorito(Long idUsuario, Long idFrase) {
        Usuario usuario = this.repositorioUsuarios.findById(idUsuario).orElse(null);
        Frase frase = this.repositorioFrases.findById(idFrase).orElse(null);
        usuario.getFrasesFavoritas().remove(frase);
        this.repositorioUsuarios.save(usuario);
    }
}
