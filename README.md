# API de Cursos (Spring Boot)

Proyecto de API REST para la gestión de cursos, profesores y estudiantes, realizado con Spring Boot para la facultad.

## Tecnologías Utilizadas
* Java 17
* Spring Boot
* Spring Data JPA (con Hibernate)
* Base de datos H2 (con persistencia en archivo)
* Maven
* Lombok

## Estructura del Proyecto

La API sigue una arquitectura en capas basada en las correcciones recibidas:

* **Controllers:** Separados por entidad (`ProfesorController`, `EstudianteController`, `CursoController`) para manejar las peticiones HTTP.
* **Services:** Separados por entidad y usando interfaces (`IProfesorService`, `IEstudianteService`, `ICursoService`) para la lógica de negocio, con sus implementaciones (`...ServiceImpl`).
* **Repositories:** Interfaces de Spring Data JPA para el acceso a datos.
* **Models:** Entidades JPA (`Profesor`, `Estudiante`, `Curso`) utilizando Lombok para reducir código boilerplate (getters, setters, etc.).

---

## Cómo Correr el Proyecto

1.  Clonar el repositorio.
2.  Abrir el proyecto con IntelliJ IDEA.
3.  Ejecutar el método `main` de la clase `CursosApiApplication.java`.
4.  El servidor se iniciará en `http://localhost:8080`.

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

Se recomienda seguir esta secuencia de 7 pasos para probar todas las funcionalidades:

### 1. POST: Crear Profesor
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/profesores`
* **Body (JSON):**
    ```json
    { "nombre": "Juan Perez", "email": "juan.perez@email.com" }
    ```

### 2. POST: Crear Estudiante (Ana)
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/estudiantes`
* **Body (JSON):**
    ```json
    { "nombre": "Ana Gomez", "matricula": "A-123" }
    ```

### 3. POST: Crear Estudiante (Luis)
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/estudiantes`
* **Body (JSON):**
    ```json
    { "nombre": "Luis Paz", "matricula": "L-456" }
    ```

### 4. POST: (Req. 3) Crear Curso
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/cursos?profesorId=1`
* **Body (JSON):**
    ```json
    { "nombre": "Programacion Avanzada" }
    ```

### 5. POST: (Req. 4) Asignar Ana al Curso
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/cursos/1/estudiantes/1`
* **Body:** `none`

### 6. POST: (Req. 4) Asignar Luis al Curso
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/cursos/1/estudiantes/2`
* **Body:** `none`

### 7. GET: (Req. 5) Ver Cursos de Ana
* **Método:** `GET`
* **URL:** `http://localhost:8080/api/estudiantes/1/cursos`
* *(Devuelve la lista de cursos de Ana)*

### Otros Endpoints (Req. 2)
* `GET http://localhost:8080/api/cursos`
* `GET http://localhost:8080/api/profesores`
* `GET http://localhost:8080/api/estudiantes`