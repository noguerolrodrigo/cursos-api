package com.noguerolrodrigo.cursos_api.entity; // <-- ¡Este es el paquete!

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "cursos")
@EqualsAndHashCode(exclude = "cursos") // <-- Soluciona el bucle de Lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estudiante { // ¡Esta es tu "caja fuerte"!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String matricula; // Lo pongo 'String' para que coincida con tus DTOs

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnoreProperties("estudiantes")
    private Set<Curso> cursos = new HashSet<>();
}