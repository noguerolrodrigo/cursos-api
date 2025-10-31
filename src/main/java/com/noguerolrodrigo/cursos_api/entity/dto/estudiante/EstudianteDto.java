package com.noguerolrodrigo.cursos_api.entity.dto.estudiante;

// Para MOSTRAR un estudiante
public record EstudianteDto(
        Long id,
        String nombre,
        String matricula
) {
}