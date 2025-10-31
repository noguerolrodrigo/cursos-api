package com.noguerolrodrigo.cursos_api.entity.dto.profesor;

// Para MOSTRAR un profesor
public record ProfesorDto(
        Long id,
        String nombre,
        String mail
) {
}