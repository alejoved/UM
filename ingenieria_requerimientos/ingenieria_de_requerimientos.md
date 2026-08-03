# Ingeniería de Requerimientos — Contenido de Clases

> **Materia:** Ingeniería de Requerimientos  
> **Duración por clase:** 2 horas (120 minutos)  
> **Total de clases:** 20  
> **Estructura de cada clase:** Teoría (60–70 min) · Práctica (40–50 min) · Cierre (10 min)

---

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

Herramienta: **diagrama de contexto** (dibuja el sistema como una caja, y sus conexiones con el mundo exterior).

#### Actividad práctica (45 min)

**Ejercicio 1.1 — Diagrama de contexto (grupos de 3)**

*Escenario:* Una biblioteca universitaria quiere digitalizar el proceso de préstamo de libros.

1. Identifiquen al menos 5 actores externos al sistema (personas, sistemas, organizaciones).
2. Para cada actor, listen las entradas y salidas de información hacia/desde el sistema.
3. Dibujen el diagrama de contexto en papel o en draw.io.
4. Definan 3 elementos que quedan **fuera** del alcance (justifiquen).

**Preguntas de reflexión para el cierre:**
- ¿Hay actores que no son humanos? ¿Cómo los tratamos?
- ¿Qué pasa si no definimos los límites desde el inicio?

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

#### Actividad práctica (45 min)

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

#### Ejercicio de código — Clase 02: Validador automático de criterios SMART-V (25 minutos)

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

#### Actividad práctica (45 min)

**Ejercicio 3.1 — Mapeo de stakeholders (grupos de 3)**

*Escenario:* Sistema de gestión de turnos para un hospital público.

1. Identifiquen al menos 8 stakeholders.
2. Ubíquenlos en la matriz influencia-interés.
3. Para cada cuadrante, definan la estrategia de participación y la técnica de elicitación más adecuada.

**Ejercicio 3.2 — Simulación de entrevista (parejas, roles: analista / stakeholder)**

Un estudiante es el analista, otro es el Jefe de Admisiones del hospital.
- Duración: 10 minutos por entrevista.
- El analista debe obtener al menos 5 requisitos candidatos.
- Al finalizar, el "stakeholder" da feedback sobre la calidad de las preguntas.

#### Recursos
- Robertson, S. & J. — *Mastering the Requirements Process*, Cap. 3–4
- Plantilla de acta de entrevista (archivo de la cátedra)
- IREB CPRE Foundation Level Syllabus, Módulo 2

---

### Clase 4 — Elicitación avanzada y uso de IA como simuladora

#### Objetivos
- Aplicar técnicas de elicitación avanzadas (JAD, etnografía).
- Utilizar IA generativa como herramienta de apoyo controlada en la elicitación.

#### Contenido teórico

**Taller JAD (Joint Application Development)**  
Sesión estructurada de 1–5 días donde stakeholders clave, analistas y un facilitador neutro trabajan en conjunto para producir especificaciones consensuadas.

*Roles en un JAD:*
- **Facilitador**: conduce, neutral, sin poder de decisión.
- **Patrocinador ejecutivo**: abre la sesión, valida decisiones estratégicas.
- **Usuarios clave**: aportan conocimiento del dominio.
- **Analista (escriba)**: documenta en tiempo real.
- **Especialistas de TI**: resuelven dudas técnicas de viabilidad.

*Agenda típica de una sesión JAD (4 horas):*
1. Revisión del contexto y límites (30 min)
2. Identificación de casos de uso de alto nivel (45 min)
3. Análisis de flujo de trabajo por proceso (90 min)
4. Identificación de requisitos de calidad y restricciones (45 min)
5. Revisión y priorización preliminar (30 min)

**Observación y etnografía**  
La observación directa del trabajo real revela requisitos tácitos que los stakeholders no pueden verbalizar porque son parte de su rutina. Variantes:
- **Shadowing**: el analista sigue al usuario durante su jornada.
- **Think aloud**: el usuario verbaliza sus pensamientos mientras trabaja.
- **Video etnography**: grabación para análisis posterior.

**IA como simuladora de stakeholder**  
Los modelos de lenguaje grandes (LLM) pueden adoptar el rol de un stakeholder con un perfil definido para:
- Generar preguntas que el analista podría no haber considerado.
- Simular respuestas con perspectivas de distintos roles (gerente, usuario final, auditor).
- Identificar ambigüedades en requisitos candidatos.

*Prompt efectivo para elicitación con IA:*
```
Actúa como [ROL] de [ORGANIZACIÓN] con [AÑOS] de experiencia. 
El contexto es [DESCRIPCIÓN DEL DOMINIO]. 
Estoy desarrollando un sistema para [OBJETIVO].
Cuando te haga preguntas de elicitación, responde desde tu perspectiva 
profesional, incluyendo preocupaciones, restricciones y necesidades reales 
de tu rol. Señala cualquier ambigüedad en mis preguntas.
```

> **Advertencia crítica**: la IA no reemplaza a los stakeholders reales. Sus respuestas deben validarse siempre con personas del dominio. Los sesgos del modelo y la falta de contexto organizacional real pueden producir requisitos incorrectos o incompletos.

**Señales de alerta en la elicitación**
- Stakeholder que dice "el sistema debe hacer todo lo que hace el actual, pero mejor."
- Requisitos que cambian en cada reunión con el mismo stakeholder.
- Stakeholders que se contradicen entre sí sin saberlo.
- "Eso es obvio, no hace falta documentarlo."

#### Actividad práctica (50 min)

**Ejercicio 4.1 — JAD simulado (grupos de 6)**

La clase se divide en grupos. Cada grupo recibe un escenario diferente:
- A: Sistema de matrícula universitaria en línea
- B: App de seguimiento de pedidos para restaurante
- C: Portal de declaraciones juradas para empleados públicos

Roles asignados: facilitador, 2 usuarios clave, patrocinador, analista (escriba), TI.  
Duración: 25 minutos de sesión JAD estructurada.  
Entregable: 8–10 requisitos candidatos documentados con ID, descripción y fuente.

**Ejercicio 4.2 — Elicitación asistida por IA (individual)**

Con acceso a un LLM (ChatGPT, Copilot, Gemini):
1. Diseñen un prompt para que la IA actúe como stakeholder del escenario de su grupo.
2. Realicen 5 preguntas de elicitación.
3. Documenten las respuestas.
4. Anoten cuáles respuestas son verosímiles y cuáles necesitarían validación con un experto real.

#### Recursos
- Wood, J. & Silver, D. — *Joint Application Development*
- Beyer, H. & Holtzblatt, K. — *Contextual Design*, Cap. 2
- Prompt engineering guide: promptingguide.ai

---

### Clase 5 — Modelado del dominio: lenguaje ubicuo y BPMN 2.0

#### Objetivos
- Construir un glosario y lenguaje ubicuo del dominio.
- Modelar procesos AS-IS y TO-BE con notación BPMN 2.0.

#### Contenido teórico

**Lenguaje común que todos entienden igual**

Cuando trabajas en un proyecto, todos deben entender exactamente lo mismo con cada palabra. Por ejemplo: ¿"cliente" y "usuario" son lo mismo? ¿Qué es un "suscriptor"? ¿Es diferente de "estudiante"? Si cada persona entiende algo distinto, la confusión es garantizada.

Tu trabajo es crear un **diccionario oficial del proyecto** que todos respeten:
- **Un término = un solo significado**. No puedes usar "cliente", "usuario" y "suscriptor" como si fueran lo mismo.
- **La misma palabra en los documentos, en las conversaciones y en el código**.
- **Construido entre todos** (usuarios, gerentes, programadores), no impuesto por una sola persona.

**Glosario del dominio**

Cada entrada incluye:

| Término | Definición | Sinónimos a evitar | Contexto de uso |
|---|---|---|---|
| Solicitud de préstamo | Petición formal de un socio para reservar un ítem | Pedido, requerimiento | Módulo de préstamos |
| Socio activo | Usuario con membresía vigente y sin sanciones activas | Cliente, usuario | Módulo de socios |

**Reglas de negocio**  
Las reglas de negocio son políticas o restricciones que gobiernan las decisiones del dominio. Son distintas de los requisitos funcionales:

- **Hecho**: "Un socio puede tener hasta 3 préstamos simultáneos."
- **Restricción**: "No se puede prestar un ítem con más de 30 días de atraso en devolución."
- **Derivación**: "El monto de multa = días de atraso × $0.50 por día."
- **Proceso**: "Toda devolución tardía debe generar una notificación automática al socio."

**Cómo dibujar procesos con BPMN 2.0 (notación estándar)**

BPMN es simplemente una forma estandarizada de dibujar procesos (pasos). Los elementos básicos son:

| Elemento | Símbolo | ¿Qué significa? | Ejemplo |
|---|---|---|---|
| **Inicio** | Círculo | "Aquí comienza el proceso" | El cliente llega a la tienda |
| **Tarea** | Caja redondeada | "Alguien hace un trabajo" | El vendedor atiende al cliente |
| **Decisión** | Rombo | "¿Cumple esta condición? Si sí, vamos por aquí; si no, por acá" | ¿El cliente es VIP? |
| **Fin** | Círculo grande | "El proceso termina" | El cliente se va con su compra |
| **Flecha** | → | "El orden de los pasos" | Paso 1 → Paso 2 → Paso 3 |
| **Carril** | Banda horizontal | "Quién hace cada paso" | Vendedor | Cliente | Gerente |

**Comparar el proceso actual (AS-IS) con el proceso mejorado (TO-BE)**

- **AS-IS** = cómo es ahora (con sus problemas, pasos manuales lentos, duplicación).
- **TO-BE** = cómo debe ser con el nuevo sistema (automatizado, rápido, sin pasos innecesarios).

La idea es identificar qué pasos se pueden automatizar, eliminar o hacer en paralelo.

#### Actividad práctica (45 min)

**Ejercicio 5.1 — Glosario y reglas de negocio (grupos de 3)**

*Dominio:* sistema de gestión de multas de tránsito.

1. Identifiquen 8 términos del dominio y construyan el glosario.
2. Redacten 5 reglas de negocio (al menos un hecho, una restricción, una derivación).

**Ejercicio 5.2 — Modelado BPMN (grupos de 3, herramienta: bpmn.io)**

Modelen el proceso AS-IS y TO-BE del siguiente escenario:

*Proceso AS-IS:* Un ciudadano recibe una infracción en papel. La lleva a la oficina, un empleado la registra manualmente, el ciudadano paga en caja, el empleado sella el recibo y archiva el documento.

*Proceso TO-BE:* Diseñen un proceso digitalizado que reduzca tiempos y pasos manuales.

Entregable: ambos diagramas BPMN exportados como imagen + tabla comparativa de métricas esperadas (pasos, tiempo estimado, roles involucrados).

#### Recursos
- Evans, E. — *Domain-Driven Design*, Cap. 2
- OMG BPMN 2.0 Specification: omg.org/bpmn
- Herramienta online: bpmn.io (gratuita)

---

## Unidad 2. Especificación estructurada e historias de usuario

---

### Clase 6 — Estándar ISO/IEC/IEEE 29148 y estructura de la especificación

#### Objetivos
- Comprender la jerarquía de documentos de requisitos según el estándar.
- Redactar la estructura de un SRS básico.

#### Contenido teórico

**El estándar internacional para documentar requisitos**

Existe un documento oficial (ISO/IEC/IEEE 29148) que dice: "así es cómo deben documentarse los requisitos en proyectos de software profesionales." Es como un manual de mejores prácticas que usan las grandes empresas de todo el mundo.

Este estándar te dice:
- **Cómo organizar** el documento de requisitos (qué secciones obligatorias tiene).
- **Qué información debe incluir** cada requisito para que sea completo.
- **Cuál debe ser la calidad** de cada requisito para que sea válido (recuerda SMART-V).

**Jerarquía de documentos**

```
BRS  →  StRS  →  SyRS  →  SRS
(negocio) (stakeholders) (sistema) (software)
```

**BRS — Business Requirements Specification**
- ¿Por qué se hace el proyecto?
- Objetivos de negocio medibles (OKRs, KPIs).
- Restricciones empresariales y regulatorias.
- Criterios de éxito del negocio.

**StRS — Stakeholder Requirements Specification**
- ¿Qué necesitan los usuarios?
- Casos de uso de alto nivel o historias épicas.
- Características del entorno operativo.
- Necesidades de usabilidad, accesibilidad, localización.

**SyRS — System Requirements Specification**
- ¿Qué debe hacer el sistema completo (hardware + software + personas)?
- Interfaces con sistemas externos.
- Requisitos de rendimiento a nivel de sistema.
- Modos de operación (normal, degradado, emergencia).

**SRS — Software Requirements Specification**
- ¿Qué debe hacer el componente software?
- Requisitos funcionales detallados.
- Requisitos de calidad (performance, seguridad, usabilidad…).
- Restricciones de diseño e implementación.
- Interfaces de usuario, hardware y software.

**Estructura mínima de un SRS (IEEE 830 / 29148)**

```
1. Introducción
   1.1 Propósito
   1.2 Alcance del producto
   1.3 Definiciones, acrónimos y abreviaturas
   1.4 Referencias
   1.5 Visión general del documento

2. Descripción general
   2.1 Perspectiva del producto
   2.2 Funciones del producto
   2.3 Clases y características de los usuarios
   2.4 Entorno operativo
   2.5 Restricciones de diseño e implementación
   2.6 Supuestos y dependencias

3. Requisitos del sistema
   3.1 Interfaces externas
   3.2 Funcionales
   3.3 De calidad (no funcionales)
   3.4 Restricciones

4. Apéndices
   Glosario, modelos de datos, diagramas
```

**Plantilla de requisito individual**

```
ID:          REQ-[MÓDULO]-[NNN]
Título:      [Nombre corto descriptivo]
Descripción: El sistema debe [verbo en infinitivo] [objeto] [condición/restricción].
Fuente:      [Stakeholder o documento origen]
Prioridad:   Alta / Media / Baja
Estado:      Propuesto / Aprobado / Implementado / Verificado
Criterio de aceptación: [Condición medible que confirma cumplimiento]
Dependencias: [IDs de requisitos relacionados]
```

#### Actividad práctica (45 min)

**Ejercicio 6.1 — Estructura del SRS (grupos de 3)**

*Escenario:* Sistema de reservas de salas de estudio en una universidad.

1. Completen las secciones 1 y 2 del SRS (introducción y descripción general).
2. Definan el alcance, al menos 4 clases de usuarios con sus características, el entorno operativo y 3 supuestos del proyecto.

**Ejercicio 6.2 — Diferenciación de niveles (individual)**

Dados los siguientes enunciados, clasifiquen a qué nivel pertenecen (BRS / StRS / SyRS / SRS):
- "Aumentar en 30% la ocupación de salas en el primer semestre."
- "Los estudiantes deben poder reservar una sala desde su celular."
- "El sistema debe integrarse con el sistema de control de acceso por tarjeta."
- "El módulo de reservas debe responder en menos de 1.5 segundos."
- "Solo usuarios con cuenta institucional activa pueden hacer reservas."

#### Recursos
- ISO/IEC/IEEE 29148:2018 (disponible en IEEE Xplore)
- Plantilla SRS de la cátedra
- Wiegers & Beatty — *Software Requirements*, Cap. 10

---

### Clase 7 — Redacción estructurada y atributos del requisito

#### Objetivos
- Dominar patrones de redacción de requisitos funcionales.
- Gestionar los atributos de los requisitos como metadatos del proyecto.

#### Contenido teórico

#### Patrones de redacción — Escribe requisitos que todos entienden igual

En lugar de escribir algo vago, usa un patrón claro y consistente.

**Patrón básico:**
> "El sistema **debe** [acción] [qué]."

**Con condición (más realista):**
> "El sistema **debe** [acción] cuando [condición]."

**Ejemplos que funcionan:**

✅ "El sistema debe registrar una reserva cuando el estudiante confirme su selección y tenga menos de 3 préstamos activos."

✅ "El sistema debe enviar confirmación por email dentro de 5 minutos de que se registre la reserva."

✅ "El sistema debe permitir que solo administradores cancelen una reserva que comenzó hace menos de 15 minutos."

**Palabras prohibidas (demasiado vagas):**
- ❌ "fácil", "rápido", "simple", "amigable" → usa números.
- ❌ "puede", "tal vez" → sé definitivo.
- ❌ "nunca", "siempre", "absolutamente" → relaja a un valor realista.

**Palabras que establecen obligatoriedad**

Hay palabras que indican si algo es obligatorio o solo recomendado:

| Palabra | Significado | Usa cuando |
|---|---|---|
| **DEBE** | Es obligatorio, sin excepciones | El sistema DEBE autenticar al usuario antes de cualquier acción |
| **DEBERÍA** | Muy recomendado, pero hay excepciones justificables | El sistema DEBERÍA enviar recordatorios antes del vencimiento |
| **PUEDE** | Es opcional, bueno tenerlo pero no es necesario | El sistema PUEDE permitir importar datos de Excel |
| **NO DEBE** | Absolutamente prohibido | El sistema NO DEBE permitir que dos usuarios reserven la misma sala al mismo tiempo |

**¿Por qué importa?** Si escribes todo con "DEBE", el equipo no sabe qué es crítico y qué es flexible. Los desarrolladores necesitan esta claridad.

**Atributos del requisito**

Más allá del ID y la descripción, cada requisito puede tener:

| Atributo | Valores típicos | Utilidad |
|---|---|---|
| Prioridad | Alta, Media, Baja; MoSCoW | Planificación de releases |
| Estado | Propuesto, En revisión, Aprobado, Implementado, Verificado, Rechazado | Control del ciclo de vida |
| Estabilidad | Estable, Volátil, Por confirmar | Gestión de riesgos |
| Versión | 1.0, 1.1… | Control de cambios |
| Esfuerzo estimado | Story points, días/persona | Planificación |
| Riesgo | Alto, Medio, Bajo | Priorización técnica |
| Fuente | Nombre del stakeholder / documento | Trazabilidad |
| Fecha de aprobación | YYYY-MM-DD | Auditoría |

**Gestión de atributos en herramientas**  
Las herramientas de gestión de requisitos (Jira, Azure DevOps, Helix RM, Doors) permiten gestionar estos atributos de forma sistemática y generar reportes de estado del baseline.

**Errores de redacción a evitar (resumen)**
- Usar "y/o" dentro de un requisito.
- Usar voz pasiva sin agente claro: "los datos serán validados."
- Condicionales vagos: "cuando sea necesario", "según corresponda."
- Requisitos de solución: "mediante el uso de JWT tokens."
- Cuantificadores absolutos imposibles: "siempre", "nunca", "todos."

#### Actividad práctica (45 min)

**Ejercicio 7.1 — Redacción guiada (individual)**

A partir de las siguientes necesidades expresadas por stakeholders, redactar el requisito formal completo con todos sus atributos:

1. "Necesito poder ver mis reservas pasadas y futuras en un solo lugar." (Estudiante)
2. "Si alguien no llega a la sala en 15 minutos, quiero que se libere automáticamente." (Coordinador)
3. "Los administradores deben poder bloquear salas para mantenimiento." (Jefe de Infraestructura)
4. "No quiero que los alumnos de primer año reserven más de 2 horas diarias." (Decano)

**Ejercicio 7.2 — Revisión cruzada (parejas)**

Intercambiar los requisitos redactados con un compañero y aplicar la checklist de calidad. Registrar al menos 2 mejoras sugeridas por requisito.

#### Recursos
- RFC 2119 — Key words for use in RFCs to indicate requirement levels
- Mavin, A. et al. — *EARS: The Easy Approach to Requirements Syntax*
- Plantilla de atributos de requisitos (cátedra)

---

### Clase 8 — Historias de usuario y criterios INVEST

#### Objetivos
- Comprender el modelo ágil de captura de requisitos mediante historias de usuario.
- Redactar historias que cumplan los criterios INVEST.

#### Contenido teórico

**Historia de usuario**  
Una historia de usuario es una descripción breve de una funcionalidad desde la perspectiva del usuario, con el propósito de iniciar una conversación, no de documentar exhaustivamente.

**Formato estándar (Connextra)**
> "Como **[tipo de usuario]**, quiero **[acción/objetivo]** para **[beneficio/valor]**."

Ejemplos:
- "Como estudiante, quiero reservar una sala de estudio desde mi teléfono para no tener que ir a la secretaría."
- "Como administrador, quiero ver el historial de ocupación de cada sala para optimizar la asignación de recursos."

**Épicas e historias**

- **Épica**: historia de usuario demasiado grande para completarse en un sprint. Agrupa historias relacionadas.
- **Historia**: unidad entregable en un sprint (1–2 semanas).
- **Tarea**: unidad técnica interna del equipo de desarrollo.

```
Épica: Gestión de reservas de salas
├── Historia: Reservar una sala
├── Historia: Cancelar una reserva
├── Historia: Ver mis reservas
└── Historia: Recibir notificaciones de reserva
```

**Criterios INVEST — ¿Cómo sé que una historia de usuario es buena?**

INVEST es un acrónimo para recordar los 6 puntos que debe cumplir toda historia de usuario:

| Criterio | ¿Qué significa? | Pregunta para verificar |
|---|---|---|
| **I**ndependiente | No depende de otras historias. Puedes hacerla en cualquier orden. | "¿Podría completar esta historia sin esperar que terminen otras?" |
| **N**egociable | Los detalles pueden discutirse y cambiar. No es un "o lo haces así o nada." | "¿Podría el equipo decir 'hagámoslo de forma diferente'?" |
| **V**aliosa | Alguien realmente la pidió y aporta valor. | "¿A quién beneficia esta historia? ¿Le importa a alguien?" |
| **E**stimable | El equipo entiende lo suficiente para decir "esto nos toma X días." | "¿Tienen datos suficientes para estimar el trabajo?" |
| **S**mall (Pequeña) | Se completa en 1–2 semanas de trabajo. | "¿Cabe en un sprint o es demasiado grande?" |
| **T**esteable | Existe una forma clara de verificar que funciona. | "¿Puedo escribir una prueba que demuestre que se cumplió?" |

**Ejemplos de historias que VIOLAN INVEST:**

- ❌ "Como sistema, quiero indexar la tabla de usuarios..." → **Problema**: Es técnica, no aporta valor directo.
- ❌ "Como usuario, quiero poder registrarme, logearme, recuperar contraseña, editar perfil..." → **Problema**: Demasiado grande (5 historias en 1).
- ❌ "Como estudiante, quiero hacer todo lo que hacía en el sistema antiguo." → **Problema**: Vaga, demasiado grande, no estimable.

**Criterios de aceptación (Acceptance Criteria)**  
Condiciones concretas y verificables que determinan si la historia está completa.

Formato lista:
- La sala aparece como "no disponible" para otros usuarios inmediatamente después de la reserva.
- El estudiante recibe un correo de confirmación en menos de 5 minutos.
- Si la sala ya está ocupada, el sistema muestra un mensaje de error claro.

#### Actividad práctica (45 min)

**Ejercicio 8.1 — De épica a historias (grupos de 3)**

Descompongan la siguiente épica en al menos 5 historias de usuario:

*Épica:* "Como docente universitario, quiero gestionar mis materiales de clase en una plataforma digital para facilitar el acceso de los estudiantes."

Para cada historia:
1. Redáctela en formato Connextra.
2. Evalúenla contra los criterios INVEST.
3. Escriban 3 criterios de aceptación.

**Ejercicio 8.2 — Diagnóstico INVEST (individual)**

Evalúen las siguientes historias e identifiquen qué criterio INVEST violan:
- "Como administrador, quiero que el sistema esté bien hecho."
- "Como usuario, quiero registrarme, iniciar sesión, recuperar contraseña y ver mi perfil."
- "Como base de datos, quiero que mis índices estén optimizados."
- "Como estudiante, quiero hacer todo lo que hacía en el sistema anterior."

#### Recursos
- Cohn, M. — *User Stories Applied*, Cap. 2–4
- Wake, B. — INVEST in Good Stories (artículo original, XP123)
- Adzic, G. — *Specification by Example*, Cap. 1

---

### Clase 9 — BDD, lenguaje Gherkin y especificación mediante ejemplos

#### Objetivos
- Comprender el paradigma Behavior-Driven Development (BDD).
- Escribir escenarios en Gherkin que sirvan de especificación y de prueba.

#### Contenido teórico

**Especificación mediante ejemplos en lugar de palabras vagas**

En lugar de escribir: "El sistema debe aplicar un descuento según el tipo de cliente," es mejor mostrar ejemplos concretos:

- Si compras como cliente estándar: descuento 0%
- Si compras como cliente premium y gastas $100: descuento 10%
- Si compras como cliente premium y gastas $500: descuento 15%

Así todos entienden exactamente qué pasa. Los ejemplos hacen la especificación cristalina.

**BDD — Desarrollo orientado por comportamiento**

BDD es simplemente: "Especifica el comportamiento del sistema usando ejemplos, y luego escribe pruebas automatizadas basadas en esos ejemplos." Los ejemplos sirven como especificación Y como pruebas.

**Lenguaje Gherkin — Escribir especificaciones que parecen en inglés simple**

Gherkin es un lenguaje simple que parece inglés normal (o español) y se usa para escribir especificaciones que también son pruebas automatizadas.

**Estructura básica:**

```gherkin
Funcionalidad: Hacer una reserva de sala

  Como estudiante
  Quiero poder reservar una sala disponible
  Para estudiar con mis compañeros

  Escenario: Reservar una sala disponible
    Dado que la sala 101 está disponible mañana de 2-4pm
    Cuando hago una reserva para mañana 2-4pm
    Entonces la reserva se confirma
    Y recibo un email de confirmación

  Escenario: No puedo reservar una sala ocupada
    Dado que la sala 101 está ocupada mañana de 2-4pm
    Cuando intento reservar la sala 101 para mañana 2-4pm
    Entonces me muestra un error "Sala no disponible"
```

**Palabras clave que debes conocer:**
- **Funcionalidad**: agrupa varios escenarios de una capacidad.
- **Escenario**: un caso específico (qué pasa si... qué pasa cuando...).
- **Dado**: el estado inicial, lo que ya existe (precondiciones).
- **Cuando**: la acción que hace el usuario.
- **Entonces**: el resultado que debe ocurrir (verificable).

**Herramientas BDD populares**

| Herramienta | Lenguaje | Framework |
|---|---|---|
| Cucumber | Java, JS, Ruby, Python | JUnit, RSpec |
| Behave | Python | — |
| SpecFlow | .NET/C# | NUnit, xUnit |
| Playwright + Cucumber | JS/TS | — |

#### Actividad práctica (50 min)

**Ejercicio 9.1 — Feature completa en Gherkin (grupos de 3)**

Escriban una Feature completa para la siguiente historia de usuario:

*"Como estudiante, quiero cancelar una reserva con al menos 1 hora de anticipación para liberar la sala y que otros puedan usarla."*

Requisitos:
- Al menos 4 escenarios (caso exitoso, cancelación tardía, reserva inexistente, reserva de otro usuario).
- Usar `Scenario Outline` para al menos un caso con múltiples datos.
- Todos los pasos en lenguaje de dominio.

**Ejercicio 9.2 — Encontrar los ejemplos (individual)**

Dada la siguiente regla de negocio, identifiquen al menos 6 ejemplos que la cubran (incluyendo casos borde y negativos):

*"Los usuarios premium pueden tener hasta 3 reservas activas simultáneas; los usuarios estándar, solo 1. Las reservas vencidas no cuentan como activas."*

#### Ejercicio de código — Clase 09: De Gherkin a código ejecutable con pytest (30 minutos)

**Problema:** escribiste escenarios Gherkin en el Ejercicio 9.1, pero ¿cómo se convierten en pruebas reales? Vamos a tomar un escenario Gherkin y ejecutarlo con Python y `pytest-bdd`.

**Paso 1 — Instala la librería:**
```bash
pip install pytest pytest-bdd
```

**Paso 2 — Crea la estructura de archivos:**
```
reservas/
  features/
    cancelar_reserva.feature
  tests/
    test_cancelar_reserva.py
  dominio.py
```

**`reservas/features/cancelar_reserva.feature`** (Gherkin — solo lectura humana + máquina):
```gherkin
# language: es
Característica: Cancelar una reserva de sala

  Escenario: Cancelación exitosa con anticipación suficiente
    Dado que existe una reserva para dentro de 2 horas
    Cuando el estudiante solicita cancelar la reserva
    Entonces la reserva queda cancelada
    Y la sala vuelve a estar disponible

  Escenario: Cancelación tardía rechazada
    Dado que existe una reserva que comienza en 30 minutos
    Cuando el estudiante solicita cancelar la reserva
    Entonces el sistema rechaza la cancelación
    Y la reserva sigue activa
```

**`reservas/dominio.py`** (lógica de negocio pura — sin frameworks):
```python
from datetime import datetime, timedelta

class Reserva:
    ANTICIPACION_MINIMA = timedelta(hours=1)

    def __init__(self, inicio: datetime):
        self.inicio = inicio
        self.activa = True

    def puede_cancelarse(self, ahora: datetime = None) -> bool:
        ahora = ahora or datetime.now()
        return self.activa and (self.inicio - ahora) >= self.ANTICIPACION_MINIMA

    def cancelar(self, ahora: datetime = None) -> bool:
        if self.puede_cancelarse(ahora):
            self.activa = False
            return True
        return False
```

**`reservas/tests/test_cancelar_reserva.py`** (pasos que conectan Gherkin con código):
```python
import pytest
from datetime import datetime, timedelta
from pytest_bdd import scenarios, given, when, then
from reservas.dominio import Reserva

scenarios("../features/cancelar_reserva.feature")

AHORA = datetime(2024, 9, 1, 10, 0)  # Momento fijo para pruebas

# ---------- Datos de contexto ----------
@pytest.fixture
def contexto():
    return {}

# ---------- Pasos Given ----------
@given("que existe una reserva para dentro de 2 horas")
def reserva_con_anticipacion(contexto):
    contexto["reserva"] = Reserva(inicio=AHORA + timedelta(hours=2))
    contexto["ahora"] = AHORA

@given("que existe una reserva que comienza en 30 minutos")
def reserva_sin_anticipacion(contexto):
    contexto["reserva"] = Reserva(inicio=AHORA + timedelta(minutes=30))
    contexto["ahora"] = AHORA

# ---------- Paso When ----------
@when("el estudiante solicita cancelar la reserva")
def solicitar_cancelacion(contexto):
    contexto["resultado"] = contexto["reserva"].cancelar(ahora=contexto["ahora"])

# ---------- Pasos Then ----------
@then("la reserva queda cancelada")
def reserva_cancelada(contexto):
    assert contexto["resultado"] is True
    assert contexto["reserva"].activa is False

@then("la sala vuelve a estar disponible")
def sala_disponible(contexto):
    # En un sistema real verificarías en el repositorio de salas
    assert contexto["reserva"].activa is False

@then("el sistema rechaza la cancelación")
def cancelacion_rechazada(contexto):
    assert contexto["resultado"] is False

@then("la reserva sigue activa")
def reserva_sigue_activa(contexto):
    assert contexto["reserva"].activa is True
```

**Paso 3 — Ejecuta las pruebas:**
```bash
cd reservas
pytest tests/ -v
```

**Salida esperada:**
```
PASSED  test_cancelar_reserva.py::test_cancelación_exitosa_con_anticipación_suficiente
PASSED  test_cancelar_reserva.py::test_cancelación_tardía_rechazada
```

**Paso 4 — Agrega un tercer escenario tú mismo:**  
Escribe en el `.feature` el escenario "Reserva inexistente" (una reserva que ya fue cancelada no puede cancelarse de nuevo). Agrega los pasos en el archivo de prueba.

**Preguntas de cierre:**
- ¿En qué punto del proceso colocas al stakeholder para validar que el escenario Gherkin refleja lo que él necesita?
- ¿Qué ventaja tiene escribir el `.feature` primero y el código después? ¿Y qué desventaja?
- La clase `Reserva` no importa ningún framework. ¿Por qué eso es una ventaja para las pruebas?

#### Recursos
- North, D. — *Introducing BDD* (artículo fundacional, dannorth.net)
- Adzic, G. — *Specification by Example*, Cap. 3–5
- Cucumber docs: cucumber.io/docs/gherkin

---

### Clase 10 — Refinamiento del backlog y uso de IA para borradores

#### Objetivos
- Aplicar técnicas de refinamiento del backlog de producto.
- Usar IA generativa como asistente de redacción controlado.

#### Contenido teórico

**Backlog de producto — La lista de trabajo priorizada**

Imagina una pila de historias ordenadas por importancia. La más importante está arriba. El equipo siempre trabaja en lo que está arriba de la pila.

Incluye todo: historias de usuario, mejoras, corrección de bugs, investigaciones técnicas. Es la única "fuente de verdad" sobre qué hacer.

**Refinamiento — Preparar la pila antes de trabajarla**

Antes de que el equipo empiece a trabajar, alguien debe:
1. Dividir historias grandes en historias pequeñas (si es necesario).
2. Escribir criterios de aceptación claros.
3. Estimar cuánto trabajo es cada una.
4. Identificar si depende de otras historias.
5. Revisar y actualizar prioridades.

Esto debe hacerse continuamente, no es un evento único. Recomendación: 10% del tiempo del equipo debe ir a refinamiento.

**Checklist: ¿Está lista una historia para que el equipo la trabaje? (Definition of Ready)**

Antes de que un programador empiece a codificar una historia, debe estar clara y lista. El checklist mínimo es:

- ✅ La historia está escrita clara y corta (formato "Como ... quiero ... para ...").
- ✅ Tiene criterios de aceptación (ejemplos de qué significa "hecho").
- ✅ El equipo estimó cuánto trabajo es (small, medium, large).
- ✅ No depende de otras historias que aún no están terminadas.
- ✅ Si hay mockups o diseños, están disponibles.
- ✅ Si hay reglas de negocio, están documentadas.

Si falta algo de esto, la historia no está lista y debe refinarse primero.

**Checklist: ¿Está realmente terminada una historia? (Definition of Done)**

Para que el Product Owner acepte que una historia está "hecha," debe cumplir:

- ✅ El código está escrito y guardado en el repositorio.
- ✅ Hay pruebas automatizadas que verifican que funciona.
- ✅ Otro programador revisó el código (code review).
- ✅ La documentación está actualizada.
- ✅ Se probó en el servidor de pruebas (no solo en la máquina del programador).
- ✅ Cumple con los requisitos de calidad (es rápido, seguro, accesible, etc.).

Si falta algo, no está "Done" todavía, aunque parezca funcionar.

**Uso de IA para redactar borradores de historias**  
La IA puede acelerar la generación inicial de historias a partir de descripciones de alto nivel. El analista actúa como **revisor crítico**, no como receptor pasivo.

*Flujo de trabajo con IA:*

```
1. Proporcionar contexto del dominio y stakeholders
2. Solicitar borradores de historias con criterios de aceptación
3. Revisar cada historia contra los criterios INVEST
4. Validar el lenguaje con stakeholders reales
5. Aprobar, rechazar o modificar
```

*Prompt efectivo:*
```
Eres un analista de requisitos experto en metodologías ágiles.
Dominio: [descripción del contexto del negocio].
Stakeholders principales: [lista de roles].
A partir de la siguiente épica: "[texto de la épica]",
genera 5 historias de usuario en formato Connextra con 3 criterios 
de aceptación cada una. Verifica que cada historia cumpla INVEST.
Señala explícitamente si algún criterio no se puede garantizar 
sin más información del dominio.
```

> **Punto crítico de validación**: la IA puede inventar reglas de negocio que no existen. Todo criterio de aceptación generado por IA debe ser confirmado con el Product Owner o stakeholder antes de entrar al backlog.

#### Actividad práctica (45 min)

**Ejercicio 10.1 — Sesión de refinamiento simulada (grupos de 4)**

Se les entrega un backlog inicial de 10 historias sin criterios de aceptación ni estimaciones para el sistema de reservas de salas.

1. Apliquen DoR a cada historia: ¿está lista para entrar a un sprint?
2. Descompongan al menos 2 historias que no cumplan el criterio "Small."
3. Redacten o completen los criterios de aceptación de 3 historias.
4. Prioricen el backlog usando MoSCoW.

**Ejercicio 10.2 — Revisión crítica de historias generadas por IA (individual)**

Se proporcionan 5 historias generadas por un LLM para el sistema de la clase. El estudiante debe:
1. Evaluar cada historia con INVEST.
2. Identificar al menos 3 errores o riesgos.
3. Corregir o descartar las historias problemáticas.
4. Documentar qué se puede aprovechar y qué no.

#### Recursos
- Cohn, M. — *Agile Estimating and Planning*, Cap. 5–6
- Pichler, R. — *Agile Product Management with Scrum*, Cap. 3
- Scrumguides.org — The Scrum Guide (versión oficial 2020)

---

## Unidad 3. Calidad, validación y trazabilidad

---

### Clase 11 — Requisitos funcionales vs. de calidad e ISO/IEC 25010

#### Objetivos
- Distinguir requisitos funcionales de requisitos de calidad (no funcionales).
- Aplicar el modelo ISO/IEC 25010 para estructurar requisitos de calidad.

#### Contenido teórico

**¿Requisito funcional o de calidad? — ¿Qué hace vs. cuán bien lo hace?**

| Pregunta | Tipo | Ejemplo |
|---|---|---|
| ¿**QUÉ** puede hacer el usuario? | Funcional | "El estudiante puede reservar una sala para estudiar" |
| ¿**CUÁN BIEN** o **CUÁN RÁPIDO** lo hace? | De calidad | "La reserva se confirma en menos de 2 segundos" |
| ¿Es **VISIBLE** para el usuario final? | Funcional | Sí (ve el botón, ve la reserva) |
| ¿Es **INVISIBLE** pero **IMPORTANTE**? | Calidad | Sí (el usuario siente que es rápido, pero no ve el código) |

**Ejemplos:**
- ❌ Incorrecto: "El sistema es rápido." → No es mensurable.
- ✅ Correcto: "Las búsquedas devuelven resultados en 2 segundos para catálogos de hasta 100,000 libros." → Mensurable.

- ❌ Incorrecto: "El sistema es seguro." → ¿Qué significa seguro?
- ✅ Correcto: "Las contraseñas se encriptan con AES-256 y solo administradores ven datos de usuarios." → Claro.

**ISO/IEC 25010:2023 — Un "checklist de calidad" del software**

Existe un documento internacional que agrupa todas las características de calidad en 8 grupos. Es como un checklist que haces antes de lanzar:

| Característica | ¿Qué significa? | Ejemplo de requisito |
|---|---|---|
| **¿Hace lo que promete?** (Adecuación funcional) | ¿Todas las funciones funcionan correctamente? | "Buscar libros devuelve exactamente lo que coincide con la búsqueda" |
| **¿Es rápido?** (Eficiencia de rendimiento) | ¿Responde en tiempo razonable? | "Las búsquedas responden en menos de 2 segundos" |
| **¿Funciona en múltiples plataformas?** (Compatibilidad) | ¿Funciona en distintos navegadores, sistemas operativos? | "El sistema funciona en Chrome, Firefox, Safari e Internet Explorer" |
| **¿Es fácil de usar?** (Usabilidad) | ¿Entienden cómo usarlo sin ayuda? | "El 95% de nuevos usuarios pueden hacer una reserva en menos de 3 minutos" |
| **¿Es confiable?** (Fiabilidad) | ¿Sigue funcionando o se cae? | "El sistema estará disponible 99% del tiempo (máximo 7 horas/mes de caída)" |
| **¿Es seguro?** (Seguridad) | ¿Los datos están protegidos? | "Solo el dueño de la reserva puede verla; la contraseña se encripta" |
| **¿Es mantenible?** (Mantenibilidad) | ¿Otro programador puede entender y modificar el código? | "Más del 80% del código tiene pruebas unitarias automatizadas" |
| **¿Se puede cambiar a otro sistema fácilmente?** (Portabilidad) | ¿Se puede desinstalar sin dejar basura? | "Los datos se pueden exportar a CSV estándar" |

**Escenario de calidad**  
Un escenario de calidad es la forma estructurada de especificar un requisito de calidad. Componentes:

| Componente | Descripción | Ejemplo |
|---|---|---|
| **Fuente** | Quién o qué genera el estímulo | 500 usuarios simultáneos |
| **Estímulo** | El evento que activa la respuesta | Solicitan búsqueda simultáneamente |
| **Entorno** | Condiciones del sistema al momento | Carga pico, hora de máxima demanda |
| **Artefacto** | Parte del sistema que responde | Módulo de búsqueda |
| **Respuesta** | Comportamiento del sistema | Devuelve resultados |
| **Medida de respuesta** | Métrica cuantificable | En ≤ 2 segundos, tasa de error < 0.1% |

**Métricas de calidad**

- **Disponibilidad**: `(tiempo total - tiempo de inactividad) / tiempo total × 100%`. Ej: 99.9% = 8.76 h/año de inactividad.
- **Tiempo de respuesta**: percentil 95 o 99 (no el promedio).
- **Throughput**: transacciones por segundo bajo carga definida.
- **MTTF/MTTR**: tiempo medio entre fallos / tiempo medio de recuperación.
- **Tasa de defectos**: defectos por KLOC o por punto de función.

#### Actividad práctica (45 min)

**Ejercicio 11.1 — Clasificación y estructuración (individual)**

Para cada uno de los siguientes requisitos, indiquen:
a) Si es funcional o de calidad.
b) Si es de calidad, a qué característica ISO 25010 pertenece.
c) Si es ambiguo, reescríbanlo como escenario de calidad completo.

1. "El sistema debe mostrar los resultados de búsqueda ordenados por relevancia."
2. "La aplicación debe ser rápida."
3. "El sistema debe estar disponible el 99.5% del tiempo."
4. "La interfaz debe ser fácil de usar."
5. "El sistema debe funcionar en Chrome, Firefox y Safari."
6. "Los datos del usuario no deben ser accesibles por personal no autorizado."

**Ejercicio 11.2 — Escenarios de calidad (grupos de 3)**

Para el sistema de reservas de salas, redacten escenarios de calidad completos para:
- Performance (carga pico al inicio del semestre).
- Disponibilidad (falla de servidor durante exámenes).
- Seguridad (intento de acceso no autorizado).

#### Recursos
- ISO/IEC 25010:2023 — SQuaRE Quality Model
- Bass, L., Clements, P. & Kazman, R. — *Software Architecture in Practice*, Cap. 4
- Richards, M. & Ford, N. — *Fundamentals of Software Architecture*, Cap. 6

---

### Clase 12 — Métricas, umbrales y accesibilidad WCAG 2.2

#### Objetivos
- Definir métricas y umbrales verificables para requisitos de calidad.
- Comprender los principios de accesibilidad WCAG 2.2.

#### Contenido teórico

**Estándares para verificar la calidad (Quality Gates)**

Antes de que un sistema salga a producción, debe pasar varias "pruebas de calidad." Piensa en un control de calidad en una fábrica: si un producto no cumple los estándares, no pasa. En software funciona igual:

- "La aplicación debe responder en menos de 2 segundos el 95% del tiempo."
- "El código debe tener al menos 80% de pruebas automatizadas."
- "No puede haber vulnerabilidades de seguridad graves."
- "Las personas con discapacidad visual deben poder navegar la aplicación."

Si el sistema no cumple estos estándares, **no puede lanzarse**.

**Cuando sacrificas calidad por prisa (Deuda técnica)**

A veces, por presión de tiempo, el equipo dice: "Saltamos esta validación o bajamos la calidad para lanzar rápido." Es como pedir un préstamo: sacas dinero rápido, pero después tienes que pagarlo con intereses.

Ejemplo: "El sistema solo responde en 5 segundos en lugar de 2, pero lo lanzamos igual. Lo arreglamos después."

El problema es:
1. Debes documentarlo explícitamente (para no olvidarlo).
2. Debes tener un plan de "pago" (cuándo arreglarlo).
3. No puede convertirse en la norma (el sistema lento y nadie lo arregla nunca).

**Accesibilidad — WCAG 2.2**  
Las Web Content Accessibility Guidelines definen cómo hacer el contenido web accesible para personas con discapacidades. Se organizan en 4 principios (**POUR**):

| Principio | Descripción |
|---|---|
| **P**erceptible | La información debe ser presentada de formas que los usuarios puedan percibir |
| **O**perable | La interfaz debe ser operable por distintos medios de entrada |
| **U**nderstandable | El contenido y la operación deben ser comprensibles |
| **R**obust | El contenido debe ser suficientemente robusto para ser interpretado por tecnologías de asistencia |

**Niveles de conformidad WCAG:**
- **Nivel A**: Mínimo. Barreras severas de acceso eliminadas.
- **Nivel AA**: Estándar internacional. Requerido por la mayoría de legislaciones.
- **Nivel AAA**: Óptimo. No siempre alcanzable para todo el contenido.

**Criterios WCAG 2.2 clave (nivel AA):**
- 1.4.3: Contraste de texto ≥ 4.5:1 (texto normal), ≥ 3:1 (texto grande).
- 2.1.1: Todo el contenido operable con teclado.
- 2.4.7: El foco de teclado visible.
- 3.3.2: Etiquetas o instrucciones en formularios.
- 4.1.2: Nombre, rol y valor para componentes de interfaz.

**Nuevos criterios en WCAG 2.2 (vs. 2.1):**
- 2.4.11: Foco no oscurecido (mínimo).
- 2.5.7: Movimientos de arrastre con alternativa.
- 2.5.8: Tamaño mínimo del objetivo táctil (24×24 px).
- 3.2.6: Ayuda consistente.
- 3.3.7: Autenticación accesible.

**Incorporación de accesibilidad en los requisitos**

```
REQ-ACC-001
Descripción: Todos los formularios del sistema deberán tener etiquetas 
             asociadas programáticamente a sus campos de entrada.
Criterio de aceptación: Auditoría con WAVE o axe DevTools sin errores 
                        en criterio 1.3.1 y 4.1.2 (WCAG 2.2 AA).
Verificación: Herramienta: axe-core, ejecutada en CI/CD.
```

#### Actividad práctica (45 min)

**Ejercicio 12.1 — Definición de puertas de calidad (grupos de 3)**

Para el sistema de reservas de salas, definan puertas de calidad para:
- Performance: criterios de aprobación para el deploy a producción.
- Disponibilidad: SLA para la fase de operación inicial.
- Seguridad: criterios previos al lanzamiento.
- Usabilidad: criterios de aceptación de UX antes del piloto.

**Ejercicio 12.2 — Auditoría de accesibilidad (individual)**

Con la extensión axe DevTools (Chrome/Firefox):
1. Auditen una página web pública (asignada por el docente).
2. Documenten los 5 errores de mayor impacto.
3. Para cada error: criterio WCAG violado, nivel (A/AA/AAA), impacto en el usuario, corrección propuesta.
4. Redacten un requisito de accesibilidad para corregir el error más crítico.

#### Recursos
- W3C WCAG 2.2: w3.org/TR/WCAG22
- WebAIM: webaim.org (recursos y herramientas de accesibilidad)
- axe DevTools: deque.com/axe
- WAVE: wave.webaim.org

---

### Clase 13 — Verificación, validación y prototipado

#### Objetivos
- Distinguir verificación de validación en el contexto de requisitos.
- Aplicar técnicas de prototipado para reducir ambigüedad.

#### Contenido teórico

**Verificación vs. Validación**

| Aspecto | Verificación | Validación |
|---|---|---|
| Pregunta | ¿Construimos el producto correctamente? | ¿Construimos el producto correcto? |
| Referencia | Especificación (SRS) | Necesidades reales del stakeholder |
| Quién | Equipo técnico | Stakeholders + equipo |
| Momento | Durante el desarrollo | Al final de cada iteración o fase |
| Técnica | Revisión, inspección, prueba | Demo, prototipo, prueba de aceptación |

**Técnicas de verificación de requisitos**

1. **Revisión informal**: lectura y retroalimentación entre pares.
2. **Walkthrough**: el autor guía a los revisores a través del documento.
3. **Inspección (Fagan)**: proceso formal con roles definidos (moderador, autor, inspector, lector). La más efectiva pero también la más costosa.
4. **Revisión basada en checklist**: verificación sistemática contra criterios predefinidos.

**Prototipado para validación**

| Tipo | Fidelidad | Cuándo usar | Herramientas |
|---|---|---|---|
| Boceto en papel | Baja | Ideas iniciales, exploración | Papel, lápiz |
| Wireframe | Media | Estructura y flujo | Balsamiq, Whimsical |
| Mockup | Media-alta | Diseño visual sin interacción | Figma, Adobe XD |
| Prototipo interactivo | Alta | Validación de usabilidad y flujo | Figma (prototipo), InVision |
| Prototipo funcional (spike) | Alta | Validación técnica | Código real (desechable) |

**El peligro del prototipo como compromiso**  
Un prototipo de baja fidelidad comunica "esto es solo una idea." Un prototipo de alta fidelidad puede crear en el stakeholder la expectativa de que el producto está casi listo. Es responsabilidad del analista gestionar estas expectativas explícitamente.

**Ciclo de validación con prototipo**

```
Requisitos candidatos
        ↓
Prototipo (baja/media fidelidad)
        ↓
Sesión de validación con stakeholders
        ↓
Feedback → Identificar gaps y malentendidos
        ↓
Actualizar requisitos
        ↓
Repetir si es necesario
```

**Revisión técnica formal (Fagan Inspection)**  
Fases: Planning → Overview → Preparation → Inspection Meeting → Rework → Follow-up.  
Métrica clave: **tasa de defectos** encontrados por hora de revisión.

**Tipos de defectos encontrados en revisiones de requisitos:**
- Omisión (falta un requisito necesario)
- Ambigüedad (múltiples interpretaciones)
- Inconsistencia (contradicción con otro requisito)
- Error de hecho (información incorrecta del dominio)
- Requisito innecesario (gold plating)

#### Actividad práctica (45 min)

**Ejercicio 13.1 — Inspección de requisitos (grupos de 4, roles asignados)**

Se entrega un SRS parcial con defectos deliberados (15 requisitos).

- **Moderador**: coordina la sesión, registra tiempo.
- **Autor**: responde preguntas de clarificación.
- **2 Inspectores**: revisan contra checklist de calidad.

Entregable: lista de defectos con tipo, ubicación y severidad.  
Métrica a calcular: defectos por requisito, defectos por tipo.

**Ejercicio 13.2 — Prototipo en Figma (grupos de 3)**

Para 3 historias de usuario del sistema de reservas:
1. Diseñen wireframes de las pantallas implicadas.
2. Conecten las pantallas creando un flujo interactivo básico.
3. Realicen una micro-sesión de validación con un compañero que actúa como usuario.
4. Documenten 3 problemas de usabilidad detectados y los requisitos que deben actualizarse.

#### Recursos
- Gilb, T. & Graham, D. — *Software Inspection*, Cap. 3–4
- Nielsen, J. — *Usability Engineering*, Cap. 4 (prototipado)
- Figma: figma.com (plan gratuito)

---

### Clase 14 — Trazabilidad y matriz de trazabilidad

#### Objetivos
- Comprender la trazabilidad como mecanismo de gestión de requisitos.
- Construir y mantener una matriz de trazabilidad.

#### Contenido teórico

**¿Qué es la trazabilidad? — "¿De dónde salió este código?"**

Imagina que tienes 100 requisitos y 50 desarrolladores. En 6 meses alguien te pregunta: "¿Por qué existe esta línea de código?"

**Sin trazabilidad:** "Ehh... no sé. Alguien la escribió hace meses."  
**Con trazabilidad:** "Porque el requisito REQ-042 lo pedía, que fue solicitado por el coordinador académico, validado en la prueba TC-083."

La trazabilidad es un **mapa que conecta:**
- ¿De dónde salió este requisito? (stakeholder)
- ¿Quién lo implementó? (desarrollador, código)
- ¿Cómo se verifica que funciona? (prueba)

| Pregunta | Con trazabilidad | Sin trazabilidad |
|---|---|---|
| "¿Implementamos REQ-042?" | Sí, en el módulo de login, código en `AuthService.java:45`, prueba `TC-083` | ¿Cuál es REQ-042? No sé |
| "Si cambio REQ-042, ¿qué más falla?" | Login, recuperación de contraseña, auditoría | Quién sabe, posiblemente todo |
| "¿Tenemos pruebas de todos los requisitos?" | 48/50 (96% de cobertura) | No tenemos idea |

**Matriz de trazabilidad (RTM) — La planilla que conecta todo**

Una tabla simple que documenta: "Para cada requisito, ¿dónde está implementado y dónde se prueba?"

| ID | ¿Qué es? | ¿Quién lo pidió? | ¿Dónde está el código? | ¿Hay prueba? | ¿Está listo? |
|---|---|---|---|---|---|
| REQ-001 | Reservar sala | Coordinación | `ReservaService.java:42` | Sí, TC-010 | ✅ Listo |
| REQ-002 | Cancelar reserva | Dirección | `ReservaService.java:87` | Sí, TC-011 | ✅ Listo |
| REQ-003 | Notificar por mail | Coordinación | `NotificadorEmail.java:15` | NO (falta) | ⚠️ Incompleto |
| REQ-004 | Reporte mensual | Dirección | NO (falta código) | NO (falta) | ❌ No hecho |

**¿Cuál es el valor?**
- Rápidamente ves qué falta implementar o probar.
- Cuando cambias un requisito, sabes exactamente qué código y qué pruebas afecta.
- Auditoría: "¿Verificaste que REQ-001 funciona?" → "Sí, en TC-010."

**Niveles de trazabilidad — Lo que conectas**

Piensa en trazabilidad como un "hilo rojo" que va desde el objetivo de negocio hasta el código:

```
"Queremos que la universidad capture más estudiantes" (¿Por qué?)
            ↓
"Los estudiantes quieren reservar salas online sin ir a coordin." (¿Qué necesitan?)
            ↓
"El sistema debe permitir inscripción por web con pago integrado" (¿Qué requisitos?)
            ↓
"En ReservaController.java línea 42, método crearReserva()" (¿Código dónde?)
            ↓
"Prueba TC-055: crear reserva de una sala, validar que se registre en BD" (¿Cómo verificas?)
```

Cada nivel es un "hilo" que puedes seguir hacia atrás o adelante:
- **Hacia atrás:** "Código en línea 42 → ¿Por qué existe?" → "REQ-007 → ¿Por qué REQ-007?" → "Necesidad del usuario"
- **Hacia adelante:** "Objetivo de negocio → ¿Qué requisitos?" → "¿Dónde está codificado?" → "¿Cómo se verifica?"

**¿Por qué importa la trazabilidad? — Tres razones críticas**

| Problema | Sin trazabilidad | Con trazabilidad |
|---|---|---|
| **Cambio de requisito** | "REQ-003 cambió, cambio el código... ¿eso es todo? ¿Hay pruebas?" | "REQ-003 impacta código en 3 archivos y 7 pruebas. Todas actualizadas." |
| **Pruebas incompletas** | "Creo que probamos todo... probablemente." | "Falta prueba para REQ-005. Cobertura: 48/50 (96%)" |
| **Auditoría o cambios futuros** | "¿Por qué existe esta línea? Nadie lo sabe." | "Línea 42: requisito REQ-042 solicitado por Dirección, validado en TC-083." |

**Herramientas para gestión de trazabilidad**

| Herramienta | Tipo | Características |
|---|---|---|
| Jira + Xray | Comercial | Integración ágil, trazabilidad test-historia |
| Azure DevOps | Comercial | Pipeline completo, trazabilidad work items |
| Helix RM (ex-Hansoft) | Especializada | Conforme DO-178, ISO 26262 |
| IBM Doors | Especializada | Sector aeroespacial y defensa |
| ReqView | Ligera | Exporta RTM a Excel, asequible |
| Confluence + Jira | Semi-manual | Para equipos ágiles pequeños |

**Mantenimiento de la RTM**  
La RTM no se actualiza sola. Debe haber un proceso definido:
1. Cada nuevo requisito aprobado → agrega fila a la RTM.
2. Cada tarea de desarrollo cerrada → actualiza estado de cobertura.
3. Cada prueba creada → vincula al requisito correspondiente.
4. Cada cambio de requisito → actualiza impacto en diseño y pruebas.

#### Actividad práctica (45 min)

**Ejercicio 14.1 — Construcción de RTM (grupos de 3)**

Se entrega un SRS de 12 requisitos y una lista de 10 casos de prueba.

1. Construyan la RTM completa.
2. Identifiquen requisitos sin cobertura de prueba.
3. Identifiquen pruebas que no rastrean a ningún requisito (pruebas huérfanas).
4. Calculen el porcentaje de cobertura de requisitos.

**Ejercicio 14.2 — Análisis de impacto (individual)**

Dado el siguiente cambio en un requisito:

*"REQ-005 se modifica: el tiempo máximo de cancelación pasa de 1 hora a 30 minutos de anticipación."*

1. Identifiquen todos los artefactos impactados usando la RTM del ejercicio anterior.
2. Describan qué cambios son necesarios en cada artefacto.
3. Estimen el esfuerzo relativo del cambio (bajo/medio/alto) y justifiquen.

#### Recursos
- Wiegers & Beatty — *Software Requirements*, Cap. 26–27
- IREB CPRE Advanced Level — Traceability Module
- Plantilla RTM en Excel (cátedra)

---

### Clase 15 — Priorización, línea base y control de cambios

#### Objetivos
- Aplicar técnicas de priorización de requisitos.
- Gestionar la línea base y el proceso formal de control de cambios.

#### Contenido teórico

**Técnicas para decidir "¿Cuál hacemos primero?"**

**1. MoSCoW — Clasificación por importancia**

Divide todos los requisitos en 4 categorías:

| Categoría | ¿Qué es? | Ejemplo |
|---|---|---|
| 🔴 **MUST** (Imprescindible) | Sin esto, el producto no funciona. Sin negociación. | "Los estudiantes deben poder inscribirse en línea" |
| 🟡 **SHOULD** (Importante) | Muy valioso, pero se puede diferir a la versión 2. Hay formas alternativas. | "Poder ver horarios en tiempo real" |
| 🟢 **COULD** (Deseable) | Sería lindo tenerlo si hay tiempo. Bajo impacto si se omite. | "Notificaciones por SMS además de email" |
| ⚪ **WON'T** (Fuera de alcance) | No en esta versión. Posible para el futuro. | "Integración con sistemas de otras universidades" |

⚠️ **Trampa común**: 80% de los requisitos termina marcado como "MUST". Fuerza a tu equipo a ser más honesto: máximo 60% MUST, mínimo 10% WON'T.

**2. Valor vs. Esfuerzo — Matriz de priorización visual**

Haz una gráfica y ubica cada requisito según:
- Eje X: ¿Cuánto trabajo cuesta? (poco a mucho)
- Eje Y: ¿Cuánto valor aporta? (poco a mucho)

```
        Alto valor
            |
  "Hacer    |  "Quick wins"
   luego"   |  (HAZLO PRIMERO)
            |
____________|____________→ Bajo esfuerzo
            |
 "Descartar"|  "Hacer si hay
            |   tiempo"
        Bajo valor
```

**3. Valor vs. Riesgo técnico**

A veces, un requisito tiene poco riesgo técnico (fácil de hacer) pero es muy importante. Otros tienen alto riesgo (complejo, desconocido). Los de alto valor + alto riesgo deben abordarse primero para reducir la incertidumbre.

**¿Cuándo congelamos los requisitos? — "A partir de ahora, nada cambia"**

En algún momento, el equipo tiene que decir: "OK, estos son los requisitos. No cambiamos más a menos que haya un motivo MUY importante."

¿Por qué? Porque si todo cambia todo el tiempo:
- Los desarrolladores nunca termina.
- Las pruebas se vuelven obsoletas.
- No sabes cuándo terminará el proyecto.

Es como trabajar en un auto en movimiento: si el cliente sigue pidiendo cambios cada día, nunca lo terminas.

| En proyectos tradicionales (Cascada) | En proyectos ágiles (Scrum) |
|---|---|
| Congelamos después de 2-3 meses de análisis | Congelamos cada 2 semanas (al inicio del sprint) |
| Se espera que casi no haya cambios | Se espera algún cambio, pero controlado |
| Si hay cambio, es un gran proceso | Si hay cambio, se decide en la reunión del sprint |

**Línea base (Baseline):** Es la versión de requisitos "congelada" que vamos a implementar. Una vez que la apruebas, cualquier cambio pasa por un proceso formal.

**¿Cómo se gestiona un cambio? — Un proceso simple para decisiones formales**

Incluso después de congelar los requisitos, aparecen cambios. Pero no puedes simplemente cambiar todo de la noche a la mañana. Hay un proceso que evita caos:

```
1️⃣ Alguien solicita un cambio
   "Necesitamos que las reservas también se hagan por WhatsApp"

2️⃣ Se documenta: ¿Qué? ¿Por qué? ¿Cuánto trabajo?
   - ¿QUÉ: Integración con WhatsApp API para hacer reservas
   - ¿POR QUÉ: Más usuarios llegan por WhatsApp que por web
   - ¿CUÁNTO: 3 semanas de trabajo, requiere servidor nuevo

3️⃣ Un comité lo revisa (normalmente: PM + Tech Lead + Cliente)
   - ¿Vale la pena 3 semanas?
   - ¿Se retrasa otra cosa?
   - ¿El cliente paga extra?

4️⃣ Decisión: ✅ Aprobado / ❌ Rechazado / ⏸️ Aplazado
   - Si es SÍ: se agrega al backlog con prioridad
   - Si es NO: se archiva (tal vez para la v2)
   - Si es DESPUÉS: se revisa en 3 meses

5️⃣ Si se aprueba, actualizar TODO:
   - Requisitos, código, pruebas, documentación, cronograma
   
6️⃣ Comunicar a todos
   - El cliente sabe que su cambio fue procesado
   - El equipo sabe que el cronograma cambió
```

**Lo que documenta una solicitud de cambio (RFC — Request for Change):**
- ¿Qué cambia exactamente?
- ¿Por qué es necesario?
- ¿Quién lo solicita?
- ¿Cuán urgente es?
- ¿Cuánto más trabajo trae?
- ¿Afecta al cronograma o al presupuesto?

#### Actividad práctica (45 min)

**Ejercicio 15.1 — Priorización con MoSCoW y Value/Effort (grupos de 3)**

Se entrega un backlog de 15 historias de usuario para el sistema de reservas.

1. Clasifiquen cada historia con MoSCoW.
2. Ubíquenlas en la matriz Value/Effort.
3. Definan el alcance de la versión 1.0 (MVP).
4. Justifiquen las exclusiones del MVP.

**Ejercicio 15.2 — Gestión de cambio (individual)**

Se recibe la siguiente RFC:  
*"El cliente solicita que las reservas también puedan hacerse por WhatsApp, no solo por la app web."*

1. Documenten la RFC con todos sus atributos.
2. Realicen el análisis de impacto (usando la RTM del ejercicio anterior).
3. Emitan una recomendación fundamentada para el CCB: aprobar, rechazar o diferir.
4. Definan los artefactos que deberían actualizarse si se aprueba.

#### Ejercicio de código — Clase 15: Calculadora de priorización MoSCoW con Value/Effort (25 minutos)

**Problema:** en el Ejercicio 15.1 priorizaste historias de usuario manualmente. Vamos a automatizar el cálculo con Python para poder iterar rápido y comparar distintos escenarios.

**Paso 1 — Crea el archivo `priorizacion.py`:**

```python
from dataclasses import dataclass, field
from enum import Enum

class MoSCoW(Enum):
    MUST   = "Must Have"
    SHOULD = "Should Have"
    COULD  = "Could Have"
    WONT   = "Won't Have"

@dataclass
class Historia:
    id: str
    nombre: str
    valor: int      # Impacto para el negocio: 1 (bajo) a 5 (muy alto)
    esfuerzo: int   # Costo de implementación: 1 (bajo) a 5 (muy alto)
    dependencias: list[str] = field(default_factory=list)

    @property
    def prioridad(self) -> float:
        """Relación valor/esfuerzo: más alto = mejor candidato para MVP."""
        return round(self.valor / self.esfuerzo, 2)

    def moscow(self) -> MoSCoW:
        p = self.prioridad
        if p >= 2.0:   return MoSCoW.MUST
        if p >= 1.0:   return MoSCoW.SHOULD
        if p >= 0.6:   return MoSCoW.COULD
        return MoSCoW.WONT

# ---------------------------------------------------------------------------
# Backlog de historias del sistema de reservas de salas
# ---------------------------------------------------------------------------
backlog: list[Historia] = [
    Historia("US-01", "Reservar sala desde la app",              valor=5, esfuerzo=2),
    Historia("US-02", "Cancelar reserva con anticipación",       valor=4, esfuerzo=1),
    Historia("US-03", "Ver historial de reservas",               valor=3, esfuerzo=2),
    Historia("US-04", "Notificación de recordatorio por email",  valor=4, esfuerzo=3),
    Historia("US-05", "Reservar sala por WhatsApp",              valor=3, esfuerzo=5),
    Historia("US-06", "Panel de administración de salas",        valor=5, esfuerzo=4),
    Historia("US-07", "Integración con calendario de Google",    valor=2, esfuerzo=5),
    Historia("US-08", "Login con cuenta institucional",          valor=5, esfuerzo=2),
]

# ---------------------------------------------------------------------------
# Reporte de priorización
# ---------------------------------------------------------------------------
def imprimir_reporte(historias: list[Historia]):
    ordenadas = sorted(historias, key=lambda h: h.prioridad, reverse=True)
    print(f"\n{'ID':<8} {'Historia':<44} {'V':>3} {'E':>3} {'V/E':>5}  {'MoSCoW'}")
    print("-" * 78)
    for h in ordenadas:
        print(f"{h.id:<8} {h.nombre:<44} {h.valor:>3} {h.esfuerzo:>3} {h.prioridad:>5}  {h.moscow().value}")

def mvp(historias: list[Historia]) -> list[Historia]:
    """Historias Must Have — candidatos al alcance v1.0."""
    return [h for h in historias if h.moscow() == MoSCoW.MUST]

imprimir_reporte(backlog)
print(f"\n=== MVP v1.0 ({len(mvp(backlog))} historias) ===")
for h in mvp(backlog):
    print(f"  ✅ {h.id} — {h.nombre}")
```

**Paso 2 — Ejecuta el script:**
```bash
python priorizacion.py
```

**Salida esperada:**
```
ID       Historia                                     V   E   V/E  MoSCoW
------------------------------------------------------------------------------
US-02    Cancelar reserva con anticipación            4   1  4.00  Must Have
US-01    Reservar sala desde la app                   5   2  2.50  Must Have
US-08    Login con cuenta institucional               5   2  2.50  Must Have
US-03    Ver historial de reservas                    3   2  1.50  Should Have
US-04    Notificación de recordatorio por email       4   3  1.33  Should Have
...

=== MVP v1.0 (3 historias) ===
  ✅ US-02 — Cancelar reserva con anticipación
  ✅ US-01 — Reservar sala desde la app
  ✅ US-08 — Login con cuenta institucional
```

**Paso 3 — Experimenta:**
1. Cambia el umbral de `MUST` (actualmente ≥ 2.0) a 1.5 y observa cómo cambia el MVP.
2. Agrega 3 historias más del backlog de tu propio proyecto.
3. Implementa la verificación de dependencias: si US-02 depende de US-08, US-08 también debe entrar en el MVP aunque su V/E sea bajo.

**Preguntas de cierre:**
- ¿La relación V/E captura todo lo que importa al priorizar? ¿Qué queda fuera del cálculo?
- Un stakeholder insiste en que US-07 (integración con Google Calendar) es crítica para él. ¿Cómo reconcilias el número con la política?
- ¿Qué pasaría si el equipo tiene restricción de capacidad (solo puede entrar 10 puntos de esfuerzo al MVP)? ¿Cómo ajustarías el script?

#### Recursos
- Leffingwell, D. — *Scaled Agile Framework (SAFe)*, Feature Prioritization
- Kano, N. — *Attractive Quality and Must-Be Quality* (artículo original)
- PMBOK Guide (7ª ed.) — Sección de gestión de cambios

---

## Unidad 4. Proyecto integrador: factoría de requisitos

---

### Clase 16 — Arranque del proyecto integrador

#### Objetivos
- Entender el alcance y la estructura del proyecto integrador.
- Validar el proceso TO-BE del dominio elegido.

#### Contenido teórico

**El proyecto integrador como "factoría de requisitos"**  
El proyecto integrador simula el trabajo real de un equipo de ingeniería de requisitos. El grupo actúa como consultores que deben producir todos los artefactos de IR para un sistema real o realista.

**Artefactos a entregar (visión general)**

| Artefacto | Clase | Descripción |
|---|---|---|
| Diagrama de contexto | 16 | Límites y actores externos |
| Glosario del dominio | 16 | Términos clave y reglas de negocio |
| Proceso TO-BE (BPMN) | 16–17 | Flujo futuro del negocio |
| Matriz de stakeholders | 16 | Influencia, interés, estrategia |
| SRS (secciones 1–3) | 17 | Especificación completa |
| Backlog con historias | 17 | Épicas e historias con criterios INVEST |
| Escenarios Gherkin | 17 | Feature files del flujo crítico |
| Requisitos de calidad | 17 | Escenarios con métricas y umbrales |
| Prototipo navegable | 18 | Wireframes del flujo crítico |
| RTM completa | 18 | Trazabilidad requisitos ↔ pruebas |
| RFC + análisis de impacto | 19 | Respuesta a cambio solicitado |

**Proceso de validación del TO-BE**  
Antes de especificar requisitos, el equipo debe validar que el proceso TO-BE diseñado es:
1. **Factible**: técnica y organizativamente posible.
2. **Valioso**: mejora cuantificable sobre el AS-IS.
3. **Acordado**: todos los stakeholders representados lo avalan.

Técnica: **Walkthrough del proceso** con al menos un representante de cada área del negocio afectada.

**Estructura de la sesión de arranque**
1. Presentación del dominio elegido (10 min por grupo)
2. Mapa de stakeholders preliminar (15 min)
3. Validación del proceso TO-BE (20 min)
4. Identificación de riesgos de IR del proyecto (10 min)
5. Plan de trabajo detallado para las clases 16–19 (10 min)

**Riesgos típicos en proyectos de IR**
- Stakeholder no disponible para validaciones.
- Dominio demasiado amplio para el tiempo disponible.
- Cambios de alcance durante el proyecto.
- Conflictos entre stakeholders no resueltos.
- Requisitos técnicos disfrazados de necesidades de negocio.

#### Actividad práctica (60 min)

**Taller de arranque (grupos de proyecto, 4–5 integrantes)**

1. **Presentación del dominio** (10 min): el grupo presenta el sistema elegido, los stakeholders identificados y el proceso AS-IS.

2. **Revisión del TO-BE** (20 min): el docente y el resto de la clase actúan como stakeholders. El grupo debe defender y ajustar su diagrama BPMN TO-BE en tiempo real.

3. **Priorización inicial** (15 min): identificar los 3 flujos de negocio más críticos que deben estar en el SRS y el prototipo.

4. **Plan de trabajo** (15 min): dividir los artefactos por integrante, definir dependencias y fechas internas de entrega.

#### Recursos
- Plantillas de todos los artefactos (repositorio de la cátedra)
- Rúbrica de evaluación del proyecto integrador
- Lista de dominios sugeridos (cátedra)

---

### Clase 17 — Especificación integrada: SRS, historias y calidad

#### Objetivos
- Integrar todos los artefactos de especificación en un documento cohesivo.
- Asegurar la consistencia entre el SRS, las historias y los requisitos de calidad.

#### Contenido teórico

**Coherencia entre artefactos**  
En la práctica, los equipos usan múltiples formatos en paralelo:
- SRS para contexto regulatorio o contractual.
- Historias de usuario en el backlog ágil.
- Escenarios Gherkin para automatización de pruebas.

La coherencia requiere que todos describan la **misma realidad** sin contradicciones.

*Mapeo entre artefactos:*

```
Objetivo de negocio (BRS)
        ↓
Épica (backlog)  ←→  Caso de uso de alto nivel (SRS sección 2)
        ↓
Historia de usuario ←→ Requisito funcional (SRS sección 3.2)
        ↓
Criterio de aceptación ←→ Escenario Gherkin (Feature file)
        ↓
Requisito de calidad (SRS 3.3) ←→ Escenario de calidad
```

**Checklist de consistencia del SRS**

- [ ] Cada épica del backlog tiene correspondencia en la sección 2 del SRS.
- [ ] Cada historia de usuario tiene al menos un requisito funcional en el SRS.
- [ ] Los términos del glosario se usan consistentemente en todos los documentos.
- [ ] Los actores del SRS coinciden con los stakeholders de la matriz.
- [ ] No hay requisitos en el SRS sin historia de usuario correspondiente (y viceversa).
- [ ] Cada requisito de calidad tiene una métrica y un método de verificación.
- [ ] La RTM tiene una fila por cada requisito funcional.

**Sesión de trabajo guiado**  
Esta clase es principalmente una sesión de trabajo de proyecto con revisión docente individual por grupo.

**Estructura de la sesión:**
- 15 min: revisión de avance con el docente (por grupo, en rotación).
- 45 min: trabajo autónomo del grupo en los artefactos.
- 20 min: revisión cruzada entre grupos (grupo A revisa SRS del grupo B).
- 10 min: síntesis y ajustes finales de la sesión.

**Errores comunes al integrar artefactos**

1. **El SRS y el backlog están desincronizados**: hay historias en el backlog que no están en el SRS o viceversa.
2. **Los criterios de aceptación contradicen el SRS**: la historia dice "en menos de 3 segundos" pero el SRS dice "en menos de 2 segundos."
3. **El glosario no se mantiene**: nuevos términos aparecen en los artefactos sin estar en el glosario.
4. **Requisitos de calidad sin verificación**: "el sistema debe ser seguro" sin escenario de calidad ni prueba definida.
5. **Trazabilidad rota**: la RTM no se actualiza cuando se agrega un requisito nuevo.

#### Actividad práctica (60 min)

**Sesión de integración del proyecto**

Cada grupo trabaja en la integración de sus artefactos. El docente circula entre los grupos.

**Checklist de la sesión:**
- [ ] SRS secciones 1 y 2 completas.
- [ ] Al menos 15 requisitos funcionales en sección 3.2 con todos los atributos.
- [ ] Al menos 5 escenarios de calidad estructurados.
- [ ] Backlog con al menos 10 historias en formato INVEST.
- [ ] Al menos 2 Feature files Gherkin completos.
- [ ] RTM con cobertura del 100% de los requisitos (aunque las pruebas estén pendientes).

**Revisión cruzada:**  
Cada grupo recibe el SRS de otro grupo y aplica la checklist de consistencia. Produce un informe de revisión con: 3 fortalezas y 3 áreas de mejora.

---

### Clase 18 — Prototipo navegable y matriz de trazabilidad completa

#### Objetivos
- Producir un prototipo navegable del flujo crítico del sistema.
- Completar la RTM con cobertura de pruebas.

#### Contenido teórico

**Prototipo navegable de alta fidelidad**  
Un prototipo navegable permite al stakeholder "usar" el sistema antes de que exista, validando flujo, vocabulario, y requisitos de usabilidad.

**Principios de diseño para el prototipo:**

1. **Visibilidad del estado del sistema**: el usuario siempre sabe qué está pasando (feedback visual).
2. **Coincidencia con el mundo real**: usar el lenguaje ubicuo del dominio, no términos técnicos.
3. **Control del usuario**: permitir deshacer acciones, salir sin consecuencias.
4. **Consistencia**: mismos patrones de interacción en toda la aplicación.
5. **Prevención de errores**: diseñar para que los errores sean difíciles de cometer.
6. **Reconocimiento sobre recuerdo**: la información necesaria visible, no en la memoria del usuario.
7. **Flexibilidad**: atajes para usuarios expertos sin perjudicar a novatos.

*(Heurísticas de usabilidad de Nielsen)*

**Flujo crítico**  
El flujo crítico es la secuencia de pantallas que representa el caso de uso de mayor valor o mayor riesgo del sistema. Es el que más frecuentemente validamos primero con stakeholders.

*Para identificar el flujo crítico:*
- ¿Qué historia de usuario tiene mayor prioridad (Must have)?
- ¿Qué flujo involucra más reglas de negocio complejas?
- ¿Qué flujo tiene mayor riesgo de malentendido con los stakeholders?

**Vinculación prototipo ↔ RTM**  
Cada pantalla del prototipo debe estar vinculada a los requisitos que satisface en la RTM. Esto permite:
- Verificar cobertura visual de los requisitos.
- Identificar requisitos sin representación en la UI.
- Facilitar las sesiones de validación con stakeholders.

**Cobertura de pruebas en la RTM**

Una RTM madura incluye:

```
| ID Req | Descripción | Pantalla Prototipo | Feature Gherkin | Caso de Prueba | Estado |
|--------|-------------|-------------------|-----------------|----------------|--------|
| REQ-001| Reservar    | P-03, P-04        | feat/reserva.f  | TC-001, TC-002 | Pend.  |
```

#### Actividad práctica (70 min)

**Taller de prototipado y RTM (trabajo de proyecto)**

**Parte 1 — Prototipo (45 min):**  
Cada grupo completa en Figma (o herramienta equivalente):
1. Al menos 5 pantallas del flujo crítico.
2. Flujo interactivo navegable (botones conectados a pantallas).
3. Micro-sesión de validación de 5 minutos con un compañero de otro grupo que actúa como usuario.
4. Documenten 3 ajustes de requisitos derivados de la validación.

**Parte 2 — RTM completa (25 min):**  
1. Completen la RTM con la columna de pantallas del prototipo.
2. Agreguen la columna de Feature files Gherkin.
3. Calculen las métricas: % de requisitos con prototipo, % con pruebas definidas.
4. Identifiquen y planifiquen los gaps restantes.

---

### Clase 19 — Análisis de impacto de cambio y actualización de artefactos

#### Objetivos
- Gestionar formalmente una solicitud de cambio sobre la baseline.
- Actualizar la RTM y los artefactos afectados.

#### Contenido teórico

**Gestión de cambios en la práctica**  
El cambio en los requisitos es inevitable. La clave no es evitarlo, sino gestionarlo con disciplina. Un cambio sin gestionar introduce:
- Inconsistencias en el SRS.
- Código sin requisito (o requisitos sin código).
- RTM desactualizada.
- Pruebas que ya no validan lo correcto.
- Stakeholders con expectativas diferentes.

**Análisis de impacto formal**

Para cada RFC aprobada, el analista debe producir:

```
RFC-[NNN] — Análisis de impacto

1. Descripción del cambio
2. Justificación (problema/oportunidad)
3. Requisitos afectados (con IDs)
4. Artefactos que deben actualizarse:
   - SRS: secciones X, Y, Z
   - Backlog: historias X, Y
   - Gherkin: features X, Y
   - RTM: filas X, Y
   - Prototipo: pantallas X, Y
5. Impacto en alcance: [ninguno / menor / mayor]
6. Impacto en cronograma: [X días/sprints adicionales]
7. Impacto en costo: [estimación]
8. Riesgos del cambio
9. Alternativas consideradas
10. Recomendación del analista
```

**Patrones de cambio en requisitos**

| Tipo de cambio | Frecuencia | Impacto típico |
|---|---|---|
| Refinamiento (más detalle) | Alta | Bajo |
| Ampliación de alcance | Media | Alto |
| Modificación de regla de negocio | Media | Medio |
| Eliminación de funcionalidad | Baja | Medio (afecta pruebas y RTM) |
| Cambio de restricción de calidad | Baja | Alto (puede requerir rediseño) |

**Comunicación del cambio**  
Una vez aprobado el cambio:
1. Notificar a todos los stakeholders afectados.
2. Publicar la nueva versión del SRS (control de versiones: 1.0 → 1.1).
3. Actualizar el backlog (si hay sprints en curso, coordinar con el equipo).
4. Registrar la RFC en el log de cambios del proyecto.
5. Verificar que la RTM se actualizó y está consistente.

#### Actividad práctica (60 min)

**Simulacro de RFC real del proyecto (trabajo de proyecto)**

El docente entrega a cada grupo una RFC específica para su sistema (diseñada para impactar entre 3 y 6 requisitos):

1. **Análisis de impacto** (25 min): completar el formulario de análisis de impacto completo.
2. **Actualización de artefactos** (25 min): actualizar el SRS, backlog, al menos un Feature file y la RTM.
3. **Presentación rápida** (10 min, 2 min por grupo): cada grupo explica el cambio recibido y las decisiones tomadas.

**Reflexión final de la clase:**
- ¿Qué hubiera pasado si este cambio llegaba sin proceso de gestión?
- ¿Qué artefactos hubieran quedado inconsistentes?
- ¿Cómo evitar este tipo de cambios con una mejor elicitación inicial?

---

### Clase 20 — Defensa técnica individual y autorreferencia final

#### Objetivos
- Demostrar dominio individual de los artefactos del proyecto integrador.
- Reflexionar críticamente sobre el proceso de IR realizado.

#### Contenido teórico

**La defensa técnica individual**  
Cada integrante del grupo debe demostrar comprensión profunda de **todos** los artefactos del proyecto, no solo de los que redactó personalmente. El evaluador puede:
- Pedir que explique cualquier requisito del SRS.
- Solicitar que justifique una decisión de priorización.
- Presentar una nueva RFC y pedir análisis de impacto en vivo.
- Cuestionar la consistencia entre el SRS y una historia de usuario.
- Pedir que modifique en tiempo real un escenario Gherkin.

**Modificación en vivo**  
Parte central de la defensa. El evaluador presenta un cambio o un error detectado. El estudiante debe:
1. Identificar el problema o el cambio.
2. Proponer la solución o modificación.
3. Implementarla en el artefacto correspondiente (en tiempo real).
4. Explicar el impacto en otros artefactos.

**Autorreferencia y metacognición**  
La última parte de la defensa incluye una reflexión personal:
- ¿Qué técnicas de elicitación usaste? ¿Cuál fue la más valiosa y por qué?
- ¿Qué requisito costó más especificar? ¿Qué aprendiste del proceso?
- ¿Qué harías diferente si empezaras el proyecto desde cero?
- ¿Cómo usaste la IA en el proyecto? ¿Cuáles fueron sus limitaciones?
- ¿Qué habilidades de IR te llevas para tu práctica profesional?

**Rúbrica de evaluación**

| Criterio | Peso | Indicadores |
|---|---|---|
| Comprensión del dominio | 15% | Explica correctamente el dominio y los stakeholders |
| Calidad del SRS | 20% | Requisitos con todos los atributos, sin ambigüedades |
| Historias y Gherkin | 15% | Cumplen INVEST, escenarios correctos |
| Trazabilidad | 15% | RTM completa y consistente |
| Análisis de impacto (en vivo) | 20% | Correcta identificación de artefactos afectados |
| Autorreferencia | 15% | Reflexión crítica y fundamentada |

#### Actividad — Defensa individual (120 min)

**Estructura de cada defensa (tiempo por estudiante: según tamaño del grupo):**

1. **Presentación del proyecto** (3–4 min, todo el grupo): contexto, dominio, decisiones arquitecturales de la especificación.

2. **Preguntas individuales** (8–10 min por estudiante):
   - 2 preguntas sobre el SRS y requisitos del estudiante.
   - 1 pregunta sobre un artefacto que NO redactó personalmente.
   - 1 RFC nueva presentada en vivo (análisis y modificación en 3 min).
   - Autorreferencia (2 min).

3. **Cierre del docente** (5 min): feedback grupal y reflexión sobre el curso.

**Preguntas frecuentes de defensa (preparación recomendada):**
- "¿Por qué este requisito es Must y no Should?"
- "¿Qué pasaría si este requisito se elimina?"
- "¿Este escenario Gherkin es suficiente para verificar el requisito?"
- "¿Cómo se distingue este requisito funcional de uno de calidad?"
- "¿Qué stakeholder validó este requisito? ¿Cómo?"
- "¿Este requisito es verificable? ¿Con qué prueba?"

#### Reflexión final del curso

**Lo que una buena IR garantiza:**
> "Los requisitos son el contrato entre el negocio y la tecnología. Un buen requisito no es solo una frase bien redactada: es el resultado de escuchar con profundidad, pensar con rigor y comunicar con claridad."

**Principios para llevar a la práctica:**
1. El requisito más costoso es el que no se captura.
2. La ambigüedad no es inocente; siempre tiene un costo.
3. Los stakeholders saben **qué** quieren, no siempre **cómo** expresarlo. Tu trabajo es el puente.
4. Un requisito sin criterio de aceptación no es un requisito: es un deseo.
5. La trazabilidad no es burocracia; es memoria del equipo.
6. La IA puede acelerar el trabajo, pero nunca reemplaza la conversación con el humano que tiene el problema.

---

## Apéndice — Plantillas y recursos de referencia

### Plantilla de requisito funcional

```
ID:                  REQ-[MÓDULO]-[NNN]
Título:              
Descripción:         El sistema deberá [acción] [objeto] [condición/restricción].
Fuente:              [Stakeholder / Documento]
Prioridad:           Must / Should / Could / Won't
Estabilidad:         Estable / Volátil / Por confirmar
Estado:              Propuesto / Aprobado / Implementado / Verificado
Criterio de aceptación:
Dependencias:        
Versión:             1.0
Fecha de aprobación: 
```

### Plantilla de escenario de calidad

```
Característica ISO 25010: 
Subcaracterística:        
Fuente del estímulo:      
Estímulo:                 
Entorno:                  
Artefacto:                
Respuesta del sistema:    
Medida de respuesta:      
Criterio de aceptación:   
Método de verificación:   
```

### Plantilla de RFC (Request for Change)

```
ID RFC:              RFC-[NNN]
Fecha:               
Solicitante:         
Descripción:         
Justificación:       
Requisitos afectados: [IDs]
Artefactos a actualizar:
Impacto en alcance:  
Impacto en tiempo:   
Impacto en costo:    
Riesgos:             
Alternativas:        
Recomendación:       
Decisión CCB:        Aprobado / Rechazado / Diferido
```

### Glosario de términos del curso

| Término | Definición |
|---|---|
| **Backlog** | Lista priorizada de trabajo pendiente del producto |
| **Baseline** | Conjunto de artefactos aprobados formalmente como referencia |
| **BDD** | Behavior-Driven Development; práctica que usa ejemplos para especificar comportamiento |
| **BRS** | Business Requirements Specification; necesidades del negocio |
| **CCB** | Change Control Board; comité que aprueba o rechaza cambios |
| **DoD** | Definition of Done; criterios que definen cuándo una historia está terminada |
| **DoR** | Definition of Ready; criterios mínimos para que una historia entre a un sprint |
| **Épica** | Historia de usuario demasiado grande para un sprint; agrupa historias |
| **Gherkin** | Lenguaje DSL para escribir escenarios BDD legibles por humanos |
| **INVEST** | Criterios de calidad de una historia de usuario (Independent, Negotiable, Valuable, Estimable, Small, Testable) |
| **MoSCoW** | Técnica de priorización (Must, Should, Could, Won't) |
| **RFC** | Request for Change; solicitud formal de modificación a la baseline |
| **RTM** | Requirements Traceability Matrix; tabla que vincula requisitos con otros artefactos |
| **SRS** | Software Requirements Specification; especificación de requisitos del software |
| **StRS** | Stakeholder Requirements Specification; necesidades de los stakeholders |
| **SyRS** | System Requirements Specification; requisitos del sistema completo |
| **Trazabilidad** | Capacidad de rastrear relaciones entre artefactos del ciclo de vida |
| **Validación** | Confirmar que el producto correcto fue construido (según necesidades reales) |
| **Verificación** | Confirmar que el producto fue construido correctamente (según la especificación) |

### Bibliografía del curso

**Libros principales:**
- Wiegers, K. & Beatty, J. (2013). *Software Requirements* (3rd ed.). Microsoft Press.
- Robertson, S. & Robertson, J. (2012). *Mastering the Requirements Process* (3rd ed.). Addison-Wesley.
- Cohn, M. (2004). *User Stories Applied: For Agile Software Development*. Addison-Wesley.
- Adzic, G. (2011). *Specification by Example*. Manning Publications.

**Estándares:**
- ISO/IEC/IEEE 29148:2018 — Requirements Engineering
- ISO/IEC 25010:2023 — SQuaRE Quality Model
- ISO/IEC/IEEE 12207:2017 — Software Life Cycle Processes
- W3C WCAG 2.2 — Web Content Accessibility Guidelines

**Artículos y recursos online:**
- North, D. — *Introducing BDD*: dannorth.net
- Wake, B. — *INVEST in Good Stories*: xp123.com
- IREB CPRE Syllabus: ireb.org
- Cucumber / Gherkin docs: cucumber.io
- bpmn.io — Editor BPMN gratuito
