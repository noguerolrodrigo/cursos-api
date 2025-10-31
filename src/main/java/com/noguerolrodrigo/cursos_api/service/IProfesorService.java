package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorDto;
import java.util.List;

public interface IProfesorService {
    List<ProfesorDto> listarProfesores();
    ProfesorDto crearProfesor(ProfesorCreate dto);
}