package com.noguerolrodrigo.cursos_api.entity; // <-- ¡Este es el paquete!

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"profesor", "estudiantes"})
@EqualsAndHashCode(exclude = {"profesor", "estudiantes"}) // <-- Soluciona el bucle de Lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Curso { // ¡Esta es tu "caja fuerte"!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    @JsonIgnoreProperties("cursos")
    private Profesor profesor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    @JsonIgnoreProperties("estudiantes")
    private Set<Estudiante> estudiantes = new HashSet<>();
}