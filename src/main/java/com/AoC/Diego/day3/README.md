# Battery Joltage

Proyecto realizado en Java para resolver el problema **Battery Joltage**.

## Estructura del proyecto

- **Main**: punto de entrada de la aplicación.
- **JoltageCalculator**: procesa los bancos de baterías y calcula el resultado de cada parte.
- **JoltageStrategy**: contiene los algoritmos utilizados para obtener el mayor voltaje posible.
- **Test**: pruebas unitarias realizadas con JUnit 5.

## Funcionamiento

El programa recibe varias líneas de entrada, donde cada línea representa un banco de baterías.

Se resuelven dos partes:

- **Parte 1**: se seleccionan exactamente dos baterías para formar el mayor número posible.
- **Parte 2**: se seleccionan exactamente doce baterías para formar el mayor número posible.

En ambos casos se mantiene el orden de las baterías y se suma el resultado obtenido en todos los bancos.

## Patrón de diseño utilizado

### Strategy

Se utiliza una clase (`JoltageStrategy`) para separar los algoritmos de cálculo del procesamiento del problema.

De esta forma, `JoltageCalculator` únicamente se encarga de recorrer los bancos de baterías y delega el cálculo de cada parte en la estrategia correspondiente, consiguiendo un código más organizado y fácil de mantener.

## Principios SOLID aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad.

Ejemplos:

- `Main` ejecuta la aplicación.
- `JoltageCalculator` procesa la entrada y calcula el resultado final.
- `JoltageStrategy` contiene la lógica necesaria para resolver ambas partes del problema.

### Open/Closed Principle (OCP)

La lógica de cálculo está separada del procesamiento principal, por lo que es sencillo modificar o añadir nuevos algoritmos sin cambiar el funcionamiento de `JoltageCalculator`.

## Tests

Se utilizan pruebas unitarias con **JUnit 5** para comprobar el funcionamiento de ambas partes del ejercicio utilizando los ejemplos proporcionados en el enunciado.