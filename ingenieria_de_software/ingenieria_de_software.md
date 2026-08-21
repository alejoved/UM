# Ingeniería del Software — Curso Completo (2 horas × 20 clases)

> Material de referencia — Universidad de Manizales  
> Última actualización: Agosto 2026 | Versión: 3.0 (Completo)

---

## Docente Jorge Alejandro Aguirre Gutierrez

**Ingeniero de Software | SRE | AWS Certified ×4**

Profesional con experiencia en diseño, desarrollo y operación de sistemas de software a escala, especializado en arquitecturas cloud, prácticas DevOps e IA.

**Certificaciones y especialidades técnicas:**

- ☁️ **AWS Certified** × 4: Solutions Architect, Developer, AI Practitioner y DevOps Engineer
- 🖥️ **Desarrollo frontend:** Angular, React
- ⚙️ **Desarrollo backend:** Spring (Java), NestJS (Node.js)
- 🗄️ **Administración de bases de datos:** Relacionales y NoSQL
- 🏗️ **Infraestructura como código (IaC):** Terraform, CloudFormation
- 🚀 **AWS DevOps:** CI/CD, automatización de infraestructura, observabilidad en nube

**Experiencia docente:**

| Institución | Programa | Nivel |
|---|---|---|
| Universidad de Caldas | Ingeniería de Sistemas | Pregrado |
| Universidad Autónoma de Manizales | Ingeniería de Sistemas | Pregrado |
| Universidad Autónoma de Manizales | Especialización en Ingeniería del Software con Énfasis en Pruebas | Posgrado |
| Universidad Autónoma de Manizales | Maestría en Ingeniería de Sistemas | Posgrado |

![alt text](../image.png)
![alt text](../image-1.png)
---

## Evaluación

| Componente | Porcentaje |
|---|---|
| Primer parcial | 20% |
| Segundo parcial | 20% |
| Tercer parcial | 20% |
| Talleres | 20% |
| Proyecto final | 20% |

---

## Índice de contenidos

**UNIDAD 1: Ciclo de vida, gestión y calidad (Clases 01-05)**
- Clase 01: Ciclo de vida del software y modelos de proceso
- Clase 02: DevOps sociotécnico y transformación cultural
- Clase 03: Planificación orientada a valor (backlog, roadmap, DoR/DoD)
- Clase 04: Estimación (Story Points, Planning Poker, Three-Point)
- Clase 05: Gestión de riesgos y calidad (ISO/IEC 25010)

**UNIDAD 2: Configuración, CI/CD y DevSecOps (Clases 06-10)**
- Clase 06: Gestión de configuración, branching y SemVer
- Clase 07: Integración continua y pipeline como código
- Clase 08: Entrega continua y estrategias de despliegue
- Clase 09: DevSecOps y OWASP Top 10
- Clase 10: SAST/DAST/SCA, SBOM y gestión de secretos

**UNIDAD 3: Operación, observabilidad e incidentes (Clases 11-15)**
- Clase 11: Los tres pilares de la observabilidad (logs, métricas, trazas)
- Clase 12: Golden Signals, SLI, SLO y Error Budgets
- Clase 13: Métricas DORA y medición del desempeño DevOps
- Clase 14: Gestión de incidentes (severidad, triage, RTO/RPO)
- Clase 15: Análisis causal y postmortem sin culpabilización

**UNIDAD 4: Mantenimiento, evolución, ética y liberación (Clases 16-20)**
- Clase 16: Tipos de mantenimiento y refactorización
- Clase 17: Migración y sistemas heredados
- Clase 18: Deuda técnica y ciclo de vida de componentes con IA
- Clase 19: Ética profesional, licencias y accesibilidad
- Clase 20: Sostenibilidad, decisión go/no-go y sustentación final

---

# UNIDAD 1. Ciclo de vida, gestión y calidad

---

## Clase 01: Ciclo de vida del software y modelos de proceso

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 1

### Objetivos de aprendizaje

Al finalizar esta clase, el estudiante será capaz de:
- Explicar los tres grupos de procesos de ISO/IEC/IEEE 12207 con ejemplos concretos.
- Comparar críticamente los modelos de proceso (cascada, iterativo, ágil, espiral, DevOps).
- Analizar un proyecto hipotético y recomendar el modelo más adecuado.
- Reconocer las implicaciones de cada modelo en términos de riesgo, velocidad y costo.

---

### Contenido teórico

#### 1. ¿Qué procesos hay en un proyecto de software? — ISO/IEC/IEEE 12207:2017

Cuando construyes software profesional, no solo escribes código. Hay muchas otras actividades: acordar qué vas a hacer, planificar el trabajo, gestionar cambios, y operar el sistema una vez desplegado.

El estándar ISO/IEC/IEEE 12207 es un **documento oficial internacional** que dice: "Estos son todos los procesos que debes considerar al desarrollar software." Es como un mapa completo de todo lo que pasa en un proyecto, desde que el cliente dice lo que quiere hasta que el usuario usa el sistema.

Agrupa los procesos en **tres categorías**:

| Grupo | ¿Para qué sirve? | Ejemplos de actividades | ¿Quién lo hace? |
|---|---|---|---|
| **Acuerdo** | Formalizar qué se va a construir y quién lo hará | Firmar contrato, definir alcance, precio | Gerente de proyecto, área legal |
| **Proyecto** | Planificar y controlar el trabajo diario | Crear cronograma, gestionar riesgos, controlar versiones | Gerente de proyecto, Scrum Master |
| **Técnicos** | Construir y verificar el software | Analizar requisitos, diseñar, codificar, probar, desplegar | Desarrolladores, QA, arquitecto |

**Clave:** Ingeniería del software **no es solo codificar**. Los acuerdos y la gestión son tan importantes como el código.

#### 2. Modelos de proceso

**Cascada (Waterfall) — "Todo planeado desde el inicio"**

Flujo: `Requisitos → Diseño → Implementación → Pruebas → Despliegue`

Cada fase debe terminar antes de empezar la siguiente. Si el cliente cambia de opinión en el mes 4, es muy caro volver atrás.

| Característica | Detalle |
|---|---|
| ¿Cuándo terminas de hablar con el cliente? | Al inicio. Luego no cambia nada |
| ¿Cuándo el cliente ve algo funcionando? | Al final del proyecto (meses o años después) |
| ¿Qué pasa si los requisitos cambian? | Costoso y complicado |

*Cuándo usarlo:* Cuando los requisitos son fijos y no van a cambiar. Ej: software de control de semáforos, aviones.  
*Cuándo NO usarlo:* Si el cliente todavía está descubriendo qué quiere.

✅ **Ventajas:** Muy predecible, fácil de presupuestar, mucha documentación.  
❌ **Desventajas:** Si algo sale mal, se descubre tarde (muy caro arreglarlo).

---

**Incremental / Iterativo — "Entregamos en partes"**

Flujo: `Sprint 1 → Feedback → Sprint 2 → Feedback → ...`

En lugar de construir todo y mostrarlo al final, entregamos partes pequeñas que funcionan cada 1-4 semanas. El cliente puede usar cada entrega y dar opiniones.

*Cuándo usarlo:* Cuando los requisitos pueden cambiar, o se necesita valor pronto.  
*Ejemplo:* App de delivery: primero solo catálogo → después carrito → después pagos.

✅ **Ventajas:** Riesgo bajo (si algo falla, lo descubres pronto), el cliente ve avances reales.  
❌ **Desventajas:** La arquitectura puede deteriorarse si no se cuida, más difícil estimar fecha de fin.

---

**Espiral (Boehm, 1986) — "Iterativo pero con énfasis en riesgos"**

Combina cascada + iterativo. En cada ciclo (espiral) se analiza qué puede salir mal y se mitiga antes de continuar.

*Cuándo usarlo:* Proyectos complejos con muchas incertidumbres técnicas. Ej: Migración de sistemas críticos de un aeropuerto.  

✅ **Ventajas:** Detecta y gestiona riesgos temprano, prototipa antes de comprometerse.  
❌ **Desventajas:** Caro y requiere un equipo con mucha experiencia. No es práctico para startups o proyectos pequeños.

---

**Ágil (Agile Manifesto, 2001) — "Rápido, colaborativo y adaptable"**

Nació como respuesta a los problemas de cascada. Prioriza personas y software funcionando sobre documentación exhaustiva.

- Ciclos cortos (sprints) de 1-4 semanas.
- El equipo se reune diariamente (standup) para ver bloqueos.
- Tests automatizadas para detectar problemas pronto.

*Cuándo usarlo:* Cuando los requisitos cambian, se necesita feedback rápido del usuario.  
*Ejemplo:* Una startup construyendo una app financiera.

✅ **Ventajas:** Entrega rápida, fácil de adaptarse a cambios, equipo motivado.  
❌ **Desventajas:** Difícil escalar a equipos grandes (>50 personas), requiere que el cliente esté disponible todo el tiempo.

---

**DevOps — "Desarrollo + Operaciones juntos"**

Tradicional: Programadores (Dev) crean el software y lo "lanzan por encima de la pared" a Operaciones (Ops) para que lo desplieguen. Resultado: conflictos y culpas.

DevOps: **El mismo equipo** construye, despliega y opera el software. La responsabilidad es compartida.

Flujo: `Código → CI (pruebas automáticas) → CD (despliegue) → Producción → Monitoreo → Feedback`

Principios clave:
- **Flujo rápido:** Un cambio llega a usuarios en horas, no meses.
- **Retroalimentación continua:** Ves en tiempo real si algo falló.
- **Aprendizaje continuo:** Cuando algo falla, se aprende cómo mejorarlo.

*Ejemplo real:* Amazon despliega un cambio cada 2 segundos. Netflix tiene 99.99% disponibilidad.

#### 3. Comparativa — ¿Cuál modelo uso para cada proyecto?

| Aspecto | Cascada | Incremental | Ágil | DevOps |
|---|---|---|---|---|
| **¿Cuándo ves algo funcionando?** | Al final (meses) | Cada pocas semanas | Cada 1-2 semanas | En horas |
| **¿Qué pasa si el cliente cambia de opinión?** | Muy caro | Se puede manejar | Fácil de adaptar | Fácil de adaptar |
| **¿Cuán rápido llegas al mercado?** | Muy lento | Medio | Rápido | Muy rápido |
| **¿Cuál es el riesgo técnico?** | Alto (problemas al final) | Medio | Bajo | Bajo |
| **¿Cuándo usarlo?** | Requisitos fijos (aviones, bancos) | Cuando se necesita valor pronto | Startups, apps de usuarios | Equipos maduros con CI/CD |

---

#### 4. ¿Qué se construye en cada fase? — Artefactos por etapa

Independientemente del modelo (cascada, ágil, DevOps), un proyecto de software atraviesa fases conceptuales. Cada fase produce **artefactos concretos y verificables**.

---

**Fase 1 — Requisitos**

> Objetivo: Entender qué debe hacer el sistema y para quién.

| Artefacto | Descripción |
|---|---|
| **Documento de visión** | Problema que resuelve, usuarios objetivo, alcance inicial |
| **Historias de usuario** | "Como *[rol]*, quiero *[acción]* para *[beneficio]*" |
| **Casos de uso** | Flujos de interacción usuario ↔ sistema |
| **Backlog priorizado** | Lista ordenada de funcionalidades por valor de negocio |
| **Criterios de aceptación** | Condiciones que determinan que una historia está "done" |
| **Prototipos / wireframes** | Bocetos de interfaz para validar con el cliente antes de codificar |
| **Glosario del dominio** | Diccionario de términos del negocio (lenguaje ubiquo) |

---

**Fase 2 — Diseño**

> Objetivo: Decidir cómo se va a construir el sistema técnicamente.

*Diseño arquitectónico (alto nivel):*

| Artefacto | Descripción |
|---|---|
| **Diagrama de arquitectura** | Estilo elegido: monolítico, microservicios, capas, hexagonal |
| **Diagrama de contexto (C4 L1)** | El sistema y sus actores/sistemas externos |
| **Diagrama de contenedores (C4 L2)** | Apps, APIs, bases de datos y cómo se comunican |
| **ADR (Architecture Decision Records)** | Por qué se eligió cada tecnología o patrón |

*Diseño detallado (bajo nivel):*

| Artefacto | Descripción |
|---|---|
| **Diagrama de clases** | Entidades, atributos, relaciones, herencia |
| **Diagrama Entidad-Relación (ER)** | Modelo de base de datos relacional |
| **Diagrama de secuencia** | Cómo interactúan los objetos en el tiempo para un caso de uso |
| **Diagrama de estados** | Ciclo de vida de una entidad (ej: `pedido: creado → pagado → enviado → entregado`) |
| **Contrato de API (OpenAPI/Swagger)** | Endpoints, request/response, códigos de error |

---

**Fase 3 — Implementación**

> Objetivo: Construir el software de forma ordenada, revisable y desplegable.

| Artefacto | Descripción |
|---|---|
| **Código fuente versionado** | Git con commits atómicos y mensajes convencionales |
| **Pull Requests con code review** | Al menos un revisor antes de mergear a main |
| **Migraciones de base de datos** | Scripts versionados (`V1__create_users.sql`) — nunca SQL manual |
| **Dockerfile / IaC** | Infraestructura como código (Terraform, Helm, Docker Compose) |
| **Configuración externalizada** | Variables de entorno separadas del código (12-Factor App) |
| **Pipeline CI configurado** | Que valide (lint + tests) cada commit automáticamente |
| **README del módulo** | Cómo levantar, configurar y contribuir al componente |

---

**Fase 4 — Pruebas**

> Objetivo: Verificar que el software funciona correcta, segura y eficientemente.

La **pirámide de pruebas** establece la proporción: muchas unitarias (baratas, rápidas) → menos de integración → pocas E2E (caras, lentas).

```
          /‾‾‾‾‾‾‾‾‾‾‾‾\
         /    E2E (UI)   \        ← Pocos, lentos, frágiles
        /‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\
       /    Integración    \      ← Moderados
      /‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\
     /      Unitarias        \    ← Muchos, rápidos, estables
    /‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\
```

| Tipo | Qué verifica | Herramientas ejemplo |
|---|---|---|
| **Unitarias** | Una función/clase aislada, sin dependencias externas | JUnit, Jest, pytest |
| **Integración** | Módulos conectados entre sí (BD, servicios, APIs) | Testcontainers, Supertest |
| **Contrato** | Que la API cumple el contrato acordado con el consumidor | Pact |
| **End-to-End (E2E)** | Flujo completo de usuario desde la interfaz | Playwright, Cypress, Selenium |
| **Rendimiento** | Latencia y comportamiento bajo carga o estrés | k6, Locust, JMeter |
| **Seguridad (SAST/DAST)** | Vulnerabilidades en código fuente y en ejecución | SonarQube, OWASP ZAP |
| **Regresión** | Que funcionalidades anteriores no se rompieron | Suite completa automatizada en CI |
| **Aceptación (UAT)** | El cliente valida que el sistema cumple los criterios de negocio | Gherkin / Cucumber |

---

**Fase 5 — Despliegue / Entrega**

> Objetivo: Llevar el software a producción de forma controlada y reversible.

| Artefacto | Descripción |
|---|---|
| **Pipeline CD** | Automatiza despliegue a staging y producción |
| **Release notes / Changelog** | Qué cambió en cada versión (siguiendo SemVer) |
| **Plan de rollback** | Cómo revertir si la nueva versión falla |
| **Feature flags** | Activar funcionalidades sin redeploy (LaunchDarkly, Unleash) |
| **Estrategia de despliegue** | Blue/Green, Canary, Rolling update — según el riesgo |

---

**Fase 6 — Mantenimiento y Operación**

> Objetivo: Operar el sistema en producción y mejorarlo de forma continua.

| Artefacto | Descripción |
|---|---|
| **Runbooks** | Guías paso a paso para operar o recuperar el sistema |
| **Dashboards de observabilidad** | Logs, métricas, trazas (Grafana, Datadog, Prometheus) |
| **Alertas** | Notificaciones automáticas ante degradación de SLOs |
| **Postmortems** | Análisis de incidentes: qué pasó, causa raíz, acciones correctivas |
| **Registro de deuda técnica** | Lo que se debe refactorizar con su impacto estimado |

---

### Ejemplos prácticos

**Ejemplo 1: Kodak — Cascada fallida**

70 años liderando fotografía. Inversión $5B en digital. Problema: Cascata en entorno incierto. Resultado: 2012 quiebra. Lección: Velocidad > dinero.

**Ejemplo 2: Netflix — Transformación DevOps**

Inicio: Cascata trimestral (DVDs). Streaming (2007): ágil + CI/CD + caos engineering. Resultado: 250M suscriptores, 99.99% uptime.

**Ejemplo 3: Proyecto: Elegir modelo**

Startup de 6 personas. Compiten con Uber. Deploy 5-10 veces/día.
- Modelo: GitHub Flow.
- Razón: Velocidad, equipos pequeños, usuarios finales.

Empresa tradicional (500 personas, software médico). Ciclo regulatorio 6 meses.
- Modelo: Git Flow.
- Razón: Múltiples versiones simultáneas, planning formal.

---

### Ejemplo integrador: Sistema de Gestión de Citas Médicas

> **Dominio:** Pacientes, Doctores, Citas y Historias Clínicas.  
> A continuación se muestran los artefactos concretos que se producirían en cada fase del ciclo de vida para este sistema.

---

#### Fase 1 — Requisitos

**Historia de usuario (formato Connextra):**

```
Como paciente registrado,
quiero agendar una cita con un doctor por especialidad y fecha disponible
para evitar desplazamientos innecesarios al consultorio.

Criterios de aceptación:
  - El sistema muestra solo horarios disponibles en tiempo real.
  - La confirmación llega por correo en menos de 2 minutos.
  - Solo puedo agendar citas a partir de mañana (no el mismo día).
  - Si el doctor cancela, recibo notificación y se libera el turno.
```

**Casos de uso — Diagrama:**

```mermaid
graph TD
    Paciente((Paciente))
    Doctor((Doctor))
    Admin((Administrador))

    Paciente --> UC1[Registrarse / Iniciar sesión]
    Paciente --> UC2[Buscar doctor por especialidad]
    Paciente --> UC3[Agendar cita]
    Paciente --> UC4[Cancelar cita]
    Paciente --> UC5[Ver historia clínica propia]

    Doctor --> UC6[Ver agenda del día]
    Doctor --> UC7[Registrar consulta / historia clínica]
    Doctor --> UC8[Cancelar cita]

    Admin --> UC9[Gestionar doctores y especialidades]
    Admin --> UC10[Generar reportes de ocupación]
```

**Glosario del dominio:**

| Término | Definición |
|---|---|
| **Cita** | Reserva de un slot de tiempo de un doctor para atender a un paciente |
| **Slot** | Bloque de tiempo disponible en la agenda de un doctor |
| **Historia Clínica** | Registro médico acumulado de todas las consultas de un paciente |
| **Especialidad** | Área médica (Cardiología, Pediatría, etc.) asociada a uno o más doctores |
| **Turno** | Jornada laboral de un doctor (mañana / tarde / noche) |

---

#### Fase 2 — Diseño

**Diagrama de contexto C4 — Nivel 1:**

```mermaid
graph TB
    P((Paciente))
    D((Doctor))
    A((Admin))

    subgraph Sistema["Sistema de Citas Médicas"]
        S[Aplicación Web / Móvil]
    end

    P -- "Agenda / cancela citas\n(HTTPS)" --> S
    D -- "Gestiona agenda\nRegistra consulta\n(HTTPS)" --> S
    A -- "Administra catálogo\n(HTTPS)" --> S

    S -- "Envía email de confirmación\n(SMTP/SendGrid)" --> Email[Servicio de Email]
    S -- "Persiste datos\n(TCP 5432)" --> DB[(PostgreSQL)]
    S -- "Autenticación\n(OAuth 2.0)" --> Auth[Auth Provider\nKeycloak / Auth0]
```

**Diagrama de clases:**

```mermaid
classDiagram
    class Paciente {
        +UUID id
        +String nombre
        +String apellido
        +Date fechaNacimiento
        +String email
        +String telefono
        +List~Cita~ citas
        +HistoriaClinica historia
        +agendarCita(doctor, slot) Cita
        +cancelarCita(citaId) void
    }

    class Doctor {
        +UUID id
        +String nombre
        +String apellido
        +String numeroColegiatura
        +Especialidad especialidad
        +List~Slot~ agenda
        +agregarSlot(fecha, hora) Slot
        +registrarConsulta(citaId, notas) Consulta
    }

    class Especialidad {
        +UUID id
        +String nombre
        +String descripcion
    }

    class Cita {
        +UUID id
        +DateTime fechaHora
        +EstadoCita estado
        +String motivoConsulta
        +Paciente paciente
        +Doctor doctor
        +Consulta consulta
        +confirmar() void
        +cancelar(motivo) void
    }

    class Slot {
        +UUID id
        +DateTime inicio
        +DateTime fin
        +Boolean disponible
        +Doctor doctor
    }

    class HistoriaClinica {
        +UUID id
        +Paciente paciente
        +List~Consulta~ consultas
        +Date fechaCreacion
        +agregarConsulta(consulta) void
    }

    class Consulta {
        +UUID id
        +DateTime fecha
        +String anamnesis
        +String diagnostico
        +String tratamiento
        +String receta
        +Doctor doctor
        +Paciente paciente
    }

    class EstadoCita {
        <<enumeration>>
        PENDIENTE
        CONFIRMADA
        CANCELADA
        COMPLETADA
        NO_ASISTIO
    }

    Paciente "1" --> "0..*" Cita : tiene
    Paciente "1" --> "1" HistoriaClinica : posee
    Doctor "1" --> "0..*" Slot : publica
    Doctor "1" --> "0..*" Cita : atiende
    Doctor "0..*" --> "1" Especialidad : pertenece
    Cita "1" --> "0..1" Consulta : genera
    HistoriaClinica "1" --> "0..*" Consulta : contiene
    Cita --> EstadoCita : tiene
```

**Diagrama Entidad-Relación:**

```mermaid
erDiagram
    PACIENTE {
        uuid id PK
        varchar nombre
        varchar apellido
        date fecha_nacimiento
        varchar email UK
        varchar telefono
        timestamp created_at
    }

    DOCTOR {
        uuid id PK
        varchar nombre
        varchar apellido
        varchar numero_colegiatura UK
        uuid especialidad_id FK
        timestamp created_at
    }

    ESPECIALIDAD {
        uuid id PK
        varchar nombre
        varchar descripcion
    }

    SLOT {
        uuid id PK
        uuid doctor_id FK
        timestamp inicio
        timestamp fin
        boolean disponible
    }

    CITA {
        uuid id PK
        uuid paciente_id FK
        uuid doctor_id FK
        uuid slot_id FK
        varchar estado
        text motivo_consulta
        timestamp fecha_hora
        timestamp created_at
    }

    HISTORIA_CLINICA {
        uuid id PK
        uuid paciente_id FK
        timestamp created_at
    }

    CONSULTA {
        uuid id PK
        uuid cita_id FK
        uuid historia_clinica_id FK
        text anamnesis
        text diagnostico
        text tratamiento
        text receta
        timestamp fecha
    }

    PACIENTE ||--o{ CITA : "agenda"
    DOCTOR   ||--o{ CITA : "atiende"
    DOCTOR   ||--o{ SLOT : "publica"
    DOCTOR   }o--|| ESPECIALIDAD : "pertenece_a"
    SLOT     ||--o| CITA : "ocupa"
    PACIENTE ||--|| HISTORIA_CLINICA : "posee"
    CITA     ||--o| CONSULTA : "genera"
    HISTORIA_CLINICA ||--o{ CONSULTA : "contiene"
```

**Diagrama de secuencia — Flujo "Agendar Cita":**

```mermaid
sequenceDiagram
    actor P as Paciente
    participant UI as Frontend (React)
    participant API as API Gateway
    participant CS as CitasService
    participant NS as NotificacionService
    participant DB as PostgreSQL

    P->>UI: Selecciona especialidad + fecha
    UI->>API: GET /doctores?especialidad=cardiologia&fecha=2026-08-20
    API->>CS: buscarSlotsDisponibles(especialidad, fecha)
    CS->>DB: SELECT slots WHERE disponible=true AND doctor.especialidad=...
    DB-->>CS: Lista de slots
    CS-->>API: Slots disponibles
    API-->>UI: 200 OK [{doctor, slots[]}]
    UI-->>P: Muestra grilla de horarios

    P->>UI: Selecciona slot y confirma
    UI->>API: POST /citas {pacienteId, slotId, motivo}
    API->>CS: agendarCita(pacienteId, slotId, motivo)
    CS->>DB: BEGIN TRANSACTION
    CS->>DB: UPDATE slots SET disponible=false WHERE id=slotId
    CS->>DB: INSERT INTO citas (paciente_id, slot_id, estado='CONFIRMADA', ...)
    CS->>DB: COMMIT
    DB-->>CS: Cita creada {citaId}
    CS->>NS: enviarConfirmacion(pacienteEmail, citaDetalles)
    NS-->>CS: Email encolado
    CS-->>API: Cita {id, fechaHora, doctor, estado}
    API-->>UI: 201 Created
    UI-->>P: "Cita confirmada — recibirás un correo"
```

**Diagrama de estados — Ciclo de vida de una Cita:**

```mermaid
stateDiagram-v2
    [*] --> PENDIENTE : Paciente agenda cita

    PENDIENTE --> CONFIRMADA : Sistema confirma disponibilidad
    PENDIENTE --> CANCELADA : Paciente o doctor cancela

    CONFIRMADA --> COMPLETADA : Doctor registra la consulta
    CONFIRMADA --> CANCELADA : Paciente o doctor cancela (≥24h antes)
    CONFIRMADA --> NO_ASISTIO : Paciente no se presenta

    CANCELADA --> [*]
    COMPLETADA --> [*]
    NO_ASISTIO --> [*]
```

**Contrato de API (OpenAPI 3.0):**

```yaml
openapi: 3.0.3
info:
  title: API - Sistema de Citas Médicas
  version: 1.0.0

paths:
  /citas:
    post:
      summary: Agendar una cita
      tags: [Citas]
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required: [pacienteId, slotId, motivoConsulta]
              properties:
                pacienteId:
                  type: string
                  format: uuid
                slotId:
                  type: string
                  format: uuid
                motivoConsulta:
                  type: string
                  maxLength: 500
      responses:
        '201':
          description: Cita creada exitosamente
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Cita'
        '409':
          description: El slot ya no está disponible
        '422':
          description: Datos de entrada inválidos

components:
  schemas:
    Cita:
      type: object
      properties:
        id:
          type: string
          format: uuid
        fechaHora:
          type: string
          format: date-time
        estado:
          type: string
          enum: [PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA, NO_ASISTIO]
        doctor:
          $ref: '#/components/schemas/DoctorResumen'
        motivoConsulta:
          type: string
    DoctorResumen:
      type: object
      properties:
        id:
          type: string
          format: uuid
        nombre:
          type: string
        especialidad:
          type: string
```

---

#### Fase 3 — Implementación

**Migración de base de datos versionada (Flyway):**

```sql
-- V1__create_core_tables.sql
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE especialidades (
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nombre      VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE pacientes (
    id                UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nombre            VARCHAR(100) NOT NULL,
    apellido          VARCHAR(100) NOT NULL,
    fecha_nacimiento  DATE NOT NULL,
    email             VARCHAR(255) NOT NULL UNIQUE,
    telefono          VARCHAR(20),
    created_at        TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE doctores (
    id                  UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nombre              VARCHAR(100) NOT NULL,
    apellido            VARCHAR(100) NOT NULL,
    numero_colegiatura  VARCHAR(50) NOT NULL UNIQUE,
    especialidad_id     UUID NOT NULL REFERENCES especialidades(id),
    created_at          TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE slots (
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    doctor_id   UUID NOT NULL REFERENCES doctores(id),
    inicio      TIMESTAMP NOT NULL,
    fin         TIMESTAMP NOT NULL,
    disponible  BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT slot_duracion CHECK (fin > inicio)
);

CREATE TABLE citas (
    id              UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    paciente_id     UUID NOT NULL REFERENCES pacientes(id),
    doctor_id       UUID NOT NULL REFERENCES doctores(id),
    slot_id         UUID NOT NULL REFERENCES slots(id),
    estado          VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE'
                    CHECK (estado IN ('PENDIENTE','CONFIRMADA','CANCELADA','COMPLETADA','NO_ASISTIO')),
    motivo_consulta TEXT,
    fecha_hora      TIMESTAMP NOT NULL,
    created_at      TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE historias_clinicas (
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    paciente_id UUID NOT NULL UNIQUE REFERENCES pacientes(id),
    created_at  TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE consultas (
    id                  UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    cita_id             UUID NOT NULL UNIQUE REFERENCES citas(id),
    historia_clinica_id UUID NOT NULL REFERENCES historias_clinicas(id),
    anamnesis           TEXT,
    diagnostico         TEXT NOT NULL,
    tratamiento         TEXT,
    receta              TEXT,
    fecha               TIMESTAMP NOT NULL DEFAULT NOW()
);
```

**Entidad y Repositorio (Java / Spring Boot):**

```java
// Cita.java — Entidad JPA
@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_id", nullable = false)
    private Slot slot;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCita estado = EstadoCita.PENDIENTE;

    @Column(name = "motivo_consulta", length = 500)
    private String motivoConsulta;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    public void confirmar() {
        if (this.estado != EstadoCita.PENDIENTE) {
            throw new IllegalStateException("Solo se puede confirmar una cita PENDIENTE");
        }
        this.estado = EstadoCita.CONFIRMADA;
    }

    public void cancelar() {
        if (this.estado == EstadoCita.COMPLETADA) {
            throw new IllegalStateException("No se puede cancelar una cita ya completada");
        }
        this.estado = EstadoCita.CANCELADA;
        this.slot.setDisponible(true);  // liberar el slot
    }
}

// CitaRepository.java
@Repository
public interface CitaRepository extends JpaRepository<Cita, UUID> {

    List<Cita> findByPacienteIdAndEstado(UUID pacienteId, EstadoCita estado);

    @Query("""
        SELECT c FROM Cita c
        WHERE c.doctor.id = :doctorId
          AND c.fechaHora BETWEEN :inicio AND :fin
          AND c.estado NOT IN ('CANCELADA')
        ORDER BY c.fechaHora
    """)
    List<Cita> findAgendaDoctor(
        @Param("doctorId") UUID doctorId,
        @Param("inicio") LocalDateTime inicio,
        @Param("fin") LocalDateTime fin
    );
}

// CitaService.java — Caso de uso: agendar cita
@Service
@Transactional
public class CitaService {

    private final CitaRepository citaRepo;
    private final SlotRepository slotRepo;
    private final NotificacionService notificacionService;

    public CitaService(CitaRepository citaRepo,
                       SlotRepository slotRepo,
                       NotificacionService notificacionService) {
        this.citaRepo = citaRepo;
        this.slotRepo = slotRepo;
        this.notificacionService = notificacionService;
    }

    public Cita agendarCita(UUID pacienteId, UUID slotId, String motivo) {
        Slot slot = slotRepo.findByIdWithLock(slotId)
            .orElseThrow(() -> new RecursoNoEncontradoException("Slot no encontrado"));

        if (!slot.isDisponible()) {
            throw new SlotNoDisponibleException("El horario seleccionado ya no está disponible");
        }

        slot.setDisponible(false);

        Cita cita = new Cita();
        cita.setPaciente(new Paciente(pacienteId));
        cita.setDoctor(slot.getDoctor());
        cita.setSlot(slot);
        cita.setFechaHora(slot.getInicio());
        cita.setMotivoConsulta(motivo);
        cita.confirmar();

        Cita citaGuardada = citaRepo.save(cita);
        notificacionService.enviarConfirmacionCita(citaGuardada);
        return citaGuardada;
    }
}
```

**Pipeline CI (GitHub Actions):**

```yaml
# .github/workflows/ci.yml
name: CI — Citas Médicas Backend

on:
  push:
    branches: [main, develop]
  pull_request:
    branches: [main, develop]

jobs:
  build-and-test:
    runs-on: ubuntu-latest

    services:
      postgres:
        image: postgres:16
        env:
          POSTGRES_DB: citas_test
          POSTGRES_USER: citas_user
          POSTGRES_PASSWORD: citas_pass
        ports:
          - 5432:5432
        options: --health-cmd pg_isready --health-interval 5s --health-retries 5

    steps:
      - uses: actions/checkout@v4

      - name: Set up JDK 21
        uses: actions/setup-java@v4
        with:
          java-version: '21'
          distribution: 'temurin'
          cache: maven

      - name: Build y tests
        run: mvn verify
        env:
          SPRING_DATASOURCE_URL: jdbc:postgresql://localhost:5432/citas_test
          SPRING_DATASOURCE_USERNAME: citas_user
          SPRING_DATASOURCE_PASSWORD: citas_pass

      - name: Análisis SonarQube
        run: mvn sonar:sonar -Dsonar.projectKey=citas-medicas
        env:
          SONAR_TOKEN: ${{ secrets.SONAR_TOKEN }}
```

---

#### Fase 4 — Pruebas

**Prueba unitaria — Lógica de negocio (JUnit 5):**

```java
// CitaTest.java
class CitaTest {

    @Test
    void confirmar_deberiaActualizarEstadoAConfirmada() {
        Cita cita = new Cita();
        cita.setEstado(EstadoCita.PENDIENTE);

        cita.confirmar();

        assertThat(cita.getEstado()).isEqualTo(EstadoCita.CONFIRMADA);
    }

    @Test
    void cancelar_deberiaLiberarElSlot() {
        Slot slot = new Slot();
        slot.setDisponible(false);

        Cita cita = new Cita();
        cita.setEstado(EstadoCita.CONFIRMADA);
        cita.setSlot(slot);

        cita.cancelar();

        assertThat(cita.getEstado()).isEqualTo(EstadoCita.CANCELADA);
        assertThat(slot.isDisponible()).isTrue();
    }

    @Test
    void cancelar_citaCompletada_deberiaLanzarExcepcion() {
        Cita cita = new Cita();
        cita.setEstado(EstadoCita.COMPLETADA);

        assertThatThrownBy(cita::cancelar)
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("No se puede cancelar");
    }
}
```

**Prueba de integración — API REST (Spring Boot Test):**

```java
// CitaControllerIntegrationTest.java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class CitaControllerIntegrationTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @Test
    void agendarCita_conSlotDisponible_deberiaRetornar201() throws Exception {
        UUID slotId = crearSlotDisponible();
        UUID pacienteId = crearPaciente();

        AgendarCitaRequest request = new AgendarCitaRequest(pacienteId, slotId, "Dolor de cabeza");

        mockMvc.perform(post("/citas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.estado").value("CONFIRMADA"))
            .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    void agendarCita_conSlotOcupado_deberiaRetornar409() throws Exception {
        UUID slotId = crearSlotOcupado();
        UUID pacienteId = crearPaciente();

        AgendarCitaRequest request = new AgendarCitaRequest(pacienteId, slotId, "Revisión");

        mockMvc.perform(post("/citas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isConflict())
            .andExpect(jsonPath("$.mensaje").value("El horario seleccionado ya no está disponible"));
    }
}
```

**Prueba E2E — Flujo completo (Playwright):**

```typescript
// agendar-cita.spec.ts
import { test, expect } from '@playwright/test';

test('paciente puede agendar y recibir confirmación', async ({ page }) => {
  // 1. Autenticación
  await page.goto('/login');
  await page.fill('[name=email]', 'paciente@test.com');
  await page.fill('[name=password]', 'Test1234!');
  await page.click('button[type=submit]');
  await expect(page).toHaveURL('/dashboard');

  // 2. Buscar doctor
  await page.click('text=Agendar cita');
  await page.selectOption('[name=especialidad]', 'Cardiología');
  await page.fill('[name=fecha]', '2026-08-25');
  await page.click('button:has-text("Buscar")');

  // 3. Seleccionar slot
  const primerSlot = page.locator('.slot-disponible').first();
  await expect(primerSlot).toBeVisible();
  await primerSlot.click();

  // 4. Confirmar
  await page.fill('[name=motivo]', 'Control cardíaco anual');
  await page.click('button:has-text("Confirmar cita")');

  // 5. Verificar confirmación
  await expect(page.locator('.toast-success')).toContainText('Cita confirmada');
  await expect(page).toHaveURL(/\/citas\/.+/);
});
```

---

#### Fase 5 — Despliegue

**Dockerfile multi-stage:**

```dockerfile
# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -q
COPY src ./src
RUN mvn package -DskipTests -q

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre-alpine
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
WORKDIR /app
COPY --from=build /app/target/citas-medicas-*.jar app.jar
USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

**Pipeline CD — Despliegue Canary:**

```mermaid
graph LR
    PR[Pull Request] -->|merge a main| CI[CI: Build + Tests]
    CI -->|✅ verde| STAGING[Deploy → Staging]
    STAGING --> SMOKE[Smoke tests\nautomatizados]
    SMOKE -->|✅ ok| CANARY[Deploy Canary\n10% tráfico producción]
    CANARY --> MONITOR[Monitoreo\n15 min]
    MONITOR -->|SLO ok| FULL[Rollout 100%]
    MONITOR -->|❌ error rate > 1%| ROLLBACK[Rollback automático]
```

---

#### Fase 6 — Mantenimiento y Operación

**Dashboard de observabilidad — métricas clave (Prometheus / Grafana):**

```yaml
# alertas.yml — Reglas de alerta para el sistema de citas
groups:
  - name: citas-medicas
    rules:
      - alert: AltaTasaErroresAPI
        expr: rate(http_requests_total{status=~"5.."}[5m]) > 0.01
        for: 2m
        labels:
          severity: critical
        annotations:
          summary: "Tasa de errores 5xx supera el 1%"
          runbook: "https://wiki.internal/runbooks/alta-tasa-errores"

      - alert: SlotsBloqueadosSinCita
        expr: slots_disponible_false_sin_cita_total > 50
        for: 10m
        labels:
          severity: warning
        annotations:
          summary: "Posible fuga de slots — más de 50 slots bloqueados sin cita asociada"

      - alert: LatenciaAgendarCitaAlta
        expr: histogram_quantile(0.95, rate(http_request_duration_seconds_bucket{
                endpoint="/citas", method="POST"}[5m])) > 2
        for: 5m
        labels:
          severity: warning
        annotations:
          summary: "P95 de agendar cita supera 2 segundos"
```

**Runbook — Procedimiento: Slots bloqueados sin cita:**

```markdown
## Runbook: Slots bloqueados sin cita asociada

**Alerta:** SlotsBloqueadosSinCita
**Severidad:** Warning
**Tiempo de resolución esperado:** < 30 min

### Diagnóstico
1. Verificar si hay transacciones largas abiertas:
   SELECT pid, now() - xact_start AS duracion, query
   FROM pg_stat_activity
   WHERE state = 'idle in transaction'
   ORDER BY duracion DESC;

2. Cuantificar el problema:
   SELECT COUNT(*) FROM slots s
   LEFT JOIN citas c ON c.slot_id = s.id
   WHERE s.disponible = false AND c.id IS NULL;

### Remediación
Si duracion > 5 minutos → terminar transacción: SELECT pg_terminate_backend(pid);
Liberar slots huérfanos:
   UPDATE slots SET disponible = true
   WHERE disponible = false
     AND id NOT IN (SELECT slot_id FROM citas WHERE estado != 'CANCELADA');

### Causa raíz habitual
Timeout de la aplicación luego de bloquear el slot pero antes del INSERT en citas.
Solución permanente: usar SELECT ... FOR UPDATE con timeout y manejo de excepción.
```

---

### Preguntas de reflexión

1. ¿Cascada es obsoleto o todavía tiene sentido en algún proyecto?
2. ¿Puedes usar DevOps en un proyecto de cascada? ¿Ou DevOps requiere Agile?
3. Si tienes 20 equipos trabajando en el mismo producto, ¿cómo organizas los sprints?

---

## Clase 02: DevOps — Más allá de herramientas (dimensión humana)

**Duración:** 2 horas | **Unidad:** 1

### Objetivos de aprendizaje

- Explicar que DevOps no es solo herramientas: personas + procesos + técnica.
- Identificar barreras culturales comunes en organizaciones.
- Comparar diferentes estrategias de transformación (liderazgo, equipos, híbrida).
- Entender qué métricas indican que la transformación está funcionando.

---

### Contenido teórico

#### 1. DevOps más allá de herramientas

**Mito:** DevOps = Jenkins, Kubernetes, Terraform.

**Realidad:** DevOps = Personas + Procesos + Técnica.

```
        Técnica (CI/CD, IaC, containers)
        /                              \
       /                                \
      /                                  \
     /                                    \
Personas ─────────────────── Procesos
(Cultura, confianza,        (Flujo, feedback,
autonomía, aprendizaje)      responsabilidad)
```

Ignorar un vértice → Fracaso.

#### 2. El pilar "Personas" — El más importante y el más difícil

**El problema clásico (silos):**

Dev: "Necesito desplegar ahora, tengo urgencia del cliente."  
Ops: "Lo siento, los deploys son el primer martes de cada mes."  
Resultado: Conflicto, culpa, software desactualizado, cliente insatisfecho.

**Con DevOps:**
- Ambos equipos comparten el mismo objetivo: "El sistema debe funcionar 99.9% del tiempo."
- Si el sistema cae, ambos son responsables (no solo Ops).
- La confianza se construye mediante automatización (si el deploy tiene pruebas automáticas, Ops confía en dejarlo pasar).

**Equipos autónomos:** Un equipo pequeño (6-10 personas) es dueño completo de su funcionalidad: desde los requisitos hasta el soporte en producción.

**Postmortem sin culpa (Blameless postmortem):**  
Cuando algo falla, en lugar de preguntar "¿Quién tuvo la culpa?", se pregunta "¿Qué condiciones del sistema permitieron este error?"  
Resultado: Las personas reportan errores temprano porque no temen castigo.

#### 3. El pilar "Proceso" — Cuánto tarda una idea en llegar al usuario

**Flujo de valor:** Desde que un desarrollador escribe una línea de código hasta que el usuario lo usa.

- Cascada tradicional: 6 meses.
- DevOps bien implementado: menos de 1 hora.

**Ciclos de retroalimentación (feedback loops) — Qué tan rápido sabes que algo está mal:**

| Velocidad | ¿Qué detecta? | Ejemplo |
|---|---|---|
| Segundos | Errores de sintaxis | El IDE subraya en rojo |
| Minutos | Pruebas unitarias fallan | CI ejecuta tests y falla |
| Horas | El sistema se comportó raro en producción | Monitoreo muestra métricas anómalas |
| Días | Los usuarios usan la nueva función | Analytics muestra adopción |

**Regla:** Mientras más rápido detectas un error, más barato es arreglarlo.

#### 4. El pilar "Técnica" — Las herramientas que habilitan todo

| Herramienta | ¿Qué hace? | Ejemplo |
|---|---|---|
| **CI** (Integración Continua) | Compila y ejecuta pruebas automáticamente cada vez que alguien hace un commit | GitHub Actions ejecuta 200 pruebas en 5 minutos |
| **CD** (Despliegue Continuo) | Despliega el software automáticamente si las pruebas pasan | Nuevo código en producción en 10 minutos |
| **Observabilidad** | Ver en tiempo real cómo se comporta el sistema | Grafana muestra que la latencia subió 200ms |
| **IaC** (Infraestructura como Código) | Los servidores se configuran con archivos, no a mano | Terraform crea 10 servidores en 3 minutos |

#### 5. ¿Cómo adoptan DevOps las empresas?

**Desde arriba (Top-Down):** La gerencia decide: "Hacemos DevOps." Compran herramientas, hacen capacitaciones.  
⚠️ Riesgo: Herramientas nuevas, misma cultura vieja. No cambia nada real.

**Desde abajo (Bottom-Up):** Los mismos equipos experimentan con nuevas prácticas porque ven el beneficio.  
✅ Ventaja: El cambio es genuino porque viene de quienes trabajan.  
❌ Desventaja: Muy lento, sin apoyo de dirección.

**Híbrido (el mejor):** La dirección crea el entorno (herramientas, presupuesto, permiso para experimentar) y los equipos adoptan a su ritmo.  
✅ Balance entre velocidad y adopción real.

---

### Actividad práctica: Registro y configuración de Jira

> **Objetivo:** Crear la cuenta de Jira, configurar el proyecto Scrum del grupo y dejar el entorno listo para registrar historias de usuario en la Clase 03.

---

#### Paso 1 — Crear cuenta gratuita en Jira

1. Ve a `https://www.atlassian.com/software/jira/free` → clic en **Get it free**.
2. Ingresa tu correo institucional y crea una contraseña segura.
3. Selecciona el producto **Jira Software** → **Get it free**.
4. En *"What is your team's name?"* escribe el nombre de tu grupo (ej: `Grupo-A`).
5. Avanza con **Next** hasta llegar al dashboard inicial de Jira.

---

#### Paso 2 — Crear un proyecto Scrum por grupo

Cada grupo crea **su propio proyecto** en Jira.

1. En el menú lateral haz clic en **Projects** → **Create project**.
2. Selecciona la plantilla **Scrum** → **Select**.
3. Completa los campos:
   - **Name:** Nombre del proyecto (ej: `NotasYa`, `FacturaYa`, `VehiculosYa`, `DoctorYa`, `ViajaYa`)
   - **Key:** Clave corta de 3 letras (ej: `NYA`, `FYA`, `VYA`, `DYA`, `VJA`)
   - **Access:** Private
4. Clic en **Create project**.

> **Claves recomendadas:**
>
> | Proyecto | Clave Jira |
> |---|---|
> | NotasYa | `NYA` |
> | FacturaYa | `FYA` |
> | VehiculosYa | `VYA` |
> | DoctorYa | `DYA` |
> | ViajaYa | `VJA` |

---

#### Paso 3 — Explorar el tablero Scrum

1. En el menú lateral haz clic en **Board**.
2. Observa las tres columnas por defecto: **To Do**, **In Progress**, **Done**.
3. Haz clic en **Backlog** y nota la diferencia: el Backlog acumula todas las historias; el Board muestra solo las del sprint activo.

---

#### Paso 4 — Habilitar el campo Story Points

1. Ve a **Project Settings** → **Features**.
2. Activa la opción **Estimation** (habilita el campo Story Points en los issues).
3. Ve a **Project Settings** → **Issue types** → **Story** y confirma que el campo **Story Points** aparece en el formulario del issue.

> Los Story Points se asignarán en la **Clase 04** mediante Planning Poker.

---

#### Paso 5 — Crear una Épica de prueba

1. Haz clic en **Create** (botón azul superior).
2. En **Issue type** selecciona **Epic**.
3. **Summary:** `Módulo de prueba` (o el módulo principal de tu proyecto).
4. **Epic Name:** el mismo valor.
5. Clic en **Create**.
6. Verifica que la épica aparece en el Backlog con un color asignado automáticamente.

#### Paso 6 — Crear una Historia de Usuario de prueba

---

#### Puntos de discusión post-actividad

1. ¿En qué se parece el Backlog de Jira a la "lista de TODO" de la que habla el estándar ISO/IEC/IEEE 12207?
2. ¿Qué diferencia hay entre un **Epic** y una **Story** en Jira?
3. ¿Por qué el campo Story Points está desactivado por defecto y hay que habilitarlo?

---

### Actividad práctica: Instalación y configuración de Jenkins

> **Objetivo:** Instalar Jenkins directamente en el sistema operativo, crear el primer pipeline CI y entender cómo encaja en el flujo DevOps.

**Prerrequisitos:** JDK 17 o superior instalado. Verificar con `java -version` en la terminal.

---

#### Paso 1 — Instalar Java (si no está instalado) (3 min)

Jenkins requiere Java 17 como mínimo. Según tu sistema operativo:

**Windows:**
1. Descarga el instalador JDK 17 desde [adoptium.net](https://adoptium.net).
2. Ejecuta el `.msi` y sigue el asistente (siguiente → siguiente → finalizar).
3. Verifica en PowerShell: `java -version`

**macOS:**
```bash
brew install openjdk@17
```

**Ubuntu / Debian:**
```bash
sudo apt update
sudo apt install -y openjdk-17-jdk
java -version
```

---

#### Paso 2 — Descargar e instalar Jenkins (5 min)

**Windows:**
1. Ve a [jenkins.io/download](https://www.jenkins.io/download/) → sección **LTS** → descarga el instalador `.msi`.
2. Ejecuta el instalador:
   - Elige la carpeta de instalación (por defecto `C:\Program Files\Jenkins`).
   - En **"Run service as LocalSystem"** deja la opción marcada.
   - Puerto: deja `8080`.
   - Selecciona el JDK instalado en el paso anterior.
3. Haz clic en **Install** y luego **Finish**. Jenkins queda instalado como servicio de Windows y arranca automáticamente.

**macOS:**
```bash
brew install jenkins-lts
brew services start jenkins-lts
```

**Ubuntu / Debian:**
```bash
# Agregar repositorio oficial de Jenkins
curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key \
  | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null

echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian-stable binary/" \
  | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null

sudo apt update
sudo apt install -y jenkins

# Iniciar el servicio
sudo systemctl enable jenkins
sudo systemctl start jenkins
sudo systemctl status jenkins   # debe mostrar "active (running)"
```

---

#### Paso 3 — Obtener la contraseña inicial (2 min)

Jenkins genera una contraseña de administrador al primer arranque. Recupérala según tu SO:

**Windows** (PowerShell como administrador):
```powershell
Get-Content "C:\ProgramData\Jenkins\.jenkins\secrets\initialAdminPassword"
```

**macOS:**
```bash
cat ~/.jenkins/secrets/initialAdminPassword
```

**Linux:**
```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

Copia el valor que aparece (cadena de 32 caracteres hexadecimales).

---

#### Paso 4 — Configuración inicial en el navegador (8 min)

1. Abre `http://localhost:8080` en tu navegador.
2. Pega la contraseña copiada → **Continue**.
3. Selecciona **"Install suggested plugins"** y espera a que termine (≈ 2-3 min).
4. Crea el usuario administrador:
   - Username: `admin`
   - Password: elige una segura
   - Full name y email: los tuyos
5. En **"Instance Configuration"** deja la URL `http://localhost:8080/` → **Save and Finish**.
6. Haz clic en **"Start using Jenkins"**.

---

#### Paso 5 — Crear el primer Pipeline (10 min)

1. En el dashboard, haz clic en **"New Item"**.
2. Nombre: `mi-primer-pipeline` | Tipo: **Pipeline** → **OK**.
3. Baja hasta la sección **"Pipeline"** → en **Definition** selecciona `Pipeline script`.
4. Pega el siguiente `Jenkinsfile` de ejemplo:

```groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Clonando repositorio...'
            }
        }
        stage('Build') {
            steps {
                echo 'Compilando el proyecto...'
            }
        }
        stage('Test') {
            steps {
                echo 'Ejecutando pruebas unitarias...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Desplegando a staging...'
            }
        }
    }

    post {
        success {
            echo 'Pipeline ejecutado correctamente.'
        }
        failure {
            echo 'El pipeline falló. Revisar logs.'
        }
    }
}
```

5. Haz clic en **Save**.

---

#### Paso 6 — Ejecutar y analizar el pipeline (5 min)

1. En la página del job, haz clic en **"Build Now"** (panel izquierdo).
2. Observa el **Stage View**: cada etapa aparece como una columna con su tiempo de ejecución y estado (verde = ok, rojo = fallo).
3. Haz clic en el número de build `#1` → **Console Output** para ver el log completo.
4. Identifica en el log cada mensaje `echo` de las cuatro etapas.

---

#### Paso 7 — Conectar el Pipeline a un repositorio Git (7 min)

Conectar Jenkins a un repo real es el caso de uso habitual en equipos:

1. Ve al job → **Configure**.
2. En **Pipeline → Definition**, cambia a `Pipeline script from SCM`.
3. En **SCM** selecciona `Git`.
4. En **Repository URL** ingresa la URL HTTPS de un repositorio tuyo en GitHub (puede ser público).
5. En **Branch Specifier** escribe `*/main`.
6. En **Script Path** deja `Jenkinsfile`.
7. Haz clic en **Save** → **Build Now**.

> Jenkins clonará el repositorio, leerá el `Jenkinsfile` de la raíz y ejecutará el pipeline. Así el pipeline **viaja con el código** y no vive solo dentro de Jenkins.

---

#### Puntos de discusión post-actividad

1. ¿Qué ocurre si el stage `Test` falla? ¿Se ejecuta `Deploy`?
2. ¿En qué se diferencia tener el `Jenkinsfile` en el repositorio vs. definirlo dentro de Jenkins?
3. ¿Cómo detener Jenkins si necesitas reiniciar el servicio? (`sudo systemctl stop jenkins` en Linux, `brew services stop jenkins-lts` en macOS)
4. ¿Cómo extenderías este pipeline para que ejecute pruebas reales con Maven (`mvn test`) o npm (`npm test`)?

---

### Preguntas de reflexión

1. ¿Puedes tener DevOps sin cambio cultural?
2. ¿Error budgets generan confianza o irresponsabilidad?
3. ¿Cómo medir éxito de transformación?

---

## Clase 03: Planificación orientada a valor

**Duración:** 2 horas | **Unidad:** 1

### Objetivos de aprendizaje

- Aplicar matriz Value/Effort para priorizar backlog.
- Construir roadmap orientado a valor (6-12 meses).
- Escribir Definition of Ready (DoR) para un equipo.
- Implementar Definition of Done (DoD) en sprints.

---

### Contenido teórico

#### 1. Product Backlog — La lista de TODO lo que queda por hacer

**Product Backlog:** Lista ordenada por importancia de todo lo que el equipo debe construir. Lo más importante está arriba. El equipo siempre trabaja en lo que está arriba.

**Product Owner (PO):** La persona responsable de esta lista. Representa a los usuarios y al negocio. Decide qué entra, qué es más urgente y qué se puede postergar.

**Tipos de items en el backlog:**
- **Épica:** Una función grande que se divide en historias más pequeñas. Ej: "Autenticación de usuarios"
- **Historia de usuario:** Una función pequeña que entrega valor al usuario. Ej: "Login por email"
- **Bug:** Algo que está roto y hay que arreglarlo. Ej: "Timeout de sesión no funciona"
- **Deuda técnica:** Código que funciona pero está mal escrito y hay que refactorizarlo.

**Estructura típica:**

```
1. [Epic] Autenticación de usuarios
   1.1 [Story] Login por email
   1.2 [Story] 2FA (two-factor auth)
   1.3 [Bug] Timeout de sesión no funciona

2. [Epic] Pagos y suscripciones
   2.1 [Story] Tarjeta de crédito
   2.2 [Story] Suscripción recurrente
   2.3 [Tech Debt] Refactor payment validation

3. [Epic] Reportes
   3.1 [Story] Exportar datos a CSV
   ...
```

#### 2. Matriz Valor vs. Esfuerzo — ¿Qué hacemos primero?

Con 20 funciones pedidas y solo tiempo para hacer 5, ¿cómo decides cuáles hacer?  
La respuesta: elige las que tienen **alto valor** y **poco esfuerzo**.

```
            Alto valor
                |
  "Planificar   |  "HAZ ESTO PRIMERO"
   para después"|  (valor alto, esfuerzo bajo)
                |
________________|________________→ Bajo esfuerzo
                |
   "Descartar"  |  "Si hay tiempo sobrante"
   (valor bajo, |  (valor bajo, esfuerzo bajo)
   esfuerzo alto)
            Bajo valor
```

| Cuadrante | Valor | Esfuerzo | ¿Qué hacer? |
|---|---|---|---|
| 🟢 **Quick Wins** | Alto | Bajo | ¡Hazlo primero! Máximo retorno con poco trabajo |
| 🔵 **Strategic** | Alto | Alto | Planificar para más adelante; vale la pena pero requiere recursos |
| 🟡 **Fill-Ins** | Bajo | Bajo | Llenar tiempo entre sprints; fácil de hacer pero no urgente |
| 🔴 **Speculative** | Bajo | Alto | Evitar; mucho trabajo, poco valor |

#### 3. Roadmap

Plan 6-12 meses con entregas incrementales.

**Q1:** Features de autenticación + pagos básico.  
**Q2:** Suscripciones + reportes.  
**Q3:** Integraciones con terceros.  
**Q4:** Performance + escalabilidad.

#### 4. Definition of Ready (DoR) — ¿Está lista la historia para que el equipo la trabaje?

Antes de que un programador empiece a codificar, la historia debe estar suficientemente clara. Si falta información, el equipo pierde tiempo. El DoR es el checklist mínimo:

- [ ] Criterios de aceptación claros
- [ ] Estimación consensuada
- [ ] Dependencias identificadas
- [ ] Tamaño < 8 Story Points
- [ ] Mockups (si UI)
- [ ] No bloqueadores

#### 5. Definition of Done (DoD) — ¿Está realmente terminada la historia?

"Terminado" no significa "el código corre en mi máquina". Una historia está hecha cuando cumple TODOS estos criterios:

- [ ] Código review (2 aprobaciones)
- [ ] Tests unitarios (>= 80% coverage)
- [ ] Tests integración
- [ ] Tests manuales en staging
- [ ] Documentación actualizada
- [ ] CI verde
- [ ] Product Owner aceptó

---

### Ejemplos prácticos

**Ejemplo 1: Priorizar backlog con Value/Effort**

App de delivery. 10 features solicitadas por usuarios.

| Feature | Usuarios pedían | Esfuerzo (SP) | Valor |
|---|---|---|---|
| Login Google | 500/2000 | 3 | Alto |
| Rastreo GPS en vivo | 1000/2000 | 13 | Muy alto |
| Facturación automática | 300/2000 | 5 | Medio |
| Dark mode | 200/2000 | 2 | Bajo |
| Integración Stripe | 800/2000 | 8 | Alto |

Análisis:
- **Quick Wins:** Login Google (3 SP, alto valor) → 1er sprint.
- **Strategic:** Rastreo GPS (13 SP, muy alto valor) → Sprint 3-4.
- **Fill-Ins:** Dark mode (2 SP, bajo valor) → Entre sprints.

**Ejemplo 2: Escribir DoR y DoD**

Story: "Como usuario, quiero pagar con tarjeta de crédito"

**DoR (antes de desarrollo):**
- [ ] ¿Qué campos de tarjeta? (CVC, CVV en backend, no guardar).
- [ ] ¿Integración Stripe o Paypal? (Decisión: Stripe).
- [ ] ¿PCI DSS compliance?
- [ ] Mockup UI: ¿Donde aparece formulario de pago?
- [ ] Estimación: 5 SP (consenso: Dev + QA + PO).

**DoD (antes de marcar hecho):**
- [ ] Tests: Pago válido → success. Tarjeta inválida → error.
- [ ] Documentación API: POST /api/payments.
- [ ] PO testea en staging: "Aprobado ✓".
- [ ] CI/CD verde: No introduce regresiones.

---

### Actividad práctica: Jira + Jenkins — 9 historias de usuario y sus pipelines CI

> **Objetivo:** Registrar y configurar Jira como herramienta de gestión ágil, crear las 9 historias de usuario del grupo en Jira y luego construir en Jenkins un pipeline CI asociado a cada Issue Key.

**Herramientas:** Jira Software (plan gratuito) + Jenkins (instalado en Clase 02)

---

#### 6. — Registro y configuración de Jira

##### Paso Crear cuenta gratuita en Jira

1. Ve a `https://www.atlassian.com/software/jira/free` → clic en **Get it free**.
2. Ingresa tu correo institucional y crea una contraseña.
3. Selecciona el producto **Jira Software** → **Get it free**.
4. En *"What is your team's name?"* escribe el nombre de tu grupo (ej: `Grupo-A`).
5. Selecciona **Next** hasta llegar al dashboard inicial de Jira.

##### Paso Crear un proyecto Scrum por estudiante (5 min)

Cada integrante crea **su propio proyecto** en Jira (uno por proyecto asignado):

1. En el menú lateral haz clic en **Projects** → **Create project**.
2. Selecciona la plantilla **Scrum** → **Select**.
3. Completa los campos:
   - **Name:** Nombre del proyecto asignado (ej: `NotasYa`)
   - **Key:** Clave corta de 3 letras (ver tabla abajo)
   - **Access:** Private
4. Clic en **Create project**.

> **Claves recomendadas por proyecto:**
>
> | Proyecto | Clave Jira |
> |---|---|
> | NotasYa | `NYA` |
> | FacturaYa | `FYA` |
> | VehiculosYa | `VYA` |
> | DoctorYa | `DYA` |
> | ViajaYa | `VJA` |

##### Paso Crear una Épica que agrupe las historias (3 min)

1. Dentro de tu proyecto, haz clic en **Create** (botón azul).
2. En **Issue type** selecciona **Epic**.
3. En **Summary** escribe el módulo principal (ej: `Gestión de Notas`).
4. En **Epic Name** escribe el mismo valor.
5. Clic en **Create**.

##### Paso Habilitar el campo Story Points (2 min)

1. Ve a **Project Settings** → **Features**.
2. Activa la opción **Estimation** (activa el campo Story Points en las historias).
3. Ve a **Project Settings** → **Issue types** → **Story** y confirma que el campo **Story Points** aparece en el formulario.

> Los Story Points se asignarán en la **Clase 04** mediante Planning Poker.

---

#### Parte Formación de grupos y asignación de proyectos

Forma grupos de **3 estudiantes**. Cada integrante elige un proyecto **diferente** (no se repite dentro del mismo grupo):

| Proyecto | Clave Jira | Módulos principales |
|---|---|---|
| **NotasYa** | `NYA` | Notas, Cursos, Estudiantes, Profesores |
| **FacturaYa** | `FYA` | Facturas, Productos, Clientes, Pagos |
| **VehiculosYa** | `VYA` | Vehículos, Seguros, Multas, Mantenimientos |
| **DoctorYa** | `DYA` | Citas, Doctores, Pacientes, Historia Clínica |
| **ViajaYa** | `VJA` | Vuelos, Hoteles, Reservas, Pasajeros |

Cada integrante crea **3 historias** en Jira → el grupo produce **9 historias en total**.

---

#### 7. Crear las 9 historias de usuario en Jira (20 min)

##### Paso Estructura de una historia bien formada

Cada historia se registra en Jira con los siguientes campos:

| Campo Jira | Valor a completar |
|---|---|
| **Issue type** | Story |
| **Summary** | Título corto de la historia (ej: `Registrar nota de estudiante`) |
| **Description** | Historia completa en Como/Quiero/Para + criterios Given/When/Then |
| **Epic Link** | La épica creada en el Paso A3 |
| **Labels** | Módulo al que pertenece (ej: `notas`, `facturas`, `citas`) |
| **Story Points** | Vacío por ahora — se completa en Clase 04 |

##### Paso a paso: crear una historia en Jira

1. En tu proyecto, haz clic en **Create**.
2. **Issue type:** `Story`.
3. **Summary:** Título corto de la historia.
4. **Description:** Usa esta plantilla:

```
Como   [rol del usuario]
Quiero [acción concreta que realiza]
Para   [valor o beneficio que obtiene]

--- Criterios de aceptación ---

Scenario 1: [nombre del escenario exitoso]
  Given [condición inicial del sistema o usuario]
  When  [acción que realiza el usuario]
  Then  [resultado esperado visible o verificable]

Scenario 2: [nombre del escenario de error o borde]
  Given [condición inicial]
  When  [acción inválida o límite]
  Then  [mensaje de error o comportamiento esperado]
```

5. **Epic Link:** selecciona la épica creada.
6. **Labels:** escribe el módulo.
7. **Story Points:** dejar vacío.
8. Clic en **Create**. Jira generará automáticamente la Issue Key (ej: `NYA-1`).

##### Paso Ejemplos de historias por proyecto

**NotasYa — Clave `NYA`**

| Issue Key | Summary | Como / Quiero / Para |
|---|---|---|
| `NYA-1` | Registrar nota de estudiante | Profesor / registrar la nota de un estudiante en un curso / que quede en el historial académico |
| `NYA-2` | Consultar notas por materia | Estudiante / ver mis notas por materia / saber mi promedio y cuánto necesito para aprobar |
| `NYA-3` | Generar reporte de notas del curso | Coordinador / generar el reporte de notas de un curso / enviarlo a padres al cierre del período |

**FacturaYa — Clave `FYA`**

| Issue Key | Summary | Como / Quiero / Para |
|---|---|---|
| `FYA-1` | Crear factura de venta | Cajero / crear una factura seleccionando productos del catálogo / registrar la transacción y entregar el comprobante |
| `FYA-2` | Anular factura emitida | Administrador / anular una factura emitida / corregir errores de cobro sin eliminar el registro |
| `FYA-3` | Exportar reporte de ventas en PDF | Contador / exportar el reporte de ventas del mes / presentarlo en el cierre contable mensual |

**VehiculosYa — Clave `VYA`**

| Issue Key | Summary | Como / Quiero / Para |
|---|---|---|
| `VYA-1` | Registrar mantenimiento de vehículo | Propietario / registrar un mantenimiento realizado / llevar el historial de servicio actualizado |
| `VYA-2` | Registrar multa a vehículo | Agente de tránsito / registrar una multa / notificar al propietario para que pague en línea |
| `VYA-3` | Consultar vencimiento de seguro | Propietario / ver la fecha de vencimiento de mi seguro / renovarlo antes de que expire |

**DoctorYa — Clave `DYA`**

| Issue Key | Summary | Como / Quiero / Para |
|---|---|---|
| `DYA-1` | Agendar cita médica | Paciente / agendar cita con médico disponible / ser atendido en la fecha y hora que me convenga |
| `DYA-2` | Registrar diagnóstico de consulta | Médico / registrar el diagnóstico y tratamiento / actualizar la historia clínica del paciente |
| `DYA-3` | Cancelar cita con aviso de 24h | Administrador / cancelar una cita con aviso previo / liberar el espacio y notificar al paciente |

**ViajaYa — Clave `VJA`**

| Issue Key | Summary | Como / Quiero / Para |
|---|---|---|
| `VJA-1` | Buscar vuelos por fecha y destino | Viajero / buscar vuelos disponibles / comparar opciones y elegir el mejor itinerario |
| `VJA-2` | Reservar hotel junto con el vuelo | Viajero / reservar habitación de hotel con mi vuelo / tener alojamiento garantizado al comprar el tiquete |
| `VJA-3` | Cancelar una reserva activa | Agente de viajes / cancelar una reserva / procesar el reembolso según la política vigente |

---

#### 8. Crear los Pipelines en Jenkins para cada historia (20 min)

Cada historia creada en Jira tendrá un **Pipeline CI en Jenkins** nombrado con la **Issue Key de Jira**. Esto simula la convención real de los equipos: el código de la rama, el pipeline y el ticket de Jira usan la misma clave.

```
Jira: Story NYA-1  →  Git branch: feature/NYA-1  →  Jenkins Pipeline: NYA-1
```

##### Paso Crear el Pipeline en Jenkins

1. Abre Jenkins en `http://localhost:8080`.
2. Haz clic en **New Item**.
3. **Name:** usa exactamente la Issue Key de Jira (ej: `NYA-1`, `FYA-2`, `DYA-3`).
4. Tipo: **Pipeline** → **OK**.
5. En **Pipeline → Definition** selecciona `Pipeline script`.
6. Pega la plantilla del Paso D2 adaptada a tu historia.
7. Clic en **Save** → **Build Now**.
8. Repite para las 3 historias de tu proyecto (9 pipelines totales en el grupo).

##### Paso Plantilla de Jenkinsfile

Adapta los valores de `JIRA_KEY`, `PROYECTO`, `HISTORIA_TITULO` y los textos del escenario por cada historia:

```groovy
pipeline {
    agent any

    environment {
        JIRA_KEY        = 'NYA-1'               // Issue Key de Jira — CAMBIAR
        PROYECTO        = 'NotasYa'             // Nombre del proyecto — CAMBIAR
        FEATURE_BRANCH  = "feature/${env.JIRA_KEY}"
        HISTORIA_TITULO = 'Registrar nota de estudiante' // Título de la historia — CAMBIAR
    }

    stages {

        stage('Historia de Usuario') {
            steps {
                echo "=== ${env.JIRA_KEY} | ${env.PROYECTO} ==="
                echo "Historia : ${env.HISTORIA_TITULO}"
                echo 'Como   profesor'
                echo 'Quiero registrar la nota de un estudiante en un curso'
                echo 'Para   que quede guardada y sea visible en el historial académico'
            }
        }

        stage('Criterios de Aceptación') {
            steps {
                echo '--- Scenario 1: Nota registrada exitosamente ---'
                echo '  Given: el profesor tiene sesión iniciada y el curso existe'
                echo '  When:  ingresa la nota (0.0 a 5.0) y hace clic en Guardar'
                echo '  Then:  el sistema almacena la nota y muestra confirmación'
                echo '--- Scenario 2: Nota fuera del rango ---'
                echo '  Given: el profesor intenta ingresar nota = 6.0'
                echo '  When:  hace clic en Guardar'
                echo '  Then:  el sistema muestra error: "La nota debe estar entre 0.0 y 5.0"'
            }
        }

        stage('DoR Check') {
            steps {
                echo '=== Definition of Ready ==='
                echo '[x] Historia registrada en Jira con formato Como/Quiero/Para'
                echo '[x] Criterios de aceptación en Given/When/Then'
                echo '[ ] Story Points: pendiente — se asigna en Clase 04 con Planning Poker'
                echo '[x] Sin bloqueadores conocidos'
            }
        }

        stage('Build') {
            steps {
                echo "Compilando rama: ${env.FEATURE_BRANCH}"
                // mvn clean compile    ← Java / Maven
                // npm install          ← Node.js
            }
        }

        stage('Unit Tests') {
            steps {
                echo "Ejecutando pruebas unitarias para ${env.JIRA_KEY}..."
                // mvn test
                // npm test
            }
        }

        stage('DoD Check') {
            steps {
                echo '=== Definition of Done ==='
                echo '[ ] Código en PR aprobado por 2 revisores'
                echo '[ ] Tests unitarios >= 80% cobertura'
                echo '[ ] Pipeline CI en verde'
                echo '[ ] PO aceptó en staging'
                echo "[ ] Ticket ${env.JIRA_KEY} en Jira marcado como Done"
            }
        }
    }

    post {
        success { echo "${env.JIRA_KEY} — Pipeline verde. Listo para revisión del PO." }
        failure { echo "${env.JIRA_KEY} — Pipeline rojo. Revisar Console Output." }
    }
}
```

---

#### Verificación grupal final

| # | Issue Key (Jira) | Proyecto | Historia creada en Jira | Pipeline en Jenkins | Build verde |
|---|---|---|---|---|---|
| 1 | | | ☐ | ☐ | ☐ |
| 2 | | | ☐ | ☐ | ☐ |
| 3 | | | ☐ | ☐ | ☐ |
| 4 | | | ☐ | ☐ | ☐ |
| 5 | | | ☐ | ☐ | ☐ |
| 6 | | | ☐ | ☐ | ☐ |
| 7 | | | ☐ | ☐ | ☐ |
| 8 | | | ☐ | ☐ | ☐ |
| 9 | | | ☐ | ☐ | ☐ |

---

#### Relación Jira ↔ Jenkins

```
Jira Software                        Jenkins
─────────────────────────────────────────────────────────────
Story NYA-1 (backlog)           →    Pipeline "NYA-1" creado
  ↓ desarrollador empieza            ↓ push a feature/NYA-1
Story NYA-1 (in progress)       →    Build ejecutado automáticamente
  ↓ criterios de aceptación          ↓ Unit Tests validan esos criterios
Story NYA-1 (done)              ←    Stage View verde + PR aprobado
```

---

#### Puntos de discusión post-actividad

1. ¿Por qué la Issue Key de Jira es el nombre del Pipeline en Jenkins? ¿Qué ventaja tiene esa convención?
2. ¿En qué se diferencia gestionar una historia en Jira vs. escribirla en un documento de Word o en el mismo Jenkins?
3. El stage `DoR Check` dice *"Story Points: pendiente"*. ¿Qué riesgo hay si el equipo empieza a desarrollar sin haber estimado?
   → Se asignará en la **Clase 04** con Planning Poker.

---

#### 9. Registrar cada historia como Pipeline en Jenkins

En Jenkins (`http://localhost:8080`) crea **un Pipeline por historia** (9 en total por grupo). Para cada uno:

1. Haz clic en **New Item**.
2. Nombre del item: usa el código de historia (`HUS-01`, `HUF-02`, etc.) seguido del nombre corto.
   - Ejemplo: `HUS-01-registrar-nota`
3. Tipo: **Pipeline** → **OK**.
4. En la sección **Pipeline → Definition** selecciona `Pipeline script`.
5. Pega la siguiente plantilla adaptándola a cada historia:

```groovy
pipeline {
    agent any

    environment {
        HISTORIA_ID    = 'HUS-01'          // Cambia por el código de tu historia
        PROYECTO       = 'NotasYa'          // Cambia por tu proyecto
        FEATURE_BRANCH = 'feature/HUS-01'   // Cambia por el código de tu historia
    }

    stages {

        stage('Historia de Usuario') {
            steps {
                echo """Proyecto  : ${env.PROYECTO}"""
                echo """Historia  : ${env.HISTORIA_ID}"""
                echo 'Como   profesor'
                echo 'Quiero registrar la nota de un estudiante en un curso'
                echo 'Para   que quede guardada y sea visible en el historial académico'
            }
        }

        stage('Criterios de Aceptación') {
            steps {
                echo 'Scenario 1: Nota registrada exitosamente'
                echo '  Given: el profesor tiene sesión iniciada y el curso existe'
                echo '  When:  ingresa la nota (0-5) y hace clic en Guardar'
                echo '  Then:  el sistema almacena la nota y muestra confirmación'
                echo '---'
                echo 'Scenario 2: Nota fuera del rango permitido'
                echo '  Given: el profesor intenta ingresar nota = 6'
                echo '  When:  hace clic en Guardar'
                echo '  Then:  el sistema muestra error: Nota debe estar entre 0 y 5'
            }
        }

        stage('DoR Check') {
            steps {
                echo '=== Definition of Ready ==='
                echo '[ ] Historia redactada en formato Como/Quiero/Para'
                echo '[ ] Criterios de aceptación en Given/When/Then'
                echo '[ ] Estimación pendiente (se asignará en Clase 04)'
                echo '[ ] Sin bloqueadores conocidos'
            }
        }

        stage('Build') {
            steps {
                echo "Compilando rama: ${env.FEATURE_BRANCH}"
            }
        }

        stage('Unit Tests') {
            steps {
                echo "Ejecutando pruebas unitarias para ${env.HISTORIA_ID}..."
            }
        }

        stage('DoD Check') {
            steps {
                echo '=== Definition of Done ==='
                echo '[ ] Código en PR aprobado por 2 revisores'
                echo '[ ] Tests unitarios >= 80% cobertura'
                echo '[ ] Pipeline CI en verde'
                echo '[ ] PO aceptó en staging'
            }
        }
    }

    post {
        success {
            echo "Historia ${env.HISTORIA_ID} — pipeline verde."
        }
        failure {
            echo "Historia ${env.HISTORIA_ID} — pipeline rojo. Revisar logs."
        }
    }
}
```

6. Haz clic en **Save** → **Build Now**.
7. Verifica el Stage View: deben aparecer 6 stages en verde.
8. Repite para las otras 2 historias del proyecto.

---

#### Verificación grupal (8 min)

Una vez que los 3 integrantes hayan creado sus 9 pipelines:

1. En el **Dashboard de Jenkins**, deberían verse los 9 jobs del grupo.
2. Revisa que todos muestren el ícono ✅ (último build exitoso).
3. Abre el **Console Output** de uno de los pipelines y comparte con el grupo el texto de los criterios de aceptación que imprimió.

**Lista de verificación grupal:**

| # | Historia (ID) | Proyecto | Pipeline creado | Build verde |
|---|---|---|---|---|
| 1 | | | ☐ | ☐ |
| 2 | | | ☐ | ☐ |
| 3 | | | ☐ | ☐ |
| 4 | | | ☐ | ☐ |
| 5 | | | ☐ | ☐ |
| 6 | | | ☐ | ☐ |
| 7 | | | ☐ | ☐ |
| 8 | | | ☐ | ☐ |
| 9 | | | ☐ | ☐ |

---

#### Puntos de discusión post-actividad

1. ¿Alguna historia no cumplió INVEST? ¿Cuál criterio falló y cómo la reescribirías?
2. ¿Qué diferencia hay entre un criterio de aceptación y una prueba unitaria?
3. ¿Por qué en el `DoR Check` del pipeline la estimación aparece como pendiente?
   → Se asignará en la **Clase 04**.

---

#### 10. Escribir los criterios de aceptación (5 min)

Los criterios de aceptación definen exactamente cuándo la historia está **hecha**. Se escriben en formato **Given / When / Then** (Gherkin):

```gherkin
Feature: Consulta de estado de pedido

  Scenario: Cliente consulta un pedido existente
    Given que el cliente tiene sesión iniciada
    And  tiene al menos un pedido registrado
    When accede a "Mis pedidos" y selecciona un pedido
    Then ve el estado actual: "Procesando", "Enviado" o "Entregado"
    And si el estado es "Enviado", ve la fecha estimada de llegada

  Scenario: Cliente consulta un pedido inexistente
    Given que el cliente tiene sesión iniciada
    When intenta acceder a un ID de pedido que no le pertenece
    Then recibe un mensaje de error: "Pedido no encontrado"
    And el sistema registra el intento en los logs de auditoría

  Scenario: Servicio de pedidos no disponible
    Given que el servicio de pedidos está caído
    When el cliente consulta el estado
    Then ve el mensaje: "Información temporalmente no disponible"
    And el error queda registrado en el sistema de observabilidad
```

---

#### Paso Definir el DoR y DoD de la historia (3 min)

Antes de llevarla al sprint, el equipo verifica:

**Definition of Ready (la historia puede entrar al sprint):**
- [x] Historia redactada con formato Como / Quiero / Para
- [x] Criterios de aceptación escritos en Given/When/Then
- [x] Estimación consensuada: **5 Story Points**
- [x] Endpoint del backend definido: `GET /api/orders/{id}/status`
- [x] Mockup de la pantalla aprobado por el PO
- [x] Sin bloqueadores ni dependencias sin resolver

**Definition of Done (la historia puede marcarse como terminada):**
- [x] Código en rama `feature/order-status` con PR aprobado por 2 revisores
- [x] Tests unitarios con cobertura ≥ 80 %
- [x] Tests de integración del endpoint `GET /api/orders/{id}/status`
- [x] Pipeline CI en verde (build + test + análisis de calidad)
- [x] PO probó en staging y aceptó
- [x] Documentación del endpoint actualizada en Swagger

---

#### Paso Crear el pipeline en Jenkins (15 min)

Abre Jenkins (`http://localhost:8080`), crea un nuevo item tipo **Pipeline** con el nombre `order-status-story` y pega el siguiente `Jenkinsfile`:

```groovy
pipeline {
    agent any

    environment {
        // Nombre de la rama asociada a la historia
        FEATURE_BRANCH = 'feature/order-status'
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Clonando rama: ${env.FEATURE_BRANCH}"
                // En un proyecto real:
                // git branch: "${env.FEATURE_BRANCH}", url: 'https://github.com/tu-org/tu-repo.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Compilando el proyecto...'
                // mvn clean compile   ← Java/Maven
                // npm install         ← Node.js
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Ejecutando pruebas unitarias del servicio de pedidos...'
                // mvn test -Dtest=OrderStatusServiceTest
                // npm test -- --testPathPattern=orderStatus
            }
            post {
                always {
                    echo 'Publicando reporte de tests...'
                    // junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Integration Tests') {
            steps {
                echo 'Verificando endpoint GET /api/orders/{id}/status...'
                // mvn verify -Pintegration-tests
            }
        }

        stage('Code Quality') {
            steps {
                echo 'Analizando cobertura y calidad de código...'
                // Requiere plugin SonarQube en Jenkins:
                // withSonarQubeEnv('SonarQube') { sh 'mvn sonar:sonar' }
            }
        }

        stage('DoD Check') {
            steps {
                echo '=== Verificando Definition of Done ==='
                echo '✔ Tests unitarios ejecutados'
                echo '✔ Tests de integración ejecutados'
                echo '✔ Análisis de calidad ejecutado'
                echo '⏳ Pendiente: aprobación del PO en staging'
            }
        }
    }

    post {
        success {
            echo 'Pipeline verde — Historia lista para revisión del PO en staging.'
        }
        failure {
            echo 'Pipeline rojo — Revisar logs. La historia NO cumple el DoD todavía.'
        }
    }
}
```

Haz clic en **Save** → **Build Now** y observa el Stage View.

---

#### Paso Leer e interpretar el resultado (5 min)

| Color del stage | Significado | Acción |
|---|---|---|
| 🟢 Verde | Stage pasó correctamente | Continuar |
| 🔴 Rojo | Stage falló | Revisar Console Output, corregir código y volver a ejecutar |
| 🔵 Azul (en curso) | Stage ejecutándose | Esperar |

En **Console Output** (`Build #1 → Console Output`) podrás leer línea a línea qué ejecutó Jenkins y en qué punto falló si hubo algún error.

**Relación historia ↔ pipeline:**

```
Historia de usuario
        │
        ▼
Criterios de aceptación (Given/When/Then)
        │
        ▼
Tests automatizados que validan esos criterios
        │
        ▼
Pipeline Jenkins que ejecuta esos tests en cada commit
        │
        ▼
Stage View en verde = DoD técnico cumplido
```

---

#### Puntos de discusión post-actividad

1. ¿Qué stage del pipeline corresponde directamente a cada criterio de aceptación?
2. ¿Por qué el `DoD Check` del pipeline no reemplaza la aprobación del PO en staging?
3. Si el stage `Unit Tests` pasa pero `Integration Tests` falla, ¿qué significa para la historia?
4. ¿Cómo modificarías el pipeline para que se ejecute automáticamente cada vez que alguien hace push a la rama `feature/order-status`?

---

## Clase 04: Estimación — Story Points, Planning Poker, Three-Point

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 2

### Objetivos de aprendizaje

- Aplicar Planning Poker para consensar estimaciones.
- Estimar histórico del equipo y velocidad.
- Usar Three-Point PERT para historias complejas.
- Traducir Story Points a tiempo calendario.

---

### Contenido teórico

#### 1. Story Points vs Horas — ¿Por qué no estimamos en horas?

**El problema con las horas:**  
"Esta tarea toma 8 horas" — ¿Cuáles 8 horas? ¿Con interrupciones? ¿Sin? ¿El Senior o el Junior? Las horas son subjetivas y no contemplan complejidad real.

**Story Points:** Número relativo que mide **complejidad + esfuerzo + incertidumbre** en comparación con otras historias ya conocidas.

**Analogía:** Un equipo de construcción no mide en horas exactas. Compara: "Esto es más fácil que poner una puerta (5 puntos) pero más difícil que cambiar un foco (1 punto), entonces es 3 puntos."

| Horas | Story Points |
|---|---|
| "Esto toma 8 horas" | "Esto es 5 SP" |
| Suena exacto pero no lo es | Suena relativo porque LO ES |
| No considera incertidumbre | Incluye: complejidad + riesgo + duda |
| Varía por persona | El equipo llega a un consenso |

**Equivalencia (solo de referencia, varía por equipo):**  
1 SP = ~2-4 horas en promedio para ese equipo.

#### 2. Escala de Fibonacci — Por qué usamos 1, 2, 3, 5, 8, 13, 21...

1, 2, 3, 5, 8, 13, 21, 34, ...

**Razón práctica:** A medida que algo es más grande, la incertidumbre crece de forma no lineal.
- La diferencia entre 1 y 2 SP la percibes bien (doble de trabajo).
- La diferencia entre 20 y 21 SP es imposible de percibir.
- Así, la escala gaps grandes ayudan a forzar una decisión real en lugar de una precisión falsa.

**Regla práctica:** Si una historia es 21 SP o más, dívídela en historias más pequeñas.

#### 3. Planning Poker — El equipo llega a un consenso

**¿Por qué no simplemente le preguntas al líer?** Porque el Senior y el Junior ven la misma historia de forma diferente. Planning Poker obliga a que todos piensen antes de ver las estimaciones de otros (evita que alguien influence a los demás).

**Proceso:**

1. El PO lee la historia y explica qué hace.
2. El equipo pregunta todo lo que no entiende.
3. Cada persona escribe su estimación **en privado** (1, 2, 3, 5, 8, 13 o 21 SP).
4. Todos muestran su número al mismo tiempo.
5. Si todos están cerca: la estimación queda.
6. Si hay divergencia: el de mayor y menor número explican por qué. Se debate y se vuelve a estimar.

**Ejemplo:**

Story: "Integrar pagos con Stripe"

Dev1: 5 SP.  
Dev2: 5 SP.  
Dev3: 13 SP.  
QA: 8 SP.

Debate:
- Dev3: "No sé si Stripe API es compleja".
- Dev1: "Ya lo usamos en Proyecto X. Simple".
- Dev3: "Ah, okay. Cambio a 8 SP".

**Nueva ronda:** 5, 5, 8, 8 → Consensus en 5 (Dev3 y QA bajan, otros suben). **Decisión:** 8 SP.

#### 4. Three-Point PERT — Cómo estimar cuando hay mucha incertidumbre

A veces una historia tiene mucho riesgo: depende de una API externa, nadie del equipo la hizo antes, o los requisitos no están 100% claros. En ese caso, en lugar de dar un solo número, estimamos tres escenarios:

| Escenario | Descripción | Ejemplo |
|---|---|---|
| **Optimista (O)** | Todo sale bien, sin problemas | 5 SP |
| **Realista (M)** | Caso típico con algunos imprevistos | 13 SP |
| **Pesimista (P)** | Todo sale mal, máximos problemas | 21 SP |

**Fórmula PERT:** `(O + 4×M + P) ÷ 6`

Ejemplo: `(5 + 4×13 + 21) ÷ 6 = (5 + 52 + 21) ÷ 6 = 78 ÷ 6 = **13 SP**`

**¿Por qué ×4 al realista?** Porque el caso típico pesa más que los extremos. Esta fórmula reduce el sesgo optimista que todos tenemos.

#### 5. Velocidad del equipo — Cuánto puede hacer el equipo por sprint

**Velocidad:** Promedio de Story Points terminados por sprint. Se calcula con datos históricos reales del equipo.

**Ejemplo:**
- Sprint 1: 20 SP terminados
- Sprint 2: 25 SP terminados
- Sprint 3: 18 SP terminados
- Sprint 4: 22 SP terminados
- **Velocidad promedio:** (20+25+18+22) ÷ 4 = **21 SP por sprint**

**¿Para qué sirve?** Para estimar cuánto tiempo tomará el roadmap completo:  
Si el backlog tiene 100 SP y la velocidad es 21 SP/sprint → necesitarás ~5 sprints (10 semanas a 2 semanas por sprint).

**Importante:** La velocidad varía entre equipos. No uses la velocidad de otro equipo para planificar el tuyo.

---

### Ejemplos prácticos

**Ejemplo 1: Planning Poker en vivo**

Story: "Como usuario, quiero cambiar mi contraseña"

*Criterios de aceptación:*
- Página de perfil tiene botón "Change Password".
- Solicita contraseña actual (validar).
- Solicita nueva contraseña (reglas: min 8 chars, mayúscula, número).
- Confirmar nueva.
- Backend: Hash con bcrypt, auditar cambio en logs.
- Tests: casos válidos e inválidos.

Estimaciones (Fibonacci):

| Rol | Estimación | Razón |
|---|---|---|
| Dev (5 años) | 3 SP | "He hecho esto 10 veces". |
| Dev Junior | 8 SP | "¿bcrypt? ¿Auditoría?" |
| QA | 5 SP | "Tests claros". |
| DevOps | 2 SP | "No requiere deploy especial". |

**Debate:**
- Junior: "No entiendo auditoría".
- Senior: "Guardar en tabla: user_id, timestamp, cambio_exitoso".
- Junior: "Ah, simple. Cambio a 5 SP".

**Consensus:** 5 SP.

**Ejemplo 2: Calcular velocidad y timeline**

Equipo de 5 personas. Sprint 2 semanas.

| Sprint | SP completados |
|---|---|
| 1 | 18 |
| 2 | 20 |
| 3 | 22 |
| 4 | 21 |
| 5 | 23 |

**Velocidad:** (18+20+22+21+23)/5 = 20.8 ≈ **21 SP/sprint**.

Roadmap:
- Q1: Autenticación (13 SP) + Pagos (21 SP) = 34 SP.
- Q2: Suscripciones (34 SP).
- Q3: Reportes (26 SP).

Timeline:
- 34 SP / 21 SP-sprint = 1.6 sprints (3-4 semanas) → Q1.
- 34 SP / 21 SP-sprint = 1.6 sprints → Q2.
- 26 SP / 21 SP-sprint = 1.2 sprints → Q3.
- Total: ~13 semanas ≈ 3.25 meses.

---

### Actividad práctica: Planning Poker en Jira + Actualización de Pipelines en Jenkins

> **Objetivo:** Asignar Story Points a las 9 historias creadas en Jira durante la Clase 03 mediante Planning Poker, registrar los resultados directamente en Jira, actualizar los pipelines de Jenkins con el SP acordado, y calcular cuántos sprints necesita el grupo para completar las historias.

---

#### Paso 1 — Preparar el tablero de estimación

Cada integrante del grupo necesita las **cartas de Planning Poker** con la escala de Fibonacci:

```
  1   2   3   5   8   13   21   ?   ☕
```

- `?` = No entiendo la historia, necesito más información
- `☕` = Necesito un descanso

Si no tienen cartas físicas, usen post-its o la app [planningpokeronline.com](https://planningpokeronline.com).

---

#### Paso 2 — Sesión de Planning Poker: estimar las 9 historias

Sigan este proceso para **cada una de las 9 historias** creadas en Jira durante la Clase 03:

1. El dueño de la historia (quien la creó) la lee en voz alta: *Como / Quiero / Para*.
2. El grupo hace preguntas de clarificación (máx. 1 min).
3. Cada integrante elige su carta **en privado** sin mostrarla.
4. A la cuenta de 3: todos muestran su carta al mismo tiempo.
5. Si hay consenso (diferencia ≤ 1 nivel Fibonacci): se registra ese valor.
6. Si hay divergencia: el mayor y el menor explican su razonamiento. Se vuelve a estimar.

**Registra los resultados en la siguiente tabla:**

| # | Código historia | Proyecto | Dev 1 | Dev 2 | Dev 3 | SP Final | Razón del consenso |
|---|---|---|---|---|---|---|---|
| 1 | | | | | | | |
| 2 | | | | | | | |
| 3 | | | | | | | |
| 4 | | | | | | | |
| 5 | | | | | | | |
| 6 | | | | | | | |
| 7 | | | | | | | |
| 8 | | | | | | | |
| 9 | | | | | | | |
| | | **Total SP** | | | | | |

**Guía de referencia para calibrar:**

| SP | Complejidad | Ejemplo orientativo |
|---|---|---|
| **1** | Trivial | Cambiar el texto de un label en pantalla |
| **2** | Simple | Agregar un campo de búsqueda que filtra una lista |
| **3** | Moderada | CRUD básico de una entidad (sin validaciones complejas) |
| **5** | Media | CRUD con validaciones, lógica de negocio y pruebas |
| **8** | Alta | Integración con servicio externo (pagos, email, API terceros) |
| **13** | Muy alta | Flujo complejo con múltiples entidades y estados |
| **21** | Épica — dividir | Demasiado grande para un sprint; debe partirse |

---

#### Paso 3 — Registrar los Story Points en Jira (5 min)

Con el SP acordado para cada historia, actualiza el campo en Jira:

1. Abre el ticket en Jira (ej: `NYA-1`).
2. En el panel lateral derecho busca el campo **Story Points** (o **Estimate**).
3. Haz clic en el campo y escribe el valor acordado (ej: `5`).
4. Presiona **Enter** para guardar.
5. Repite para las 9 historias del grupo.

#### Paso 4 — Crear el Sprint en Jira y agregar las historias (5 min)

1. En tu proyecto, ve a **Backlog**.
2. Haz clic en **Create Sprint** (aparece sobre el backlog).
3. Clic derecho sobre cada historia → **Move to Sprint** para agregar las 3 historias de tu proyecto al sprint.
4. Haz clic en **Start Sprint** y define:
   - **Sprint name:** `Sprint 1`
   - **Duration:** 2 semanas
   - **Start / End date:** fechas reales de la clase
5. Confirma con **Start**.

#### Paso 5 — Actualizar el DoR en Jenkins con el Story Point acordado

Vuelve a cada pipeline en Jenkins y actualiza el stage `DoR Check` con el SP acordado en Jira:

1. Ve al job en Jenkins → **Configure**.
2. Localiza en el Jenkinsfile la línea:
   ```groovy
   echo '[ ] Story Points: pendiente — se asigna en Clase 04 con Planning Poker'
   ```
3. Reemplázala con el valor acordado en Jira:
   ```groovy
   echo '[x] Story Points: 5 SP (consenso Planning Poker — registrado en Jira)'
   ```
   *(Cambia el número por el SP real de esa historia)*
4. Haz clic en **Save** → **Build Now** y verifica en el Console Output que el stage `DoR Check` muestra el SP correcto.

---

#### Paso 6 — Calcular la velocidad del grupo y proyectar el sprint (5 min)

Usando los SP totales de las 9 historias, calcula cuántos sprints necesitaría el grupo para completarlas.

**Dato de referencia:** Un equipo de 3 personas en un sprint de 2 semanas suele completar entre **15 y 25 SP** (velocidad estimada inicial: **18 SP/sprint**).

**Fórmula:**

$$
\text{Sprints necesarios} = \frac{\text{Total SP}}{\text{Velocidad del equipo (SP/sprint)}}
$$

**Ejemplo:**

| Historia | SP |
|---|---|
| HUS-01 | 3 |
| HUS-02 | 2 |
| HUS-03 | 5 |
| HUF-01 | 5 |
| HUF-02 | 3 |
| HUF-03 | 8 |
| HUV-01 | 3 |
| HUV-02 | 5 |
| HUV-03 | 2 |
| **Total** | **36 SP** |

$$
\frac{36 \text{ SP}}{18 \text{ SP/sprint}} = 2 \text{ sprints} \approx 4 \text{ semanas}
$$

Calcula el total de tu grupo y completa:

| Concepto | Valor del grupo |
|---|---|
| Total SP de las 9 historias | |
| Velocidad estimada (SP/sprint) | 18 |
| Sprints necesarios | |
| Semanas calendario | |

---

#### Puntos de discusión post-actividad

1. ¿Hubo alguna historia donde los tres integrantes estimaron muy diferente? ¿Qué causó esa divergencia?
2. ¿Alguna historia resultó ser mayor a 13 SP? Si es así, ¿cómo la dividirías en dos historias más pequeñas?
3. ¿Por qué es importante registrar el SP en Jira y no solo hablarlo en la reunión?
4. ¿Qué ventaja tiene ver los SP de todas las historias del Sprint en el Board de Jira antes de empezar a desarrollar?
5. Si la velocidad real del equipo fuera 12 SP/sprint en lugar de 18, ¿cómo cambiaría el timeline? ¿Qué historias priorizarías para el Sprint 1?

---
🔴 VOY ACA

## Clase 05: Gestión de riesgos y calidad (ISO/IEC 25010)

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 3

### Objetivos de aprendizaje

- Identificar y clasificar riesgos (probabilidad × impacto).
- Aplicar ISO/IEC 25010 para evaluar calidad del software.
- Implementar quality gates en pipeline de CI/CD.
- Calcular deuda técnica acumulada.

---

### Contenido teórico

#### 1. Gestión de riesgos

**Riesgo = Probabilidad × Impacto**

| Riesgo | Prob. | Impacto | Score | Mitigación |
|---|---|---|---|---|
| Servidor cae | Alta | Alto | 9 | Redundancia, failover automático |
| Competidor innova | Baja | Crítico | 7 | Equipo R&D, monitoreo compet. |
| Dev clave renuncia | Baja | Alto | 6 | Documentación, cross-training |
| Bug en pagos | Baja | Crítico | 8 | Tests exhaustivos, auditoría |

**Acciones:**
- **Evitar:** Cambiar decisión. Ej: No entrar a mercado con alto riesgo político.
- **Mitigar:** Reducir probabilidad o impacto. Ej: Tests para reducir riesgos de bugs.
- **Aceptar:** Entender impacto, tener plan B. Ej: Aceptar que 0.1% requests fallan, pero tenemos retry.
- **Transferir:** Contratar seguro/servicio. Ej: Cloud provider con SLA 99.99%.

#### 2. ISO/IEC 25010 — Modelo de calidad del software

Define 8 características principales:

1. **Idoneidad funcional:** ¿Software hace lo que debe?
2. **Confiabilidad:** ¿Cuándo falla? MTBF (Mean Time Between Failures)?
3. **Usabilidad:** ¿Es fácil de usar? Test con usuarios.
4. **Rendimiento:** ¿Latencia? ¿CPU/Memoria?
5. **Compatibilidad:** ¿Funciona en diferentes plataformas?
6. **Seguridad:** ¿Datos protegidos? ¿Sin vulnerabilidades?
7. **Mantenibilidad:** ¿Fácil de modificar? ¿Tests?
8. **Portabilidad:** ¿Fácil de mover a otra plataforma?

**Medición típica:**

| Característica | Métrica | Target |
|---|---|---|
| Confiabilidad | Uptime | 99.99% |
| Rendimiento | P95 latencia | < 200ms |
| Seguridad | Vulnerabilidades | 0 critical/high |
| Mantenibilidad | Code coverage | >= 80% |
| Usabilidad | Tasks completadas | >= 90% |

#### 3. Quality Gates — "El código no pasa si no cumple estos criterios"

Un quality gate es un conjunto de condiciones que tu código debe cumplir para poder integrarse al proyecto. Es como un semafóro: si algo falla, el merge queda bloqueado hasta arreglarlo.

**Ejemplo de quality gates típicos:**
```yaml
Quality Gates:
  - Cobertura de pruebas >= 80%       # Si menos del 80% del código está probado, bloquea
  - Sin bugs críticos (SonarQube)      # Ningún bug grave sin resolver
  - Sin vulnerabilidades de seguridad  # Ningún hueco de seguridad de nivel alto
  - Latencia P95 < 200ms               # El 95% de las solicitudes responden en 200ms
  - Estilo de código pasa el linter    # Código consistente con el estándar del equipo
  - Deuda técnica < 5 días             # Máximo 5 días-persona de refactorización pendiente
```

**Si falla el quality gate:** El merge se bloquea. El desarrollador debe arreglarlo antes de continuar.

#### 4. Deuda técnica — El costo de los atajos

**Analogía:** Es como endeudarse con una tarjeta de crédito. Funciona rápido ahora, pero si no pagas, los intereses crecen. Cuanta más deuda acumulas, más difícil y costoso es cada cambio futuro.

**Ejemplos comunes:**
- Pruebas manuales en lugar de automatizadas.
- Código duplicado en 5 lugares distintos.
- Funciones de 300 líneas que nadie entiende.
- Librerías con versiones viejas y vulnerabilidades conocidas.

**Cómo se mide (SonarQube):**  
"Deuda: 15 días" significa que si dedicaras a limpiar ese código exclusivamente, tardarías 15 días-persona.

**Recomendación:** Dedicar el 15-20% del tiempo de cada sprint a pagar deuda técnica. Si no lo haces, el equipo se va frenando gradualmente.

---

### Ejemplos prácticos

**Ejemplo 1: Matriz de riesgos para proyecto**

Proyecto: Migración de BD Oracle a PostgreSQL. 200GB datos. Sin downtime.

| Riesgo | Prob. | Impacto | Score | Mitigación |
|---|---|---|---|---|
| Pérdida de datos | Baja | Crítica | 8 | Backup, validación post-migración |
| Downtime >= 1 hora | Media | Alto | 7 | Replicación dual, cutover nocturno |
| Performance degrada | Media | Medio | 5 | Indexes, query optimization pre-migración |
| Compatibilidad SQL | Alta | Medio | 6 | Testing: casos edge, views complejas |

**Plan de mitigación:**

*Semana 1-2:* Setup ambiente dual (Oracle + PostgreSQL), comenzar replicación.

*Semana 3-4:* Testing exhaustivo. Corregir incompatibilidades.

*Semana 5:* Cutover: Parar escritura en Oracle (5 min), sincronizar últimos cambios a PostgreSQL, cambiar connection strings, validar datos (< 15 min total downtime).

---

**Ejemplo 2: Aplicar ISO 25010 a app de banca**

**App:** Transferencias de dinero.

| Característica | Target | Métrica actual | Gap |
|---|---|---|---|
| Idoneidad funcional | 100% casos | 98% | Casos edge en moneda extranjera |
| Confiabilidad | 99.99% uptime | 99.90% | Fallos ocasionales en picos |
| Usabilidad | 95% tareas | 87% | UX compleja para usuarios mayores |
| Rendimiento | P95 < 100ms | P95 150ms | Queries BD lentas |
| Seguridad | 0 crítica | 2 crítica | Vulnerabilidades XSS y CSRF |
| Mantenibilidad | 85% coverage | 72% | Código legacy sin tests |

**Acciones correctivas:**

1. **Seguridad (Crítica):** Fix XSS/CSRF en 1 semana.
2. **Rendimiento:** Optimizar queries, agregar índices. 2-3 sprints.
3. **Usabilidad:** Rediseño UX. 4 sprints.
4. **Mantenibilidad:** Aumentar tests. Actividad continua (20% sprint).

---

### Actividades prácticas

**Actividad 1: Matriz de riesgos**

Equipo elige proyecto real/hipotético. Identifica 5-10 riesgos, completa matriz (Prob×Impacto), propone mitigación.

**Actividad 2: Quality gates para proyecto**

Diseña 6-8 quality gates específicos para proyecto elegido. Define métricas, thresholds, cómo medirlas.

---

# UNIDAD 2. Configuración, CI/CD y DevSecOps

---

## Clase 06: Control de versiones, ramas y versionamiento semántico

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 3

### Objetivos de aprendizaje

- Elegir la estrategia de ramas adecuada para cada contexto (flujo simple, GitHub Flow, Git Flow).
- Entender qué es el versionamiento semántico y por qué importa.
- Escribir changelogs que comuniquen los cambios a usuarios y equipo.
- Resolver conflictos de merge cuando dos personas cambiaron el mismo código.

---

### Contenido teórico

#### 1. Control de versiones — ¿Qué guardamos y por qué?

**Objetivo:** Siempre poder responder: ¿Quién cambió este código? ¿Cuándo? ¿Por qué? Y poder volver atrás si algo sale mal.

**¿Qué versionamos?** No solo el código. Todo lo que necesitas para reproducir el sistema:
- Código fuente
- Pruebas automatizadas
- Migraciones de base de datos
- Configuración de infraestructura (IaC)
- Documentación

**1.2 Control de cambios:**

En cascata: Change Request formal, CCB (20+ personas), 2-4 semanas.  
En Ágil: PR, 2-3 reviewers, 24 horas.

**1.3 Registro de estado:** `git log --oneline`. Historial auditable.

**1.4 Auditoría:** ¿Qué versión está en producción? Verificar: `git show v1.2.3:VERSION`.

#### 2. Estrategias de branching

**Trunk-Based Development (TBD):**

**Trunk-Based Development (Flujo en rama principal) — "Todos en la misma rama"**

Todos los desarrolladores trabajan en ramas muy cortas (menos de 1 día de vida) y hacen merge a `main` constantemente. El CI detecta conflictos en minutos.

Cuándo usarlo: Equipos experimentados con muchas pruebas automáticas, que despliegan más de una vez por día.  
Ejemplo: Stripe (más de 1,000 commits por día).

---

**GitHub Flow:**

**GitHub Flow — "Ramas cortas, deploy frecuente"**

Cada funcionalidad vive en su propia rama (1-2 días). Cuando está lista, abres un Pull Request, alguien revisa, se aprueba y se despliega automáticamente.

Cuándo usarlo: Apps web/móvil donde despliegas frecuentemente, equipos pequeños-medianos.  
Ejemplo: GitHub mismo.

---

**Git Flow:**

**Git Flow — "Múltiples versiones en paralelo"**

Tiene varias ramas de larga duración: `main` (lo que está en producción), `develop` (trabajo en curso), ramas de `feature`, `release` y `hotfix`.

Cuándo usarlo: Software que tiene múltiples versiones activas al mismo tiempo, o ciclos de lanzamiento largos (meses).  
Ejemplo: WordPress tiene v1.x y v2.x en producción simultáneamente.

#### 3. Versionamiento Semántico (SemVer) — ¿Qué significa cada número?

Formato: `MAJOR.MINOR.PATCH`

| Número | ¿Qué significa? | Ejemplo de cambio | Ejemplo |
|---|---|---|---|
| **MAJOR** | Cambió algo y el código viejo ya no funciona | Eliminaste un endpoint de la API | `1.0.0` → `2.0.0` |
| **MINOR** | Nueva función, pero lo de antes sigue funcionando | Agregaste un endpoint nuevo | `1.0.0` → `1.1.0` |
| **PATCH** | Solo arreglaste un bug, nada nuevo | Corregiste un error de cálculo | `1.0.0` → `1.0.1` |

**Regla clave:** Si usas una librería y ves que su MAJOR cambió (ej: de `3.x.x` a `4.x.x`), revisa si tu código sigue compatible antes de actualizar.

#### 4. Changelog — "Qué cambió en esta versión"

Es un archivo (`CHANGELOG.md`) que lista en lenguaje humano qué cambió en cada versión. Lo leen los usuarios, desarrolladores y equipos de soporte.

**Secciones típicas:**
```markdown
## [1.2.0] - 2026-08-15

### Agregado (Added)
- Soporte para múltiples monedas en la API de pagos

### Corregido (Fixed)
- Error de división por cero en el cálculo de impuestos

### Eliminado (Removed)
- Endpoint XML de legado (ya deprecado desde v1.1)
```

**¿Por qué es importante?** Si un cliente actualiza tu librería y algo se rompe, el changelog le dice exactamente qué cambió y por qué.

---

### Ejemplos prácticos

**Ejemplo 1: Conflicto de merge y resolución**

Dev1 (feature/multi-currency):
```javascript
function calculateTax(amount, currency) {
  const rates = { USD: 0.08, EUR: 0.19 };
  return amount * rates[currency];
}
```

Dev2 (feature/tax-regional):
```javascript
function calculateTax(amount, region) {
  const rates = { USA: 0.08, EU: 0.19 };
  return amount * rates[region];
}
```

**Conflicto:** Ambos modifican función. Solución: Sentarse juntos. Combinar.

```javascript
function calculateTax(amount, currencyOrRegion) {
  const rates = {
    USD: 0.08, EUR: 0.19, USA: 0.08, EU: 0.19
  };
  return amount * rates[currencyOrRegion];
}
```

**Lección:** Conflictos = oportunidad de comunicación y diseño mejorado.

---

**Ejemplo 2: Estrategia branching para équipo**

**Scenario A: Startup fintech (6 personas, deploy 10/día)**

Decisión: GitHub Flow.

- Feature branch < 1 día.
- PR → review (30 min) → merge.
- Deploy automático.
- Usuarios ven cambio en < 4 horas.

---

**Scenario B: Empresa tradicional (500 personas, software médico, release cada 6 meses)**

Decisión: Git Flow.

- `main`: v1.0 en producción (tagueada v1.0.0, v1.0.1, v1.1.0).
- `develop`: v2.0 en desarrollo.
- Release branch: 8 semanas antes de release para hardening + regulación.
- Hotfix: Bug crítico en v1.0 → hotfix → v1.0.1.

---

### Actividades prácticas

**Actividad 1: Modelar branching strategy (12 min)**

App web SaaS. 20 personas. Deploy 2-3/semana. Elige estrategia. Dibuja flujo. Describe proceso "feature a producción".

**Actividad 2: Escribir changelog (13 min)**

v1.3.0 → v1.4.0. Cambios: nuevo endpoint, bug fix, deprecation. Escribe entrada changelog (formato Keep a Changelog).

---

## Clase 07: Integración Continua (CI) — Verificación automática del código

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 4

### Objetivos de aprendizaje

- Entender qué es la Integración Continua y para qué sirve.
- Diseñar un pipeline de CI con sus fases (compilación, pruebas, calidad, seguridad).
- Escribir un pipeline como código con GitHub Actions.
- Identificar y aplicar estrategias para hacer un pipeline más rápido.

---

### Contenido teórico 

#### 1. ¿Qué es la Integración Continua (CI)?

**Problema sin CI:** 10 desarrolladores trabajan en ramas separadas por 2 semanas. Cuando unen el código, hay conflictos masivos, bugs inesperados y nadie sabe qué rompió qué. Se llama "Integration Hell" (infierno de integración).

**Con CI:** Cada desarrollador integra su código al repositorio varias veces por día. Un sistema automático verifica inmediatamente que nada se rompió.

**Los 3 pilares de CI:**
- 🤖 **Automatización:** El sistema compila, prueba y analiza sin que nadie lo haga a mano.
- ✅ **Verificación:** Si algo falla, el sistema avisa inmediatamente (en minutos, no días).
- ⚡ **Rapidez:** El feedback llega rápido para que puedas corregir mientras recuerdas qué cambiaste.

#### 2. Cómo funciona un pipeline de CI

Un **pipeline** es una serie de pasos automáticos que se ejecutan cada vez que alguien hace un commit. Si cualquier paso falla, el pipeline para y notifica al desarrollador.

```
git push
  ↓
GitHub notifica al servidor CI
  ↓
Paso 1: Compilar (2 min) ─ instala dependencias, compila
  ↓
Paso 2: Pruebas (5 min) ─ pruebas unitarias e integración
  ↓
Paso 3: Calidad (3 min) ─ SonarQube analiza, linting
  ↓
Paso 4: Seguridad (3 min) ─ busca vulnerabilidades en el código
  ↓
Paso 5: Empaquetado (2 min) ─ crea imagen Docker lista para desplegar
  ↓
✅ LISTO ─ El código está listo para hacer merge/deploy
```

**Total: ~15 minutos.** En 15 minutos sabes si tu cambio rompió algo o no.

#### 3. Pipeline como código — El pipeline también se versiona

**Antes (Malo):** El pipeline se configuraba en la interfaz gráfica de Jenkins. Si alguien lo cambiaba, nadie sabía qué cambió. No quedaba historial.

**Ahora (Bien):** El pipeline se escribe en un archivo `.yml` que vive en el mismo repositorio que el código. Ventajas: se versiona con git, se revisa con Pull Request, es reproducible.

```yaml
# .github/workflows/ci.yml
name: CI

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-node@v2
        with:
          node-version: '18'
      - run: npm install
      - run: npm test
      - run: npm run lint
```

**Ventajas:**
- Versionado (git history).
- Revisable (code review antes de merge).
- Reproducible.
- Auditable.

#### 4. Quality Gates

Criterios que bloquean merge si fallan:

```yaml
Quality Gates:
  - Test coverage >= 80%
  - No new bugs (SonarQube)
  - No vulnerabilidades high/critical
  - Code style pasa
  - Performance P95 < 200ms
```

#### 5. Optimization: 45 min → 10 min

Estrategias:

1. **Paralelización:** Tests en paralelo.
2. **Caché:** npm cache, Docker layers.
3. **Shallow clone:** `--depth 1`.
4. **Incrementalidad:** Solo test changed files.
5. **Container optimization:** Multi-stage, alpine.

---

### Ejemplos prácticos

**Ejemplo 1: Diagnosar fallo de pipeline**

Pipeline falla:
```
npm ERR! 404 Not Found - GET npm registry
npm ERR! 'my-custom-lib' not found
```

Investigación:
- `grep my-custom-lib package.json` → typo? No.
- `npm view my-custom-lib` → No existe.
- `git log -p package.json` → Dev cambió "my-lib" a "my-custom-lib".
- Fix: Corregir typo. Push. Pipeline pasa.

**Lección:** CI falla = ¡Oportunidad de aprender! Errores atrapados acá, no en producción.

---

**Ejemplo 2: Pipeline optimizado**

Baseline: 45 minutos.

```
Build: 5 min
Test: 15 min
Lint: 3 min
SonarQube: 12 min
Docker build: 5 min
Push registry: 5 min
─────────
45 min
```

Optimizaciones:

1. Test + Lint en paralelo: 15 + 3 → max(15, 3) = 15. **Ahorro: 3 min.**
2. npm cache: 5 min → 30 seg. **Ahorro: 4.5 min.**
3. SonarQube solo en main, no en cada PR: 12 min × 90%. **Ahorro: 11 min.**
4. Docker multi-stage + alpine: 5 + 5 → 2. **Ahorro: 8 min.**

**Resultado:** 45 → 10 minutos.

---

### Actividades prácticas

**Actividad 1: Diseñar pipeline (12 min)**

Proyecto Node.js + DB. Lenguaje: JavaScript. Requisitos: tests, lint, security scan, coverage >= 80%.

Diseña: 5-6 stages, duración estimada, quality gates.

**Actividad 2: Escribir pipeline as code (13 min)**

GitHub Actions workflow para proyecto anterior. Archivo `.github/workflows/ci.yml`.

---

#### Ejercicio de código — Clase 07: Construir un pipeline CI real

**Objetivo:** Escribir desde cero un pipeline de CI funcional y el código que lo acompaña.

**Contexto:** Tienes una API REST en Python (Flask) con un endpoint de suma. Tu tarea es escribir:
1. La función con su prueba unitaria.
2. El pipeline GitHub Actions que la verifica automáticamente en cada commit.

---

**Paso 1 — Escribe la función y su prueba (10 min)**

Crea el archivo `app.py`:

```python
# app.py
def sumar(a: float, b: float) -> float:
    """Suma dos números. Lanza ValueError si alguno no es numérico."""
    if not isinstance(a, (int, float)) or not isinstance(b, (int, float)):
        raise ValueError("Solo se aceptan números")
    return a + b
```

Crea el archivo `test_app.py`:

```python
# test_app.py
import pytest
from app import sumar

# ✅ Caso normal
def test_sumar_enteros():
    assert sumar(3, 4) == 7

# ✅ Números negativos
def test_sumar_negativos():
    assert sumar(-5, 3) == -2

# ✅ Decimales
def test_sumar_decimales():
    assert sumar(1.5, 2.5) == 4.0

# ✅ Suma con cero
def test_sumar_cero():
    assert sumar(0, 100) == 100

# ❌ Texto → debe lanzar error
def test_sumar_texto_lanza_error():
    with pytest.raises(ValueError):
        sumar("hola", 5)
```

**Ejecuta localmente para verificar:**
```bash
pip install pytest
pytest test_app.py -v
```

Salida esperada:
```
test_app.py::test_sumar_enteros      PASSED
test_app.py::test_sumar_negativos    PASSED
test_app.py::test_sumar_decimales    PASSED
test_app.py::test_sumar_cero         PASSED
test_app.py::test_sumar_texto_lanza_error PASSED

5 passed in 0.12s
```

---

**Paso 2 — Escribe el pipeline CI (15 min)**

Crea el archivo `.github/workflows/ci.yml`:

```yaml
# .github/workflows/ci.yml

name: Pipeline CI — Verificación automática

# ¿Cuándo se ejecuta?
on:
  push:
    branches: [main, develop]   # Al subir cambios a estas ramas
  pull_request:
    branches: [main]            # Al abrir un Pull Request hacia main

jobs:
  verificar:
    name: Verificar código
    runs-on: ubuntu-latest       # Servidor limpio con Ubuntu

    steps:
      # 1. Descargar el código del repositorio
      - name: Descargar código
        uses: actions/checkout@v4

      # 2. Instalar Python
      - name: Configurar Python 3.11
        uses: actions/setup-python@v5
        with:
          python-version: "3.11"

      # 3. Instalar dependencias del proyecto
      - name: Instalar dependencias
        run: pip install pytest pytest-cov

      # 4. Ejecutar pruebas y medir cobertura
      - name: Ejecutar pruebas
        run: pytest test_app.py -v --cov=app --cov-report=term-missing

      # 5. Verificar que cobertura >= 80%
      - name: Verificar cobertura mínima
        run: pytest test_app.py --cov=app --cov-fail-under=80
```

---

**Paso 3 — Simula un fallo (reflexión, 5 min)**

Modifica `sumar` para que falle:
```python
def sumar(a, b):
    return a - b   # ← error intencional
```

Sube el cambio. ¿Qué muestra el pipeline? ¿Qué prueba falla primero?

**Preguntas de cierre:**
- ¿Qué pasaría si eliminamos el paso "Verificar cobertura mínima"?
- ¿Por qué el pipeline usa `ubuntu-latest` y no tu computador directamente?
- ¿Cómo agregarías un paso de lint con `flake8` o `pylint`?

---

## Clase 08: Despliegue continuo y estrategias para lanzar sin apagar el sistema

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 4

### Objetivos de aprendizaje

- Entender la diferencia entre Entrega Continua y Despliegue Continuo.
- Aplicar las 3 estrategias de despliegue: rolling, blue-green y canary.
- Diseñar un plan de rollback (cómo volver atrás si algo falla).
- Monitorear un despliegue para detectar problemas pronto.

---

### Contenido teórico

#### 1. Entrega Continua vs. Despliegue Continuo

Ambas se llaman "CD" pero son distintas:

| | Entrega Continua | Despliegue Continuo |
|---|---|---|
| **¿Qué hace?** | Prepara el código para ir a producción automáticamente | Envia el código a producción automáticamente |
| **¿Quién aprieta el botón?** | Una persona decide cuándo despliegar | Nadie — si las pruebas pasan, va solo |
| **¿Cuándo usarlo?** | Cuando el negocio quiere control sobre el momento del lanzamiento | Cuando confías en tus pruebas y quieres velocidad máxima |
| **Ejemplo** | Amazon tiene 100 despliegos/día pero aprobados por una persona | GitHub deploys cada commit que pasa todos los tests |

#### 2. Estrategias de despliegue

**Rolling Deploy — "Reemplazar de a poco"**

Tienes 5 servidores corriendo V1. Los reemplazas de a uno con V2:
- Servidor 1: V2 (los otros 4 siguen en V1)
- Monitorear 2 minutos...
- Servidor 2: V2 (los otros 3 siguen en V1)
- ... y así hasta completar los 5.

Tiempo total: ~10 minutos. Downtime: casi cero.

✅ **Ventaja:** Económico, no necesitas el doble de servidores.  
❌ **Desventaja:** Volver atrás tarda (tienes que reemplazar todos de nuevo).

---

**Blue-Green Deploy — "Cambiar el interruptor"**

Mantenes dos ambientes idénticos: **Blue** (el activo) y **Green** (en espera).
- Despliegas V2 en Green (mientras Blue sigue funcionando).
- Pruebas Green. Todo OK.
- Cambias el enrutador: el tráfico ahora va a Green.
- Blue queda como respaldo. Si algo falla, reviertes en segundos.

✅ **Ventaja:** Rollback instantáneo (cambias el interruptor de vuelta).  
❌ **Desventaja:** Necesitas el doble de servidores (costo más alto).

---

**Canary Deploy — "Probar con pocos usuarios primero"**

El nombre viene de los canarios que se usaban en minas de carbón: si el canario caía, había gas. Aquí, si el 5% de usuarios ve errores, paras antes de afectar al 100%.

- 5% del tráfico → V2. Monitorear 30 minutos.
- Si la tasa de errores está bien: 25% → V2.
- Si sigue bien: 100% → V2.
- Si sube la tasa de errores en cualquier momento: Rollback instantáneo al 0% V2.

✅ **Ventaja:** Rísgo mínimo. Los bugs se detectan con muy pocos usuarios afectados.  
❌ **Desventaja:** Más complejo de implementar. Necesitas buen monitoreo.

---

#### 3. Rollback plan

Si algo sale mal post-deploy:

- ¿Quién lo detecta? (Monitoreo automático vs. usuarios).
- ¿Quién lo decide? (Alert → Escalación → Dec. técnica).
- ¿Cuánto tarda? (5 min, 1 hora?).
- ¿Validación post-rollback? (Verificar datos OK).

**SLA típico:** Rollback < 5 minutos si error rate sube > 0.5%.

#### 4. Monitoreo post-deploy

**Golden Signals:**
- Latencia (P95 < 200ms?).
- Errores (error rate < 0.1%?).
- Tráfico (RPS estable?).
- Saturación (CPU < 80%?).

Si algo devía → Alerta → Rollback automático.

---

### Ejemplos prácticos

**Ejemplo 1: Elegir estrategia para contexto**

**Contexto A: App móvil fintech. 5M usuarios. Pagos críticos.**

Estrategia: **Canary + monitoreo.**

- Deploy a 1% usuarios (50k).
- Monitorear 2 horas: error rate de pagos, latencia de transacciones, crash rate.
- Si OK: 10% (500k), monitorear 2 horas.
- Si OK: 100%.
- Total: 4-6 horas desde deploy a 100%. Riesgo mínimo.

---

**Contexto B: API interna de empresa (10 engineers usando).**

Estrategia: **Blue-Green.**

- Deploy a Green.
- Tests + Dev team prueba 1 hora.
- Switch.
- Total: 2 horas downtime ~0.

---

**Ejemplo 2: Rollback scenario**

Post-deploy a producción:

- **10:00:** Deploy V2 (canary 5%).
- **10:05:** Error rate de pagos sube 2% (debería ser 0.1%).
- **10:06:** Monitoreo dispara alerta. On-call engineer recibe.
- **10:07:** Engineer revisa: "Error en nueva validación de tarjeta". Autoriza rollback.
- **10:08:** Sistema automáticamente rollback a 0% V2.
- **10:12:** Rollback completo. Error rate vuelve a 0.1%.
- **Post-mortem:** Caso edge no testeado (tarjeta específica).

**Total downtime:** 0 (usuarios en V2 vieron error, pero ya rollback).

---

### Actividades prácticas

**Actividad 1: Elegir estrategia (12 min)**

3 contextos. Para cada uno, elige estrategia de deploy. Justifica.

**Actividad 2: Escribir rollback plan (13 min)**

Proyecto elegido. Detalla: detección (¿cómo sabemos que falló?), decisión (¿quién decide?), ejecución (¿cómo rollback?), validación (¿cómo sabemos que OK?).

---

#### Ejercicio de código — Clase 08: Simula un despliegue Canary con feature flags

**Objetivo:** Implementar en Python la lógica de un despliegue canary usando feature flags, para entender cómo un sistema envía solo el X% del tráfico a la nueva versión.

**Contexto:** Tu equipo lanzó una nueva versión del algoritmo de recomendaciones. No quieres arriesgar a todos los usuarios, así que solo lo activas para el 20% del tráfico.

---

**Paso 1 — Escribe la lógica del feature flag (10 min):**

```python
# feature_flag.py

import hashlib

class FeatureFlag:
    """
    Decide si un usuario recibe la nueva versión o la vieja,
    basándose en un porcentaje de activación.
    """

    def __init__(self, nombre: str, porcentaje_activado: float):
        """
        nombre:              nombre del flag (ej: "nuevo_algoritmo_recomendaciones")
        porcentaje_activado: de 0.0 a 100.0 (ej: 20.0 = 20% de usuarios)
        """
        if not 0.0 <= porcentaje_activado <= 100.0:
            raise ValueError("El porcentaje debe estar entre 0 y 100")
        self.nombre              = nombre
        self.porcentaje_activado = porcentaje_activado

    def esta_activo_para(self, usuario_id: int) -> bool:
        """
        Determina si el flag está activo para un usuario específico.
        Usa un hash del ID para que la asignación sea consistente:
        el mismo usuario siempre recibe la misma versión.
        """
        # Convertir el ID a un número entre 0 y 99 (distribución uniforme)
        clave   = f"{self.nombre}:{usuario_id}"
        hash_bytes = hashlib.md5(clave.encode()).digest()
        bucket  = hash_bytes[0] % 100            # valor entre 0 y 99

        return bucket < self.porcentaje_activado  # si está en el porcentaje activado → True
```

---

**Paso 2 — Usa el feature flag en el servicio (5 min):**

```python
# recomendaciones.py

from feature_flag import FeatureFlag

flag_nuevo_algoritmo = FeatureFlag("nuevo_algoritmo", porcentaje_activado=20.0)

def obtener_recomendaciones(usuario_id: int) -> list:
    if flag_nuevo_algoritmo.esta_activo_para(usuario_id):
        # Nueva versión — solo para el 20% de usuarios
        return _recomendaciones_v2(usuario_id)
    else:
        # Versión estable — para el 80% restante
        return _recomendaciones_v1(usuario_id)

def _recomendaciones_v1(usuario_id: int) -> list:
    return [f"Producto clásico para usuario {usuario_id}"]

def _recomendaciones_v2(usuario_id: int) -> list:
    return [f"Producto ML para usuario {usuario_id}"]
```

---

**Paso 3 — Prueba la distribución (10 min):**

```python
# test_feature_flag.py

from feature_flag import FeatureFlag
from recomendaciones import obtener_recomendaciones

def test_distribucion_aproximada():
    """El 20% de los primeros 1000 usuarios debe recibir v2."""
    flag = FeatureFlag("nuevo_algoritmo", porcentaje_activado=20.0)
    activos = sum(1 for uid in range(1000) if flag.esta_activo_para(uid))

    # Esperamos aproximadamente 200 (±50 por variación estadística)
    assert 150 <= activos <= 250, f"Distribución inesperada: {activos}/1000"

def test_mismo_usuario_siempre_recibe_misma_version():
    """Consistencia: el usuario 42 siempre debe recibir lo mismo."""
    flag = FeatureFlag("nuevo_algoritmo", porcentaje_activado=20.0)
    resultados = [flag.esta_activo_para(42) for _ in range(10)]
    assert len(set(resultados)) == 1, "El mismo usuario recibió versiones distintas"

def test_0_porciento_nunca_activo():
    flag = FeatureFlag("apagado", porcentaje_activado=0.0)
    assert all(not flag.esta_activo_para(uid) for uid in range(100))

def test_100_porciento_siempre_activo():
    flag = FeatureFlag("todos", porcentaje_activado=100.0)
    assert all(flag.esta_activo_para(uid) for uid in range(100))
```

**Ejecuta:** `pytest test_feature_flag.py -v`

**Preguntas de cierre:**
- ¿Qué ventaja tiene usar el hash del ID en lugar de `random()`?
- ¿Cómo ampliarías el porcentaje de 20% a 50% si todo funciona bien?
- ¿Cómo modificarías el código para activar el flag solo para usuarios de un país específico?

---

## Clase 09: Seguridad en el desarrollo — DevSecOps y las 10 vulnerabilidades más comunes

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 5

### Objetivos de aprendizaje

- Entender por qué la seguridad debe integrarse desde el inicio (no al final).
- Identificar y mitigar las 10 vulnerabilidades más comunes según OWASP.
- Distinguir SAST y DAST: dos formas de buscar vulnerabilidades.
- Aplicar quality gates de seguridad en el pipeline de CI.

---

### Contenido teórico

#### 1. DevSecOps — Seguridad desde el día 1, no como paso final

**El problema clásico:** Se construye todo, se entrega, y al final el equipo de seguridad dice "hay 50 vulnerabilidades." Arreglarlas en ese punto es 10 veces más caro que haberlas evitado desde el principio.

**DevSecOps:** Integrar seguridad en cada paso del desarrollo. "La seguridad es responsabilidad de todos, no solo del equipo de seguridad."

```
Requisitos: Definir qué datos deben protegerse
  ↓
Código: Practicas seguras (no SQL injection, no credenciales en código)
  ↓
CI: SAST ─ busca vulnerabilidades automáticamente en cada commit
  ↓
Etapa de pruebas: DAST ─ simula ataques reales contra el sistema
  ↓
Dependencias: SCA ─ escanea librerías externas por vulnerabilidades conocidas
  ↓
Despliegue: Solo si pasan todos los quality gates de seguridad
  ↓
Producción: Monitoreo continuo + respuesta a incidentes
```

**Beneficio:** Los problemas se detectan en minutos (en CI) en lugar de en semanas (en el equipo de seguridad).

#### 2. OWASP Top 10 — Las 10 vulnerabilidades más comunes en la web (2021)

**OWASP** (Open Web Application Security Project) es una organización que publica las vulnerabilidades más frecuentes. Si conoces estas 10, evitas la mayoría de los ataques comunes:

| # | Nombre | ¿Qué significa? | Ejemplo | Cómo prevenirlo |
|---|---|---|---|---|
| 1 | **Control de acceso roto** | Un usuario ve datos que no debería ver | Juan accede al perfil de María cambiando el ID en la URL | Verificar permisos en cada operación |
| 2 | **Fallos criptográficos** | Datos sensibles viajan o se guardan sin cifrar | Contraseñas guardadas en texto plano en la BD | Usar HTTPS, cifrar datos sensibles |
| 3 | **Inyección (SQL Injection)** | El atacante inyecta código malicioso en un formulario | `' OR 1=1 --` en el campo de contraseña | Usar prepared statements |
| 4 | **Diseño inseguro** | La arquitectura tiene huecos de seguridad desde el inicio | Login sin límite de intentos | Modelado de amenazas desde el diseño |
| 5 | **Configuración insegura** | Valores por defecto peligrosos activos | Contraseña admin `admin123` por defecto | Checklist de endurecimiento del servidor |
| 6 | **Componentes vulnerables** | Librerías con vulnerabilidades conocidas sin actualizar | `lodash 3.x` con CVE conocido | Escanear y actualizar dependencias (SCA) |
| 7 | **Fallos de autenticación** | Contraseñas débiles, sin 2FA, sesiones que no expiran | Usuario puede usar `1234` como contraseña | bcrypt, doble factor, tiempo de sesión |
| 8 | **Fallos de integridad** | Código o datos manipulados sin detección | Plugin descargado de servidor no oficial modificado | Verificar firmas digitales |
| 9 | **Sin registros ni monitoreo** | No hay forma de saber si hubo un ataque | Hacker accede por semanas sin que nadie lo sepa | Logs de acceso + alertas de anomalías |
| 10 | **SSRF** | El servidor hace peticiones a URLs controladas por el atacante | API acepta una URL y el atacante apunta a un servicio interno | Validar URLs, lista blanca de dominios |

#### 3. SAST vs DAST — Dos formas de buscar vulnerabilidades

| | SAST — Análisis Estático | DAST — Análisis Dinámico |
|---|---|---|
| **¿Qué hace?** | Analiza el código fuente sin ejecutarlo | Ejecuta la aplicación e intenta atacarla |
| **Analogía** | Revisar el plano de una casa buscando errores | Contratar a alguien para intentar entrar a robar |
| **¿Cuándo corre?** | En cada commit, dentro del pipeline CI | En ambiente de pruebas antes del despliegue |
| **Velocidad** | Rápido (1-2 minutos) | Lento (30+ minutos) |
| **Problema** | Muchos falsos positivos (alerta cuando no hay problema) | Menos falsos positivos pero más lento |
| **Herramientas** | SonarQube, Semgrep, Checkmarx | OWASP ZAP, Burp Suite |

**Usados juntos:** SAST detecta vulnerabilidades comunes rápido. DAST valida que las vulnerabilidades reales no estén presentes en el sistema.
- Herramientas: OWASP ZAP, Burp Suite, Nessus.
- Lento (~30+ min). Fewer false positives.
- Runs: En staging pre-deploy.

#### 4. SCA (Software Composition Analysis)

Escanea dependencias (npm packages, Python libs, etc.) contra CVE database.

- Herramientas: Snyk, Dependabot, WhiteSource.
- Integración: CI/CD.
- Bloquea deploy si vulnerabilidad alta encontrada.

---

### Ejemplos prácticos

**Ejemplo 1: SQL Injection y mitigación**

**Código vulnerable:**
```python
query = f"SELECT * FROM users WHERE email = '{user_input}'"
db.execute(query)
```

Si usuario_input = `admin' --`, query se convierte en:
```sql
SELECT * FROM users WHERE email = 'admin' -- '
```

Devuelve todos los usuarios.

**Código seguro (Prepared Statement):**
```python
query = "SELECT * FROM users WHERE email = ?"
db.execute(query, (user_input,))
```

BD maneja escaping. ¡Safe!

---

**Ejemplo 2: SAST en pipeline**

GitHub push. SonarQube SAST detecta:

```
Blocker: SQL injection risk detected at line 45
  Code: query = f"SELECT * FROM users WHERE email = '{input}'"
  Fix: Use parameterized queries
```

Merge bloqueado hasta fix. Dev arregla. Re-push. Pasa. Merge OK.

---

**Ejemplo 3: Incident de seguridad**

Fintech app. Usuario reporta: "Puedo ver datos de otros usuarios".

**Investigación (postmortem):**

1. **Root cause:** Falta validación de permisos en endpoint `GET /api/users/{id}`.
2. **Impact:** 1000 usuarios expusieron (últimos 24 horas de logs).
3. **Causa raíz:** Requisito de seguridad no fue considerado en diseño.

**Acciones:**

Inmediato:
- Fix: Agregar validación de permisos.
- Deploy hotfix.
- Audit: Verificar si otros endpoints tienen problema similar.

Corto plazo (1-2 semanas):
- Implementar SAST (SonarQube) en CI para detectar similar.
- Code review enfocada en seguridad.

Largo plazo (1-2 meses):
- Threat modeling formal.
- Security training para equipo.
- Penetration testing por terceros.

---

### Actividades prácticas

**Actividad 1: Threat modeling (12 min)**

App de banca. Diagrama: Usuario → App → BD.

Identifica 5 amenazas. Para cada una: OWASP Top 10 número, mitigación.

**Actividad 2: Implementar security gates (13 min)**

Diseña quality gates de seguridad para pipeline CI:
- SAST (SonarQube, qué bloquea?).
- SCA (Snyk, umbral de severidad?).
- Tests de seguridad (qué casos?).

---

#### Ejercicio de código — Clase 09: Encuentra y corrige las vulnerabilidades

**Objetivo:** Identificar vulnerabilidades reales del OWASP Top 10 en código Python y corregirlas.

El siguiente código es una API de inicio de sesión con **5 vulnerabilidades intencionales**. Tu tarea es encontrarlas todas y escribir la versión corregida.

---

**Código vulnerable (SOLO para análisis — NO usar en producción):**

```python
# login_vulnerable.py  — CÓDIGO CON ERRORES INTENCIONALES PARA PRÁCTICA

import sqlite3
import hashlib
import os

# ❌ VULNERABILIDAD 1: Credenciales hardcodeadas en el código
DB_PASSWORD = "admin123"
SECRET_KEY  = "mi_clave_secreta_12345"

def login(username: str, password: str):
    # ❌ VULNERABILIDAD 2: SQL Injection — el usuario puede escribir SQL en su nombre
    conn = sqlite3.connect("usuarios.db")
    query = f"SELECT * FROM users WHERE username = '{username}' AND password = '{password}'"
    resultado = conn.execute(query).fetchone()
    conn.close()
    return resultado

def guardar_password(password: str) -> str:
    # ❌ VULNERABILIDAD 3: Hash inseguro — MD5 está roto desde 2004
    return hashlib.md5(password.encode()).hexdigest()

def reset_password(user_id: str):
    # ❌ VULNERABILIDAD 4: Sin autorización — cualquiera puede resetear la contraseña de cualquier usuario
    nueva_pass = "temp_password"
    conn = sqlite3.connect("usuarios.db")
    conn.execute(f"UPDATE users SET password = '{nueva_pass}' WHERE id = {user_id}")
    conn.commit()
    conn.close()
    print(f"Password reseteada para usuario {user_id}")

def log_evento(evento: str):
    # ❌ VULNERABILIDAD 5: Log injection — el atacante puede escribir logs falsos
    with open("logs.txt", "a") as f:
        f.write(f"EVENTO: {evento}\n")
```

---

**Tu tarea (trabaja en parejas):**

**Paso 1 — Identificar (10 min):**

Para cada una de las 5 vulnerabilidades marcadas con `❌`, completa esta tabla:

| # | Línea(s) de código | Vulnerabilidad OWASP | ¿Qué puede hacer el atacante? |
|---|---|---|---|
| 1 | `DB_PASSWORD = ...` | | |
| 2 | `query = f"SELECT..."` | | |
| 3 | `hashlib.md5(...)` | | |
| 4 | `UPDATE users SET...` | | |
| 5 | `f.write(f"EVENTO: {evento}")` | | |

**Paso 2 — Corregir (15 min):**

Reescribe el código sin las vulnerabilidades. Guía:

```python
# login_seguro.py — TU VERSIÓN CORREGIDA

import sqlite3
import bcrypt          # pip install bcrypt
import os
import re

# ✅ CORRECCIÓN 1: Las credenciales vienen de variables de entorno, no del código
DB_PASSWORD = os.environ.get("DB_PASSWORD")
SECRET_KEY  = os.environ.get("SECRET_KEY")

# Verifica que estén configuradas
if not DB_PASSWORD or not SECRET_KEY:
    raise EnvironmentError("Faltan variables de entorno DB_PASSWORD y SECRET_KEY")

def login(username: str, password: str):
    # ✅ CORRECCIÓN 2: Parametrized query — el input del usuario NO entra directo al SQL
    conn = sqlite3.connect("usuarios.db")
    query = "SELECT id, password_hash FROM users WHERE username = ?"  # ← el ? es el placeholder
    resultado = conn.execute(query, (username,)).fetchone()            # ← el valor va separado
    conn.close()

    if resultado is None:
        return None  # Usuario no existe

    user_id, password_hash = resultado
    # ✅ CORRECCIÓN 3: Verificar con bcrypt (incluye salt automático)
    if bcrypt.checkpw(password.encode(), password_hash):
        return user_id
    return None

def guardar_password(password: str) -> bytes:
    # ✅ CORRECCIÓN 3: bcrypt con salt — si dos usuarios tienen la misma contraseña, el hash es diferente
    salt = bcrypt.gensalt(rounds=12)    # rounds=12 hace el hash más lento (más seguro)
    return bcrypt.hashpw(password.encode(), salt)

def reset_password(user_id: str, usuario_autenticado_id: str, es_admin: bool):
    # ✅ CORRECCIÓN 4: Solo admin o el propio usuario pueden resetear
    if not es_admin and user_id != usuario_autenticado_id:
        raise PermissionError("No tienes permiso para resetear esta contraseña")
    # ... resto del reset seguro

def log_evento(evento: str):
    # ✅ CORRECCIÓN 5: Sanitizar el evento para evitar log injection
    evento_limpio = evento.replace("\n", " ").replace("\r", " ")
    with open("logs.txt", "a") as f:
        f.write(f"EVENTO: {evento_limpio}\n")
```

**Pregunta de reflexión:**
- ¿Por qué `bcrypt` es mejor que `md5` o `sha256` para contraseñas?
- ¿Qué pasaría si un atacante escribe `'; DROP TABLE users; --` como nombre de usuario en el código vulnerable?

---

## Clase 10: Herramientas de seguridad automática y manejo seguro de contraseñas

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 5

### Objetivos de aprendizaje

- Configurar herramientas SAST, DAST y SCA en el pipeline.
- Entender qué es un SBOM ("lista de ingredientes" del software) y para qué sirve.
- Manejar contraseñas y llaves de API de forma segura (sin poner nada en el código).
- Responder a vulnerabilidades (CVEs) detectadas por las herramientas.

---

### Contenido teórico

#### 1. SAST en profundidad

**Herramientas comunes:**

- **SonarQube:** Java, JS, Python, C#. Cloud + Self-hosted.
- **Checkmarx:** Enterprise. Múltiples lenguajes.
- **Semgrep:** Open-source. Reglas personalizables.

**Configuración típica:**

```yaml
sonarqube:
  coverage_threshold: 80%
  blocker_issues: 0  # No permitir issue "Blocker"
  security_hotspots: must_review  # Revisar manualmente
  debt_ratio: < 5 days  # Deuda técnica máxima
```

#### 2. DAST en profundidad

**Herramientas:**

- **OWASP ZAP:** Open-source. Escaneo automático + manual.
- **Burp Suite:** Enterprise. Interceptor proxy.

**Tipología de scan:**

- **Authenticated scan:** Loguear como usuario.
- **Full scan:** Todos los endpoints.
- **Focused scan:** Endpoints críticos (login, pagos).

**Resultado:** Vulnerabilidades encontradas. Severity. Proof-of-concept.

#### 3. SCA — Escanear las librerías que usas

**SCA (Software Composition Analysis):** Verifica que las librerías externas que usa tu proyecto no tengan vulnerabilidades conocidas.

**¿Por qué?** Tu aplicación puede tener código perfecto, pero si usa una librería con un hueco de seguridad, tu sistema también es vulnerable.

**Herramientas:**
- **Snyk:** Se integra con npm, Python, Maven. Monitoreo continuo.
- **Dependabot:** Nativa de GitHub. Crea Pull Requests automáticos para actualizar librerías vulnerables.
- **WhiteSource:** Para empresas grandes.

**Flujo típico:**
1. Agregas librería: `npm install lodash@4.17.0`.
2. SCA escanea: "lodash@4.17.0 tiene vulnerabilidad CVE-2021-23337 (nivel ALTO)."
3. Tienes dos opciones:
   - **A:** Actualizar a la versión que corrige el problema.
   - **B:** Aceptar el riesgo temporalmente (documéntalo y créa un plan de actualización).

#### 4. SBOM — La "lista de ingredientes" de tu software

**Analogía:** Un producto alimenticio tiene una lista de ingredientes. Un SBOM es lo mismo pero para el software: lista exactamente qué librerías externas usa tu sistema, en qué versión y con qué licencia.

**¿Para qué sirve?**
- **Auditoría:** "¿Qué librerías usamos?" Respuesta en segundos.
- **Licencias:** "¿Usamos alguna librería con licencia que no podemos usar comercialmente?"
- **Seguridad:** Si aparece una nueva vulnerabilidad en `lodash`, sabes automáticamente si tu sistema la tiene.

**Ejemplo de SBOM simplificado:**
```json
{
  "componentes": [
    { "nombre": "lodash", "versión": "4.17.21", "licencia": "MIT" },
    { "nombre": "express", "versión": "4.18.0", "licencia": "MIT" }
  ]
}
```

**Cómo generarlo:** `npm install && cyclonedx-npm --output-format json`

**Usos:**

- Auditoría (¿qué librerías usamos?).
- Compliance (¿licencias permitidas?).
- Vulnerabilidad (si CVE en lodash, automáticamente sabemos está en nuestro app).

**Generación:** `npm install && cyclonedx-npm --output-format json`.

#### 5. Gestión de secretos

**Problema:** DB password en código → Git → GitHub → Mundo la ve.

**Soluciones:**

1. **Environment variables:**
   ```
   export DB_PASSWORD="secret123"
   process.env.DB_PASSWORD  // en código
   ```

2. **Secrets manager:**
   - AWS Secrets Manager
   - Azure Key Vault
   - HashiCorp Vault
   - GitHub Secrets (para CI/CD)

3. **Pre-commit hooks:**
   Herramienta `gitleaks` previene accidental commit de secretos.
   ```bash
   git commit  # Hook corre, detecta "password123" en diff, bloquea
   ```

4. **Rotation:**
   Cambiar secretos regularmente (30-90 días).

---

### Ejemplos prácticos

**Ejemplo 1: SAST detecta SQL injection**

Dev comete código:

```java
String query = "SELECT * FROM users WHERE id = " + userId;
ResultSet rs = stmt.executeQuery(query);
```

SonarQube en CI:

```
Security Hotspot: SQL Injection
Risk: High
Code: line 45
Message: Concatenation in SQL query is vulnerable
Fix: Use PreparedStatement
```

Dev debe fijar antes de merge.

---

**Ejemplo 2: SCA detecta CVE y respuesta**

Proyecto Node.js. `npm install` agrega `express@4.15.0` (vieja).

Snyk scan:

```
Found 3 vulnerabilities in express@4.15.0:

1. CVE-2022-24999: Open Redirect (Severity: MEDIUM)
2. CVE-2022-23582: Denial of Service (Severity: HIGH)

Recommendation: Upgrade to express@4.18.2+
```

Dev decision:

- Opción A: Upgrade a 4.18.2 (puede romper compatibilidad). Plan: Test, 1-2 días.
- Opción B: Accept risk temporalmente, pero crear issue para upgrade en próximo sprint.

Dev elige A. Upgradea. Tests pasan. Merge OK.

---

**Ejemplo 3: Gestión de secretos**

Servidor necesita conectar a BD:

**Antes (Malo):**
```python
# config.py
DB_PASSWORD = "supersecret123"
```

Push a GitHub. ¡Seguridad comprometida!

**Después (Bueno):**
```python
import os
DB_PASSWORD = os.environ.get("DB_PASSWORD")
```

En CI/CD (GitHub Actions):

```yaml
env:
  DB_PASSWORD: ${{ secrets.DB_PASSWORD }}
```

Secreto almacenado en GitHub Secrets (encriptado). Disponible solo en CI, no en código.

---

### Actividades prácticas

**Actividad 1: Generar SBOM (12 min)**

Proyecto Node.js. Ejecuta `npm install && cyclonedx-npm`. Analiza SBOM. Identifica:
- Total componentes.
- Licencias (MIT, Apache, etc.).
- Versiones desactualizadas.

**Actividad 2: Plan de gestión de secretos (13 min)**

Proyecto con 10 secretos (DB password, API keys, etc.). Diseña:
1. Cómo almacenar (envs, vault, etc.).
2. Cómo rotar (frecuencia, proceso).
3. Cómo auditar (quién accedió?).
4. Cómo detectar leaks (gitleaks, truffleHog, etc.).

---

#### Ejercicio de código — Clase 10: De credenciales en el código a variables de entorno

**Objetivo:** Migrar un script con credenciales hardcodeadas a una versión segura que las lee desde variables de entorno, y verificar que gitleaks detecta el problema original.

---

**Código inseguro (punto de partida):**

```python
# conexion_bd_insegura.py  — ❌ NUNCA hacer esto en producción

import psycopg2   # pip install psycopg2-binary

def conectar():
    return psycopg2.connect(
        host     = "db.empresa.com",
        database = "produccion",
        user     = "admin",
        password = "P@ssw0rd2026!"    # ← credencial expuesta en el código
    )

STRIPE_API_KEY = "sk_live_4eC39HqLyjWDarjtT1zdp7dc"  # ← clave real de Stripe en el repo
```

Si este archivo llega a GitHub (aunque sea en un commit borrado después), las credenciales quedan en el historial para siempre.

---

**Paso 1 — Crear el archivo `.env` (fuera del repositorio):**

```bash
# Crea el archivo .env en la raíz del proyecto (NO lo hagas commit)
cat > .env << 'EOF'
DB_HOST=db.empresa.com
DB_NAME=produccion
DB_USER=admin
DB_PASSWORD=P@ssw0rd2026!
STRIPE_API_KEY=sk_live_4eC39HqLyjWDarjtT1zdp7dc
EOF

# Agrega .env al .gitignore para que NUNCA entre al repositorio
echo ".env" >> .gitignore
```

---

**Paso 2 — Reescribe el código para leer desde el entorno:**

```python
# conexion_bd_segura.py  — ✅ Versión correcta

import os
import psycopg2
from dotenv import load_dotenv   # pip install python-dotenv

# Carga las variables del archivo .env (en desarrollo)
# En producción, las variables se inyectan directamente por el sistema (CI/CD, Kubernetes secrets)
load_dotenv()

def conectar():
    host     = os.environ.get("DB_HOST")
    database = os.environ.get("DB_NAME")
    user     = os.environ.get("DB_USER")
    password = os.environ.get("DB_PASSWORD")

    # Verificar que todas las variables necesarias están presentes
    if not all([host, database, user, password]):
        raise EnvironmentError(
            "Faltan variables de entorno: DB_HOST, DB_NAME, DB_USER, DB_PASSWORD"
        )

    return psycopg2.connect(
        host=host, database=database, user=user, password=password
    )

STRIPE_API_KEY = os.environ.get("STRIPE_API_KEY")
if not STRIPE_API_KEY:
    raise EnvironmentError("Falta variable de entorno: STRIPE_API_KEY")
```

---

**Paso 3 — Agregar detección automática de secretos al pipeline CI:**

```yaml
# .github/workflows/security.yml  — Fragmento a agregar al pipeline existente

  detectar-secretos:
    name: Detectar credenciales en el código
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
        with:
          fetch-depth: 0            # Necesario para analizar todo el historial

      - name: Instalar gitleaks
        run: |
          wget -q https://github.com/gitleaks/gitleaks/releases/download/v8.18.0/gitleaks_8.18.0_linux_x64.tar.gz
          tar -xzf gitleaks_8.18.0_linux_x64.tar.gz
          chmod +x gitleaks

      - name: Escanear repositorio
        run: ./gitleaks detect --source . --exit-code 1
        # exit-code 1 → el pipeline FALLA si encuentra credenciales
```

**Prueba: si agregas `password = "secreto123"` en cualquier archivo y haces commit, este paso fallará y el merge quedará bloqueado.**

**Preguntas de cierre:**
- ¿Por qué agregar `.env` al `.gitignore` no es suficiente si ya lo subiste una vez?
- ¿Cómo se inyectan las variables de entorno en producción sin usar un archivo `.env`?
- ¿Qué diferencia hay entre `os.environ.get("KEY")` y `os.environ["KEY"]`?

---

# UNIDAD 3. Operación, observabilidad e incidentes

---

## Clase 11: Logs, métricas y trazas

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 6

### Objetivos de aprendizaje

- Entender la diferencia entre logs, métricas y trazas: los tres pilares para observar un sistema.
- Escribir logs estructurados (en JSON) que se puedan buscar fácilmente.
- Configurar alertas basadas en métricas para detectar problemas automáticamente.
- Usar trazas distribuidas para encontrar qué parte del sistema está causando lentitud.

---

### Contenido teórico

#### 1. Logs — El diario de eventos del sistema

**¿Qué son?** Registros de todo lo que pasa: quién inició sesión, qué error ocurrió, qué operación se ejecutó.

Ejemplo de logs básicos:
```
2026-08-15 10:30:45 INFO  [auth] Usuario 123 inició sesión exitosamente
2026-08-15 10:30:46 ERROR [pagos] Transacción falló: timeout en servidor de pagos
```

**Logs estructurados (en JSON) — Más buscables:**
```json
{
  "timestamp": "2026-08-15T10:30:45Z",
  "nivel": "INFO",
  "servicio": "auth",
  "mensaje": "Usuario inició sesión",
  "usuario_id": 123,
  "duracion_ms": 45
}
```

**¿Por qué JSON?** Puedes buscar "todos los errores del servicio de pagos en los últimos 10 minutos" en segundos. Con texto plano, es imposible.

**Herramientas de centralización:** Kibana, Datadog, Splunk (juntan los logs de todos los servidores en un solo lugar).

#### 2. Métricas — Números que cambian en el tiempo

**¿Qué son?** Valores numéricos que mides continuamente para ver cómo se comporta el sistema.

Ejemplos de métricas importantes:
- CPU: 45%
- Memoria: 2.1 GB usados de 8 GB
- Solicitudes por segundo: 1,200
- Tasa de errores: 0.1%
- Tiempo de respuesta P95: 150ms *(el 95% de las solicitudes responden en 150ms o menos)*

**Cómo funciona el monitoreo:**
```
Prometheus (cada 15 segundos): "CPU = 45%... 46%... 45%... 78%... 90%!"

Grafana visualiza en gráficas:
  [Gráfica] CPU última hora
  [Gráfica] Solicitudes por segundo
  [ALERTA] CPU > 80% por 5 minutos → Aviso a Slack
```

**Valor:** Sin métricas, descubres que algo falló cuando un usuario te llama. Con métricas, lo sabes antes de que el usuario lo note.

#### 3. Trazas — El camino completo de una solicitud

**¿Qué son?** Registran todo el recorrido de una solicitud del usuario a través de todos los servicios del sistema.

**¿Para qué sirven?** Si una solicitud tarda 2 segundos y debería tardar 200ms, ¿dónde está el problema? Las trazas te lo dicen exactamente:

```
POST /api/login (100ms total)
  │
  ├─ servicio-auth (50ms)
  │  ├─ validar credenciales (10ms)
  │  ├─ consultar BD (20ms)
  │  └─ generar token (20ms)
  │
  ├─ servicio-auditoria (30ms)
  │  ├─ registrar evento (15ms)
  │  └─ enviar notificación (15ms)
  │
  └─ servicio-cache (20ms)
     └─ guardar sesión (20ms)
```

Si algo empieza a tardar 1,500ms en lugar de 20ms, lo ves inmediatamente en la traza.

**Herramientas:** Jaeger, Zipkin, DataDog APM.

---

### Ejemplos prácticos

**Ejemplo 1: Debugging con trazas**

API lenta. Latencia P95 = 2 segundos (debería ser 200ms).

Tracer muestra:

```
Request: GET /api/products (2000ms)
  ├─ product-service: 100ms
  ├─ recommendation-service: 1800ms ← CULPABLE
  │   ├─ query DB (1700ms) ← Muy lento
  │   └─ transform response (100ms)
  └─ cache-service: 50ms
```

Culpable: Query BD en recommendation-service es lenta.

**Solución:** Agregar índice, o cachear resultados.

---

**Ejemplo 2: Alertas basadas en métricas**

Producción. Alerta:

```
ERROR_RATE spike
Alert: error_rate > 1% for 5 minutes

Current: 2.3% (should be < 0.1%)
```

On-call engineer recibe notificación. Acciones:

1. Revisa logs en último 10 minutos.
2. Identifica: "Payment API timeout" empezó a las 10:15.
3. Revisa trazas de payment requests: "Database connection pool exhausted".
4. Escala al DB team.
5. DB team reinicia connection pool.
6. Error rate vuelve a 0.1%.

**Post-mortem:**
- Causa: Connection pool size was too low para picos de tráfico.
- Fix: Aumentar pool size + agregar alerta de "low connection pool".

---

### Actividades prácticas

**Actividad 1: Diseñar logs estructura (12 min)**

Request de login. Qué información loguear? Campos.

**Actividad 2: Alertas críticas (13 min)**

App de comercio. 10 alertas críticas (error rate, latencia, etc.). Define threshold, escalation path.

---

#### Ejercicio de código — Clase 11: Mejorar logs de texto plano a logs estructurados

**Objetivo:** Transformar logs de texto plano (difíciles de buscar) a logs estructurados en JSON que un sistema de monitoreo pueda analizar automáticamente.

---

**Código inicial — logs en texto plano (difícil de analizar):**

```python
# servicio_pagos_malo.py

def procesar_pago(usuario_id: int, monto: float, metodo: str):
    print(f"Procesando pago de {usuario_id}")          # ← ¿Qué nivel? ¿Qué contexto?
    
    if monto <= 0:
        print(f"Error: monto inválido {monto}")        # ← No hay severidad, no hay ID de request
        return False
    
    # Simular llamada a procesador de pagos
    print(f"Pago {monto} procesado por {metodo}")      # ← No hay timestamp, sin trace_id
    return True

# Logs que genera:
# Procesando pago de 456
# Pago 99.99 procesado por tarjeta
```

**Problema:** Si hay 10,000 pagos por hora, no puedes buscar fácilmente todos los pagos fallidos de un usuario específico, ni cuánto tarda cada paso.

---

**Tu tarea: Reescribir con logs estructurados (15 min)**

Completa el siguiente código reemplazando los `# TU CÓDIGO AQUÍ`:

```python
# servicio_pagos_mejorado.py

import logging
import json
import uuid
from datetime import datetime, timezone

# Configurar el logger para emitir JSON
class FormateadorJSON(logging.Formatter):
    def format(self, record):
        entrada = {
            "timestamp": datetime.now(timezone.utc).isoformat(),
            "nivel":     record.levelname,        # INFO, WARNING, ERROR
            "servicio":  "servicio-pagos",
            "mensaje":   record.getMessage(),
            # Incluir campos extra si existen
            **getattr(record, "extra", {})
        }
        return json.dumps(entrada, ensure_ascii=False)

# Crear logger
logger = logging.getLogger("pagos")
handler = logging.StreamHandler()
handler.setFormatter(FormateadorJSON())
logger.addHandler(handler)
logger.setLevel(logging.INFO)


def procesar_pago(usuario_id: int, monto: float, metodo: str) -> bool:
    # Generar un ID único por request para poder rastrear toda la operación
    request_id = str(uuid.uuid4())[:8]

    # ✅ Log de inicio — nivel INFO con contexto completo
    logger.info(
        "Iniciando procesamiento de pago",
        extra={
            "extra": {
                "request_id":  request_id,
                "usuario_id":  usuario_id,
                "monto":       monto,
                "metodo":      metodo
            }
        }
    )

    # ✅ Validación con log de WARNING si el monto es inválido
    if monto <= 0:
        # TU CÓDIGO AQUÍ: emitir un log de nivel WARNING con request_id, usuario_id y monto
        pass

    # ✅ Simulación de procesamiento exitoso
    # TU CÓDIGO AQUÍ: emitir un log INFO de "Pago procesado exitosamente"
    # incluye: request_id, usuario_id, monto, metodo, duracion_ms (usa un valor fijo de 143)

    return True
```

**Salida esperada cuando se llama `procesar_pago(456, 99.99, "tarjeta")`:**

```json
{"timestamp": "2026-08-15T10:30:44Z", "nivel": "INFO", "servicio": "servicio-pagos", "mensaje": "Iniciando procesamiento de pago", "request_id": "a3b9c1d2", "usuario_id": 456, "monto": 99.99, "metodo": "tarjeta"}
{"timestamp": "2026-08-15T10:30:44Z", "nivel": "INFO", "servicio": "servicio-pagos", "mensaje": "Pago procesado exitosamente", "request_id": "a3b9c1d2", "usuario_id": 456, "monto": 99.99, "metodo": "tarjeta", "duracion_ms": 143}
```

**Salida esperada cuando se llama `procesar_pago(456, -50, "tarjeta")`:**

```json
{"timestamp": "2026-08-15T10:30:45Z", "nivel": "WARNING", "servicio": "servicio-pagos", "mensaje": "Monto inválido rechazado", "request_id": "f7e2a4b1", "usuario_id": 456, "monto": -50}
```

**Preguntas de cierre:**
- ¿Por qué el `request_id` es útil cuando hay muchos usuarios haciendo pagos al mismo tiempo?
- ¿Qué diferencia hay entre `logger.info()`, `logger.warning()` y `logger.error()`?
- Con logs en JSON, ¿cómo buscarías en Elasticsearch todos los pagos fallidos de `usuario_id = 456`?

---

## Clase 12: Las 4 métricas clave y cómo definir objetivos de servicio

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 6

### Objetivos de aprendizaje

- Entender las 4 métricas clave para monitorear un sistema (latencia, errores, tráfico y saturación).
- Diferenciar SLI, SLO y SLA con ejemplos prácticos.
- Calcular y usar el error budget de forma simple.
- Tomar decisiones de despliegue según confiabilidad, no por intuición.

---

### Contenido teórico

#### 1. Las 4 métricas clave (Golden Signals) — Lo que siempre debes monitorear

Google diseñó estos 4 indicadores como las métricas mínimas para saber si un sistema está saludable. Cualquier sistema, sin importar su complejidad, se puede evaluar con estas 4:

| Métrica | ¿Qué mide? | Ejemplo | Objetivo típico |
|---|---|---|---|
| **Latencia** | Cuánto tarda el sistema en responder | "95% de solicitudes responden en menos de 200ms" | P95 < 200ms |
| **Errores** | Qué porcentaje de solicitudes fallan | "Solo 1 de cada 1000 solicitudes da error" | < 0.1% |
| **Tráfico** | Cuántas solicitudes recibe por segundo | "En hora pico: 8,500 solicitudes/seg" | Monitorear baseline |
| **Saturación** | Cuánto recurso está ocupado | "CPU al 65%" | CPU < 80%, Memoria < 85% |

**Panel de monitoreo en tiempo real:**
```
Latencia P95: 150ms ✅  |  Errores: 0.05% ✅  |  Tráfico: 8,500 RPS ✅  |  CPU: 65% ✅
```
**Si alguno está en rojo, algo está mal en el sistema.**

#### 2. SLI, SLO y SLA — De la métrica al contrato

**SLI (Indicador del nivel de servicio):** La métrica real que mides. Ej: "Hoy la latencia P95 fue 163ms."

**SLO (Objetivo del nivel de servicio):** El objetivo que te propones cumplir. Ej: "La latencia P95 debe ser menor a 200ms."

**SLA (Acuerdo del nivel de servicio):** Contrato con el cliente. Si no cumples el SLO, hay consecuencias (crédito, penalización).

**Relación:**
```
SLI = lo que mides en la realidad
SLO = lo que prometiste internamente (objetivo)
SLA = lo que firmaste con el cliente (contrato)

Si SLI no cumple SLO → El equipo trabaja para mejorar
Si SLO no se cumple persistentemente → El SLA puede verse afectado
```

**Ejemplo banco:**
- SLI: "Disponibilidad del mes: 99.92%"
- SLO: "Disponibilidad debe ser >= 99.99%"
- Estado: ❌ Fuera del objetivo. El equipo investiga las causas.

#### 3. Error Budget — "Cuánto puedo fallar este mes"

**Analogía:** Como un presupuesto de dinero, pero para fallos. Si tu SLO es 99.9% de disponibilidad, tienes "presupuesto" para 0.1% de fallos.

**Cálculo para un mes:**

```
SLO: 99.9% disponibilidad
Período: 30 días = 43,200 minutos totales

Presupuesto de error: 43,200 × 0.001 = 43 minutos/mes

→ Puedes tener hasta 43 minutos de caída al mes
```

**¿Cómo se usa para tomar decisiones?**

| Presupuesto restante | Decisión |
|---|---|
| Queda 40 min (prácticamente todo) | ✅ Podemos desplegar nuevas funciones con riesgo normal |
| Queda 5 min (casi agotado) | ⚠️ Congelamos nuevos deploys. Solo correcciones urgentes |
| Agotado (0 min) | ❌ Prioridad: estabilidad. Sin ningún nuevo despliegue hasta el próximo mes |

**Valor:** El equipo no debate por intuición si "hay que desplegarlo hoy". Lo decide con datos.

---

### Ejemplos prácticos

**Ejemplo 1: SLI/SLO en app bancaria**

**Requisitos de negocio:** App debe estar disponible 99.99% (< 52 min downtime/año).

**SLI definidas:**
1. Uptime: % tiempo sistema respondiendo.
2. Success rate: % transacciones exitosas.
3. Latency P99: transacción debe completarse < 1 segundo.

**SLO (30 días):**
```
Uptime >= 99.99%
Success rate >= 99.9%
Latency P99 < 1000ms
```

**Monitoreo (Grafana):**

```
[UPTIME]: 99.98% (❌ INCUMPLIENDO)
  - Downtime actual: 58 minutos (budget era 43 min)
  - Causa: DB failover en semana 2 (15 min), malfunction en alertas (43 min)
  
[SUCCESS RATE]: 99.92% (✓ CUMPLIENDO)

[LATENCY P99]: 950ms (✓ CUMPLIENDO)
```

**Acción:** Uptime fuera de SLO. Congelamos deploys. Investigar DB failover.

---

**Ejemplo 2: Error budget y decisión de deploy**

SLO: 99.9% uptime. Mes: 43.2 min budget.

Semana 1: Producción sin incidentes. Error budget: 43.2 min.  
Semana 2: Incidente 15 min downtime. Error budget: 28.2 min.  
Semana 3: Incidente 25 min downtime. Error budget: 3.2 min.

**Semana 4:**
- Team quiere deploy de feature "new payment method".
- Feature es moderadamente riesgosa (cambio en payment flow).

**Decision tree:**
- Error budget disponible: 3.2 min.
- Riesgo deploy: "10% chance de 1 min outage".
- Expected impacto: 0.1 min.
- Decisión: **DEPLOY OK** (0.1 < 3.2).

Pero si error budget fuese 0.5 min, decisión sería: **NO DEPLOY. Congelamos.**

---

### Actividades prácticas

**Actividad 1: Definir SLI/SLO (12 min)**

App de delivery. Define 5 SLI (qué medir?). Para cada, define SLO (qué target?).

**Actividad 2: Error budget planning (13 min)**

SLO: 99.95% uptime. Período: 1 mes. Calcula error budget en minutos.

Escenario: Ya gastaste 80% del budget. Un feature arriesgado solicita deploy. ¿Sí o no? ¿Por qué?

---

## Clase 13: Métricas DORA — ¿Cómo saber si tu equipo es eficiente?

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 7

### Objetivos de aprendizaje

- Entender las 4 métricas DORA y qué mide cada una.
- Calcular las métricas a partir de datos reales del equipo.
- Identificar cuál es el cuello de botella (bottleneck) principal del equipo.
- Crear un plan de mejora concreto basado en esas métricas.

---

### Contenido teórico

#### 1. Las 4 métricas DORA — El estándar de la industria para medir equipos de software

Forsgren, Humble y Kim investigaron miles de equipos y encontraron que estos 4 indicadores predicen qué tan bien funciona un equipo de desarrollo:

| Métrica | ¿Qué mide? | Bueno (“High”) | Excelente (“Elite”) |
|---|---|---|---|
| **Frecuencia de deploys** | ¿Cuántas veces despliegan a producción? | 1 vez por día | Varias veces al día |
| **Lead time** | ¿Cuánto tarda un cambio desde el commit hasta producción? | 1 semana a 1 mes | Menos de 1 día |
| **MTTR** (tiempo de recuperación) | Si algo falla, ¿cuánto tardan en arreglarlo? | Menos de 1 hora | Menos de 15 minutos |
| **CFR** (tasa de fallos de cambio) | ¿Qué % de sus cambios causaron incidente o rollback? | 0-15% | 0-15% (con confianza para arreglar rápido) |

**Equipos "Elite" según los datos:** Son ~200 veces más rápidos y confiables que los de nivel bajo.

**Equipos tradicionales (nivel “Low”):**
- Deploys: 1 vez por mes o menos
- Lead time: De 1 mes a 6 meses
- MTTR: Más de 6 horas
- CFR: 30-60% de cambios causan problemas

#### 2. Medir DORA

**Deployment Frequency:**
```
Octubre:
  Semana 1: 5 deploys
  Semana 2: 7 deploys
  Semana 3: 4 deploys
  Semana 4: 6 deploys
  Total: 22 deploys / 30 días = 0.73 deploys/día = "High" (1/día)
```

**Lead Time:**
```
Feature A: Commit 2026-08-01 → Deploy 2026-08-02 = 1 día ✓ Elite
Feature B: Commit 2026-08-05 → Deploy 2026-08-12 = 7 días ✓ High
Feature C: Commit 2026-07-15 → Deploy 2026-08-15 = 31 días ✗ Low

Average: (1 + 7 + 31) / 3 = 13 días = "High"
```

**MTTR:**

Incident: DB connection pool exhausted. Detección 10:00. Recovery 10:12.  
MTTR: 12 minutos = "Elite".

**CFR:**

```
Octubre deploys: 22 total
Rolledback/caused incident: 2
CFR: 2/22 = 9% = "High" (0-15%)
```

#### 3. Benchmark y mejora

**Google:**
- Deployment Frequency: 1000+ cambios/día (Elite)
- Lead Time: Horas (Elite)
- MTTR: < 5 minutos (Elite)
- CFR: < 1% (Elite)

**Equipo típico Ágil:**
- Deployment Frequency: 1/semana (High)
- Lead Time: 1-2 semanas (High)
- MTTR: 1 hora (High)
- CFR: 10-15% (High)

**Equipo tradicional:**
- Deployment Frequency: 1/trimestre (Low)
- Lead Time: 2-6 meses (Low)
- MTTR: 4 horas (Medium)
- CFR: 30-50% (Low)

---

### Ejemplos prácticos

**Ejemplo 1: Analizar DORA de equipo**

Datos actuales (equipo de 8 personas):

```
Deployment Frequency: 2/semana
Lead Time: 10 días
MTTR: 2 horas
CFR: 25%
```

**Ranking:** High / High / High / Medium.

**Análisis de bottlenecks:**

1. **Lead Time 10 días es lento.** Raíz: "PR review tarda 5 días. Reviewer no disponible."
   - Solución: Romper reviewer bottleneck. Entrenar más personas.

2. **CFR 25% es alto.** Raíz: "Tests no cubren edge cases. No hay staging env para validar."
   - Solución: Aumentar coverage a 90%, validar en staging antes de deploy.

3. **MTTR 2 horas es OK.** Pero correlacionado con CFR alto. Si arreglamos CFR, MTTR baja naturalmente.

**Plan 6 meses:**

```
Mes 1-2: Aumentar test coverage (70% → 85%).
Mes 2-3: Entrenar reviewers adicionales. Objetivo: PR review < 1 día.
Mes 3-4: Setup staging env. Validar deploys.
Mes 4-6: Automatizar más. Objetivo: Deploy 3-5/semana.

Target para fin año:
  Deployment Frequency: 5/semana (High → Elite)
  Lead Time: 3 días (High → High+)
  MTTR: 30 min (High → Elite)
  CFR: 5% (Medium → High)
```

---

### Actividades prácticas

**Actividad 1: Medir DORA de equipo (12 min)**

Datos históricos de equipo. Calcula 4 métricas. Categoriza (Low/Medium/High/Elite). Identifica bottleneck #1.

**Actividad 2: Plan de mejora (13 min)**

Plan de 6 meses para llevar equipo de "Medium" a "High" en todas métricas. Propuestas concretas (herramientas, entrenamientos, cambios de proceso).

---

## Clase 14: Gestión de incidentes — ¿Qué hacer cuando algo falla en producción?

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 7

### Objetivos de aprendizaje

- Clasificar un incidente según su nivel de urgencia (severidad).
- Saber qué hacer paso a paso cuando hay un fallo en producción.
- Entender RTO y RPO: cuánto puede estar caído el sistema y cuántos datos puede perder.
- Coordinar la respuesta entre el equipo.

---

### Contenido teórico

#### 1. Niveles de severidad — ¿Qué tan urgente es el problema?

No todos los fallos son iguales. Algunos paralizan el negocio; otros son un inconveniente menor. Esta escala (SEV) ayuda a decidir qué tan rápido y con cuántos recursos responder:

| Nivel | Nombre | ¿Qué pasa? | Ejemplo | ¿Cuánto tiempo para resolver? |
|---|---|---|---|---|
| **SEV-1** | Crítico | Todo el sistema caído. Todos los usuarios afectados | "Ningún pago funciona" | Menos de 15 minutos |
| **SEV-2** | Alto | Funcionalidad clave parcialmente caída | "Pagos con tarjeta fallan, pero transferencias sí funcionan" | Menos de 1 hora |
| **SEV-3** | Medio | Función degradada, pero hay alternativa | "El filtro de búsqueda está lento" | Menos de 4 horas |
| **SEV-4** | Bajo | Error menor, sin impacto real | "Hay un error tipográfico en la interfaz" | Menos de 1 semana |

**Regla práctica:** SEV-1 y SEV-2 = todo el equipo para. SEV-3 = asignar una persona. SEV-4 = entra al backlog.

#### 2. Triage — ¿Cómo determinar la severidad?

Triage viene de la medicina: es la clasificación rápida de urgencia. Para un incidente de software, hazte estas 4 preguntas:

1. ¿Cuántos usuarios están afectados? (10% vs 100%)
2. ¿Hay pérdida de dinero o datos?
3. ¿Podría ser un ataque?
4. ¿Hay una alternativa temporal (workaround)?

Con esas respuestas asignas el nivel SEV y el ingeniero de turno (on-call) empieza a actuar.

#### 3. RTO y RPO — Los límites que el negocio define

**RTO (Recovery Time Objective):** Máximo tiempo que el sistema puede estar caído antes de que el impacto sea inaceptable.

**RPO (Recovery Point Objective):** Máxima cantidad de datos que puedes perder. Si el backup se hace cada hora, puedes perder hasta 1 hora de transacciones.

| Tipo de sistema | RTO (tiempo máximo caído) | RPO (datos que pueden perderse) |
|---|---|---|
| Banco central | 15 minutos | Cero (ninguna transacción puede perderse) |
| App financiera | 1 hora | Menos de 15 minutos |
| Plataforma SaaS | Pocas horas | Menos de 1 hora (backup por hora) |
| Blog o sitio informativo | 1 día | 1 día |

**Consecuencia práctica:** Un RTO muy bajo requiere inversión en infraestructura redundante. No todos los sistemas necesitan el mismo nivel.

#### 4. Respuesta a incidentes

**Fase 1: Detección (segundos)**

Monitoreo automático dispara alerta, o usuario reporta.

**Fase 2: Triage (1 min)**

On-call recibe alerta. Clasifica severidad.

**Fase 3: Escalación (2 min)**

Si SEV-1: Llama a tech lead. Abre war room.  
Si SEV-2: Notifica vía Slack. Ingenieros se unen.

**Fase 4: Investigación (5-30 min)**

"¿Qué está mal?" Revisa logs, métricas, trazas.

**Fase 5: Remediación (5-60 min)**

"¿Cómo lo arreglamos?" Opciones: rollback, hotfix, escalada, workaround.

**Fase 6: Comunicación (continuo)**

Actualizar status en Slack. Notificar clientes. "Investigando...", "Remediando...", "Resuelto".

**Fase 7: Recovery (después de SEV-1/2)**

Monitoreo intensivo. ¿Se vuelve a romper?

**Fase 8: Post-mortem (24-48 horas)**

Reunión. "¿Por qué pasó? ¿Cómo prevenimos?"

---

### Ejemplos prácticos

**Ejemplo 1: Incident de pagos**

10:00 AM: Alerta. Error rate en payment API = 50% (debería ser 0.1%).

**Triage:** SEV-1. 30% usuarios affected. Revenue down.

**Escalación:** Slack. "#incidents" channel. Llamada de conferencia abierta.

**Investigación (10:05 AM):**

Logs muestran:
```
Payment API → Stripe API: Connection timeout
Stripe status page: Stripe down (maintenance no anunciada)
```

**Comunicación (10:06 AM):**

Clientes notificados: "Stripe (payment processor) está caído. Estamos monitoreando. Volverá en ~ 30 min".

**Workaround (10:10 AM):**

"Mientras Stripe se recupera, mostrar mensaje: 'Pagos en mantenimiento. Reintentar en 5 min'".

**Recovery (10:30 AM):**

Stripe se recupera. Error rate vuelve a 0.1%.

**Post-mortem:**

"Debimos:
1. Monitorear Stripe status page.
2. Tener circuit breaker (si Stripe cae > 2x, fallback a Paypal).
3. Comunicación proactiva a clientes."

---

### Actividades prácticas

**Actividad 1: Clasificar incidentes (12 min)**

5 incidentes. Clasifica severidad. Define RTO.

**Actividad 2: Plan de respuesta (13 min)**

Diseña runbook para incidente SEV-1 de tu app. Pasos, quién hace qué, escalaciones, comunicación.

---

## Clase 15: Cómo aprender de los fallos — Análisis de causa raíz y postmortem

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 8

### Objetivos de aprendizaje

- Aplicar la técnica de los "5 Por qués" para encontrar la causa raíz de un fallo.
- Diferenciar la causa directa (síntoma) de las causas sistémicas (el problema real).
- Ejecutar un postmortem sin culpar a personas.
- Crear acciones concretas para que el mismo fallo no vuelva a ocurrir.

---

### Contenido teórico

#### 1. Los 5 Por qués — Encontrar el problema real, no el síntoma

**Problema:** Servidor caído 30 minutos. Si dices "el servidor se cayó" y listo, el problema volverá. La técnica es preguntar "¿por qué?" repetidamente hasta llegar a la causa que puedes cambiar:

| # | Pregunta | Respuesta |
|---|---|---|
| 1 | ¿Por qué se cayó el servidor? | Memoria llena. Error “Out of Memory” |
| 2 | ¿Por qué se llenó la memoria? | Un memory leak en la versión 2.1.0 |
| 3 | ¿Por qué hay memory leak? | El código no cierra la conexión a la BD |
| 4 | ¿Por qué no se cerró la conexión? | El desarrollador olvidó el `.close()` |
| 5 | ¿Por qué pasó sin detectarse? | El code review no cubrió ese camino y no había prueba para ese caso |

**Causa real (sistémica):** Las pruebas no cubren todos los caminos + el code review fue superficial.  
**No es:** "El desarrollador cometió un error."

**Si arreglas sólo el síntoma:** Reinicias el servidor. Pero en 2 semanas vuelve a ocurrir.  
**Si arreglas la causa:** Agregas prueba para ese caso, mejoras el proceso de code review. No vuelve a ocurrir.

#### 2. Postmortem sin culpar a nadie (Blameless postmortem)

**Filosofía:** Los errores no ocurren porque las personas son malas. Ocurren porque el **sistema** lo permitió. Cuando culpas a una persona, no arreglas el sistema.

**Si culpas:** "El programador olvidó cerrar la conexión." → El programador tiene miedo de reportar futuros errores. El sistema sigue igual.

**Sin culpar:** "¿Qué condiciones del sistema permitieron que esta conexión no se cerrara?" → Encontramos el problema real. La gente reporta libremente.

| Preguntas CORRECTAS | Preguntas INCORRECTAS |
|---|---|
| ¿Qué condiciones lo permitieron? | ¿Quién cometió el error? |
| ¿Cómo podemos prevenir esto? | ¿Por qué el programador no hizo pruebas? |
| ¿Qué aprendimos del sistema? | ¿Quién fue el responsable? |

#### 3. Estructura de postmortem

1. **Resumen:** Descripción breve del incident. Impacto (duración, usuarios, revenue).

2. **Timeline:** Eventos segundo a segundo.
   - 10:00 - Alerta error rate.
   - 10:02 - On-call atiende.
   - 10:05 - Identifica OOM.
   - 10:35 - Rollback completado.

3. **Root causes:** 2-3 causas sistémicas (no: "Dev fault").

4. **Contributing factors:** Condiciones que facilitaron.
   - "Test suite no cobrió path".
   - "Monitoring de memory no alertó en 80%".
   - "Runbook de OOM no existía".

5. **Accionables:** Cambios concretos para prevenir.
   - "Agregar test de memory leak".
   - "Alertar en memory > 80%".
   - "Crear runbook OOM".

6. **Follow-up:** ¿Quién hace qué, cuándo?
   - "Dev A: Add test (jueves)".
   - "DevOps B: Alerting rule (martes)".

---

### Ejemplos prácticos

**Ejemplo 1: Postmortem de outage**

**Incident:**
- Inicio: 2026-08-15 14:00 UTC
- Fin: 2026-08-15 14:35 UTC
- Duración: 35 minutos
- Impacto: 50% usuarios, ~$50k revenue perdido.

**Timeline:**
```
14:00:00 - Alerta: CPU alta (95%)
14:00:30 - On-call revisa. "¿Pico de tráfico?"
14:01:00 - Error rate 5% (debería ser 0.1%)
14:02:00 - On-call abre war room. Tech lead se une.
14:03:00 - Investigación: "Nuevo deploy 13:55. Antes de eso, todo OK."
14:04:00 - Rollback iniciado.
14:06:00 - Rollback completado. Services recover.
14:10:00 - Error rate 0.1%. CPU normal. Incident resuelto.
```

**Root causes:**

1. **Code change causó inefficient loop en recommendation engine.**
   - Código nuevo entra en bucle infinito si input vacío.

2. **Tests no cubrieron el caso de input vacío.**
   - Coverage report: 85%, pero ese path específico no testeado.

3. **Code review no detectó porque reviewer no correr tests localmente.**
   - Revisor solo leyó diff, no ejecutó.

**Contributing factors:**

- Deploy en horario con tráfico (debería ser después de horas).
- No hay circuit breaker (si recommendation falla, fallback a default).
- El monitoreo de CPU alertó, pero latencia no alertó (debería ser la métrica principal).

**Accionables:**

| Acción | Propietario | Vencimiento | Prioridad |
|---|---|---|---|
| Agregar test de input vacío | Dev A | 2026-08-17 | P0 |
| Code reviewer debe ejecutar tests | Tech Lead | 2026-08-20 | P1 |
| Deploy solo en ventana off-peak | DevOps | 2026-08-22 | P0 |
| Agregar circuit breaker a recommendation | Dev B | 2026-08-24 | P1 |
| Alerta en latency, no solo CPU | DevOps | 2026-08-17 | P0 |

**Tone:**

"Esto fue excelente aprender. Sistema permitió este error. Todos los cambios propuestos van a mejorar robustez."

---

### Actividades prácticas

**Actividad 1: Five Whys analysis (12 min)**

Incident: "Base de datos down 1 hora".

Aplica 5 Whys. Identifica causa raíz sistémica.

**Actividad 2: Escribir postmortem (13 min)**

Mismo incident. Escribe postmortem blameless con: timeline, root causes, contributing factors, 3-5 accionables.

---

#### Ejercicio de código — Clase 15: Traza el bug y aplica los 5 Por qués

**Objetivo:** Practicar análisis de causa raíz leyendo código real, no solo describiendo el problema en abstracto.

**Escenario:** Tu sistema de carrito de compras tiene este bug reportado en producción:

> *"El total del carrito a veces muestra $0.00 aunque hay productos. Ocurre cuando el usuario agrega ítems, cierra sesión y vuelve a entrar."*

---

**Código con el bug (léelo completo antes de responder):**

```python
# carrito.py

class Carrito:
    def __init__(self):
        self.items = []         # lista de dicts: {nombre, precio, cantidad}
        self.descuento = 0.0    # porcentaje de descuento (0.0 a 1.0)

    def agregar_item(self, nombre: str, precio: float, cantidad: int):
        self.items.append({"nombre": nombre, "precio": precio, "cantidad": cantidad})

    def calcular_total(self) -> float:
        subtotal = 0
        for item in self.items:
            subtotal += item["precio"] * item["cantidad"]
        return subtotal * (1 - self.descuento)

    def limpiar(self):
        self.items = []
        self.descuento = 0.0


# sesion.py

class Sesion:
    _carrito_activo = None    # ← variable de clase (compartida entre TODAS las instancias)

    def iniciar(self, usuario_id: int):
        self.usuario_id = usuario_id
        if Sesion._carrito_activo is None:
            Sesion._carrito_activo = Carrito()   # ← solo crea uno nuevo si no existe

    def obtener_carrito(self) -> Carrito:
        return Sesion._carrito_activo

    def cerrar(self):
        Sesion._carrito_activo.limpiar()          # ← limpia el carrito al cerrar sesión
        # ¿Pero lo destruye? ¿O solo lo vacía?
```

**Flujo que produce el bug:**

```python
# Usuario A agrega productos
sesion_a = Sesion()
sesion_a.iniciar(usuario_id=1)
sesion_a.obtener_carrito().agregar_item("Libro", 25.0, 2)
print(sesion_a.obtener_carrito().calcular_total())  # → 50.0 ✅

# Usuario A cierra sesión
sesion_a.cerrar()

# Usuario B inicia sesión y agrega producto
sesion_b = Sesion()
sesion_b.iniciar(usuario_id=2)
sesion_b.obtener_carrito().agregar_item("Mochila", 80.0, 1)
print(sesion_b.obtener_carrito().calcular_total())  # → ¿Cuánto da? 🤔
```

---

**Paso 1 — Analiza el comportamiento (5 min):**

Sin ejecutar el código, responde:
1. `_carrito_activo` es una variable de instancia o de clase?
2. Cuando `sesion_b` llama `iniciar(usuario_id=2)`, ¿se crea un carrito nuevo o se reutiliza el de `sesion_a`?
3. ¿Qué retorna `sesion_b.obtener_carrito().calcular_total()`? ¿`80.0` o `0.0`?

**Paso 2 — Aplica los 5 Por qués (10 min):**

| # | Pregunta | Tu respuesta |
|---|---|---|
| 1 | ¿Por qué el total es $0.00? | |
| 2 | ¿Por qué el carrito está vacío al iniciar sesión? | |
| 3 | ¿Por qué `limpiar()` deja el carrito vacío para el siguiente usuario? | |
| 4 | ¿Por qué `_carrito_activo` es compartido entre sesiones? | |
| 5 | ¿Por qué el código fue escrito así sin detectarse el error? | |

**Paso 3 — Escribe la corrección (10 min):**

```python
# sesion_corregida.py — TU VERSIÓN

class Sesion:
    def iniciar(self, usuario_id: int):
        self.usuario_id = usuario_id
        # TU CÓDIGO AQUÍ:
        # La variable del carrito debe ser de INSTANCIA, no de clase.
        # Siempre crear un carrito NUEVO al iniciar sesión.
        pass

    def obtener_carrito(self) -> Carrito:
        # TU CÓDIGO AQUÍ
        pass

    def cerrar(self):
        # TU CÓDIGO AQUÍ:
        # Al cerrar sesión, ¿qué debe pasar con el carrito?
        pass
```

**Respuesta esperada (no mires hasta haber intentado):**

```python
class Sesion:
    def iniciar(self, usuario_id: int):
        self.usuario_id = usuario_id
        self._carrito = Carrito()   # ← variable de INSTANCIA, nuevo carrito por sesión

    def obtener_carrito(self) -> Carrito:
        return self._carrito

    def cerrar(self):
        self._carrito = None        # ← liberar referencia (el GC la limpiará)
        self.usuario_id = None
```

**Preguntas de postmortem:**
- ¿Qué prueba unitaria habría detectado este bug antes de llegar a producción?
- ¿Qué "condición del sistema" permitió que el bug llegara a producción?
- Si tuvieras que escribir el accionable de postmortem, ¿cuál sería?

---

# UNIDAD 4. Mantenimiento, evolución, ética y liberación

---

## Clase 16: Mantenimiento del software — El trabajo que ocurre después de lanzar

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 8

### Objetivos de aprendizaje

- Identificar los 4 tipos de mantenimiento (correctivo, adaptativo, perfectivo, preventivo).
- Aplicar refactorización: mejorar el código sin cambiar lo que hace.
- Gestionar la deuda técnica sin frenar el avance del equipo.
- Usar feature flags para hacer cambios de forma segura.

---

### Contenido teórico

#### 1. Los 4 tipos de mantenimiento

El software no termina cuando se lanza. La mayor parte de la vida del software es mantenimiento. Estos son los 4 tipos:

| Tipo | ¿Cuándo ocurre? | Ejemplo real | Urgencia |
|---|---|---|---|
| **Correctivo** | Algo está roto | "El cálculo de impuestos es incorrecto y el cliente pierde dinero" | Alta |
| **Adaptativo** | El entorno cambió | "Migrar de Python 2 a Python 3 porque Python 2 ya no tiene soporte" | Media-alta |
| **Perfectivo** | El sistema funciona pero puede mejorar | "Una consulta tarda 2 segundos; la optimizamos a 200ms" | Media |
| **Preventivo** | Evitar problemas futuros | "Actualizamos dependencias antes de que queden obsoletas" | Baja |

**Distribución típica:** En la práctica, más del 60% del esfuerzo de un equipo de software es mantenimiento (no nuevas funciones).

#### 2. Refactorización

**Definición:** Cambiar estructura interna sin cambiar comportamiento externo.

**Ejemplo:**

Antes:
```python
def get_user_age(user_id):
  user = db.query("SELECT * FROM users WHERE id = " + user_id)
  return datetime.now().year - user.birth_year
```

Después (refactorizado):
```python
def get_user_age(user_id):
  user = db.get_user_by_id(user_id)  # Abstracción
  return calculate_age(user.birth_date)  # Función pura

def calculate_age(birth_date):
  return datetime.now().year - birth_date.year
```

Behavior es idéntico. Pero: SQL injection arreglado, testeable, reutilizable.

#### 3. Deuda técnica

**Concepto:** Compromiso de calidad para ganancia de velocidad corto plazo.

**Matríz (Ward Cunningham):**

```
              Reckless | Deliberate
      ─────────────────┼─────────────────
Inadvertent │    ?     │   Paying down
      ─────────────────┼─────────────────
Deliberate  │   Bad!   │   Strategic
```

- **Reckless-Inadvertent:** "No sabía que era deuda." → Sorpresa. Malo.
- **Deliberate-Inadvertent:** "No previmos impacto." → Aprender.
- **Reckless-Deliberate:** "Atajos, código sucio." → Muy malo. Evitar.
- **Deliberate-Deliberate:** "Ganamos velocidad ahora, pagaremos después." → Strategic (OK si plazo claro).

**Estrategia:** Dedicar 15-20% del tiempo por sprint a "pagar deuda técnica".

#### 4. Feature flags para refactorización segura

**Técnica:** Refactorizar código, pero mantener ambas versiones. Toggle para elegir.

Ejemplo:

```python
if use_new_payment_engine:
  result = payment_engine_v2.process(order)
else:
  result = payment_engine_v1.process(order)
```

**Ventaja:** Rollout gradual. A/B testing. Rollback sin deploy.

---

### Ejemplos prácticos

**Ejemplo 1: Refactorización de función compleja**

Código frágil:

```javascript
// calculateTotal: 200 líneas, sin tests, acoplada a DB
function calculateTotal(cart_id) {
  let total = 0;
  const items = db.query("SELECT * FROM cart_items WHERE cart_id=" + cart_id);
  for (let i = 0; i < items.length; i++) {
    const item = items[i];
    const product = db.query("SELECT * FROM products WHERE id=" + item.product_id);
    let price = product.price;
    if (item.quantity > 10) {
      price = price * 0.9;  // 10% discount
    }
    total = total + (price * item.quantity);
  }
  return total;
}
```

**Problemas:** N+1 queries, duplicado descuento lógica, SQL injection, no testeable.

**Refactorización:**

```javascript
// Step 1: Extract discount logic
function applyDiscount(price, quantity) {
  return quantity > 10 ? price * 0.9 : price;
}

// Step 2: Extract line total
function calculateLineTotal(item, product) {
  const price = applyDiscount(product.price, item.quantity);
  return price * item.quantity;
}

// Step 3: Pure function (NO DB)
function calculateTotal(items, products) {
  return items.reduce((total, item) => {
    const product = products.find(p => p.id === item.product_id);
    return total + calculateLineTotal(item, product);
  }, 0);
}

// Test (fácil, no necesita DB mock)
assert(calculateTotal(
  [{product_id: 1, quantity: 15}],
  [{id: 1, price: 100}]
) === 100 * 0.9 * 15);
```

**Resultado:** Testeable, sin SQL injection, sin N+1 queries. Deuda técnica pagada.

---

### Actividades prácticas

**Actividad 1: Clasificar mantenimiento (12 min)**

5 cambios. Clasifica: correctivo, adaptativo, perfectivo, preventivo. Prioridad.

**Actividad 2: Refactorizar función (13 min)**

Código complejo dado. Refactoriza: extrae funciones, mejora tests, reduce coupling.

---

#### Ejercicio de código — Clase 16: Refactorización paso a paso

**Objetivo:** Aplicar 3 técnicas de refactorización concretas sobre un fragmento de código real, verificando en cada paso que el comportamiento no cambió.

**Código original (funciona, pero es difícil de mantener):**

```python
# factura.py  — VERSIÓN SIN REFACTORIZAR

def procesar_factura(cliente_id, items, descuento_cliente):
    # Calcular subtotal
    subtotal = 0
    for i in items:
        if i["tipo"] == "producto":
            subtotal += i["precio"] * i["cantidad"]
        elif i["tipo"] == "servicio":
            subtotal += i["precio"]

    # Calcular impuesto
    if subtotal < 100:
        impuesto = subtotal * 0.08
    elif subtotal < 1000:
        impuesto = subtotal * 0.12
    else:
        impuesto = subtotal * 0.16

    # Calcular descuento
    if descuento_cliente == "VIP":
        descuento = subtotal * 0.10
    elif descuento_cliente == "FIDELIDAD":
        descuento = subtotal * 0.05
    else:
        descuento = 0

    total = subtotal + impuesto - descuento

    # Construir resultado
    resultado = {
        "cliente":   cliente_id,
        "subtotal":  subtotal,
        "impuesto":  impuesto,
        "descuento": descuento,
        "total":     total
    }
    print(f"Factura para cliente {cliente_id}: ${total:.2f}")
    return resultado
```

**Problemas que tiene este código:**
- Una función hace 4 cosas distintas (viola el Principio de Responsabilidad Única).
- Los números mágicos (`0.08`, `0.12`, `0.16`, `0.10`, `0.05`) no tienen nombre.
- El `print` dentro de la función de negocio mezcla lógica con presentación.
- Muy difícil de probar en partes.

---

**Paso 1 — Extraer constantes con nombre (5 min)**

Mueve los números mágicos a constantes en la parte superior del archivo:

```python
# factura_v1.py — después del Paso 1

# TU CÓDIGO AQUÍ: define las constantes con nombres descriptivos
# Ejemplos de nombres: TASA_IVA_BASICA, TASA_IVA_MEDIA, TASA_IVA_ALTA
#                      DESCUENTO_VIP, DESCUENTO_FIDELIDAD
#                      UMBRAL_SUBTOTAL_BAJO, UMBRAL_SUBTOTAL_MEDIO
```

---

**Paso 2 — Extraer funciones puras (10 min)**

Divide la función grande en 3 funciones pequeñas, cada una con una sola responsabilidad:

```python
# factura_v2.py — después del Paso 2

def calcular_subtotal(items: list) -> float:
    """Suma el costo de todos los ítems según su tipo."""
    # TU CÓDIGO AQUÍ

def calcular_impuesto(subtotal: float) -> float:
    """Retorna el impuesto según el tramo del subtotal."""
    # TU CÓDIGO AQUÍ

def calcular_descuento(subtotal: float, tipo_cliente: str) -> float:
    """Retorna el descuento según el tipo de cliente."""
    # TU CÓDIGO AQUÍ

def procesar_factura(cliente_id: int, items: list, tipo_cliente: str) -> dict:
    """Ensambla la factura usando las funciones anteriores."""
    subtotal  = calcular_subtotal(items)
    impuesto  = calcular_impuesto(subtotal)
    descuento = calcular_descuento(subtotal, tipo_cliente)
    total     = subtotal + impuesto - descuento

    return {
        "cliente":   cliente_id,
        "subtotal":  round(subtotal,  2),
        "impuesto":  round(impuesto,  2),
        "descuento": round(descuento, 2),
        "total":     round(total,     2)
    }
    # Nota: ya no hay print() aquí — el llamador decide cómo mostrar el resultado
```

---

**Paso 3 — Escribir pruebas para verificar que no cambiaste el comportamiento (10 min)**

```python
# test_factura.py

from factura_v2 import calcular_subtotal, calcular_impuesto, calcular_descuento, procesar_factura

ITEMS_EJEMPLO = [
    {"tipo": "producto", "precio": 50.0,  "cantidad": 2},   # 100.00
    {"tipo": "servicio", "precio": 30.0,  "cantidad": 1},   # 30.00
]
# subtotal esperado: 130.00

def test_subtotal_mezcla_producto_y_servicio():
    assert calcular_subtotal(ITEMS_EJEMPLO) == 130.0

def test_impuesto_tramo_medio():
    # subtotal 130 → tramo medio (100-1000) → 12%
    assert calcular_impuesto(130.0) == 130.0 * 0.12

def test_descuento_vip():
    assert calcular_descuento(130.0, "VIP") == 130.0 * 0.10

def test_descuento_sin_categoria():
    assert calcular_descuento(130.0, "NORMAL") == 0.0

def test_factura_completa_cliente_vip():
    resultado = procesar_factura(
        cliente_id=42,
        items=ITEMS_EJEMPLO,
        tipo_cliente="VIP"
    )
    assert resultado["subtotal"]  == 130.0
    assert resultado["impuesto"]  == round(130.0 * 0.12, 2)
    assert resultado["descuento"] == round(130.0 * 0.10, 2)
    assert resultado["total"]     == round(130.0 + 130.0 * 0.12 - 130.0 * 0.10, 2)
```

**Ejecuta las pruebas:**
```bash
pytest test_factura.py -v
```

**Todas deben pasar en verde. Si alguna falla, tu refactorización cambió el comportamiento.**

**Preguntas de cierre:**
- ¿Cuántas pruebas tenía el código original? ¿Cuántas tiene ahora?
- Si el negocio cambia la tasa de impuesto alta a 18%, ¿en cuántos lugares del código nuevo debes cambiar? ¿Y en el original?
- ¿Qué técnicas de refactorización aplicaste en cada paso? (Extract Constant, Extract Function, Separate Concerns)

---

## Clase 17: Cómo reemplazar un sistema viejo sin apagarlo — Migración y sistemas heredados

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 9

### Objetivos de aprendizaje

- Entender cuándo un sistema heredado (legacy) necesita reemplazarse.
- Comparar las estrategias Big-Bang vs. Strangler Fig.
- Aplicar el patrón Strangler Fig para migrar gradualmente.
- Planificar la migración de datos sin corrupción ni pérdida.

---

### Contenido teórico

#### 1. ¿Big-Bang o Gradual? Las dos estrategias de migración

**Big-Bang** (❌ Evitar): Apagas el sistema viejo, enciendes el nuevo, y cruzas los dedos.
- Riesgo: Muy alto. Si falla, todo el sistema cae.
- Cuándo usar: Prácticamente nunca en sistemas críticos.

**Strangler Fig — Migración gradual** (✅ Recomendado):
El sistema nuevo "estrangula" al viejo poco a poco, como una higuera que crece alrededor de un árbol hasta reemplazarlo.

```
Día  1: 90% viejo, 10% nuevo (solo el login está migrado)
Día 10: 70% viejo, 30% nuevo (login + usuarios)
Día 20: 40% viejo, 60% nuevo (login + usuarios + pagos)
Día 30:  0% viejo, 100% nuevo
```

**Ventaja:** Bajo riesgo. Si algo falla, reviertes solo ese componente.
**Desventaja:** Es más lento y por un tiempo conviven dos sistemas.

---

#### 2. Patrón Strangler

**Router:** Request viene. Decide: ¿Viejo o nuevo sistema?

```
Request → Router
            ├─ /login → NEW system (200% usuarios listos)
            ├─ /users → NEW system
            ├─ /payments → OLD system (nuevo aún no listo)
            ├─ /reports → OLD system
            └─ ...
```

**Evolución:**

Conforme features migren:
```
Request → Router (Día 10)
            ├─ 50% tráfico → NEW
            ├─ 50% tráfico → OLD
```

Beneficios:

- Usuarios no ven discontinuidad.
- Parallelización: Dev equipo B en login, equipo C en payments.
- Rollback: Si nuevo login es buggy, revert router, 0 downtime.

#### 3. Gestión de datos

**Challenge:** Datos en BD vieja. Cómo transferir a BD nueva sin corrupción?

**Solución:**

1. **Replicación dual:** Vieja y nueva BD en paralelo.
   - Writes van a ambas (temporarily).
   - Validar consistency.

2. **Migración de datos:** Script que transforma datos vieja → nueva BD.
   - Test en ambiente staging.
   - Rollback plan.

3. **Reconciliación:** Post-migrate, validar todos datos coinciden.

---

### Ejemplos prácticos

**Ejemplo 1: Migración monolito → microservicios**

**Sistema viejo:** Monolito Rails. 500k líneas. 15 años.

Componentes:
- User management
- Payments
- Notifications
- Reports
- Admin panel

**Plan de migración (12 meses):**

**Fase 1 (Mes 1-2):** User management microservice.
- Implementar nuevo servicio.
- Router: POST /users/login → NEW. GET /users → OLD (temporario).
- Validar.

**Fase 2 (Mes 3-4):** Payments microservice.
- Similar a Fase 1.
- Router: /payments/* → NEW.

**Fase 3 (Mes 5-6):** Notifications, Reports.

**Fase 4 (Mes 7-12):** Admin, cleanup.
- Retirar rutas del router.
- Monolito viejo retratado a solo legacy.

**Beneficios:**

- Bajo riesgo (rollback cada fase).
- Parallelización (3 equipos simultáneamente).
- Validación continua.
- Usuarios sin downtime.

---

### Actividades prácticas

**Actividad 1: Plan de migración (12 min)**

Sistema heredado dado. Diseña plan Strangler con 5-6 fases. Timeline.

**Actividad 2: Data migration strategy (13 min)**

Detalla: cómo transferir datos, validación, rollback, reconciliación.

---

## Clase 18: Deuda técnica y modelos de IA en producción

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 9

### Objetivos de aprendizaje

- Medir la deuda técnica con indicadores concretos (ej: SonarQube).
- Entender el ciclo de vida de un modelo de IA en producción.
- Diferenciar data drift y concept drift con ejemplos fáciles.
- Aplicar prácticas básicas de MLOps para mantener modelos útiles en el tiempo.

---

### Contenido teórico

#### 1. Deuda técnica cuantificada

**SonarQube métrica:** Deuda en días-persona.

```
Proyecto: Payment API

Bugs: 5
Codesmells: 120
Coverage: 72% (target 85%)
Duplicación: 8%
Vulnerabilidades: 2

SonarQube calcula: 
  → Deuda = 15 días de refactorización equivalente
```

**Políticas:**

- Nunca superar 10 días de deuda.
- Pagar 10-15% de sprint capacity.
- Bloquear PR si agrega > 0.5 días de deuda nueva.

#### 2. Ciclo de vida de un modelo de IA

**Ejemplo:** Un recomendador tipo Netflix. El modelo no es "entrenar y olvidar"; hay que cuidarlo durante toda su vida.

1. **Entrenamiento inicial:**
  - Recolectas datos históricos.
  - Entrenas el modelo.
  - Lo validas con datos de prueba.

2. **Salida a producción:**
  - Activas el modelo para un porcentaje de usuarios (A/B test).
  - Mides métricas reales (CTR, precisión, tiempo de respuesta).

3. **Monitoreo continuo:**
  - Revisas si sigue funcionando bien con datos reales.
  - Aquí aparecen dos riesgos clave:

| Problema | ¿Qué cambia? | Ejemplo | ¿Qué hacer? |
|---|---|---|---|
| **Data drift** | Cambian los datos de entrada | Antes casi no había videos cortos; ahora sí. El modelo no vio ese patrón al entrenar | Reentrenar con datos recientes |
| **Concept drift** | Cambia la relación entre entrada y salida | Antes a un usuario le gustaban dramas; ahora consume anime y comedia | Reentrenar y ajustar variables del modelo |

4. **Degradación:**
  - Si la precisión cae de forma sostenida, decides entre:
  - Reentrenar el modelo actual, o
  - Diseñar una nueva arquitectura.

#### 3. MLOps practices

**CI/CD para modelos:**

```
Data versioning (DVC)
  ↓
Model training (TensorFlow)
  ↓
Model validation (tests: accuracy, fairness, bias)
  ↓
Model registry (store model v1.2.3)
  ↓
Deploy canary (5% usuarios)
  ↓
Monitor (accuracy, data drift, performance)
  ↓
Retrain trigger (si accuracy < threshold)
```

---

### Ejemplos prácticos

**Ejemplo 1: Deuda técnica negociación**

Team quiere agregar feature "multi-currency". Estimación: 5 SP.

PM: "Presupuesto solo 8 SP este sprint."

Dev Lead: "Feature es 5 SP, pero acumularía 2 SP deuda técnica (code duplication)."

Decision: "OK, hacemos feature. Pero próximo sprint, pagamos esa deuda."

---

**Ejemplo 2: Concept drift en modelo de fraude**

Modelo: Detecta transacciones fraudulentas.

**Pre-COVID:** Patrón fraude = grandes transacciones de noche.

**COVID:** Lockdown. Nuevo patrón = compras en línea noche alta.

**Resultado:** Modelo marca legítimas como fraude. False positive rate sube 50%.

**Solución:** Retrain modelo con datos COVID. Accuracy vuelve a 95%.

---

### Actividades prácticas

**Actividad 1: MLOps pipeline**

Diseña CI/CD para modelo IA. Stages: data, train, validate, deploy, monitor.

**Actividad 2: Gestionar deuda técnica**

Proyecto con 25 días de deuda técnica. Plan de pago en 6 sprints. Decisiones: qué pagar primero?

---

## Clase 19: Ética, licencias y accesibilidad — Decisiones técnicas con impacto real

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 10

### Objetivos de aprendizaje

- Entender por qué la ética también es parte del trabajo de ingeniería.
- Diferenciar licencias comunes (MIT, GPL, Apache, comercial) y su impacto legal.
- Aplicar principios básicos de accesibilidad (WCAG 2.2) en interfaces.
- Reconocer y reducir sesgos en sistemas de IA.

---

### Contenido teórico

#### 1. Ética profesional (ACM) — Lo correcto también es ingeniería

La ética no es un tema "extra". Tus decisiones técnicas pueden afectar dinero, salud, privacidad y oportunidades de miles de personas.

| Principio | ¿Qué significa en la práctica? | Ejemplo |
|---|---|---|
| Contribuir al bienestar | Diseñar software que ayude, no que perjudique | Evitar prácticas manipuladoras para enganchar usuarios |
| Evitar daño | No ignorar riesgos de seguridad o discriminación | Reportar una vulnerabilidad grave apenas se detecta |
| Ser transparente | Decir límites reales del sistema | "Este modelo tiene 92% de precisión, no 100%" |
| Trato justo | Evitar exclusiones por género, discapacidad, nivel económico | Revisar si una IA afecta peor a un grupo específico |
| Respetar privacidad | Pedir solo los datos necesarios y protegerlos | No guardar ubicación si la app no la necesita |

#### 2. Licencias de software — Qué puedes usar y bajo qué reglas

| Licencia | ¿La puedes usar en proyectos comerciales? | ¿Puedes modificar? | Condición clave |
|---|---|---|---|
| **MIT** | Sí | Sí | Mantener aviso de copyright/licencia |
| **GPL** | Sí, pero con obligación de compartir código derivado | Sí | Si distribuyes software derivado, también debe ser GPL |
| **Apache 2.0** | Sí | Sí | Incluye protección explícita de patentes |
| **Comercial/Propietaria** | Depende del contrato | Generalmente no | Pagas licencia y cumples el EULA |

**Para el equipo:** Revisar licencias de dependencias no es opcional. Una librería GPL puede obligar cambios legales en tu producto.

#### 3. Accesibilidad (WCAG 2.2) — Diseñar para todas las personas

**Objetivo:** Que una persona pueda usar tu sistema aunque no vea bien, no escuche bien, tenga movilidad reducida o use lector de pantalla.

**Nivel recomendado en industria:** **AA**.

Checklist práctico (AA):

1. **Contraste suficiente:** texto legible sobre el fondo.
2. **Texto alternativo en imágenes:** para lectores de pantalla.
3. **Uso completo por teclado:** todo debe funcionar con Tab/Enter, sin mouse.
4. **Subtítulos en videos:** para personas con discapacidad auditiva.
5. **HTML semántico y ARIA:** para que tecnologías de apoyo entiendan la interfaz.

**Cómo validarlo:**
- Herramientas automáticas (Axe, WAVE).
- Pruebas manuales.
- Idealmente, pruebas con usuarios reales.

#### 4. Sesgo en modelos IA

**Problema:** Modelo entrenado en datos históricos (biased) perpetúa bias.

**Ejemplo: Algoritmo de hiring de Amazon.**

- Entrenado en datos históricos (mayoría hombres en tech).
- Modelo aprendió: "Hombres = good hire".
- Discriminó mujeres automáticamente.
- Amazon canceló (reputación, legalidad).

**Soluciones:**

1. **Auditoría de datos:** ¿Está biased el dataset de entrenamiento?
2. **Fairness testing:** Medir accuracy por demografía. ¿Equal performance?
3. **Bias mitigation:** Balancear dataset, ajustar pesos.

---

### Ejemplos prácticos

**Ejemplo 1: Auditar licencias**

Proyecto con 50 dependencias.

```bash
npm ls --depth=0
├── express@4.18.0 (MIT)
├── lodash@4.17.21 (MIT)
├── redis@4.1.0 (MIT)
├── some-gpl-lib@1.0.0 (GPL v2)
└── ...
```

GPL v2 detectado. Implicación: Tu código debe ser GPL v2 también (si es derivado).

Opción A: Remove `some-gpl-lib`. Usar alternativa MIT.  
Opción B: OK ser GPL v2 (ej: SaaS interno, no vendemos).

**Decision:** A (mantenemos MIT para flexibilidad).

---

**Ejemplo 2: WCAG compliance checklist**

App de banca. Testing:

- [ ] Buttons have labels (screen reader readable).
- [ ] Color contrast text/background >= 4.5:1. Check: Axe report. ❌ FAIL (2.1:1).
- [ ] All forms keyboard accessible (Tab navigation).
- [ ] Videos captioned.
- [ ] Mobile responsive (zoom-ability).

**Fix:** Aumentar contrast colores. Re-test. ✓ PASS.

---

### Actividades prácticas

**Actividad 1: Ethical scenario**

Scenario: PM pide agregar tracking de datos de usuarios sin consentimiento para "mejorar recomendaciones".

Respuesta ética: Qué dirías? Cómo lo justificas?

**Actividad 2: Accesibilidad audit**

App dada. Auditoría manual + herramienta Axe. Lista de issues WCAG AA. Prioriza fixes.

---

## Clase 20: Lanzamiento responsable — Sostenibilidad, decisión go/no-go y sustentación

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 10

### Objetivos de aprendizaje

- Entender cómo el software también tiene impacto ambiental.
- Usar una lista de verificación para decidir si un sistema está listo para producción.
- Preparar una sustentación técnica clara y bien argumentada.
- Reflexionar sobre decisiones profesionales y responsabilidad ética.

---

### Contenido teórico

#### 1. Green Software (Sostenibilidad)

**Problema:** Software consume energía. Data centers emiten CO2.

**Ejemplo:** Streaming de video = 36kg CO2/año por usuario (Netflix).

**Soluciones:**

1. **Eficiencia energética:**
   - Algoritmos optimizados. Menos CPU = menos energía.
   - Compresión de datos. Menos transferencia = menos energía.
   - Caché. Menos queries = menos energía.

2. **Green hosting:**
   - Cloud providers con energía renovable (Google Cloud, AWS).
   - Data centers en zonas frías (Islandia, Suiza).

3. **Software lifecycle:**
   - Evitar over-engineering. Simple es sostenible.
   - Longevidad. Software que dura 10 años vs. 1 año = menos e-waste.
   - End-of-life: Recyclability, no landfill.

#### 2. Go/No-Go Checklist

Antes de deploy a producción:

**Funcionalidad:**
- [ ] Cumple requisitos (acceptance criteria).
- [ ] Bugs críticos fixed (0 SEV-1).
- [ ] Tests passed (coverage >= 80%).

**Calidad:**
- [ ] Code review aprobado.
- [ ] SonarQube quality gate passed.
- [ ] No new vulnerabilities (security scan).

**Rendimiento:**
- [ ] P95 latency < SLO.
- [ ] No memory leaks (profiling).
- [ ] Load tested (puede soportar 2x pico de tráfico).

**Operación:**
- [ ] Runbooks escritos (qué hacer si falla).
- [ ] Rollback plan (cómo revertir).
- [ ] Monitoreo alertas configuradas.
- [ ] On-call team preparado.

**Comunicación:**
- [ ] Stakeholders notificados (timeline, scope).
- [ ] Customer communication drafted (si downtime).

**Decision:**
- ✓ **GO:** Cumple todo.
- ✗ **NO-GO:** Fallos en crítico (P0) bloquean.
- ⚠️ **GO-WITH-RISK:** Fallos en secundario (P1). Aceptado riesgo consciente.

#### 3. Sustentación

**Sustentación:** Presentación final del proyecto. Reflexión sobre aprendizaje, decisiones, ética.

**Estructura típica (15-20 minutos):**

1. **Contexto:** Problema que se resolvió. Scope. Restrictions.
2. **Decisiones técnicas:** Qué tecnologías, por qué. Alternativas consideradas.
3. **Proceso:** Modelo de ciclo de vida elegido. Justificación.
4. **Resultados:** Métricas. ¿Se alcanzó SLO? Performance.
5. **Lessons learned:** Qué salió bien, mal, qué harías diferente.
6. **Reflexión ética:** Impacto. ¿Beneficia a usuarios? ¿Privacidad protegida?
7. **Futuro:** Qué vendría. Roadmap siguiente.

---

### Ejemplos prácticos

**Ejemplo 1: Go/No-Go para producción**

App de pagos.

**Checklist:**

| Criterio | Status | Nota |
|---|---|---|
| **Funcional** |
| Requisitos | ✓ | 100% acceptance criteria met |
| Bugs críticos | ✓ | 0 SEV-1. 2 SEV-3 (aceptado riesgo) |
| Tests | ✓ | Coverage 88% (target 85%) |
| **Calidad** |
| Code review | ✓ | 2 approvals |
| SonarQube | ✓ | Quality gate passed |
| Seguridad | ✗ | 1 CVE high (dependencia outdated) |
| **Rendimiento** |
| Latency P95 | ✓ | 180ms (target 200ms) |
| Memory | ✓ | No leaks (profiled 1 hora) |
| Load | ✓ | Soporta 3x pico |
| **Operación** |
| Runbooks | ✓ | Escritos |
| Rollback | ✓ | Testeado |
| Alertas | ✓ | Configuradas |
| On-call | ✓ | Team notificado |
| **Comunicación** |
| Stakeholders | ✓ | Notificados |
| Clientes | ✓ | Draft listo |

**Decision:** ⚠️ **GO-WITH-RISK**

Razón: Hay una vulnerabilidad alta (CVE) pendiente de actualización, pero la funcionalidad es crítica para el lanzamiento. Plan: actualizar la dependencia en 48 horas después del despliegue.

---

### Actividades prácticas

**Actividad 1: Go/No-Go análisis (12 min)**

Proyecto dado. Llenar checklist. Decision: GO / NO-GO / GO-WITH-RISK.

**Actividad 2: Sustentación prep (13 min)**

Preparar outline de sustentación para proyecto personal (5 minutos hablado).

---

# Apéndices

## Apéndice A: Rúbrica de evaluación (Sustentación)

| Criterio | Insuficiente (0-5) | Regular (6-12) | Bueno (13-18) | Excelente (19-25) |
|---|---|---|---|---|
| **Comprensión conceptual** | No demuestra entendimiento de conceptos | Demuestra parcial entendimiento | Demuestra buen entendimiento | Demuestra profundo entendimiento. Conecta conceptos. |
| **Aplicación práctica** | No aplica conceptos a proyecto | Aplicación superficial | Aplicación competente. Decisiones justificadas. | Aplicación avanzada. Consideró alternativas. |
| **Decisiones argumentadas** | Sin justificación | Justificación vaga | Justificación clara, referencia normas | Justificación rigurosa, cita normas, benchmarks. |
| **Consciencia ética** | No menciona consideraciones éticas | Menciona pero superficialmente | Analiza impacto en usuarios/privacidad | Reflexión profunda sobre implicaciones sistémicas. |

**Puntaje:** 0-25 por criterio. Total 100 puntos = A.

---

## Apéndice B: Herramientas recomendadas

**Gestión de proyecto:** Jira, Azure DevOps, Linear.  
**VCS:** GitHub, GitLab, Bitbucket.  
**CI/CD:** GitHub Actions, Jenkins, GitLab CI, CircleCI.  
**Contenedores:** Docker, Kubernetes, Podman.  
**IaC:** Terraform, Ansible, CloudFormation.  
**Monitoreo:** Prometheus, Grafana, Datadog, New Relic, ELK Stack.  
**Testing:** Jest, Pytest, JUnit, Selenium, Cypress, Playwright.  
**Seguridad:** SonarQube, OWASP ZAP, Snyk, Burp Suite, gitleaks.  
**Analítica:** Mixpanel, Amplitude, Segment.  

---

## Apéndice C: Plantillas descargables

### Definition of Ready

- Criterios de aceptación escritos
- Estimación consensuada
- Dependencias identificadas
- Tamaño < 8 SP
- Mockups (si aplicable)
- No hay bloqueadores

### Definition of Done

- Código review (2+ aprobaciones)
- Tests unitarios (>= 80% coverage)
- Tests integración (si aplica)
- Tests manuales en staging
- Documentación actualizada
- CI verde
- PO aceptó

### Go/No-Go Checklist

- Funcional: Requisitos cumplidos, tests passed
- Calidad: Quality Gate passed, coverage OK
- Seguridad: Vulnerabilidades críticas = 0
- Rendimiento: SLO cumplido
- Operación: Runbooks, alertas, rollback plan
- Comunicación: Stakeholders notificados

---

## Apéndice D: Referencias bibliográficas

### Libros

- Kim, Behr, Spafford (2014). *The Phoenix Project* — Novela sobre DevOps.
- Forsgren, Humble, Kim (2018). *Accelerate* — DORA metrics.
- Google SRE (2016). *Site Reliability Engineering* — Principios SRE.
- Fowler, Beck (2018). *Refactoring* — Técnicas de refactorización.
- Martin (2008). *Clean Code* — Código de calidad.
- Sommerville (2015). *Software Engineering* — Texto clásico.

### Estándares

- ISO/IEC/IEEE 12207:2017 — Procesos del ciclo de vida
- ISO/IEC/IEEE 828:2012 — Gestión de configuración
- ISO/IEC 25010:2023 — Modelo de calidad
- OWASP Top 10 — Vulnerabilidades web
- WCAG 2.2 — Accesibilidad web
- GDPR, CCPA — Privacidad de datos

### Recursos online

- dora.dev — Métricas DORA
- sre.google — Google SRE book
- semver.org — Semantic Versioning
- agilemanifesto.org — Agile Manifesto
- cloud.google.com/architecture — Patrones cloud
- owasp.org — Seguridad

---

**Fin del curso — Ingeniería del Software**

*Última actualización: agosto 2026*  
*Versión: 3.0 (Completo: 20 clases, 40 horas)*  
*Público: Ingenieros de software, líderes técnicos, estudiantes*

