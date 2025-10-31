package com.noguerolrodrigo.cursos_api.repository;

import com.noguerolrodrigo.cursos_api.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}