package com.noguerolrodrigo.cursos_api.service;

// --- IMPORTS DE ENTIDADES Y DTOS ---
import com.noguerolrodrigo.cursos_api.entity.Estudiante;
import com.noguerolrodrigo.cursos_api.entity.dto.curso.CursoDto;
import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.estudiante.EstudianteDto;

// --- IMPORTS DE MAPPERS Y REPOSITORIES ---
import com.noguerolrodrigo.cursos_api.entity.mapper.CursoMapper;
import com.noguerolrodrigo.cursos_api.entity.mapper.EstudianteMapper;
import com.noguerolrodrigo.cursos_api.repository.EstudianteRepository;

// --- IMPORTS DE SPRING Y JAVA ---
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private EstudianteMapper estudianteMapper;

    // ¡Usamos @Lazy para romper el bucle!
    @Autowired
    @Lazy
    private CursoMapper cursoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteDto> listarEstudiantes() {
        return estudianteRepository.findAll()
                .stream()
                .map(estudianteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EstudianteDto crearEstudiante(EstudianteCreate dto) {
        Estudiante estudiante = estudianteMapper.toEntity(dto);
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return estudianteMapper.toDto(estudianteGuardado);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<CursoDto> obtenerCursosPorEstudiante(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + estudianteId));

        // ¡Mapea los cursos de la entidad a DTOs!
        return estudiante.getCursos()
                .stream()
                .map(cursoMapper::toDto) // Llama al mapper de cursos
                .collect(Collectors.toSet());
    }
}