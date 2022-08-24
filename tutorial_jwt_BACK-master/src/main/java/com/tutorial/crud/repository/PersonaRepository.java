package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Persona;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}