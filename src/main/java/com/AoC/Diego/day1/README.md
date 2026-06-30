

Proyecto realizado en Java para resolver los retos de Advent of Code 2025.

## Funcionamiento

Cada día dispone de:

- Un `Main` para ejecutar la solución.
- Clases de modelo para representar los datos de entrada.
- Un servicio que contiene la lógica del problema.
- Tests con JUnit 5 para comprobar el funcionamiento.

Los datos de entrada se leen desde `src/main/resources/dayXX/input.txt`.

## Patrones de diseño utilizados

### Strategy

Se utiliza el patrón **Strategy** mediante el enum `Direction`.

Cada dirección (`L` y `R`) implementa su propia forma de mover el dial, evitando condicionales en el servicio.

### Arquitectura Modelo-Servicio

El proyecto está dividido en:

- **Modelo**: clases que representan los datos (`Rotation`, `Direction`...).
- **Servicio**: contiene la lógica de resolución del problema.
- **Main**: punto de entrada de la aplicación.

Esta separación facilita la organización y el mantenimiento del código.

## Principios SOLID aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad.

Ejemplos:

- `InputReader` únicamente lee archivos.
- `Rotation` representa una rotación.
- `SafeService` resuelve el problema.
- `Main` ejecuta la aplicación.

### Open/Closed Principle (OCP)

La lógica de movimiento está encapsulada en `Direction`, por lo que se pueden añadir nuevos comportamientos sin modificar el servicio principal.

## Tests

Se utilizan pruebas unitarias con **JUnit 5** para verificar las soluciones de cada parte del problema y comprobar distintos casos de prueba.