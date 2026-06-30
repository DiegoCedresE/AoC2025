
## Descripción

Este proyecto resuelve las dos partes del reto utilizando Programación Orientada a Objetos. El problema se modela como un **grafo dirigido**, donde cada dispositivo representa un nodo y las conexiones representan las aristas.

Se utiliza un algoritmo de búsqueda en profundidad (**DFS - Depth First Search**) para encontrar todos los caminos posibles entre un nodo inicial y el nodo final.

- Parte 1: contar todos los caminos desde `you` hasta `out`.
- Parte 2: contar los caminos desde `svr` hasta `out` que además pasan por los nodos `dac` y `fft`.

---

## Arquitectura

Se utiliza una arquitectura sencilla basada en separación de responsabilidades:

- **Main**: punto de entrada de la aplicación.
- **Graph**: representa el grafo mediante una lista de adyacencia.
- **GraphParser**: convierte el input en texto a una estructura de grafo.
- **PathFinder**: contiene la lógica del algoritmo DFS para calcular caminos.

---

## Patrón de diseño

### Strategy (conceptual)

El comportamiento del algoritmo podría separarse en distintas estrategias (conteo simple y conteo con condiciones). En esta implementación se mantiene en la misma clase para simplificar la solución.


## Principios SOLID

### SRP (Single Responsibility Principle)

Cada clase tiene una única responsabilidad:

- `Main`: ejecuta la aplicación.
- `Graph`: almacena la estructura del grafo.
- `GraphParser`: construye el grafo a partir del input.
- `PathFinder`: implementa la lógica del DFS.

---

### OCP (Open/Closed Principle)

La solución está preparada para extender el comportamiento del algoritmo sin modificar las clases existentes, por ejemplo añadiendo nuevas condiciones de búsqueda.

---

### DIP (Dependency Inversion Principle)

`PathFinder` depende de la abstracción del grafo (`Graph`) en lugar de una implementación concreta de estructuras complejas, lo que permite modificar la implementación interna sin afectar la lógica del algoritmo.



## Tests

Se han implementado tests con **JUnit 5** para validar:

- El ejemplo de la Parte 1 (5 caminos de `you` a `out`).
- El ejemplo de la Parte 2 (2 caminos que pasan por `dac` y `fft`).
- Casos adicionales simples para verificar el funcionamiento del DFS.

