package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.model.Profesor;
import com.noguerolrodrigo.cursos_api.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service // ¡Importante!
public class ProfesorServiceImpl implements IProfesorService { // ¡Implementa la interfaz!

    // Inyecta solo el repositorio que necesita
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override // Le dice a Java que este método está en el "contrato"
    @Transactional(readOnly = true)
    public List<Profesor> listarProfesores() {
        // Esta lógica la "robamos" de tu viejo CursoService
        return profesorRepository.findAll();
    }

    @Override
    @Transactional
    public Profesor crearProfesor(Profesor profesor) {
        // Esta lógica la "robamos" de tu viejo CursoService
        return profesorRepository.save(profesor);
    }
}