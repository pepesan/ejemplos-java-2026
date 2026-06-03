# Ejercicios propuestos

Para cada ejercicio se indica el concepto que practica y lo que se debe implementar.
Las resoluciones están en el paquete `ejercicios` del proyecto (ver `EJERCICIOSRESUELTOS.md`).

---

## u00 — Entorno de desarrollo

### Ejercicio 1 — Saludo personalizado

Crea una clase con un método `saludo(String nombre)` que devuelva `"Hola, " + nombre + "!"`.
En el `main`, declara una variable `String nombre = "Mundo"` y llama al método para imprimir el resultado.
No uses `if`, ternario ni ninguna condición — solo variables, concatenación y `System.out.println`.

**Concepto:** estructura mínima de una clase Java, variable `String`, concatenación, llamada a método estático.

---

### Ejercicio 2 — Operaciones aritméticas

Crea una clase con cuatro métodos estáticos — `sumar`, `restar`, `multiplicar`, `dividir` —,
cada uno recibe dos `double` y devuelve el resultado de la operación correspondiente.
En el `main`, declara dos variables numéricas y muestra los cuatro resultados por consola.
No uses `if` ni condiciones de ningún tipo.

**Concepto:** variables `double`, métodos estáticos con parámetros y retorno, operadores aritméticos básicos.

---

## u01 — Programación orientada a objetos

### Ejercicio 1 — Rectángulo

Crea la clase `Rectangulo` con atributos `ancho` y `alto`.
Implementa `area()`, `perimetro()`, `esCuadrado()` y `toString()`.
Si se pasa una dimensión negativa, el constructor debe usar su valor absoluto (`Math.abs`).

**Concepto:** clase, atributos `private final`, constructor, `Math.abs`, métodos derivados.

---

### Ejercicio 2 — Termostato (encapsulamiento)

Crea la clase `Termostato` con una temperatura interna.

Implementa `setTemperatura`, `getTemperatura`, `subir` y `bajar`.

**Concepto:** encapsulamiento — la invariante del estado nunca puede romperse desde fuera.

---

### Ejercicio 3 — Figuras geométricas (herencia + polimorfismo)

Crea una clase abstracta `Figura` con métodos abstractos `area()` y `perimetro()`.
Implementa las subclases `Circulo` (radio) y `Triangulo` (base, altura y los tres lados).
Añade un método estático `areaTotal(Figura... figuras)` (varargs) que sume las áreas de todas las figuras
sin conocer sus tipos concretos. Usa `Math.abs` en el constructor de `Circulo` para valores negativos.
No uses `List` ni colecciones (eso se verá en u02).

**Concepto:** herencia con `extends`, `abstract`, `@Override`, polimorfismo y dynamic dispatch.

---

### Ejercicio 4 — Biblioteca (composición)

Crea las clases `Libro` (título, autor, año) y `Biblioteca` (nombre, lista de libros).
`Biblioteca` debe permitir agregar (ignorar `null` silenciosamente), eliminar por título con un bucle `for`
y buscar por título devolviendo el `Libro` encontrado o `null` si no existe.
`getLibros()` debe devolver una copia de la lista para no exponer el estado interno.
No uses lambdas ni `removeIf` (eso se verá en u05), ni `Collections.unmodifiableList` (u02).

**Concepto:** composición ("tiene-un"), bucle de búsqueda y eliminación, devolver copia de colección.

---

### Ejercicio 5 — Conversor (sobrecarga)

Crea la clase `Conversor` con tres versiones del método `convertir`:
- `convertir(double km)` → millas  (1 km = 0,621371 millas)
- `convertir(double litros, double precioPorLitro)` → coste total
- `convertir(double euros, double tasaCambio, String monedaDestino)` → importe en otra moneda

No añadas validaciones de argumentos (eso se verá en u03).

**Concepto:** sobrecarga — mismo nombre de método, distintas firmas; el compilador elige en tiempo de compilación.

---

## u02 — Sistema de tipos, colecciones y ficheros

### Ejercicio 1 — Frecuencia de palabras

Escribe el método `contar(String texto)` que devuelva un `Map<String, Integer>` con la frecuencia
de cada palabra (ignorando mayúsculas y puntuación).
Añade `masRepetida(Map)` que devuelva la palabra más frecuente.

**Concepto:** `Map`, `getOrDefault`, autoboxing al insertar/leer `Integer`.

---

### Ejercicio 2 — Validador de email

Escribe `esValido(String email)` usando solo métodos de `String` (sin regex):
`indexOf`, `substring`, `lastIndexOf`, `contains`, `length`.
Considera inválido: sin `@`, `@` al inicio o al final, sin punto en el dominio, espacio en cualquier posición.

**Concepto:** inmutabilidad de `String`, API de métodos de `String`.

---

### Ejercicio 3 — Estadísticas de un array

Implementa `maximo`, `minimo`, `media` y `ordenadoAscendente` sobre un `int[]`.
`ordenadoAscendente` debe devolver una copia sin modificar el array original.
No añadas validaciones de argumentos (eso se verá en u03).

**Concepto:** recorrido de arrays, `Arrays.copyOf`, `Arrays.sort`, cast para división real.

---

### Ejercicio 4 — Agrupador de palabras

Implementa `porPrimeraLetra(List<String>)` que devuelva un `Map<Character, List<String>>`
agrupando palabras por su primera letra (en mayúscula, orden alfabético).
Implementa `ordenarPorLongitud(List<String>)` con `Comparator`: longitud ascendente; empate por orden alfabético.

**Concepto:** `TreeMap`, `ArrayList`, `Comparator`, `Collections.sort`.

---

### Ejercicio 5 — Par genérico

Crea la clase genérica `Par<A, B>` con los dos valores y sus getters.
Añade un factory method estático `de(A, B)` para aprovechar la inferencia de tipos.

**Concepto:** parámetros de tipo `<A, B>`, factory method estático genérico, seguridad de tipos en compilación.

---

### Ejercicio 6 — Estaciones del año (enum)

Crea el enum `Estacion` con `PRIMAVERA`, `VERANO`, `OTONO`, `INVIERNO`.
Cada constante lleva su mes de inicio y fin. Implementa:
- `esFria()` → true para otoño e invierno
- `deMes(int mes)` → devuelve la estación del mes dado; devuelve `null` para mes fuera de rango (1-12)

Nota: invierno cruza el cambio de año (diciembre → febrero).

**Concepto:** enum con campos y métodos, lógica encapsulada en la constante.

---

## u03 — Excepciones

### Ejercicio 1 — Excepción personalizada checked

Crea `SaldoInsuficienteException` que extienda `Exception` (checked).
Debe almacenar el saldo actual y el importe solicitado, e incluirlos en el mensaje.

**Concepto:** excepción checked vs unchecked, campos de contexto de dominio, `super(mensaje)`.

---

### Ejercicio 2 — Caja fuerte

Crea `CajaFuerte` con saldo inicial y un método `retirar(double)` que declare `throws SaldoInsuficienteException`.
Requisitos:
- Importe negativo → `IllegalArgumentException` (unchecked, no se declara)
- Saldo insuficiente → `SaldoInsuficienteException` (checked, se declara)
- Tras 3 intentos fallidos consecutivos la caja se bloquea
- Un retiro exitoso reinicia el contador de intentos

**Concepto:** throw vs throws, checked vs unchecked, lógica de estado con excepciones.

---

## u04 — JDBC

### Ejercicio 1 — Repositorio de productos

Crea `Producto` (id, nombre, precio, stock) y `ProductoRepository` con:
- `save(Producto)` → devuelve la PK generada
- `findById(long)` → `Optional<Producto>`
- `findAll()` → `List<Producto>`
- `updatePrecio(long id, double nuevoPrecio)`
- `deleteById(long id)`

El repositorio recibe un `DataSource` por constructor. Usa `PreparedStatement` y `try-with-resources`.

**Concepto:** JDBC completo (Connection, PreparedStatement, ResultSet, claves generadas), row mapper, inyección de DataSource.

---

## u05 — Programación funcional y Java 8

### Ejercicio 1 — Procesador de pedidos (Stream API)

Crea `Pedido` (cliente, categoría, importe) y la clase `ProcesadorPedidos` con:
- `filtrarPorImporteMinimo(List, double)` — filter + collect
- `agruparPorCategoria(List)` — groupingBy
- `importeTotal(List)` — mapToDouble + sum
- `topNPorImporte(List, int)` — sorted (desc) + limit
- `clientesUnicos(List)` — map + distinct + sorted

**Concepto:** pipeline de Stream, operaciones intermedias y terminales, referencias a métodos.

---

### Ejercicio 2 — Buscador de usuarios (Optional)

Crea `Usuario` (nombre, email, edad) y `BuscadorUsuario` con:
- `buscarPorNombre(List, String)` → `Optional<Usuario>` (insensible a mayúsculas)
- `emailSiMayorDeEdad(Optional<Usuario>, int edadMinima)` → email o valor por defecto usando `filter + map + orElse`
- `obtenerOFallar(List, String)` → `Usuario` o lanza excepción con `orElseThrow`

**Concepto:** Optional como tipo de retorno, encadenamiento funcional sin null explícito.

---

### Ejercicio 3 — Agenda de citas (java.time)

Crea `Cita` (título, `ZonedDateTime` inicio, `ZonedDateTime` fin) con:
- Constructor que valide que `fin` es posterior a `inicio`
- `duracionMinutos()` usando `ChronoUnit.MINUTES.between`
- `enZona(ZoneId)` que devuelva una nueva cita en otra zona (inmutabilidad)

Añade en `AgendaCitas`:
- `citasDelDia(List, LocalDate, ZoneId)` — filtra y ordena
- `diasHastaProximaCita(List, ZonedDateTime ahora)` — mapToLong + min

**Concepto:** inmutabilidad de `java.time`, `ZonedDateTime`, `ChronoUnit`, `withZoneSameInstant`.
