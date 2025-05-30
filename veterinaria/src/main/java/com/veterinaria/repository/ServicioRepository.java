package com.veterinaria.repository;

import com.veterinaria.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    boolean existsByNombre(String nombre);
} 