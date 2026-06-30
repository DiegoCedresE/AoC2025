

## Estructura del proyecto

El proyecto está organizado en un único paquete que contiene todas las clases necesarias para resolver el problema:

- **Mainday6**: punto de entrada de la aplicación.
- **WorksheetSolver**: contiene la lógica principal para resolver ambas partes del reto.
- **WorksheetParser**: se encarga de interpretar el texto de entrada y convertirlo en estructuras de datos.
- **Problem**: representa cada operación del problema (lista de números y operador).

## Funcionamiento

El problema consiste en resolver una serie de operaciones matemáticas representadas en un formato en forma de rejilla.

Cada bloque contiene:
- Varios números organizados en columnas.
- Un operador (`+` o `*`) al final del bloque.

La aplicación se divide en dos partes:

- **Parte 1**: los números se leen directamente por filas.
- **Parte 2**: los números se reconstruyen leyendo las columnas de derecha a izquierda.

## Arquitectura del proyecto

El proyecto sigue una arquitectura simple basada en separación de responsabilidades:

- **Modelo**: `Problem`
- **Parser**: `WorksheetParser`
- **Lógica de negocio**: `WorksheetSolver`
- **Main**: `Mainday6`

Esta separación permite mantener el código organizado, legible y fácil de modificar.

## Principios SOLID aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad:

- `WorksheetParser` → interpreta la entrada.
- `WorksheetSolver` → resuelve el problema matemático.
- `Problem` → almacena los datos de cada operación.
- `Mainday6` → ejecuta la aplicación.

### Open/Closed Principle (OCP)

La lógica de resolución está separada del parsing, lo que permite modificar el formato de entrada sin cambiar la lógica del solver.

## Encapsulación

La clase `Problem` encapsula sus datos mediante atributos privados y getters, evitando modificaciones externas directas.

## Tests

Se utilizan pruebas unitarias con **JUnit 5** para verificar el correcto funcionamiento del programa.

Los tests incluyen:

- Ejemplo del enunciado (Parte 1 y Parte 2).
- Casos simples de suma.
- Casos simples de multiplicación.
- Casos pequeños combinados.
- Validación de que el parser no rompe con entradas mínimas.