

## Estructura del proyecto

El proyecto está organizado en un único paquete que contiene las clases necesarias para resolver el problema:

- **Main**: punto de entrada de la aplicación.
- **TachyonSolver**: contiene la lógica para resolver ambas partes del reto.

## Funcionamiento

El problema consiste en simular el recorrido de un haz de taquiones a través de un manifold representado como una matriz de caracteres.

El tablero está formado por:

- `S`: punto de inicio del haz.
- `.`: espacio vacío por el que el haz continúa descendiendo.
- `^`: divisor (*splitter*), que detiene el haz actual y genera dos nuevos haces, uno hacia la izquierda y otro hacia la derecha.

La aplicación se divide en dos partes:

- **Parte 1**: calcula el número total de divisiones producidas al recorrer el manifold.
- **Parte 2**: calcula el número total de líneas temporales generadas siguiendo la interpretación cuántica del problema.

## Arquitectura del proyecto

El proyecto sigue una arquitectura sencilla basada en la separación de responsabilidades:

- **Presentación**: `Main`
- **Lógica de negocio**: `TachyonSolver`

Esta organización mantiene el código simple, legible y fácil de mantener.

## Principios SOLID aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad:

- `Main` → ejecuta la aplicación, carga la entrada y muestra los resultados.
- `TachyonSolver` → implementa la lógica necesaria para resolver ambas partes del problema.

## Encapsulación

La clase `TachyonSolver` encapsula el tablero y los datos necesarios para la resolución mediante atributos privados, evitando que puedan modificarse directamente desde otras clases.

## Abstracción

La lógica interna del algoritmo queda oculta al usuario. Desde `Main` únicamente se utilizan los métodos públicos:

- `countSplits()`
- `countTimelines()`

De esta forma, el funcionamiento interno del algoritmo permanece desacoplado de la ejecución del programa.

## Tests

Se utilizan pruebas unitarias con **JUnit 5** para verificar el correcto funcionamiento del programa.

Los tests incluyen:

- Ejemplo del enunciado (Parte 1).
- Ejemplo del enunciado (Parte 2).
