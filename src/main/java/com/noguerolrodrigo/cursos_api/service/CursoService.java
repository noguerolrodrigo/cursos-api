package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.model.Curso; // <-- ¡CON L!
import com.noguerolrodrigo.cursos_api.model.Estudiante; // <-- ¡CON L!
import com.noguerolrodrigo.cursos_api.model.Profesor; // <-- ¡CON L!
import com.noguerolrodrigo.cursos_api.repository.CursoRepository; // <-- ¡CON L!
import com.noguerolrodrigo.cursos_api.repository.EstudianteRepository; // <-- ¡CON L!
import com.noguerolrodrigo.cursos_api.repository.ProfesorRepository; // <-- ¡CON L!
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

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    // --- REQUISITO 3: Crear nuevos cursos con su profesor ---

    public Curso crearCurso(Curso curso, Long profesorId) {
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + profesorId));

        curso.setProfesor(profesor);
        return cursoRepository.save(curso);
    }

    // --- REQUISITO 4: Asignar estudiantes a un curso ---

    public Curso asignarEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + cursoId));

        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + estudianteId));

        curso.getEstudiantes().add(estudiante);
        return cursoRepository.save(curso);
    }

    // --- REQUISITO 5: Devolver la lista de cursos en los que esta un estudiante ---

    public Set<Curso> obtenerCursosPorEstudiante(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + estudianteId));

        return estudiante.getCursos();
    }

    // --- Métodos extra (para crear datos de prueba) ---

    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
}












