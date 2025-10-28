package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.model.Curso;
import java.util.List;

public interface ICursoService {
    List<Curso> listarCursos();
    Curso crearCurso(Curso curso, Long profesorId);
    Curso asignarEstudiante(Long cursoId, Long estudianteId);
}