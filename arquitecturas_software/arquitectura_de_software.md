# Arquitectura de Software — Curso Completo (2 horas × 20 clases)

> Material de referencia — Universidad de Manizales  
> Última actualización: agosto 2026 | Versión: 1.0  
> **Duración total: 40 horas** | 20 clases × 2 horas

---

## Mapa de clases

| Clase | Título | Unidad |
|---|---|---|
| 01 | Arquitectura como estructuras y decisiones | 1 |
| 02 | Requisitos arquitectónicamente significativos y drivers | 1 |
| 03 | Atributos de calidad y escenarios (ISO/IEC 25010) | 1 |
| 04 | Estilos, patrones y tácticas arquitectónicas | 1 |
| 05 | Documentación: ISO 42010, vistas 4+1 y modelo C4 | 1 |
| 06 | ADR, arquitectura como código e IA como revisora | 1 |
| 07 | Attribute-Driven Design (ADD): de drivers a estructuras | 2 |
| 08 | Árbol de utilidad, sensitivity points y ATAM simplificado | 2 |
| 09 | Principios cloud-native y Twelve-Factor App | 2 |
| 10 | Docker y Docker Compose en arquitecturas reales | 2 |
| 11 | Introducción a Kubernetes y orquestación de contenedores | 2 |
| 12 | Comunicación síncrona, asíncrona, API Gateway y colas | 3 |
| 13 | IA como componente arquitectónico: RAG, guardrails y fallback | 3 |
| 14 | Patrones de resiliencia: timeout, retry, circuit breaker, bulkhead | 3 |
| 15 | Estimación de capacidad y topología de despliegue | 3 |
| 16 | Pruebas de carga (k6/JMeter) y observabilidad básica | 3 |
| 17 | Proyecto: drivers, escenarios y arquitectura candidata | 4 |
| 18 | Proyecto: prototipo contenerizado y resiliencia end-to-end | 4 |
| 19 | Proyecto: validación, carga, observabilidad y análisis de impacto | 4 |
| 20 | Defensa técnica individual y autorreferencia final | 4 |

---

# UNIDAD 1. Fundamentos, drivers y documentación arquitectónica

---

## Clase 01: Arquitectura como estructuras y decisiones

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 1

### Objetivos de aprendizaje

- Definir arquitectura de software desde múltiples perspectivas (Bass, Fowler, Garlan).
- Explicar el concepto de "arquitectura como decisiones" y el costo de cambiar una decisión.
- Identificar deuda arquitectónica y erosión en sistemas reales.
- Distinguir entre arquitectura, diseño y código.

---

### Contenido teórico (45 minutos)

#### 1. ¿Qué es la arquitectura de software?

**Definición de Bass, Clements y Kazman (2022):**

> "La arquitectura de software de un sistema es el conjunto de estructuras necesarias para razonar sobre el sistema, que comprende elementos de software, relaciones entre ellos y propiedades de ambos."

**Perspectiva de Fowler:**

> "La arquitectura son las decisiones difíciles de cambiar."

**Perspectiva de Garlan:**

> "La arquitectura define la organización fundamental de un sistema, incluidos sus componentes, sus relaciones mutuas, su relación con el entorno, y los principios que gobiernan su diseño y evolución."

**Claves conceptuales:**

1. **Estructuras:** No hay "una" arquitectura. Existen múltiples vistas (módulos, componentes-conectores, despliegue).
2. **Decisiones:** Cada decisión de arquitectura tiene costo de reversión.
3. **Propiedades emergentes:** Rendimiento, disponibilidad, seguridad no están en ningún componente individual; surgen de las relaciones.

#### 2. Estructuras arquitectónicas

**Estructura de módulos:** ¿Cómo está dividido el código?
- Módulos, capas, paquetes, subsistemas.
- Relación: "usa", "es parte de", "depende de".

**Estructura de componentes-conectores:** ¿Cómo corren los procesos en tiempo de ejecución?
- Componentes: instancias de proceso, servicios, BD.
- Conectores: HTTP, mensajes, RPC.

**Estructura de despliegue:** ¿Dónde corre el software?
- Servidores, VMs, contenedores, regiones cloud.
- Relación: "desplegado en", "comunica con".

**Ejemplo — sistema e-commerce:**

```
Estructura módulos:
  UserModule → OrderModule → PaymentModule → NotificationModule

Estructura componentes-conectores (tiempo real):
  Browser -HTTP→ API Gateway -REST→ OrderService
                              -AMQP→ NotificationService
                              -SQL→ PostgreSQL

Estructura despliegue:
  API Gateway: AWS ELB (2 AZ)
  OrderService: 3 réplicas EC2 t3.medium
  NotificationService: Lambda (serverless)
  PostgreSQL: RDS Multi-AZ
```

Tres vistas, un sistema. Cada una responde preguntas distintas.

#### 3. Arquitectura como decisiones

**Tipos de decisiones arquitectónicas:**

| Tipo | Ejemplo | Costo de cambio |
|---|---|---|
| Estilo/patrón | Monolito vs. microservicios | Muy alto |
| Tecnología | PostgreSQL vs. MongoDB | Alto |
| Protocolo | REST vs. gRPC | Medio-alto |
| Estructura de módulos | Capas vs. hexagonal | Medio |
| Configuración | Variables de entorno vs. config service | Bajo |

**Ley de cambio arquitectónico:**

El costo de cambiar una decisión es proporcional al número de elementos que dependen de ella × el tiempo transcurrido.

**Implicación práctica:** Las decisiones más importantes deben tomarse con la mayor información posible, pero también deben poder revisarse cuando nueva información llega. Por eso existen los ADR.

#### 4. Deuda arquitectónica y erosión

**Deuda arquitectónica:** Compromisos estructurales que dificultan la evolución del sistema.

**Ejemplos:**
- Lógica de negocio embebida en stored procedures que dificultan cambio de BD.
- Microservicio que accede directamente a la BD de otro (rompe encapsulamiento).
- Librería de terceros sin abstracción (acoplamiento externo directo).

**Erosión arquitectónica:** La arquitectura planeada diverge de la implementada con el tiempo.

```
Diseñada:       Real (6 meses después):
UI → API → Service → DB      UI → API ──────────────→ DB
                                   │                    │
                                   └→ Service → BD2 ←──┘
                             (Alguien hizo "solo este caso especial")
```

**Causas:** Presión de tiempo, falta de revisión, conocimiento no compartido.

**Remediación:** ADR, code reviews de arquitectura, herramientas como ArchUnit, Structurizr.

#### 5. Arquitectura vs. Diseño vs. Código

| Nivel | Alcance | Impacto | Ejemplo |
|---|---|---|---|
| **Arquitectura** | Sistema completo | Muy alto, difícil cambiar | Microservicios vs. monolito |
| **Diseño** | Módulo/componente | Medio | Patrón Repository, Factory |
| **Código** | Función/clase | Bajo | Nombre de variable, algoritmo |

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Amazon — Evolución arquitectónica**

2000: Amazon.com era un monolito masivo. Funcionaba para el tamaño de entonces.

Problemas a escala (2002):
- Build: 2 horas. Tests: 8 horas.
- Cambios requerían coordinación de 100+ personas.
- Black Friday: Sistema saturado. Revenue perdido.

Decisión (Jeff Bezos, 2002): "Todos los teams deben exponer datos y funcionalidad SOLO a través de interfaces de servicio. No excepciones."

Resultado: 15 años después → AWS. Servicios independientes. Cada equipo dueño de su servicio. Deploy independiente.

Costo: 3 años de migración, decenas de millones de dólares. Pero creó $60B/año en AWS.

Lección: Decisiones arquitectónicas tienen horizonte de tiempo largo. Evaluar a 5-10 años.

---

**Ejemplo 2: Deuda arquitectónica en startup**

Año 1: MVP rápido. PHP + MySQL. "Funciona, lanzamos".

Año 2: Escalan a 50 ciudades. 300 tablas, lógica de precios en stored procedures, sin tests.

Año 3: Quieren cambiar motor de precios (ML). Imposible: lógica en stored procedures no es testeable.

Deuda acumulada: 2 años de ingeniería para desacoplar.

Lección: La deuda arquitectónica se acumula con interés. Pagar temprano es más barato.

---

### Preguntas de reflexión

1. ¿Puede haber "buena" deuda arquitectónica? ¿Cuándo es estratégica?
2. ¿Quién es responsable de la arquitectura en un equipo Ágil?
3. ¿Cómo explicarías "arquitectura" a un PM que solo entiende features?

---

### Recursos

- Bass, Clements, Kazman. *Software Architecture in Practice* (4ª ed.)
- Richards, Ford. *Fundamentals of Software Architecture*
- Fowler. *Patterns of Enterprise Application Architecture*

---

## Clase 02: Requisitos arquitectónicamente significativos y drivers

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 1

### Objetivos de aprendizaje

- Distinguir entre requisitos funcionales y arquitectónicamente significativos.
- Identificar los cuatro tipos de drivers arquitectónicos.
- Priorizar drivers por impacto y riesgo.
- Escribir drivers bien formados y medibles.

---

### Contenido teórico (45 minutos)

#### 1. Requisitos Arquitectónicamente Significativos (ASR)

No todos los requisitos afectan la arquitectura. Los ASR son aquellos que:
1. Tienen alto impacto en la estructura.
2. Son difíciles de cumplir.
3. Afectan múltiples componentes.
4. Requieren decisiones de diseño explícitas.

**Filtro ASR:**

| Requisito | ¿ASR? | Razón |
|---|---|---|
| "El sistema debe enviar emails" | No | Un servicio simple lo resuelve |
| "El sistema debe procesar 100k transacciones/seg" | Sí | Afecta particionamiento, replicación, tecnología |
| "El sistema debe estar disponible 99.99%" | Sí | Afecta toda la infraestructura |
| "El campo nombre máximo 100 chars" | No | Validación simple |
| "Ningún dato puede salir de la UE" | Sí | Afecta topología de despliegue completa |

#### 2. Cuatro tipos de drivers

**Restricciones (Constraints):** Decisiones ya tomadas que limitan opciones.
- Negocio: "Debe integrarse con SAP existente."
- Técnicas: "Debe correr en Azure." "Equipo conoce Java."
- Regulatorias: "Datos de salud: HIPAA." "Pagos: PCI-DSS nivel 1."

**Atributos de calidad:** Propiedades no funcionales que el sistema debe exhibir.
- Disponibilidad, rendimiento, seguridad, mantenibilidad, escalabilidad.
- Se especifican como escenarios de calidad (próxima clase).

**Requisitos funcionales influyentes:** Funcionalidades que dictan la arquitectura.
- "Soportar 50 idiomas" → i18n architecture.
- "Extensiones por plugins" → Plugin architecture.
- "Transacciones auditadas 100%" → Event sourcing.

**Preocupaciones de stakeholders:** Necesidades implícitas no en requisitos formales.
- CEO: "No quiero que un incidente salga en noticias" → seguridad, disponibilidad.
- Dev team: "Necesitamos desplegar sin coordinación" → independencia de servicios.

#### 3. Drivers bien formados

| Mal formado | Bien formado |
|---|---|
| "El sistema debe ser rápido" | "El sistema debe responder el endpoint de score en P95 ≤ 2s bajo carga de 500 req/seg" |
| "El sistema debe ser seguro" | "El sistema debe cumplir OWASP Top 10 y pasar pentesting externo antes de go-live" |
| "El sistema debe escalar" | "El sistema debe soportar crecimiento de 100k a 1M usuarios sin rediseño arquitectónico" |

#### 4. Priorización: Matriz Impact × Risk

```
High Impact   |  PRIORITAD ALTA    |  INVESTIGAR      |
              |  (arquitectura     |  (confirmar si   |
              |  debe resolverlo)  |  realmente      |
              |                    |  importante)    |
──────────────┼────────────────────┼─────────────────┤
Low Impact    |  SECUNDARIO        |  IGNORAR        |
              └────────────────────┴─────────────────┘
                   High Risk           Low Risk
```

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Extraer drivers de un brief**

Brief del cliente:
> "Somos una fintech colombiana. Queremos construir una plataforma de crédito al consumo. Los clientes aplican desde la app. En segundos deben saber si son aprobados (ML scoring). Esperamos crecer a 1M clientes en 2 años. Estamos regulados por la SFC. El stack actual es AWS + Python. Equipo de 5 personas."

**Restricciones:** AWS + Python. Equipo de 5. Regulación SFC. Datos financieros en Colombia.

**Atributos de calidad:** Score ML < 2 segundos. Escalabilidad 1M usuarios. Disponibilidad 99.9%. Seguridad datos financieros. Auditabilidad SFC.

**Funcionales influyentes:** Integración bureaus de crédito. Motor de decisión ML.

**Preocupaciones implícitas:** CEO: "Que no nos retire la licencia". Dev team: "Actualizar modelo ML sin downtime."

---

**Ejemplo 2: Priorizar drivers**

10 drivers. Colocar en matriz. Top 3 justificados.

Resultado típico: Disponibilidad 99.9% (H, H), Score < 2s (H, H), Seguridad PCI-DSS (H, M).

---

### Actividades prácticas (25 minutos)

**Actividad 1: Extraer ASR (12 min)**

Brief de sistema de telemedicina. Extraer: 3 restricciones, 4 atributos de calidad, 2 funcionales influyentes, 2 preocupaciones implícitas.

**Actividad 2: Priorizar drivers (13 min)**

10 drivers dados. Colocar en matriz Impact × Risk. Justificar Top 3. ¿Qué hace al Top 1 ser el más importante?

---

## Clase 03: Atributos de calidad y escenarios (ISO/IEC 25010)

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 2

### Objetivos de aprendizaje

- Mapear atributos de calidad según ISO/IEC 25010:2023.
- Escribir escenarios de calidad completos (6 partes).
- Identificar tácticas arquitectónicas para cada atributo.
- Detectar trade-offs entre atributos de calidad.

---

### Contenido teórico (45 minutos)

#### 1. ISO/IEC 25010:2023 — Atributos de calidad

**8 características principales:**

1. **Idoneidad funcional:** ¿El software hace lo que se especifica?
2. **Rendimiento:** Recursos usados vs. resultados. Latencia, throughput.
3. **Compatibilidad:** Coexiste con otros sistemas. Interoperabilidad.
4. **Usabilidad:** Facilidad de uso. Aprendizaje, operabilidad.
5. **Confiabilidad:** ¿Cuándo falla? MTBF, disponibilidad, tolerancia a fallos.
6. **Seguridad:** Confidencialidad, integridad, autenticidad, no repudio.
7. **Mantenibilidad:** Facilidad de modificar. Modularidad, testeabilidad.
8. **Portabilidad:** Trasladar a otro entorno. Adaptabilidad.

#### 2. Estructura de escenarios de calidad (6 partes)

```
Fuente    → ¿Quién genera el estímulo?
Estímulo  → ¿Qué evento ocurre?
Artefacto → ¿Qué parte del sistema se afecta?
Entorno   → ¿En qué condición?
Respuesta → ¿Qué hace el sistema?
Medida    → ¿Cómo se mide el éxito?
```

**Escenario de Rendimiento:**

| Parte | Valor |
|---|---|
| Fuente | 500 usuarios simultáneos |
| Estímulo | Solicitan endpoint GET /score |
| Artefacto | Sistema de scoring crediticio |
| Entorno | Operación normal, hora pico |
| Respuesta | Retorna respuesta HTTP 200 con score |
| Medida | P95 latencia ≤ 2 segundos; error rate 0% |

**Escenario de Disponibilidad:**

| Parte | Valor |
|---|---|
| Fuente | Fallo de hardware en AZ us-east-1a |
| Estímulo | Zona de disponibilidad cae |
| Artefacto | API de pagos |
| Entorno | Horario de operación normal |
| Respuesta | Failover automático a AZ us-east-1b |
| Medida | Downtime ≤ 30 segundos; sin pérdida de transacciones |

**Escenario de Mantenibilidad:**

| Parte | Valor |
|---|---|
| Fuente | Desarrollador nuevo |
| Estímulo | Tarea: "agregar nueva pasarela de pago" |
| Artefacto | Módulo de pagos |
| Entorno | Desarrollo normal |
| Respuesta | Implementa usando interfaz existente |
| Medida | Sin tocar código existente; completado en < 1 día |

#### 3. Tácticas por atributo

**Disponibilidad:** Redundancia activa, heartbeat, retry con backoff, circuit breaker, rollback.

**Rendimiento:** Cache (Redis, CDN), procesamiento asíncrono, load balancing, connection pooling, indexing.

**Seguridad:** OAuth 2.0 + JWT, RBAC/ABAC, TLS, input validation, rate limiting.

**Mantenibilidad:** Arquitectura en capas, dependency injection, interfaces, Strangler Fig.

#### 4. Trade-offs entre atributos

| Mejoras en | Costo en |
|---|---|
| Disponibilidad (replicación) | Consistencia (eventual consistency) |
| Rendimiento (cache) | Consistencia (datos stale) |
| Seguridad (encriptación) | Rendimiento (overhead CPU) |
| Flexibilidad (microservicios) | Complejidad operacional |
| Consistencia (ACID) | Disponibilidad (Teorema CAP) |

---

### Ejemplos prácticos (40 minutos)

**Ejemplo: Sistema de telemedicina — 3 escenarios**

**Escenario 1 (Disponibilidad):**
App de videoconsulta. Si servidor de video cae a mitad de consulta → failover automático → ≤ 5 segundos de interrupción.

**Escenario 2 (Seguridad):**
Atacante intenta acceder a historia clínica. Sistema rechaza → registra en audit log → 100% accesos no autorizados rechazados.

**Escenario 3 (Mantenibilidad):**
Regulación nueva requiere guardar consentimiento por videoconsulta → módulo nuevo sin modificar módulo de video → < 1 sprint.

**Trade-off:** Seguridad alta (encriptar video en tiempo real) vs. Rendimiento (overhead). Decisión: TLS en tránsito + encriptación en reposo. Aceptar overhead TLS (~5% CPU).

---

### Actividades prácticas (25 minutos)

**Actividad 1: Escribir escenarios (12 min)**

App de delivery. 4 escenarios (rendimiento, disponibilidad, seguridad, mantenibilidad). 6 partes cada uno.

**Actividad 2: Identificar trade-offs (13 min)**

5 atributos priorizados. Para cada par relevante: ¿existe trade-off? ¿Cómo resolverlo arquitectónicamente?

---

## Clase 04: Estilos, patrones y tácticas arquitectónicas

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 2

### Objetivos de aprendizaje

- Identificar y comparar estilos arquitectónicos principales.
- Seleccionar estilo basándose en drivers específicos.
- Aplicar tácticas para satisfacer atributos de calidad.
- Evaluar trade-offs de la elección de estilo.

---

### Contenido teórico (45 minutos)

#### 1. Estilos arquitectónicos

**Layered (Capas):**

```
  ┌─────────────────────────┐
  │   Presentación (UI)     │
  ├─────────────────────────┤
  │   Aplicación            │
  ├─────────────────────────┤
  │   Dominio / Negocio     │
  ├─────────────────────────┤
  │   Infraestructura       │
  └─────────────────────────┘
```

Regla: Cada capa solo comunica con la inmediatamente inferior.

Ventajas: Separación de concerns, fácil de entender.
Desventajas: Cambios traversales costosos, rendimiento (múltiples capas).
Cuándo: Aplicaciones empresariales tradicionales.

---

**Hexagonal (Ports & Adapters):**

```
             ┌──────────────────┐
REST API →  Port│                  │Port → PostgreSQL
CLI      →  Port│   Core Domain    │Port → MongoDB
Queue    →  Port│                  │Port → Email
             └──────────────────┘
```

El dominio no conoce la infraestructura. Dependencias apuntan hacia adentro.

Ventajas: Testeable sin infraestructura. Fácil cambio de BD o canal.
Desventajas: Más código inicial (adapters, ports).
Cuándo: Sistemas con lógica de dominio compleja que debe mantenerse limpia.

---

**Microservicios:**

```
  API Gateway
  ┌──────────────────────────────────────────┐
  │  User     Order     Payment  Notification│
  │  Service  Service   Service  Service     │
  │  (DB1)    (DB2)     (DB3)    (DB4)       │
  └──────────────────────────────────────────┘
```

Cada servicio: pequeño, dueño de su BD, desplegable independientemente.

Ventajas: Escalabilidad independiente. Despliegue independiente. Aislamiento de fallos.
Desventajas: Complejidad operacional alta. Latencia de red. Transacciones distribuidas.
Cuándo: Alta frecuencia de deploy, equipos grandes, escala variable por servicio.

---

**Event-Driven:**

```
  Producer → Event Bus → Consumer 1
                       → Consumer 2
                       → Consumer 3
```

Variantes: Event Notification, Event-Carried State Transfer, Event Sourcing, CQRS.

Ventajas: Desacoplamiento. Escalabilidad. Auditabilidad (event sourcing).
Desventajas: Complejidad de debugging. Eventual consistency. Orden de eventos.
Cuándo: Múltiples consumidores, auditabilidad requerida, flujos asíncronos.

---

**Serverless:**

```
  Trigger (HTTP/Timer/Queue) → Function → Resultado
```

Ventajas: Costo por ejecución. Sin gestión de servidores. Auto-escalado.
Desventajas: Cold start. Estado efímero. Debug difícil. Lock-in.
Cuándo: Cargas de trabajo intermitentes, procesamiento batch, integraciones.

---

#### 2. Criterios de selección

1. ¿Frecuencia de despliegue? (1/año → monolito. Múltiple/día → microservicios)
2. ¿Tamaño del equipo? (5 personas → monolito. 100+ → microservicios)
3. ¿Complejidad de dominio? (Simple → capas. Complejo → hexagonal)
4. ¿Volatilidad de requisitos? (Estable → capas. Muy cambiante → event-driven)
5. ¿Restricciones operacionales? (Sin Ops team → serverless. Con DevOps → contenedores)

#### 3. Tácticas vs. Patrones

**Patrón:** Solución probada para problema recurrente. Tiene nombre, contexto, problema, solución, consecuencias.

**Táctica:** Decisión de diseño más granular que afecta un atributo de calidad específico.

Ejemplo: Circuit Breaker es un patrón completo. Las tácticas que lo componen son: "detectar fallo" + "aislar componente fallido".

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Netflix — Evolución de estilos**

2007: DVD rental. Monolito Java. Funcionaba.

2008: Streaming lanzado. Un bug baja todo. No pueden escalar solo el módulo de video.

2012-2016: Migración a microservicios. 700+ servicios. Cada equipo (<10 personas) dueño de su servicio. Deploy independiente.

Lecciones: Monolito está bien hasta cierto punto. Microservicios requieren plataforma. La complejidad operacional se desplaza al equipo de plataforma.

---

**Ejemplo 2: Elegir estilo — E-commerce 20 personas**

Contexto: 20 desarrolladores. Escala diferente por módulo. Deploy objetivo: 5/día.

| Criterio | Monolito | Microservicios | Híbrido |
|---|---|---|---|
| Deploy 5/día | Difícil | Ideal | Posible |
| Equipo 20 personas | OK | Ideal (3-4 equipos) | OK (2 equipos) |
| Escala diferenciada | Difícil | Fácil | Parcialmente |
| Complejidad | Baja | Alta | Media |

Decisión: Modular monolito con 2-3 servicios críticos (checkout independiente, catálogo independiente). No microservicios full.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Elegir estilo (12 min)**

3 proyectos con contextos distintos. Elegir estilo + 3 criterios + 2 trade-offs para cada uno.

**Actividad 2: Tabla comparativa (13 min)**

Columnas: 6 atributos de calidad. Filas: 5 estilos. Para cada celda: (+), (-) o (=). Luego: ¿Cuál estilo tiene mejor perfil de calidad global?

---

## Clase 05: Documentación arquitectónica — ISO 42010, 4+1 y C4

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 3

### Objetivos de aprendizaje

- Explicar por qué documentar arquitectura y para qué audiencias.
- Aplicar el estándar ISO/IEC/IEEE 42010.
- Construir las 5 vistas del modelo 4+1 (Kruchten).
- Dibujar los 4 niveles del modelo C4 (Simon Brown).

---

### Contenido teórico (45 minutos)

#### 1. Por qué documentar

**Sin documentación:**
- "¿Por qué usamos esta BD? Nadie sabe."
- "¿Cómo se conecta servicio A con B? El senior ya se fue."

**Audiencias y necesidades:**

| Audiencia | Qué necesita |
|---|---|
| Desarrolladores | Cómo implementar dentro de la estructura |
| Arquitecto nuevo | Entender decisiones previas |
| Ops/SRE | Cómo desplegar, qué monitorear |
| PM/Stakeholder | Módulos existentes, interacciones |
| Auditoría | Decisiones tomadas y justificaciones |

**Principio:** Documentación mínima pero suficiente.

#### 2. ISO/IEC/IEEE 42010

**Conceptos clave:**
- **Concern:** Interés de un stakeholder. Ej: "¿Puede manejar picos de Black Friday?"
- **Viewpoint:** Perspectiva para abordar un concern.
- **View:** Representación del sistema desde un viewpoint.

Principio: Cada view responde concerns de una audiencia específica.

#### 3. Modelo 4+1 (Philippe Kruchten, 1995)

**Vista Lógica:** ¿Qué módulos existen? → Desarrolladores, arquitectos. Notación: Clases/paquetes UML.

**Vista de Proceso:** ¿Cómo se comporta en tiempo de ejecución? → Arquitectos, SRE. Notación: Actividad/secuencia UML.

**Vista de Desarrollo:** ¿Cómo está organizado el código fuente? → Desarrolladores. Notación: Componentes UML.

**Vista Física:** ¿Dónde corre el software? → Ops, DevOps. Notación: Despliegue UML.

**Vista de Escenarios (+1):** Casos de uso que validan las otras 4 vistas. → Todos.

#### 4. Modelo C4 (Simon Brown)

4 niveles de abstracción, como zoom en un mapa:

**Nivel 1 — Contexto:** ¿Qué sistema es y cómo se relaciona con el mundo?

```
[Usuario] → [Sistema de Crédito] → [Bureau de Crédito]
            [Admin]    ↑           [Banco]
```

**Nivel 2 — Contenedores:** ¿Qué aplicaciones y almacenes de datos componen el sistema?

```
[Mobile App] -HTTPS→ [API Gateway] → [Scoring Service]
                                   → [User Service]
                                   → [PostgreSQL DB]
                                   → [Redis Cache]
```

**Nivel 3 — Componentes:** ¿Qué componentes hay dentro de un contenedor?

```
Scoring Service:
[ScoreController] → [ScoreUseCase] → [ModelAdapter]
                                   → [BureauAdapter]
                                   → [ScoreRepository]
```

**Nivel 4 — Código:** Clases, interfaces, funciones. Generalmente auto-generado.

---

### Ejemplos prácticos (40 minutos)

**Ejemplo: C4 completo para sistema de pagos P2P**

Nivel 1 (Contexto): Cliente, Comercio, Banco emisor, Red Visa/MC, Antifraude externo, Payment Platform.

Nivel 2 (Contenedores): Mobile App → API Gateway (Kong) → Payment Service, Merchant Service, Notification Service → PostgreSQL, MongoDB, SQS → Lambda.

Nivel 3 (Componentes de Payment Service): PaymentController → AuthorizationUseCase → FraudCheckPort, CardValidationPort, BankAuthPort, TransactionRepository. Cada Port con su Adapter.

---

### Actividades prácticas (25 minutos)

**Actividad 1: C4 Niveles 1 y 2 (15 min)**

Sistema de telemedicina. Dibujar Nivel 1 (contexto) y Nivel 2 (contenedores).

**Actividad 2: C4 vs 4+1 (10 min)**

¿Cuándo usarías C4? ¿4+1? ¿Hay información en 4+1 que C4 no cubre? ¿Cuál recomendarías a un equipo ágil de 8 personas?

---

## Clase 06: ADR, arquitectura como código e IA como revisora

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 3

### Objetivos de aprendizaje

- Escribir ADR (Architecture Decision Records) bien formados.
- Implementar arquitectura como código (Structurizr DSL).
- Usar IA para detectar ambigüedades y verificar completitud.
- Entender limitaciones de IA como revisora técnica.

---

### Contenido teórico (45 minutos)

#### 1. ADR — Architecture Decision Records

**Problema que resuelve:** "¿Por qué lo hicimos así?" → Nadie sabe.

**Formato MADR:**

```markdown
# ADR-0001: Usar PostgreSQL como base de datos principal

## Estado
Aceptado

## Contexto
El sistema necesita almacenar transacciones financieras con consistencia ACID.
Las consultas son relacionales. El equipo tiene experiencia en SQL.

## Decisión
Utilizaremos PostgreSQL 15 como base de datos principal.

## Consecuencias

### Positivas
- ACID compliance nativo.
- Costo: Open source.
- Ecosistema maduro.

### Negativas
- Escalado horizontal complejo vs. NoSQL.
- Requiere gestión de migrations.

## Alternativas consideradas
- MySQL 8.0: Descartado. PostgreSQL tiene mejor soporte JSON y extensiones.
- MongoDB: Descartado. Modelo de datos relacional; no necesitamos schema flexible.
- DynamoDB: Descartado. Lock-in a AWS; costos impredecibles a escala.

## Referencias
- Driver: Consistencia financiera (ACID requerido por regulador).
```

**Cuándo crear ADR:** Decisión difícil de revertir, afecta múltiples equipos, hubo debate real.

**Cuándo NO:** Decisión trivial, decisión implícita en el estilo elegido.

**Ubicación:** `/docs/adr/` en el repositorio. Versionado con el código.

#### 2. Arquitectura como código — Structurizr DSL

```
workspace {
  model {
    user = person "Cliente"
    creditSystem = softwareSystem "Sistema de Crédito" {
      mobileApp = container "App Móvil" "React Native"
      apiGateway = container "API Gateway" "Kong"
      scoringService = container "Scoring Service" "Python FastAPI"
      db = container "PostgreSQL" "Database" "Database"
    }
    bureau = softwareSystem "Bureau de Crédito"

    user -> mobileApp "Solicita crédito"
    mobileApp -> apiGateway "HTTPS/REST"
    apiGateway -> scoringService "REST"
    scoringService -> db "SQL"
    scoringService -> bureau "REST API"
  }
  views {
    systemContext creditSystem "Context" { include * }
    container creditSystem "Containers" { include * }
  }
}
```

**Ventajas:** Versionado, revisable en PR, siempre actualizado, múltiples renders.

#### 3. IA como revisora arquitectónica

**Casos de uso válidos:**
1. Detectar ambigüedades: "Este ADR dice 'el sistema debe ser seguro'. ¿Qué significa?"
2. Verificar completitud: "¿El documento menciona cómo manejar fallos?"
3. Inconsistencias entre documentos: "ADR-003 dice REST, pero C4 muestra gRPC."
4. Generar preguntas de revisión: "¿Qué pasa si la BD falla? ¿Hay rollback?"

**Limitaciones importantes:**
- No valida contra el contexto real de negocio.
- Puede aceptar inconsistencias lógicas que no detecta.
- Puede ser demasiado generosa ("esto parece bien").
- **Validación humana es obligatoria.**

**Flujo correcto:**
1. Arquitecto escribe ADR.
2. IA revisa (ambigüedades, completitud).
3. Arquitecto evalúa sugerencias.
4. Arquitecto decide qué incorporar.
5. Peer review humano.
6. ADR aprobado.

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: ADR completo — Protocolo de comunicación**

```markdown
# ADR-0005: gRPC para comunicación entre microservicios internos

## Estado: Aceptado

## Contexto
8 microservicios se comunican frecuentemente. REST JSON: P95=15ms entre servicios.
Scoring requiere llamar 3 servicios secuencialmente (45ms total).

## Decisión
gRPC para comunicación interna. REST/JSON solo para APIs externas.

## Consecuencias
Positivas: ~30% más rápido. Contrato fuerte con .proto. Streaming disponible.
Negativas: Curva de aprendizaje de protobuf. Debug más difícil. Menos herramientas.

## Alternativas
- REST JSON: Descartado. Latencia bloquea SLO.
- GraphQL: Descartado. Optimizado para frontend, no backend-to-backend.
```

---

**Ejemplo 2: IA detecta ambigüedades**

Documentación con problemas: "El sistema procesará transacciones rápidamente y será altamente disponible."

IA señala:
1. "Rápidamente" → Sin métrica. ¿P95 < 100ms? ¿P99 < 1s?
2. "Altamente disponible" → ¿Cuánto? ¿99.9%? ¿99.99%?

Arquitecto evalúa: Ambas observaciones válidas. Corrige.

Validación humana agrega: "IA no detectó que 'alta disponibilidad' puede ser incompatible con el presupuesto descrito. Necesitamos resolver este trade-off."

---

### Actividades prácticas (25 minutos)

**Actividad 1: Escribir ADR (15 min)**

Decisión: Elegir entre MongoDB y PostgreSQL para catálogo de productos con atributos variables. Escribe ADR completo con formato MADR.

**Actividad 2: Revisar documentación con IA (10 min)**

Texto arquitectónico con 4-5 ambigüedades intencionales. Identificarlas. Luego: ¿Qué validación humana es necesaria que IA no puede hacer?

---

# UNIDAD 2. Diseño orientado por atributos y arquitecturas cloud-native

---

## Clase 07: Attribute-Driven Design (ADD)

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 4

### Objetivos de aprendizaje

- Aplicar los 8 pasos del método ADD.
- Descomponer el sistema en estructuras partiendo de drivers.
- Asignar funcionalidad a elementos arquitectónicos.
- Producir design rationale documentado con ADRs.

---

### Contenido teórico (45 minutos)

#### 1. Método ADD (Attribute-Driven Design)

**Problema:** Equipos diseñan sin considerar sistemáticamente los atributos de calidad. ADD convierte drivers en decisiones estructurales.

**8 pasos de ADD:**

**Paso 1:** Revisar entradas (propósito, drivers, criterios).
**Paso 2:** Establecer objetivo de la iteración (qué drivers aborda esta iteración).
**Paso 3:** Elegir elemento(s) a refinar (iteración 1: sistema completo; siguientes: componentes).
**Paso 4:** Elegir conceptos de diseño (estilos, patrones, tácticas).
**Paso 5:** Instanciar elementos y asignar responsabilidades.
**Paso 6:** Describir instancias y asignar interfaces.
**Paso 7:** Analizar la decisión (¿satisface los drivers? trade-offs?).
**Paso 8:** Revisar e iterar (¿hay drivers no abordados?).

#### 2. ADD es iterativo

```
Iteración 1: Estructura global
  Drivers: Disponibilidad 99.9%, Escalabilidad 1M usuarios
  Resultado: 3 servicios independientes (escala diferente)

Iteración 2: Módulo de scoring
  Drivers: Rendimiento < 2s, Mantenibilidad (actualizar modelo ML sin deploy)
  Resultado: Hexagonal architecture + model registry externo

Iteración 3: Integración con bureau externo
  Drivers: Disponibilidad (bureau puede fallar), Seguridad
  Resultado: Circuit breaker + cache + retry con backoff
```

---

### Ejemplos prácticos (40 minutos)

**Ejemplo: ADD completo para plataforma de crédito**

**Drivers:** Rendimiento score < 2s, Disponibilidad 99.9%, Escalabilidad 1M usuarios, Mantenibilidad equipo 5 personas, Restricción AWS + Python.

**Iteración 1 — Estructura global:**

Conceptos elegidos: 3 servicios separados, API Gateway, CDN assets.

```
Mobile App → API Gateway (Kong) → Scoring Service (AutoScaling)
                                → User Service (fijo)
                                → Notification Service (Lambda)
                                PostgreSQL (RDS Multi-AZ)
                                Redis (ElastiCache, cache scores)
```

Rationale: Scoring separado porque escala independiente. Notification en Lambda porque es esporádica. RDS Multi-AZ para disponibilidad 99.9%.

Trade-off aceptado: 3 servicios = más complejidad operacional para equipo de 5. Mitigación: CI/CD automatizado.

**Iteración 2 — Dentro de Scoring Service:**

Drivers: Rendimiento < 2s, Mantenibilidad (actualizar modelo ML sin deploy).

Conceptos: Hexagonal architecture, Model registry (S3), Cache bureau responses (Redis).

Resultado: Core → ScoreUseCase. Adapters: BureauAdapter, ModelAdapter, CacheAdapter.

---

### Actividades prácticas (25 minutos)

**Actividad 1: ADD Iteración 1 (12 min)**

Brief dado con drivers priorizados. Aplicar pasos 1-5 de ADD. Producir estructura de contenedores (C4 nivel 2).

**Actividad 2: ADD Iteración 2 (13 min)**

Tomar un contenedor del resultado anterior. ADD para su interior. Producir componentes (C4 nivel 3) y rationale documentado.

---

## Clase 08: Árbol de utilidad, sensitivity points y ATAM simplificado

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 4

### Objetivos de aprendizaje

- Construir árbol de utilidad con priorización (H/M/L).
- Identificar sensitivity points y trade-off points en una arquitectura.
- Aplicar ATAM simplificado para evaluar arquitectura candidata.
- Producir lista de riesgos, puntos sensibles y no-riesgos.

---

### Contenido teórico (45 minutos)

#### 1. Árbol de utilidad

**Objetivo:** Organizar y priorizar atributos de calidad y sus escenarios.

```
Utilidad
├── Rendimiento
│   ├── Latencia de score (H, H)          ← [Importancia negocio, Riesgo técnico]
│   └── Throughput de transacciones (M, L)
├── Disponibilidad
│   ├── Failover automático (H, M)
│   └── Recovery sin pérdida datos (H, H)
├── Seguridad
│   ├── Confidencialidad datos crédito (H, L)
│   └── Autenticación 2FA (M, L)
└── Mantenibilidad
    ├── Actualizar modelo ML sin deploy (H, M)
    └── Onboarding dev nuevo < 4h (L, L)
```

Priorización: Primero los de (H, H). Son críticos y difíciles.

#### 2. Sensitivity Points

Componente o decisión cuyo cambio tiene impacto significativo en un atributo de calidad.

**Ejemplos:**
- Rendimiento: "La llamada síncrona al bureau es el cuello de botella. Si tarda 1.5s, nunca cumplimos SLO de 2s."
- Disponibilidad: "El API Gateway es SPOF. Si cae, toda la plataforma cae."
- Seguridad: "El JWT secret compartido. Si se compromete, todos los tokens son vulnerables."

#### 3. Trade-off Points

Decisión que afecta positivamente a un atributo y negativamente a otro.

| Trade-off | Ganancia | Costo |
|---|---|---|
| Replicar BD en 3 AZ | Disponibilidad | Costo + latencia de replicación |
| Cache de scores del bureau | Rendimiento | Consistencia (score puede estar desactualizado) |
| Encriptación end-to-end | Seguridad | CPU overhead ~5%, latencia |
| 3 Microservicios | Escalabilidad independiente | Complejidad operacional |

#### 4. ATAM simplificado

**Pasos:**
1. Presentar la arquitectura (C4 niveles 1 y 2).
2. Presentar los drivers (árbol de utilidad, top 5-10 escenarios).
3. Analizar escenarios: ¿La arquitectura puede satisfacerlos? ¿Cómo?
4. Identificar sensitivity points y trade-off points.
5. Documentar riesgos y no-riesgos.

**Output:** Documento de evaluación + ADRs + lista de riesgos.

---

### Ejemplos prácticos (40 minutos)

**Ejemplo: ATAM simplificado para sistema de crédito**

Arquitectura propuesta: Mobile App → API Gateway → Scoring (3 réplicas) + User (1 réplica) + Notification (Lambda). PostgreSQL RDS Multi-AZ. Redis ElastiCache. Bureau externo SLA 98%.

**Análisis escenario: Score < 2s (H,H):**

Cómo satisface: Redis cache scores previos < 5ms. Sin cache: ML ~500ms + Bureau ~1s = 1.5-1.8s.

Sensitivity point: Bureau DataCrédito. Si latencia sube a 1.5s, violamos SLO.

Trade-off: Score cacheado (< 5ms, puede estar desactualizado) vs. score fresco (1-1.5s, siempre actual).

Riesgo: Sin fallback documentado si bureau no responde. Acción: ADR sobre estrategia de fallback.

**Análisis escenario: Failover sin pérdida datos (H,H):**

RDS Multi-AZ: Failover automático 60-120s. Durante ese tiempo, transacciones que inician fallan.

Sensitivity point: RDS failover tarda 60-120s. No-riesgo: Scoring Service (3 réplicas) bien cubierto.

Trade-off: RDS Multi-AZ cuesta 2x. Aceptado por driver de disponibilidad 99.9%.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Árbol de utilidad (12 min)**

8 atributos de calidad dados. Construir árbol con puntuación (H/M/L, H/M/L). Identificar top 3.

**Actividad 2: ATAM simplificado (13 min)**

Arquitectura propuesta (C4 nivel 2) + 3 escenarios top. Para cada uno: ¿La arquitectura los satisface? Identificar 1 sensitivity point, 1 trade-off, 1 riesgo.

---

## Clase 09: Principios cloud-native y Twelve-Factor App

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 5

### Objetivos de aprendizaje

- Explicar los 6 principios cloud-native.
- Aplicar los 12 factores de Twelve-Factor App a una aplicación real.
- Identificar violaciones de factores en código existente.
- Transformar una aplicación legacy en una app 12-factor.

---

### Contenido teórico (45 minutos)

#### 1. Principios cloud-native (CNCF)

1. **Microservicios:** Aplicaciones descompuestas en servicios pequeños e independientes.
2. **Contenedores:** Empaquetado consistente. "Build once, run anywhere."
3. **Orquestación dinámica:** Kubernetes gestiona despliegue, escalado, recuperación.
4. **APIs:** Comunicación via APIs versionadas (REST, gRPC, eventos).
5. **DevOps & CI/CD:** Automatización de build, test, deploy.
6. **Immutable infrastructure:** No se modifica en producción; se reemplaza.

#### 2. The Twelve-Factor App (Heroku, 2012)

**Factor 1 — Codebase:** Un repo, múltiples deploys. No copiar-pegar código entre apps.

**Factor 2 — Dependencies:** Declarar y aislar. `package.json`, `requirements.txt`.

**Factor 3 — Config:** Config en el entorno, no en el código.
```python
# MALO:  DB_URL = "postgresql://user:pass@prod-db:5432/mydb"
# BUENO: DB_URL = os.environ["DATABASE_URL"]
```

**Factor 4 — Backing services:** Tratar servicios de respaldo como recursos adjuntos. Cambiar de BD local a RDS = solo cambiar variable de entorno.

**Factor 5 — Build, release, run:** Separar etapas. Build (compilar), Release (build + config), Run (ejecutar release).

**Factor 6 — Processes:** Ejecutar app como proceso(s) sin estado. Estado en backing services.

**Factor 7 — Port binding:** App auto-contenida. Expone un puerto. No requiere servidor externo.

**Factor 8 — Concurrency:** Escalar via modelo de proceso. Workers para background jobs.

**Factor 9 — Disposability:** Startup rápido (< 5 segundos). Apagado graceful al recibir SIGTERM.

**Factor 10 — Dev/prod parity:** Misma BD en dev y prod. Reducir gaps de tiempo y herramientas.

**Factor 11 — Logs:** App escribe a stdout. La plataforma captura y enruta. Sin archivos de log en la app.

**Factor 12 — Admin processes:** Tareas administrativas (migrations) como procesos de un solo uso con la misma release.

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Auditar app legacy**

App Python Flask. Problemas encontrados:

```python
# Factor 3 VIOLADO (crítico):
DB_URL = "postgresql://admin:secret123@192.168.1.100/prod_db"
API_KEY = "sk-live-abc123"

# Factor 6 VIOLADO (crítico):
sessions = {}  # Estado en memoria del proceso

# Factor 11 VIOLADO (medio):
with open('/var/log/app.log', 'a') as f:
    f.write(f"health check at {datetime.now()}\n")
```

Corrección:
```python
import os, logging

DB_URL = os.environ["DATABASE_URL"]
API_KEY = os.environ["API_KEY"]

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

# Estado en Redis, no en memoria
import redis
r = redis.Redis(host=os.environ["REDIS_HOST"])
```

---

**Ejemplo 2: Dockerfile 12-factor**

```dockerfile
FROM python:3.11 AS builder
WORKDIR /app
COPY requirements.txt .
RUN pip install --user --no-cache-dir -r requirements.txt

FROM python:3.11-slim AS runtime
WORKDIR /app
COPY --from=builder /root/.local /root/.local
COPY src/ ./src/
RUN adduser --disabled-password appuser
USER appuser
ENV PORT=8080
EXPOSE $PORT
HEALTHCHECK --interval=30s CMD curl -f http://localhost:8080/health || exit 1
CMD ["uvicorn", "src.main:app", "--host", "0.0.0.0", "--port", "8080"]
```

---

### Actividades prácticas (25 minutos)

**Actividad 1: Auditoría 12 factores (12 min)**

Código legacy dado. Identificar violaciones. Priorizar por severidad.

**Actividad 2: Refactorizar (13 min)**

Tomar la violación más grave. Reescribir el fragmento para cumplir el factor correspondiente.

---

## Clase 10: Docker y Docker Compose en arquitecturas reales

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 5

### Objetivos de aprendizaje

- Escribir Dockerfiles multi-stage optimizados y seguros.
- Gestionar configuración y secretos de forma segura.
- Diseñar `docker-compose.yml` para desarrollo local.
- Usar IA para generar Dockerfiles y saber cómo validarlos.

---

### Contenido teórico (45 minutos)

#### 1. Imagen vs. Contenedor

```
Dockerfile -build→ Image (read-only, plantilla) -run→ Container (proceso + filesystem)
```

#### 2. Dockerfile multi-stage (best practices)

**Sin multi-stage:** ~1.2 GB (incluye compiladores, tools).

**Con multi-stage:**

```dockerfile
# Stage 1: Build
FROM python:3.11 AS builder
WORKDIR /app
COPY requirements.txt .
RUN pip install --user --no-cache-dir -r requirements.txt

# Stage 2: Runtime (solo lo necesario)
FROM python:3.11-slim AS runtime
WORKDIR /app
COPY --from=builder /root/.local /root/.local
COPY src/ ./src/

# Seguridad: usuario no-root
RUN adduser --disabled-password --gecos '' appuser
USER appuser

# Healthcheck
HEALTHCHECK --interval=30s --timeout=5s --retries=3 \
  CMD curl -f http://localhost:8080/health || exit 1

ENV PATH=/root/.local/bin:$PATH
EXPOSE 8080
CMD ["uvicorn", "src.main:app", "--host", "0.0.0.0", "--port", "8080"]
```

**Resultado:** ~200 MB en lugar de ~1.2 GB.

#### 3. Configuración y secretos

**Solo desarrollo (.env en .gitignore):**
```yaml
# docker-compose.yml
services:
  scoring:
    env_file: .env
```

**Producción (Docker secrets / K8s secrets):**
```yaml
services:
  scoring:
    secrets:
      - db_password
    environment:
      DB_PASSWORD_FILE: /run/secrets/db_password
secrets:
  db_password:
    external: true
```

**CI/CD (GitHub Actions):**
```yaml
env:
  DATABASE_URL: ${{ secrets.DATABASE_URL }}
```

#### 4. Docker Compose para desarrollo local

```yaml
version: '3.9'
services:
  api:
    build: { context: ., dockerfile: Dockerfile, target: runtime }
    ports: ["8080:8080"]
    environment:
      DATABASE_URL: postgresql://dev:devpass@db:5432/dev_scoring
    depends_on:
      db: { condition: service_healthy }
    volumes:
      - ./src:/app/src  # Hot reload

  db:
    image: postgres:15-alpine
    environment:
      POSTGRES_USER: dev
      POSTGRES_PASSWORD: devpass
      POSTGRES_DB: dev_scoring
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U dev"]
      interval: 5s
      retries: 5
    volumes:
      - db_data:/var/lib/postgresql/data

  cache:
    image: redis:7-alpine

volumes:
  db_data:
```

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Generar Dockerfile con IA y validarlo**

Checklist de validación humana:
- [ ] Imagen base oficial y fija (no `latest`).
- [ ] Multi-stage build correcto.
- [ ] Usuario no-root.
- [ ] Sin secretos hardcodeados.
- [ ] Healthcheck correcto.
- [ ] Orden de capas optimizado (COPY requirements antes que COPY src).

Problemas típicos que IA comete: usar `python:3.11` en lugar de `python:3.11-slim`, omitir healthcheck, no incluir usuario no-root.

---

**Ejemplo 2: Docker Compose multi-servicio**

Sistema de crédito: scoring-service, user-service, PostgreSQL, Redis, Kong.

Problemas comunes: dependencias con `condition: service_healthy`, networking en misma red bridge, gestión de secretos (.env local vs. Docker secrets en producción).

---

### Actividades prácticas (25 minutos)

**Actividad 1: Dockerfile multi-stage (12 min)**

App Node.js + Express. Requiere build (webpack), runtime liviano. Escribir Dockerfile multi-stage. Validar contra checklist.

**Actividad 2: Docker Compose (13 min)**

2 servicios + PostgreSQL + Redis. Escribir `docker-compose.yml` con healthchecks, dependencias y configuración via variables de entorno.

---

## Clase 11: Introducción a Kubernetes y orquestación de contenedores

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 6

### Objetivos de aprendizaje

- Entender la arquitectura de Kubernetes (control plane + worker nodes).
- Escribir manifiestos básicos (Deployment, Service, ConfigMap, Secret).
- Comprender auto-healing y auto-scaling (HPA).
- Distinguir cuándo usar Kubernetes vs. Docker Compose.

---

### Contenido teórico (45 minutos)

#### 1. Por qué Kubernetes

Docker Compose: Ideal para desarrollo local. Un solo host. Sin auto-healing. Sin auto-scaling.

Kubernetes: Múltiples nodos (cluster). Auto-healing. Auto-scaling. Rolling deploys sin downtime. Self-service para equipos.

Cuándo usar K8s: Producción con HA, múltiples servicios con escala diferente, equipo DevOps disponible.

Cuándo NO: App pequeña (< 3 servicios), equipo sin experiencia, serverless más apropiado.

#### 2. Arquitectura de Kubernetes

```
Control Plane:
  API Server   ← punto de entrada
  Scheduler    ← decide en qué nodo va el pod
  etcd         ← base de datos del estado

Worker Nodes:
  kubelet      ← agente en cada nodo
  kube-proxy   ← networking
  Container Runtime (containerd)
```

#### 3. Objetos fundamentales

**Deployment:**
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: scoring-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: scoring
  template:
    metadata:
      labels:
        app: scoring
    spec:
      containers:
        - name: scoring
          image: scoring-service:1.2.0
          ports:
            - containerPort: 8080
          resources:
            requests:
              memory: "256Mi"
              cpu: "250m"
            limits:
              memory: "512Mi"
              cpu: "500m"
          env:
            - name: DATABASE_URL
              valueFrom:
                secretKeyRef:
                  name: scoring-secrets
                  key: database-url
          readinessProbe:
            httpGet:
              path: /health
              port: 8080
            initialDelaySeconds: 5
            periodSeconds: 10
```

**Service (ClusterIP):**
```yaml
apiVersion: v1
kind: Service
metadata:
  name: scoring-service
spec:
  selector:
    app: scoring
  ports:
    - port: 80
      targetPort: 8080
  type: ClusterIP
```

**HorizontalPodAutoscaler:**
```yaml
apiVersion: autoscaling/v2
kind: HorizontalPodAutoscaler
metadata:
  name: scoring-hpa
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: scoring-deployment
  minReplicas: 3
  maxReplicas: 10
  metrics:
    - type: Resource
      resource:
        name: cpu
        target:
          type: Utilization
          averageUtilization: 70
```

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Deploy completo con ConfigMap, Secret, Deployment, Service, HPA**

ConfigMap para config no sensible (LOG_LEVEL, cache TTL). Secret para DATABASE_URL (base64). Deployment con readinessProbe, resource limits, env desde secrets. Service para exposición interna. HPA para escalar 3→10 si CPU > 70%.

---

**Ejemplo 2: Rolling deploy sin downtime**

```bash
# Actualizar imagen a nueva versión
kubectl set image deployment/scoring-deployment scoring=scoring-service:1.3.0

# K8s hace rolling update:
# 1. Crea pod nuevo con v1.3.0
# 2. Espera readinessProbe OK
# 3. Termina 1 pod de v1.2.0. Repite.

# Si algo sale mal, rollback instantáneo:
kubectl rollout undo deployment/scoring-deployment
```

---

### Actividades prácticas (25 minutos)

**Actividad 1: Escribir manifiestos (15 min)**

App Node.js. Escribir: Deployment (2 réplicas), Service, ConfigMap. Resource limits y readinessProbe obligatorios.

**Actividad 2: K8s vs Docker Compose (10 min)**

4 escenarios de proyectos. Para cada uno: ¿K8s o Docker Compose? Justificar.

---

# UNIDAD 3. Integración, resiliencia, capacidad y validación

---

## Clase 12: Comunicación síncrona, asíncrona, API Gateway y colas

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 7

### Objetivos de aprendizaje

- Comparar comunicación síncrona vs. asíncrona con casos de uso concretos.
- Implementar idempotencia en consumidores de colas.
- Diseñar API Gateway como punto de entrada único.
- Elegir herramienta de mensajería según requisitos.

---

### Contenido teórico (45 minutos)

#### 1. Comunicación síncrona

Llamador espera respuesta antes de continuar.

Protocolos: REST/HTTP (estándar), gRPC (binary, más rápido), GraphQL (flexible para frontend).

Cuándo usar: Respuesta inmediata requerida, validación antes de continuar, simple request/response.

Cuándo NO: Operaciones largas (> 2s), destinatario puede no estar disponible, múltiples consumidores.

#### 2. Comunicación asíncrona

Llamador NO espera. Continúa inmediatamente.

Patrones:
- **Punto a punto (Queue):** Mensaje va a UN consumidor.
- **Publicar/Suscribir (Topic):** Mensaje va a TODOS los suscriptores.

Herramientas: RabbitMQ (queues, reliable delivery), Apache Kafka (event streaming, replay), AWS SQS/SNS (cloud managed), Redis Streams (simple, baja latencia).

Cuándo usar: Operaciones lentas, múltiples consumidores, desacoplar producer/consumer, consumer puede estar caído.

#### 3. Idempotencia

Si consumer falla y reintenta, ¿procesa dos veces?

Solución: Operaciones idempotentes (N ejecuciones = mismo resultado que 1).

```python
def process_payment(payment_id, amount):
    if redis.get(f"processed:{payment_id}"):
        return "already_processed"

    result = payment_gateway.charge(amount)
    redis.setex(f"processed:{payment_id}", 86400, "true")
    return result
```

#### 4. API Gateway

Responsabilidades: Autenticación/Autorización, Rate limiting, SSL termination, Load balancing, Request routing, Logging, API versioning.

Herramientas: Kong, AWS API Gateway, Nginx, Envoy.

```
Cliente (Mobile/Web)
    ↓ HTTPS
API Gateway (Kong)
  ├─ Auth: Validar JWT
  ├─ Rate limit: 100 req/seg/user
  ├─ Route: /score/* → Scoring Service
  │         /users/* → User Service
  └─ Log: Cada request
```

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Sync vs Async por operación**

E-commerce — 5 operaciones:

| Operación | Patrón | Razón |
|---|---|---|
| Verificar stock | Sync | Necesita respuesta inmediata |
| Procesar pago | Sync | Usuario espera confirmación |
| Enviar email confirmación | Async | No bloquea al usuario |
| Actualizar índice de búsqueda | Async | No es urgente |
| Generar reporte de ventas | Async | Puede tardar minutos |

**Diseño resultante:**
```
POST /orders
  → [Sync] Verificar stock
  → [Sync] Procesar pago
  → Responder: "Pedido confirmado #12345"
  → [Async] Queue: "send_confirmation_email"
  → [Async] Queue: "update_search_index"
  → [Async] Queue: "update_inventory"
```

---

**Ejemplo 2: Retry con dead-letter queue**

```
Normal Queue → Consumer
  → Si falla: Retry 1 (30s delay)
  → Si falla: Retry 2 (120s delay)
  → Si falla: Retry 3 (600s delay)
  → Si sigue fallando: Dead Letter Queue → Alerta equipo → Revisión manual
```

---

### Actividades prácticas (25 minutos)

**Actividad 1: Clasificar operaciones (12 min)**

Sistema de reservas de vuelos. 8 operaciones. Clasificar: sync, async, o ambas. Justificar.

**Actividad 2: API Gateway config (13 min)**

Sistema con 4 servicios. Diseñar: rate limits, routing rules, autenticación. Dibujar configuración.

---

## Clase 13: IA como componente arquitectónico

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 7

### Objetivos de aprendizaje

- Integrar modelos de inferencia como componentes de servicio.
- Diseñar pipeline RAG (Retrieval-Augmented Generation).
- Implementar guardrails de entrada y salida.
- Definir políticas de human-in-the-loop y fallback.

---

### Contenido teórico (45 minutos)

#### 1. IA predictiva vs. Generativa

**IA predictiva (ML clásico):**
- Determinístico (mismo input → mismo output).
- Scoring crediticio, detección de fraude, recomendaciones.
- Arquitectura: Model Registry → Load → Inferencia → Cache resultado.

**IA generativa (LLM):**
- No determinístico. Genera texto, código, imágenes.
- Chatbots, resumen de documentos, asistentes.
- Arquitectura: LLM API + RAG + guardrails.

#### 2. Embeddings y RAG

**Embeddings:** Representación vectorial de texto. Permite búsqueda semántica.

**RAG (Retrieval-Augmented Generation):**
```
Pregunta del usuario
    ↓
Embedding de la pregunta
    ↓
Vector Search → Documentos relevantes (pgvector, Pinecone)
    ↓
Prompt = "Contexto: [docs] + Pregunta: [user question]"
    ↓
LLM (GPT-4, Claude, Llama)
    ↓
Guardrails validation
    ↓
Respuesta al usuario
```

Ventaja: El LLM responde con información actualizada y específica del dominio.

#### 3. Guardrails

**Input guardrails:** ¿Está dentro del scope? ¿Contiene PII? ¿Es prompt injection?

**Output guardrails:** ¿Formato correcto? ¿Información confidencial? ¿Puntaje de confianza > threshold?

```python
def generate_with_guardrails(user_input):
    if contains_pii(user_input):
        return "No puedo procesar información personal."
    if is_out_of_scope(user_input):
        return "Solo puedo responder sobre servicios de crédito."

    response = llm.generate(build_prompt(user_input))

    if confidence_score(response) < 0.7:
        return escalate_to_human(user_input)

    return response
```

#### 4. Human-in-the-loop y Fallback

**Human-in-the-loop:** IA propone, humano decide para casos de alto impacto.

Ejemplo fintech:
- Score >= 80 + monto < $10M → Auto-aprobación.
- Score 60-79 → Revisión humana (< 4 horas).
- Score < 60 → Auto-rechazo.

**Fallback:**
```python
def get_recommendation(application):
    try:
        score = ml_model.predict(application)
        if score.confidence > 0.8:
            return score
        score = bureau_api.get_score(application.id)
        return score
    except Exception:
        return rules_engine.evaluate(application)  # Fallback determinístico
    finally:
        audit_log.record(application, score)
```

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Arquitectura RAG para atención al cliente bancario**

Documentos en Vector DB: FAQs, políticas de crédito, reglamentos, tarifas.

Pipeline: Usuario → Chatbot UI → [Input guardrail] → Embedding(pregunta) → VectorDB → Top-3 docs → LLM → [Output guardrail] → Respuesta.

Guardrails: Input: No procesar números de cuenta. Output: No revelar información de otros clientes.

Si guardrail falla → Escalada a agente humano.

---

**Ejemplo 2: Human-in-the-loop para scoring crediticio**

```
Solicitud recibida → ML Score: 72/100
    ↓
Política: Score 60-79 → Cola de revisión humana
    ↓
Analista recibe alerta → Revisa en < 4 horas
    ↓
Analista aprueba con condiciones ($3M en lugar de $5M)
    ↓
Notificación automática al cliente
```

---

### Actividades prácticas (25 minutos)

**Actividad 1: Diseñar pipeline RAG (12 min)**

Empresa legal. Asistente que responde preguntas sobre contratos internos. Diseñar pipeline RAG completo con guardrails. Identificar riesgos.

**Actividad 2: Política human-in-the-loop (13 min)**

Sistema médico de diagnóstico asistido. Definir: ¿Cuándo IA sola? ¿Cuándo human-in-the-loop? ¿Cuándo fallback? Justificar con ética y riesgo.

---

## Clase 14: Patrones de resiliencia

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 8

### Objetivos de aprendizaje

- Implementar Timeout, Retry, Circuit Breaker, Bulkhead y Fallback.
- Combinar patrones para construir sistemas resilientes.
- Monitorear el estado de los patrones en producción.
- Analizar el impacto de la ausencia de cada patrón.

---

### Contenido teórico (45 minutos)

#### 1. Timeout

Sin timeout: Llamada nunca responde → servicio bloqueado indefinidamente.

```python
import requests
try:
    response = requests.get(url, timeout=2.0)  # 2 segundos máximo
    return response.json()
except requests.exceptions.Timeout:
    raise TimeoutException("Servicio tardó más de 2s")
```

**Regla:** Timeout siempre. Sin excepción. "Sin timeout" es un bug.

#### 2. Retry con backoff exponencial

```python
def retry_with_backoff(func, max_retries=3, base_delay=0.5):
    for attempt in range(max_retries):
        try:
            return func()
        except TransientException:
            if attempt == max_retries - 1:
                raise
            delay = base_delay * (2 ** attempt) + random.uniform(0, 0.1)
            time.sleep(delay)
            # Intento 0: ~0.5s, Intento 1: ~1.0s, Intento 2: ~2.0s
```

Jitter: Variación aleatoria. Evita thundering herd (miles reintentando simultáneamente).

Cuándo NO reintentar: Errores permanentes (404, 401, 400). Solo errores transitorios (500, timeout).

#### 3. Circuit Breaker

```
CLOSED → [N fallos] → OPEN (no llama) → [timeout] → HALF-OPEN (1 prueba)
          (normal)                                      ↓            ↓
                                                 sigue OPEN   vuelve CLOSED
```

```python
class CircuitBreaker:
    def __init__(self, failure_threshold=5, timeout=60):
        self.state = "CLOSED"
        self.failure_count = 0
        self.failure_threshold = failure_threshold
        self.timeout = timeout
        self.last_failure_time = None

    def call(self, func, *args, **kwargs):
        if self.state == "OPEN":
            if time.time() - self.last_failure_time > self.timeout:
                self.state = "HALF-OPEN"
            else:
                raise CircuitOpenException("Circuit breaker is OPEN")

        try:
            result = func(*args, **kwargs)
            if self.state == "HALF-OPEN":
                self.state = "CLOSED"
                self.failure_count = 0
            return result
        except Exception:
            self.failure_count += 1
            self.last_failure_time = time.time()
            if self.failure_count >= self.failure_threshold:
                self.state = "OPEN"
            raise
```

#### 4. Bulkhead

Sin bulkhead: Un servicio lento consume todos los threads → afecta a todos los demás.

Con bulkhead: Cada servicio tiene su propio pool de threads/conexiones. Fallan independientemente.

```
Thread Pool Bureau (5)
Thread Pool User Service (10)
Thread Pool Payment (5)
→ Si bureau lento, solo su pool se satura. User y Payment siguen funcionando.
```

#### 5. Fallback

```python
def get_recommendations(user_id):
    try:
        return recommendation_service.get(user_id)
    except Exception:
        return cache.get("popular_items_top10")  # Fallback: populares genéricos
```

Tipos: Cache (último valor conocido), Default (valor estático), Degraded (funcionalidad reducida).

---

### Ejemplos prácticos (40 minutos)

**Ejemplo: Combinar todos los patrones**

```python
bureau_circuit_breaker = CircuitBreaker(failure_threshold=5, timeout=30)

def get_bureau_score(client_id):
    def call_bureau():
        return bureau_circuit_breaker.call(
            lambda: requests.get(f"{BUREAU_URL}/score/{client_id}", timeout=2.0).json()
        )

    try:
        return retry_with_backoff(call_bureau, max_retries=3)
    except CircuitOpenException:
        cached = redis.get(f"bureau_score:{client_id}")
        if cached:
            return {"score": int(cached), "source": "cache", "stale": True}
        raise NoBureauScoreAvailable("Sin score disponible")
```

Resiliencia completa: Circuit Breaker → Timeout → Retry → Fallback (cache).

---

**Ejemplo: Monitorear circuit breakers con Prometheus**

```
circuit_breaker_state{service="bureau"} 1  # OPEN=1, CLOSED=0
circuit_breaker_calls_total{service="bureau",result="success"} 1250
circuit_breaker_calls_total{service="bureau",result="failure"} 47
circuit_breaker_calls_total{service="bureau",result="rejected"} 123
```

Alerta: Si state == OPEN por > 5 min → Slack alert.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Implementar circuit breaker (12 min)**

Sistema de pagos que llama Stripe y Paypal. Circuit breaker simple: estados, transiciones, métricas.

**Actividad 2: Estrategia de resiliencia por dependencia (13 min)**

Microservicio que depende de 4 servicios externos. Para cada uno: Timeout (cuánto?), Retry (cuántos? delay?), Circuit Breaker (threshold?), Fallback (qué devolver?).

---

## Clase 15: Estimación de capacidad y topología de despliegue

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 8

### Objetivos de aprendizaje

- Estimar capacidad de infraestructura con supuestos explícitos.
- Diseñar topología de despliegue para alta disponibilidad.
- Calcular costos de infraestructura AWS.
- Eliminar Single Points of Failure (SPOFs).

---

### Contenido teórico (45 minutos)

#### 1. Estimación back-of-the-envelope

**Principio:** Estimar con supuestos explícitos y documentados. Si el supuesto cambia, la estimación cambia.

**Paso 1: Entender el tráfico**

```
DAU = 100,000 usuarios
Acciones/día/usuario = 5
Total requests/día = 500,000
RPS promedio = 500,000 / 86,400 ≈ 6 RPS
Pico (2x) = 12 RPS
Con 20% buffer = 15 RPS
```

**Paso 2: Calcular CPU**

```
Scoring service: 1 request = 0.5 CPU-seconds, 50ms latencia
Para 15 RPS: necesito manejar 15 requests simultáneos
15 requests × 0.5 CPU = 7.5 CPUs
Con 20% overhead: 10 CPUs
Instancias t3.large (2 vCPU): 5 instancias mínimo
```

**Paso 3: Calcular almacenamiento**

```
Cada solicitud = 5 KB
Solicitudes/día = 10,000
Storage/día = 50 MB
Retención = 7 años (regulatorio)
Total = 50 MB × 365 × 7 ≈ 127 GB
```

#### 2. Topología HA (Alta Disponibilidad)

**Principios:** Eliminar SPOFs. Multi-AZ. Servicios stateless (escalan horizontal). Stateful con replicación.

**Topología de referencia AWS:**

```
Internet
    ↓
Route 53 (DNS + health check)
    ↓
Application Load Balancer (multi-AZ)
    ↓
Auto Scaling Group
  ├─ AZ us-east-1a: 2× Scoring Service
  └─ AZ us-east-1b: 2× Scoring Service
    ↓
  RDS PostgreSQL Multi-AZ
  ├─ Primary: us-east-1a
  └─ Standby: us-east-1b (failover automático 60-120s)

  ElastiCache Redis Cluster
  ├─ Primary: us-east-1a
  └─ Replica: us-east-1b
```

Si cae AZ us-east-1a: Load Balancer redirige a 1b. RDS failover automático. Total downtime ~2 min.

#### 3. Costos estimados

| Componente | Costo/mes |
|---|---|
| 4× EC2 t3.large | $240 |
| RDS PostgreSQL Multi-AZ | $180 |
| ElastiCache Redis | $25 |
| ALB | $20 |
| Route 53 | $5 |
| **Total** | **~$470** |

---

### Ejemplos prácticos (40 minutos)

**Ejemplo: Estimación Black Friday**

E-commerce. Normal: 1,000 órdenes/hora. Black Friday pico: 50x.

```
Black Friday: 50,000 órdenes/hora = 13.9 órdenes/seg
Cada orden: 5 API calls = 69.4 RPS

Order service: 1 request = 200ms → 14 CPU cores
Con overhead: 20 cores
EC2 c5.xlarge (4 vCPU): 5 instancias mínimo, 8 para pico

Costo adicional Black Friday (48h):
  3 instancias extra × $0.17/h × 48h = $24 extra
```

---

### Actividades prácticas (25 minutos)

**Actividad 1: Estimación de capacidad (12 min)**

App telemedicina. 10,000 consultas/día. Pico matutino 3x. Calcular: RPS, CPU necesario, instancias, storage (60 días).

**Actividad 2: Topología HA (13 min)**

Diseñar topología HA para sistema anterior. Dibujar diagrama. Identificar componentes HA y eliminar SPOFs.

---

## Clase 16: Pruebas de carga y observabilidad básica

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 9

### Objetivos de aprendizaje

- Diseñar y ejecutar pruebas de carga con k6.
- Interpretar resultados contra SLOs.
- Implementar logs estructurados, métricas Prometheus y trazas OpenTelemetry.
- Construir dashboard de observabilidad básico con Grafana.

---

### Contenido teórico (45 minutos)

#### 1. Tipos de pruebas de rendimiento

- **Load test:** ¿Soporta la carga esperada? Rampar a nivel esperado. Verificar SLOs.
- **Stress test:** ¿Hasta dónde aguanta? ¿Falla graciosamente? Incrementar continuamente.
- **Spike test:** ¿Qué pasa con picos repentinos? Carga normal → 10x → normal.
- **Soak test:** ¿Hay memory leaks? Carga moderada por horas.

#### 2. k6 — Load testing as code

```javascript
import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: [
    { duration: '2m', target: 50 },    // Ramp-up
    { duration: '5m', target: 50 },    // Hold
    { duration: '2m', target: 100 },   // Ramp-up
    { duration: '5m', target: 100 },   // Hold
    { duration: '2m', target: 0 },     // Ramp-down
  ],
  thresholds: {
    'http_req_duration': ['p(95)<2000'],  // P95 < 2s
    'http_req_failed': ['rate<0.01'],     // Error rate < 1%
  },
};

export default function () {
  const res = http.post(
    'https://api.example.com/score',
    JSON.stringify({ client_id: '12345', amount: 5000000 }),
    { headers: { 'Content-Type': 'application/json' } }
  );

  check(res, {
    'status is 200': (r) => r.status === 200,
    'response time < 2s': (r) => r.timings.duration < 2000,
  });

  sleep(1);
}
```

**Interpretar resultados:**
```
http_req_duration............: avg=856ms p(95)=2100ms
http_req_failed..............: 1.50%

Análisis: P95=2100ms viola SLO de 2000ms. Error rate 1.5% viola SLO < 1%.
Acción: Investigar requests lentos via traces. Escalar o optimizar.
```

#### 3. Los tres pilares de observabilidad

**Logs (structured):**
```python
logger.info("score_completed",
            client_id=client_id,
            score=result.score,
            duration_ms=result.duration_ms,
            source=result.source)
```

**Métricas (Prometheus):**
```python
from prometheus_client import Counter, Histogram

SCORE_REQUESTS = Counter('score_requests_total', 'Requests', ['status'])
SCORE_LATENCY = Histogram('score_duration_seconds', 'Latency',
                           buckets=[0.1, 0.5, 1.0, 2.0, 5.0])

@SCORE_LATENCY.time()
def process_score(client_id):
    try:
        result = model.predict(client_id)
        SCORE_REQUESTS.labels(status='success').inc()
        return result
    except Exception:
        SCORE_REQUESTS.labels(status='error').inc()
        raise
```

**Trazas (OpenTelemetry):**
```python
from opentelemetry import trace
tracer = trace.get_tracer(__name__)

def process_score(client_id):
    with tracer.start_as_current_span("process_score") as span:
        span.set_attribute("client_id", client_id)
        with tracer.start_as_current_span("bureau_call"):
            bureau_score = call_bureau(client_id)
        with tracer.start_as_current_span("ml_inference"):
            score = model.predict(bureau_score)
        return score
```

---

### Ejemplos prácticos (40 minutos)

**Ejemplo 1: Interpretar resultados k6 con violaciones**

Resultados dados con P95 = 2100ms (SLO 2000ms). Identificar: ¿Cuál endpoint es el lento? Usar traces para encontrar. Proponer 3 soluciones (cache, escalar, optimizar query).

---

**Ejemplo 2: Dashboard Grafana básico**

4 paneles: Latency P95 (gauge), Error rate % (gauge), RPS (graph), Circuit breaker state (alert).

Alertas: P95 > 1.5s (warning), P95 > 2s (critical), Error rate > 0.5% (warning).

---

### Actividades prácticas (25 minutos)

**Actividad 1: k6 script (12 min)**

API de telemedicina. Endpoint `GET /appointment/availability`. Ramp 0→50 en 3 min, hold 5 min. SLO: P95 < 500ms, error < 0.5%. Escribir el script k6.

**Actividad 2: Análisis de resultados (13 min)**

Resultados de k6 con violaciones dadas. Identificar problema específico (con trace analysis). Proponer 3 soluciones arquitectónicas priorizadas.

---

# UNIDAD 4. Proyecto integrador: grupo de arquitectura

---

## Clase 17: Proyecto — Drivers, escenarios, arquitectura candidata y C4

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 9

### Descripción del proyecto integrador

**Grupos:** 3-4 estudiantes.

**Sistema:** Cada grupo elige sistema de mediana complejidad.

Opciones: Plataforma de pagos P2P, App de salud con telemedicina, Sistema de logística y tracking, Marketplace de servicios profesionales.

**Entregables por clase:**

| Clase | Entregable |
|---|---|
| 17 | Drivers + Árbol de utilidad + C4 Nivel 1 y 2 + ADR inicial |
| 18 | Arquitectura refinada + ADRs + Prototipo contenerizado |
| 19 | Resultados carga + Observabilidad + Análisis de impacto |
| 20 | Defensa técnica individual |

---

### Trabajo en clase (90 minutos)

**Fase 1 — Brief y drivers (30 min):**

Extraer: Restricciones, atributos de calidad, funcionales influyentes, preocupaciones implícitas.

Priorizar con matriz (H/M/L × H/M/L).

**Fase 2 — Escenarios de calidad (30 min):**

Top 5 drivers → 5 escenarios completos (6 partes cada uno).

Árbol de utilidad con puntuación.

**Fase 3 — Arquitectura candidata (30 min):**

ADD Iteración 1:
- Estilo arquitectónico elegido y justificado.
- C4 Nivel 1 (contexto).
- C4 Nivel 2 (contenedores).
- 1 ADR sobre la decisión más importante.

---

### Ejemplo de salida esperada

**Brief:** Plataforma de pagos P2P. 500k usuarios. SLO 99.9%. Regulada SFC. AWS.

**Driver Top 1 (H,H):** Disponibilidad 99.9% en transacciones financieras.

**Escenario 1:**
- Fuente: 5000 usuarios simultáneos. Estímulo: Solicitan transferencia.
- Artefacto: API de pagos. Entorno: Viernes 6 PM (pico).
- Respuesta: Procesa y confirma. Medida: P95 < 3s, 0% errores, 0% pérdida datos.

**C4 Nivel 2:**
```
Mobile App → API Gateway → Payment Service → PostgreSQL (RDS Multi-AZ)
                         → Notification Service → SQS → Lambda
                         → Fraud Service → Redis (cache)
```

**ADR-001:** PostgreSQL para consistencia ACID en transacciones financieras.

---

### Preguntas guía para grupos

1. ¿Cuáles son los 3 escenarios donde el sistema NO puede fallar?
2. ¿Cuál es el bottleneck de rendimiento más probable?
3. ¿Qué pasa si el servicio de pagos externo cae?

---

## Clase 18: Proyecto — Prototipo contenerizado y resiliencia

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 10

### Objetivos

- Construir prototipo arquitectónico contenerizado.
- Implementar al menos 2 patrones de resiliencia.
- Validar que la arquitectura satisface escenarios top.
- Actualizar ADRs con hallazgos de implementación.

---

### Qué es un prototipo arquitectónico

**NO es:** MVP de producto. No necesita UI completa ni todas las features.

**SÍ es:** Demostración que las decisiones arquitectónicas clave funcionan y que los riesgos están mitigados.

**Enfoque:** Implementar la parte más arriesgada técnicamente. Demostrar que los escenarios top se cumplen.

---

### Trabajo en clase (90 minutos)

**Fase 1 — Setup contenerizado (30 min):**

```
proyecto/
├── docker-compose.yml
├── services/
│   ├── payment-service/
│   │   ├── Dockerfile
│   │   └── src/
│   └── fraud-service/
├── load-tests/
│   └── payment_load.js
└── docs/adr/
```

**Fase 2 — Servicio core (30 min):**

Endpoint principal: validar datos, llamar servicio de fraude (con circuit breaker), persistir transacción, emitir evento a cola.

**Fase 3 — Implementar resiliencia (30 min):**

1. Circuit breaker en llamada a fraud service.
2. Retry con backoff en llamada a BD.
3. Fallback si fraude service no disponible.

---

### Checklist de entregable

- [ ] `docker-compose up` levanta todo el sistema.
- [ ] Endpoint principal responde correctamente.
- [ ] Circuit breaker demostrable (matar fraud service, observar estado).
- [ ] ADRs actualizados con hallazgos.
- [ ] Al menos 1 escenario de calidad verificado.

---

## Clase 19: Proyecto — Pruebas de carga, observabilidad y análisis de impacto

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 10

### Trabajo en clase (90 minutos)

**Fase 1 — Prueba de carga (30 min):**

```bash
k6 run --vus 50 --duration 5m load-tests/payment_load.js
```

Documentar: P95 actual vs. SLO target. Error rate actual vs. SLO. Throughput máximo.

**Fase 2 — Observabilidad (30 min):**

Agregar al prototipo:
- Logs estructurados (3 eventos clave: request recibido, procesado, error).
- Métricas Prometheus (requests totales, duración, errors).
- Trace en el endpoint principal.

**Fase 3 — Análisis de impacto de cambio (30 min):**

Escenario: "El equipo de negocio solicita cambiar de PostgreSQL a DynamoDB para reducir costos."

Análisis:
1. ¿Qué ADRs deben re-evaluarse?
2. ¿Qué atributos de calidad se ven afectados?
3. ¿Qué componentes deben cambiar?
4. ¿Cuál es el riesgo más alto?
5. ¿Cuál sería el plan de migración?

Documentar como ADR nuevo: Aceptar o rechazar el cambio con justificación.

---

## Clase 20: Defensa técnica individual y autorreferencia final

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 11

### Estructura de la clase

#### Parte 1: Defensa técnica individual (90 minutos)

Cada estudiante: 12-15 minutos. El instructor elige 3-5 preguntas.

**Preguntas sobre drivers y diseño:**
1. "¿Por qué eligieron ese estilo y no [alternativa]?"
2. "Si el SLO sube de 99.9% a 99.99%, ¿qué cambia en su arquitectura?"
3. "¿Cuál fue el trade-off más difícil que aceptaron?"

**Preguntas sobre resiliencia:**
4. "El bureau de crédito cae 30 minutos. ¿Qué le pasa a su sistema?"
5. "Explica paso a paso qué ocurre cuando el circuit breaker pasa de CLOSED a OPEN."

**Preguntas sobre observabilidad:**
6. "Un cliente reporta que su pago tardó 8 segundos. ¿Cómo lo investigan?"
7. "¿Qué alerta habría disparado ese problema antes de que el cliente lo reportara?"

**Preguntas sobre cambio:**
8. "¿Dónde modificarían la arquitectura si quieren agregar soporte para criptomonedas?"

**Preguntas sobre IA:**
9. "¿Cómo incorporarían detección de fraude con ML sin afectar la latencia del pago?"

---

#### Parte 2: Autorreferencia final (30 minutos)

**Reflexión individual (15 min):**

1. ¿Qué sé ahora que no sabía al inicio del curso? (Conceptos específicos)
2. ¿Cuál fue la decisión arquitectónica más difícil del proyecto?
3. ¿Qué decisión cambiarías con lo aprendido?
4. ¿Qué preguntas me quedan abiertas?
5. ¿Cómo aplicarías esto en tu trabajo real?

**Discusión grupal (15 min):**

- ¿Qué fue más sorprendente del curso?
- ¿Qué herramientas usarán en sus proyectos?
- ¿Qué quieren profundizar después?

---

### Rúbrica de defensa

| Criterio | Insuficiente (0-5) | Regular (6-12) | Bueno (13-18) | Excelente (19-25) |
|---|---|---|---|---|
| **Comprensión de drivers** | No conecta decisiones con drivers | Conexión vaga | Conecta claramente | Conecta y evalúa trade-offs explícitamente |
| **Decisiones arquitectónicas** | No puede justificar | Justificación superficial | Justificación clara | Con alternativas y ADR bien formado |
| **Resiliencia** | No conoce patrones | Conoce nombres | Explica mecanismos | Analiza escenarios de fallo complejos |
| **Análisis de cambio** | No identifica impacto | Identifica parcialmente | Análisis estructurado | Completo con ADR y plan de migración |

---

# Apéndices

## Apéndice A: Plantillas del proyecto

### Plantilla ADR (formato MADR)

```markdown
# ADR-XXXX: [Título de la decisión]

## Estado
[Propuesto | Aceptado | Obsoleto | Reemplazado por ADR-YYYY]

## Contexto
[¿Por qué se tomó esta decisión? ¿Qué drivers la motivaron?]

## Decisión
[¿Qué se decidió exactamente?]

## Consecuencias
### Positivas
- [Beneficio 1]
### Negativas / Trade-offs
- [Costo 1]

## Alternativas consideradas
- [Alternativa A]: [Razón de descarte]

## Referencias
- Driver relacionado: [Driver X]
- Patrón/estándar: [Nombre]
```

### Plantilla de escenario de calidad

```
Atributo de calidad:
Fuente:
Estímulo:
Artefacto:
Entorno:
Respuesta:
Medida:
Táctica arquitectónica que lo satisface:
```

### Checklist Go/No-Go de arquitectura

**Decisiones documentadas:**
- [ ] Estilo arquitectónico justificado (ADR).
- [ ] BD elegida y justificada (ADR).
- [ ] Protocolo de comunicación justificado (ADR).

**Atributos de calidad:**
- [ ] Top 5 escenarios escritos.
- [ ] Árbol de utilidad con priorización.
- [ ] Trade-offs identificados y aceptados.

**Resiliencia:**
- [ ] SPOFs identificados y mitigados.
- [ ] Circuit breaker en dependencias externas críticas.
- [ ] Fallback para dependencias de disponibilidad < 99.9%.

**Observabilidad:**
- [ ] Logs estructurados en camino crítico.
- [ ] Métricas: latencia, errors, tráfico, saturación.
- [ ] Al menos 3 alertas configuradas.

**Validación:**
- [ ] Prueba de carga ejecutada.
- [ ] SLOs verificados.
- [ ] Estimación de capacidad documentada.

---

## Apéndice B: Herramientas del curso

| Categoría | Herramienta | Uso |
|---|---|---|
| Diagramas | Structurizr DSL, draw.io, Mermaid | C4, 4+1 |
| ADR | MADR format, adr-tools CLI | Decisiones |
| Contenedores | Docker, Docker Compose | Desarrollo local |
| Orquestación | Kubernetes, k3d (local) | Producción / Lab |
| API Gateway | Kong, AWS API Gateway | Punto de entrada |
| Mensajería | RabbitMQ, Kafka, Redis Streams | Comunicación async |
| Pruebas de carga | k6, JMeter | Performance testing |
| Observabilidad | Prometheus, Grafana, Jaeger | Métricas / Trazas |
| Resiliencia | Resilience4j, tenacity (Python) | Circuit breakers |
| Seguridad | OWASP ZAP, Snyk | Vulnerabilidades |

---

## Apéndice C: Referencias bibliográficas

### Libros fundamentales

- Bass, Clements, Kazman (2022). *Software Architecture in Practice* (4ª ed.) — El texto canónico.
- Richards, Ford (2020). *Fundamentals of Software Architecture* — Estilos y trade-offs.
- Brown (2018). *Software Architecture for Developers* — Modelo C4.
- Newman (2021). *Building Microservices* (2ª ed.) — Microservicios en profundidad.
- Kleppmann (2017). *Designing Data-Intensive Applications* — Sistemas distribuidos.
- Richardson (2018). *Microservices Patterns* — Patrones específicos.
- Nygard (2018). *Release It!* (2ª ed.) — Patrones de resiliencia.

### Estándares

- ISO/IEC/IEEE 42010:2011 — Descripción de arquitecturas de software.
- ISO/IEC 25010:2023 — Modelo de calidad del software.

### Recursos online

- arc42.org — Plantilla de documentación arquitectónica.
- adr.github.io — ADR templates y ejemplos.
- c4model.com — Modelo C4, herramientas.
- 12factor.net — The Twelve-Factor App.
- martinfowler.com/architecture — Artículos de Martin Fowler.
- sre.google — Prácticas SRE de Google.
- landscape.cncf.io — CNCF tools landscape.

---

**Fin del curso — Arquitectura de Software**

*Última actualización: agosto 2026*  
*Versión: 1.0 (Completo: 20 clases, 40 horas)*  
*Público: Ingenieros de software, arquitectos de soluciones*
