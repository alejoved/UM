# Segundo parcial de Ingeniería de Software

## Examen práctico: API de eventos y recintos

**Modalidad:** individual  
**Tecnología base:** Java 21, Spring Boot, Maven, Spring Web, Spring Data JPA, PostgreSQL y Lombok

### Contexto

Una empresa organizadora de eventos necesita una aplicación para consultar y registrar eventos y recintos. Construya la aplicación siguiendo la misma arquitectura por capas del proyecto `tiendavirtual`: controladores, DTOs, modelos, entidades JPA, mappers, interfaces e implementaciones de repositorio y servicios.

El proyecto de referencia separa el desarrollo de la persistencia y usa el flujo **Controller → Service → Repository → JPA**. Mantenga esa separación; no acceda directamente al repositorio desde un controlador ni exponga entidades JPA en las respuestas.

## Indicaciones de construcción

### 1. Crear y configurar el proyecto

1. Cree un proyecto Maven con Spring Boot y una clase principal en el paquete raíz `com.example.agenciaviajes`.
2. Incluya dependencias equivalentes a las de `tiendavirtual`: Spring Web, Spring Data JPA, Validation, el driver PostgreSQL y Lombok. Use Java 21.
3. Configure `application.properties` para conectar a una base de datos PostgreSQL llamada `agencia_viajes` y habilite la actualización del esquema durante el desarrollo (`spring.jpa.hibernate.ddl-auto=update`). No publique credenciales reales en el repositorio.
4. Cree los paquetes para `controllers`, `dtos`, `entitites`, `exceptions`, `mappers`, `models`, `repositories.interf`, `repositories.impl`, `services.interf` y `services.impl`. Para mantener compatibilidad con el proyecto de referencia, use el nombre `entitites` tal como aparece allí.

## 2. Definir los recursos

Implemente los siguientes dos recursos. Cada entidad debe tener un identificador UUID generado por JPA.

**Evento (`Event`)**

- Código único del evento, nombre, organizador y ciudad.
- Fecha y hora de inicio y finalización.
- Precio de la entrada y cantidad de cupos disponibles.
- Reglas: el precio debe ser mayor que cero; los cupos disponibles no pueden ser negativos; la finalización debe ser posterior al inicio.

**Recinto (`Venue`)**

- Nombre, ciudad, dirección y tipo de recinto (por ejemplo, teatro, auditorio o centro de convenciones).
- Tarifa de alquiler por día y cantidad de espacios disponibles.
- Reglas: la tarifa debe ser mayor que cero; los espacios disponibles no pueden ser negativos.

### 3. Seguir las capas del proyecto de referencia

Para cada recurso, cree las clases e interfaces necesarias siguiendo el estilo de `Customer` y `Product`:

1. **Entidad:** clase JPA con `@Entity`, nombre de tabla explícito y columnas. Configure el código del evento como único. Use `BigDecimal` para tarifas y precios.
2. **Modelo:** clase de dominio independiente de la entidad, con los datos necesarios para las operaciones de negocio.
3. **DTOs:** cree un DTO de creación y otro de respuesta. No reciba ni devuelva entidades JPA desde los controladores. En los DTOs de respuesta incluya los identificadores y la información necesaria para que el consumidor comprenda el resultado.
4. **Mapper:** implemente conversiones explícitas entre entidad y modelo, y entre modelo y DTO cuando corresponda. Puede seguir el estilo de métodos estáticos usado en los mappers del proyecto base.
5. **Repositorio:** defina una interfaz de dominio en `repositories.interf`, una interfaz Spring Data que extienda `JpaRepository` y una implementación en `repositories.impl`. Incluya búsquedas por UUID, código de evento y nombre de recinto cuando sean necesarias.
6. **Servicio:** defina la interfaz y su implementación. Ubique en el servicio las reglas de disponibilidad, validaciones de negocio y coordinación entre repositorios.
7. **Controlador:** exponga endpoints REST usando `ResponseEntity`. El controlador solo debe traducir la petición, invocar el servicio y construir la respuesta HTTP.

## 4. Endpoints requeridos

Use la ruta base `/api` y documente para cada operación el método, la ruta, los datos esperados y el código HTTP. Use rutas diferenciadas para las búsquedas por UUID y por código o nombre, de modo que no haya ambigüedad.

| Recurso | Método y ruta | Datos esperados | Respuesta esperada |
|---|---|---|---|
| Eventos | `GET /api/events` | Ninguno. | `200 OK`, lista de eventos. |
| Eventos | `GET /api/events/{id}` | UUID en la ruta. | `200 OK` con el evento o `404 Not Found`. |
| Eventos | `GET /api/events/code/{code}` | Código del evento en la ruta. | `200 OK` con el evento o `404 Not Found`. |
| Eventos | `POST /api/events` | DTO de creación del evento en el cuerpo. | `201 Created` con el evento creado; `400 Bad Request` si los datos no son válidos. |
| Recintos | `GET /api/venues` | Ninguno. | `200 OK`, lista de recintos. |
| Recintos | `GET /api/venues/{id}` | UUID en la ruta. | `200 OK` con el recinto o `404 Not Found`. |
| Recintos | `GET /api/venues/name/{name}` | Nombre del recinto en la ruta. | `200 OK` con el recinto o `404 Not Found`. |
| Recintos | `POST /api/venues` | DTO de creación del recinto en el cuerpo. | `201 Created` con el recinto creado; `400 Bad Request` si los datos no son válidos. |

### 5. Pruebas y entrega

Verifique cada endpoint con Postman, incluyendo solicitudes válidas y casos de error de validación o recurso inexistente.

## Criterios de evaluación

| Criterio | Puntaje |
|---|---:|
| Estructura por capas y separación de responsabilidades coherentes con `tiendavirtual` | 20% |
| Entidades, modelos, asociaciones y persistencia JPA | 20% |
| DTOs y mappers; no exponer entidades en la API | 20% |
| Repositorios e implementación de servicios | 20% |
| Endpoints, controladores funcionando | 20% |
| **Total** | **100** |
