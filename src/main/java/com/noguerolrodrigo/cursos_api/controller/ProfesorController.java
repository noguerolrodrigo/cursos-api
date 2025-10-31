package com.noguerolrodrigo.cursos_api.controller;

import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorDto;
import com.noguerolrodrigo.cursos_api.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private IProfesorService profesorService;

    @GetMapping
    public List<ProfesorDto> listarProfesores() {
        return profesorService.listarProfesores();
    }

    @PostMapping
    public ProfesorDto crearProfesor(@RequestBody ProfesorCreate dto) {
        return profesorService.crearProfesor(dto);
    }
}