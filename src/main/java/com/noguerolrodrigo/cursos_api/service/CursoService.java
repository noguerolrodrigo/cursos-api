package com.noguerolrodrigo.cursos_api.service;

import org.springframework.transaction.annotation.Transactional;
import com.noguerolrodrigo.cursos_api.model.Curso;
import com.noguerolrodrigo.cursos_api.model.Estudiante;
import com.noguerolrodrigo.cursos_api.model.Profesor;
import com.noguerolrodrigo.cursos_api.repository.CursoRepository;
import com.noguerolrodrigo.cursos_api.repository.EstudianteRepository;
import com.noguerolrodrigo.cursos_api.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;

    // --- REQUISITO 2: Listar todo ---

    @Transactional(readOnly = true) // Soluciona el Error 500 en "GET /api/cursos"
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    // --- REQUISITO 3: Crear nuevos cursos con su profesor ---

    @Transactional
    public Curso crearCurso(Curso curso, Long profesorId) {
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + profesorId));

        curso.setProfesor(profesor);       // Sincroniza "ida"
        profesor.getCursos().add(curso);   // ¡Sincroniza "vuelta"!

        return cursoRepository.save(curso);
    }

    // --- REQUISITO 4: Asignar estudiantes a un curso ---

    @Transactional // Soluciona el Error 500 en "POST .../estudiantes/1"
    public Curso asignarEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + cursoId));

        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + estudianteId));

        curso.getEstudiantes().add(estudiante); // Sincroniza "ida"
        estudiante.getCursos().add(curso);      // ¡Sincroniza "vuelta"!

        // Con @Transactional no haría falta el save, pero no hace mal
        return cursoRepository.save(curso);
    }

    // --- REQUISITO 5: Devolver la lista de cursos en los que esta un estudiante ---

    @Transactional(readOnly = true)
    public Set<Curso> obtenerCursosPorEstudiante(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + estudianteId));

        return estudiante.getCursos(); // @Transactional permite "despertar" esta lista
    }

    // --- Métodos extra (para crear datos de prueba) ---

    @Transactional
    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Transactional
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
}












