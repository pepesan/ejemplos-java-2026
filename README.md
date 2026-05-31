# Java 8+ — Ejemplos del curso

Proyecto Maven con el código Java de todos los ejemplos del curso,
organizados por unidad y con tests JUnit asociados.

## Requisitos

- JDK 8 o superior
- Maven 3.6+

## Estructura

```
src/
├── main/java/com/cursosdedesarrollo/java/
│   ├── u00/  HolaMundo
│   ├── u01/  Modelo de objetos (Vehiculo, Persona, Animal, CuentaBancaria…)
│   ├── u02/  Tipos y colecciones (Caja, Planeta, FicherosDemo)
│   ├── u03/  Excepciones (PedidoInvalidoException, BancaServicio)
│   ├── u04/  JDBC (Cliente, ClienteRepository)
│   └── u05/  —  (ejemplos cubiertos en tests)
└── test/java/com/cursosdedesarrollo/java/
    ├── u01/  VehiculoTest, ProductoTest, PersonaTest, CuentaBancariaTest,
    │         PilaresPooTest, CalcTest, ColeccionTest
    ├── u02/  AutoboxingTest, StringTest, ArraysTest, CollectionsTest,
    │         FicherosTest, CajaTest, PlanetaTest
    ├── u03/  PedidoInvalidoExceptionTest, BancaServicioTest
    ├── u04/  ClienteRepositoryTest  (H2 in-memory)
    └── u05/  LambdasTest, StreamApiTest, OptionalTest, FechasTest
```

## Ejecutar tests

```bash
mvn test
```

Los tests de JDBC (u04) usan H2 en memoria — no requieren ningún servidor.

## Correspondencia con las diapositivas

| Unidad | Sección del curso | Clases principales |
|--------|------------------|--------------------|
| u00 | Entorno de desarrollo | `HolaMundo` |
| u01 | Clases y objetos | `Vehiculo`, `Producto`, `Persona` |
| u01 | Los cuatro pilares POO | `Animal`, `Perro`, `Gato`, `CuentaBancaria`, `Notificador` |
| u01 | Composición | `Coche`, `Motor` |
| u01 | Interfaces vs abstractas | `Pagable`, `Empleado`, `EmpleadoFijo`, `EmpleadoPorHoras` |
| u01 | Sobrecarga | `Calc` |
| u01 | Default methods | `Coleccion` |
| u02 | Sistema de tipos | `AutoboxingTest` |
| u02 | Sintaxis básica | `StringTest` |
| u02 | Arrays | `ArraysTest` |
| u02 | Collections | `CollectionsTest` |
| u02 | Ficheros | `FicherosDemo`, `FicherosTest` |
| u02 | Generics y Enums | `Caja`, `Planeta` |
| u03 | Excepciones | `BancaServicio`, `PedidoInvalidoException` |
| u04 | JDBC | `Cliente`, `ClienteRepository` |
| u05 | Lambdas y funcional | `LambdasTest`, `StreamApiTest`, `OptionalTest`, `FechasTest` |
