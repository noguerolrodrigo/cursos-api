package com.noguerolrodrigo.cursos_api.controller;

import com.noguerolrodrigo.cursos_api.model.Curso;
import com.noguerolrodrigo.cursos_api.model.Estudiante;
import com.noguerolrodrigo.cursos_api.service.IEstudianteService; // <-- ¡La Interfaz!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService; // <-- ¡Inyecta la Interfaz!

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.listarEstudiantes(); // <-- Usa el nuevo servicio
    }

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.crearEstudiante(estudiante); // <-- Usa el nuevo servicio
    }

    @GetMapping("/{estudianteId}/cursos")
    public Set<Curso> obtenerCursosPorEstudiante(@PathVariable Long estudianteId) {
        return estudianteService.obtenerCursosPorEstudiante(estudianteId); // <-- Usa el nuevo servicio
    }
}