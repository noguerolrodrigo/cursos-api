package com.noguerolrodrigo.cursos_api.entity.dto.curso;

// Para CREAR un curso (solo necesitamos el ID del profe)
public record CursoCreate(
        String nombre,
        Long profesorId
) {
}
