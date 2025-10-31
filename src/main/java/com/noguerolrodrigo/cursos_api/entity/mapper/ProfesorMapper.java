package com.noguerolrodrigo.cursos_api.entity.mapper;

import com.noguerolrodrigo.cursos_api.entity.Profesor;
import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorDto;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {

    public ProfesorDto toDto(Profesor profesor) {
        return new ProfesorDto(
                profesor.getId(),
                profesor.getNombre(),
                profesor.getMail()
        );
    }

    public Profesor toEntity(ProfesorCreate dto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(dto.nombre());
        profesor.setMail(dto.mail());
        return profesor;
    }
}