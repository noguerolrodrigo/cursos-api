package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.model.Curso;
import com.noguerolrodrigo.cursos_api.model.Estudiante;
import com.noguerolrodrigo.cursos_api.model.Profesor;
import com.noguerolrodrigo.cursos_api.repository.CursoRepository;
import com.noguerolrodrigo.cursos_api.repository.EstudianteRepository;
import com.noguerolrodrigo.cursos_api.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService { // ¡Implementa la interfaz!

    // Este servicio SÍ necesita los 3 repositorios para las asignaciones
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;

    // ----- MÉTODOS DE CURSO -----

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    @Transactional
    public Curso crearCurso(Curso curso, Long profesorId) {
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + profesorId));
        curso.setProfesor(profesor);
        profesor.getCursos().add(curso);
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public Curso asignarEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + cursoId));
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + estudianteId));
        curso.getEstudiantes().add(estudiante);
        estudiante.getCursos().add(curso);
        return cursoRepository.save(curso);
    }
}











