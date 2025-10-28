package com.noguerolrodrigo.cursos_api.model;

import lombok.*; // Import general
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // Lombok: Solo Getters
@Setter // Lombok: Solo Setters
@ToString(exclude = "cursos") // Lombok: toString sin la lista de cursos
@EqualsAndHashCode(exclude = "cursos") // Lombok: equals/hashCode sin la lista de cursos (¡LA SOLUCIÓN!)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("profesor")
    private List<Curso> cursos = new ArrayList<>();
}