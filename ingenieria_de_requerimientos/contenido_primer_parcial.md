## Unidad 1. Fundamentos, calidad, elicitación y modelado del dominio

---

### Clase 1 — Introducción a la Ingeniería de Requerimientos

#### Objetivos
- Comprender qué es la IR y por qué es crítica en el desarrollo de software.
- Distinguir los niveles de requisitos y el ciclo de vida de la IR.

#### Contenido teórico

**¿Qué es un requisito?**  
Imagina que quieres construir una casa. Primero le dices al arquitecto: "quiero una casa con varias habitaciones y mucha luz." Eso es informal. Después él lo escribe en los planos: "3 habitaciones, con ventanas de 2m² en el lado norte, piso a techo de 2.8 metros." Eso es formal y verificable.

En software funciona igual:
- **Requerimiento**: lo que el usuario expresa sin tecnicismos (ejemplo: "quiero poder ver mis calificaciones fácilmente").
- **Requisito**: la versión formal, clara y verificable (ejemplo: "el estudiante accede a sus calificaciones en menos de 3 clics, en menos de 2 segundos después de iniciar sesión").

**Los 4 niveles de requisitos (de lo general a lo específico)**

Como una pirámide, cada nivel es más detallado que el anterior:

| Nivel | Quién lo escribe | La pregunta que responde | Ejemplo real |
|---|---|---|---|
| **1️⃣ Negocio** | Rector, Director | "¿Por qué hacemos esto? ¿Cuál es la meta?" | "Queremos que 500 nuevos estudiantes se inscriban este semestre" |
| **2️⃣ Usuarios** | Estudiantes, docentes | "¿Qué necesito que el sistema me permita hacer?" | "Necesito inscribirme en línea sin ir a las oficinas" |
| **3️⃣ Sistema** | Arquitectos | "¿Qué sistemas necesitan trabajar juntos?" | "Debe conectarse con el banco para procesar pagos" |
| **4️⃣ Software** | Programadores | "¿Qué código específico escribo?" | "El botón 'Pagar' envía los datos al servidor" |

**El ciclo de la Ingeniería de Requerimientos**

La IR no es un evento puntual donde "escribes los requisitos y listo." Es un ciclo continuo:

```
1. ELICITACIÓN: ¿Qué necesita el usuario? (Entrevistar, observar)
        ↓
2. ANÁLISIS: ¿Tiene sentido? ¿Es realista? (Revisar, cuestionar)
        ↓
3. ESPECIFICACIÓN: ¿Cómo lo escribo formalmente? (Documentar)
        ↓
4. VALIDACIÓN: ¿Esto es lo que realmente querías? (Mostrar al usuario)
        ↓
5. GESTIÓN: Controlar cambios, trazabilidad, prioridades
        ↑_____________________________________________________↓
        (si el usuario dice "no, yo quería otra cosa")
```

El ciclo es: capturar → entender → escribir → validar → ajustar → repetir si es necesario.

**¿Por qué importa?** Porque un requisito capturado mal al inicio es muy costoso de arreglar después (hasta 100 veces más caro).

**¿Qué va a hacer el sistema y qué no? (Alcance)**

Es muy importante definir los límites: qué está DENTRO de tu sistema y qué está FUERA. Sino, los usuarios te pedirán de todo.

Ejemplo: "Sistema de inscripción en línea"
- ✅ DENTRO: estudiantes se registran, seleccionan cursos, pagan
- ❌ FUERA: procesar pagos internacionales (eso lo hace el banco)
- ❌ FUERA: crear nuevos programas académicos (eso lo hace coordinación)
- ❌ FUERA: auditoría de fraude (lo hace otro sistema)

**¿Cómo crear un diagrama de contexto paso a paso?**

Un diagrama de contexto dibuja tu sistema como una sola caja en el centro, y muestra todo lo que interactúa con él desde afuera. No muestra lo que hay dentro del sistema; solo sus fronteras y conexiones.

**Los 3 elementos que contiene:**

| Elemento | Representación | Descripción |
|---|---|---|
| **El sistema** | Caja central con el nombre | El software que vas a construir |
| **Actores externos** | Elipses o rectángulos alrededor | Personas, sistemas u organizaciones que interactúan con él |
| **Flujos de datos** | Flechas con etiqueta | Información que entra o sale del sistema |

---

**Paso a paso para construirlo:**

**Paso 1 — Nombra tu sistema en el centro**

Pon el nombre de lo que vas a construir en una caja central. Ejemplo: `Sistema de Inscripción en Línea`.

**Paso 2 — Identifica a todos los actores externos**

Hazte estas preguntas:
- ¿Quién usa el sistema directamente? → usuarios humanos
- ¿Qué otros sistemas necesita consultar o notificar? → sistemas externos
- ¿Quién recibe reportes o resultados? → actores receptores
- ¿Quién alimenta datos al sistema? → actores fuente

**Paso 3 — Dibuja los flujos de información**

Para cada actor, pregúntate:
- ¿Qué datos **le manda** al sistema? → flecha entrante (→)
- ¿Qué datos **recibe** del sistema? → flecha saliente (←)
- Las flechas siempre llevan una etiqueta que describe qué dato fluye

**Paso 4 — Verifica los límites**

Todo lo que está dentro de la caja central lo vas a construir tú. Todo lo que está afuera ya existe o es responsabilidad de otro.

---

**Ejemplo completo — Sistema de Inscripción Universitaria en Línea:**

```
                    ┌─────────────────────────────────────┐
  Estudiante ───────▶                                     ◀─── Coordinación Académica
  (solicitud de     │   SISTEMA DE INSCRIPCIÓN EN LÍNEA   │    (catálogo de materias)
   inscripción)     │                                     │
  Estudiante ◀──────│                                     ├───▶ Coordinación Académica
  (confirmación,    │                                     │    (lista de inscriptos)
   horario)         │                                     │
                    │                                     ├───▶ Sistema Bancario
  Docente ─────────▶│                                     │    (solicitud de cobro)
  (disponibilidad   │                                     │
   de horarios)     │                                     ◀─── Sistema Bancario
                    │                                     │    (confirmación de pago)
  Admin ────────────▶                                     │
  (apertura de      │                                     ├───▶ Sistema de Email
   período)         │                                     │    (correos de confirmación)
                    └─────────────────────────────────────┘
```

**Lo que muestra este diagrama:**

| Actor externo | Datos que envía al sistema | Datos que recibe del sistema |
|---|---|---|
| **Estudiante** | Solicitud de inscripción | Confirmación, horario asignado |
| **Docente** | Disponibilidad de horarios | — |
| **Admin** | Apertura y cierre de período | — |
| **Coordinación Académica** | Catálogo de materias | Lista de inscriptos |
| **Sistema Bancario** | Confirmación de pago | Solicitud de cobro |
| **Sistema de Email** | — | Correos de confirmación |

**Lo que NO está en el diagrama (y por qué importa):**
- ❌ No aparece la base de datos → es interna, no es un actor externo
- ❌ No aparece el servidor → es infraestructura, no un actor de negocio
- ❌ No aparece el código → el diagrama es conceptual, no técnico

---

**Errores comunes al hacer el diagrama:**

| Error | Ejemplo | Corrección |
|---|---|---|
| Poner componentes internos como actores | "Base de datos" como elipse externa | La base de datos va dentro del sistema |
| Flechas sin etiqueta | Una flecha vacía entre Estudiante y el sistema | Etiquetar: "solicitud de inscripción" |
| Olvidar actores no humanos | No incluir el sistema de pagos | Incluir todos los sistemas externos que interactúan |
| Demasiado detalle | Mostrar pantallas o pasos internos | Solo fronteras y flujos de datos, nada interno |

---

**Herramientas para dibujarlo:**
- **draw.io** (gratuito, online): app.diagrams.net
- **Lucidchart**: lucidchart.com (plan gratuito limitado)
- **Figma**: figma.com (también sirve para wireframes)
- **A mano**: papel + lápiz es suficiente para borradores iniciales

Herramienta: **diagrama de contexto** (dibuja el sistema como una caja, y sus conexiones con el mundo exterior).

#### Actividades prácticas

Cada grupo elige **uno** de los siguientes escenarios. Todos realizan los mismos pasos sobre dominios distintos.

---

**Ejercicio A — Sistema de Gestión de Citas Médicas**

*Escenario:* Una clínica privada quiere digitalizar la gestión de turnos médicos. Los pacientes deben poder sacar, cancelar y reprogramar citas. Los médicos deben poder ver su agenda diaria. La clínica emite recordatorios automáticos y cobra una seña al reservar.

1. Identifiquen al menos 6 actores externos al sistema (ej: paciente, médico, obra social, sistema de pagos, sistema de email/SMS, laboratorio).
2. Para cada actor, listen qué información **envía** al sistema y qué información **recibe**.
3. Dibujen el diagrama de contexto en draw.io o en papel.
4. Definan al menos 3 elementos que quedan **fuera del alcance** y justifiquen (ej: gestión de historias clínicas, facturación a obras sociales, asignación de quirófanos).
5. Redacten el alcance en una oración: "El sistema gestiona X, pero no gestiona Y."

**Preguntas de reflexión:**
- ¿El laboratorio es un actor externo o parte del sistema? ¿De qué depende la respuesta?
- ¿Qué pasa si el médico y la clínica tienen expectativas distintas sobre quién puede cancelar una cita?

---

**Ejercicio B — Sistema de Gestión de Reservas de Vuelos y Hoteles**

*Escenario:* Una agencia de viajes online permite reservar vuelos y hoteles en una sola plataforma. El sistema debe consultar disponibilidad en tiempo real a aerolíneas y hoteles externos, procesar pagos con tarjeta y enviar itinerarios al viajero por email.

1. Identifiquen al menos 7 actores externos (ej: viajero, aerolínea, hotel, pasarela de pago, sistema de email, agencia reguladora de aviación, proveedor de mapas).
2. Para cada actor, describan los flujos de datos de entrada y salida con etiquetas concretas (ej: "consulta de disponibilidad", "confirmación de reserva", "notificación de cancelación").
3. Dibujen el diagrama de contexto.
4. Identifiquen 3 límites del sistema: qué gestiona la plataforma y qué gestionan los actores externos.
5. Redacten el alcance en una oración: "El sistema gestiona X, pero no gestiona Y."

**Preguntas de reflexión:**
- ¿Cuántos sistemas externos tiene este dominio comparado con el Ejercicio A? ¿Qué implica eso en términos de riesgo e integración?
- ¿Cambiaría el diagrama si la aerolínea también fuera cliente de la plataforma?

---

**Ejercicio C — Sistema de Gestión de Facturación de una Tienda de Productos**

*Escenario:* Una tienda de electrónica quiere digitalizar su proceso de ventas y facturación. Los vendedores registran ventas, el sistema genera facturas electrónicas, descuenta stock automáticamente y reporta al sistema contable. Los clientes pueden solicitar comprobantes por email.

1. Identifiquen al menos 6 actores externos (ej: cliente, vendedor, sistema contable, AFIP/SAT u organismo fiscal, proveedor de stock, sistema de email).
2. Para cada actor, identifiquen los datos que intercambian con el sistema (ej: "datos de la venta", "factura electrónica", "CAE/folio fiscal", "reporte de ventas mensual").
3. Dibujen el diagrama de contexto.
4. Definan 3 elementos fuera del alcance (ej: gestión de proveedores, recursos humanos, logística de envíos).
5. Identifiquen cuál actor tiene el flujo de datos más crítico para el negocio y justifiquen.

**Preguntas de reflexión:**
- ¿El organismo fiscal (AFIP/SAT) es un actor activo o pasivo? ¿Envía datos o solo los recibe?
- ¿Qué sucede si el sistema contable cambia? ¿Cómo afecta al diagrama de contexto?

---

**Ejercicio D — Sistema de Gestión de Notas, Estudiantes, Profesores y Cursos**

*Escenario:* Una universidad quiere un sistema que centralice la gestión académica: inscripción de estudiantes a cursos, registro de notas por parte de los profesores, generación de certificados analíticos y reportes para la dirección académica.

1. Identifiquen al menos 6 actores externos (ej: estudiante, profesor, dirección académica, sistema de pagos de aranceles, ministerio de educación, sistema de email).
2. Para cada actor, detallen los datos que envían y reciben (ej: el estudiante envía "solicitud de inscripción" y recibe "certificado analítico").
3. Dibujen el diagrama de contexto.
4. Definan el alcance: ¿gestiona el sistema la asistencia? ¿Las becas? ¿Los sueldos de los profesores? Justifiquen cada exclusión.
5. Identifiquen al menos 2 actores que tienen tanto flujos de entrada como de salida y descríbanlos.

**Preguntas de reflexión:**
- ¿El "sistema de pagos de aranceles" debería ser un actor externo o una función interna del sistema? ¿Qué información necesitarían para decidirlo?
- ¿Cómo cambia el diagrama si la universidad es pública y no cobra aranceles?

---

**Ejercicio E — Sistema de Gestión de Vehículos, Seguros, Multas y Mantenimientos**

*Escenario:* Una empresa de transporte de carga necesita un sistema para gestionar su flota: registro de vehículos, vencimientos de seguros, multas recibidas, planes de mantenimiento preventivo y correctivo, y reportes de disponibilidad de unidades para el área operativa.

1. Identifiquen al menos 7 actores externos (ej: mecánico/taller, compañía de seguros, organismo de tránsito, conductor, área operativa, proveedor de repuestos, sistema contable).
2. Para cada actor, identifiquen los datos intercambiados (ej: el taller envía "informe de reparación" y recibe "orden de trabajo").
3. Dibujen el diagrama de contexto.
4. Definan 4 elementos fuera del alcance (ej: liquidación de sueldos de conductores, gestión de clientes de la empresa de transporte, GPS en tiempo real, licitaciones de seguros).
5. Identifiquen qué actor genera la mayor cantidad de eventos en el sistema (el más "activo") y cuál recibe la mayor cantidad de reportes.

**Preguntas de reflexión:**
- ¿El conductor es usuario del sistema o solo un actor externo que genera datos? ¿Cambia algo si tiene acceso a una app mobile?
- ¿Cómo afecta al alcance si la empresa también quiere gestionar el combustible?

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

#### Recursos
- ISO/IEC/IEEE 29148:2018 — Systems and software engineering: Requirements engineering
- Wiegers, K. & Beatty, J. — *Software Requirements* (3rd ed.), Cap. 1–2
- IREB — International Requirements Engineering Board: ireb.org

---

### Clase 2 — Calidad del requisito y del conjunto

#### Objetivos
- Aplicar criterios de calidad a requisitos individuales y al conjunto.
- Identificar y corregir errores comunes en la redacción de requisitos.

#### Contenido teórico

**Criterios de un requisito de calidad (SMART-V)**

Los 6 puntos que debe cumplir todo requisito para que sea bueno:

| Criterio | ¿Qué significa? | ❌ Ejemplo malo | ✅ Ejemplo bueno |
|---|---|---|---|
| **Específico** | Claro, sin ambigüedades, una sola interpretación | "El sistema debe ser rápido" | "Las búsquedas devuelven resultados en máximo 2 segundos" |
| **Medible** | Puedes verificar si cumple o no (con números o criterios concretos) | "La respuesta debe ser aceptable" | "Tiempo máximo de respuesta: 2 segundos en el 95% de casos" |
| **Alcanzable** | Es posible hacerlo con la tecnología y dinero que tienes | "El sistema nunca tendrá errores, en 100 años" | "El sistema funcionará el 99% del tiempo (puede fallar máximo 7 horas/mes)" |
| **Relevante** | Alguien realmente lo pidió y es importante para el negocio | Un requisito que inventaste sin que nadie lo pida | "Los docentes pidieron poder ver asistencia en tiempo real" |
| **Identificable** | Tiene número único y sabes exactamente quién lo pidió | "Alguien me comentó sobre esto en el pasillo" | "REQ-001: Solicitado por coordinación, 20 de julio de 2024" |
| **Verificable** | Hay una forma clara de probar que funciona | "El sistema será fácil de usar" | "En una prueba, 8 de 10 usuarios completan el registro sin ayuda en menos de 5 minutos" |

**Errores frecuentes en requisitos**

1. **Ambigüedad**: "El sistema debe procesar las solicitudes rápidamente."
   - *Corrección*: "El sistema debe procesar el 95% de las solicitudes en menos de 2 segundos bajo carga normal (≤ 100 usuarios simultáneos)."

2. **Requisito compuesto (AND/OR implícito)**: "El sistema debe enviar un correo y actualizar el inventario al confirmar una venta."
   - *Corrección*: Separar en REQ-001 y REQ-002.

3. **El cliente dice "cómo" en lugar de "qué" (Requisito de diseño)**

Cuando el cliente dice exactamente "úsalo como hago yo," está impidiendo que busques soluciones mejores.

❌ **Malo**: "El sistema debe usar una base de datos Oracle porque es la que tenemos."  
*Problema*: Tal vez no sea la mejor opción. El cliente está especificando la solución, no el problema.

✅ **Mejor**: "El sistema debe guardar datos de forma segura, permitir búsquedas rápidas en millones de registros, y permitir hacer respaldos sin detener el servicio."  
*Beneficio*: Ahora el arquitecto puede elegir Oracle, PostgreSQL, o lo que sea mejor.

4. **Lenguaje vago**: palabras prohibidas → *adecuado, razonable, eficiente, fácil de usar, flexible, robusto*.

5. **Requisito negativo mal especificado**: "El sistema no debe perder datos."
   - *Corrección*: Especificar el mecanismo de respaldo y el RTO/RPO aceptable.

**Criterios de calidad del conjunto**

- **Completo**: todos los escenarios de uso están cubiertos.
- **Consistente**: no existen contradicciones entre requisitos.
- **No redundante**: un mismo hecho no se especifica dos veces.
- **Ordenado por prioridad**: hay una jerarquía clara de importancia.
- **Modificable**: la estructura permite cambios sin efectos en cascada.

**Estructura de un ID de requisito**

```
[TIPO]-[MÓDULO]-[NÚMERO]

Ejemplo: REQ-AUTH-003
         REQ = requisito funcional
         AUTH = módulo de autenticación
         003 = número secuencial
```

#### Actividad práctica

**Ejercicio 2.1 — Clínica de requisitos (individual + pares)**

Se entregan 10 requisitos mal redactados. Para cada uno:
1. Identifica el/los defecto(s) de calidad.
2. Reescríbelo aplicando los criterios correctos.
3. Asígnale un ID siguiendo el esquema visto.

*Requisitos a corregir (muestra):*
- "El sistema debe funcionar bien en dispositivos móviles."
- "El login debe ser seguro y fácil."
- "El sistema no debe caerse nunca."
- "Se deberá implementar OAuth2 para la autenticación."
- "El reporte debe generarse rápido y debe incluir gráficas y tablas."

**Ejercicio 2.2 — Detección de inconsistencias (grupos de 2)**

Dados los siguientes pares de requisitos, determinen si son consistentes o contradictorios y propongan resolución:
- REQ-001: "Solo los administradores pueden eliminar usuarios."
- REQ-047: "Cualquier usuario puede desactivar su propia cuenta, lo que elimina todos sus datos."

#### Ejercicio de código — Clase 02: Validador automático de criterios SMART-V

**Problema:** revisar requisitos manualmente es tedioso y se presta a omisiones. Vamos a construir un script que evalúa automáticamente cuántos criterios SMART-V cumple un requisito.

**Paso 1 — Crea el archivo `validar_requisito.py`:**

```python
import re

# ---------------------------------------------------------------------------
# Reglas heurísticas para detectar criterios SMART-V.
# No son perfectas: son una primera pasada que ayuda a guiar la revisión.
# ---------------------------------------------------------------------------

PALABRAS_VAGAS = [
    "rápido", "lento", "fácil", "difícil", "bueno", "malo",
    "aceptable", "adecuado", "robusto", "eficiente", "seguro",
    "amigable", "intuitivo", "flexible",
]

def es_especifico(req: str) -> bool:
    """Específico: no contiene palabras vagas."""
    texto = req.lower()
    encontradas = [p for p in PALABRAS_VAGAS if p in texto]
    if encontradas:
        print(f"  ⚠ Palabras vagas encontradas: {encontradas}")
    return len(encontradas) == 0

def es_medible(req: str) -> bool:
    """Medible: contiene al menos un número o porcentaje."""
    tiene_numero = bool(re.search(r"\d+", req))
    tiene_porcentaje = "%" in req
    return tiene_numero or tiene_porcentaje

def es_verificable(req: str) -> bool:
    """Verificable: menciona una condición o criterio concreto."""
    palabras_clave = ["cuando", "si ", "debe", "máximo", "mínimo",
                      "menos de", "más de", "al menos", "exactamente"]
    texto = req.lower()
    return any(p in texto for p in palabras_clave)

def tiene_id(req: str) -> bool:
    """Identificable: comienza con un ID tipo REQ-001."""
    return bool(re.match(r"^REQ-\d{3,}", req.strip()))

def evaluar_requisito(req: str) -> dict:
    resultado = {
        "texto": req,
        "Específico":   es_especifico(req),
        "Medible":      es_medible(req),
        "Verificable":  es_verificable(req),
        "Identificable": tiene_id(req),
    }
    resultado["puntaje"] = sum(1 for v in resultado.values() if v is True)
    return resultado

# ---------------------------------------------------------------------------
# Requisitos de prueba
# ---------------------------------------------------------------------------
requisitos = [
    "El sistema debe ser rápido.",
    "El login debe ser seguro y fácil.",
    "REQ-001: El sistema debe responder en menos de 2 segundos cuando el usuario busca un libro.",
    "El sistema no debe caerse nunca.",
    "REQ-042: Las búsquedas devuelven resultados en máximo 2 segundos para catálogos de hasta 100,000 libros.",
]

print("=" * 60)
for req in requisitos:
    r = evaluar_requisito(req)
    estado = "✅" if r["puntaje"] >= 3 else "❌"
    print(f"\n{estado} [{r['puntaje']}/4] {r['texto'][:55]}...")
    for criterio in ["Específico", "Medible", "Verificable", "Identificable"]:
        marca = "✔" if r[criterio] else "✘"
        print(f"    {marca} {criterio}")
print("=" * 60)
```

**Paso 2 — Ejecuta el script:**
```bash
python validar_requisito.py
```

**Salida esperada (fragmento):**
```
❌ [1/4] El sistema debe ser rápido....
    ✘ Específico
    ✘ Medible
    ✔ Verificable
    ✘ Identificable

✅ [4/4] REQ-042: Las búsquedas devuelven resultados en máximo 2 segundos...
    ✔ Específico
    ✔ Medible
    ✔ Verificable
    ✔ Identificable
```

**Paso 3 — Extiende el ejercicio:**
1. Agrega la detección del criterio **Alcanzable** (puedes buscar palabras como "imposible", "infinito", "nunca" como señales de alerta).
2. Agrega la detección de **Relevante** (pista: ¿hay alguna mención de un stakeholder o de una necesidad de negocio?).
3. Prueba el validador con los 10 requisitos del Ejercicio 2.1 de esta clase.

**Preguntas de cierre:**
- ¿Qué criterios son más difíciles de detectar automáticamente? ¿Por qué?
- ¿Qué pasa si el script da "verde" pero el requisito aún tiene problemas? ¿Qué significa eso sobre la confianza en herramientas automáticas?

#### Recursos
- Wiegers & Beatty — *Software Requirements*, Cap. 10–11
- INCOSE — *Systems Engineering Handbook*, Sección 4.2
- Checklist de calidad de requisitos (NASA-STD-7009)

---

### Continuacion Clase 2
**Duración:** 2 horas | **Unidad:** 1 — Análisis del comportamiento

### Objetivos
- Redactar casos de uso completos con flujo principal, flujos alternativos y excepciones.
- Distinguir entre escenario, flujo alternativo y excepción.
- Identificar los actores y su relación con el sistema.

---

### Bloque 1 (50 min) — Teoría de casos de uso

#### ¿Qué es un caso de uso?

Un **caso de uso** describe una interacción entre una persona (o sistema) y tu sistema para alcanzar un objetivo.

**NO es:**
- Un paso a paso técnico de botones.
- Cómo se implementa ("usa base de datos MySQL").

**SÍ es:**
- Una descripción del flujo de negocio.
- "Un estudiante busca un libro, lo reserva y recibe confirmación."

| Concepto | Qué es | Ejemplo |
|---|---|---|
| **Actor** | Quién interactúa con el sistema | Estudiante, bibliotecario, sistema de emails |
| **Objetivo** | Qué quiere lograr | Reservar un libro disponible |
| **Flujo principal** | El camino feliz sin problemas | Busca → encuentra → reserva → confirma |
| **Flujo alternativo** | Otro camino válido | Busca por autor en lugar de título |
| **Excepción** | Lo que sale mal | Libro no existe, ya está reservado |

#### Estructura completa de un caso de uso

```
ID: CU-03
Nombre: Realizar transferencia bancaria
Actor primario: Cliente autenticado
Actores secundarios: Sistema de notificaciones, Core bancario
Precondiciones:
  - El cliente está autenticado en el sistema
  - La cuenta origen tiene saldo disponible
Postcondiciones (éxito):
  - El saldo de la cuenta origen disminuye en el monto
  - El saldo de la cuenta destino aumenta en el monto
  - Se registra la operación en el historial de ambas cuentas
  - Se envía notificación al cliente

Flujo principal:
  1. El cliente selecciona "Nueva transferencia"
  2. El cliente ingresa el número de cuenta destino y el monto
  3. El sistema valida los datos ingresados
  4. El sistema muestra un resumen para confirmación
  5. El cliente confirma la operación
  6. El sistema procesa la transferencia
  7. El sistema muestra el comprobante

Flujos alternativos:
  3a. Número de cuenta destino inexistente:
      3a.1 El sistema informa "Cuenta destino no encontrada"
      3a.2 El cliente puede corregir el dato (vuelve al paso 2) o cancelar
  5a. El cliente cancela la confirmación:
      5a.1 El sistema descarta la operación
      5a.2 El caso de uso termina sin cambios

Excepciones:
  3b. Saldo insuficiente:
      3b.1 El sistema informa "Saldo insuficiente para realizar la operación"
      3b.2 El caso de uso termina
  6a. Fallo en el servicio de transferencia:
      6a.1 El sistema revierte cualquier cambio parcial (rollback)
      6a.2 El sistema informa "No fue posible completar la transferencia. Intente más tarde"
      6a.3 El sistema registra el error internamente

Reglas de negocio referenciadas:
  - RN-07: El monto máximo de transferencia diaria es $100.000
  - RN-12: No se permiten transferencias a cuentas bloqueadas
```

---

## CLASE 3 — Historias de usuario, criterios de aceptación y trazabilidad
**Duración:** 2 horas | **Unidad:** 1 — Análisis del comportamiento

### Objetivos
- Redactar historias de usuario efectivas con criterios de aceptación verificables.
- Comprender las reglas de negocio y su ubicación en el sistema.
- Construir una matriz de trazabilidad básica.

---

### Bloque 1 (50 min) — Historias de usuario y reglas de negocio

#### Historias de usuario (User Stories)

Las historias de usuario describen el **valor** que un tipo de usuario obtiene al realizar algo. Son el vehículo de comunicación en el desarrollo ágil, no un documento formal.

**Formato estándar:**
> **Como** [rol del usuario], **quiero** [acción o funcionalidad], **para** [beneficio o valor obtenido].

**Criterios para una buena historia (INVEST):**
| Criterio | Significado |
|---|---|
| **I**ndependiente | No depende de otra historia para ser implementada o probada |
| **N**egociable | Es un punto de partida para una conversación, no un contrato fijo |
| **V**aliosa | Entrega valor real a un usuario o al negocio |
| **E**stimable | El equipo puede estimar el esfuerzo |
| **S**mall (pequeña) | Se puede implementar en una iteración |
| **T**estable | Tiene criterios claros de verificación |

**Ejemplos — bien vs. mal escritas:**

❌ Historia mal escrita:
> Como sistema, quiero guardar los datos del usuario en la base de datos.

Problemas: El actor es el sistema (no un usuario), no expresa valor, es técnica.

✅ Historia bien escrita:
> Como estudiante, quiero buscar libros por título o autor, para encontrar rápidamente el material que necesito para mis cursos.

#### Criterios de aceptación (CA)

Los CA son condiciones verificables que deben cumplirse para que la historia esté "terminada". Son el contrato entre el dueño del producto y el equipo.

**Formato Given/When/Then (Gherkin):**
```gherkin
# Historia: Buscar libros

Scenario: Búsqueda exitosa por título
  Given que existen libros con "Programación" en el título
  When el estudiante busca "Programación"
  Then el sistema muestra una lista con todos los libros que contienen "Programación"
  And cada resultado muestra: título, autor, disponibilidad

Scenario: Búsqueda sin resultados
  Given que no existen libros con "XYZ123" en el título o autor
  When el estudiante busca "XYZ123"
  Then el sistema muestra el mensaje "No se encontraron resultados para su búsqueda"

Scenario: Búsqueda con término vacío
  Given que el estudiante está en la pantalla de búsqueda
  When intenta buscar sin ingresar texto
  Then el sistema muestra "Por favor ingrese un término de búsqueda"
  And no se realiza ninguna consulta
```

**Buenas prácticas para CA:**
- Escribirlos **antes** de programar (guía la implementación y las pruebas).
- Ser específicos y medibles, no subjetivos ("rápido" es subjetivo; "en menos de 2 segundos" es medible).
- Cubrir: camino feliz, flujos alternativos y excepciones.
- Un CA = un escenario = una prueba de aceptación.

#### Reglas de negocio

Las **reglas de negocio** son restricciones o políticas del dominio que el sistema debe respetar, independientemente de cómo se implemente.

Ejemplos:
- RN-01: Un estudiante puede tener como máximo 3 préstamos de libros activos simultáneamente.
- RN-02: Un libro solo puede renovarse una vez por préstamo.
- RN-03: La renovación solo es posible si no hay otro estudiante con reserva activa del mismo libro.

---

### Bloque 2 (50 min) — Actividad práctica

#### Ejercicio 1: Redactar casos de uso completos

> **Sistema de pagos de servicios publicos:** Las entidades que intervienen son: Cuenta, Cuenta de Ahorros, Cuenta Corriente, Factura, Cliente y Pago. Construir el CRUD para cada entidad y las funcionalidades de procesarPago, obtenerSaldoCuenta, obtenerPagosPorCliente, ObtenerFacturasPorCliente.

Redactar **los casos de uso completos** de las funcionalidades:
- Actores primarios y secundarios.
- Precondiciones y postcondiciones.
- Flujo principal paso a paso.
- Al menos 2 flujos alternativos.
- Al menos 2 excepciones.

#### Ejercicio 2: Desarrollo en código aplicando pilares POO (20 min)

Tomando los casos de uso redactados en el ejercicio anterior, se debe implementar un prototipo en cualquier lenguaje de programacion que use explícitamente los 4 pilares:

1. **Abstracción** 
2. **Encapsulamiento** 
3. **Herencia**
4. **Polimorfismo**

**Entregable mínimo del ejercicio:**
- Diagrama de Clases.
- Casos de uso.
- Historias de Usuario en Jira.
- Código compilable y funcionando en el repositorio de talleres.

---

#### Taller

### Taller — Clases, herencia e interfaces en Java (Sistema de pagos de servicios públicos)

**Duración estimada:** 90 minutos | **Modalidad:** individual o parejas

#### Objetivos
- Modelar con clases e interfaces las entidades del "Sistema de pagos de servicios públicos" descrito en el Ejercicio 1.
- Aplicar herencia entre `Cuenta`, `CuentaAhorros` y `CuentaCorriente`.
- Definir una interfaz `Pagable` que obligue a implementar el comportamiento de pago.
- Leer datos por consola con `Scanner` y mostrar resultados con `System.out`.

#### Contexto

Retomando el dominio del Ejercicio 1 (Cuenta, Cuenta de Ahorros, Cuenta Corriente, Factura, Cliente y Pago), construyan una aplicación de consola en Java que permita registrar un cliente, crear su cuenta (de ahorros o corriente), registrar una factura y procesar un pago, validando el saldo disponible.

#### Requisitos técnicos obligatorios

1. **Interfaz `Pagable`** con el método `boolean procesarPago(double monto);`
2. **Clase abstracta `Cuenta`** que implemente `Pagable` y contenga: `numeroCuenta`, `titular`, `saldo` (encapsulados con getters/setters) y el método abstracto `double calcularInteresOComision();`
3. **`CuentaAhorros extends Cuenta`**: aplica una tasa de interés (ej. 2% mensual) y no permite saldo negativo.
4. **`CuentaCorriente extends Cuenta`**: permite un cupo de sobregiro (ej. hasta -$50.000) y cobra una comisión fija por mantenimiento.
5. **Clase `Cliente`**: nombre, documento y una lista de cuentas.
6. **Clase `Factura`**: número, concepto, monto y estado (pendiente/pagada).
7. **Clase `Main`** que use `Scanner` para:
   - Pedir los datos del cliente.
   - Pedir el tipo de cuenta a crear (1 = Ahorros, 2 = Corriente) y el saldo inicial.
   - Pedir los datos de una factura (concepto y monto).
   - Ejecutar `procesarPago()` sobre la cuenta y mostrar en consola si el pago fue aprobado o rechazado, junto con el saldo resultante.

#### Esqueleto de partida

```java
public interface Pagable {
    boolean procesarPago(double monto);
}

public abstract class Cuenta implements Pagable {
    protected String numeroCuenta;
    protected String titular;
    protected double saldo;

    public Cuenta(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public double getSaldo() { return saldo; }

    public abstract double calcularInteresOComision();

    @Override
    public boolean procesarPago(double monto) {
        if (monto <= 0) return false;
        if (saldo - monto < limiteInferiorPermitido()) return false;
        saldo -= monto;
        return true;
    }

    protected double limiteInferiorPermitido() { return 0; }
}

public class CuentaCorriente extends Cuenta {
    private final double sobregiroPermitido = -50000;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo) {
        super(numeroCuenta, titular, saldo);
    }

    @Override
    protected double limiteInferiorPermitido() { return sobregiroPermitido; }

    @Override
    public double calcularInteresOComision() { return 5000; } // comisión fija
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.print("Tipo de cuenta (1=Ahorros, 2=Corriente): ");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Saldo inicial: ");
        double saldoInicial = Double.parseDouble(sc.nextLine());

        Cuenta cuenta = (tipo == 1)
                ? new CuentaAhorros("AH-001", nombre, saldoInicial)
                : new CuentaCorriente("CC-001", nombre, saldoInicial);

        System.out.print("Monto de la factura a pagar: ");
        double monto = Double.parseDouble(sc.nextLine());

        boolean aprobado = cuenta.procesarPago(monto);

        System.out.println("--------------------------------------");
        System.out.println("Pago " + (aprobado ? "APROBADO" : "RECHAZADO"));
        System.out.println("Saldo resultante: " + cuenta.getSaldo());

        sc.close();
    }
}
```

> El esqueleto omite `CuentaAhorros`, `Cliente` y `Factura` a propósito: son parte del entregable.

#### Pasos a seguir

1. Completa `CuentaAhorros` (herencia + comisión/interés distinto al de `CuentaCorriente`).
2. Implementa `Cliente` con una `List<Cuenta>` y un método `mostrarResumen()` que imprima sus cuentas y saldos.
3. Implementa `Factura` y vincúlala al pago: solo si `procesarPago()` retorna `true`, marca la factura como "PAGADA".
4. En `Main`, agrega un menú con `Scanner` que repita el ciclo (crear cliente → crear cuenta → registrar factura → pagar) hasta que el usuario ingrese "salir".
5. Imprime en consola una tabla final con: cliente, tipo de cuenta, saldo final y estado de la factura.

#### Criterios de aceptación del taller

- [ ] Compila y ejecuta sin errores (`javac` / `java`).
- [ ] `Cuenta` es abstracta y ambas subclases sobrescriben `calcularInteresOComision()`.
- [ ] `Pagable` se implementa en `Cuenta` (o en cada subclase) y se invoca de forma polimórfica.
- [ ] Todo el ingreso de datos ocurre mediante `Scanner` (no valores fijos en el código).
- [ ] La salida por consola es clara: muestra aprobación/rechazo del pago y saldo resultante.
- [ ] Se valida que `CuentaAhorros` nunca quede con saldo negativo y que `CuentaCorriente` respete el sobregiro máximo.

#### Preguntas de cierre
- ¿Qué ventaja aporta declarar `Pagable` como interfaz en lugar de poner `procesarPago()` solo en `Cuenta`?
- ¿Qué pasaría si mañana se agrega `CuentaNomina` con otra regla de sobregiro? ¿Qué clases hay que tocar?
- ¿Cómo se relaciona este ejercicio con los requisitos funcionales redactados en el Ejercicio 1 (trazabilidad requisito → código)?

---

### Clase 3 — Stakeholders y técnicas de elicitación

#### Objetivos
- Identificar y clasificar stakeholders usando herramientas estructuradas.
- Aplicar técnicas de elicitación apropiadas según el contexto.

#### Contenido teórico

**¿Qué es un stakeholder?**  
Toda persona, grupo u organización que tiene un interés legítimo en el sistema, que puede afectar o ser afectado por él. Incluye:
- Usuarios directos e indirectos
- Patrocinadores y financiadores
- Equipos de desarrollo y operación
- Reguladores y entes externos
- Sistemas externos que interactúan

**Matriz Influencia–Interés (Power/Interest Grid)**

```
        Alta influencia
             |
  Gestionar  |  Colaborar
  de cerca   |  activamente
-------------|-------------→ Alto interés
  Monitorear |  Mantener
  (mínimo)   |  informado
             |
        Baja influencia
```

- **Colaborar activamente**: decisores con alto interés. Entrevistas en profundidad, talleres JAD.
- **Gestionar de cerca**: poder de veto, interés bajo. Validaciones periódicas, informes ejecutivos.
- **Mantener informado**: alto interés, poca influencia. Encuestas, demos.
- **Monitorear**: impacto mínimo. Listas de distribución.

**Técnicas de elicitación**

| Técnica | Cuándo usarla | Ventajas | Desventajas |
|---|---|---|---|
| **Entrevista** | Requisitos complejos, pocas personas clave | Profundidad, flexibilidad | Costosa en tiempo, sesgos |
| **Taller JAD** | Conflictos entre áreas, necesidad de consenso | Consenso rápido | Requiere facilitador experto |
| **Observación** | Procesos tácitos, documentación inexistente | Revela lo que no se dice | Invasiva, efecto Hawthorne |
| **Estudio documental** | Sistemas existentes, regulaciones | Bajo costo, objetiva | Documentación desactualizada |
| **Cuestionario/encuesta** | Muchos stakeholders, validación masiva | Escalable | Superficial, bajo retorno |
| **Prototipado** | Requisitos de UX, alto riesgo de malentendidos | Feedback temprano | Puede generar expectativas erróneas |

**Estructura de una entrevista de elicitación**

1. **Preparación**: estudiar el dominio, preparar guía de preguntas abiertas.
2. **Apertura**: presentación, objetivo, contexto.
3. **Cuerpo**: preguntas de contexto → problemáticas → necesidades → restricciones.
4. **Cierre**: síntesis y validación, próximos pasos.
5. **Documentación**: acta en 24 h, validación con entrevistado.

**Tipos de preguntas**
- **Abiertas**: "¿Cómo gestiona usted actualmente el proceso de alta de clientes?"
- **De sondeo**: "¿Puede darme un ejemplo de cuándo eso falla?"
- **De confirmación**: "Si entendí bien, el problema es X, ¿correcto?"
- **Hipotéticas**: "¿Qué haría si pudiera rediseñar ese proceso desde cero?"

#### Actividades prácticas

Cada grupo elige **uno** de los siguientes escenarios. Todos realizan los mismos pasos sobre dominios distintos.

---

**Ejercicio A — Sistema de Gestión de Citas Médicas**

*Escenario:* Una clínica privada quiere digitalizar la gestión de turnos médicos. Pacientes, médicos, administrativos, obras sociales y sistemas de notificación deben interactuar con el sistema.

1. Identifiquen al menos 8 stakeholders del sistema (ej: paciente, médico, administrativo, director de clínica, obra social, sistema de email/SMS, laboratorio, proveedor de tecnología).
2. Para cada stakeholder, anoten:
   - ¿Cuán influyente es? (poder de decisión o veto)
   - ¿Cuánto interés tiene en el sistema? (impacto directo en su trabajo)
3. Ubíquenlos en la matriz influencia-interés (4 cuadrantes).
4. Para cada cuadrante, definan:
   - **Colaborar activamente**: ¿Quiénes son? ¿Qué técnica de elicitación usan?
   - **Gestionar de cerca**: ¿Qué información necesitan? ¿Cada cuánto?
   - **Mantener informado**: ¿Cómo los mantienen actualizado?
   - **Monitorear**: ¿Cuál es su impacto mínimo?
5. Diseñen un plan de participación para cada stakeholder del cuadrante "Colaborar activamente".

**Preguntas de reflexión:**
- ¿La obra social tiene más influencia que el paciente? ¿Por qué?
- ¿El laboratorio debería estar en el sistema o es externo? ¿Qué información intercambiaría?

---

**Ejercicio B — Sistema de Gestión de Reservas de Vuelos y Hoteles**

*Escenario:* Una agencia de viajes online gestiona reservas. Viajeros, aerolíneas, hoteles, pasarelas de pago, reguladores y proveedores de mapas son stakeholders.

1. Identifiquen al menos 8 stakeholders (ej: viajero, agente de viajes, aerolínea, hotel, pasarela de pago, agencia reguladora, proveedor de mapas, gerente de agencia).
2. Para cada uno, determinen:
   - Influencia: ¿puede detener o acelerar el proyecto?
   - Interés: ¿cuánto le afecta el sistema en su día a día?
3. Construyan la matriz influencia-interés.
4. Identifiquen conflictos potenciales:
   - ¿Hay stakeholders con alto interés pero baja influencia que podrían sentirse ignorados?
   - ¿Hay stakeholders con alta influencia pero bajo interés que podrían no priorizar este proyecto?
5. Propongan una estrategia de comunicación que equilibre los intereses de los stakeholders en conflicto.

**Preguntas de reflexión:**
- ¿El regulador debería estar en el cuadrante de "Colaborar activamente" o de "Gestionar de cerca"? ¿Por qué?
- ¿Cómo cambia la matriz si la aerolínea es también accionista de la agencia de viajes?

---

**Ejercicio C — Sistema de Gestión de Facturación de una Tienda de Productos**

*Escenario:* Una tienda de electrónica digitaliza ventas y facturación. Clientes, vendedores, contabilidad, AFIP/SAT, proveedores y gerencia están involucrados.

1. Identifiquen al menos 8 stakeholders (ej: cliente, vendedor, contador, AFIP/SAT, proveedor de stock, gerente de ventas, supervisor de caja, auditor externo).
2. Para cada stakeholder:
   - Analicen si su influencia es **ejecutiva** (toman decisiones), **técnica** (dan recomendaciones), o **consultiva** (dan información).
   - Analicen su interés: ¿alto (afecta su trabajo diario)? ¿Bajo (afecta ocasionalmente)?
3. Construyan la matriz influencia-interés.
4. Identifiquen al menos 3 pares de stakeholders con intereses **conflictivos** y propongan cómo resolverlos (ej: vendedor quiere procesos rápidos, contador quiere precisión; AFIP quiere datos completos, cliente quiere privacidad).
5. Diseñen la estrategia de elicitación para el cuadrante "Colaborar activamente" especificando técnicas concretas.

**Preguntas de reflexión:**
- ¿El auditor externo tiene influencia o solo interés? ¿Cómo lo tratarían en la matriz?
- ¿Qué conflicto de intereses existe entre el AFIP/SAT y el cliente? ¿Cómo lo gestionan?

---

**Ejercicio D — Sistema de Gestión de Notas, Estudiantes, Profesores y Cursos**

*Escenario:* Una universidad centraliza gestión académica. Estudiantes, profesores, dirección académica, dirección de finanzas, ministerio de educación y padres son stakeholders.

1. Identifiquen al menos 8 stakeholders (ej: estudiante, profesor, coordinador académico, director de facultad, tesorero, ministerio de educación, padre/apoderado, empleado de admisión).
2. Analicen para cada uno:
   - ¿Es usuario directo del sistema o recibe información de él?
   - ¿Qué tan afectado es por cambios en las reglas académicas?
3. Construyan la matriz influencia-interés.
4. Identifiquen stakeholders que probablemente estén en conflicto:
   - Ejemplo: Estudiante quiere transparencia de calificaciones en tiempo real; Profesor quiere privacidad hasta publicación oficial.
5. Propongan 3 técnicas de elicitación concretas para el cuadrante "Colaborar activamente" y justifiquen por qué las eligieron (ej: entrevista vs. taller vs. encuesta).

**Preguntas de reflexión:**
- ¿El padre/apoderado debería tener tanta influencia como el estudiante? ¿Por qué sí o no?
- ¿El ministerio de educación está interesado en este sistema específico o solo en que cumpla estándares?

---

**Ejercicio E — Sistema de Gestión de Vehículos, Seguros, Multas y Mantenimientos**

*Escenario:* Una empresa de transporte gestiona su flota. Conductores, mecánicos, compañía de seguros, organismo de tránsito, operadores y finanzas están involucrados.

1. Identifiquen al menos 8 stakeholders (ej: conductor, mecánico/taller, compañía de seguros, organismo de tránsito, supervisor de operaciones, gerente de finanzas, proveedor de repuestos, contador de la empresa).
2. Para cada stakeholder, clasifiquen:
   - Influencia: ¿puede vetar decisiones? ¿Puede acelerar aprobaciones?
   - Interés: ¿cuánto les importa que el sistema funcione bien?
3. Construyan la matriz influencia-interés.
4. Identifiquen stakeholders con **alta influencia y bajo interés** (riesgo de que bloqueen el proyecto sin entender bien por qué es importante):
   - ¿Cómo los convencen de la importancia del sistema?
   - ¿Qué información necesitan para mantenerlos conformes?
5. Diseñen un plan de gestión de stakeholders que incluya:
   - Frecuencia de comunicación para cada grupo
   - Qué información comparten con cada uno
   - Cómo manejan desacuerdos entre grupos

**Preguntas de reflexión:**
- ¿El conductor debería estar en "Colaborar activamente" o en "Mantener informado"? ¿Qué cambia si la app mobile es crítica para él?
- ¿Cómo resuelven un conflicto entre lo que quiere el organismo de tránsito (datos detallados de multas) y lo que quiere el conductor (privacidad)?

#### Recursos
- Robertson, S. & J. — *Mastering the Requirements Process*, Cap. 3–4
- Plantilla de acta de entrevista (archivo de la cátedra)
- IREB CPRE Foundation Level Syllabus, Módulo 2

---