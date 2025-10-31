package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoDto;
import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteDto;
import java.util.List;
import java.util.Set;

public interface IEstudianteService {
    List<EstudianteDto> listarEstudiantes();
    EstudianteDto crearEstudiante(EstudianteCreate dto);
    Set<CursoDto> obtenerCursosPorEstudiante(Long estudianteId);
}