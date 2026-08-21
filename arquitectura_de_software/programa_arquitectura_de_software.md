# Arquitecturas de Software

## Unidad 1. Fundamentos, drivers y documentación arquitectónica

### Fundamentos y drivers

- Arquitectura como estructuras y decisiones; costo de cambio; deuda y erosión
- Requisitos arquitectónicamente significativos y drivers
- Atributos de calidad (ISO/IEC 25010:2023) y escenarios de calidad (fuente, estímulo, respuesta, medida)

### Estilos y documentación

- Estilos, patrones y tácticas; criterios de selección y trade-offs
- ISO/IEC/IEEE 42010; vistas 4+1; modelo C4 (contexto, contenedores, componentes)
- Registros de decisión arquitectónica (ADR) y arquitectura como código
- Uso de IA como revisora inicial de ambigüedades y contradicciones, con validación

---

## Unidad 2. Diseño orientado por atributos y arquitecturas cloud-native

### Diseño orientado por atributos

- Attribute-Driven Design (ADD): de drivers a estructuras; patrones y tácticas
- Árbol de utilidad; sensitivity y trade-off points; uso académico acotado de ATAM

### Cloud-native y contenerización

- Principios cloud-native y Twelve-Factor App
- Docker y Docker Compose; configuración externa y secretos; introducción a Kubernetes
- Uso de IA para generar Dockerfiles, revisados y validados

---

## Unidad 3. Integración, resiliencia, capacidad y validación

### Integración y componentes de IA

- Comunicación síncrona y asíncrona; API Gateway; colas, eventos e idempotencia
- La IA como componente arquitectónico: inferencia, embeddings, RAG, guardrails, human-in-the-loop y fallback

### Resiliencia, capacidad y validación

- Patrones de resiliencia (timeout, retry, circuit breaker, bulkhead, fallback)
- Estimación de capacidad con supuestos explícitos; topología de despliegue
- Pruebas de carga (k6/JMeter) y observabilidad básica (logs, métricas, trazas)
- Uso de IA para analizar trade-offs de integración y resultados de pruebas, con validación

---

## Unidad 4. Proyecto integrador: grupo de arquitectura

### Diseño y prototipo

- Drivers, escenarios y arquitectura candidata; C4, ADR y ATAM simplificado
- Prototipo arquitectónico contenerizado; resiliencia y validación end-to-end

### Validación, cambio y defensa

- Prueba de carga, observabilidad y estimación contrastada
- Análisis de impacto de un cambio, defensa técnica individual y autorreferencia final
