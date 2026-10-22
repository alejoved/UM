# Proyecto: Sistema de Reservas de Vuelos y Hoteles

## Usuarios y actores

- **Agente de viajes:** registra viajeros, vuelos y hoteles; crea, consulta y cancela reservas.
- **Viajero:** persona cuyos datos se asocian a la reserva. En esta versión, el agente gestiona las operaciones en su nombre.

## Historias de usuario

Las historias se expresan desde la perspectiva del producto. La prioridad **Alta** cubre el flujo principal de una reserva; la prioridad **Media** facilita la administración y consulta del catálogo.

### Épica 1: Gestión de viajeros

#### HU-01 — Registrar un viajero

**Prioridad:** Alta  
**Como** agente de viajes, **quiero** registrar un viajero con nombre, documento de identidad, correo y teléfono, **para** asociar sus datos a una reserva.

**Criterios de aceptación**

- Dado que ingreso los datos obligatorios, cuando confirmo el registro, entonces el sistema guarda el viajero y confirma la operación.
- Dado que el documento ya está registrado, cuando intento crear otro viajero con el mismo documento, entonces el sistema informa el duplicado y no crea un segundo registro.
- Dado que falta un dato obligatorio, cuando intento guardar, entonces el sistema indica que debo completar la información.

#### HU-02 — Buscar y listar viajeros

**Prioridad:** Media  
**Como** agente de viajes, **quiero** buscar un viajero por su documento y consultar el listado de viajeros, **para** verificar sus datos al gestionar una reserva.

**Criterios de aceptación**

- Si existe el documento ingresado, la búsqueda muestra los datos principales del viajero.
- Si no existe, el sistema informa que no fue encontrado.
- El listado muestra los viajeros registrados e informa si todavía está vacío.

### Épica 2: Catálogo de vuelos y hoteles

#### HU-03 — Registrar un vuelo

**Prioridad:** Alta  
**Como** agente de viajes, **quiero** registrar un vuelo con código, aerolínea, origen, destino, fechas y horas de salida y llegada, precio y cantidad de cupos, **para** ofrecer opciones de viaje y controlar su disponibilidad.

**Criterios de aceptación**

- El sistema registra el vuelo si el código es único, el precio no es negativo, los cupos son mayores que cero y el origen es diferente del destino.
- Si el código ya existe o algún dato no es válido, el sistema rechaza el registro e informa el motivo.

#### HU-04 — Consultar vuelos

**Prioridad:** Alta  
**Como** agente de viajes, **quiero** buscar y listar vuelos, **para** encontrar una opción de viaje y revisar su precio y cupos disponibles.

**Criterios de aceptación**

- La búsqueda por código muestra aerolínea, origen, destino, salida, llegada, precio y cupos disponibles.
- El listado presenta los vuelos registrados e informa si no hay vuelos disponibles en el catálogo.
- Los vuelos sin cupos se identifican como no disponibles para nuevas reservas.

#### HU-05 — Registrar un hotel

**Prioridad:** Alta  
**Como** agente de viajes, **quiero** registrar un hotel con código, nombre, ciudad, precio por noche y cantidad de habitaciones, **para** ofrecer opciones de alojamiento y controlar su disponibilidad.

**Criterios de aceptación**

- El sistema registra el hotel si el código es único, el precio por noche no es negativo y la cantidad de habitaciones es mayor que cero.
- Si el código ya existe o algún dato no es válido, el sistema rechaza el registro e informa el motivo.

#### HU-06 — Consultar hoteles

**Prioridad:** Alta  
**Como** agente de viajes, **quiero** buscar y listar hoteles, **para** encontrar alojamiento en la ciudad de destino y conocer su precio por noche.

**Criterios de aceptación**

- La búsqueda por código muestra nombre, ciudad, precio por noche y cantidad de habitaciones registradas.
- El listado presenta los hoteles registrados e informa si el catálogo está vacío.

### Épica 3: Reservas de viaje

#### HU-07 — Crear una reserva de vuelo y hotel

**Prioridad:** Alta  
**Como** agente de viajes, **quiero** crear una reserva para un viajero que incluya un vuelo de ida y una estadía en un hotel, **para** organizar y confirmar los componentes principales de su viaje.

**Criterios de aceptación**

- La reserva tiene un código único y queda asociada a un viajero, un vuelo y un hotel existentes.
- La fecha de entrada al hotel debe ser anterior a la fecha de salida, y el hotel debe estar ubicado en la ciudad de destino del vuelo.
- La fecha de salida del vuelo no puede estar en el pasado y la entrada al hotel debe ser en la fecha de llegada del vuelo o después.
- Si falta algún elemento, no hay disponibilidad o las fechas no son válidas, el sistema no crea la reserva y explica el motivo.
- Cuando se confirma la reserva, el sistema descuenta un cupo del vuelo y una habitación para las noches seleccionadas.

#### HU-08 — Calcular el costo de la reserva

**Prioridad:** Alta  
**Como** agente de viajes, **quiero** conocer el precio del vuelo, el costo de las noches de hotel y el total, **para** informar al viajero el valor de su itinerario antes de confirmarlo.

**Criterios de aceptación**

- El costo del vuelo corresponde al precio registrado para el vuelo seleccionado.
- El costo del hotel es el precio por noche multiplicado por la cantidad de noches entre entrada y salida.
- El total es la suma del vuelo y el alojamiento.
- El sistema muestra el desglose y el total en pesos colombianos, sin incluir impuestos ni cargos adicionales.

#### HU-9 — Consultar una reserva

**Prioridad:** Alta  
**Como** agente de viajes, **quiero** buscar una reserva por su código, **para** revisar el viajero, los detalles del vuelo y hotel, las fechas, el costo y el estado.

**Criterios de aceptación**

- Si el código existe, el sistema muestra los datos asociados, el costo desglosado y el estado **Confirmada** o **Cancelada**.
- Si el código no existe, el sistema informa que la reserva no fue encontrada.

#### HU-11 — Listar reservas

**Prioridad:** Media  
**Como** agente de viajes, **quiero** listar las reservas registradas, **para** consultar los viajes confirmados y las reservas canceladas.

**Criterios de aceptación**

- El listado muestra código, viajero, vuelo, hotel, fechas y estado.
- Si no hay reservas, el sistema informa que el listado está vacío.

## Menú esperado

1. Registrar viajero
2. Buscar viajero
3. Listar viajeros
4. Registrar vuelo
5. Buscar vuelo
6. Listar vuelos
7. Registrar hotel
8. Buscar hotel
9. Listar hoteles
10. Crear reserva de vuelo y hotel
11. Buscar reserva
12. Listar reservas
13. Salir

## INGENIERIA DE REQUERIMIENTOS
**DESAROLLAR DIAGRAMA DE CASOS DE USO, CATALOGO DE CASOS DE USO, ESPECIFICACION DE CASOS DE USO, DIAGRAMA DE CLASES Y DESARROLLO DE CODIGO**
