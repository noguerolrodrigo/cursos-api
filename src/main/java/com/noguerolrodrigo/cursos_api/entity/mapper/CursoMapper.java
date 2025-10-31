package com.noguerolrodrigo.cursos_api.entity.mapper;

import com.noguerolrodrigo.cursos_api.entity.Curso;
import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class CursoMapper {

    // ¡Un Mapper puede usar otros Mappers!
    @Autowired
    private ProfesorMapper profesorMapper;
    @Autowired
    private EstudianteMapper estudianteMapper;

    // Para convertir la Entidad (con objetos) a un DTO (con otros DTOs)
    public CursoDto toDto(Curso curso) {
        return new CursoDto(
                curso.getId(),
                curso.getNombre(),
                // Llama al ProfesorMapper para convertir el profesor
                profesorMapper.toDto(curso.getProfesor()),
                // Convierte CADA estudiante de la lista a EstudianteDto
                curso.getEstudiantes().stream()
                        .map(estudianteMapper::toDto)
                        .collect(Collectors.toSet())
        );
    }

    // (No necesitamos un toEntity para CursoCreate
    // porque el Servicio lo maneja)
}