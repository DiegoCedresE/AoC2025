## Arquitectura

Se utiliza una arquitectura sencilla por capas:

- **Main**: punto de entrada de la aplicación.
- **Machine**: representa una máquina con sus luces, botones y niveles de voltaje.
- **Solver**: interfaz que define el algoritmo de resolución.
- **Part1Solver**: implementa la resolución de la primera parte.
- **Part2Solver**: implementa la resolución de la segunda parte.

## Patrón de diseño

### Strategy

Se utiliza el patrón **Strategy** mediante la interfaz `Solver`.

Las clases `Part1Solver` y `Part2Solver` implementan dicha interfaz, permitiendo cambiar el algoritmo utilizado sin modificar el resto del programa.

## Principios SOLID

### SRP (Single Responsibility Principle)

Cada clase tiene una única responsabilidad:

- `Main`: ejecuta la aplicación y muestra el resultado.
- `Machine`: almacena la información de cada máquina.
- `Part1Solver`: resuelve la primera parte del problema.
- `Part2Solver`: resuelve la segunda parte del problema.

### OCP (Open/Closed Principle)

El diseño permite añadir nuevas estrategias de resolución implementando la interfaz `Solver`, sin modificar el código existente.

### DIP (Dependency Inversion Principle)

`Main` trabaja con la abstracción `Solver` en lugar de depender directamente de una implementación concreta, lo que facilita cambiar el algoritmo de resolución.

## Algoritmos

### Parte 1

Se utiliza una búsqueda por fuerza bruta mediante máscaras de bits. Cada botón puede pulsarse una única vez (o no pulsarse), por lo que se prueban todas las combinaciones posibles y se selecciona la que consigue el estado objetivo con el menor número de pulsaciones.

### Parte 2

Se utiliza una búsqueda en anchura (BFS). Cada estado representa el valor actual de los contadores y, a partir de él, se generan nuevos estados pulsando los distintos botones. El algoritmo garantiza encontrar el número mínimo de pulsaciones necesario para alcanzar el objetivo.

## Tests

Se han desarrollado pruebas con **JUnit 5** para comprobar:

- El resultado de la primera parte para el ejemplo del enunciado.
- El resultado de la segunda parte para el ejemplo del enunciado.
- El resultado total de la Parte 1 (7).
- El resultado total de la Parte 2 (33).