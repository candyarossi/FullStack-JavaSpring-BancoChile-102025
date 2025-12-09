package com.oct2025.tiendaVideojuegos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oct2025.tiendaVideojuegos.models.Usuario;
import java.util.Optional;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
