package com.noguerolrodrigo.cursos_api.controller; // ¡Tu paquete controller!

import com.noguerolrodrigo.cursos_api.model.Curso;
import com.noguerolrodrigo.cursos_api.model.Estudiante;
import com.noguerolrodrigo.cursos_api.model.Profesor;
import com.noguerolrodrigo.cursos_api.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController // Le dice a Spring que esta clase es un Controlador REST
@RequestMapping("/api") // Todas las URLs de esta clase empezarán con /api
public class CursoController {

    @Autowired
    private CursoService cursoService; // ¡Inyectamos el servicio que ya creamos!

    // --- REQUISITO 2: Listar todo ---

    @GetMapping("/cursos") // URL: GET http://localhost:8080/api/cursos
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/profesores") // URL: GET http://localhost:8080/api/profesores
    public List<Profesor> listarProfesores() {
        return cursoService.listarProfesores();
    }

    @GetMapping("/estudiantes") // URL: GET http://localhost:8080/api/estudiantes
    public List<Estudiante> listarEstudiantes() {
        return cursoService.listarEstudiantes();
    }

    // --- REQUISITO 3: Crear nuevos cursos con su profesor ---

    // URL: POST http://localhost:8080/api/cursos?profesorId=1
    // Y en el "Body" del POST, enviamos el JSON del curso (ej: {"nombre": "Matemática"})
    @PostMapping("/cursos")
    public Curso crearCurso(@RequestBody Curso curso, @RequestParam Long profesorId) {
        return cursoService.crearCurso(curso, profesorId);
    }

    // --- REQUISITO 4: Asignar estudiantes a un curso ---

    // URL: POST http://localhost:8080/api/cursos/1/estudiantes/3
    // (Asigna el estudiante 3 al curso 1)
    @PostMapping("/cursos/{cursoId}/estudiantes/{estudianteId}")
    public String asignarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        cursoService.asignarEstudiante(cursoId, estudianteId);
        return "✅ Estudiante asignado correctamente al curso.";
    }

    // --- REQUISITO 5: Devolver la lista de cursos en los que está un estudiante ---

    // URL: GET http://localhost:8080/api/estudiantes/3/cursos
    // (Devuelve todos los cursos del estudiante 3)
    @GetMapping("/estudiantes/{estudianteId}/cursos")
    public Set<Curso> obtenerCursosPorEstudiante(@PathVariable Long estudianteId) {
        return cursoService.obtenerCursosPorEstudiante(estudianteId);
    }

    // --- Endpoints extra para crear datos de prueba (muy útiles) ---

    @PostMapping("/profesores") // URL: POST http://localhost:8080/api/profesores
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        // Body: {"nombre": "Juan Perez", "email": "juan@mail.com"}
        return cursoService.crearProfesor(profesor);
    }

    @PostMapping("/estudiantes") // URL: POST http://localhost:8080/api/estudiantes
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        // Body: {"nombre": "Ana Gomez", "matricula": "A-123"}
        return cursoService.crearEstudiante(estudiante);
    }
}