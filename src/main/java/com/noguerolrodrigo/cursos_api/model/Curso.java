package com.noguerolrodrigo.cursos_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Added "handler"
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    @JsonIgnoreProperties("cursos") // Avoid infinite loop with Profesor
    private Profesor profesor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    @JsonIgnoreProperties("estudiantes") // Avoid infinite loop with Estudiante
    private Set<Estudiante> estudiantes = new HashSet<>();

    // No more manual getters or setters!
}