package com.noguerolrodrigo.cursos_api.repository;

import com.noguerolrodrigo.cursos_api.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}