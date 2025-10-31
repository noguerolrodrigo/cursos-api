package com.noguerolrodrigo.cursos_api.service;

// ¡Imports de los DTOs!
import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoDto;
import java.util.List;

public interface ICursoService {
    List<CursoDto> listarCursos();
    CursoDto crearCurso(CursoCreate dto);
    CursoDto asignarEstudiante(Long cursoId, Long estudianteId);
}