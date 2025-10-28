package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.model.Profesor;
import java.util.List;

public interface IProfesorService {
    List<Profesor> listarProfesores();
    Profesor crearProfesor(Profesor profesor);
}