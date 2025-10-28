package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.model.Curso;
import com.noguerolrodrigo.cursos_api.model.Estudiante;
import java.util.List;
import java.util.Set;

public interface IEstudianteService {
    List<Estudiante> listarEstudiantes();
    Estudiante crearEstudiante(Estudiante estudiante);
    Set<Curso> obtenerCursosPorEstudiante(Long estudianteId);
}
