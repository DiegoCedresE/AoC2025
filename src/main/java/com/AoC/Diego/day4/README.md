# Advent of Code 2025 - Día XX

Proyecto desarrollado en **Java** para resolver el reto correspondiente del **Advent of Code 2025**.

## Estructura del proyecto

El proyecto está organizado en las siguientes clases:

- **Main**: punto de entrada de la aplicación. Lee la entrada y muestra el resultado de ambas partes.
- **PaperGrid**: representa el tablero y proporciona las operaciones necesarias para consultar y modificar su estado.
- **PaperRollSolver**: contiene la lógica necesaria para resolver las dos partes del problema.
- **PaperRollSolverTest**: pruebas unitarias desarrolladas con JUnit 5.

---

## Funcionamiento

La aplicación sigue el siguiente flujo:

1. Lee el mapa de entrada.
2. Construye el tablero mediante `PaperGrid`.
3. Calcula los rollos accesibles para la Parte 1.
4. Simula la eliminación sucesiva de los rollos accesibles para resolver la Parte 2.
5. Muestra los resultados por consola.

---

## Arquitectura

Se ha utilizado una arquitectura sencilla basada en la separación de responsabilidades:

- **Modelo (Model)**: `PaperGrid`, encargado de representar el estado del tablero.
- **Servicio (Service)**: `PaperRollSolver`, donde se implementa toda la lógica del algoritmo.
- **Aplicación**: `Main`, responsable de iniciar la ejecución del programa y mostrar los resultados.

Esta organización facilita el mantenimiento del código y permite que cada clase tenga una función bien definida.

---

## Principios de diseño

### Single Responsibility Principle (SRP)

Se ha aplicado el principio de **Responsabilidad Única**, ya que cada clase tiene una única función dentro de la aplicación:

- **Main** se encarga únicamente de iniciar el programa y mostrar los resultados.
- **PaperGrid** representa y gestiona el estado del tablero.
- **PaperRollSolver** implementa el algoritmo que resuelve el reto.
- **PaperRollSolverTest** verifica el correcto funcionamiento mediante pruebas unitarias.

Esta separación facilita el mantenimiento del código y hace que futuras modificaciones afecten únicamente a la clase responsable.

### Encapsulación

La representación interna del tablero permanece oculta dentro de `PaperGrid`. El acceso a la matriz se realiza únicamente mediante métodos públicos como `isPaper()`, `removePaper()` o `inside()`, evitando modificaciones directas desde otras clases.


## Patrones de diseño

Debido al tamaño y la naturaleza del problema, no ha sido necesario aplicar patrones de diseño clásicos (como Strategy, Factory o Observer). Se ha optado por una solución simple basada en la separación de responsabilidades, lo que mejora la legibilidad y facilita el mantenimiento del código sin añadir complejidad innecesaria.

---

## Complejidad

- **Parte 1:** recorre todo el tablero comprobando los ocho vecinos de cada posición.
- **Parte 2:** repite el proceso de eliminación mientras existan rollos accesibles.

Esta solución ofrece un rendimiento adecuado para el tamaño de los datos proporcionados por el reto.

---

## Tests

Se han desarrollado pruebas unitarias utilizando **JUnit 5** para comprobar:

- El ejemplo oficial de la Parte 1.
- El ejemplo oficial de la Parte 2.
- Un tablero vacío.
- Un tablero con un único rollo de papel.

Estas pruebas permiten verificar el correcto funcionamiento del algoritmo antes de ejecutarlo con la entrada definitiva.