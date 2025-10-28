package com.noguerolrodrigo.cursos_api.model;

import lombok.AllArgsConstructor; // Import
import lombok.Data; // Import
import lombok.NoArgsConstructor; // Import
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data // <-- Generates getters, setters, toString, equals, hashCode!
@NoArgsConstructor // <-- Generates empty constructor
@AllArgsConstructor // <-- Generates constructor with all fields
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cursos"}) // Added "handler" for safety
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("profesor") // Avoid infinite loop with Curso
    private List<Curso> cursos = new ArrayList<>();

    // No more manual getters or setters! 🎉
}