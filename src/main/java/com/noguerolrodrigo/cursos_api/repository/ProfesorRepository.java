package com.noguerolrodrigo.cursos_api.repository;

import com.noguerolrodrigo.cursos_api.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}