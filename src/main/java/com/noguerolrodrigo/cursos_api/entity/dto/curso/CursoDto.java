package com.noguerolrodrigo.cursos_api.entity.dto.curso;

import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteDto;
import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorDto;
import java.util.Set;

// Para MOSTRAR un curso (con todos sus datos)
public record CursoDto(
        Long id,
        String nombre,
        ProfesorDto profesor,
        Set<EstudianteDto> estudiantes
) {
}