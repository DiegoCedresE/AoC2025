# Advent of Code 2025

Proyecto realizado en Java para resolver uno de los retos de Advent of Code 2025.

## Estructura del proyecto

El proyecto está organizado en un único paquete que contiene todas las clases necesarias para resolver el problema:

- **Main**: punto de entrada de la aplicación.
- **Range**: representa un rango de IDs.
- **ParsedInput**: almacena los datos obtenidos tras procesar la entrada.
- **InputParser**: convierte el texto de entrada en objetos del modelo.
- **InventoryService**: contiene la lógica para resolver ambas partes del reto.
- **InventoryServiceTest**: pruebas unitarias realizadas con JUnit 5.

## Funcionamiento

La aplicación se divide en dos partes:

- **Parte 1**: determina cuántos IDs pertenecen a alguno de los rangos definidos.
- **Parte 2**: calcula el número total de IDs únicos cubiertos por todos los rangos, teniendo en cuenta los solapamientos.

Para ello:

1. `InputParser` procesa el texto de entrada.
2. Se crean los objetos `Range`.
3. Los datos se almacenan en `ParsedInput`.
4. `InventoryService` resuelve ambas partes del problema.

## Patrones de diseño utilizados

En este proyecto no se ha utilizado ningún patrón de diseño clásico (GoF), ya que el problema no presenta la complejidad suficiente para justificar su uso.

Se ha priorizado una solución sencilla, clara y fácil de mantener.

## Arquitectura Modelo-Servicio

El proyecto está dividido en:

- **Modelo**: clases que representan los datos (`Range` y `ParsedInput`).
- **Parser**: encargado de convertir la entrada en objetos (`InputParser`).
- **Servicio**: contiene la lógica de resolución del problema (`InventoryService`).
- **Main**: punto de entrada de la aplicación.

Esta separación facilita la organización, el mantenimiento y la reutilización del código.

## Principios SOLID aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad.

Ejemplos:

- `InputParser` procesa el texto de entrada.
- `Range` representa un rango de IDs.
- `ParsedInput` almacena los datos obtenidos tras el parseo.
- `InventoryService` resuelve el problema.
- `Main` ejecuta la aplicación.

### Open/Closed Principle (OCP)

La lógica del problema está separada del procesamiento de la entrada. Si el formato de los datos cambiara, únicamente sería necesario modificar `InputParser`, sin afectar a `InventoryService`.

## Encapsulación

Las clases del modelo encapsulan sus atributos mediante campos privados y proporcionan acceso a ellos mediante métodos públicos (`getters`).

Esto protege el estado interno de los objetos y evita modificaciones directas desde otras clases.

## Tests

Se utilizan pruebas unitarias con **JUnit 5** para verificar el funcionamiento de ambas partes del problema y comprobar distintos casos de prueba, como:

- Ejemplo del enunciado.
- Rangos vacíos.
- Un único rango.
- Rangos solapados.