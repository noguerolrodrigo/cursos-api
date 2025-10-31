package com.noguerolrodrigo.cursos_api.controller;

import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoDto;
import com.noguerolrodrigo.cursos_api.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @GetMapping
    public List<CursoDto> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping
    public CursoDto crearCurso(@RequestBody CursoCreate dto) {
        return cursoService.crearCurso(dto);
    }

    @PostMapping("/{cursoId}/estudiantes/{estudianteId}")
    public CursoDto asignarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        return cursoService.asignarEstudiante(cursoId, estudianteId);
    }
}