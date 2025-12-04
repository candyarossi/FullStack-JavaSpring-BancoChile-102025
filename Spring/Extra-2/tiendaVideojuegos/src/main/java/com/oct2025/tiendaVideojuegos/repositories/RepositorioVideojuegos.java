package com.oct2025.tiendaVideojuegos.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oct2025.tiendaVideojuegos.models.Videojuego;

@Repository
public interface RepositorioVideojuegos extends CrudRepository<Videojuego, Long> {

    // SELECT (JPQL)
    @Query(value = "SELECT v FROM Videojuego v WHERE v.creador.id = ?1")
    Optional<Videojuego> obtenerVideojuegoPorIdUsuarioJPQL(Long idUsuario);

    // SELECT (SQL)
    @Query(value = "SELECT * FROM videojuegos WHERE id_usuario = ?1", nativeQuery = true)
    Optional<Videojuego> obtenerVideojuegoPorIdUsuarioSQL(Long idUsuario);

    // UPDATE (SQL)
    @Transactional
    @Modifying
    @Query(value = "UPDATE videojuegos SET nombre = ?2, descripcion = ?3, portada = ?4, fecha_lanzamiento = ?5, rating = ?6, precio = ?7, id_usuario = ?8 WHERE id = ?1", nativeQuery = true)
    void actualizarVideojuego(Long id, String nombre, String descripcion, String portada, LocalDate fecha_lanzamiento,
            Double rating, Double precio, Long id_creador);

    // DELETE (SQL)
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM videojuegos WHERE id = ?1", nativeQuery = true)
    void eliminarVideojuego(Long id);

    // INSERT (SQL)
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO videojuegos (nombre, descripcion, portada, fecha_lanzamiento, rating, precio, id_usuario) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    Videojuego crearVideojuego(String nombre, String descripcion, String portada, LocalDate fecha_lanzamiento,
            Double rating, Double precio, Long id_creador);

    // JOINS (SQL)
    @Query(value = "SELECT * FROM videojuegos v JOIN usuarios u ON v.id_usuario = u.id WHERE u.id = ?1", nativeQuery = true)
    Object[] obtenerVideojuegosConUsuario(Long idUsuario);
}
