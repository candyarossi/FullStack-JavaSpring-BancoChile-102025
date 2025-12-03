package com.oct2025.tiendaVideojuegos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oct2025.tiendaVideojuegos.models.Resena;

@Repository
public interface RepositorioResenas extends CrudRepository<Resena, Long> {

}
