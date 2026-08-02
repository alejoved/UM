# Ingeniería del Software — Curso Completo (2 horas × 20 clases)

> Material de referencia — Universidad de Manizales  
> Última actualización: agosto 2026 | Versión: 3.0 (Completo)  
> **Duración total: 40 horas** | Público: Ingenieros de software, líderes técnicos

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

### Contenido teórico (40 minutos)

#### 1. Procesos del ciclo de vida — ISO/IEC/IEEE 12207:2017

ISO/IEC/IEEE 12207:2017 es el estándar internacional que define procesos del ciclo de vida del software. Agrupa los procesos en **tres categorías principales**:

| Grupo | Objetivo | Procesos | Responsables |
|---|---|---|---|
| **Acuerdo** | Relación comprador-proveedor | Adquisición, Suministro | PM, Legal, Procura |
| **Proyecto** | Planificación y control | Planificación, Control, Riesgos, Configuración | PM, ScrumMaster |
| **Técnicos** | Especificación y realización | Requisitos, Diseño, Implementación, Pruebas, Operación | Arquitecto, Dev, QA, SRE |

**¿Por qué importa?** Clarifica que ingeniería del software no es solo codificar; incluye acuerdos, gestión y aseguramiento técnico.

#### 2. Modelos de proceso

**Cascada (Waterfall)**

Flujo: `Requisitos → Diseño → Implementación → Pruebas → Despliegue`

- Fases secuenciales. Cambios tardíos = costo alto.
- Documentación exhaustiva.
- Pruebas al final.

*Cuándo:* Requisitos estables, sistemas regulados, contexto crítico.  
*Ejemplo:* Control de semáforos, software aeroespacial.

**Ventajas:** Predecibilidad, documentación.  
**Desventajas:** Feedback tardío, inflexibilidad, alto riesgo.

---

**Incremental / Iterativo**

Flujo: `Sprint 1 → Feedback → Sprint 2 → Feedback → ...`

- Entregas pequeñas cada 1-4 semanas.
- Feedback temprano.
- Adaptación a cambios.

*Cuándo:* Requisitos parciales, ROI temprano necesario.  
*Ejemplo:* Plataforma e-commerce (catálogo → carrito → pagos).

**Ventajas:** Riesgo bajo, satisfacción usuario, adaptable.  
**Desventajas:** Arquitectura puede degradarse, estimación difícil.

---

**Espiral (Boehm, 1986)**

Combina cascata + iterativo. Énfasis en gestión de riesgos.

*Cuándo:* Proyectos complejos, riesgos técnicos altos.  
*Ejemplo:* Migración de sistemas aeroportuarios.

**Ventajas:** Control de riesgos, prototipado temprano.  
**Desventajas:** Costoso, requiere experiencia.

---

**Ágil (Agile Manifesto, 2001)**

Valores: Individuos > procesos, software > documentación, cambio > plan.

- Sprints 1-4 semanas.
- Standup diario.
- Tests automatizadas.

*Cuándo:* Requisitos evolucionan, feedback rápido, equipo ágil.  
*Ejemplo:* App fintech startup.

**Ventajas:** Entrega rápida, adaptabilidad, satisfacción equipo.  
**Desventajas:** Difícil escalar, requiere disponibilidad PO.

---

**DevOps sociotécnico**

Integra Dev + Ops + Seguridad. Responsabilidad compartida.

Flujo: `Código → CI → CD → Prod → Monitoreo → Feedback`

Principios:
- **Flujo:** Lead time corto.
- **Retroalimentación:** Métricas en tiempo real.
- **Aprendizaje:** Postmortems sin culpa.
- **Responsabilidad:** Compartida.

*Impacto:* Deployment 1/trimestre → múltiples/día. Lead time semanas → horas.

*Ejemplo:* Amazon (1 cambio cada 2 segundos), Netflix (99.99% uptime).

#### 3. Comparativa

| Aspecto | Cascata | Incremental | Espiral | Ágil | DevOps |
|---|---|---|---|---|---|
| Tiempo valor | Muy largo | Medio | Medio | Corto | Muy corto |
| Flexibilidad | Baja | Media | Media | Alta | Muy alta |
| Costo cambio | Alto | Medio | Medio | Bajo | Bajo |
| Riesgo técnico | Alto | Medio | Bajo | Bajo | Bajo |

---

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (30 minutos)

**Actividad 1: Matriz de decisión (15 min)**

5 proyectos: (1) Nómina, (2) Red social, (3) Control misiles, (4) SaaS CRM, (5) Auto eléctrico.

Elige modelo + 3 criterios + justificación.

**Actividad 2: Flujo de proyecto (15 min)**

Dibuja flujo completo (requisito → mantenimiento) para modelo elegido. Identifica roles, documentos, puntos de riesgo.

---

### Preguntas de reflexión

1. ¿Cascata es obsoleto? ¿Hay contextos donde sigue siendo apropiado?
2. ¿DevOps requiere Ágil? ¿Puedes hacer DevOps en cascata?
3. ¿Cómo escalarías Ágil a 20 equipos simultáneamente?

---

### Recursos

- ISO/IEC/IEEE 12207:2017
- "The Phoenix Project" — Kim et al.
- "Accelerate" — Forsgren et al.
- Agile Manifesto: agilemanifesto.org

---

## Clase 02: DevOps sociotécnico y transformación cultural

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 1

### Objetivos de aprendizaje

- Explicar pilares sociotécnicos de DevOps (personas, procesos, técnica).
- Identificar barreras culturales comunes en organizaciones.
- Diseñar estrategia de transformación (top-down, bottom-up, hybrid).
- Comparar métricas pre/post transformación.

---

### Contenido teórico (45 minutos)

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

#### 2. El pilar "Personas"

**Silos tradicionales:**

Dev: "Necesito desplegar cada 2 horas".  
Ops: "Okay, 1 cambio por mes".  
Resultado: Conflicto, culpa.

**DevOps:**
- SLO compartido: 99.9% uptime.
- Si se viola: ambos responsables.
- Confianza mediante automatización.

**Autonomía:** Squad (6-10 personas) dueño end-to-end (requisitos → soporte).

**Blameless postmortem:**
- ¿Qué condiciones lo permitieron? (No: ¿Quién?).
- Resultado: Reportan problemas temprano.

#### 3. El pilar "Proceso"

**Flujo de valor:** Requisito → Código → Commit → CI → CD → Producción.

Cascata: 6 meses.  
DevOps: < 1 hora.

**Feedback loops:**
- Nivel 1 (segundos): IDE muestra errores.
- Nivel 2 (minutos): CI ejecuta tests.
- Nivel 3 (horas): Monitoreo muestra métricas.
- Nivel 4 (días): Usuarios usan feature.

#### 4. El pilar "Técnica"

- **CI:** Build automático, tests, análisis.
- **CD:** Deploy automático, estrategias seguras (canary, blue-green).
- **Observabilidad:** Logs, métricas, trazas.
- **IaC:** Infraestructura como código.

#### 5. Patrones de transformación

**Top-Down:** Liderazgo impone. Riesgo: Herramientas sin cambio cultural.

**Bottom-Up:** Equipos experimentan. Ventaja: Cambio genuino. Desventaja: Lento.

**Hybrid:** Liderazgo crea incentivos + Equipos adoptan. Balance óptimo.

---

### Ejemplos prácticos (40 minutos)

**Google (Bottom-Up):**
- Startup: Ingenieros construyen todo.
- Escala: SRE role (50% ops, 50% ingeniería).
- Error Budget: SLO 99.9% → presupuesto 0.1% downtime.
- Resultado: 2M cambios/día.

**IBM (Top-Down):**
- 2015: Transformación decidida desde C-level.
- Herramientas, capacitación, innovation centers.
- Resultado: Lead time 6 meses → 2 semanas. CFR < 5%.

**Empresa energética (Hybrid):**
- 2015: Lab innovación (8 personas). +$2M/año.
- 2017: 3 equipos. Herramientas.
- 2019: 20 equipos. Deployment 1/año → 5/semana. MTTR 4h → 15min.

---

### Actividades prácticas (25 minutos)

**Actividad 1: Diagnóstico cultural (10 min)**

Checklist 8 preguntas. Scoring: 7-8 = DevOps. 4-6 = Transición. 0-3 = Tradicional.

Preguntas:
1. ¿Deplegan más de 1 vez/semana?
2. ¿Postmortems sin culpa?
3. ¿Menos de 1 hora de lead time?
4. ¿Menos de 15% cambios fallan?
5. ¿Equipos multidisciplinarios?
6. ¿CI/CD automático?
7. ¿Monitoreo en tiempo real?
8. ¿Autonomía de equipos?

**Actividad 2: Plan de transformación (15 min)**

Empresa Financiera: 200 personas, ciclo 6 meses. Competidor fintech 10x rápido.

Plan 24 meses: Awareness (3m) → Pilots (6m) → Scale (15m).

Presupuesto $2M. Presenta: ¿Por qué este plan?

---

### Preguntas de reflexión

1. ¿Puedes tener DevOps sin cambio cultural?
2. ¿Error budgets generan confianza o irresponsabilidad?
3. ¿Cómo medir éxito de transformación?

---

## Clase 03: Planificación orientada a valor

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 2

### Objetivos de aprendizaje

- Aplicar matriz Value/Effort para priorizar backlog.
- Construir roadmap orientado a valor (6-12 meses).
- Escribir Definition of Ready (DoR) para un equipo.
- Implementar Definition of Done (DoD) en sprints.

---

### Contenido teórico (45 minutos)

#### 1. Product Backlog y Product Owner

**Product Backlog:** Lista priorizada de requisitos (features, bugs, tech debt).

**Responsable:** Product Owner (PO) representa usuario/negocio.

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

#### 2. Matriz Value/Effort

```
High Value              │  Quick Wins  │  Strategic
High Effort             │  Fill-Ins    │  Initiatives
────────────────────────┼──────────────┼────────────
Low Value   Low Effort  │ Speculative  │
```

**Quick Wins:** Alto valor, bajo esfuerzo. Prioridad máxima.  
**Strategic:** Alto valor, alto esfuerzo. Para después.  
**Fill-Ins:** Bajo valor, bajo esfuerzo. Entre sprints.  
**Speculative:** Bajo valor, alto esfuerzo. Evitar.

#### 3. Roadmap

Plan 6-12 meses con entregas incrementales.

**Q1:** Features de autenticación + pagos básico.  
**Q2:** Suscripciones + reportes.  
**Q3:** Integraciones con terceros.  
**Q4:** Performance + escalabilidad.

#### 4. Definition of Ready (DoR)

Criterios antes de que Story entre a sprint:

- [ ] Criterios de aceptación claros
- [ ] Estimación consensuada
- [ ] Dependencias identificadas
- [ ] Tamaño < 8 Story Points
- [ ] Mockups (si UI)
- [ ] No bloqueadores

#### 5. Definition of Done (DoD)

Criterios antes de marcar Story como "Hecho":

- [ ] Código review (2 aprobaciones)
- [ ] Tests unitarios (>= 80% coverage)
- [ ] Tests integración
- [ ] Tests manuales en staging
- [ ] Documentación actualizada
- [ ] CI verde
- [ ] Product Owner aceptó

---

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Construir roadmap (12 min)**

Empresa SaaS CRM. Usuario solicita 5 features. Timeframe 6 meses. Presupuesto: 4 sprints/mes.

Tareas:
1. Estimar effort de cada feature.
2. Crear roadmap (Q1 H1, Q2 H1, Q2 H2).
3. Justificar orden.

**Actividad 2: Escribir DoR/DoD (13 min)**

Story elegida por grupo. Escribir:
- 5 criterios DoR específicos.
- 5 criterios DoD específicos.

---

## Clase 04: Estimación — Story Points, Planning Poker, Three-Point

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 2

### Objetivos de aprendizaje

- Aplicar Planning Poker para consensar estimaciones.
- Estimar histórico del equipo y velocidad.
- Usar Three-Point PERT para historias complejas.
- Traducir Story Points a tiempo calendario.

---

### Contenido teórico (45 minutos)

#### 1. Story Points vs Horas

**Horas:** "Esto toma 8 horas".
- Optimista. No incluye contexto, interrupciones, tests.

**Story Points:** "Esto es 5 puntos".
- Relativo. Compara con historias previas.
- Incluye incertidumbre.

**Equivalencia (equipo específico):**
Equipo A: 1 SP = 4 horas promedio.  
Equipo B: 1 SP = 6 horas promedio.  
*Varía por equipo, lenguaje, experiencia.*

#### 2. Escala de Fibonacci

1, 2, 3, 5, 8, 13, 21, 34, ...

**Razón:** Diferencia entre 8 y 13 es significativa (65% más); diferencia entre 1 y 2 también (100%). Escala logarítmica.

#### 3. Planning Poker

**Proceso:**

1. PO lee story.
2. Q&A (equipo pregunta, PO clarifica).
3. Cada dev/QA estima (1-21 SP) en privado.
4. Revelan simultáneamente.
5. Si consensus (todos dentro 1 número): Done. Si divergencia, debate.
6. Re-estiman si es necesario.

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

#### 4. Three-Point PERT

Para historias complejas/arriesgadas:

**Optimista (O):** Si todo va bien. Ej: 5 SP.  
**Realista (M):** Caso promedio. Ej: 13 SP.  
**Pesimista (P):** Todo sale mal. Ej: 21 SP.

**Fórmula:** (O + 4M + P) / 6 = (5 + 4×13 + 21) / 6 = (5 + 52 + 21) / 6 = 78/6 = **13 SP**.

Reduce sesgo optimista.

#### 5. Velocidad del equipo

**Velocidad:** Promedio SP entregados por sprint.

Sprint 1: 20 SP.  
Sprint 2: 25 SP.  
Sprint 3: 18 SP.  
Sprint 4: 22 SP.  
**Velocidad promedio:** (20+25+18+22)/4 = 21.25 SP/sprint.

**Usar para planificar:** Si roadmap tiene 100 SP, y velocidad es 21 SP/sprint, timeline ≈ 5 sprints (2.5 meses si sprints 2 semanas).

---

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Planning Poker simulado (12 min)**

3 stories. Equipo estima, debate, consensus.

**Actividad 2: Calcular velocidad (13 min)**

Datos históricos de 8 sprints. Calcular velocidad, proyectar timeline para roadmap dado.

---

## Clase 05: Gestión de riesgos y calidad (ISO/IEC 25010)

**Duración:** 2 horas | **Unidad:** 1 | **Semana:** 3

### Objetivos de aprendizaje

- Identificar y clasificar riesgos (probabilidad × impacto).
- Aplicar ISO/IEC 25010 para evaluar calidad del software.
- Implementar quality gates en pipeline de CI/CD.
- Calcular deuda técnica acumulada.

---

### Contenido teórico (45 minutos)

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

#### 3. Quality Gates

Criterios que deben cumplirse para merge/deploy:

```yaml
Quality Gates:
  - Test coverage >= 80%
  - No bugs críticos (SonarQube)
  - No vulnerabilidades CVSS > 7
  - Performance P95 < 200ms
  - Code style pasa linting
  - Deuda técnica < 5 días
```

Si Quality Gate falla → Bloquea merge. Dev debe arreglar.

#### 4. Deuda técnica

**Concepto:** Código que "funciona" pero compromete calidad futura.

**Ejemplos:**
- Tests manuales en lugar de automatizadas.
- Duplicación de código.
- Funciones muy largas (200+ líneas).
- Dependencias desactualizadas.

**Costo:** Cada día que no la corriges, costo de cambios futuros sube.

**Medición (SonarQube):**
- "Deuda: 15 días" = equivalente a 15 días-persona de refactorización.

**Política:** Dedicar 20% tiempo por sprint a reducir deuda.

---

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Matriz de riesgos (12 min)**

Equipo elige proyecto real/hipotético. Identifica 5-10 riesgos, completa matriz (Prob×Impacto), propone mitigación.

**Actividad 2: Quality gates para proyecto (13 min)**

Diseña 6-8 quality gates específicos para proyecto elegido. Define métricas, thresholds, cómo medirlas.

---

# UNIDAD 2. Configuración, CI/CD y DevSecOps

---

## Clase 06: Gestión de configuración, branching y SemVer

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 3

### Objetivos de aprendizaje

- Implementar estrategia de branching (trunk-based, GitHub Flow, Git Flow).
- Aplicar versionamiento semántico (SemVer).
- Construir changelogs que comunican cambios.
- Resolver conflictos de merge sin perder historia.

---

### Contenido teórico (45 minutos)

#### 1. Gestión de Configuración (SCM) — ISO/IEC/IEEE 828

**Objetivo:** Trazabilidad completa: ¿Quién? ¿Qué? ¿Cuándo? ¿Por qué?

**4 Actividades clave:**

**1.1 Identificación:** Qué versionamos (código, tests, BD migrations, IaC, docs).

**1.2 Control de cambios:**

En cascata: Change Request formal, CCB (20+ personas), 2-4 semanas.  
En Ágil: PR, 2-3 reviewers, 24 horas.

**1.3 Registro de estado:** `git log --oneline`. Historial auditable.

**1.4 Auditoría:** ¿Qué versión está en producción? Verificar: `git show v1.2.3:VERSION`.

#### 2. Estrategias de branching

**Trunk-Based Development (TBD):**

Todos a `main`. Feature branches < 1 día. CI rápido detecta conflictos.

Cuándo: Equipos maduros, testing fuerte, deploy frecuente (> 1/día).

Ejemplo: Stripe (1000+ commits/día).

---

**GitHub Flow:**

Rama feature corta (1-2 días). PR → Review → Merge → Deploy.

Cuándo: SaaS, deploy frecuente, equipos pequeños.

Ejemplo: GitHub mismo.

---

**Git Flow:**

`main` (producción) + `develop` (integración) + `feature/*` + `release/*` + `hotfix/*`.

Cuándo: Múltiples versiones simultáneas, ciclos de release largos.

Ejemplo: WordPress (v1.0 y v2.0 en producción).

#### 3. Versionamiento Semántico (SemVer)

Formato: `MAJOR.MINOR.PATCH[-prerelease][+build]`

- **MAJOR:** Breaking changes.
- **MINOR:** Nuevas features, backward compatible.
- **PATCH:** Bug fixes.

Ejemplo: `1.2.3-beta.1+build.42`.

#### 4. Changelog

Documento (CHANGELOG.md) que lista cambios por versión en lenguaje humano.

Formato: Keep a Changelog.

```markdown
## [1.2.0] - 2026-08-15

### Added
- Support multiple currencies in payment API

### Fixed
- Division by zero error in tax calculation

### Removed
- Legacy XML endpoint
```

---

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Modelar branching strategy (12 min)**

App web SaaS. 20 personas. Deploy 2-3/semana. Elige estrategia. Dibuja flujo. Describe proceso "feature a producción".

**Actividad 2: Escribir changelog (13 min)**

v1.3.0 → v1.4.0. Cambios: nuevo endpoint, bug fix, deprecation. Escribe entrada changelog (formato Keep a Changelog).

---

## Clase 07: Integración continua y pipeline como código

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 4

### Objetivos de aprendizaje

- Diseñar pipeline de CI (stages: build, test, security, artifact).
- Implementar "Pipeline as Code" (GitHub Actions, GitLab CI, Jenkins).
- Configurar quality gates automáticos.
- Optimizar tiempo de pipeline.

---

### Contenido teórico (45 minutos)

#### 1. Qué es CI

**Definición:** Integrar cambios de múltiples devs a repositorio compartido varias veces/día. Cada integración verificada automáticamente.

**3 Pilares:**
- Automatización (no manual).
- Verificación (tests, análisis, seguridad).
- Rapidez (feedback en minutos).

#### 2. Pipeline típico

```
git push
  ↓
GitHub webhook → CI Server
  ↓
Stage 1: Build (2 min) - npm install, webpack
  ↓
Stage 2: Test (5 min) - unit tests, integration
  ↓
Stage 3: Quality (3 min) - SonarQube, lint
  ↓
Stage 4: Security (3 min) - SAST, SCA
  ↓
Stage 5: Artifact (2 min) - Docker build, push
  ↓
PASS ✓ (código listo para merge/deploy)
```

Total: ~15 minutos.

#### 3. Pipeline as Code

**Antes (Bad):** Pipeline en UI de Jenkins. No versionado. Desorganizado.

**Ahora (Good):** Pipeline en `.yml` en repo.

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Diseñar pipeline (12 min)**

Proyecto Node.js + DB. Lenguaje: JavaScript. Requisitos: tests, lint, security scan, coverage >= 80%.

Diseña: 5-6 stages, duración estimada, quality gates.

**Actividad 2: Escribir pipeline as code (13 min)**

GitHub Actions workflow para proyecto anterior. Archivo `.github/workflows/ci.yml`.

---

## Clase 08: Entrega continua y estrategias de despliegue

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 4

### Objetivos de aprendizaje

- Distinguir entre CD (Continuous Delivery) y CDeployment.
- Implementar estrategias: rolling, blue-green, canary.
- Diseñar rollback plan.
- Monitorear despliegues post-release.

---

### Contenido teórico (45 minutos)

#### 1. CD vs CDeployment

**Continuous Delivery (CD):** Código listo para producción en cada commit. Deploy es decisión manual.

**Continuous Deployment:** Código automáticamente a producción si tests pasan.

Spectrum: Manual → CD → CDeployment.

#### 2. Estrategias de despliegue

**Rolling Deploy:**

Reemplazar instancias gradualmente. Ej: 5 servidores, 1 por 1.

- V1 (5 instancias) → Reemplazar 1 con V2 (1 V2, 4 V1).
- Monitor (2 min).
- Reemplazar siguiente. (2 V2, 3 V1).
- ...
- Total: 10 minutos, downtime ~0.

Ventaja: Económico (no requiere 2x infraestructura).  
Desventaja: Rollback más lento.

---

**Blue-Green Deploy:**

2 ambientes idénticos. Uno activo (Blue), otro en standby (Green).

- Deploy V2 a Green.
- Tests.
- Switch router: Blue → Green.
- V1 queda en Blue para rollback rápido.

Ventaja: Rollback instantáneo.  
Desventaja: 2x infraestructura.

---

**Canary Deploy:**

Desviar pequeño % tráfico a V2. Monitor. Si OK, aumentar gradualmente.

- 5% tráfico → V2. Monitorear 30 min.
- Si error rate OK: 25% → V2.
- Si error rate OK: 100% → V2.
- Si error rate SUBE: Rollback al 0% V2.

Ventaja: Riesgo mínimo. Catch bugs con pocos usuarios.  
Desventaja: Complejo de implementar.

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Elegir estrategia (12 min)**

3 contextos. Para cada uno, elige estrategia de deploy. Justifica.

**Actividad 2: Escribir rollback plan (13 min)**

Proyecto elegido. Detalla: detección (¿cómo sabemos que falló?), decisión (¿quién decide?), ejecución (¿cómo rollback?), validación (¿cómo sabemos que OK?).

---

## Clase 09: DevSecOps y OWASP Top 10

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 5

### Objetivos de aprendizaje

- Integrar seguridad en el ciclo de vida (shift-left).
- Identificar y mitigar OWASP Top 10 vulnerabilidades.
- Implementar SAST/DAST en pipeline.
- Crear cultura de seguridad en equipo.

---

### Contenido teórico (45 minutos)

#### 1. DevSecOps: Seguridad desde el inicio

**Ciclo tradicional:**

Desarrollo → Ops → Seguridad (post-facto) → Remediación costosa.

**DevSecOps:**

Seguridad integrada desde Requisitos.

```
Requisitos de seguridad
  ↓
Secure code practices (durante dev)
  ↓
SAST en CI (detección de código vulnerable)
  ↓
DAST en staging (pruebas dinámicas)
  ↓
SCA: dependencias vulnerables
  ↓
Deploy solo si security gates pasan
  ↓
WAF + IDS en producción
  ↓
Monitoreo continuo + response a incidentes
```

Filosofía: "Security is everyone's responsibility".

#### 2. OWASP Top 10 (2021)

1. **Broken Access Control:** Usuarios acceden datos que no deberían.
   - Mitigación: Verificar permisos en cada operación.

2. **Cryptographic Failures:** Datos sensibles no encriptados.
   - Mitigación: Usar HTTPS (TLS), encriptar datos en BD.

3. **Injection:** SQL injection, command injection.
   - Mitigación: Prepared statements, input validation.

4. **Insecure Design:** Arquitectura sin threat modeling.
   - Mitigación: Threat modeling en diseño, security requirements.

5. **Security Misconfiguration:** Defaults inseguros, headers faltantes.
   - Mitigación: Hardening checklist, automated scanning.

6. **Vulnerable & Outdated Components:** Dependencias con CVEs.
   - Mitigación: SCA, update frecuentes.

7. **Authentication Failures:** Password débil, 2FA faltante.
   - Mitigación: bcrypt, 2FA obligatorio, session timeout.

8. **Data Integrity Failures:** Deserialization insegura.
   - Mitigación: No desserialize untrusted data, usar JSON.

9. **Logging & Monitoring Failures:** No hay audit trail.
   - Mitigación: Logs de acceso, alertas de anomalías.

10. **SSRF:** Server-Side Request Forgery.
    - Mitigación: Validar URLs, whitelist dominios.

#### 3. SAST vs DAST

**SAST (Static Application Security Testing):**
- Analiza código sin ejecutarlo.
- Herramientas: SonarQube, Checkmarx, Fortify.
- Rápido (~1-2 min). Falsos positivos altos.
- Runs: En CI después de commit.

**DAST (Dynamic Application Security Testing):**
- Ejecuta app, intenta ataques.
- Herramientas: OWASP ZAP, Burp Suite, Nessus.
- Lento (~30+ min). Fewer false positives.
- Runs: En staging pre-deploy.

#### 4. SCA (Software Composition Analysis)

Escanea dependencias (npm packages, Python libs, etc.) contra CVE database.

- Herramientas: Snyk, Dependabot, WhiteSource.
- Integración: CI/CD.
- Bloquea deploy si vulnerabilidad alta encontrada.

---

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Threat modeling (12 min)**

App de banca. Diagrama: Usuario → App → BD.

Identifica 5 amenazas. Para cada una: OWASP Top 10 número, mitigación.

**Actividad 2: Implementar security gates (13 min)**

Diseña quality gates de seguridad para pipeline CI:
- SAST (SonarQube, qué bloquea?).
- SCA (Snyk, umbral de severidad?).
- Tests de seguridad (qué casos?).

---

## Clase 10: SAST/DAST/SCA, SBOM y gestión de secretos

**Duración:** 2 horas | **Unidad:** 2 | **Semana:** 5

### Objetivos de aprendizaje

- Implementar herramientas SAST, DAST, SCA en pipeline.
- Generar y validar SBOM (Software Bill of Materials).
- Gestionar secretos (API keys, DB passwords) de forma segura.
- Responder a CVEs encontradas.

---

### Contenido teórico (45 minutos)

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

#### 3. SCA en profundidad

**Herramientas:**

- **Snyk:** Integración npm, Python, Maven. Monitoreo continuo.
- **Dependabot:** GitHub nativa.
- **WhiteSource:** Enterprise.

**Flujo:**

1. Dev agrega dependencia: `npm install lodash@4.17.0`.
2. SCA escanea: "lodash@4.17.0 tiene CVE-2021-23337 (severity HIGH)".
3. Opción A: Bloquea instalación.
4. Opción B: Permite, pero crea issue. Dev debe upgradear.

#### 4. SBOM (Software Bill of Materials)

**Concepto:** Inventario completo de componentes (librerías, frameworks, tools) en software.

**Formato:** CycloneDX, SPDX.

**Ejemplo SBOM (formato JSON):**

```json
{
  "components": [
    {
      "name": "lodash",
      "version": "4.17.21",
      "license": "MIT",
      "purl": "pkg:npm/lodash@4.17.21"
    },
    {
      "name": "express",
      "version": "4.18.0",
      "license": "MIT",
      "purl": "pkg:npm/express@4.18.0"
    }
  ]
}
```

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

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

# UNIDAD 3. Operación, observabilidad e incidentes

---

## Clase 11: Los tres pilares de la observabilidad

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 6

### Objetivos de aprendizaje

- Distinguir logs, métricas y trazas.
- Implementar logging structured.
- Configurar alertas basadas en métricas.
- Usar distributed tracing para depurar request end-to-end.

---

### Contenido teórico (45 minutos)

#### 1. Logs

**Qué son:** Registros discretos de eventos.

Ejemplo:
```
2026-08-15T10:30:45Z INFO auth: User login successful (user_id=123)
2026-08-15T10:30:46Z ERROR payment: Transaction failed (error=timeout, retry=1)
```

**Structured logging (JSON):**
```json
{
  "timestamp": "2026-08-15T10:30:45Z",
  "level": "INFO",
  "service": "auth",
  "message": "User login successful",
  "user_id": 123,
  "duration_ms": 45
}
```

**Beneficio:** Parseable, queryable, analizable.

**Agregación:** ELK Stack (Elasticsearch, Logstash, Kibana), Splunk, Datadog.

#### 2. Métricas

**Qué son:** Números que evolucionan en el tiempo.

Ejemplos:
- CPU: 45%
- Memory: 2.1 GB / 8 GB
- Requests/segundo: 1200
- Error rate: 0.1%
- Response time P95: 150ms

**Monitoreo:**
```
Prometheus scrapes app every 15 seconds:
  cpu_usage: 45% → 46% → 45% → 47% → ...
  
Grafana visualiza:
  [Graph] CPU over 1 hour
  [Graph] Requests/sec
  [Alert] CPU > 80% for 5 min → Slack notification
```

#### 3. Trazas (Traces)

**Qué son:** Request end-to-end a través de servicios.

Ejemplo request: "usuario hace login"

```
POST /api/login (100ms total)
  │
  ├─ auth-service (50ms)
  │  ├─ validate credentials (10ms)
  │  ├─ query DB (20ms)
  │  └─ generate token (20ms)
  │
  ├─ audit-service (30ms)
  │  ├─ log login (15ms)
  │  └─ notify (15ms)
  │
  └─ cache-service (20ms)
     └─ store session (20ms)
```

**Herramientas:** Jaeger, Zipkin, DataDog APM.

---

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Diseñar logs estructura (12 min)**

Request de login. Qué información loguear? Campos.

**Actividad 2: Alertas críticas (13 min)**

App de comercio. 10 alertas críticas (error rate, latencia, etc.). Define threshold, escalation path.

---

## Clase 12: Golden Signals, SLI, SLO y Error Budgets

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 6

### Objetivos de aprendizaje

- Entender los 4 Golden Signals (latencia, errores, tráfico, saturación).
- Definir SLI (Service Level Indicators) y SLO (Service Level Objectives).
- Implementar error budgets.
- Usar error budgets para tomar decisiones (deploy vs. confiabilidad).

---

### Contenido teórico (45 minutos)

#### 1. Golden Signals (Google SRE)

**4 métricas universales:**

1. **Latencia:** ¿Cuánto tarda una request?
   - Target: P50 < 100ms, P95 < 200ms, P99 < 500ms.

2. **Errores:** ¿Qué % de requests fallan?
   - Target: < 0.1% (99.9% success rate).

3. **Tráfico:** ¿Cuántas requests por segundo?
   - Baseline: 5000 RPS. Pico: 50000 RPS.

4. **Saturación:** ¿Cuánto recurso % está en uso?
   - CPU < 70%, Memory < 80%, Disk < 85%.

**Dashboard típico:**

```
Latency         Error Rate      Traffic           Saturacion
[Graph P95]     [Graph %]       [Graph RPS]       [Graph CPU%]
150ms           0.05%           8500 RPS          65%
✓ HEALTHY       ✓ HEALTHY       ✓ NORMAL          ✓ HEALTHY
```

#### 2. SLI y SLO

**SLI (Service Level Indicator):** Métrica que mide un aspecto del servicio.

Ejemplo: "Latencia P95 de payment API".

```
Monday:   P95 = 150ms
Tuesday:  P95 = 180ms
Wednesday: P95 = 160ms
Average:  P95 = 163ms
```

**SLO (Service Level Objective):** Objetivo de qué debería ser el SLI.

Ejemplo: "Latencia P95 de payment API debe ser < 200ms en 99% de días".

```
SLI medido: 163ms
SLO target: < 200ms
Status: ✓ CUMPLIDO (163 < 200)
```

**SLA (Service Level Agreement):** Contrato. Si SLO se incumple, compensación.

Ejemplo: "Si uptime < 99.9%, crédito de $100/mes al cliente".

#### 3. Error Budget

**Concepto:** Si SLO es 99.9%, tienes presupuesto de fallos 0.1%.

**Cálculo:**

```
SLO: 99.9% uptime
Período: 30 días

Minutos totales: 30 × 24 × 60 = 43200 min
Error budget: 43200 × (1 - 0.999) = 43.2 minutos

Puedes tener ~43 minutos downtime en 30 días.
```

**Uso del error budget:**

- **Quedan 40 min:** Deploy nuevo feature. Riesgo OK.
- **Quedan 5 min:** Congelamos deploys. Solo hotfixes.
- **Se agotó:** Prioridad máxima: confiabilidad. Sin deploys.

**Decisión científica:** No es "sentimiento". Es matemática.

---

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Definir SLI/SLO (12 min)**

App de delivery. Define 5 SLI (qué medir?). Para cada, define SLO (qué target?).

**Actividad 2: Error budget planning (13 min)**

SLO: 99.95% uptime. Período: 1 mes. Calcula error budget en minutos.

Escenario: Ya gastaste 80% del budget. Un feature arriesgado solicita deploy. ¿Sí o no? ¿Por qué?

---

## Clase 13: Métricas DORA y medición del desempeño DevOps

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 7

### Objetivos de aprendizaje

- Entender las 4 métricas DORA.
- Medir y comparar desempeño (baseline vs. actual).
- Usar DORA para identificar bottlenecks.
- Crear plan de mejora basado en DORA.

---

### Contenido teórico (45 minutos)

#### 1. Métricas DORA (Forsgren et al., 2018)

**4 métricas que correlacionan con performance organizacional:**

1. **Deployment Frequency:** ¿Cuánto desplegamos?
   - Low: 1/mes.
   - Medium: 1/semana.
   - High: 1/día.
   - Elite: Múltiples/día.

2. **Lead Time for Changes:** ¿Cuánto tarda un cambio en llegar a producción?
   - Low: > 6 meses.
   - Medium: 1 mes a 6 meses.
   - High: 1 semana a 1 mes.
   - Elite: < 1 día.

3. **Mean Time to Recovery (MTTR):** Si algo falla, ¿cuánto tarda en recuperar?
   - Low: > 6 horas.
   - Medium: 1 hora a 6 horas.
   - High: < 1 hora.
   - Elite: < 15 minutos.

4. **Change Failure Rate (CFR):** ¿Qué % de cambios causa incidente/rollback?
   - Low: 46-60%.
   - Medium: 16-30%.
   - High: 0-15%.
   - Elite: 0-15%. (+ confianza para arreglar rápido).

**Hipótesis:** Equipos con DORA "Elite" son ~200x más rápidos y confiables.

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Medir DORA de equipo (12 min)**

Datos históricos de equipo. Calcula 4 métricas. Categoriza (Low/Medium/High/Elite). Identifica bottleneck #1.

**Actividad 2: Plan de mejora (13 min)**

Plan de 6 meses para llevar equipo de "Medium" a "High" en todas métricas. Propuestas concretas (herramientas, entrenamientos, cambios de proceso).

---

## Clase 14: Gestión de incidentes

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 7

### Objetivos de aprendizaje

- Clasificar incidentes por severidad.
- Implementar triage y escalación.
- Calcular y usar RTO/RPO.
- Ejecutar respuesta a incidentes coordinada.

---

### Contenido teórico (45 minutos)

#### 1. Severidad de incidentes

**SEV-1 (Crítico):** Pérdida total de funcionalidad. Impacto: todos los usuarios.
- Ejemplo: "Todas las transacciones fallan".
- RTO: < 15 minutos.
- Action: Encender alarmas. Todos los hands on deck.

**SEV-2 (Alto):** Funcionalidad parcial perdida. Impacto: muchos usuarios.
- Ejemplo: "Pagos con tarjeta no funcionan (ACH sí)".
- RTO: < 1 hora.
- Action: Escalada urgente.

**SEV-3 (Medio):** Feature no funciona pero hay workaround. Impacto: algunos usuarios.
- Ejemplo: "Filtro de búsqueda lento".
- RTO: < 4 horas.
- Action: Asignar ingenieros. Monitoreo.

**SEV-4 (Bajo):** Bug menor. Sin impacto. Ejemplo: Typo.
- RTO: < 1 semana.
- Action: Crear bug, asignar a sprint.

#### 2. Triage

**Objetivo:** Determinar severidad correcto.

**Preguntas:**
1. ¿Cuántos usuarios afectados?
2. ¿Impacto en revenue?
3. ¿Puerta de entrada para el atacante?
4. ¿Hay workaround?

**Resultado:** SEV-1/2/3/4. On-call engineer responde.

#### 3. RTO/RPO

**RTO (Recovery Time Objective):** ¿Cuánto tiempo máximo puede estar down?
- Banco: 1 hora.
- Fintech app: 15 minutos.
- E-commerce Black Friday: < 1 minuto.

**RPO (Recovery Point Objective):** ¿Cuántos datos podemos perder?
- Banco: 0 (cero tolerance).
- SaaS: < 1 hora (ej: backup cada hora).
- Blog: < 1 día.

**Implicación:** RTO/RPO pequeños requieren inversión (redundancia, backups).

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Clasificar incidentes (12 min)**

5 incidentes. Clasifica severidad. Define RTO.

**Actividad 2: Plan de respuesta (13 min)**

Diseña runbook para incidente SEV-1 de tu app. Pasos, quién hace qué, escalaciones, comunicación.

---

## Clase 15: Análisis causal y postmortem sin culpabilización

**Duración:** 2 horas | **Unidad:** 3 | **Semana:** 8

### Objetivos de aprendizaje

- Aplicar "Five Whys" para encontrar causa raíz.
- Diferenciar causa directa vs. causas sistémicas.
- Ejecutar postmortem blameless.
- Crear accionables. Seguimiento.

---

### Contenido teórico (45 minutos)

#### 1. Root Cause Analysis (RCA)

**Problema:** Servidor caído 30 minutos. ¿Por qué?

**Análisis causal (5 Whys):**

1. ¿Por qué se cayó el servidor?
   - "Memoria llena. Out of Memory error."

2. ¿Por qué se llena la memoria?
   - "Leak de memoria en versión 2.1.0 de app."

3. ¿Por qué hay leak?
   - "En request handler, no liberamos conexión a BD."

4. ¿Por qué no se liberó?
   - "Dev olvidó `.close()` en código."

5. ¿Por qué se pasó por alto?
   - "Code review no cubrió ese path. Tests no ejercitan ese edge case."

**Causa raíz sistémica:** Tests incompletos + Code review superficial. No es "Dev cometió error".

#### 2. Blameless postmortem

**Filosofía:** "Buscamos entender el sistema, no culpar a personas."

**Premisa:** Personas son inherentemente confiables. Errores ocurren porque **sistema permitió error**.

**Preguntas correctas:**
- ¿Qué condiciones permitieron este error?
- ¿Cómo podemos prevenir en el futuro?
- ¿Qué aprendimos?

**Preguntas INCORRECTAS:**
- ¿Quién cometió el error?
- ¿Por qué Dev no testeo?
- ¿Quién fue responsable?

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

### Ejemplos prácticos (40 minutos)

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

2. **Teste no cubrió caso de input vacío.**
   - Coverage report: 85%, pero ese path específico no testeado.

3. **Code review no detectó porque reviewer no correr tests localmente.**
   - Revisor solo leyó diff, no ejecutó.

**Contributing factors:**

- Deploy en horario con tráfico (debería ser después de horas).
- No hay circuit breaker (si recommendation falla, fallback a default).
- Monitoring de CPU alertó, pero latency não alertó (debería ser primary métrica).

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

### Actividades prácticas (25 minutos)

**Actividad 1: Five Whys analysis (12 min)**

Incident: "Base de datos down 1 hora".

Aplica 5 Whys. Identifica causa raíz sistémica.

**Actividad 2: Escribir postmortem (13 min)**

Mismo incident. Escribe postmortem blameless con: timeline, root causes, contributing factors, 3-5 accionables.

---

# UNIDAD 4. Mantenimiento, evolución, ética y liberación

---

## Clase 16: Tipos de mantenimiento y refactorización

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 8

### Objetivos de aprendizaje

- Clasificar mantenimiento (correctivo, adaptativo, perfectivo, preventivo).
- Aplicar refactorización sin cambiar comportamiento.
- Gestionar deuda técnica incremental.
- Usar feature flags para refactorización segura.

---

### Contenido teórico (45 minutos)

#### 1. Tipos de mantenimiento

**Correctivo:** Arreglar bugs.
- "Error en cálculo de impuestos → 3% dinero perdido."
- Urgencia: Alta.
- Ejemplo: Hotfix urgente.

**Adaptativo:** Cambiar software para entorno nuevo.
- "Migrar de Python 2 a Python 3."
- "Soportar iOS 16 + 17."
- Urgencia: Media-alta.
- Costo: Significativo.

**Perfectivo:** Mejorar funcionalidad sin cambiar requisitos.
- "Performance: query BD en 2s → 200ms."
- "Usabilidad: UI rediseño."
- Urgencia: Media.
- ROI: Indirecto (mejor retención de usuarios).

**Preventivo:** Evitar problemas futuros.
- "Actualizaciones de dependencias."
- "Refactorización de código frágil."
- "Mejoras de observabilidad."
- Urgencia: Baja.
- ROI: Largo plazo.

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Clasificar mantenimiento (12 min)**

5 cambios. Clasifica: correctivo, adaptativo, perfectivo, preventivo. Prioridad.

**Actividad 2: Refactorizar función (13 min)**

Código complejo dado. Refactoriza: extrae funciones, mejora tests, reduce coupling.

---

## Clase 17: Migración y sistemas heredados

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 9

### Objetivos de aprendizaje

- Estrategias de migración (big-bang vs. gradual).
- Patrón Strangler Fig.
- Gestionar datos en migración.
- De-risk grandes cambios.

---

### Contenido teórico (45 minutos)

#### 1. Estrategias de migración

**Big-Bang:**

"Apagamos sistema viejo. Prendemos nuevo. Esperamos que funcione."

Riesgo: Altísimo. Si falla, downtime total.

Cuándo: Nunca. Evitar.

---

**Gradual / Strangler Fig (Martin Fowler, 2004):**

New system gradualmente "estrangula" (reemplaza) funcionalidad del viejo.

```
Día 1: 90% viejo, 10% nuevo (login)
Día 2: 80% viejo, 20% nuevo (login + users)
Día 3: 70% viejo, 30% nuevo (... + payment)
...
Día 30: 0% viejo, 100% nuevo
```

Ventaja: Bajo riesgo. Rollback fácil.

Desventaja: Lento. Duplicación de código temporaria.

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Plan de migración (12 min)**

Sistema heredado dado. Diseña plan Strangler con 5-6 fases. Timeline.

**Actividad 2: Data migration strategy (13 min)**

Detalla: cómo transferir datos, validación, rollback, reconciliación.

---

## Clase 18: Deuda técnica y ciclo de vida de componentes con IA

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 9

### Objetivos de aprendizaje

- Cuantificar deuda técnica (SonarQube, metraje).
- Entender ciclo de vida de modelos IA (data drift, concept drift).
- Monitorear modelos en producción.
- MLOps practices.

---

### Contenido teórico (45 minutos)

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

#### 2. Ciclo de vida de componentes IA

**Componente:** Modelo de recomendación (ej: Netflix).

**Fases:**

1. **Desarrollo (Mes 1-2):**
   - Recolectar datos históricos.
   - Entrenar modelo (TensorFlow).
   - Validar en dataset test.
   - Performance: 85% accuracy.

2. **Deployment (Mes 3):**
   - Enviar modelo a producción.
   - A/B test: 10% usuarios ven recomendaciones nuevas.
   - Métrica: Click-through rate (CTR).

3. **Monitoreo (Mes 4+):**
   - **Data drift:** Distribución de entrada cambió.
     - Ej: Nuevas categorías de contenido. Modelo no vio antes.
     - Detección: Input features estadísticamente divergentes.
     - Acción: Re-train modelo.
   
   - **Concept drift:** Relación entre inputs y outputs cambió.
     - Ej: Usuarios cambian preferencias de género.
     - Detección: Model accuracy baja. CTR cae.
     - Acción: Retrain con datos frescos.

4. **Degradación (Mes 12+):**
   - Accuracy cae de 85% a 70%.
   - Necesita re-diseño.
   - Decisión: Retrain vs. nueva arquitectura.

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: MLOps pipeline (12 min)**

Diseña CI/CD para modelo IA. Stages: data, train, validate, deploy, monitor.

**Actividad 2: Gestionar deuda técnica (13 min)**

Proyecto con 25 días de deuda técnica. Plan de pago en 6 sprints. Decisiones: qué pagar primero?

---

## Clase 19: Ética profesional, licencias y accesibilidad

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 10

### Objetivos de aprendizaje

- Aplicar ACM Code of Ethics.
- Entender licencias de software (MIT, GPL, Apache).
- Implementar WCAG 2.2 (accesibilidad).
- Detectar sesgo y fairness en modelos IA.

---

### Contenido teórico (45 minutos)

#### 1. ACM Code of Ethics

**1. Contribuir a bienestar de la sociedad.**
- ¿Software causa daño (ej: vigilancia, desempleo)?
- Responsabilidad ética, no solo técnica.

**2. Evitar daño.**
- No desarrollar armas autónomas.
- No participar en fraude, corrupción.
- Reportar vulnerabilidades.

**3. Ser honesto y transparente.**
- Competencia real (no oversell).
- Limitaciones conocidas.
- Incertidumbre. Comunicar riesgos.

**4. Justiciar.**
- Software debe beneficiar a todos, no solo ricos.
- Accesibilidad. No discriminación.

**5. Respeto por privacidad y confidencialidad.**
- GDPR, CCPA, datos personales.
- Consentimiento informado.
- Minimizar recolección.

#### 2. Licencias de software

**MIT:**
- Permisiva. Comercial OK. Cambios OK. Simplemente cita.
- Usado: jQuery, Node.js.

**GPL (GNU Public License):**
- Copyleft. Si usas GPL code, tu código también debe ser GPL.
- No comercial (comercialmente si pagas).
- Usado: Linux, WordPress.

**Apache 2.0:**
- Permisiva. Comercial OK. Patent protection incluida.
- Usado: Android, Kubernetes.

**Commercial/Proprietary:**
- Código cerrado. Licencia paga. EULA.
- Usado: Adobe, Microsoft.

**Implicación para Dev:**
- Audita dependencias. ¿Licencia GPL? Afecta tu licencia.
- Herramientas: SBOM, WhiteSource, Black Duck.

#### 3. Accesibilidad (WCAG 2.2)

**Definición:** Software usable por personas con discapacidades (vista, audición, movilidad, cognitiva).

**Niveles:**
- A: Mínimo.
- AA: Recomendado.
- AAA: Mejor en clase.

**Requisitos comunes (AA):**

1. **Contrast:** Texto/fondo ratio >= 4.5:1 (colores contrastantes).
2. **Alt text:** Imágenes tienen descripción (screen readers).
3. **Keyboard accessible:** Todo funciona sin mouse (Tab, Enter).
4. **Captioning:** Videos tienen subtítulos.
5. **ARIA labels:** HTML semántico + ARIA roles para asistentes.

**Testing:**
- Manual + herramientas: Axe, WAVE.
- Usuarios reales (personas con discapacidades).

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

### Ejemplos prácticos (40 minutos)

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

### Actividades prácticas (25 minutos)

**Actividad 1: Ethical scenario (12 min)**

Scenario: PM pide agregar tracking de datos de usuarios sin consentimiento para "mejorar recomendaciones".

Respuesta ética: Qué dirías? Cómo lo justificas?

**Actividad 2: Accesibilidad audit (13 min)**

App dada. Auditoría manual + herramienta Axe. Lista de issues WCAG AA. Prioriza fixes.

---

## Clase 20: Sostenibilidad, decisión go/no-go y sustentación

**Duración:** 2 horas | **Unidad:** 4 | **Semana:** 10

### Objetivos de aprendizaje

- Entender Green Software.
- Aplicar checklist go/no-go antes de producción.
- Preparar sustentación de proyecto.
- Reflexionar sobre carrera en ingeniería de software.

---

### Contenido teórico (45 minutos)

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

### Ejemplos prácticos (40 minutos)

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

Razón: CVE high debe ser upgradeda, pero feature es crítica para lanzamiento. Plan: Upgrade en 48 horas post-deploy.

---

### Actividades prácticas (25 minutos)

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

