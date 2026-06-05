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
| `Punto` | `equals` y `hashCode` — contrato de igualdad por valor (reflexivo, simétrico, transitivo) |
| `Contador` | Atributos y métodos `static` — la diferencia entre estado de clase y estado de instancia |
| `Persona` | Atributos de instancia vs estáticos (`static`), patrón Builder (clase anidada estática) |

**Demo ejecutable:** `u01/ClasesBasicasDemo` — muestra los tres conceptos en acción con salida por consola.

**Tests:** `VehiculoTest`, `ProductoTest`, `PuntoTest`, `ContadorTest`, `PersonaTest`

---

#### `equals` y `hashCode` — `Punto`

Por defecto `equals` compara referencias (si dos variables apuntan al mismo objeto).
Sobreescribiéndolo se define **igualdad por valor**: dos objetos son iguales si sus campos relevantes coinciden.

- `equals` debe cumplir: reflexivo, simétrico, transitivo y consistente con `null`.
- `hashCode` **debe** sobreescribirse siempre que se sobreescriba `equals`: Java exige que objetos iguales produzcan el mismo hash (necesario para `HashMap`, `HashSet`…).
- `Double.compare(a, b) == 0` en lugar de `a == b` para evitar errores de precisión de coma flotante.

**Test:** `PuntoTest`

---

#### Atributos y métodos estáticos — `Contador`

Un miembro `static` pertenece a **la clase**, no a cada instancia:

- `totalCreados` es un atributo `static`: existe uno solo, compartido por todos los objetos `Contador`.
- `getTotalCreados()` es un método `static`: se llama con `Contador.getTotalCreados()`, sin necesidad de ningún objeto.
- `id` y `nombre` son atributos de instancia: cada `new Contador(...)` tiene su propia copia.

El test usa `@Before` para resetear el estado de clase entre pruebas — consecuencia directa de que `static` persiste durante toda la JVM.

**Test:** `ContadorTest`

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

### NullPointerException — `NullPointerExceptionTest`

`NullPointerException` (NPE) se lanza automáticamente cuando se intenta usar
una referencia que vale `null` (llamar a un método, acceder a un campo, etc.).
Es una excepción **unchecked** — el compilador no la detecta.

- Invocar cualquier método sobre `null` la dispara.
- La defensa más sencilla: comprobar `!= null` antes de usar la referencia.
- En Java moderno se prefiere `Optional` o diseño que evite nulls por contrato.

**Test:** `NullPointerExceptionTest`

---

## u04 — JDBC

### Entorno MySQL con Docker

Antes de ejecutar los tests de MySQL es necesario levantar los contenedores:

```bash
cd docker
./01-up.sh                        # levanta MySQL 8.4 y phpMyAdmin
./02-ps.sh                        # muestra el estado de los contenedores
./03-logs.sh                      # logs en tiempo real (Ctrl+C para salir)
./04-down.sh                      # para y elimina contenedores y volumen
./05-bash.sh                      # abre una shell bash dentro del contenedor
./06-exec-sql.sh script.sql       # ejecuta un fichero SQL (base: cursodb)
./06-exec-sql.sh script.sql otradb# ejecuta un fichero SQL en otra base de datos
./07-mysql.sh                     # cliente mysql interactivo en cursodb
./07-mysql.sh otradb              # cliente mysql interactivo en otra base de datos
```

| Servicio    | URL / puerto            | Credenciales       |
|-------------|-------------------------|--------------------|
| MySQL       | `localhost:3306`        | root / root        |
| phpMyAdmin  | http://localhost:8080   | root / root        |
| Base de datos | `cursodb`             | —                  |

El fichero `docker/init.sql` se ejecuta automáticamente al arrancar el contenedor
y crea las tablas `pedidos`, `alumnos`, `clientes` y `productos` con datos de ejemplo.

#### Ejemplo — ejecutar un script SQL y ver el resultado

El fichero `docker/consulta-alumnos.sql` lista todos los alumnos ordenados por curso y apellido:

```bash
./docker/06-exec-sql.sh docker/consulta-alumnos.sql
```

Salida esperada:

```
+----+--------+------------------+-----------------+-------------+
| id | nombre | apellidos        | email           | curso       |
+----+--------+------------------+-----------------+-------------+
|  1 | María  | García López     | maria@curso.com | Java 2026   |
|  2 | Carlos | Martínez Ruiz    | carlos@curso.com| Java 2026   |
|  3 | Lucía  | Fernández Pérez  | lucia@curso.com | Python 2026 |
+----+--------+------------------+-----------------+-------------+
```

> El cliente `mysql` muestra la tabla con bordes cuando se ejecuta en modo interactivo
> (`07-mysql.sh`). Con `06-exec-sql.sh` la salida es texto separado por tabuladores,
> suficiente para scripts y redirecciones.

---

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

### Acceso a MySQL — `PedidoRepository` / `Pedido`

Ejemplo completamente diferente al anterior: conecta contra **MySQL real** (no H2)
y añade operaciones que `ClienteRepository` no tiene.

| Concepto | Qué demuestra |
|----------|---------------|
| `MysqlDataSource` | Configurar un `DataSource` para MySQL Connector/J |
| `Pedido.Estado` (enum) | Mapear una columna `ENUM` de MySQL a un enum Java |
| `findByEstado` | `SELECT ... WHERE estado = ?` — filtrado por valor de enum |
| `updateEstado` | `UPDATE` — modificar un campo sin reemplazar la fila entera |
| `@Ignore` en los tests | Marcar tests de integración para que no corran en CI sin la BBDD |

**Requisito:** contenedor MySQL levantado (`docker/01-up.sh`)

**Test:** `PedidoRepositoryMysqlTest` — deshabilitado con `@Ignore` por defecto

Para ejecutarlo manualmente:
```bash
./docker/01-up.sh
mvn test -Dtest=PedidoRepositoryMysqlTest
```

---

### Ejercicio — `EjAlumnoRepository` / `EjAlumno`

Practica los mismos patrones JDBC pero sobre la tabla `alumnos` de MySQL.

**Enunciado:**
1. Levanta el entorno con `docker/01-up.sh`.
2. Comprueba en phpMyAdmin (`http://localhost:8080`) que existe la tabla `alumnos`.
3. Estudia `EjAlumnoRepository` y compara su estructura con `PedidoRepository`.
4. Quita el `@Ignore` de `EjAlumnoRepositoryTest` y ejecuta los tests:
   ```bash
   mvn test -Dtest=EjAlumnoRepositoryTest
   ```
5. Haz que todos los tests pasen en verde.

La tabla `alumnos` tiene: `id`, `nombre`, `apellidos`, `email` (único), `curso`.
El repositorio incluye `findByCurso` y `updateCurso` como variantes de los métodos de filtrado y actualización.

**Test:** `EjAlumnoRepositoryTest` — deshabilitado con `@Ignore` por defecto

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
