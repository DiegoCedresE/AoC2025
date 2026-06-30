

## Estructura del proyecto

El proyecto está organizado en varias clases, cada una con una responsabilidad concreta:

- **Main**: punto de entrada de la aplicación. Ejecuta el programa mostrando el resultado de ambas partes del reto.
- **RectangleService**: contiene la lógica principal para resolver la Parte 1 y la Parte 2.
- **PolygonService**: gestiona el polígono formado por las baldosas rojas y verdes, comprobando si un rectángulo pertenece completamente a la zona válida.
- **Point**: representa la posición de una baldosa mediante sus coordenadas (X, Y).

## Funcionamiento

Cada punto representa una baldosa roja mediante sus coordenadas:

```text
X,Y
```

Estos puntos forman el recorrido del borde del polígono.

La aplicación se divide en dos partes:

- **Parte 1:** busca el rectángulo de mayor área utilizando únicamente dos baldosas rojas como esquinas opuestas.
- **Parte 2:** además de utilizar dos baldosas rojas como esquinas opuestas, comprueba que todas las baldosas contenidas dentro del rectángulo pertenezcan a la región formada por las baldosas rojas y verdes.

Para calcular el resultado, el programa recorre todas las posibles parejas de puntos y calcula el área del rectángulo formado por ellas. En la segunda parte, antes de aceptar el rectángulo, se verifica que todo su contenido pertenezca al polígono.


## Arquitectura del proyecto

El proyecto sigue una arquitectura sencilla basada en la separación de responsabilidades:

- **Presentación:** `Main`
- **Lógica de negocio:** `RectangleService`
- **Validación del polígono:** `PolygonService`
- **Modelo:** `Point`

Esta organización facilita la lectura del código, la reutilización y el mantenimiento.


## Principios SOLID aplicados

### Single Responsibility Principle (SRP)

Cada clase posee una única responsabilidad:

- **Main** → ejecuta la aplicación y muestra los resultados.
- **RectangleService** → implementa el algoritmo para resolver ambas partes del problema.
- **PolygonService** → comprueba si un rectángulo pertenece completamente al polígono.
- **Point** → representa un punto del plano mediante sus coordenadas.

### Open/Closed Principle (OCP)

La lógica de validación del polígono se encuentra encapsulada en `PolygonService`. Si en el futuro se quisiera modificar la forma de comprobar los rectángulos válidos, únicamente sería necesario modificar esta clase sin afectar al resto de la aplicación.

## Encapsulación

Las clases mantienen sus atributos privados y únicamente exponen los métodos necesarios para utilizar su funcionalidad.

La lógica interna de comprobación del polígono permanece oculta para el resto del programa.

---

## Abstracción

La complejidad del algoritmo queda encapsulada dentro de `RectangleService` y `PolygonService`.

Desde `Main` únicamente se utilizan los métodos públicos:

```java
part1(...)
part2(...)
```

De esta forma, el punto de entrada permanece sencillo y desacoplado de la 

## Patrón de diseño utilizado

### Service

Se emplea el patrón **Service**, centralizando la lógica de negocio en clases específicas:

- **RectangleService** → cálculo de la solución.
- **PolygonService** → validación del polígono.

Este diseño permite separar claramente la lógica del algoritmo de la ejecución de la aplicación.


## Algoritmo utilizado

### Parte 1

El algoritmo recorre todas las posibles parejas de puntos y calcula el área del rectángulo que forman como esquinas opuestas.

Finalmente devuelve el área máxima encontrada.

### Parte 2

Además de recorrer todas las parejas de puntos, se verifica que el rectángulo completo pertenezca a la región delimitada por el polígono antes de calcular su área.

Solo los rectángulos completamente contenidos en la zona válida son considerados como solución.

---

## Tests

Se utilizan pruebas unitarias con **JUnit 5** para verificar el correcto funcionamiento del programa.

