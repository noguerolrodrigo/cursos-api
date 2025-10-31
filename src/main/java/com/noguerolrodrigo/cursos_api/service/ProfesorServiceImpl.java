package com.noguerolrodrigo.cursos_api.service;

import com.noguerolrodrigo.cursos_api.entity.Profesor;
import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorCreate;
import com.noguerolrodrigo.cursos_api.entity.dto.profesor.ProfesorDto;
import com.noguerolrodrigo.cursos_api.entity.mapper.ProfesorMapper;
import com.noguerolrodrigo.cursos_api.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private ProfesorMapper profesorMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorDto> listarProfesores() {
        return profesorRepository.findAll()
                .stream()
                .map(profesorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProfesorDto crearProfesor(ProfesorCreate dto) {
        Profesor profesor = profesorMapper.toEntity(dto);
        Profesor profesorGuardado = profesorRepository.save(profesor);
        return profesorMapper.toDto(profesorGuardado);
    }
}