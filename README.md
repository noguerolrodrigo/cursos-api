# API de Cursos (Spring Boot) - Proyecto Refactorizado

Este es un proyecto de API REST para la gestión de cursos, profesores y estudiantes. El proyecto original fue refactorizado para cumplir con los estándares de arquitectura de software, incluyendo la separación de responsabilidades (capas), el uso de Interfaces y el patrón DTO/Mapper.

## Tecnologías Utilizadas
* Java 17
* Spring Boot
* Spring Data JPA (con Hibernate)
* Base de datos H2 (con persistencia en archivo)
* Maven
* Lombok

## Estructura del Proyecto

La API sigue una arquitectura en capas profesional:

* **`controller`**: Controladores separados por entidad (`ProfesorController`, `EstudianteController`, `CursoController`) que manejan las peticiones HTTP.
* **`entity`**: Contiene las entidades de la base de datos (`Profesor`, `Estudiante`, `Curso`).
* **`dto`**: (Data Transfer Objects) Clases `record` simples (`ProfesorDto`, `ProfesorCreate`, etc.) que se usan para transferir datos hacia y desde el controlador, evitando exponer las entidades.
* **`mapper`**: Componentes (`ProfesorMapper`, etc.) responsables de convertir Entidades $\leftrightarrow$ DTOs.
* **`service`**: Lógica de negocio separada en Interfaces (`IProfesorService`, etc.) y sus Implementaciones (`ProfesorServiceImpl`, etc.).
* **`repository`**: Interfaces de Spring Data JPA para el acceso a datos.

---

## Cómo Correr el Proyecto

1.  Clonar el repositorio.
2.  Abrir el proyecto con IntelliJ IDEA.
3.  (¡Importante!) Si IntelliJ muestra errores en rojo, asegurarse de tener el **Plugin de Lombok** instalado y habilitar **Annotation Processing** (`File > Settings > Build > Compiler > Annotation Processors`).
4.  Ejecutar el método `main` de la clase `CursosApiApplication.java`.
5.  El servidor se iniciará en `http://localhost:8080`.

### Base de Datos (H2)

* La aplicación usa una base de datos **H2** que persiste los datos en un archivo (`cursos-db.mv.db`) que se crea en la raíz del proyecto.
* Se puede acceder a la consola web de H2 (mientras la app corre) en:
  `http://localhost:8080/h2-console`
* **Datos para conectar a la consola H2:**
    * **JDBC URL:** `jdbc:h2:file:./cursos-db`
    * **User Name:** `sa`
    * **Password:** (dejar en blanco)

---

## Cómo Probar la API (Postman)

**¡Importante!** Se recomienda **borrar el archivo `cursos-db.mv.db`** antes de correr la secuencia de pruebas para empezar con una base de datos limpia.

### 1. POST: Crear Profesor
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/profesores`
* **Body (JSON) (Usa `ProfesorCreate`):**
    ```json
    {
        "nombre": "Juan Perez",
        "mail": "juan.perez@email.com"
    }
    ```
* *(Respuesta: `ProfesorDto` con ID 1)*

### 2. POST: Crear Estudiante (Ana)
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/estudiantes`
* **Body (JSON) (Usa `EstudianteCreate`):**
    ```json
    {
        "nombre": "Ana Gomez",
        "matricula": "A-123"
    }
    ```
* *(Respuesta: `EstudianteDto` con ID 1)*

### 3. POST: Crear Estudiante (Luis)
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/estudiantes`
* **Body (JSON) (Usa `EstudianteCreate`):**
    ```json
    {
        "nombre": "Luis Paz",
        "matricula": "L-456"
    }
    ```
* *(Respuesta: `EstudianteDto` con ID 2)*

### 4. POST: (Req. 3) Crear Curso
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/cursos`
* **Body (JSON) (Usa `CursoCreate`):**
    ```json
    {
        "nombre": "Programacion Avanzada",
        "profesorId": 1
    }
    ```
* *(Respuesta: `CursoDto` completo con el profesor)*

### 5. POST: (Req. 4) Asignar Ana al Curso
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/cursos/1/estudiantes/1`
* **Body:** `none`
* *(Respuesta: `CursoDto` actualizado, con Ana en la lista de estudiantes)*

### 6. POST: (Req. 4) Asignar Luis al Curso
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/cursos/1/estudiantes/2`
* **Body:** `none`
* *(Respuesta: `CursoDto` actualizado, con Ana y Luis)*

### 7. GET: (Req. 5) Ver Cursos de Ana
* **Método:** `GET`
* **URL:** `http://localhost:8080/api/estudiantes/1/cursos`
* *(Respuesta: Una lista `[ ]` conteniendo el `CursoDto` de "Programacion Avanzada")*

### Otros Endpoints (Req. 2)
* `GET http://localhost:8080/api/cursos`
* `GET http://localhost:8080/api/profesores`
* `GET http://localhost:8080/api/estudiantes`