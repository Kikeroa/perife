# API de Mutantes

Esta API detecta si una secuencia de ADN pertenece a un mutante o a un humano.

## Uso

### Detectar Mutantes

- **URL:** `/mutant`
- **Método:** POST
- **Cuerpo (JSON):** 
  ```json
  {
    "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
  }

Respuesta Exitosa: HTTP 200 OK (Mutante detectado)
Respuesta Fallida: HTTP 403 Forbidden (Humano detectado)
Estadísticas
URL: /stats
Método: GET
Respuesta Exitosa (JSON):

{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}

Requisitos Previos
Asegúrate de tener instalados los siguientes requisitos previos:

Java Development Kit (JDK) - Versión 17 
Maven - Herramienta de gestión de proyectos
Git - Control de versiones
Spring Boot - Framework para aplicaciones Java

Instalación y Ejecución
Clona el repositorio:

git clone https://github.com/tuusuario/tu-repo.git

Navega al directorio del proyecto:
cd tu-repo

Compila la aplicación con Maven:
mvn clean install

Ejecuta la aplicación Spring Boot:

mvn spring-boot:run

La API estará disponible en http://localhost:8009/