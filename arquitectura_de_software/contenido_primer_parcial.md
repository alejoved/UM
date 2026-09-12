# UNIDAD 1. Fundamentos, drivers y vocabulario arquitectónico

---

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

#### Ejercicio de código — Clase 01: detectar dependencias y erosión (30 minutos)

**Problema:** la arquitectura planeada sigue el flujo `UI → API → Service → Repository → DB`, pero una nueva funcionalidad puede haber creado accesos directos a la base de datos. Construye un script que detecte esa erosión y estime el impacto de cambiar un módulo.

**Paso 1 — Crea `analizar_arquitectura.py`:**

```python
from collections import defaultdict

CAPAS = ["UI", "API", "Service", "Repository", "DB"]
DEPENDENCIAS = [
  ("UI", "API"),
  ("API", "Service"),
  ("Service", "Repository"),
  ("Repository", "DB"),
  ("API", "DB"),  # Erosión: salta Service y Repository.
]


def construir_grafo(dependencias):
  grafo = defaultdict(list)
  for origen, destino in dependencias:
    grafo[origen].append(destino)
  return grafo


def detectar_violaciones(dependencias):
  posicion = {capa: indice for indice, capa in enumerate(CAPAS)}
  return [
    f"{origen} depende directamente de {destino}: salta capas"
    for origen, destino in dependencias
    if posicion[destino] - posicion[origen] > 1
  ]


def dependientes_de(modulo, grafo):
  """Devuelve los módulos que dependen directa o indirectamente de modulo."""
  dependientes = set()
  pendientes = [modulo]
  while pendientes:
    actual = pendientes.pop()
    for origen, destinos in grafo.items():
      if actual in destinos and origen not in dependientes:
        dependientes.add(origen)
        pendientes.append(origen)
  return dependientes


if __name__ == "__main__":
  grafo = construir_grafo(DEPENDENCIAS)
  print("=== Posibles erosiones ===")
  for violacion in detectar_violaciones(DEPENDENCIAS):
    print(f"- {violacion}")

  afectados = dependientes_de("DB", grafo)
  print(f"Módulos afectados si cambia DB: {sorted(afectados)}")
```

**Paso 2 — Ejecuta:**

```bash
python analizar_arquitectura.py
```

Debe aparecer una violación `API → DB` y los módulos afectados deben ser `API`, `Repository`, `Service` y `UI`.

**Paso 3 — Extiende el ejercicio:**

1. Implementa `dependencias_circulares()` para detectar ciclos.
2. Elimina `("API", "DB")` y verifica que desaparezca la erosión.
3. Agrega una vista de despliegue con `LoadBalancer`, `AppServer` y `Database`.
4. Compara el costo de cambiar `DB` y `UI` contando sus módulos dependientes.

**Preguntas de cierre:**

- ¿Por qué `API → DB` aumenta el costo de cambiar la base de datos?
- ¿Qué diferencia hay entre una dependencia válida y una violación arquitectónica?
- ¿Qué información de esta vista no aparece en una vista de despliegue?

---

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

#### Ejercicio de código — Clase 02: clasificador y priorizador de requisitos (30 minutos)

**Problema:** recibe requisitos escritos en lenguaje natural. El script debe clasificar cada uno como ASR o no ASR usando palabras clave, asignar impacto y riesgo, y ordenar los requisitos que necesitan atención arquitectónica.

**Paso 1 — Crea `priorizar_requisitos.py`:**

```python
from dataclasses import dataclass


@dataclass
class Requisito:
  texto: str
  impacto: str
  riesgo: str
  tipo: str = "por analizar"


REQUISITOS = [
  Requisito("Procesar 100000 transacciones por segundo", "alto", "alto"),
  Requisito("Permitir cambiar la foto de perfil", "bajo", "bajo"),
  Requisito("Los datos de salud deben permanecer en Colombia", "alto", "alto"),
  Requisito("Disponibilidad del 99.99%", "alto", "medio"),
  Requisito("Agregar proveedores sin modificar el núcleo", "alto", "medio"),
  Requisito("Enviar un correo de bienvenida", "bajo", "bajo"),
]

PALABRAS_ASR = {
  "disponibilidad", "disponible", "transacciones", "segundo", "segundos",
  "salud", "colombia", "proveedores", "escalar", "seguridad", "auditoría",
}


def es_asr(texto: str) -> bool:
  palabras = set(texto.lower().replace("%", " ").split())
  return bool(palabras & PALABRAS_ASR)


def puntaje(requisito: Requisito) -> int:
  valores = {"alto": 2, "medio": 1, "bajo": 0}
  return valores[requisito.impacto] + valores[requisito.riesgo]


def analizar(requisitos: list[Requisito]) -> list[Requisito]:
  for requisito in requisitos:
    requisito.tipo = "ASR" if es_asr(requisito.texto) else "No ASR"
  return sorted(
    [requisito for requisito in requisitos if requisito.tipo == "ASR"],
    key=puntaje,
    reverse=True,
  )


if __name__ == "__main__":
  print("=== Requisitos que requieren decisión arquitectónica ===")
  for requisito in analizar(REQUISITOS):
    print(
      f"[{puntaje(requisito)} puntos] "
      f"Impacto: {requisito.impacto} | Riesgo: {requisito.riesgo}\n"
      f"  {requisito.texto}"
    )

  print("\n=== Requisitos descartados como ASR ===")
  for requisito in REQUISITOS:
    if requisito.tipo == "No ASR":
      print(f"- {requisito.texto}")
```

**Paso 2 — Ejecuta:**

```bash
python priorizar_requisitos.py
```

Los tres primeros requisitos ASR deben quedar por encima de los demás según la suma de impacto y riesgo.

**Paso 3 — Convierte requisitos vagos en medibles:**

Agrega `hacer_medible(texto)` para transformar estos ejemplos:

| Requisito vago | Resultado esperado |
|---|---|
| El sistema debe ser rápido | El endpoint debe responder en P95 ≤ 500 ms con 200 solicitudes por segundo |
| El sistema debe ser seguro | Debe rechazar el 100% de accesos no autorizados y registrar cada intento |
| El sistema debe escalar | Debe soportar 1 millón de usuarios sin rediseño arquitectónico |

**Paso 4 — Extiende el ejercicio:**

1. Agrega `categoria` con los valores `restricción`, `calidad`, `funcional` o `stakeholder`.
2. Reemplaza las palabras clave por reglas explícitas por categoría.
3. Exporta los tres requisitos prioritarios a `drivers.csv` usando el módulo `csv`.
4. Escribe dos pruebas con `assert`: 100000 transacciones debe ser ASR y el correo de bienvenida no debe ser ASR.

**Preguntas de cierre:**

- ¿Qué falsos positivos o falsos negativos produce la detección por palabras clave?
- ¿Por qué impacto y riesgo deben analizarse por separado?
- ¿Qué información adicional pedirías al stakeholder antes de aceptar un driver como definitivo?

---

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

---

## Clase 05A: Principios SOLID aplicados a pagos de servicios públicos

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 3

### Objetivos de aprendizaje

- Explicar los cinco principios SOLID y reconocer sus señales de incumplimiento.
- Aplicar SOLID a un dominio con `Cliente`, `Cuenta`, `CuentaAhorros`, `CuentaCorriente`, `Factura` y `Pago`.
- Separar reglas de negocio, persistencia, notificaciones y medios de pago mediante interfaces.

### Contenido teórico

SOLID es un conjunto de cinco principios para diseñar clases con responsabilidades claras, extensibles y fáciles de probar.

| Principio | Idea central | Señal de incumplimiento |
|---|---|---|
| **S — Single Responsibility** | Una clase debe tener un motivo principal para cambiar. | Una clase calcula, guarda, imprime y notifica. |
| **O — Open/Closed** | Extensible sin modificar código estable. | Cada nuevo tipo exige editar un `switch` central. |
| **L — Liskov Substitution** | Un subtipo debe poder reemplazar a su tipo base. | Un subtipo lanza `UnsupportedOperationException` para una operación prometida. |
| **I — Interface Segregation** | Interfaces pequeñas y enfocadas. | Clientes dependen de métodos que no usan. |
| **D — Dependency Inversion** | El dominio depende de abstracciones, no de detalles. | Una regla de pago crea directamente un cliente SQL o HTTP. |

#### S — Single Responsibility Principle

Una responsabilidad es una razón de cambio. `Factura` puede conocer su total; no debería enviar correos ni guardar datos. La separación permite probar cada decisión aisladamente.

**Ejemplo 1 — Separación de cálculo y persistencia:**

```java
record Factura(double base, double impuesto) {
  double total() {
    return base + impuesto;
  }
}

final class CalculadorFactura {
  double total(Factura factura) {
    return factura.base() + factura.impuesto();
  }
}

final class FacturaRepository {
  void guardar(Factura factura) {
    // Guardar en base de datos SQL
    System.out.println("Guardando factura: " + factura.total());
  }
}

public class EjemploS1 {
  public static void main(String[] args) {
    Factura f = new Factura(1000, 200);
    CalculadorFactura calc = new CalculadorFactura();
    FacturaRepository repo = new FacturaRepository();
    
    System.out.println("Total: " + calc.total(f));
    repo.guardar(f);
  }
}
```

**Ejemplo 2 — Separación de pago y notificación:**

```java
interface MedioPago {
  void cobrar(double valor);
}

final class PagoService {
  private final MedioPago medio;
  
  PagoService(MedioPago medio) {
    this.medio = medio;
  }
  
  void pagar(double cantidad) {
    this.medio.cobrar(cantidad);
  }
}

final class Notificador {
  void confirmar(double monto) {
    System.out.println("Notificando pago por: $" + monto);
  }
}

final class PagoPSE implements MedioPago {
  @Override
  public void cobrar(double valor) {
    System.out.println("Cobrando por PSE: $" + valor);
  }
}

public class EjemploS2 {
  public static void main(String[] args) {
    PagoService pagos = new PagoService(new PagoPSE());
    Notificador notificador = new Notificador();
    
    pagos.pagar(5000);
    notificador.confirmar(5000);
  }
}
```

**Ejemplo 3 — Reporte de estado de cuenta:**

```java
record Cliente(String id, String nombre) {}

record Cuenta(double saldo) {}

final class EstadoCuentaReport {
  String generar(Cliente cliente, Cuenta cuenta) {
    return cliente.nombre() + ": $" + cuenta.saldo();
  }
}

public class EjemploS3 {
  public static void main(String[] args) {
    Cliente client = new Cliente("C001", "Juan Pérez");
    Cuenta cuenta = new Cuenta(50000);
    EstadoCuentaReport report = new EstadoCuentaReport();
    
    System.out.println(report.generar(client, cuenta));
  }
}
```

#### O — Open/Closed Principle

El sistema debe permitir agregar una variante mediante una nueva implementación, sin reabrir y modificar la regla que ya funciona.

**Ejemplo 1 — Cálculo de intereses por tipo de cuenta:**

```java
interface ReglaInteres {
  double calcular(double saldo);
}

final class InteresAhorros implements ReglaInteres {
  @Override
  public double calcular(double saldo) {
    return saldo * 0.04; // 4% anual
  }
}

final class InteresCorriente implements ReglaInteres {
  @Override
  public double calcular(double saldo) {
    return 0; // Sin intereses
  }
}

final class InteresEmpresarial implements ReglaInteres {
  @Override
  public double calcular(double saldo) {
    return saldo * 0.02; // 2% anual
  }
}

final class CalculadorInteres {
  double calcularMesActual(ReglaInteres regla, double saldo) {
    return regla.calcular(saldo) / 12;
  }
}

public class EjemploO1 {
  public static void main(String[] args) {
    CalculadorInteres calc = new CalculadorInteres();
    
    ReglaInteres ahorros = new InteresAhorros();
    ReglaInteres corriente = new InteresCorriente();
    ReglaInteres empresarial = new InteresEmpresarial();
    
    System.out.println("Interés ahorros: $" + calc.calcularMesActual(ahorros, 10000));
    System.out.println("Interés corriente: $" + calc.calcularMesActual(corriente, 10000));
    System.out.println("Interés empresarial: $" + calc.calcularMesActual(empresarial, 10000));
  }
}
```

**Ejemplo 2 — Medios de pago extensibles:**

```java
interface MedioPago {
  void cobrar(double valor);
}

final class PagoPSE implements MedioPago {
  @Override
  public void cobrar(double valor) {
    System.out.println("Procesando PSE: $" + valor);
  }
}

final class PagoTarjeta implements MedioPago {
  @Override
  public void cobrar(double valor) {
    System.out.println("Procesando Tarjeta: $" + valor);
  }
}

final class PagoBilletera implements MedioPago {
  @Override
  public void cobrar(double valor) {
    System.out.println("Procesando Billetera Digital: $" + valor);
  }
}

final class Procesador {
  void ejecutar(MedioPago medio, double valor) {
    medio.cobrar(valor);
  }
}

public class EjemploO2 {
  public static void main(String[] args) {
    Procesador proc = new Procesador();
    
    proc.ejecutar(new PagoPSE(), 5000);
    proc.ejecutar(new PagoTarjeta(), 3000);
    proc.ejecutar(new PagoBilletera(), 2000);
  }
}
```

**Ejemplo 3 — Sistema de descuentos:**

```java
interface Descuento {
  double aplicar(double total);
}

final class DescuentoAdultoMayor implements Descuento {
  @Override
  public double aplicar(double total) {
    return total * 0.9; // 10% descuento
  }
}

final class DescuentoClienteFrecuente implements Descuento {
  @Override
  public double aplicar(double total) {
    return total * 0.95; // 5% descuento
  }
}

final class DescuentoEstudiantil implements Descuento {
  @Override
  public double aplicar(double total) {
    return total * 0.85; // 15% descuento
  }
}

final class Totalizador {
  double total(double base, Descuento descuento) {
    return descuento.aplicar(base);
  }
}

public class EjemploO3 {
  public static void main(String[] args) {
    Totalizador totalizador = new Totalizador();
    
    System.out.println("Total AdultoMayor: $" + totalizador.total(10000, new DescuentoAdultoMayor()));
    System.out.println("Total Cliente Frecuente: $" + totalizador.total(10000, new DescuentoClienteFrecuente()));
    System.out.println("Total Estudiante: $" + totalizador.total(10000, new DescuentoEstudiantil()));
  }
}
```

#### L — Liskov Substitution Principle

La herencia conserva el contrato: precondiciones no más estrictas, resultados válidos y excepciones compatibles. Si `Cuenta` permite retirar dentro del saldo, una subclase no debe romper esa expectativa.

**Ejemplo 1 — Tipos de cuenta intercambiables:**

```java
abstract class Cuenta {
  protected double saldo;
  
  Cuenta(double saldoInicial) {
    this.saldo = saldoInicial;
  }
  
  double saldo() {
    return saldo;
  }
  
  abstract double calcularInteres();
}

final class CuentaAhorros extends Cuenta {
  CuentaAhorros(double saldoInicial) {
    super(saldoInicial);
  }
  
  @Override
  double calcularInteres() {
    return saldo * 0.04;
  }
}

final class CuentaCorriente extends Cuenta {
  CuentaCorriente(double saldoInicial) {
    super(saldoInicial);
  }
  
  @Override
  double calcularInteres() {
    return 0;
  }
}

final class ConsultaSaldo {
  double consultar(Cuenta cuenta) {
    return cuenta.saldo();
  }
}

public class EjemploL1 {
  public static void main(String[] args) {
    ConsultaSaldo consultor = new ConsultaSaldo();
    
    Cuenta ahorros = new CuentaAhorros(10000);
    Cuenta corriente = new CuentaCorriente(10000);
    
    System.out.println("Saldo Ahorros: $" + consultor.consultar(ahorros));
    System.out.println("Saldo Corriente: $" + consultor.consultar(corriente));
  }
}
```

**Ejemplo 2 — Retiros respetando el contrato:**

```java
interface Retirable {
  boolean retirar(double valor);
}

final class CuentaConSaldo implements Retirable {
  private double saldo = 100;
  
  @Override
  public boolean retirar(double valor) {
    if (valor <= 0) {
      return false;
    }
    if (valor > saldo) {
      return false;
    }
    saldo -= valor;
    return true;
  }
  
  double saldo() {
    return saldo;
  }
}

final class CuentaSobregirada implements Retirable {
  private double saldo = 100;
  private double limite = 500;
  
  @Override
  public boolean retirar(double valor) {
    if (valor <= 0) {
      return false;
    }
    if (valor > saldo + limite) {
      return false;
    }
    saldo -= valor;
    return true;
  }
  
  double saldo() {
    return saldo;
  }
}

public class EjemploL2 {
  public static void main(String[] args) {
    Retirable cuenta1 = new CuentaConSaldo();
    Retirable cuenta2 = new CuentaSobregirada();
    
    System.out.println("Retiro $50: " + cuenta1.retirar(50));
    System.out.println("Retiro $200: " + cuenta2.retirar(200));
  }
}
```

**Ejemplo 3 — Capacidad de pago intercambiable:**

```java
interface CuentaPagadora {
  boolean puedePagar(double valor);
}

final class Ahorros implements CuentaPagadora {
  private double saldo = 5000;
  
  @Override
  public boolean puedePagar(double valor) {
    return valor >= 0 && valor <= saldo;
  }
}

final class Corriente implements CuentaPagadora {
  private double saldo = 3000;
  private double limite = 2000;
  
  @Override
  public boolean puedePagar(double valor) {
    return valor >= 0 && valor <= (saldo + limite);
  }
}

final class ProcesadorPagos {
  boolean procesar(CuentaPagadora cuenta, double monto) {
    return cuenta.puedePagar(monto);
  }
}

public class EjemploL3 {
  public static void main(String[] args) {
    ProcesadorPagos proc = new ProcesadorPagos();
    
    CuentaPagadora ahorros = new Ahorros();
    CuentaPagadora corriente = new Corriente();
    
    System.out.println("Ahorros puede pagar $2000: " + proc.procesar(ahorros, 2000));
    System.out.println("Corriente puede pagar $4500: " + proc.procesar(corriente, 4500));
  }
}
```

#### I — Interface Segregation Principle

Una interfaz debe representar un rol pequeño. Consultar una factura no debería obligar a implementar conciliación, auditoría y notificaciones.

**Ejemplo 1 — Interfaces segregadas de lectura y escritura:**

```java
record Factura(String id, double total) {}

interface FacturaReader {
  Factura buscar(String id);
}

interface FacturaWriter {
  void guardar(Factura factura);
}

final class FacturaRepositorio implements FacturaReader, FacturaWriter {
  private java.util.Map<String, Factura> datos = new java.util.HashMap<>();
  
  @Override
  public Factura buscar(String id) {
    return datos.get(id);
  }
  
  @Override
  public void guardar(Factura factura) {
    datos.put(factura.id(), factura);
  }
}

final class FacturaConsulta implements FacturaReader {
  private final FacturaReader reader;
  
  FacturaConsulta(FacturaReader reader) {
    this.reader = reader;
  }
  
  @Override
  public Factura buscar(String id) {
    return reader.buscar(id);
  }
}

public class EjemploI1 {
  public static void main(String[] args) {
    FacturaRepositorio repo = new FacturaRepositorio();
    Factura f = new Factura("F001", 5000);
    
    repo.guardar(f);
    
    FacturaConsulta consulta = new FacturaConsulta(repo);
    Factura encontrada = consulta.buscar("F001");
    System.out.println("Factura: " + encontrada);
  }
}
```

**Ejemplo 2 — Canales de notificación segregados:**

```java
interface NotificadorEmail {
  void enviar(String destino, String mensaje);
}

interface NotificadorSms {
  void enviarSms(String telefono, String mensaje);
}

final class ClienteEmail implements NotificadorEmail {
  @Override
  public void enviar(String destino, String mensaje) {
    System.out.println("Email a " + destino + ": " + mensaje);
  }
}

final class ClienteSms implements NotificadorSms {
  @Override
  public void enviarSms(String telefono, String mensaje) {
    System.out.println("SMS a " + telefono + ": " + mensaje);
  }
}

final class ConfirmacionPago {
  private final NotificadorEmail email;
  
  ConfirmacionPago(NotificadorEmail email) {
    this.email = email;
  }
  
  void confirmar(String email, double monto) {
    this.email.enviar(email, "Pago de $" + monto + " confirmado");
  }
}

public class EjemploI2 {
  public static void main(String[] args) {
    NotificadorEmail email = new ClienteEmail();
    NotificadorSms sms = new ClienteSms();
    
    ConfirmacionPago conf = new ConfirmacionPago(email);
    conf.confirmar("user@email.com", 5000);
    
    sms.enviarSms("+573001234567", "Pago de $5000 confirmado");
  }
}
```

**Ejemplo 3 — Interfaces específicas por capacidad:**

```java
interface PuedeAhorrar {
  void depositar(double valor);
}

interface PuedeSobregirar {
  double cupoDisponible();
}

interface PuedeConsultar {
  double consultarSaldo();
}

final class CuentaAhorrosService implements PuedeAhorrar, PuedeConsultar {
  private double saldo = 0;
  
  @Override
  public void depositar(double valor) {
    saldo += valor;
    System.out.println("Depositado: $" + valor);
  }
  
  @Override
  public double consultarSaldo() {
    return saldo;
  }
}

final class CuentaCorrienteService implements PuedeAhorrar, PuedeSobregirar, PuedeConsultar {
  private double saldo = 0;
  private final double limite = 500000;
  
  @Override
  public void depositar(double valor) {
    saldo += valor;
    System.out.println("Depositado: $" + valor);
  }
  
  @Override
  public double cupoDisponible() {
    return limite - Math.max(0, -saldo);
  }
  
  @Override
  public double consultarSaldo() {
    return saldo;
  }
}

public class EjemploI3 {
  public static void main(String[] args) {
    PuedeAhorrar ahorros = new CuentaAhorrosService();
    PuedeAhorrar corriente = new CuentaCorrienteService();
    
    ahorros.depositar(10000);
    corriente.depositar(5000);
    
    if (corriente instanceof PuedeSobregirar) {
      System.out.println("Cupo disponible: $" + ((PuedeSobregirar)corriente).cupoDisponible());
    }
  }
}
```