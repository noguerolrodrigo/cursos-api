package com.noguerolrodrigo.cursos_api.entity.mapper;

import com.noguerolrodrigo.cursos_api.entity.Estudiante;
import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteDto;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    public EstudianteDto toDto(Estudiante estudiante) {
        return new EstudianteDto(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getMatricula()
        );
    }

    public Estudiante toEntity(EstudianteCreate dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.nombre());
        estudiante.setMatricula(dto.matricula());
        return estudiante;
    }
}