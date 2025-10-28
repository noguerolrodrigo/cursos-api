package com.noguerolrodrigo.cursos_api.controller;

import com.noguerolrodrigo.cursos_api.model.Profesor;
import com.noguerolrodrigo.cursos_api.service.IProfesorService; // <-- ¡La Interfaz!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private IProfesorService profesorService; // <-- ¡Inyecta la Interfaz!

    @GetMapping
    public List<Profesor> listarProfesores() {
        return profesorService.listarProfesores(); // <-- Usa el nuevo servicio
    }

    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        return profesorService.crearProfesor(profesor); // <-- Usa el nuevo servicio
    }
}