package com.noguerolrodrigo.cursos_api.entity; // <-- ¡Este es el paquete!

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "cursos")
@EqualsAndHashCode(exclude = "cursos") // <-- Soluciona el bucle de Lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profesor { // ¡Esta es tu "caja fuerte"!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String mail; // Lo pongo 'mail' para que coincida con tus DTOs

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("profesor")
    private List<Curso> cursos = new ArrayList<>();
}
