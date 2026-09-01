# Taller de Diseño de Sistemas de Información

## Modelos de proyecto

| Proyecto | Integrantes |
| --- | --- |
| **FACTURAYA** | Jonathan Jaramillo, Jenny Paola Buitrago Osorio |
| **NOTASYA** | Hilder Tangarife, Johntatan Sierra |
| **DOCTORYA** | Daniel Stiven Ramirez |
| **VEHICULOSYA** | Christopher Osorio |
| **VIAJAYA** | Sofia Giraldo |

## Contenido

- [Tareas generales](#tareas-generales)
- [Requisitos por proyecto](#requisitos-por-proyecto)
- [Primera fase](#primera-fase)
- [Paso a paso de la construcción](#paso-a-paso-de-la-construccion)

## Tareas generales

- Crear un repositorio público en GitHub con el formato `[nombre]-[proyecto]`.
- Enviar el enlace del repositorio al correo `jlaguirre@umanizales.edu.co`.
- Mantener el repositorio público y documentar el proyecto en un archivo `README.md`.

## Requisitos por proyecto

### FACTURAYA

- **Entidades:** Cliente, Producto y Factura.
    - **Cliente:** Nombre, Tipo de identificación, Número de identificación, Teléfono y Correo.
    - **Producto:** Referencia, Nombre, Precio y Stock.
    - **Factura:** Fecha, Secuencia, Cliente, Productos y Valor total.
- **Funcionalidades:**
    - **Cliente:** `ObtenerTodosLosClientes`, `ObtenerClientePorTipoYNumeroIdentificacion`, `ObtenerClientePorCorreo`, `CrearCliente`, `ActualizarCliente`.
    - **Producto:** `ObtenerTodosLosProductos`, `ObtenerProductoPorReferencia`, `CrearProducto`, `ActualizarProducto`.
    - **Factura:** `ObtenerTodasLasFacturas`, `ObtenerFacturaPorSecuencia`, `CrearFactura`, `ActualizarFactura`.

### NOTASYA

- **Entidades:** Estudiante, Profesor y Curso.
    - **Estudiante:** Nombre, Teléfono y Correo.
    - **Profesor:** Nombre, Tipo de identificación, Número de identificación y Especialidad.
    - **Curso:** ID, Nombre, Estudiante, Profesor y Calificación.
- **Funcionalidades:**
    - **Estudiante:** `ObtenerTodosLosEstudiantes`, `ObtenerEstudiantePorCorreo`, `CrearEstudiante`, `ActualizarEstudiante`.
    - **Profesor:** `ObtenerTodosLosProfesores`, `ObtenerProfesorPorTipoYNumeroIdentificacion`, `CrearProfesor`, `ActualizarProfesor`.
    - **Curso:** `ObtenerTodosLosCursos`, `ObtenerCursoPorId`, `CrearCurso`, `ActualizarCurso`.

### DOCTORYA

- **Entidades:** Médico, Paciente y Cita.
    - **Médico:** Nombre, Tipo de identificación, Número de identificación, Especialidad, Teléfono y Correo.
    - **Paciente:** Nombre, Tipo de identificación, Número de identificación, Fecha de nacimiento, Teléfono y Correo.
    - **Cita:** Fecha, Hora, Motivo, Estado, Médico y Paciente.
- **Funcionalidades:**
    - **Médico:** `ObtenerTodosLosMedicos`, `ObtenerMedicoPorTipoYNumeroIdentificacion`, `ObtenerMedicoPorCorreo`, `CrearMedico`, `ActualizarMedico`.
    - **Paciente:** `ObtenerTodosLosPacientes`, `ObtenerPacientePorTipoYNumeroIdentificacion`, `ObtenerPacientePorCorreo`, `CrearPaciente`, `ActualizarPaciente`.
    - **Cita:** `ObtenerTodasLasCitas`, `ObtenerCitaPorId`, `CrearCita`, `ActualizarCita`.

### VEHICULOSYA

- **Entidades:** Vehículo, Seguro SOAT y Certificado tecnomecánico.
    - **Vehículo:** Placa, Marca, Modelo, Año, Color, Propietario, Seguro SOAT y Certificado tecnomecánico.
    - **Seguro SOAT:** Número de póliza, Fecha de expedición, Fecha de vencimiento y Entidad aseguradora.
    - **Certificado tecnomecánico:** Número de certificado, Fecha de expedición, Fecha de vencimiento y Centro de diagnóstico.
- **Funcionalidades:**
    - **Vehículo:** `ObtenerTodosLosVehiculos`, `ObtenerVehiculoPorPlaca`, `CrearVehiculo`, `ActualizarVehiculo`.
    - **Seguro SOAT:** `ObtenerTodosLosSegurosSOAT`, `ObtenerSeguroSOATPorNumeroDePoliza`, `CrearSeguroSOAT`, `ActualizarSeguroSOAT`.
    - **Certificado tecnomecánico:** `ObtenerTodosLosCertificadosTecnomecanicos`, `ObtenerCertificadoTecnomecanicoPorNumero`, `CrearCertificadoTecnomecanico`, `ActualizarCertificadoTecnomecanico`.

### VIAJAYA

- **Entidades:** Vuelo, Hotel y Reserva.
    - **Vuelo:** Número de vuelo, Origen, Destino, Fecha y hora de salida, Fecha y hora de llegada, Capacidad y Estado.
    - **Hotel:** Nombre, Dirección, Ciudad, Teléfono, Correo y Categoría.
    - **Reserva:** Código, Fecha de reserva, Fecha de inicio, Fecha de finalización, Número de personas, Vuelo, Hotel y Estado.
- **Funcionalidades:**
    - **Vuelo:** `ObtenerTodosLosVuelos`, `ObtenerVueloPorNumero`, `CrearVuelo`, `ActualizarVuelo`.
    - **Hotel:** `ObtenerTodosLosHoteles`, `ObtenerHotelPorNombre`, `CrearHotel`, `ActualizarHotel`.
    - **Reserva:** `ObtenerTodasLasReservas`, `ObtenerReservaPorCodigo`, `CrearReserva`, `ActualizarReserva`.

## Primera fase

### Entregables

- Construir el desarrollo con FastAPI y Python, conectado a una base de datos PostgreSQL.
- Aplicar una arquitectura por capas: DTOs -> Controladores -> Servicios -> Repositorios.
- Crear el diagrama de clases en PlantUML.
- Crear los diagramas de secuencia en PlantUML.
- Crear el diagrama de despliegue.
- Implementar un patrón de diseño creacional.
- Implementar un patrón de diseño estructural.
- Implementar un patrón de diseño de comportamiento.
- Aplicar los principios SOLID.
- Implementar el despliegue en Vercel o Railway (opcional).

### Paso a paso de la construcción

El siguiente procedimiento se debe aplicar al proyecto asignado: DOCTORYA, VEHICULOSYA, VIAJAYA, NOTASYA, FACTURAYA.

#### 1. Crear el proyecto y preparar el entorno

1. Crear un repositorio publico en GitHub con el formato `[nombre]-[proyecto]`.
2. Crear un entorno virtual de Python y activarlo.
3. Instalar las dependencias principales: FastAPI, Uvicorn, SQLAlchemy, Psycopg, Pydantic y Alembic.
4. Crear un archivo `.env` para guardar la URL de conexion a PostgreSQL y cualquier otro dato de configuracion. Este archivo no debe publicarse en GitHub.
5. Crear un archivo `requirements.txt` y un `README.md` con la descripcion del proyecto, la forma de instalarlo y la forma de ejecutarlo.

#### 2. Organizar la arquitectura por capas

Crear una estructura similar a la siguiente:

```text
app/
|-- main.py
|-- config/
|   |-- database.py
|   |-- settings.py
|-- models/
|-- dtos/
|-- repositories/
|-- services/
|-- controllers/
|-- patterns/
|-- tests/
```

- `models`: contiene las entidades y sus tablas de base de datos.
- `dtos`: contiene los esquemas Pydantic para recibir datos y devolver respuestas.
- `repositories`: contiene exclusivamente las consultas y operaciones contra PostgreSQL.
- `services`: contiene las reglas de negocio y las validaciones del sistema.
- `controllers`: contiene las rutas de FastAPI; recibe la solicitud, llama al servicio y entrega la respuesta.
- `patterns`: contiene las implementaciones de los patrones de diseño.
- `tests`: contiene las pruebas unitarias y de los endpoints.

El flujo de una solicitud debe ser:

```text
Actor -> Controlador -> Servicio -> Repositorio -> PostgreSQL
Actor <- Controlador <- Servicio <- Repositorio <- PostgreSQL
```

El controlador no debe consultar directamente la base de datos y el repositorio no debe contener reglas de negocio.

#### 3. Diseñar las entidades y las relaciones

1. Convertir cada entidad del proyecto en un modelo SQLAlchemy.
2. Definir una llave primaria para cada entidad y los tipos de datos de sus atributos.
3. Definir restricciones como campos obligatorios, valores unicos y fechas validas.
4. Crear las relaciones entre las entidades.
    - DOCTORYA: un medico y un paciente pueden tener muchas citas; cada cita pertenece a un medico y a un paciente.
    - VEHICULOSYA: un vehiculo se relaciona con su seguro SOAT y su certificado tecnomecanico.
    - VIAJAYA: una reserva relaciona un vuelo y un hotel.
5. Crear las migraciones con Alembic y ejecutarlas en PostgreSQL.
6. Elaborar el diagrama de clases en PlantUML mostrando atributos, operaciones y relaciones.

#### 4. Construir los DTOs

Para cada entidad crear, como minimo, los siguientes esquemas:

- DTO de creacion: contiene los campos necesarios para registrar un nuevo elemento.
- DTO de actualizacion: permite modificar los campos autorizados.
- DTO de respuesta: define la informacion que devuelve la API e incluye el identificador.

Los DTOs deben validar formatos como correos electronicos, fechas, numeros positivos y campos obligatorios. No se deben exponer directamente los modelos de base de datos en las respuestas.

#### 5. Implementar los repositorios

Crear un repositorio por entidad con las operaciones solicitadas en el taller. Por ejemplo, en DOCTORYA:

1. `MedicoRepository`: listar, buscar por tipo y numero de identificacion, buscar por correo, crear y actualizar.
2. `PacienteRepository`: listar, buscar por tipo y numero de identificacion, buscar por correo, crear y actualizar.
3. `CitaRepository`: listar, buscar por identificador, crear y actualizar.

Aplicar el mismo criterio a las entidades de VEHICULOSYA y VIAJAYA. Cada repositorio debe usar la sesion de SQLAlchemy, confirmar las operaciones de escritura y cerrar o liberar la sesion correctamente.

#### 6. Implementar los servicios

1. Recibir los DTOs y utilizar el repositorio correspondiente.
2. Verificar reglas de negocio antes de guardar la informacion.
    - DOCTORYA: validar que el medico y el paciente existan y que la cita no se cruce con otra cita del medico.
    - VEHICULOSYA: impedir placas repetidas y verificar que las fechas de vencimiento sean posteriores a las fechas de expedicion.
    - VIAJAYA: verificar disponibilidad del vuelo y del hotel antes de crear una reserva.
    - FACTURAYA: Verificar Stock del producto antes de crear la factura.
3. Convertir los errores de negocio en respuestas claras, por ejemplo `404` cuando no existe un registro, `409` cuando hay un duplicado o conflicto y `422` cuando los datos no son validos.
4. Devolver el DTO de respuesta sin incluir detalles internos de la base de datos.

#### 7. Crear los controladores y endpoints

1. Crear un router de FastAPI para cada entidad.
2. Asociar cada endpoint con el DTO de entrada, el servicio y el DTO de respuesta.
3. Usar los verbos HTTP de forma consistente:
    - `GET` para obtener todos los registros o buscar uno.
    - `POST` para crear un registro.
    - `PUT` o `PATCH` para actualizar un registro.
4. Definir codigos de respuesta, documentacion y parametros en Swagger.
5. Registrar todos los routers en `main.py` y agregar un endpoint de salud, por ejemplo `GET /health`.

#### 8. Aplicar los patrones de diseño

Implementar y documentar un patron de cada categoria:

- Creacional: **Factory Method** para crear DTOs, servicios o configuraciones segun el tipo de proyecto.
- Creacional: **Singleton** para la creacion unica de la conexion a la base de datos
- Estructural: **Adapter** para aislar la aplicacion de un proveedor externo, como un servicio de correo, pagos o disponibilidad.
- De comportamiento: **Strategy** para encapsular reglas que pueden variar, como validacion de disponibilidad, calculo de tarifas o notificaciones.

Para cada patron incluir el problema que resuelve, las clases participantes, y una prueba que demuestre su funcionamiento.

#### 9. Aplicar los principios SOLID

1. Mantener una responsabilidad por clase: los controladores enrutan, los servicios aplican reglas y los repositorios acceden a datos.
2. Programar contra interfaces o contratos para poder cambiar PostgreSQL o un proveedor externo sin modificar los servicios.
3. Separar interfaces pequenas y enfocadas por entidad o responsabilidad.
4. Permitir extender estrategias y repositorios sin modificar el codigo estable.
5. Evitar que una clase dependa de implementaciones concretas; inyectar sus dependencias desde la configuracion o desde FastAPI.

Documentar en el README donde se evidencia cada principio.

#### 10. Crear el diagrama de clase, los diagramas de secuencia y de despliegue

1. Elaborar un diagrama de secuencia para una operacion de consulta.
2. Elaborar otro para una operacion de creacion o actualizacion, mostrando validaciones y errores.
3. En los diagramas incluir Cliente, Controlador, Servicio, Repositorio y PostgreSQL.
4. Crear el diagrama de despliegue mostrando el cliente, la API FastAPI, el servicio de PostgreSQL y, si aplica Railway.

#### 11. Probar el sistema

1. Probar los DTOs con datos validos e invalidos.
2. Probar los servicios con repositorios simulados para verificar las reglas de negocio.
3. Cubrir los casos de registro, consulta, actualizacion, duplicados, elementos inexistentes y conflictos de negocio.
4. Probar la conexion a una base de datos de desarrollo antes de realizar el despliegue.

#### 12. Ejecutar y desplegar

1. Ejecutar localmente la API con `uvicorn app.main:app --reload`.
2. Verificar la documentacion en `/docs` y el endpoint `/health`.
3. Configurar las variables de entorno en la plataforma de despliegue.
4. Desplegar la API en Railway y conectar su base de datos PostgreSQL.
5. Si se utiliza Vercel, configurar el proyecto para enrutar las solicitudes hacia la API.
6. Ejecutar las migraciones en la base de datos de produccion.
7. Probar nuevamente los endpoints publicados y documentar la URL, las variables requeridas y el procedimiento de despliegue en el README.

# Recursos

## Videos recomendados

### FastAPI y Python

- [Curso de FastAPI para principiantes](https://www.youtube.com/results?search_query=curso+FastAPI+Python+espanol): instalación, rutas, parámetros, documentación y creación de APIs.
- [FastAPI desde cero en español](https://www.youtube.com/results?search_query=FastAPI+desde+cero+espanol): conceptos básicos y construcción de un proyecto paso a paso.
- [Curso completo de Python](https://www.youtube.com/results?search_query=curso+completo+Python+espanol): variables, funciones, clases, módulos, excepciones y programación orientada a objetos.
- [Documentación oficial de FastAPI en video](https://www.youtube.com/results?search_query=FastAPI+official+tutorial+Python): tutoriales y charlas del equipo y la comunidad oficial.

### PostgreSQL y SQLAlchemy

- [Curso de PostgreSQL en español](https://www.youtube.com/results?search_query=curso+PostgreSQL+espanol): instalación, bases de datos, tablas, relaciones, consultas y restricciones.
- [PostgreSQL con Python](https://www.youtube.com/results?search_query=PostgreSQL+con+Python+espanol): conexión desde Python, consultas y operaciones CRUD.
- [SQLAlchemy con FastAPI](https://www.youtube.com/results?search_query=SQLAlchemy+FastAPI+PostgreSQL+espanol): modelos, sesiones, repositorios y relaciones con la base de datos.
- [Alembic y migraciones con SQLAlchemy](https://www.youtube.com/results?search_query=Alembic+SQLAlchemy+FastAPI+espanol): creación y ejecución de migraciones para mantener actualizado el esquema.

### Proyecto completo

- [FastAPI, PostgreSQL y SQLAlchemy: proyecto completo](https://www.youtube.com/results?search_query=FastAPI+PostgreSQL+SQLAlchemy+proyecto+completo): construcción de una API conectada a PostgreSQL.
- [API REST con FastAPI y PostgreSQL](https://www.youtube.com/results?search_query=API+REST+FastAPI+PostgreSQL+CRUD): endpoints CRUD, validación con Pydantic y persistencia de datos.
- [Arquitectura por capas con FastAPI](https://www.youtube.com/results?search_query=arquitectura+por+capas+FastAPI+Python): separación entre DTOs, controladores, servicios y repositorios.
- [Pruebas de APIs con FastAPI y Pytest](https://www.youtube.com/results?search_query=pruebas+FastAPI+Pytest+espanol): pruebas unitarias, pruebas de servicios y pruebas de endpoints.

### Despliegue

- [Desplegar FastAPI en Railway](https://www.youtube.com/results?search_query=desplegar+FastAPI+Railway+PostgreSQL): publicación de la API y conexión con una base de datos PostgreSQL.
- [Desplegar FastAPI en Vercel](https://www.youtube.com/results?search_query=desplegar+FastAPI+Vercel): configuración de una API FastAPI para ejecutarse en Vercel.
- [Variables de entorno en FastAPI](https://www.youtube.com/results?search_query=variables+de+entorno+FastAPI+PostgreSQL): configuración segura de credenciales y cadenas de conexión.

## Documentación oficial

- [FastAPI](https://fastapi.tiangolo.com/es/): documentación oficial del framework.
- [Python](https://docs.python.org/es/3/): documentación oficial del lenguaje.
- [PostgreSQL](https://www.postgresql.org/docs/): documentación oficial del motor de base de datos.
- [SQLAlchemy](https://docs.sqlalchemy.org/): documentación oficial del ORM y el acceso a datos.
- [Pydantic](https://docs.pydantic.dev/): documentación oficial para validación de datos.
- [Alembic](https://alembic.sqlalchemy.org/): documentación oficial para migraciones.

