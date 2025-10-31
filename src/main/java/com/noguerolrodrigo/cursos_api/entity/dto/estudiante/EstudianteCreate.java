package com.noguerolrodrigo.cursos_api.entity.dto.estudiante;

// Para CREAR un estudiante
public record EstudianteCreate(
        String nombre,
        String matricula
) {
}