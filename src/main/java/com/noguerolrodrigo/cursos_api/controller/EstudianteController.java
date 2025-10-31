package com.noguerolrodrigo.cursos_api.controller;

import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoDto;
import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteDto;
import com.noguerolrodrigo.cursos_api.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping
    public List<EstudianteDto> listarEstudiantes() {
        return estudianteService.listarEstudiantes();
    }

    @PostMapping
    public EstudianteDto crearEstudiante(@RequestBody EstudianteCreate dto) {
        return estudianteService.crearEstudiante(dto);
    }

    @GetMapping("/{estudianteId}/cursos")
    public Set<CursoDto> obtenerCursosPorEstudiante(@PathVariable Long estudianteId) {
        return estudianteService.obtenerCursosPorEstudiante(estudianteId);
    }
}