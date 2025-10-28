package com.noguerolrodrigo.cursos_api.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "cursos")
@EqualsAndHashCode(exclude = "cursos") // <-- ¡LA SOLUCIÓN!
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String matricula;

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnoreProperties("estudiantes")
    private Set<Curso> cursos = new HashSet<>();
}