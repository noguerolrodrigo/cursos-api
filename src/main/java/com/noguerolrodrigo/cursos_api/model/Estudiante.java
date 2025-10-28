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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cursos"}) // Added "handler"
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String matricula;

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnoreProperties("estudiantes") // Avoid infinite loop with Curso
    private Set<Curso> cursos = new HashSet<>();

    // No more manual getters or setters!
}