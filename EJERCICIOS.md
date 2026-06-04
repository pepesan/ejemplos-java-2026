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
Implementa Constructores, getters y setters y `toString()`.

Si puedes implementa las pruebas con Junit sino haz una clase Main.

**Concepto:** clase, atributos, constructor, getters, setters y toString.

---

### Ejercicio 2 — Termostato (encapsulamiento)

Crea la clase `Termostato` con una temperatura interna que **siempre** debe estar entre `10.0 °C` y `30.0 °C`.
Define esos límites como constantes de clase (`public static final double TEMP_MIN` y `TEMP_MAX`).
Implementa `setTemperatura`, `getTemperatura`, `subir(double grados)` y `bajar(double grados)`.

**Concepto:** encapsulamiento — la invariante del estado nunca puede romperse desde fuera; constantes de clase `static final`.

---

### Ejercicio 3 — Figuras geométricas (herencia + polimorfismo)

Crea la clase `Figura` con un atributo `nombre` (`String`) y dos métodos `area()` y `perimetro()`
que devuelvan `0.0` como valor por defecto.

Implementa las subclases `Circulo` (radio) y `Triangulo` (base, altura y los tres lados),
cada una usando `extends Figura` y sobreescribiendo `area()` y `perimetro()` con `@Override`.
Usa `Math.abs` en el constructor de `Circulo` para valores negativos.


**Concepto:** herencia con `extends`, `@Override`, polimorfismo y dynamic dispatch —
la JVM decide en tiempo de ejecución qué versión de `area()` ejecutar según el tipo real del objeto,
aunque la variable sea de tipo `Figura`.

---

### Ejercicio 4 — Igualdad por valor (equals y hashCode)

Crea la clase `Coordenada` con `latitud` y `longitud` (`double`).
Implementa constructores, getters, setters y `toString`.
Sobreescribe `equals` para que dos coordenadas sean iguales si tienen la misma latitud y longitud,
y sobreescribe `hashCode` de forma coherente.

Verifica en el test que `equals` es reflexivo, simétrico y transitivo,
que devuelve `false` al comparar con `null` y con un objeto de distinto tipo,
y que objetos iguales producen el mismo `hashCode`.

No uses `==` para comparar `double` — usa `Double.compare(a, b) == 0`.

**Concepto:** igualdad por valor, contrato `equals`/`hashCode`, uso en `HashMap` y `HashSet`.

---

### Ejercicio 5 — Atributos y métodos estáticos: aparcamiento

Crea la clase `Parking` que gestiona las plazas de un aparcamiento con capacidad fija.

- Define la constante `public static final int CAPACIDAD = 5`.
- Define el atributo estático `static int plazasOcupadas` (inicialmente 0).
- Método estático `getPlazasLibres()` → devuelve `CAPACIDAD - plazasOcupadas`.
- Método estático `setPlazasLibres(int libres)` → establece el valor de plazas libres. 
- Método estático `hayPlazas()` → devuelve `true` si quedan plazas libres.
- Añade `resetear()` estático para aislar los tests entre sí.


Verifica con JUnit que:
- Sin vehículos hay `CAPACIDAD` plazas libres y `hayPlazas()` devuelve `true`.
- usar Método estático `setPlazasLibres(int libres)` para colocar 4
- `hayPlazas()` devuelve `true`
- getPlazasLibres() devería devolver 4

**Concepto:** atributo `static` como recurso compartido por todas las instancias;
constante `static final`; métodos estáticos que consultan estado de clase sin necesitar objeto;
métodos de instancia que modifican ese estado compartido.

---

### Ejercicio 6— Conversor (sobrecarga)

Crea la clase `Conversor` con tres versiones del método `convertir`:
- `convertir(double km)` → millas  (1 km = 0,621371 millas)
- `convertir(double litros, double precioPorLitro)` → coste total
- `convertir(double euros, double tasaCambio, String monedaDestino)` → importe en otra moneda

No añadas validaciones de argumentos (eso se verá en u03).

**Concepto:** sobrecarga — mismo nombre de método, distintas firmas; el compilador elige en tiempo de compilación.

---

### Ejercicio 7 — Animal (clase abstracta)

Crea la clase **abstracta** `EjAnimal` con un atributo `nombre` (`String`),
su getter y un método abstracto `hacerSonido()` que devuelva un `String`.

Implementa las subclases `EjPerro` y `EjGato` con `extends EjAnimal`,
cada una sobrescribiendo `hacerSonido()` con `@Override`:
- `EjPerro.hacerSonido()` → `"Guau"`
- `EjGato.hacerSonido()` → `"Miau"`

Verifica en el test que una variable de tipo `EjAnimal` puede apuntar a un `EjPerro`
y que al llamar a `hacerSonido()` se ejecuta la versión de `EjPerro` — y que no es posible
crear un `new EjAnimal(...)` directamente (el compilador lo rechaza).

**Concepto:** clase abstracta — no se puede instanciar directamente;
obliga a las subclases a implementar los métodos abstractos;
sigue soportando polimorfismo y dynamic dispatch igual que la herencia normal.

---

### Ejercicio 9 — Vehículo (clase abstracta sencilla)

Crea la clase **abstracta** `Vehiculo` con un atributo `marca` (`String`),
su getter y un método abstracto `moverme()` que devuelva un `String`.

Implementa las subclases `Coche` y `Bicicleta` con `extends Vehiculo`,
cada una sobrescribiendo `moverme()` con `@Override`:
- `Coche.moverme()` → `"Con motor"`
- `Bicicleta.moverme()` → `"Con pedales"`

Verifica en el test que una variable de tipo `Vehiculo` puede apuntar a un `Coche`
y que al llamar a `moverme()` se ejecuta la versión de `Coche`.

**Concepto:** clase abstracta en su forma más mínima — un atributo heredado,
un único método abstracto y dos subclases concretas.
La diferencia con la herencia normal (Ejercicio 3) es que el compilador
**no permite** que una subclase olvide implementar `moverme()`.

---

### Ejercicio 10 — Describible (interfaz)

Crea la interfaz `EjDescribible` con un único método `getDescripcion()` que devuelva un `String`.

Implementa dos clases **sin ninguna relación de herencia entre sí** que implementen la interfaz con `implements`:
- `EjProducto` (nombre y precio `double`): descripción `"nombre (X.XXX€)"`
- `EjServicio` (nombre y duracionHoras `int`): descripción `"nombre (Xh)"`

Verifica en el test que una variable de tipo `EjDescribible` puede apuntar
tanto a un `EjProducto` como a un `EjServicio`, y que `getDescripcion()` funciona en ambos casos.

**Concepto:** interfaz como contrato — define qué debe hacer una clase, no cómo;
permite que clases sin ninguna relación compartan el mismo tipo;
polimorfismo por interfaz: la variable es `EjDescribible`, el objeto real puede ser cualquiera.

---

## u02 — Tipos, estructuras de control, cadenas y colecciones

### Ejercicio 1 — Variables y tipos básicos

Crea la clase `EjTipos` con estos métodos estáticos:
- `duplicar(int n)` → devuelve `n * 2`
- `mitad(double d)` → devuelve `d / 2`
- `esPar(int n)` → devuelve `true` si n es par

**Concepto:** tipos primitivos `int`, `double`, `boolean`, `char`; tipo por referencia `String`; `String.valueOf`.

---

### Ejercicio 2 — Condicionales

Crea la clase `EjCondicionales` con estos métodos estáticos:
- `maximo(int a, int b)` → devuelve el mayor de los dos
- `clasificarNota(int nota)` → `"Suspenso"` (<5), `"Aprobado"` (5-6), `"Notable"` (7-8), `"Sobresaliente"` (9-10)
- `signo(int n)` → `"positivo"`, `"negativo"` o `"cero"`

**Concepto:** `if / else if / else`, condiciones compuestas, cláusulas de guarda.

---

### Ejercicio 3 — Bucles

Crea la clase `EjBucles` con estos métodos estáticos:
- `sumar(int desde, int hasta)` → suma todos los enteros del rango (ambos inclusive), con `for`
- `factorial(int n)` → calcula n! con `while` (sin usar `Math`)

**Concepto:** `for`, `while`.

---

### Ejercicio 4 — Cadenas de caracteres

Crea la clase `EjCadenas` con estos métodos estáticos:
- `mayusculas(String s)` → convierte a mayúsculas
- `contarCaracter(String s, char c)` → cuántas veces aparece `c` en `s`
- `invertir(String s)` → devuelve la cadena al revés (con bucle, sin `StringBuilder`)
- `contiene(String frase, String palabra)` → `true` si `frase` contiene `palabra` ignorando mayúsculas

**Concepto:** `String.length`, `charAt`, `toUpperCase`, `toLowerCase`, `contains`; inmutabilidad de `String`.

---

### Ejercicio 5 — List

Crea la clase `EjLista` con estos métodos estáticos:
- `primerosN(List<String>, int n)` → devuelve los primeros `n` elementos (o todos si hay menos)
- `filtrarPositivos(List<Integer>)` → devuelve solo los números mayores que cero (sin streams)
- `unir(List<String>, String separador)` → une todos los elementos con el separador dado

**Concepto:** `ArrayList`, `List<T>`, `add`, `get`, `size`; recorrer una lista con `for`.

---

### Ejercicio 6 — Map

Crea la clase `EjMapa` con estos métodos estáticos:
- `contarOcurrencias(String[] palabras)` → `Map<String, Integer>` con la frecuencia de cada palabra
- `obtenerODefecto(Map<String, Integer>, String clave, int defecto)` → valor o defecto si no existe
- `existeClave(Map<String, String>, String clave)` → `true` si la clave está en el mapa

**Concepto:** `HashMap`, `put`, `get`, `getOrDefault`, `containsKey`.

---

### Ejercicio 7 — Set

Crea la clase `EjConjunto` con estos métodos estáticos:
- `sinDuplicados(List<String>)` → devuelve una nueva lista sin repetidos, preservando el orden de primera aparición
- `tieneDuplicados(List<String>)` → `true` si la lista tiene algún elemento repetido
- `comunes(List<Integer>, List<Integer>)` → `Set<Integer>` con los elementos presentes en las dos listas

**Concepto:** `HashSet`, `add` devuelve `false` si ya existía, `contains`; Set como estructura sin duplicados.

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
