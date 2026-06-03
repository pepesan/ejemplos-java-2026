# Java 8+ — Ejemplos del curso

Proyecto Maven con el código Java de todos los ejemplos del curso,
organizados por unidad y con tests JUnit asociados.

## Requisitos

- JDK 8 o superior
- Maven 3.6+

## Ejecutar tests

```bash
mvn test
```

Los tests de JDBC (u04) usan H2 en memoria — no requieren ningún servidor.

---

## u00 — Entorno de desarrollo

**Concepto:** Primer programa Java. Estructura mínima de una clase con método `main`,
compilación con `javac` y ejecución con `java`.

| Clase | Qué ilustra |
|-------|-------------|
| `HolaMundo` | Clase con `main`, salida por consola con `System.out.println` |

**Test:** `HolaMundoTest`

---

## u01 — Programación orientada a objetos

### Clases y objetos básicos

Antes de los pilares, los bloques fundamentales: cómo se define una clase, qué son
los atributos, los constructores, los métodos de acceso y el método `toString`.

| Clase | Concepto |
|-------|----------|
| `Vehiculo` | Constructores encadenados con `this(...)` — un constructor delega en otro |
| `Producto` | Getters, setters y `toString` — convención JavaBeans, validación al escribir |
| `Persona` | Atributos de instancia vs estáticos (`static`), patrón Builder (clase anidada estática) |

**Demo ejecutable:** `u01/ClasesBasicasDemo` — muestra los tres conceptos en acción con salida por consola.

**Tests:** `VehiculoTest`, `ProductoTest`, `PersonaTest`

---

### Los cuatro pilares de la POO

#### 1. Encapsulamiento — `CuentaBancaria`

El encapsulamiento consiste en **ocultar el estado interno** de un objeto y exponer
sólo las operaciones que mantienen sus invariantes.

- El campo `saldo` es `private`: nadie puede ponerlo a negativo directamente.
- Los métodos `depositar` y `retirar` validan antes de modificar.
- La invariante `saldo >= 0` queda garantizada para siempre por la clase misma.

**Test:** `CuentaBancariaTest`

---

#### 2. Herencia — `Animal` / `Perro` / `Gato`

La herencia permite que una clase **extienda** otra, reutilizando su implementación
y añadiendo o redefiniendo comportamiento.

- `Animal` define el estado (`nombre`) y el método `hacerSonido()`.
- `Perro` y `Gato` extienden `Animal` con `extends` y llaman a `super()` en el constructor.
- Anotar con `@Override` hace explícita la sobreescritura y permite que el compilador
  detecte errores de firma.

**Test:** `PilaresPooTest` — `perroEsSubtipoDeAnimal`

---

#### 3. Polimorfismo — `Animal` / `Perro` / `Gato` (dynamic dispatch)

El polimorfismo permite tratar objetos de distintos tipos concretos **de forma uniforme**
a través de un tipo común. Java resuelve qué método ejecutar en tiempo de ejecución
según el tipo real del objeto, no el tipo de la variable (*dynamic dispatch*).

- Una variable de tipo `Animal` puede contener un `Perro` o un `Gato`.
- La llamada a `hacerSonido()` siempre ejecuta la versión del tipo real.
- Esto es lo que hace posible recorrer una lista de `Animal` sin saber qué subtipos contiene.

**Test:** `PilaresPooTest` — `dinamicDispatchEjecutaMetodoDelTipoReal`

---

#### 4. Abstracción — `Notificador` / `NotificadorEmail` / `PedidoServicio`

La abstracción consiste en definir **qué hace** algo sin revelar **cómo lo hace**.
En Java se expresa principalmente mediante interfaces.

- `Notificador` es una interfaz con un único método `enviar(String)`.
  Es el *contrato*: define el "qué", no el "cómo".
- `NotificadorEmail` implementa ese contrato guardando mensajes en una lista.
- `PedidoServicio` recibe un `Notificador` por constructor: no sabe si es email,
  SMS u otro canal. Sólo trabaja con la abstracción.

Esto hace posible cambiar la implementación sin tocar `PedidoServicio` (abierto/cerrado).

**Test:** `PilaresPooTest` — `pedidoServicioUsaNotificadorPorAbstraccion`

---

### Composición vs herencia — `Coche` + `Motor`

La composición modela una relación "tiene-un" en lugar de "es-un".
Es preferible a la herencia cuando el componente no tiene sentido de forma independiente.

- `Motor` no existe sin `Coche`: es creado y controlado por él (relación de composición fuerte).
- `Coche` delega el comportamiento de arranque/parada al `Motor` sin exponer sus detalles.
- Contrasta con la herencia: `Perro` *es* un `Animal`; `Coche` *tiene* un `Motor`.

**Test:** `PilaresPooTest` — `cocheArrancarEnciendeSuMotor`

---

### Interfaces vs clases abstractas — `Pagable` / `Empleado` / `EmpleadoFijo` / `EmpleadoPorHoras`

Cuándo usar cada uno:

| | Interfaz (`Pagable`) | Clase abstracta (`Empleado`) |
|--|----------------------|------------------------------|
| Estado compartido | No | Sí (`nombre`, `salarioBase`) |
| Herencia múltiple | Sí | No |
| Uso | Contrato de capacidad | Esqueleto con lógica común |

- `Pagable` declara `calcularPago()` y añade un `default` `resumen()` (Java 8).
- `Empleado` es abstracta: tiene estado y obliga a sus subclases a implementar `calcularPago()`.
- `EmpleadoFijo` devuelve el salario base; `EmpleadoPorHoras` multiplica precio × horas.

**Test:** `PilaresPooTest` — `empleadoFijoCalculaPagoIgualASalarioBase`, `resumenDefaultMethodDevuelveTextoLegible`

---

### Sobrecarga (overloading) — `Calc`

La sobrecarga permite definir **varios métodos con el mismo nombre** pero distinta
firma (número o tipo de parámetros). Se resuelve en **tiempo de compilación** (no es
polimorfismo dinámico).

**Test:** `CalcTest`

---

### Default methods (Java 8) — `Coleccion<T>`

Los `default` methods permiten añadir **comportamiento a una interfaz** sin romper
las implementaciones existentes. Útil para evolucionar APIs de forma retrocompatible.

- `agregar(T)` es abstracto: cada implementación lo define.
- `agregarTodos(List<T>)` es `default`: lo heredan todas las implementaciones
  usando `this::agregar`.

**Test:** `ColeccionTest`

---

## u02 — Sistema de tipos, colecciones y ficheros

### Autoboxing y unboxing

Java convierte automáticamente entre tipos primitivos (`int`, `double`…) y sus
envolturas (`Integer`, `Double`…). El autoboxing ocurre al insertar primitivos en
colecciones; el unboxing al sacarlos. Hay que conocer el coste y la posibilidad de
`NullPointerException` al hacer unboxing de un `null`.

**Test:** `AutoboxingTest`

---

### String y sus métodos principales

`String` es inmutable en Java: toda "modificación" crea un nuevo objeto.
Los métodos más usados: `length`, `charAt`, `substring`, `contains`, `replace`,
`toUpperCase`, `trim`, `split`, `equals` (nunca `==` para comparar contenido).

**Test:** `StringTest`

---

### Arrays

Arrays de primitivos y de objetos, longitud fija con `new tipo[n]`,
índices desde 0, `Arrays.sort`, `Arrays.fill`, `Arrays.copyOf` y
`Arrays.toString` para imprimir. Diferencia entre array y colección.

**Test:** `ArraysTest`

---

### Collections — `List`, `Set`, `Map`

El framework de colecciones de Java:

| Tipo | Implementación habitual | Característica clave |
|------|------------------------|----------------------|
| `List` | `ArrayList` | orden de inserción, duplicados, acceso por índice |
| `Set` | `HashSet` | sin duplicados, sin orden garantizado |
| `Map` | `HashMap` | pares clave-valor, claves únicas |

Recorrer con `for-each`, añadir/eliminar, buscar con `contains`/`containsKey`.
`Collections.sort`, `Collections.unmodifiableList`.

**Test:** `CollectionsTest`

---

### Ficheros con NIO.2 — `FicherosDemo`

`java.nio.file` (NIO.2, Java 7+) es la API moderna para ficheros:

- `Path` en lugar de `File` para representar rutas.
- `Files.newBufferedWriter` / `Files.newBufferedReader` con `StandardCharsets.UTF_8`.
- `Files.readAllLines` para leer todas las líneas de golpe.
- `try-with-resources` garantiza el cierre del stream aunque se lance una excepción.

**Test:** `FicherosTest`

---

### Generics — `Caja<T>`

Los genéricos permiten escribir clases y métodos que funcionan con **cualquier tipo**
manteniendo seguridad de tipos en compilación (sin casts explícitos).

- `Caja<T>` almacena un valor de tipo `T`: `Caja<Integer>`, `Caja<String>`…
- El método estático `maximo(T a, T b)` usa un *bounded type parameter* `T extends Comparable<T>`
  para garantizar que los elementos se pueden comparar.

**Test:** `CajaTest`

---

### Enums con comportamiento — `Planeta`

Un `enum` en Java no es sólo una constante: puede tener **campos y métodos**.

- Cada constante (`MERCURIO`, `TIERRA`, `MARTE`) almacena masa y radio.
- El método `gravedad()` calcula la aceleración gravitatoria usando esos campos.
- Esto evita clases de constantes o switches dispersos por el código.

**Test:** `PlanetaTest`

---

## u03 — Excepciones

### `throw` y `throws` — `BancaServicio`

- **`throw`**: lanzar una excepción para señalar que se ha violado un contrato o invariante.
  Se usa dentro de un método cuando detecta una situación inválida.
- **`throws`**: declarar en la firma del método que puede lanzar una *checked exception*
  (como `IOException`). El llamador está obligado a manejarla o propagarla.

**Tests:** `BancaServicioTest`

---

### Excepciones personalizadas — `PedidoInvalidoException`

Cuando una excepción estándar no transmite suficiente contexto de dominio,
se crea una excepción propia extendiendo `RuntimeException` (unchecked) o `Exception` (checked).

- Extiende `RuntimeException`: el llamador no está obligado a capturarla
  (adecuado para errores de programación o violaciones de reglas de negocio).
- Incluye el campo `pedidoId` para que el receptor sepa exactamente qué pedido falló,
  sin tener que parsear el mensaje de texto.

**Test:** `PedidoInvalidoExceptionTest`

---

## u04 — JDBC

### Acceso a base de datos — `ClienteRepository` / `Cliente`

JDBC (*Java Database Connectivity*) es la API estándar para conectarse a bases de datos
relacionales desde Java.

Conceptos clave que ilustra `ClienteRepository`:

| Concepto | Qué hace |
|----------|----------|
| `DataSource` | Fuente de conexiones (pool). Se inyecta por constructor — no se crea dentro |
| `Connection` | Sesión con la base de datos. Se obtiene de `ds.getConnection()` |
| `PreparedStatement` | Consulta parametrizada con `?`. Evita SQL injection |
| `ResultSet` | Cursor sobre las filas devueltas por un `SELECT` |
| `Statement.RETURN_GENERATED_KEYS` | Recuperar la PK autogenerada tras un `INSERT` |
| Row mapper | Convertir una fila del `ResultSet` en un objeto de dominio (`Cliente`) |
| `try-with-resources` | Cierra `Connection`, `PreparedStatement` y `ResultSet` automáticamente |

El test `ClienteRepositoryTest` usa **H2 en memoria**: no requiere ningún servidor externo.

---

## u05 — Programación funcional y Java 8

### Lambdas e interfaces funcionales — `FuncionalesDemo`

Una *lambda* es una función anónima que implementa una interfaz funcional (interfaz con
un único método abstracto). Java 8 incluye las más comunes en `java.util.function`:

| Interfaz | Método | Uso |
|----------|--------|-----|
| `Predicate<T>` | `test(T)` → `boolean` | Filtrar: ¿cumple la condición? |
| `Function<T,R>` | `apply(T)` → `R` | Transformar: de tipo T a tipo R |
| `Consumer<T>` | `accept(T)` → `void` | Efecto secundario sin retorno |
| `Supplier<T>` | `get()` → `T` | Producir un valor sin argumentos |

**Test:** `LambdasTest`

---

### Stream API — `StreamDemo`

Un `Stream` es un **pipeline de operaciones** sobre una secuencia de elementos.
No modifica la colección original (inmutabilidad funcional).

- **Operaciones intermedias** (devuelven otro `Stream`): `filter`, `map`, `sorted`, `distinct`…
- **Operaciones terminales** (consumen el stream): `collect`, `count`, `sum`, `findFirst`…

`Collectors.groupingBy` agrupa elementos en un `Map<K, List<V>>`.
`mapToInt(...).sum()` opera sobre primitivos (sin boxing) para eficiencia.

**Test:** `StreamApiTest`

---

### Optional — `OptionalDemo`

`Optional<T>` es un contenedor que **puede o no contener un valor**.
Reemplaza el uso de `null` explícito como señal de "ausencia".

- `Optional.empty()` — sin valor.
- `Optional.of(v)` — con valor no nulo; lanza NPE si es nulo.
- `Optional.ofNullable(v)` — acepta null (lo convierte en `empty`).
- `.filter(predicate).map(func).orElse(default)` — encadenamiento funcional sin `if (x != null)`.

**Test:** `OptionalTest`

---

### java.time — `FechasDemo`

`java.time` (Java 8) reemplaza a `java.util.Date` y `Calendar`.
Sus clases son **inmutables** y *thread-safe* por diseño.

| Clase | Para qué |
|-------|----------|
| `LocalDate` | Sólo fecha (año, mes, día), sin hora ni zona |
| `LocalDateTime` | Fecha + hora, sin zona horaria |
| `ZonedDateTime` | Fecha + hora + zona horaria |
| `ZoneId` | Identificador de zona (`"Europe/Madrid"`, `"UTC"`) |
| `DateTimeFormatter` | Formatear/parsear con un patrón (`"dd/MM/yyyy HH:mm"`) |
| `ChronoUnit.DAYS.between` | Diferencia entre dos fechas en la unidad elegida |

`withZoneSameInstant` convierte el mismo instante a otra zona horaria
(útil para mostrar una hora UTC en la zona local del usuario).

**Test:** `FechasTest`
