package com.noguerolrodrigo.cursos_api.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String matricula;

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnoreProperties("estudiantes")
    private Set<Curso> cursos = new HashSet<>();

    // --- Getters y Setters ---

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Set<Curso> getCursos() {
        return cursos;
    }
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}