
## Descripción

Este proyecto resuelve un problema de colocación de piezas en un tablero bidimensional. El objetivo es determinar cuántas regiones pueden contener todas las piezas dadas, permitiendo rotaciones y reflejos.

La solución está basada en Programación Orientada a Objetos y utiliza un algoritmo de backtracking para explorar todas las combinaciones posibles de colocación.


## Arquitectura

Se utiliza una arquitectura sencilla basada en separación de responsabilidades:

- **Main**: punto de entrada de la aplicación. Encargado del parsing del input y ejecución del solver.
- **PuzzleSolver**: implementa el algoritmo de backtracking para resolver el problema.
- **Board**: representa el tablero y gestiona las reglas de colocación de piezas.
- **Shape**: representa cada pieza y genera sus transformaciones (rotaciones y reflejos).
- **Point**: representa una coordenada en el tablero.

---

## Patrón de diseño

### Strategy (implícito)

El algoritmo de resolución se basa en **backtracking**, que actúa como una estrategia de exploración del espacio de soluciones.

Esto permite que el `PuzzleSolver` pueda ser sustituido por otro enfoque (heurístico u optimizado) sin modificar el resto del sistema.

### Composite (simplificado)

Cada `Shape` está compuesta por múltiples `Point`, formando una única entidad que representa una pieza completa del problema.

---

## Principios SOLID

### SRP (Single Responsibility Principle)

Cada clase tiene una única responsabilidad:

- `Main`: parseo del input y ejecución.
- `PuzzleSolver`: lógica de resolución.
- `Board`: gestión del estado del tablero.
- `Shape`: representación y transformaciones de piezas.
- `Point`: estructura de datos simple.

---

### OCP (Open/Closed Principle)

El sistema está abierto a extensión:

- Se pueden añadir nuevas piezas (`Shape`) sin modificar el solver.
- Se puede cambiar el algoritmo de resolución sin modificar el dominio.

---

### DIP (Dependency Inversion Principle)

El `PuzzleSolver` depende de abstracciones simples (`Board`, `Shape`) en lugar de depender del input o del parsing.

---

## Tests

Se han implementado tests con **JUnit 5** para validar el sistema:

- Casos básicos de colocación de piezas.
- Casos donde no es posible encajar todas las piezas.
- Validación de transformaciones de `Shape` (rotaciones y reflejos).
- Test de integración simplificado del problema.

