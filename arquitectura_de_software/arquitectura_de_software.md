# Arquitectura de Software — Curso Completo Ampliado (2 horas × 30 clases)

> Material de referencia — Universidad de Manizales  
> Última actualización: agosto 2026 | Versión: 1.0  
> **Duración total: 60 horas** | 30 clases × 2 horas

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

## Mapa de clases recomendado

La secuencia está organizada para que los estudiantes avancen desde fundamentos y vocabulario arquitectónico, luego diseño y evaluación, después plataforma y operación, y finalmente proyecto integrador. Los temas de seguridad, datos, DevOps, gobernanza y modernización se ubican antes del proyecto para que puedan aplicarse en los entregables finales.

| Clase | Título | Unidad |
|---|---|---|
| 01 | Arquitectura como estructuras y decisiones | 1 |
| 02 | Requisitos arquitectónicamente significativos y drivers | 1 |
| 03 | Atributos de calidad y escenarios (ISO/IEC 25010) | 1 |
| 04 | Estilos, patrones y tácticas arquitectónicas | 1 |
| 05A | Principios SOLID aplicados a pagos de servicios públicos | 1 |
| 06A | Patrones de diseño GoF en Java | 1 |
| 07A | Patrones GRASP para asignar responsabilidades | 1 |
| 08A | DRY, KISS y YAGNI aplicados a pagos | 1 |
| 05 | Domain-Driven Design, bounded contexts y monolito modular | 2 |
| 06 | Documentación arquitectónica — ISO 42010, 4+1 y C4 | 2 |
| 07 | ADR, arquitectura como código e IA como revisora | 2 |
| 08 | Attribute-Driven Design (ADD) | 2 |
| 09 | Árbol de utilidad, sensitivity points y ATAM simplificado | 2 |
| 10 | Arquitectura de datos, consistencia distribuida y eventos | 3 |
| 11 | Comunicación síncrona, asíncrona, API Gateway y colas | 3 |
| 12 | Arquitectura de seguridad — threat modeling, Zero Trust y controles | 3 |
| 13 | Principios cloud-native y Twelve-Factor App | 3 |
| 14 | Docker y Docker Compose en arquitecturas reales | 3 |
| 15 | Introducción a Kubernetes y orquestación de contenedores | 3 |
| 16 | DevOps avanzado, CI/CD, GitOps e infraestructura como código | 4 |
| 17 | Patrones de resiliencia: timeout, retry, circuit breaker, bulkhead | 4 |
| 18 | Estimación de capacidad y topología de despliegue | 4 |
| 19 | Pruebas de carga y observabilidad básica | 4 |
| 20 | Gobernanza arquitectónica, fitness functions y evolución | 4 |
| 21 | IA como componente arquitectónico: RAG, guardrails y fallback | 5 |
| 22 | Modernización de sistemas legacy y migración incremental | 5 |
| 23 | Proyecto — Drivers, escenarios, arquitectura candidata y C4 | 6 |
| 24 | Proyecto — Prototipo contenerizado y resiliencia end-to-end | 6 |
| 25 | Proyecto — Pruebas de carga, observabilidad y análisis de impacto | 6 |
| 26 | Defensa técnica individual y autorreferencia final | 6 |

---

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

#### D — Dependency Inversion Principle

Las reglas de pago pertenecen al dominio; PostgreSQL, PSE o correo son detalles reemplazables. La inversión se logra definiendo puertos y pasando implementaciones por constructor.

**Ejemplo 1 — Desacoplamiento de persistencia:**

```java
record Pago(String id, double valor) {}

interface PagoRepository {
  void guardar(Pago pago);
}

final class PagoService {
  private final PagoRepository repository;
  
  PagoService(PagoRepository repository) {
    this.repository = repository;
  }
  
  void registrar(Pago pago) {
    repository.guardar(pago);
  }
}

final class PagoRepositoryPostgres implements PagoRepository {
  @Override
  public void guardar(Pago pago) {
    System.out.println("Guardando en PostgreSQL: " + pago);
  }
}

final class PagoRepositoryMemoria implements PagoRepository {
  private java.util.List<Pago> datos = new java.util.ArrayList<>();
  
  @Override
  public void guardar(Pago pago) {
    datos.add(pago);
    System.out.println("Guardando en memoria: " + pago);
  }
}

public class EjemploD1 {
  public static void main(String[] args) {
    PagoService servicioPostgres = new PagoService(new PagoRepositoryPostgres());
    PagoService servicioMemoria = new PagoService(new PagoRepositoryMemoria());
    
    Pago p = new Pago("P001", 5000);
    servicioPostgres.registrar(p);
    servicioMemoria.registrar(p);
  }
}
```

**Ejemplo 2 — Desacoplamiento de pasarela de pagos:**

```java
record Factura(String id, double total) {}

interface Pasarela {
  String autorizar(double valor);
}

final class PagarFactura {
  private final Pasarela pasarela;
  
  PagarFactura(Pasarela pasarela) {
    this.pasarela = pasarela;
  }
  
  String ejecutar(Factura factura) {
    return pasarela.autorizar(factura.total());
  }
}

final class PasarelaPSE implements Pasarela {
  @Override
  public String autorizar(double valor) {
    return "PSE autorizado: $" + valor;
  }
}

final class PasarelaTarjeta implements Pasarela {
  @Override
  public String autorizar(double valor) {
    return "Tarjeta autorizada: $" + valor;
  }
}

public class EjemploD2 {
  public static void main(String[] args) {
    PagarFactura pagarConPse = new PagarFactura(new PasarelaPSE());
    PagarFactura pagarConTarjeta = new PagarFactura(new PasarelaTarjeta());
    
    Factura f = new Factura("F001", 10000);
    
    System.out.println(pagarConPse.ejecutar(f));
    System.out.println(pagarConTarjeta.ejecutar(f));
  }
}
```

**Ejemplo 3 — Composición de dependencias inyectadas:**

```java
interface PagoRepository {
  void guardar(Pago pago);
}

interface Notificador {
  void notificar(Pago pago);
}

final class PagoProcesado {
  private final PagoRepository repository;
  private final Notificador notificador;
  
  PagoProcesado(PagoRepository repository, Notificador notificador) {
    this.repository = repository;
    this.notificador = notificador;
  }
  
  void procesar(Pago pago) {
    repository.guardar(pago);
    notificador.notificar(pago);
  }
}

final class NotificadorConsola implements Notificador {
  @Override
  public void notificar(Pago pago) {
    System.out.println("Pago procesado: " + pago);
  }
}

final class PagoRepositoryMemoria implements PagoRepository {
  private java.util.List<Pago> datos = new java.util.ArrayList<>();
  
  @Override
  public void guardar(Pago pago) {
    datos.add(pago);
  }
}

public class EjemploD3 {
  public static void main(String[] args) {
    PagoProcesado procesador = new PagoProcesado(
      new PagoRepositoryMemoria(),
      new NotificadorConsola()
    );
    
    Pago p = new Pago("P001", 5000);
    procesador.procesar(p);
  }
}
```

### Actividad: SOLID en el sistema de pagos de servicios públicos

Diseñe una solución para que un `Cliente` consulte sus `Factura`, elija una `Cuenta` de ahorros o corriente, registre un `Pago` y reciba confirmación.

1. Dibuje el modelo con `Cuenta` como abstracción y sus dos variantes.
2. Extraiga interfaces para `FacturaRepository`, `PagoRepository`, `Pasarela` y `Notificador`.
3. Implemente `PagarFactura` con inyección por constructor y sin dependencias de SQL, HTTP o consola.
4. Agregue una nueva pasarela sin modificar el caso de uso.
5. Señale qué clase cambia ante cada cambio: impuesto, base de datos, notificación, tipo de cuenta y medio de pago.
6. Escriba pruebas para pago aprobado, factura ya pagada, saldo insuficiente y pasarela no disponible.

---

## Clase 06A: Patrones de diseño GoF en Java

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 3

### Objetivos de aprendizaje

- Reconocer los 23 patrones del catálogo Gang of Four (GoF).
- Distinguir patrones creacionales, estructurales y de comportamiento.
- Seleccionar un patrón según el problema y sus consecuencias.

### Teoría

Los patrones GoF son soluciones de diseño nombradas para problemas recurrentes. No son bibliotecas ni recetas obligatorias: describen participantes, colaboraciones y consecuencias.

| Familia | Patrones |
|---|---|
| Creacionales | Abstract Factory, Builder, Factory Method, Prototype, Singleton |
| Estructurales | Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy |
| Comportamiento | Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, Visitor |

#### Abstract Factory

Provee familias de objetos relacionados sin acoplar el cliente a clases concretas.

```java
record Boton(String estilo) {}
record Campo(String estilo) {}

interface WidgetFactory {
  Boton boton();
  Campo campo();
}

final class WebFactory implements WidgetFactory {
  @Override
  public Boton boton() {
    return new Boton("web");
  }
  
  @Override
  public Campo campo() {
    return new Campo("web");
  }
}

final class MovilFactory implements WidgetFactory {
  @Override
  public Boton boton() {
    return new Boton("movil");
  }
  
  @Override
  public Campo campo() {
    return new Campo("movil");
  }
}

final class ReporteFactory implements WidgetFactory {
  @Override
  public Boton boton() {
    return new Boton("reporte");
  }
  
  @Override
  public Campo campo() {
    return new Campo("reporte");
  }
}

public class EjemploAbstractFactory {
  public static void main(String[] args) {
    WidgetFactory web = new WebFactory();
    WidgetFactory movil = new MovilFactory();
    WidgetFactory reporte = new ReporteFactory();
    
    System.out.println("Web: " + web.boton() + " | " + web.campo());
    System.out.println("Móvil: " + movil.boton() + " | " + movil.campo());
    System.out.println("Reporte: " + reporte.boton() + " | " + reporte.campo());
  }
}
```

#### Builder

Construye objetos complejos paso a paso y evita constructores con muchos parámetros.

```java
final class SolicitudPago {
  final String factura;
  final String cuenta;
  final boolean notificar;
  
  private SolicitudPago(Builder builder) {
    this.factura = builder.factura;
    this.cuenta = builder.cuenta;
    this.notificar = builder.notificar;
  }
  
  static class Builder {
    String factura;
    String cuenta;
    boolean notificar = false;
    
    Builder factura(String factura) {
      this.factura = factura;
      return this;
    }
    
    Builder cuenta(String cuenta) {
      this.cuenta = cuenta;
      return this;
    }
    
    Builder notificar() {
      this.notificar = true;
      return this;
    }
    
    SolicitudPago build() {
      return new SolicitudPago(this);
    }
  }
  
  @Override
  public String toString() {
    return "SolicitudPago{" + "factura='" + factura + "'" +
           ", cuenta='" + cuenta + "'" +
           ", notificar=" + notificar + "}";
  }
}

public class EjemploBuilder {
  public static void main(String[] args) {
    SolicitudPago solo_factura = new SolicitudPago.Builder()
      .factura("F001")
      .build();
    
    SolicitudPago factura_cuenta = new SolicitudPago.Builder()
      .factura("F001")
      .cuenta("CTA001")
      .build();
    
    SolicitudPago completa = new SolicitudPago.Builder()
      .factura("F001")
      .cuenta("CTA001")
      .notificar()
      .build();
    
    System.out.println(solo_factura);
    System.out.println(factura_cuenta);
    System.out.println(completa);
  }
}
```

#### Factory Method

Delega a subclases la creación del producto que el flujo necesita.

```java
interface Validador {
  boolean valida(String dato);
}

abstract class Servicio {
  abstract Validador crearValidador();
  
  boolean ejecutar(String dato) {
    return crearValidador().valida(dato);
  }
}

final class ServicioFactura extends Servicio {
  @Override
  Validador crearValidador() {
    return dato -> dato.startsWith("FAC-");
  }
}

final class ServicioPago extends Servicio {
  @Override
  Validador crearValidador() {
    return dato -> dato.startsWith("PAG-");
  }
}

final class ServicioCliente extends Servicio {
  @Override
  Validador crearValidador() {
    return dato -> dato.startsWith("CLI-");
  }
}

public class EjemploFactoryMethod {
  public static void main(String[] args) {
    Servicio factura = new ServicioFactura();
    Servicio pago = new ServicioPago();
    Servicio cliente = new ServicioCliente();
    
    System.out.println("FAC-001 es factura: " + factura.ejecutar("FAC-001"));
    System.out.println("PAG-001 es pago: " + pago.ejecutar("PAG-001"));
    System.out.println("CLI-001 es cliente: " + cliente.ejecutar("CLI-001"));
  }
}
```

#### Prototype

Crea objetos nuevos copiando una instancia configurada.

```java
record PlantillaFactura(String empresa, double impuesto) {
  PlantillaFactura copia() {
    return new PlantillaFactura(empresa, impuesto);
  }
}

public class EjemploPrototype {
  public static void main(String[] args) {
    PlantillaFactura agua = new PlantillaFactura("Agua", 0.02);
    PlantillaFactura energia = agua.copia();
    PlantillaFactura gas = new PlantillaFactura("Gas", 0.03).copia();
    
    System.out.println("Agua: " + agua);
    System.out.println("Energía (copia): " + energia);
    System.out.println("Gas (copia): " + gas);
  }
}
```

#### Singleton

Garantiza una única instancia controlada. Debe reservarse para un recurso realmente único y no para esconder dependencias globales.

```java
enum RelojSistema {
  INSTANCIA;
  
  public long ahora() {
    return System.currentTimeMillis();
  }
}

final class Configuracion {
  private static final Configuracion INSTANCIA = new Configuracion();
  private String ambiente = "produccion";
  
  private Configuracion() {}
  
  static Configuracion instancia() {
    return INSTANCIA;
  }
  
  String ambiente() {
    return ambiente;
  }
}

final class Metricas {
  static final Metricas INSTANCIA = new Metricas();
  private int contador = 0;
  
  private Metricas() {}
  
  void contar(String evento) {
    contador++;
    System.out.println("Evento: " + evento + " (Total: " + contador + ")");
  }
}

public class EjemploSingleton {
  public static void main(String[] args) {
    System.out.println("Hora actual: " + RelojSistema.INSTANCIA.ahora());
    System.out.println("Ambiente: " + Configuracion.instancia().ambiente());
    
    Metricas.INSTANCIA.contar("pago");
    Metricas.INSTANCIA.contar("consulta");
    Metricas.INSTANCIA.contar("pago");
  }
}
```

#### Adapter

Convierte la interfaz de un proveedor en la interfaz que espera el dominio.

```java
interface Pasarela {
  void cobrar(double valor);
}

final class ProveedorPse {
  void debitarEnPesos(double pesos) {
    System.out.println("PSE debitó: $" + pesos);
  }
}

final class PseAdapter implements Pasarela {
  private final ProveedorPse proveedor;
  
  PseAdapter(ProveedorPse proveedor) {
    this.proveedor = proveedor;
  }
  
  @Override
  public void cobrar(double valor) {
    proveedor.debitarEnPesos(valor);
  }
}

final class TarjetaLegacy {
  void chargeInCents(long cents) {
    System.out.println("Tarjeta cargada: $" + (cents / 100.0));
  }
}

final class TarjetaAdapter implements Pasarela {
  private final TarjetaLegacy tarjeta;
  
  TarjetaAdapter(TarjetaLegacy tarjeta) {
    this.tarjeta = tarjeta;
  }
  
  @Override
  public void cobrar(double valor) {
    tarjeta.chargeInCents(Math.round(valor * 100));
  }
}

public class EjemploAdapter {
  public static void main(String[] args) {
    Pasarela pse = new PseAdapter(new ProveedorPse());
    Pasarela tarjeta = new TarjetaAdapter(new TarjetaLegacy());
    
    pse.cobrar(5000);
    tarjeta.cobrar(3000);
  }
}
```

#### Bridge

Separa una abstracción de su implementación para que ambas evolucionen de forma independiente.

```java
interface Canal {
  void enviar(String mensaje);
}

final class EmailCanal implements Canal {
  @Override
  public void enviar(String mensaje) {
    System.out.println("Email enviado: " + mensaje);
  }
}

final class SmsCanal implements Canal {
  @Override
  public void enviar(String mensaje) {
    System.out.println("SMS enviado: " + mensaje);
  }
}

abstract class Aviso {
  protected final Canal canal;
  
  Aviso(Canal canal) {
    this.canal = canal;
  }
  
  abstract void enviar();
}

final class AvisoPago extends Aviso {
  AvisoPago(Canal canal) {
    super(canal);
  }
  
  @Override
  void enviar() {
    canal.enviar("Pago recibido");
  }
}

final class AvisoFactura extends Aviso {
  AvisoFactura(Canal canal) {
    super(canal);
  }
  
  @Override
  void enviar() {
    canal.enviar("Factura disponible");
  }
}

public class EjemploBridge {
  public static void main(String[] args) {
    new AvisoPago(new EmailCanal()).enviar();
    new AvisoPago(new SmsCanal()).enviar();
    new AvisoFactura(new EmailCanal()).enviar();
  }
}
```

#### Composite

Trata objetos individuales y composiciones de forma uniforme.

```java
interface Cargo {
  double total();
}

record ServicioCargo(double valor) implements Cargo {
  @Override
  public double total() {
    return valor;
  }
}

final class GrupoCargos implements Cargo {
  private final java.util.List<Cargo> items = new java.util.ArrayList<>();
  
  void agregar(Cargo cargo) {
    items.add(cargo);
  }
  
  @Override
  public double total() {
    return items.stream()
      .mapToDouble(Cargo::total)
      .sum();
  }
}

final class FacturaCompuesta implements Cargo {
  private final java.util.List<Cargo> cargos;
  
  FacturaCompuesta(java.util.List<Cargo> cargos) {
    this.cargos = cargos;
  }
  
  @Override
  public double total() {
    return cargos.stream()
      .mapToDouble(Cargo::total)
      .sum();
  }
}

public class EjemploComposite {
  public static void main(String[] args) {
    GrupoCargos grupo = new GrupoCargos();
    grupo.agregar(new ServicioCargo(1000));
    grupo.agregar(new ServicioCargo(2000));
    
    FacturaCompuesta factura = new FacturaCompuesta(
      java.util.List.of(
        new ServicioCargo(1000),
        new ServicioCargo(500),
        grupo
      )
    );
    
    System.out.println("Total grupo: $" + grupo.total());
    System.out.println("Total factura: $" + factura.total());
  }
}
```

#### Decorator

Añade responsabilidades envolviendo un objeto, sin modificar su clase.

```java
interface Cobro {
  double ejecutar(double valor);
}

record CobroBase() implements Cobro {
  @Override
  public double ejecutar(double valor) {
    return valor;
  }
}

record CobroConAuditoria(Cobro interno) implements Cobro {
  @Override
  public double ejecutar(double valor) {
    System.out.println("Auditando cobro de: $" + valor);
    return interno.ejecutar(valor);
  }
}

record CobroConComision(Cobro interno, double comision) implements Cobro {
  @Override
  public double ejecutar(double valor) {
    double total = interno.ejecutar(valor) + comision;
    System.out.println("Aplicada comisión: $" + comision);
    return total;
  }
}

public class EjemploDecorator {
  public static void main(String[] args) {
    Cobro base = new CobroBase();
    Cobro conAuditoria = new CobroConAuditoria(base);
    Cobro conTodo = new CobroConComision(conAuditoria, 500);
    
    System.out.println("Cobro base: $" + base.ejecutar(5000));
    System.out.println("Cobro con auditoria: $" + conAuditoria.ejecutar(5000));
    System.out.println("Cobro con todo: $" + conTodo.ejecutar(5000));
  }
}
```

#### Facade

Ofrece una entrada simple a un subsistema complejo.

```java
record Factura(double total) {}
record Cuenta(double saldo) {}

interface Pasarela {
  void cobrar(double valor);
}

final class PagoFacade {
  private final Pasarela pasarela;
  
  PagoFacade(Pasarela pasarela) {
    this.pasarela = pasarela;
  }
  
  void pagar(Factura factura, Cuenta cuenta) {
    if (factura.total() <= 0) {
      System.out.println("Factura inválida");
      return;
    }
    if (cuenta.saldo() < factura.total()) {
      System.out.println("Saldo insuficiente");
      return;
    }
    pasarela.cobrar(factura.total());
    System.out.println("Pago procesado: $" + factura.total());
  }
}

final class ConsultaFacade {
  String estado(Factura factura) {
    return factura.total() > 0 ? "PENDIENTE" : "INVALIDA";
  }
}

final class PasarelaSimple implements Pasarela {
  @Override
  public void cobrar(double valor) {
    System.out.println("Cobrando: $" + valor);
  }
}

public class EjemploFacade {
  public static void main(String[] args) {
    PagoFacade pago = new PagoFacade(new PasarelaSimple());
    ConsultaFacade consulta = new ConsultaFacade();
    
    Factura f = new Factura(5000);
    Cuenta c = new Cuenta(10000);
    
    System.out.println("Estado: " + consulta.estado(f));
    pago.pagar(f, c);
  }
}
```

#### Flyweight

Comparte estado intrínseco para reducir memoria cuando hay muchos objetos similares.

```java
record Icono(String nombre) {
  @Override
  public String toString() {
    return "Icono(" + nombre + ")";
  }
}

final class Iconos {
  private static final java.util.Map<String, Icono> cache = 
    new java.util.HashMap<>();
  
  static Icono obtener(String nombre) {
    return cache.computeIfAbsent(nombre, Icono::new);
  }
}

public class EjemploFlyweight {
  public static void main(String[] args) {
    Icono agua1 = Iconos.obtener("agua");
    Icono agua2 = Iconos.obtener("agua");
    Icono energia = Iconos.obtener("energia");
    Icono gas = Iconos.obtener("gas");
    
    System.out.println("agua1: " + agua1);
    System.out.println("agua2: " + agua2);
    System.out.println("¿Están compartiendo instancia? " + (agua1 == agua2));
    System.out.println("energia: " + energia);
    System.out.println("gas: " + gas);
  }
}
```

#### Proxy

Controla el acceso a otro objeto, por ejemplo con seguridad, cache o carga diferida.

```java
record Factura(String id, double total) {}

interface Facturas {
  Factura buscar(String id);
}

final class FacturaRepositorio implements Facturas {
  private java.util.Map<String, Factura> datos = new java.util.HashMap<>();
  
  FacturaRepositorio() {
    datos.put("F001", new Factura("F001", 5000));
    datos.put("F002", new Factura("F002", 3000));
  }
  
  @Override
  public Factura buscar(String id) {
    System.out.println("Consultando BD: " + id);
    return datos.get(id);
  }
}

final class FacturaProxySeguridad implements Facturas {
  private final Facturas real;
  private final String usuario;
  
  FacturaProxySeguridad(Facturas real, String usuario) {
    this.real = real;
    this.usuario = usuario;
  }
  
  @Override
  public Factura buscar(String id) {
    if (usuario == null || usuario.isBlank()) {
      throw new SecurityException("Usuario no autenticado");
    }
    return real.buscar(id);
  }
}

final class FacturaProxyCache implements Facturas {
  private final Facturas real;
  private java.util.Map<String, Factura> cache = new java.util.HashMap<>();
  
  FacturaProxyCache(Facturas real) {
    this.real = real;
  }
  
  @Override
  public Factura buscar(String id) {
    if (cache.containsKey(id)) {
      System.out.println("Obtenida de cache: " + id);
      return cache.get(id);
    }
    Factura factura = real.buscar(id);
    cache.put(id, factura);
    return factura;
  }
}

public class EjemploProxy {
  public static void main(String[] args) {
    Facturas repo = new FacturaRepositorio();
    Facturas proxySeguro = new FacturaProxySeguridad(repo, "usuario1");
    Facturas proxyCache = new FacturaProxyCache(proxySeguro);
    
    System.out.println("Primera consulta: " + proxyCache.buscar("F001"));
    System.out.println("Segunda consulta: " + proxyCache.buscar("F001"));
  }
}
```

#### Chain of Responsibility

Pasa una solicitud por una cadena de manejadores hasta que uno la procesa.

```java
record Pago(double valor) {}

abstract class Regla {
  protected Regla siguiente;
  
  Regla sigue(Regla siguiente) {
    this.siguiente = siguiente;
    return siguiente;
  }
  
  abstract boolean acepta(Pago pago);
}

final class ReglaMonto extends Regla {
  @Override
  boolean acepta(Pago pago) {
    if (pago.valor() > 0 && pago.valor() <= 1000000) {
      System.out.println("Monto válido: $" + pago.valor());
      return true;
    }
    return siguiente != null && siguiente.acepta(pago);
  }
}

final class ReglaSaldo extends Regla {
  @Override
  boolean acepta(Pago pago) {
    if (pago.valor() <= 100000000) {
      System.out.println("Saldo suficiente para: $" + pago.valor());
      return true;
    }
    return siguiente != null && siguiente.acepta(pago);
  }
}

final class ReglaFraude extends Regla {
  @Override
  boolean acepta(Pago pago) {
    if (pago.valor() < 5000000) {
      System.out.println("Sin fraude detectado");
      return true;
    }
    return false;
  }
}

public class EjemploChainOfResponsibility {
  public static void main(String[] args) {
    Regla cadena = new ReglaMonto();
    cadena.sigue(new ReglaSaldo()).sigue(new ReglaFraude());
    
    cadena.acepta(new Pago(500000));
    cadena.acepta(new Pago(5000000));
  }
}
```

#### Command

Encapsula una acción como objeto para ejecutar, registrar, encolar o deshacer.

```java
interface Comando {
  void ejecutar();
}

record Pago(String id, double valor) {}

final class PagarCommand implements Comando {
  private final Runnable accion;
  
  PagarCommand(Runnable accion) {
    this.accion = accion;
  }
  
  @Override
  public void ejecutar() {
    accion.run();
  }
}

final class ReversarCommand implements Comando {
  private final Runnable accion;
  
  ReversarCommand(Runnable accion) {
    this.accion = accion;
  }
  
  @Override
  public void ejecutar() {
    System.out.println("Reversando...");
    accion.run();
  }
}

final class InvocadorDeComandos {
  private java.util.List<Comando> comandos = new java.util.ArrayList<>();
  
  void agregar(Comando cmd) {
    comandos.add(cmd);
  }
  
  void ejecutarTodos() {
    for (Comando cmd : comandos) {
      cmd.ejecutar();
    }
  }
}

public class EjemploCommand {
  public static void main(String[] args) {
    InvocadorDeComandos invocador = new InvocadorDeComandos();
    Pago pago = new Pago("P001", 5000);
    
    invocador.agregar(new PagarCommand(() -> System.out.println("Pago ejecutado: " + pago)));
    invocador.agregar(new ReversarCommand(() -> System.out.println("Pago revertido")));
    
    invocador.ejecutarTodos();
  }
}
```

#### Interpreter

Representa una gramática pequeña y evalúa expresiones de ese lenguaje.

```java
record Cliente(String tipo) {}

interface Expresion {
  boolean evaluar(Cliente cliente);
}

record EsTipo(String tipo) implements Expresion {
  @Override
  public boolean evaluar(Cliente cliente) {
    return cliente.tipo().equals(tipo);
  }
}

record TieneDescuento() implements Expresion {
  @Override
  public boolean evaluar(Cliente cliente) {
    return cliente.tipo().equals("preferencial");
  }
}

record And(Expresion izquierda, Expresion derecha) implements Expresion {
  @Override
  public boolean evaluar(Cliente cliente) {
    return izquierda.evaluar(cliente) && derecha.evaluar(cliente);
  }
}

public class EjemploInterpreter {
  public static void main(String[] args) {
    Expresion esResidencial = new EsTipo("residencial");
    Expresion tieneDescuento = new TieneDescuento();
    Expresion ambas = new And(esResidencial, tieneDescuento);
    
    Cliente c1 = new Cliente("residencial");
    Cliente c2 = new Cliente("preferencial");
    
    System.out.println("c1 es residencial: " + esResidencial.evaluar(c1));
    System.out.println("c2 tiene descuento: " + tieneDescuento.evaluar(c2));
    System.out.println("c1 es residencial Y tiene descuento: " + ambas.evaluar(c1));
  }
}
```

#### Iterator

Recorre una colección sin exponer su representación interna.

```java
record Factura(String id, double total) {}

final class FacturaCollection implements Iterable<Factura> {
  private final java.util.List<Factura> datos = new java.util.ArrayList<>();
  
  void agregar(Factura factura) {
    datos.add(factura);
  }
  
  @Override
  public java.util.Iterator<Factura> iterator() {
    return datos.iterator();
  }
}

final class PagosCollection implements Iterable<Factura> {
  private final java.util.List<Factura> pendientes = new java.util.ArrayList<>();
  
  void agregar(Factura factura) {
    pendientes.add(factura);
  }
  
  @Override
  public java.util.Iterator<Factura> iterator() {
    return pendientes.iterator();
  }
}

public class EjemploIterator {
  public static void main(String[] args) {
    FacturaCollection facturas = new FacturaCollection();
    facturas.agregar(new Factura("F001", 5000));
    facturas.agregar(new Factura("F002", 3000));
    facturas.agregar(new Factura("F003", 2000));
    
    System.out.println("Recorriendo facturas:");
    for (Factura factura : facturas) {
      System.out.println("  " + factura.id() + ": $" + factura.total());
    }
  }
}
```

#### Mediator

Centraliza la comunicación entre objetos para reducir referencias directas entre colegas.

```java
record Pago(String id, double valor) {}

interface Notificador {
  void notificar(Pago pago);
}

interface Auditor {
  void registrar(Pago pago);
}

final class PagoMediator {
  private final Notificador notificador;
  private final Auditor auditor;
  
  PagoMediator(Notificador notificador, Auditor auditor) {
    this.notificador = notificador;
    this.auditor = auditor;
  }
  
  void pagoRegistrado(Pago pago) {
    auditor.registrar(pago);
    notificador.notificar(pago);
  }
}

final class NotificadorConsola implements Notificador {
  @Override
  public void notificar(Pago pago) {
    System.out.println("Notificación: Pago " + pago.id() + " confirmado");
  }
}

final class AuditorConsola implements Auditor {
  @Override
  public void registrar(Pago pago) {
    System.out.println("Auditoria: Pago " + pago.id() + " registrado");
  }
}

public class EjemploMediator {
  public static void main(String[] args) {
    PagoMediator mediador = new PagoMediator(
      new NotificadorConsola(),
      new AuditorConsola()
    );
    
    Pago pago = new Pago("P001", 5000);
    mediador.pagoRegistrado(pago);
  }
}
```

#### Memento

Guarda el estado de un objeto sin exponer sus detalles para poder restaurarlo.

```java
final class EstadoPago {
  private String estado = "PENDIENTE";
  
  record Memento(String valor) {}
  
  String estado() {
    return estado;
  }
  
  void estado(String nuevoEstado) {
    this.estado = nuevoEstado;
    System.out.println("Estado cambiado a: " + estado);
  }
  
  Memento guardar() {
    return new Memento(estado);
  }
  
  void restaurar(Memento memento) {
    estado = memento.valor();
    System.out.println("Estado restaurado a: " + estado);
  }
}

public class EjemploMemento {
  public static void main(String[] args) {
    EstadoPago pago = new EstadoPago();
    System.out.println("Estado inicial: " + pago.estado());
    
    EstadoPago.Memento antesDeAutorizar = pago.guardar();
    pago.estado("AUTORIZADO");
    
    EstadoPago.Memento antesDeAplicar = pago.guardar();
    pago.estado("APLICADO");
    
    pago.restaurar(antesDeAplicar);
    pago.restaurar(antesDeAutorizar);
  }
}
```

#### Observer

Notifica automáticamente a suscriptores cuando cambia un sujeto.

```java
record Pago(String id, double valor) {}

interface Observador {
  void actualizar(Pago pago);
}

final class ClienteNotificador implements Observador {
  @Override
  public void actualizar(Pago pago) {
    System.out.println("Email: Pago " + pago.id() + " confirmado por $" + pago.valor());
  }
}

final class AuditorObservador implements Observador {
  @Override
  public void actualizar(Pago pago) {
    System.out.println("Auditoria: Pago " + pago.id() + " registrado");
  }
}

final class AnaliticaObservador implements Observador {
  @Override
  public void actualizar(Pago pago) {
    System.out.println("Analítica: Incrementando métrica de $" + pago.valor());
  }
}

final class RegistroPagos {
  private final java.util.List<Observador> observadores = new java.util.ArrayList<>();
  
  void suscribir(Observador observador) {
    observadores.add(observador);
  }
  
  void publicar(Pago pago) {
    for (Observador obs : observadores) {
      obs.actualizar(pago);
    }
  }
}

public class EjemploObserver {
  public static void main(String[] args) {
    RegistroPagos registro = new RegistroPagos();
    registro.suscribir(new ClienteNotificador());
    registro.suscribir(new AuditorObservador());
    registro.suscribir(new AnaliticaObservador());
    
    Pago pago = new Pago("P001", 5000);
    registro.publicar(pago);
  }
}
```

#### State

Permite que un objeto cambie su comportamiento al cambiar de estado interno.

```java
interface Estado {
  String siguiente();
}

record Pendiente() implements Estado {
  @Override
  public String siguiente() {
    return "AUTORIZADO";
  }
}

record Autorizado() implements Estado {
  @Override
  public String siguiente() {
    return "APLICADO";
  }
}

record Aplicado() implements Estado {
  @Override
  public String siguiente() {
    return "APLICADO";
  }
}

record Rechazado() implements Estado {
  @Override
  public String siguiente() {
    return "RECHAZADO";
  }
}

final class PagoContext {
  private Estado estado = new Pendiente();
  
  void avanzar() {
    String siguiente = estado.siguiente();
    System.out.println("Transición a: " + siguiente);
    estado = switch(siguiente) {
      case "AUTORIZADO" -> new Autorizado();
      case "APLICADO" -> new Aplicado();
      default -> estado;
    };
  }
  
  String estado() {
    return estado.getClass().getSimpleName();
  }
}

public class EjemploState {
  public static void main(String[] args) {
    PagoContext pago = new PagoContext();
    System.out.println("Estado: " + pago.estado());
    
    pago.avanzar();
    pago.avanzar();
    pago.avanzar();
  }
}
```

#### Strategy

Encapsula algoritmos intercambiables bajo una misma interfaz.

```java
interface CalculoComision {
  double calcular(double valor);
}

record SinComision() implements CalculoComision {
  @Override
  public double calcular(double valor) {
    return 0;
  }
}

record ComisionFija() implements CalculoComision {
  @Override
  public double calcular(double valor) {
    return 1500;
  }
}

record ComisionPorcentual(double tasa) implements CalculoComision {
  @Override
  public double calcular(double valor) {
    return valor * tasa;
  }
}

final class CalculadorTotal {
  double total(double valor, CalculoComision estrategia) {
    return valor + estrategia.calcular(valor);
  }
}

public class EjemploStrategy {
  public static void main(String[] args) {
    CalculadorTotal calc = new CalculadorTotal();
    
    System.out.println("Sin comisión: $" + calc.total(5000, new SinComision()));
    System.out.println("Comisión fija: $" + calc.total(5000, new ComisionFija()));
    System.out.println("Comisión 5%: $" + calc.total(5000, new ComisionPorcentual(0.05)));
  }
}
```

#### Template Method

Define el esqueleto de un algoritmo y deja pasos variables a las subclases.

```java
record Pago(String id, double valor) {}

abstract class ProcesarPago {
  final void procesar(Pago pago) {
    validar(pago);
    autorizar(pago);
    registrar(pago);
  }
  
  void validar(Pago pago) {
    System.out.println("Validando pago " + pago.id());
  }
  
  abstract void autorizar(Pago pago);
  
  void registrar(Pago pago) {
    System.out.println("Registrando pago " + pago.id());
  }
}

final class ProcesarPse extends ProcesarPago {
  @Override
  void autorizar(Pago pago) {
    System.out.println("Autorizando por PSE: " + pago.valor());
  }
}

final class ProcesarTarjeta extends ProcesarPago {
  @Override
  void autorizar(Pago pago) {
    System.out.println("Autorizando por Tarjeta: " + pago.valor());
  }
}

final class ProcesarBilletera extends ProcesarPago {
  @Override
  void autorizar(Pago pago) {
    System.out.println("Autorizando por Billetera: " + pago.valor());
  }
}

public class EjemploTemplateMethod {
  public static void main(String[] args) {
    Pago pago = new Pago("P001", 5000);
    
    new ProcesarPse().procesar(pago);
    System.out.println();
    new ProcesarTarjeta().procesar(pago);
    System.out.println();
    new ProcesarBilletera().procesar(pago);
  }
}
```

#### Visitor

Permite agregar operaciones a una estructura de objetos sin modificar sus clases.

```java
record ServicioCargo(String nombre, double valor) {}

interface ElementoFactura {
  void aceptar(Visitante visitante);
}

final class Cargo implements ElementoFactura {
  private final ServicioCargo servicio;
  
  Cargo(ServicioCargo servicio) {
    this.servicio = servicio;
  }
  
  @Override
  public void aceptar(Visitante visitante) {
    visitante.visitar(this);
  }
  
  ServicioCargo servicio() {
    return servicio;
  }
}

interface Visitante {
  void visitar(Cargo cargo);
}

final class VisitanteImpuesto implements Visitante {
  @Override
  public void visitar(Cargo cargo) {
    double impuesto = cargo.servicio().valor() * 0.19;
    System.out.println("Impuesto de " + cargo.servicio().nombre() + ": $" + impuesto);
  }
}

final class VisitanteReporte implements Visitante {
  @Override
  public void visitar(Cargo cargo) {
    System.out.println("Reporte: " + cargo.servicio().nombre() + " - $" + cargo.servicio().valor());
  }
}

final class VisitanteExportacion implements Visitante {
  @Override
  public void visitar(Cargo cargo) {
    System.out.println("CSV," + cargo.servicio().nombre() + "," + cargo.servicio().valor());
  }
}

public class EjemploVisitor {
  public static void main(String[] args) {
    Cargo agua = new Cargo(new ServicioCargo("Agua", 5000));
    Cargo energia = new Cargo(new ServicioCargo("Energía", 3000));
    
    Visitante impuesto = new VisitanteImpuesto();
    Visitante reporte = new VisitanteReporte();
    Visitante exportacion = new VisitanteExportacion();
    
    System.out.println("=== Cálculo de impuestos ===");
    agua.aceptar(impuesto);
    energia.aceptar(impuesto);
    
    System.out.println("\n=== Reporte ===");
    agua.aceptar(reporte);
    energia.aceptar(reporte);
    
    System.out.println("\n=== Exportación ===");
    agua.aceptar(exportacion);
    energia.aceptar(exportacion);
  }
}
```

### Ejemplos 2 y 3 de cada patrón GoF

El bloque de cada patrón contiene el ejemplo 1. Los siguientes dos ejemplos son alternativas distintas, no simples repeticiones de instancias.

#### Abstract Factory
```java
interface ReporteFactory { Encabezado encabezado(); Pie pie(); }
record Encabezado(String texto) {} record Pie(String texto) {}
final class ReporteResidencial implements ReporteFactory { public Encabezado encabezado(){return new Encabezado("Hogar");} public Pie pie(){return new Pie("Total residencial");} }
final class ReporteEmpresarial implements ReporteFactory { public Encabezado encabezado(){return new Encabezado("Empresa");} public Pie pie(){return new Pie("Total empresarial");} }
```
```java
WidgetFactory factory = tipoCliente.equals("empresa") ? new WebFactory() : new MovilFactory();
Boton boton = factory.boton();
Campo campo = factory.campo();
```

#### Builder
```java
record FiltroFacturas(String cliente, String estado, Integer limite) {
  static class Builder { String cliente, estado; Integer limite;
    Builder cliente(String v){cliente=v;return this;} Builder estado(String v){estado=v;return this;}
    Builder limite(int v){limite=v;return this;} FiltroFacturas build(){return new FiltroFacturas(cliente,estado,limite);} }
}
```
```java
FiltroFacturas filtro = new FiltroFacturas.Builder().cliente("C1").estado("PENDIENTE").limite(20).build();
```

#### Factory Method
```java
interface Documento { String formato(); }
abstract class Exportador { abstract Documento crearDocumento(); Documento exportar(){return crearDocumento();} }
final class ExportadorPdf extends Exportador { Documento crearDocumento(){return () -> "PDF";} }
final class ExportadorCsv extends Exportador { Documento crearDocumento(){return () -> "CSV";} }
```
```java
Exportador exportador = formato.equals("pdf") ? new ExportadorPdf() : new ExportadorCsv();
Documento documento = exportador.exportar();
```

#### Prototype
```java
record ReglaMora(double porcentaje, String servicio) { ReglaMora copia(){return new ReglaMora(porcentaje, servicio);} }
ReglaMora agua = new ReglaMora(.02, "agua");
ReglaMora energia = agua.copia();
```
```java
ReglaMora gas = new ReglaMora(.03, "gas").copia();
```

#### Singleton
```java
final class Configuracion { private Configuracion() {} private static final Configuracion I=new Configuracion();
  static Configuracion instancia(){return I;} String ambiente(){return "produccion";} }
Configuracion configuracion = Configuracion.instancia();
```
```java
final class Metricas { private Metricas() {} static final Metricas INSTANCIA=new Metricas(); void contar(String evento){} }
Metricas.INSTANCIA.contar("pago");
```

#### Adapter
```java
final class TarjetaLegacy { void chargeInCents(long cents){} }
final class TarjetaAdapter implements Pasarela { private final TarjetaLegacy tarjeta; TarjetaAdapter(TarjetaLegacy t){tarjeta=t;} public void cobrar(double v){tarjeta.chargeInCents(Math.round(v*100));} }
```
```java
final class BilleteraDigital { void pagarPesos(String valor){} }
final class BilleteraAdapter implements Pasarela { private final BilleteraDigital billetera; BilleteraAdapter(BilleteraDigital b){billetera=b;} public void cobrar(double v){billetera.pagarPesos(String.valueOf(v));} }
```

#### Bridge
```java
final class EmailCanal implements Canal { public void enviar(String m){/* email */} }
final class SmsCanal implements Canal { public void enviar(String m){/* SMS */} }
final class AvisoFactura extends Aviso { AvisoFactura(Canal c){super(c);} void enviar(){canal.enviar("Factura disponible");} }
```
```java
new AvisoFactura(new SmsCanal()).enviar();
```

#### Composite
```java
final class FacturaCompuesta implements Cargo { private final java.util.List<Cargo> cargos; FacturaCompuesta(java.util.List<Cargo> c){cargos=c;} public double total(){return cargos.stream().mapToDouble(Cargo::total).sum();} }
```
```java
final class ClienteCargos implements Cargo { private final Cargo cargo; ClienteCargos(Cargo c){cargo=c;} public double total(){return cargo.total();} }
```

#### Decorator
```java
record CobroConComision(Cobro interno, double comision) implements Cobro { public double ejecutar(double v){return interno.ejecutar(v)+comision;} }
```
```java
Cobro cobroSeguro = new CobroConAuditoria(new CobroConComision(new CobroBase(), 1500));
```

#### Facade
```java
final class ConsultaFacade { String estado(Factura f){return f.total()>0 ? "PENDIENTE" : "INVALIDA";} }
```
```java
final class ReversoFacade { void cancelar(Pago p){/* valida y revierte */} }
```

#### Flyweight
```java
Icono agua1 = Iconos.obtener("agua");
Icono agua2 = Iconos.obtener("agua");
```
```java
Icono gas1 = Iconos.obtener("gas");
Icono gas2 = Iconos.obtener("gas");
```

#### Proxy
```java
final class AutorizacionProxy implements Facturas { private final Facturas real; private final String usuario; AutorizacionProxy(Facturas r,String u){real=r;usuario=u;}
  public Factura buscar(String id){if(usuario==null)throw new SecurityException();return real.buscar(id);} }
```
```java
final class CacheProxy implements Facturas { private final Facturas real; private final java.util.Map<String,Factura> cache=new java.util.HashMap<>(); CacheProxy(Facturas r){real=r;}
  public Factura buscar(String id){return cache.computeIfAbsent(id,real::buscar);} }
```

#### Chain of Responsibility
```java
final class ReglaSaldo extends Regla { boolean acepta(Pago p){return p.valor()<=1000000 || (siguiente!=null&&siguiente.acepta(p));} }
```
```java
final class ReglaFraude extends Regla { boolean acepta(Pago p){return p.valor()<5000000 || (siguiente!=null&&siguiente.acepta(p));} }
```

#### Command
```java
final class ReversarCommand implements Comando { private final Runnable accion; ReversarCommand(Runnable a){accion=a;} public void ejecutar(){accion.run();} }
```
```java
final class ReintentarCommand implements Comando { private final Runnable accion; ReintentarCommand(Runnable a){accion=a;} public void ejecutar(){accion.run();} }
```

#### Interpreter
```java
record And(Expresion izquierda, Expresion derecha) implements Expresion { public boolean evaluar(Cliente c){return izquierda.evaluar(c)&&derecha.evaluar(c);} }
```
```java
record TieneDescuento() implements Expresion { public boolean evaluar(Cliente c){return c.tipo().equals("preferencial");} }
```

#### Iterator
```java
final class PagosCollection implements Iterable<Pago> { private final java.util.List<Pago> datos=new java.util.ArrayList<>(); void agregar(Pago p){datos.add(p);} public java.util.Iterator<Pago> iterator(){return datos.iterator();} }
```
```java
for (Pago pago : new PagosCollection()) { System.out.println(pago.valor()); }
```

#### Mediator
```java
final class PagoBus { private final java.util.List<Runnable> acciones=new java.util.ArrayList<>(); void agregar(Runnable a){acciones.add(a);} void publicar(){acciones.forEach(Runnable::run);} }
```
```java
final class FacturaColleague { private final PagoBus bus; FacturaColleague(PagoBus b){bus=b;} void actualizar(){bus.publicar();} }
```

#### Memento
```java
EstadoPago estado = new EstadoPago();
EstadoPago.Memento antesDeAutorizar = estado.guardar();
estado.estado("AUTORIZADO");
```
```java
EstadoPago.Memento antesDeAplicar = estado.guardar();
estado.estado("APLICADO");
estado.restaurar(antesDeAplicar);
```

#### Observer
```java
final class ClienteNotificador implements Observador { public void actualizar(Pago p){/* envia correo */} }
final class AuditorObservador implements Observador { public void actualizar(Pago p){/* guarda auditoria */} }
```
```java
final class AnaliticaObservador implements Observador { public void actualizar(Pago p){/* actualiza metricas */} }
```

#### State
```java
record Rechazado() implements Estado { public String siguiente(){return "RECHAZADO";} }
```
```java
final class PagoContext { private Estado estado=new Pendiente(); void avanzar(){estado=new Autorizado();} String estado(){return estado.siguiente();} }
```

#### Strategy
```java
record ComisionPorcentual(double tasa) implements CalculoComision { public double calcular(double v){return v*tasa;} }
```
```java
final class Calculador { double total(double valor, CalculoComision estrategia){return valor+estrategia.calcular(valor);} }
```

#### Template Method
```java
final class ProcesarTarjeta extends ProcesarPago { void autorizar(Pago p){/* tarjeta */} }
```
```java
final class ProcesarBilletera extends ProcesarPago { void autorizar(Pago p){/* billetera */} }
```

#### Visitor
```java
final class VisitanteReporte implements Visitante { public void visitar(ServicioCargo c){/* agrega al reporte */} }
```
```java
final class VisitanteExportacion implements Visitante { public void visitar(ServicioCargo c){/* exporta CSV */} }
```

### Actividad: GoF en el sistema de pagos

1. Cree familias de facturas residenciales y empresariales con `Abstract Factory`.
2. Integre PSE, tarjeta y billetera con `Adapter` y justifique la decisión.
3. Calcule comisiones por tipo de cuenta con `Strategy`.
4. Ejecute validación de saldo, límite y fraude con `Chain of Responsibility`.
5. Notifique un pago aplicado a cliente, auditoría y analítica con `Observer` o `Mediator`.
6. Encapsule pagar, reversar y reintentar mediante `Command`.
7. Implemente al menos tres patrones, escriba una prueba por patrón y documente una consecuencia negativa de cada elección.

---

## Clase 07A: Patrones GRASP para asignar responsabilidades

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 4

### Objetivos de aprendizaje

- Usar GRASP para decidir qué objeto conoce, crea, coordina o delega una operación.
- Aplicar los nueve patrones al sistema de pagos de servicios públicos.
- Justificar responsabilidades con cohesión, acoplamiento y polimorfismo.

### Teoría y ejemplos Java

GRASP significa *General Responsibility Assignment Software Patterns*. Es una guía para asignar responsabilidades, no un catálogo de clases prefabricadas.

#### Experto en información

Asigna una responsabilidad a la clase que posee la información necesaria.

```java
record Factura(double consumo, double tarifa) { double total(){return consumo*tarifa;} }
// Tres ejemplos: Factura calcula total; Cuenta calcula saldo; Cliente obtiene sus facturas.
```

#### Creador

Una clase crea objetos que contiene, agrega o usa estrechamente.

```java
final class Cuenta { Pago crearPago(Factura f){return new Pago(f.total());} }
record Pago(double valor) {}
// Tres ejemplos: Cliente crea Cuenta; Cuenta crea Pago; SistemaPagos crea Factura.
```

#### Controlador

Un objeto de aplicación recibe eventos del sistema y coordina el caso de uso.

```java
final class PagoController { private final PagarFactura caso; PagoController(PagarFactura c){caso=c;} void pagar(String id){caso.ejecutar(id);} }
interface PagarFactura { void ejecutar(String facturaId); }
// Tres ejemplos: PagoController, ConsultaFacturaController y RegistroClienteController.
```

#### Bajo acoplamiento

Minimiza dependencias entre clases para que los cambios se propaguen menos.

```java
interface PagoStore { void guardar(Pago p); }
final class RegistroPago { private final PagoStore store; RegistroPago(PagoStore s){store=s;} void registrar(Pago p){store.guardar(p);} }
// Tres ejemplos: puerto de persistencia, puerto de notificacion y puerto de pasarela.
```

#### Alta cohesión

Mantiene juntas responsabilidades relacionadas y evita clases “dios”.

```java
final class ValidadorFactura { boolean valida(Factura f){return f.total()>0;} }
// Tres ejemplos: ValidadorFactura valida; CalculadorTarifa calcula; ConciliadorPago concilia.
```

#### Polimorfismo

Asigna variaciones de comportamiento a tipos polimórficos en lugar de condicionales repetidos.

```java
interface ReglaCuenta { boolean autoriza(double valor); }
record ReglaAhorros() implements ReglaCuenta { public boolean autoriza(double v){return v>=0;} }
// Tres ejemplos: ReglaAhorros, ReglaCorriente y ReglaEmpresarial responden al mismo mensaje.
```

#### Fabricación pura

Crea una clase artificial, sin representar una entidad del dominio, para proteger cohesión y acoplamiento.

```java
final class PagoMapper { Pago desdeLinea(String linea){return new Pago(Double.parseDouble(linea));} }
// Tres ejemplos: PagoMapper, FacturaCsvParser y ResumenMensualService.
```

#### Indirección

Introduce un intermediario para evitar dependencia directa entre componentes.

```java
interface NotificacionPort { void enviar(String texto); }
final class NotificacionService { private final NotificacionPort port; NotificacionService(NotificacionPort p){port=p;} void confirmar(){port.enviar("ok");} }
// Tres ejemplos: port de pago, repository y adapter de notificacion.
```

#### Variaciones protegidas

Identifica puntos de cambio y los protege detrás de una interfaz estable.

```java
interface FuenteTarifa { double tarifa(String servicio); }
final class FacturaService { private final FuenteTarifa fuente; FacturaService(FuenteTarifa f){fuente=f;} }
// Tres ejemplos: proteger cambio de tarifa, pasarela y proveedor de identidad.
```

### Ejemplos 2 y 3 de cada patrón GRASP

El bloque de cada patrón contiene el ejemplo 1. Se agregan dos ejemplos distintos por patrón, con responsabilidades y colaboradores diferentes.

#### Experto en información
```java
record Cuenta(double saldo, double limite) { boolean puedePagar(double v){return saldo+limite>=v;} }
```
```java
final class ClientePagos { long pendientes(java.util.List<Factura> fs){return fs.stream().filter(f->!f.pagada()).count();} }
```

#### Creador
```java
final class ClienteCreador { private final java.util.List<Cuenta> cuentas=new java.util.ArrayList<>();
  Cuenta abrirCuenta(double saldo){Cuenta c=new Cuenta(saldo,0);cuentas.add(c);return c;} }
```
```java
final class SistemaFacturacion { Factura emitir(double consumo,double tarifa){return new Factura(consumo,tarifa);} }
```

#### Controlador
```java
final class ConsultaFacturaController { private final FacturaReader reader; ConsultaFacturaController(FacturaReader r){reader=r;} Factura consultar(String id){return reader.buscar(id);} }
```
```java
final class RegistroClienteController { private final ClienteService servicio; RegistroClienteController(ClienteService s){servicio=s;} void registrar(String nombre){servicio.registrar(nombre);} }
interface ClienteService { void registrar(String nombre); }
```

#### Bajo acoplamiento
```java
interface NotificacionPort { void enviar(String destino,String texto); }
final class EnviarAviso { private final NotificacionPort port; EnviarAviso(NotificacionPort p){port=p;} void ejecutar(){port.enviar("cliente","Pago aplicado");} }
```
```java
interface PasarelaPort { void autorizar(double valor); }
final class AutorizarPago { private final PasarelaPort port; AutorizarPago(PasarelaPort p){port=p;} void ejecutar(double v){port.autorizar(v);} }
```

#### Alta cohesión
```java
final class CalculadorTarifa { double calcular(double consumo,double tarifa){return consumo*tarifa;} }
```
```java
final class ConciliadorPago { boolean conciliar(Pago pago,String referencia){return pago.valor()>0&&referencia!=null;} }
```

#### Polimorfismo
```java
final class ReglaCorriente implements ReglaCuenta { public boolean autoriza(double v){return v<=1000000;} }
```
```java
final class ReglaEmpresarial implements ReglaCuenta { public boolean autoriza(double v){return v<=10000000;} }
```

#### Fabricación pura
```java
final class FacturaCsvParser { Factura parsear(String linea){String[] p=linea.split(",");return new Factura(Double.parseDouble(p[0]),Double.parseDouble(p[1]));} }
```
```java
final class ResumenMensualService { double generar(java.util.List<Pago> pagos){return pagos.stream().mapToDouble(Pago::valor).sum();} }
```

#### Indirección
```java
interface AuditoriaPort { void registrar(String evento); }
final class PagoAuditable { private final AuditoriaPort auditoria; PagoAuditable(AuditoriaPort a){auditoria=a;} void registrar(Pago p){auditoria.registrar("pago:"+p.valor());} }
```
```java
interface FacturaPort { Factura consultar(String id); }
final class ConsultaFactura { private final FacturaPort port; ConsultaFactura(FacturaPort p){port=p;} Factura ejecutar(String id){return port.consultar(id);} }
```

#### Variaciones protegidas
```java
interface FuenteIdentidad { boolean validar(String token); }
final class SeguridadService { private final FuenteIdentidad identidad; SeguridadService(FuenteIdentidad i){identidad=i;} boolean autorizar(String token){return identidad.validar(token);} }
```
```java
interface Impuesto { double calcular(double base); }
final class TotalFactura { private final Impuesto impuesto; TotalFactura(Impuesto i){impuesto=i;} double total(double base){return base+impuesto.calcular(base);} }

### Actividad: GRASP en el sistema de pagos

1. Asigne a `Factura` el cálculo de su total y a `Cuenta` la validación del saldo; justifique cada decisión con **Experto**.
2. Diseñe `PagarFacturaController` como **Controlador** y mantenga el flujo fuera de las entidades.
3. Use **Creador** para decidir quién construye `Pago` y `Factura`.
4. Encapsule base de datos, tarifas, pasarelas y notificaciones usando **Indirección** y **Variaciones protegidas**.
5. Sustituya un `switch` de tipos de cuenta por **Polimorfismo**.
6. Separe un servicio con demasiadas responsabilidades en clases de **Alta cohesión** y use **Fabricación pura** para mapeos.
7. Entregue diagrama de clases, tres pruebas unitarias y una tabla de acoplamientos antes y después.

---

## Clase 08A: DRY, KISS y YAGNI aplicados a pagos

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 4

### Objetivos de aprendizaje

- Reducir duplicación real sin crear abstracciones prematuras.
- Mantener soluciones simples y proporcionales al problema.
- Implementar solo necesidades actuales y registrar extensiones futuras como decisiones pendientes.

### Teoría y ejemplos Java

#### DRY — Don't Repeat Yourself

Cada conocimiento de negocio debe tener una representación autoritativa. DRY no significa eliminar toda repetición textual: dos fragmentos iguales pueden representar reglas distintas.

```java
final class Validaciones { static void requerido(String v){if(v==null||v.isBlank())throw new IllegalArgumentException();} }
// Tres usos: validar Cliente, Cuenta y Factura con la misma regla.
```

```java
interface Tarifario { double obtener(String servicio); }
final class FacturaService { private final Tarifario tarifas; FacturaService(Tarifario t){tarifas=t;} }
// Tres usos: tarifa de agua, energia y gas desde una fuente única.
```

```java
interface Factura { double base(); double impuesto(); }
final class Totales { static double total(Factura f){return f.base()+f.impuesto();} }
// Tres usos: cobro, recibo y reporte usan el mismo total.
```

#### KISS — Keep It Simple

Prefiere el diseño más simple que cumpla las reglas actuales y pueda explicarse. La simplicidad no elimina validaciones necesarias ni controles de seguridad.

```java
final class EstadoFactura { static String estado(boolean pagada){return pagada ? "PAGADA" : "PENDIENTE";} }
// Tres usos: estado de factura, recibo y consulta con una decision directa.
```

```java
final class PagoSimple { boolean aprobado(double saldo, double valor){return valor>0 && saldo>=valor;} }
// Tres usos: pago de agua, energia y gas sin jerarquias innecesarias.
```

```java
record Pago(double valor) {}
final class Pendientes { private final java.util.List<Pago> datos=new java.util.ArrayList<>(); void agregar(Pago p){datos.add(p);} }
// Tres usos: lista de pagos pendientes, aplicados y rechazados con colecciones estándar.
```

#### YAGNI — You Aren't Gonna Need It

No implementes funcionalidades especulativas antes de tener una necesidad comprobada. Se diseña un punto de extensión razonable, pero no se construyen módulos sin requisito.

```java
interface Pasarela { void cobrar(double valor); }
final class PagoActual { private final Pasarela pasarela; PagoActual(Pasarela p){pasarela=p;} }
// Tres usos actuales: PSE, tarjeta y una billetera requerida por el negocio.
```

```java
record FacturaActual(String id, double total, boolean pagada) {}
// Tres usos: guardar datos actuales de agua, energia y gas sin campos hipoteticos.
```

```java
final class ReportePagos { long aprobados(java.util.List<Pago> pagos){return pagos.stream().filter(p->p.valor()>0).count();} }
// Tres usos: contar pagos, sumar valores y filtrar pendientes; sin un motor BI prematuro.
```

### Tres ejemplos Java por principio

```java
// DRY: un mismo conocimiento, una sola implementación.
Validaciones.requerido(cliente.nombre());
Validaciones.requerido(cuenta.id());
Validaciones.requerido(factura.id());
```

```java
// KISS: decisiones directas para tres operaciones del dominio.
estadoFactura.estado(factura.pagada());
pagoSimple.aprobado(cuenta.saldo(), factura.total());
pendientes.agregar(pago);
```

```java
// YAGNI: solo se implementan necesidades confirmadas.
new PagoActual(pse);
new PagoActual(tarjeta);
new PagoActual(billeteraRequerida);
```

### Actividad: DRY, KISS y YAGNI en el sistema de pagos

1. Reciba un código con tres validaciones repetidas de `Cliente`, `Cuenta` y `Factura`. Extraiga solo las reglas idénticas aplicando **DRY**.
2. Simplifique un método con cinco niveles de `if` para decidir si se puede pagar; mantenga explícitas las reglas de saldo, estado y valor.
3. El negocio pide PSE hoy y “tal vez” cripto, cuotas y pagos recurrentes después. Implemente PSE mediante una interfaz y documente las otras solicitudes sin construirlas: aplique **YAGNI**.
4. Compare complejidad ciclomática, número de clases y líneas antes y después.
5. Escriba pruebas para factura pendiente, factura pagada, saldo insuficiente y cliente inexistente.

### Proyecto integrador de cierre de la unidad

Construya un diseño Java del sistema de pagos con `Cliente`, `Cuenta`, `CuentaAhorros`, `CuentaCorriente`, `Factura` y `Pago`. Incluya:

- Diagrama de clases y diagrama de secuencia para “pagar factura”.
- Una aplicación de SOLID, tres decisiones GRASP, dos patrones GoF y una mejora DRY/KISS/YAGNI.
- Repositorios y pasarelas como interfaces, implementaciones en memoria para pruebas y validación de errores.
- Una tabla de trazabilidad: requisito, patrón o principio aplicado, clase afectada y prueba que lo verifica.

---

# UNIDAD 2. Modelado, documentación y evaluación arquitectónica

---

---

## Clase 05: Domain-Driven Design, bounded contexts y monolito modular

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 3

### Objetivos de aprendizaje

- Explicar el valor de Domain-Driven Design (DDD) en decisiones arquitectónicas.
- Identificar bounded contexts y relaciones entre contextos.
- Diseñar un monolito modular como alternativa pragmática a microservicios prematuros.
- Aplicar reglas de dependencia entre módulos de dominio.

---

### Contenido teórico (50 minutos)

#### 1. DDD como herramienta arquitectónica

DDD no es solo una técnica de modelado de clases. En arquitectura ayuda a decidir límites de módulos, servicios, equipos y contratos.

**Conceptos principales:**
- **Dominio:** área de conocimiento del negocio.
- **Subdominio core:** lo que diferencia estratégicamente al sistema.
- **Subdominio de soporte:** necesario para operar, pero no diferencial.
- **Subdominio genérico:** problema común que puede resolverse con software estándar.
- **Lenguaje ubicuo:** vocabulario compartido entre negocio y desarrollo.

#### 2. Bounded contexts

Un bounded context define dónde un modelo tiene significado preciso. La misma palabra puede significar cosas distintas según el contexto.

**Ejemplo — universidad:**

| Contexto | Concepto "estudiante" significa |
|---|---|
| Admisiones | Aspirante en proceso de ingreso |
| Matrícula | Persona inscrita en asignaturas |
| Financiera | Responsable de pagos y cartera |
| Bienestar | Usuario de servicios de acompañamiento |

#### 3. Context mapping

Relaciones típicas entre contextos:
- **Customer/Supplier:** un contexto depende del contrato de otro.
- **Conformist:** un contexto adopta el modelo de otro sin poder cambiarlo.
- **Anti-corruption Layer:** traduce modelos para evitar contaminación conceptual.
- **Shared Kernel:** dos contextos comparten una parte pequeña del modelo.

#### 4. Monolito modular

Un monolito modular puede ser una arquitectura excelente cuando el equipo es pequeño o el dominio aún cambia rápido.

```text
src/
  admisiones/
    api.py
    dominio.py
    repositorio.py
  matricula/
    api.py
    dominio.py
    repositorio.py
  financiera/
    api.py
    dominio.py
    repositorio.py
  shared/
    eventos.py
```

Regla: los módulos no acceden directamente a la base de datos ni a clases internas de otros módulos. Se comunican por interfaces públicas o eventos de dominio.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Event storming ligero (10 min)**

Sistema de matrícula universitaria. Identificar eventos de dominio: `EstudianteAdmitido`, `AsignaturaInscrita`, `PagoRegistrado`, `CupoAgotado`. Agruparlos en bounded contexts.

**Actividad 2: Context map (15 min)**

Dibujar relaciones entre `Admisiones`, `Matrícula`, `Financiera` y `Bienestar`. Marcar dónde usar Anti-corruption Layer y dónde exponer APIs públicas.

#### Ejercicio de código — detectar violaciones entre bounded contexts (35 minutos)

**Problema:** un monolito modular debe impedir que un contexto importe archivos internos de otro contexto.

**Paso 1 — Crea `verificar_contextos.py`:**

```python
from dataclasses import dataclass


@dataclass
class Importacion:
  archivo: str
  importado: str


IMPORTACIONES = [
  Importacion("src/matricula/api.py", "src/matricula/dominio.py"),
  Importacion("src/matricula/api.py", "src/admisiones/public.py"),
  Importacion("src/matricula/dominio.py", "src/financiera/repositorio.py"),
  Importacion("src/financiera/api.py", "src/shared/eventos.py"),
]


def contexto(ruta: str) -> str:
  partes = ruta.split("/")
  return partes[1] if len(partes) > 1 and partes[0] == "src" else "externo"


def es_api_publica(ruta: str) -> bool:
  return ruta.endswith("/public.py") or "/shared/" in ruta


def detectar_violaciones(importaciones: list[Importacion]) -> list[str]:
  violaciones = []
  for item in importaciones:
    origen = contexto(item.archivo)
    destino = contexto(item.importado)
    if origen != destino and destino != "shared" and not es_api_publica(item.importado):
      violaciones.append(
        f"{item.archivo} importa {item.importado}: cruza el límite de {destino}"
      )
  return violaciones


if __name__ == "__main__":
  print("=== Violaciones de bounded contexts ===")
  for violacion in detectar_violaciones(IMPORTACIONES):
    print(f"- {violacion}")
```

**Paso 2 — Ejecuta:**

```bash
python verificar_contextos.py
```

**Extensión:** agrega una regla para permitir dependencias solo en una dirección: `admisiones -> matricula -> financiera` no es igual a `financiera -> matricula`.

**Preguntas de cierre:**
- ¿Cuándo un bounded context merece convertirse en microservicio?
- ¿Qué señales indican que el monolito modular se está erosionando?
- ¿Qué diferencia hay entre una dependencia de dominio y una dependencia técnica?

---

---

## Clase 06: Documentación arquitectónica — ISO 42010, 4+1 y C4

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 3

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

---

## Clase 07: ADR, arquitectura como código e IA como revisora

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 4

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

#### Ejercicio de código — Clase 07: Validador de ADR en formato MADR (25 minutos)

**Problema:** tu equipo decide usar ADRs para documentar decisiones arquitectónicas, pero nadie verifica que estén bien escritas. Vamos a construir un script que valida si un ADR en Markdown tiene todas las secciones requeridas del formato MADR.

**Paso 1 — Crea el archivo `validar_adr.py`:**

```python
import re
import sys
from pathlib import Path

# Secciones obligatorias del formato MADR (Markdown Architecture Decision Records)
SECCIONES_OBLIGATORIAS = [
    "# ADR-",               # Título con número
    "## Estado",            # Estado: propuesto | aceptado | obsoleto | reemplazado
    "## Contexto",          # Descripción del problema y por qué se necesita una decisión
    "## Opciones consideradas",  # Lista de alternativas
    "## Decisión",          # La opción elegida y por qué
    "## Consecuencias",     # Efectos positivos y negativos de la decisión
]

ESTADOS_VALIDOS = {"propuesto", "aceptado", "obsoleto", "reemplazado", "deprecated"}


def validar_adr(contenido: str, nombre_archivo: str) -> list[str]:
    """Retorna lista de problemas encontrados. Lista vacía = ADR válido."""
    problemas = []

    for seccion in SECCIONES_OBLIGATORIAS:
        if seccion.lower() not in contenido.lower():
            problemas.append(f"  ✘ Falta la sección: '{seccion}'")

    # Verificar que el estado sea uno de los valores esperados
    match = re.search(r"##\s*Estado\s*\n+(.+)", contenido, re.IGNORECASE)
    if match:
        estado = match.group(1).strip().lower()
        if not any(v in estado for v in ESTADOS_VALIDOS):
            problemas.append(f"  ⚠ Estado inválido: '{estado}'. Valores válidos: {ESTADOS_VALIDOS}")

    # Verificar que tenga al menos 2 opciones consideradas
    opciones = re.findall(r"^[-*] .+", contenido, re.MULTILINE)
    if len(opciones) < 2:
        problemas.append("  ⚠ Se recomienda al menos 2 opciones consideradas (solo se encontró 1 o ninguna).")

    return problemas


def validar_archivo(ruta: str):
    path = Path(ruta)
    if not path.exists():
        print(f"❌ Archivo no encontrado: {ruta}")
        return

    contenido = path.read_text(encoding="utf-8")
    problemas = validar_adr(contenido, path.name)

    if not problemas:
        print(f"✅ {path.name} — ADR válido")
    else:
        print(f"❌ {path.name} — {len(problemas)} problema(s):")
        for p in problemas:
            print(p)


# ---------------------------------------------------------------------------
# Prueba con contenido en memoria (sin archivos reales)
# ---------------------------------------------------------------------------
ADR_COMPLETO = """
# ADR-001: Usar PostgreSQL como base de datos principal

## Estado
Aceptado

## Contexto
Necesitamos una base de datos relacional para el catálogo de libros y préstamos.
Los datos tienen estructura fija y relaciones claras entre entidades.

## Opciones consideradas
- PostgreSQL: ACID compliant, código abierto, extensible
- MongoDB: flexible para esquemas variables, pero nuestros datos son relacionales
- MySQL: similar a PostgreSQL pero con menos características avanzadas

## Decisión
Elegimos PostgreSQL porque nuestros datos son relacionales (préstamos, estudiantes, libros)
y necesitamos transacciones ACID para garantizar consistencia.

## Consecuencias
- Positivo: transacciones confiables, joins eficientes, amplia documentación
- Negativo: más complejo de escalar horizontalmente que MongoDB
- Neutral: el equipo ya conoce SQL, curva de aprendizaje mínima
"""

ADR_INCOMPLETO = """
# ADR-002: Elegir framework frontend

## Contexto
Necesitamos un framework para la interfaz de usuario.

## Decisión
Usaremos React.
"""

print("=" * 55)
print("Validando ADRs de ejemplo\n")

for nombre, contenido in [("adr-001-completo.md", ADR_COMPLETO),
                           ("adr-002-incompleto.md", ADR_INCOMPLETO)]:
    problemas = validar_adr(contenido, nombre)
    if not problemas:
        print(f"✅ {nombre} — ADR válido")
    else:
        print(f"❌ {nombre} — {len(problemas)} problema(s):")
        for p in problemas:
            print(p)
    print()

print("=" * 55)
print("Uso con archivo real: python validar_adr.py mi-adr.md")
```

**Paso 2 — Ejecuta el script:**
```bash
python validar_adr.py
```

**Salida esperada:**
```
=======================================================
Validando ADRs de ejemplo

✅ adr-001-completo.md — ADR válido

❌ adr-002-incompleto.md — 3 problema(s):
  ✘ Falta la sección: '## Estado'
  ✘ Falta la sección: '## Opciones consideradas'
  ✘ Falta la sección: '## Consecuencias'
  ⚠ Se recomienda al menos 2 opciones consideradas
```

**Paso 3 — Escribe tu propio ADR y valídalo:**
1. Crea un archivo `adr-003-mi-decision.md` con el ADR del Ejercicio de esta clase (MongoDB vs. PostgreSQL).
2. Ejecuta: `python validar_adr.py adr-003-mi-decision.md`
3. Corrige cualquier problema que detecte el script.

**Paso 4 — Integración en CI (opcional avanzado):**
```yaml
# .github/workflows/validar-adrs.yml
name: Validar ADRs
on: [push]
jobs:
  validar:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - run: python scripts/validar_adr.py docs/adr/*.md
```

**Preguntas de cierre:**
- ¿Qué problemas que NO puede detectar el script (validación de contenido vs. validación de estructura)?
- ¿Cuándo es mejor un ADR largo y detallado vs. uno corto y directo?
- ¿Qué sección del ADR es la más difícil de escribir bien? ¿Por qué?

---

## Clase 08: Attribute-Driven Design (ADD)

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

---

## Clase 09: Árbol de utilidad, sensitivity points y ATAM simplificado

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 5

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

---

# UNIDAD 3. Arquitecturas distribuidas, seguridad y plataforma cloud-native

---

---

## Clase 10: Arquitectura de datos, consistencia distribuida y eventos

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 5

### Objetivos de aprendizaje

- Comparar consistencia fuerte, consistencia eventual y modelos híbridos.
- Diseñar transacciones distribuidas usando Saga y Outbox Pattern.
- Identificar cuándo usar CQRS o Event Sourcing.
- Evaluar el impacto arquitectónico de elegir SQL, NoSQL o event streaming.

---

### Contenido teórico (50 minutos)

#### 1. Datos como decisión arquitectónica

La base de datos no es un detalle de implementación cuando determina consistencia, escalabilidad, latencia, recuperación y forma del dominio.

#### 2. Consistencia distribuida

| Modelo | Ventaja | Costo |
|---|---|---|
| ACID local | Simplicidad y consistencia fuerte | Menor flexibilidad entre servicios |
| Saga | Escala entre servicios | Requiere compensaciones |
| Eventual consistency | Alta disponibilidad | Lecturas temporalmente desactualizadas |
| Event sourcing | Auditoría completa | Mayor complejidad operacional |

#### 3. Saga

Una saga divide una transacción de negocio en pasos locales con acciones compensatorias.

```text
Crear orden -> Reservar inventario -> Cobrar pago -> Confirmar orden
     si falla pago: liberar inventario y cancelar orden
```

#### 4. Outbox Pattern

Problema: guardar en BD y publicar evento no es atómico si se hacen en dos operaciones separadas.

Solución: guardar el cambio y el evento pendiente en la misma transacción local. Un publicador lee la tabla outbox y envía eventos.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Diseñar una saga (12 min)**

Sistema de e-commerce. Diseñar la saga para crear pedido, reservar inventario, cobrar y despachar. Incluir compensaciones.

**Actividad 2: Elegir modelo de datos (13 min)**

Comparar PostgreSQL, DynamoDB y Kafka para auditoría de pagos. Justificar usando consistencia, costo, operación y consultas necesarias.

#### Ejercicio de código — outbox pattern en memoria (35 minutos)

**Problema:** simular una transacción local que guarda una orden y registra el evento pendiente para publicación.

**Paso 1 — Crea `outbox_demo.py`:**

```python
from dataclasses import dataclass, asdict
from uuid import uuid4


@dataclass
class Orden:
  id: str
  cliente: str
  total: float
  estado: str


@dataclass
class EventoOutbox:
  id: str
  tipo: str
  payload: dict
  publicado: bool = False


ordenes: dict[str, Orden] = {}
outbox: list[EventoOutbox] = []


def crear_orden(cliente: str, total: float) -> Orden:
  orden = Orden(id=str(uuid4()), cliente=cliente, total=total, estado="CREADA")
  evento = EventoOutbox(
    id=str(uuid4()),
    tipo="OrdenCreada",
    payload=asdict(orden),
  )
  ordenes[orden.id] = orden
  outbox.append(evento)
  return orden


def publicar_eventos_pendientes() -> None:
  for evento in outbox:
    if not evento.publicado:
      print(f"Publicando {evento.tipo}: {evento.payload}")
      evento.publicado = True


if __name__ == "__main__":
  orden = crear_orden("cliente-123", 250000)
  print(f"Orden guardada: {orden.id}")
  print(f"Eventos pendientes: {sum(not e.publicado for e in outbox)}")
  publicar_eventos_pendientes()
  print(f"Eventos pendientes: {sum(not e.publicado for e in outbox)}")
```

**Extensión:** agrega reintentos al publicador y una lista `dead_letter` para eventos que fallen 3 veces.

**Preguntas de cierre:**
- ¿Qué problema resuelve Outbox frente a publicar directamente a Kafka o RabbitMQ?
- ¿Cuándo una saga coreografiada se vuelve difícil de entender?
- ¿Qué indicadores muestran problemas de consistencia eventual?

---

---

## Clase 11: Comunicación síncrona, asíncrona, API Gateway y colas

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 6

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

---

## Clase 12: Arquitectura de seguridad — threat modeling, Zero Trust y controles

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 6

### Objetivos de aprendizaje

- Incorporar seguridad como atributo arquitectónico desde el diseño.
- Aplicar STRIDE para modelar amenazas.
- Definir controles arquitectónicos para autenticación, autorización, auditoría y secretos.
- Diseñar una postura Zero Trust básica para servicios internos.

---

### Contenido teórico (50 minutos)

#### 1. Seguridad como arquitectura

La seguridad no se agrega al final. Decisiones como identidad, segmentación de red, gestión de secretos, cifrado y auditoría cambian la estructura del sistema.

#### 2. STRIDE

| Amenaza | Pregunta guía | Control típico |
|---|---|---|
| Spoofing | ¿Alguien puede hacerse pasar por otro? | MFA, OAuth2, mTLS |
| Tampering | ¿Puede alterar datos o mensajes? | Firmas, hashes, integridad |
| Repudiation | ¿Puede negar una acción? | Audit logs inmutables |
| Information disclosure | ¿Puede ver datos no autorizados? | Cifrado, RBAC, masking |
| Denial of service | ¿Puede degradar el sistema? | Rate limit, WAF, quotas |
| Elevation of privilege | ¿Puede obtener más permisos? | Least privilege, ABAC |

#### 3. Zero Trust

Principios:
1. Verificar explícitamente cada solicitud.
2. Usar privilegio mínimo.
3. Asumir brecha: segmentar y monitorear.

```text
Cliente -> API Gateway -> Servicio A -> Servicio B
       JWT validado   mTLS + scope   mTLS + policy
```

#### 4. Controles arquitectónicos mínimos

- Autenticación centralizada.
- Autorización por scopes o políticas.
- Secretos fuera del código.
- Cifrado en tránsito y en reposo.
- Auditoría de acciones críticas.
- Rate limiting por usuario, IP o token.

---

### Actividades prácticas (25 minutos)

**Actividad 1: DFD y amenazas (12 min)**

Dibujar un Data Flow Diagram simple para un sistema de pagos. Marcar boundaries de confianza: internet, red interna, base de datos y proveedor externo.

**Actividad 2: Controles por amenaza (13 min)**

Para cada amenaza STRIDE identificada, seleccionar un control arquitectónico y explicar el trade-off de costo, latencia o complejidad.

#### Ejercicio de código — analizador simple de amenazas STRIDE (35 minutos)

**Problema:** dado un flujo entre componentes, genera amenazas y controles recomendados.

**Paso 1 — Crea `threat_model.py`:**

```python
from dataclasses import dataclass


@dataclass
class Flujo:
  origen: str
  destino: str
  protocolo: str
  datos_sensibles: bool
  autenticado: bool


FLUJOS = [
  Flujo("MobileApp", "APIGateway", "HTTPS", True, True),
  Flujo("APIGateway", "PaymentService", "HTTP", True, True),
  Flujo("PaymentService", "FraudService", "HTTP", True, False),
  Flujo("PaymentService", "AuditLog", "HTTPS", True, True),
]


def evaluar_flujo(flujo: Flujo) -> list[str]:
  hallazgos = []
  if flujo.datos_sensibles and flujo.protocolo != "HTTPS":
    hallazgos.append("Information disclosure: usar TLS/mTLS para datos sensibles")
  if not flujo.autenticado:
    hallazgos.append("Spoofing: autenticar origen con JWT, mTLS o firma")
  if flujo.destino.lower().endswith("service"):
    hallazgos.append("Elevation of privilege: validar scopes por operación")
  return hallazgos


if __name__ == "__main__":
  for flujo in FLUJOS:
    print(f"\n{flujo.origen} -> {flujo.destino}")
    for hallazgo in evaluar_flujo(flujo):
      print(f"- {hallazgo}")
```

**Extensión:** agrega una regla de DoS que sugiera rate limiting para flujos expuestos a internet.

**Preguntas de cierre:**
- ¿Qué amenazas aparecen por introducir un API Gateway?
- ¿Por qué mTLS entre servicios no reemplaza la autorización?
- ¿Qué controles deben quedar documentados en ADR?

---

---

## Clase 13: Principios cloud-native y Twelve-Factor App

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 7

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

#### Ejercicio de código — Clase 13: Aplicación con los 12 factores en Python (30 minutos)

**Problema:** el código legacy siguiente viola varios factores de la Twelve-Factor App. Tu tarea es identificar los problemas y corregirlos.

**Paso 1 — Instala las dependencias:**
```bash
pip install python-dotenv
```

**Paso 2 — Código con violaciones (`app_legacy.py`):**

```python
# ❌ CÓDIGO CON VIOLACIONES — identifica cuáles son antes de continuar

import psycopg2
import logging

# Factor III violado: credenciales en el código
DB_HOST     = "prod-db.empresa.com"
DB_USER     = "admin"
DB_PASSWORD = "SuperS3creta!"
DB_NAME     = "biblioteca_prod"

# Factor XI violado: logs a archivo local en vez de stdout
logging.basicConfig(filename="/var/log/app.log", level=logging.INFO)

def buscar_libros(titulo: str):
    # Factor IV violado: conexión nueva en cada llamada (sin pool, sin backing service configurable)
    conn = psycopg2.connect(
        host=DB_HOST, user=DB_USER, password=DB_PASSWORD, dbname=DB_NAME
    )
    cursor = conn.cursor()
    cursor.execute(f"SELECT * FROM libros WHERE titulo LIKE '%{titulo}%'")  # ⚠ SQL injection
    resultados = cursor.fetchall()
    conn.close()  # no hay manejo de errores ni context manager
    return resultados

# Factor XV violado (no es un factor oficial, pero es práctica incorrecta):
# El puerto está hardcodeado
if __name__ == "__main__":
    import flask
    app = flask.Flask(__name__)
    app.run(host="0.0.0.0", port=5000)  # Puerto hardcodeado
```

**Paso 3 — Versión corregida (`app_12factor.py`):**

```python
# ✅ CÓDIGO CORREGIDO aplicando Twelve-Factor App

import os
import logging
from dotenv import load_dotenv

# Factor III: Cargar configuración desde variables de entorno
load_dotenv()   # Lee .env en desarrollo; en producción las variables ya están definidas

DB_HOST     = os.environ["DB_HOST"]      # Falla explícitamente si no está configurado
DB_USER     = os.environ["DB_USER"]
DB_PASSWORD = os.environ["DB_PASSWORD"]
DB_NAME     = os.environ["DB_NAME"]
PORT        = int(os.environ.get("PORT", "8080"))

# Factor XI: Logs a stdout (sin archivos, sin rutas hardcodeadas)
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
    handlers=[logging.StreamHandler()]   # stdout
)
logger = logging.getLogger(__name__)

def get_connection():
    """Factor IV: la conexión es un backing service intercambiable."""
    import psycopg2
    return psycopg2.connect(
        host=DB_HOST, user=DB_USER, password=DB_PASSWORD, dbname=DB_NAME
    )

def buscar_libros(titulo: str) -> list:
    """Consulta parametrizada: evita SQL injection."""
    with get_connection() as conn:
        with conn.cursor() as cursor:
            cursor.execute(
                "SELECT id, titulo, autor FROM libros WHERE titulo ILIKE %s",
                (f"%{titulo}%",)   # Parámetro separado del SQL
            )
            resultados = cursor.fetchall()
    logger.info("Búsqueda completada: '%s' — %d resultados", titulo, len(resultados))
    return resultados

if __name__ == "__main__":
    from flask import Flask, jsonify, request
    app = Flask(__name__)

    @app.route("/libros")
    def libros():
        titulo = request.args.get("titulo", "")
        return jsonify(buscar_libros(titulo))

    # Factor VII: puerto desde variable de entorno
    app.run(host="0.0.0.0", port=PORT)
```

**Paso 4 — Crea el archivo `.env` (solo para desarrollo local):**
```bash
# .env  — NO subir a git (agregar al .gitignore)
DB_HOST=localhost
DB_USER=dev_user
DB_PASSWORD=dev_password
DB_NAME=biblioteca_dev
PORT=8080
```

**Paso 5 — Agrega `.env` al `.gitignore`:**
```bash
echo ".env" >> .gitignore
```

**Paso 6 — Identifica los factores en cada corrección:**

| Violación en el legacy | Factor violado | Corrección aplicada |
|---|---|---|
| Credenciales en el código | Factor III (Config) | `os.environ["DB_HOST"]` con `.env` |
| Log a archivo local | Factor XI (Logs) | `StreamHandler()` → stdout |
| Puerto hardcodeado | Factor VII (Port binding) | `os.environ.get("PORT", "8080")` |
| SQL con f-string | No es un factor, pero es OWASP A03 | Parámetros `%s` separados |

**Preguntas de cierre:**
- ¿Qué pasa si alguien sube el archivo `.env` al repositorio por error? ¿Cómo lo previenes automáticamente?
- ¿Por qué los logs deben ir a stdout y no a un archivo? ¿Quién recoge esos logs en producción?
- Nombra 3 backing services típicos de una app y cómo se configurarían con variables de entorno.

---

---

## Clase 14: Docker y Docker Compose en arquitecturas reales

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 7

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

---

## Clase 15: Introducción a Kubernetes y orquestación de contenedores

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 8

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

# UNIDAD 4. Operación, resiliencia, validación y gobernanza

---

---

## Clase 16: DevOps avanzado, CI/CD, GitOps e infraestructura como código

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 8

### Objetivos de aprendizaje

- Diseñar pipelines CI/CD que protejan decisiones arquitectónicas.
- Explicar GitOps como modelo operativo declarativo.
- Escribir infraestructura como código mínima y revisable.
- Incorporar validaciones automáticas de seguridad, pruebas y arquitectura.

---

### Contenido teórico (50 minutos)

#### 1. Pipeline como parte de la arquitectura

El pipeline define cómo cambia el sistema. Si no hay pruebas, escaneo, despliegue repetible ni rollback, la arquitectura real incluye riesgo operacional alto.

#### 2. CI/CD recomendado

```text
Commit -> Lint -> Tests -> Build image -> Scan -> Push registry -> Deploy staging -> Smoke test -> Deploy prod
```

#### 3. GitOps

Git es la fuente de verdad del estado deseado. Un controlador sincroniza el cluster con lo declarado.

Ventajas: auditoría, rollback por commit, revisión por pull request, menor drift manual.

#### 4. Infraestructura como código

Buenas prácticas:
- Módulos pequeños.
- Variables explícitas.
- Estado remoto.
- Plan revisado en PR.
- Secretos gestionados fuera del repositorio.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Diseñar pipeline (12 min)**

Definir etapas obligatorias para un servicio de pagos: pruebas unitarias, análisis estático, build de imagen, escaneo, despliegue staging, smoke tests y aprobación para producción.

**Actividad 2: Política de despliegue (13 min)**

Comparar rolling deployment, blue/green y canary. Elegir uno para un sistema regulado y justificar rollback, auditoría y riesgo.

#### Ejercicio práctico — pipeline CI con validación arquitectónica (35 minutos)

**Problema:** crear un pipeline que ejecute pruebas, valide ADRs y construya imagen Docker.

**Paso 1 — Crea `.github/workflows/arquitectura-ci.yml`:**

```yaml
name: Arquitectura CI

on:
  pull_request:
  push:
    branches: [main]

jobs:
  validar:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-python@v5
        with:
          python-version: '3.11'
      - name: Ejecutar pruebas
        run: python -m pytest tests
      - name: Validar ADRs
        run: python scripts/validar_adr.py docs/adr/*.md
      - name: Construir imagen
        run: docker build -t arquitectura-demo:${{ github.sha }} .
```

**Extensión:** agrega un paso de escaneo con Trivy o Snyk y una política que falle si hay vulnerabilidades críticas.

**Preguntas de cierre:**
- ¿Qué decisiones arquitectónicas puede proteger un pipeline?
- ¿Qué diferencia hay entre CI/CD tradicional y GitOps?
- ¿Por qué el rollback debe diseñarse antes del incidente?

---

---

## Clase 17: Patrones de resiliencia: timeout, retry, circuit breaker, bulkhead

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 9

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

#### Ejercicio de código — Clase 17: Implementar un Circuit Breaker desde cero en Python (35 minutos)

**Problema:** tienes un microservicio de pagos que llama a una API externa (Stripe). Si Stripe está caído, tu servicio no debe seguir intentando llamadas que van a fallar — eso desperdicia recursos y empeora el tiempo de respuesta. El **Circuit Breaker** resuelve esto.

**Los tres estados del circuito:**
```
CLOSED ──(umbral de errores superado)──► OPEN
OPEN   ──(timeout de espera expirado)──► HALF-OPEN
HALF-OPEN ──(llamada exitosa)──► CLOSED
HALF-OPEN ──(llamada falla)──► OPEN
```

**Paso 1 — Crea el archivo `circuit_breaker.py`:**

```python
import time
import random
from enum import Enum, auto
from dataclasses import dataclass, field

class Estado(Enum):
    CLOSED    = auto()   # Funcionando normalmente
    OPEN      = auto()   # Cortado: rechaza llamadas sin intentar
    HALF_OPEN = auto()   # Prueba: deja pasar una llamada para ver si el servicio se recuperó

@dataclass
class CircuitBreaker:
    nombre: str
    umbral_errores: int = 3        # Cuántos errores seguidos abren el circuito
    timeout_open: float = 10.0     # Segundos en OPEN antes de pasar a HALF-OPEN

    _estado: Estado = field(default=Estado.CLOSED, init=False, repr=False)
    _errores_consecutivos: int = field(default=0, init=False, repr=False)
    _tiempo_apertura: float = field(default=0.0, init=False, repr=False)

    @property
    def estado(self) -> Estado:
        # Verificar si el timeout OPEN ya venció → pasar a HALF-OPEN
        if self._estado == Estado.OPEN:
            if time.monotonic() - self._tiempo_apertura >= self.timeout_open:
                print(f"  [{self.nombre}] Timeout expirado → HALF-OPEN (probando recuperación)")
                self._estado = Estado.HALF_OPEN
        return self._estado

    def llamar(self, funcion, *args, **kwargs):
        """Intenta ejecutar 'funcion'. Administra el estado del circuito."""
        estado_actual = self.estado  # Puede actualizar a HALF-OPEN si el timeout venció

        if estado_actual == Estado.OPEN:
            raise RuntimeError(f"[{self.nombre}] Circuito ABIERTO — llamada rechazada sin intentar")

        try:
            resultado = funcion(*args, **kwargs)
            self._en_exito()
            return resultado
        except Exception as e:
            self._en_fallo()
            raise

    def _en_exito(self):
        if self._estado == Estado.HALF_OPEN:
            print(f"  [{self.nombre}] Llamada exitosa en HALF-OPEN → volviendo a CLOSED")
        self._estado = Estado.CLOSED
        self._errores_consecutivos = 0

    def _en_fallo(self):
        self._errores_consecutivos += 1
        print(f"  [{self.nombre}] Fallo #{self._errores_consecutivos}/{self.umbral_errores}")
        if self._errores_consecutivos >= self.umbral_errores:
            self._estado = Estado.OPEN
            self._tiempo_apertura = time.monotonic()
            print(f"  [{self.nombre}] ⚡ Circuito ABIERTO — demasiados errores")

    def __str__(self):
        return f"CircuitBreaker({self.nombre}, estado={self.estado.name}, errores={self._errores_consecutivos})"


# ---------------------------------------------------------------------------
# Simulación de llamadas a un servicio externo (Stripe)
# ---------------------------------------------------------------------------

def llamar_stripe(probabilidad_fallo: float = 0.0) -> dict:
    """Simula la API de Stripe. Falla con la probabilidad dada."""
    if random.random() < probabilidad_fallo:
        raise ConnectionError("Stripe no disponible (timeout)")
    return {"status": "ok", "charge_id": f"ch_{random.randint(10000, 99999)}"}


def procesar_pago(cb: CircuitBreaker, monto: float, prob_fallo: float) -> str:
    try:
        resultado = cb.llamar(llamar_stripe, probabilidad_fallo=prob_fallo)
        return f"✅ Pago de ${monto} aprobado — {resultado['charge_id']}"
    except RuntimeError as e:
        return f"🚫 {e} — devolviendo fallback: 'intente más tarde'"
    except ConnectionError as e:
        return f"❌ Error de red: {e}"


# ---------------------------------------------------------------------------
# Escenario de prueba
# ---------------------------------------------------------------------------
if __name__ == "__main__":
    random.seed(42)
    cb = CircuitBreaker(nombre="stripe", umbral_errores=3, timeout_open=5.0)

    print("=== Fase 1: servicio degradado (70% de fallos) ===")
    for i in range(6):
        msg = procesar_pago(cb, monto=100 * (i + 1), prob_fallo=0.7)
        print(f"  Intento {i+1}: {msg}")
        print(f"  Estado: {cb}")

    print("\n=== Fase 2: esperando recuperación (5 segundos) ===")
    time.sleep(5.1)   # Esperar que el timeout OPEN expire

    print("\n=== Fase 3: servicio recuperado (0% de fallos) ===")
    for i in range(3):
        msg = procesar_pago(cb, monto=500, prob_fallo=0.0)
        print(f"  Intento {i+1}: {msg}")
        print(f"  Estado: {cb}")
```

**Paso 2 — Ejecuta el script:**
```bash
python circuit_breaker.py
```

**Salida esperada:**
```
=== Fase 1: servicio degradado (70% de fallos) ===
  Intento 1: ❌ Error de red: Stripe no disponible (timeout)
  [stripe] Fallo #1/3
  ...
  [stripe] ⚡ Circuito ABIERTO — demasiados errores
  Intento 4: 🚫 [stripe] Circuito ABIERTO — llamada rechazada sin intentar

=== Fase 3: servicio recuperado (0% de fallos) ===
  [stripe] Timeout expirado → HALF-OPEN (probando recuperación)
  [stripe] Llamada exitosa en HALF-OPEN → volviendo a CLOSED
  Intento 1: ✅ Pago de $500 aprobado — ch_XXXXX
```

**Paso 3 — Extiende el ejercicio:**
1. Agrega un contador de llamadas rechazadas en estado OPEN (métrica para monitoreo).
2. Implementa el patrón **Retry con backoff exponencial**: 1s, 2s, 4s entre reintentos antes de abrir el circuito.
3. Modifica el código para tener **dos circuit breakers independientes**: uno para Stripe y otro para PayPal. Prueba que el fallo de uno no afecta al otro.

**Preguntas de cierre:**
- ¿Qué diferencia hay entre un Circuit Breaker y simplemente poner un `try/except`?
- ¿Por qué el estado HALF-OPEN es necesario? ¿Qué pasaría sin él?
- En un sistema de microservicios real, ¿dónde viviría el Circuit Breaker: en el cliente, en el servidor, o en el API Gateway?

---

---

## Clase 18: Estimación de capacidad y topología de despliegue

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 9

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

---

## Clase 19: Pruebas de carga y observabilidad básica

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 10

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

## Clase 20: Gobernanza arquitectónica, fitness functions y evolución

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 10

### Objetivos de aprendizaje

- Diseñar mecanismos ligeros de gobernanza arquitectónica.
- Implementar fitness functions para verificar reglas de arquitectura.
- Medir erosión arquitectónica con indicadores técnicos.
- Definir un proceso de evolución basado en ADRs y revisiones periódicas.

---

### Contenido teórico (50 minutos)

#### 1. Gobernanza sin burocracia

Gobernar arquitectura no significa crear comités lentos. Significa definir reglas explícitas, automatizar verificaciones y revisar decisiones importantes.

#### 2. Fitness functions

Una fitness function es una prueba automatizada que verifica una propiedad arquitectónica.

Ejemplos:
- Ningún módulo `ui` importa directamente `repository`.
- Todo endpoint público tiene autenticación.
- Ningún Dockerfile usa `latest`.
- P95 de un endpoint debe ser menor a 500 ms en prueba de carga.

#### 3. Indicadores de erosión

- Dependencias cíclicas.
- Módulos con demasiadas responsabilidades.
- Aumento de acoplamiento entre servicios.
- ADRs obsoletos frente al código.
- Excepciones manuales repetidas.

#### 4. Proceso recomendado

1. Decisiones relevantes se documentan en ADR.
2. Las reglas repetibles se convierten en fitness functions.
3. Las excepciones tienen fecha de expiración.
4. La arquitectura se revisa cada iteración o release importante.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Definir fitness functions (12 min)**

Para un sistema de microservicios, escribir 5 reglas verificables automáticamente y clasificarlas por atributo de calidad.

**Actividad 2: Revisión de erosión (13 min)**

Dado un grafo de dependencias, identificar ciclos, dependencias prohibidas y excepciones que requieren ADR.

#### Ejercicio de código — fitness function para Dockerfiles (35 minutos)

**Problema:** validar que los Dockerfiles no usen imágenes `latest` y declaren usuario no-root.

**Paso 1 — Crea `fitness_dockerfile.py`:**

```python
from pathlib import Path


def validar_dockerfile(path: Path) -> list[str]:
  contenido = path.read_text(encoding="utf-8")
  problemas = []
  for linea in contenido.splitlines():
    if linea.strip().startswith("FROM") and ":latest" in linea:
      problemas.append("No usar imágenes con tag latest")
  if "\nUSER " not in f"\n{contenido}":
    problemas.append("Declarar USER no-root en la imagen")
  return problemas


if __name__ == "__main__":
  dockerfiles = list(Path(".").rglob("Dockerfile"))
  if not dockerfiles:
    print("No se encontraron Dockerfiles")
  for dockerfile in dockerfiles:
    problemas = validar_dockerfile(dockerfile)
    if problemas:
      print(f"{dockerfile}:")
      for problema in problemas:
        print(f"- {problema}")
    else:
      print(f"{dockerfile}: OK")
```

**Extensión:** agrega reglas para exigir `HEALTHCHECK` y bloquear secretos como `PASSWORD=` o `API_KEY=` en el Dockerfile.

**Preguntas de cierre:**
- ¿Qué reglas arquitectónicas conviene automatizar?
- ¿Qué riesgos aparecen si toda gobernanza depende de revisiones manuales?
- ¿Cómo se maneja una excepción válida sin debilitar la arquitectura?

---

---

# UNIDAD 5. IA arquitectónica, evolución y modernización

---

---

## Clase 21: IA como componente arquitectónico: RAG, guardrails y fallback

**Duración:** 2 horas | **Unidad:** 5 | **Semana:** 11

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

---

## Clase 22: Modernización de sistemas legacy y migración incremental

**Duración:** 2 horas | **Unidad:** 5 | **Semana:** 11

### Objetivos de aprendizaje

- Diagnosticar riesgos arquitectónicos en sistemas legacy.
- Aplicar patrones de modernización como Strangler Fig, Branch by Abstraction y Anti-corruption Layer.
- Diseñar una migración incremental con bajo riesgo operacional.
- Validar una migración mediante pruebas de contrato y comparación de respuestas.

---

### Contenido teórico (50 minutos)

#### 1. Modernizar no es reescribir todo

Las reescrituras completas suelen fallar porque congelan aprendizaje y duplican complejidad. La modernización incremental reduce riesgo al reemplazar partes verificables.

#### 2. Patrones principales

| Patrón | Uso | Riesgo que reduce |
|---|---|---|
| Strangler Fig | Reemplazar funcionalidades gradualmente | Big bang migration |
| Branch by Abstraction | Cambiar implementación detrás de una interfaz | Cambios masivos simultáneos |
| Anti-corruption Layer | Integrar legacy sin contaminar el nuevo modelo | Acoplamiento conceptual |
| Parallel Run | Ejecutar viejo y nuevo en paralelo | Regresiones invisibles |

#### 3. Ruta de migración típica

1. Identificar capacidad de negocio pequeña.
2. Poner proxy o gateway delante del legacy.
3. Redirigir una ruta al nuevo servicio.
4. Comparar respuestas y métricas.
5. Aumentar tráfico gradualmente.
6. Retirar la funcionalidad vieja.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Mapa de modernización (12 min)**

Para un sistema monolítico de biblioteca, elegir una capacidad pequeña para extraer primero. Justificar por riesgo, dependencia y valor de negocio.

**Actividad 2: Plan de migración (13 min)**

Diseñar un plan de 4 incrementos con criterios de rollback y métricas de éxito.

#### Ejercicio de código — router Strangler Fig (35 minutos)

**Problema:** dirigir algunas rutas al sistema nuevo y mantener las demás en el legacy.

**Paso 1 — Crea `strangler_router.py`:**

```python
from dataclasses import dataclass


@dataclass
class Solicitud:
  metodo: str
  ruta: str
  usuario: str


RUTAS_NUEVAS = {
  "/api/v2/pagos",
  "/api/v2/usuarios/perfil",
}


def enrutar(solicitud: Solicitud) -> str:
  if solicitud.ruta in RUTAS_NUEVAS:
    return f"nuevo-servicio <- {solicitud.metodo} {solicitud.ruta}"
  return f"legacy <- {solicitud.metodo} {solicitud.ruta}"


if __name__ == "__main__":
  solicitudes = [
    Solicitud("POST", "/api/v2/pagos", "ana"),
    Solicitud("GET", "/api/v1/reportes", "luis"),
    Solicitud("GET", "/api/v2/usuarios/perfil", "maria"),
  ]
  for solicitud in solicitudes:
    print(enrutar(solicitud))
```

**Extensión:** agrega una regla de canary release: solo 10% de usuarios van al nuevo servicio para una ruta migrada.

**Preguntas de cierre:**
- ¿Qué parte del legacy conviene migrar primero?
- ¿Cómo se decide cuándo apagar una funcionalidad vieja?
- ¿Qué métricas usarías para probar que la migración no degradó el sistema?

---

---

# UNIDAD 6. Proyecto integrador: grupo de arquitectura

---

---

## Clase 23: Proyecto — Drivers, escenarios, arquitectura candidata y C4

**Duración:** 2 horas | **Unidad:** 6 | **Semana:** 12

### Descripción del proyecto integrador

**Grupos:** 3-4 estudiantes.

**Sistema:** Cada grupo elige sistema de mediana complejidad.

Opciones: Plataforma de pagos P2P, App de salud con telemedicina, Sistema de logística y tracking, Marketplace de servicios profesionales.

**Entregables por clase:**

| Clase | Entregable |
|---|---|
| 23 | Drivers + Árbol de utilidad + C4 Nivel 1 y 2 + ADR inicial |
| 24 | Arquitectura refinada + ADRs + Prototipo contenerizado |
| 25 | Resultados carga + Observabilidad + Análisis de impacto |
| 26 | Defensa técnica individual |

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

---

## Clase 24: Proyecto — Prototipo contenerizado y resiliencia end-to-end

**Duración:** 2 horas | **Unidad:** 6 | **Semana:** 12

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

---

## Clase 25: Proyecto — Pruebas de carga, observabilidad y análisis de impacto

**Duración:** 2 horas | **Unidad:** 6 | **Semana:** 13

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

---

## Clase 26: Defensa técnica individual y autorreferencia final

**Duración:** 2 horas | **Unidad:** 6 | **Semana:** 13

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
*Versión: 1.0 (Completo ampliado: 30 clases, 60 horas)*
*Público: Ingenieros de software, arquitectos de soluciones*
