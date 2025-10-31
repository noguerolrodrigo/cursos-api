package com.noguerolrodrigo.cursos_api.service;

// --- IMPORTS DE ENTIDADES (de la carpeta 'entity') ---
import com.noguerolrodrigo.cursos_api.entity.Curso;
import com.noguerolrodrigo.cursos_api.entity.Estudiante;
import com.noguerolrodrigo.cursos_api.entity.Profesor;

// --- IMPORTS DE DTOS (de la carpeta 'entity/dto') ---
import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoDto;

// --- IMPORTS DE MAPPER Y REPOSITORIES ---
import com.noguerolrodrigo.cursos_api.entity.mapper.CursoMapper;
import com.noguerolrodrigo.cursos_api.repository.CursoRepository;
import com.noguerolrodrigo.cursos_api.repository.EstudianteRepository;
import com.noguerolrodrigo.cursos_api.repository.ProfesorRepository;

// --- IMPORTS DE SPRING Y JAVA ---
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CursoMapper cursoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CursoDto> listarCursos() {
        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CursoDto crearCurso(CursoCreate dto) {
        Profesor profesor = profesorRepository.findById(dto.profesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + dto.profesorId()));

        Curso curso = new Curso();
        curso.setNombre(dto.nombre());
        curso.setProfesor(profesor);
        profesor.getCursos().add(curso);

        Curso cursoGuardado = cursoRepository.save(curso);
        return cursoMapper.toDto(cursoGuardado);
    }

    @Override
    @Transactional
    public CursoDto asignarEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + cursoId));
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + estudianteId));

        curso.getEstudiantes().add(estudiante);
        estudiante.getCursos().add(curso);

        Curso cursoGuardado = cursoRepository.save(curso);
        return cursoMapper.toDto(cursoGuardado);
    }
}



