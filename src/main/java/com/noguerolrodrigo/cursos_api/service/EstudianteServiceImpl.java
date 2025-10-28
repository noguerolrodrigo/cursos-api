package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.model.Curso;
import com.noguerolrodrigo.cursos_api.model.Estudiante;
import com.noguerolrodrigo.cursos_api.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    @Transactional
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Curso> obtenerCursosPorEstudiante(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + estudianteId));
        return estudiante.getCursos();
    }
}