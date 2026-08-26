### TALLER

**Actividad: Modelo de dominio**

Para un sistema de pagos de servicios publicos, en donde existen entidades como cuenta, cuenta de ahorros, cuenta corriente, factura, cliente y pago, identificar 6 funcionalidades de negocio.

**Tareas:**
**Fase 1 Requisitos**
- Construir las historias de usuario en jira asociadas a las funcionalidades del sistema de pagos de servicios publicos.
- Construir los casos de uso de las funcionalidades del sistema de pagos de servicios publicos.

**Tareas:**
**Fase 2 Diseño**
- Construir el diagrama de arquitectura.
- Construir el diagrama C4
- Construir el diagrama de clases
- Construir el diagrama entidad relacion
- Construir los diagramas de secuencia

**Fase 3 Implementacion**
- Construccion del diagrama de arquitectura de software (Arquitectura cliente servidor, por capas, hexagonal, limpia, etc)
- Entrega del repositorio con el codigo fuente
- Entrega de los archivos SQL

### Ejemplo: Sistema de Gestión de Citas Médicas

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