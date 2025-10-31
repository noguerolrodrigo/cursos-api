package com.noguerolrodrigo.cursos_api.entity.dto.profesor;

// Para CREAR un profesor
public record ProfesorCreate(
        String nombre,
        String mail
) {
}