package com.oct2025.tiendaVideojuegos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oct2025.tiendaVideojuegos.models.Videojuego;

@Repository
public interface RepositorioVideojuegos extends CrudRepository<Videojuego, Long> {

}
