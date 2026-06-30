

## Descripción

Este proyecto resuelve las dos partes del reto utilizando Programación Orientada a Objetos. La lógica de validación de los IDs se ha separado del servicio principal para facilitar el cambio entre la Parte 1 y la Parte 2 sin modificar el resto del código.

## Arquitectura

Se utiliza una arquitectura sencilla por capas:

- **App**: punto de entrada de la aplicación.
- **InvalidIdService**: contiene la lógica para recorrer los rangos y calcular la suma.
- **RepeatedPatternRule**: implementa la validación de los IDs.
- **Range**: representa un rango de números.

## Patrón de diseño

### Strategy

Se utiliza el patrón **Strategy** mediante la interfaz `InvalidRule`.

Esto permite cambiar el algoritmo de validación (Parte 1 o Parte 2) sin modificar `InvalidIdService`, únicamente cambiando la estrategia utilizada.

## Principios SOLID

### SRP (Single Responsibility Principle)

Cada clase tiene una única responsabilidad:

- `App`: ejecuta la aplicación.
- `Range`: representa un rango.
- `InvalidIdService`: calcula la suma de los IDs inválidos.
- `RepeatedPatternRule`: valida si un ID es inválido.

### OCP (Open/Closed Principle)

El servicio está preparado para extender el comportamiento sin modificar su código. La diferencia entre la Parte 1 y la Parte 2 se gestiona mediante distintos modos de validación.

### DIP (Dependency Inversion Principle)

`InvalidIdService` depende de la abstracción `InvalidRule` en lugar de depender directamente de una implementación concreta de validación.

## Tests

Se han desarrollado pruebas con **JUnit 5** para comprobar:

- Casos individuales.
- El ejemplo completo de la Parte 1.
- El ejemplo completo de la Parte 2.