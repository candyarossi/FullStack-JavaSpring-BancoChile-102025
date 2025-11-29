package com.javaSpring.examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaSpring.examen.models.Frase;

@Repository
public interface RepositorioFrases extends CrudRepository<Frase, Long> {

}
