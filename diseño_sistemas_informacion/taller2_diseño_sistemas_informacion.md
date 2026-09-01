# Taller 2 de Diseño de Sistemas de Informacion

## Objetivo del taller

El objetivo de este taller es comprender cómo se construye una aplicación simple en Python con operaciones básicas de una calculadora, y cómo se valida su funcionamiento mediante diferentes niveles de pruebas:

- Pruebas unitarias
- Pruebas de integración
- Pruebas end-to-end (E2E)

Este enfoque permite ver cómo una aplicación puede validarse desde el nivel más pequeño de lógica hasta la interacción completa con el sistema.

## Descripcion general

Se debe desarrollar una calculadora en Python con las siguientes operaciones:

- API para sumar: recibe dos números y devuelve el resultado
- API para restar: recibe dos números y devuelve el resultado
- API para multiplicar: recibe dos números y devuelve el resultado
- API para dividir: recibe dos números y devuelve el resultado

La idea es que cada operación pueda ser ejecutada de forma independiente, y que luego se prueben sus comportamientos con valores positivos y negativos.

## Funcionalidades a implementar

### 1. Suma
- Entrada: dos números
- Resultado: suma de ambos
- Ejemplo: 5 + 3 = 8

### 2. Resta
- Entrada: dos números
- Resultado: diferencia entre el primero y el segundo
- Ejemplo: 10 - 4 = 6

### 3. Multiplicación
- Entrada: dos números
- Resultado: producto de ambos
- Ejemplo: 6 * 7 = 42

### 4. División
- Entrada: dos números
- Resultado: cociente de la división
- Importante: debe manejar la división entre cero, porque es una validación necesaria en aplicaciones reales
- Ejemplo: 20 / 5 = 4

## Pasos generales para realizar el taller

### Paso 1: Definir el proyecto
- Crear una estructura de carpetas para el proyecto
- Separar la lógica de negocio de la API o servicio
- Definir un archivo principal para la calculadora y otro para las pruebas

### Paso 2: Desarrollar la lógica de la calculadora
- Implementar funciones en Python para cada operación
- Validar tipos de datos y casos especiales como división entre cero
- Asegurarse de que cada operación retorne un resultado correcto

### Paso 3: Exponer las operaciones como API
- Crear una API REST con Flask o FastAPI
- Definir endpoints para cada operación
- Recibir los parámetros como números
- Devolver respuestas JSON con el resultado

### Paso 4: Realizar pruebas unitarias con pytest
- Probar cada operación con números positivos
- Probar cada operación con números negativos
- Verificar casos límite como cero y división por cero
- Ejecutar una prueba por operación y validar el resultado esperado

Ejemplo de enfoque:
- test_sum_positive_numbers()
- test_sum_negative_numbers()
- test_subtract_positive_numbers()
- test_subtract_negative_numbers()
- test_multiply_positive_numbers()
- test_multiply_negative_numbers()
- test_divide_positive_numbers()
- test_divide_negative_numbers()
- test_divide_by_zero()

### Paso 5: Realizar pruebas de integración con SOAPUI
- Configurar la API para que pueda ser consumida por una herramienta de pruebas tipo SOAPUI
- Crear pruebas de integración por cada operación
- Comprobar que la API responde correctamente a entradas válidas e inválidas
- Verificar que los valores positivos y negativos funcionan correctamente

SOAPUI se usa para validar que los servicios interactúan bien con clientes externos y que la comunicación funciona según lo esperado.

### Paso 6: Realizar pruebas E2E con Serenity BDD
- Definir escenarios de negocio para cada operación
- Hacer pruebas desde la perspectiva del usuario final
- Validar que la operación se ejecuta de manera correcta dentro del flujo completo
- Incluir escenarios con números positivos y negativos

Serenity BDD ayuda a describir pruebas en lenguaje cercano al negocio, facilitando su comprensión y mantenimiento.

### Paso 7: Ejecutar y documentar resultados
- Ejecutar todas las pruebas en orden
- Revisar fallos y corregir errores
- Guardar evidencia de ejecución
- Preparar la entrega final con explicación del resultado

## Tareas del taller

- Desarrollar en Python una calculadora con operaciones básicas
- Crear API para cada una de las operaciones
- Hacer pruebas unitarias con pytest
- Hacer pruebas de integración con SOAPUI
- Hacer pruebas E2E con Serenity BDD

### Requerimientos de pruebas

Para cada operación, se deben crear pruebas con:

- Números positivos
- Números negativos

Ejemplo:
- Sumar 5 + 3
- Sumar -5 + (-3)
- Restar 10 - 4
- Restar -10 - (-4)
- Multiplicar 6 * 7
- Multiplicar -6 * (-7)
- Dividir 20 / 5
- Dividir -20 / (-5)

## ¿Qué se evalúa en este taller?

- Correcta implementación de las operaciones
- Calidad de las pruebas unitarias
- Uso adecuado de herramientas de pruebas
- Comprensión del ciclo de validación de software
- Capacidad para diferenciar pruebas unitarias, de integración y E2E

## Recursos recomendados (videos)

### Pytest
- Tutorial completo de pytest: https://www.youtube.com/watch?v=umi2n3_7R0Q
- Pytest para principiantes: https://www.youtube.com/watch?v=Y8JXbA5M9Wk
- Testing en Python con pytest: https://www.youtube.com/watch?v=0nM5r3zmd84

### SOAPUI
- Introducción a SoapUI: https://www.youtube.com/watch?v=6bIWR0A2LkE
- SoapUI tutorial para pruebas API: https://www.youtube.com/watch?v=GoL3FhQK5cI
- SoapUI REST API testing: https://www.youtube.com/watch?v=9Qj0gXwO5Wg

### Serenity BDD
- Serenity BDD tutorial: https://www.youtube.com/watch?v=8L8u8xGmD8A
- Introducción a Serenity BDD con Java: https://www.youtube.com/watch?v=E5b9Q2frFQ8
- Serenity BDD + Selenium: https://www.youtube.com/watch?v=J1n6lY4Vw3A

## Recomendaciones para entregar el taller

- Documenta cada operación con su nombre y su propósito
- Guarda evidencia de las pruebas ejecutadas
- Haz una breve explicación de cada tipo de prueba
- Compara los resultados entre pruebas unitarias, integración y E2E
- Incluye ejemplos con números positivos y negativos

## Resumen corto

Este taller ayuda a entender que no basta con construir una aplicación: también es necesario probarla correctamente. La lógica se valida con pytest, la comunicación con servicios se valida con SOAPUI y el comportamiento del sistema completo se valida con Serenity BDD.

En resumen, la secuencia ideal es:

1. Construir la calculadora
2. Probar cada operación con pytest
3. Probar la integración con SoapUI
4. Validar el flujo completo con Serenity BDD
5. Presentar evidencia y conclusiones