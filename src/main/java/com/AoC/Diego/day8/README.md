
## Estructura del proyecto

El proyecto está organizado en varias clases, cada una con una responsabilidad concreta:

- **Main**: punto de entrada de la aplicación. Ejecuta el programa mostrando el resultado de ambas partes del reto.
- **CircuitService**: contiene la lógica principal para resolver la Parte 1 y la Parte 2.
- **Point**: representa la posición de una caja de conexiones en el espacio mediante coordenadas (X, Y, Z).
- **Edge**: representa una posible conexión entre dos cajas de conexiones, almacenando los dos puntos y la distancia entre ellos.
- **UnionFind**: implementa la estructura de datos *Disjoint Set Union (DSU)* para gestionar los distintos circuitos.

## Funcionamiento

Cada línea de la entrada representa la posición de una caja de conexiones mediante sus coordenadas tridimensionales:

```text
X,Y,Z
```

El programa genera todas las conexiones posibles entre las cajas de conexiones, calcula la distancia euclídea entre ellas y las ordena de menor a mayor distancia.

Posteriormente utiliza la estructura **Union-Find** para ir conectando las cajas de conexiones y formar circuitos.

La aplicación se divide en dos partes:

- **Parte 1:** realiza las 1000 conexiones más cortas (10 en el ejemplo del enunciado) y calcula el producto de los tamaños de los tres circuitos más grandes.
- **Parte 2:** continúa realizando conexiones hasta que todas las cajas pertenezcan al mismo circuito y devuelve el producto de las coordenadas **X** de la última conexión realizada.

## Arquitectura del proyecto

El proyecto sigue una arquitectura sencilla basada en la separación de responsabilidades:

- **Presentación:** `Main`
- **Lógica de negocio:** `CircuitService`
- **Modelo:** `Point` y `Edge`
- **Estructura de datos:** `UnionFind`

Esta organización facilita la lectura del código y su mantenimiento.

## Principios SOLID aplicados

### Single Responsibility Principle (SRP)

Cada clase posee una única responsabilidad:

- **Main** → ejecuta la aplicación y muestra los resultados.
- **CircuitService** → implementa el algoritmo de resolución del problema.
- **Point** → representa un punto en el espacio tridimensional.
- **Edge** → representa una conexión entre dos puntos.
- **UnionFind** → gestiona los conjuntos de nodos conectados.

## Encapsulación

Todas las clases utilizan atributos privados para proteger su estado interno y acceder a ellos mediante métodos públicos cuando es necesario.

## Abstracción

La complejidad del algoritmo queda oculta dentro de `CircuitService`.

Desde `Main` únicamente se invocan los métodos públicos:

- `solvePart1(...)`
- `solvePart2(...)`

Esto permite utilizar el servicio sin conocer los detalles de su implementación.

## Patrón de diseño utilizado

### Strategy (ordenación mediante Comparable)

La clase `Edge` implementa la interfaz `Comparable<Edge>`, permitiendo definir una estrategia de ordenación basada en la distancia entre conexiones.

Gracias a ello, las conexiones pueden ordenarse fácilmente utilizando:

```java
Collections.sort(edges);
```

Este diseño desacopla el criterio de comparación de la lógica principal del algoritmo.

## Algoritmo utilizado

Para resolver el problema se emplea el algoritmo de **Kruskal**, utilizando la estructura de datos **Union-Find (Disjoint Set Union)**.

El algoritmo consiste en:

1. Generar todas las conexiones posibles.
2. Calcular la distancia entre cada par de puntos.
3. Ordenar las conexiones por distancia.
4. Recorrer las conexiones desde la más corta hasta la más larga.
5. Unir únicamente aquellas conexiones que pertenecen a circuitos diferentes.

Esta estrategia garantiza que las conexiones se realizan siguiendo exactamente el orden solicitado en el enunciado.

## Tests

Se utilizan pruebas unitarias con **JUnit 5** para verificar el correcto funcionamiento del programa.
