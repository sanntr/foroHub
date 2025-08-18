# Foro Alura API 🚀

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)


## 📋 Descripción

API REST desarrollada para el foro de Alura, una plataforma que permite a los usuarios crear tópicos de discusión sobre cursos, compartir dudas y responder preguntas. El proyecto implementa un sistema completo de autenticación y autorización, gestión de usuarios, tópicos y respuestas.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.x**
  - Spring Security para autenticación y autorización
  - Spring Data JPA para persistencia
  - Spring Validation para validación de datos
  - Spring MVC para la capa web
- **Flyway** para migraciones de base de datos
- **JWT (JSON Web Token)** para manejo de sesiones
- **SpringDoc** para documentación de la API
- **Maven** como gestor de dependencias

## ✨ Características Principales

### 👥 Gestión de Usuarios
- Registro y autenticación de usuarios
- Perfiles de usuario (ADMIN, MODERADOR, USUARIO)
- Gestión de datos personales
- Autenticación segura con JWT

### 📝 Gestión de Tópicos
- Creación, edición y eliminación de tópicos
- Categorización por cursos
- Estado de tópicos (ABIERTO, SOLUCIONADO, CERRADO)
- Paginación y filtrado de resultados


## 🏗️ Arquitectura

El proyecto sigue los principios de Clean Architecture, organizando el código en capas:

```
src/
├── main/
│   ├── java/com/alura/challenge/foro/
│   │   ├── application/              # Capa de Aplicación
│   │   │   ├── dto/                  # Data Transfer Objects
│   │   │   └── service/              # Servicios de negocio
│   │   ├── controller/               # Controladores REST
│   │   ├── domain/                   # Capa de Dominio
│   │   │   ├── model/               # Entidades
│   │   │   └── repository/          # Interfaces repositorio
│   │   └── infrastructure/           # Capa de Infraestructura
│   │       ├── security/            # Configuración seguridad
│   │       └── exception/           # Manejo de excepciones
│   └── resources/
│       └── db/migration/            # Scripts Flyway
```

## 🚀 Endpoints

### Autenticación
```http
POST /login              # Iniciar sesión
```
### Usuarios
```http
POST /usuario/crear      # Registrar nuevo usuario
DELETE /usuario/{id}     # Buscar un usuario
GET /usuario             # LIstar todos los usuarios
```

### Tópicos
```http
GET    /topicos              # Listar tópicos (paginado)
POST   /topicos              # Crear tópico
GET    /topicos/{id}         # Ver detalle de tópico
PUT    /topicos/{id}         # Actualizar tópico
DELETE /topicos/{id}         # Eliminar tópico
```

### Respuestas
```http
GET    /respuestas/topico/{id}  # Ver respuestas de un tópico
POST   /respuestas              # Crear respuesta
PUT    /respuestas/{id}         # Actualizar respuesta
DELETE /respuestas/{id}         # Eliminar respuesta
```

## ⚙️ Configuración del Proyecto

### Prerrequisitos
- Java 17
- Maven 3.8+
- MySQL/PostgreSQL
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### Pasos para Ejecutar

1. Clonar el repositorio
```bash
git clone https://github.com/sanntr/foroHub.git
```

2. Configurar la base de datos en `application.properties`
```properties
spring.datasource.url=${DATASOURCE_URL}
spring.datasource.username=${DATASOURCE_USERNAME}
spring.datasource.password=${DATASOURCE_PASSWORD}
```

## 🔒 Seguridad

- Autenticación basada en JWT
- Protección contra CSRF
- Validación de datos en endpoints
- Encriptación de contraseñas
- Control de acceso basado en roles

### Ejemplo de Header de Autorización
```http
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

## 📚 Documentación

La documentación de la API está disponible en:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI: `http://localhost:8080/v3/api-docs`


## 📝 Versionado de Base de Datos

El proyecto utiliza Flyway para el control de versiones de la base de datos:

- `V1__create-all-table-.sql`: Estructura inicial
- `V2__alter-topics-add-active.sql`: Adición de campo active



Desarrollado con ❤️ por [sanntr](https://github.com/sanntr) como parte del Challenge Backend de Alura.

[⬆️ Volver arriba](#foro-alura-api-)
