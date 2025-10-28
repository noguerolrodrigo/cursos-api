package com.noguerolrodrigo.cursos_api.controller;

import com.noguerolrodrigo.cursos_api.model.Curso;
import com.noguerolrodrigo.cursos_api.service.ICursoService; // <-- ¡La Interfaz!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private ICursoService cursoService; // <-- ¡Inyecta la Interfaz!

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso, @RequestParam Long profesorId) {
        return cursoService.crearCurso(curso, profesorId);
    }

    @PostMapping("/{cursoId}/estudiantes/{estudianteId}")
    public Curso asignarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        return cursoService.asignarEstudiante(cursoId, estudianteId);
    }
}