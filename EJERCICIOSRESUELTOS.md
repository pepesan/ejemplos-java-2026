# Ejercicios resueltos

Cada solución está en `src/main/java/com/cursosdedesarrollo/java/ejercicios/<unidad>/`
y su test en `src/test/java/com/cursosdedesarrollo/java/ejercicios/<unidad>/`.

Ejecutar todos los tests de ejercicios:
```bash
mvn test -Dtest="com.cursosdedesarrollo.java.ejercicios.**"
```

---

## u00 — Entorno de desarrollo

### Ejercicio 1 — Saludo personalizado
| | Fichero |
|--|---------|
| Solución | `ejercicios/u00/EjSaludoArg.java` |
| Test     | `ejercicios/u00/EjSaludoArgTest.java` |

El método `saludo(String)` solo concatena: `"Hola, " + nombre + "!"` — sin ningún `if` ni ternario. El `main` declara una variable con el nombre y llama al método. Sin condiciones y sin leer de `args[]` porque ni `if` ni `String.equals` se han explicado todavía.

---

### Ejercicio 2 — Calculadora básica
| | Fichero |
|--|---------|
| Solución | `ejercicios/u00/EjCalculadoraMain.java` |
| Test     | `ejercicios/u00/EjCalculadoraMainTest.java` |

Cuatro métodos estáticos — `sumar`, `restar`, `multiplicar`, `dividir` —, cada uno hace exactamente una operación aritmética sin ninguna condición. El `main` declara dos variables numéricas y llama a los cuatro métodos. No hay `if`, no hay `String.equals`, no hay `args[]`: todo eso se introduce en u01.

---

## u01 — Programación orientada a objetos

### Ejercicio 1 — Rectángulo
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjRectangulo.java` |
| Test     | `ejercicios/u01/EjRectanguloTest.java` |

Atributos `private Long` — tipo envoltorio en lugar del primitivo `long`, lo que permite usar `null` como valor ausente y pasar instancias donde se espera `Object`. Los atributos no son `final` para que los setters puedan modificarlos. El constructor asigna directamente sin validación — las reglas de negocio (dimensiones positivas, etc.) se añadirían en u03 con excepciones. El test usa `assertEquals((Object) 3L, ...)` para forzar la sobrecarga `assertEquals(Object, Object)` de JUnit y evitar la ambigüedad con `assertEquals(long, long)` al comparar objetos `Long`.

---

### Ejercicio 2 — Termostato (encapsulamiento)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjTermostato.java` |
| Test     | `ejercicios/u01/EjTermostatoTest.java` |

`TEMP_MIN = 10.0` y `TEMP_MAX = 30.0` son constantes `public static final`: `static` porque pertenecen a la clase (no a cada instancia) y `final` porque su valor nunca cambia. Los tests las usan directamente (`EjTermostato.TEMP_MIN`) en lugar de repetir el literal `10.0`, de forma que si el límite cambia solo hay que tocar un sitio. El método privado `acotar(double)` centraliza la lógica: todos los puntos de entrada (`setTemperatura`, `subir`, `bajar`) lo invocan para garantizar que la temperatura nunca sale del rango.

---

### Ejercicio 3 — Figuras geométricas (herencia + polimorfismo)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjFigura.java`, `ejercicios/u01/EjCirculo.java`, `ejercicios/u01/EjTriangulo.java` |
| Test     | `ejercicios/u01/EjFiguraGeometricaTest.java` |

Cada clase vive en su propio fichero — sin clases anidadas. `EjFigura` es concreta (no abstracta): `area()` y `perimetro()` devuelven `0.0` por defecto; `EjCirculo` y `EjTriangulo` los sobreescriben con `@Override`. El test `dynamicDispatch_variableFiguraEjecutaMetodoDelTipoReal` es el más importante: una variable de tipo `EjFigura` apunta a un `EjCirculo` y la llamada a `area()` ejecuta la versión de `EjCirculo` — eso es el dynamic dispatch. `areaTotal(EjFigura... figuras)` vive en `EjFigura` como método estático y usa varargs para recibir cualquier número de figuras sin necesitar `List` (que se ve en u02).

---

### Ejercicio 4 — Biblioteca (composición)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjBiblioteca.java` |
| Test     | `ejercicios/u01/EjBibliotecaTest.java` |

`Libro` es una clase anidada estática dentro de `EjBiblioteca` para indicar que es un componente de ella. `agregar` ignora `null` con un `if` simple. `eliminar` usa un bucle `for` con índice explícito — `removeIf(lambda)` se verá en u05. `buscarPorTitulo` devuelve `null` si no encuentra el libro — `Optional` se verá en u05. `getLibros()` devuelve `new ArrayList<>(libros)`, una copia independiente, en lugar de `Collections.unmodifiableList` que pertenece a u02.

---

### Ejercicio 5 — Conversor (sobrecarga)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjConversor.java` |
| Test     | `ejercicios/u01/EjConversorTest.java` |

Las tres versiones de `convertir` tienen firmas distintas (1, 2 y 3 parámetros). El compilador resuelve cuál usar en tiempo de compilación según los argumentos de la llamada — no hay ambigüedad ni decisión en tiempo de ejecución.

---

### Ejercicio 6 — Igualdad por valor (equals y hashCode)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjCoordenada.java` |
| Test     | `ejercicios/u01/EjCoordenadaTest.java` |

`equals` comprueba primero identidad de referencia (`this == obj` → `true` de inmediato) y después descarta `null` y tipos distintos con `getClass()`. Solo entonces compara los campos con `Double.compare` en lugar de `==` para evitar errores de precisión de coma flotante. `hashCode` usa `Objects.hash(latitud, longitud)`: delega en la JDK la combinación de hashes, garantizando que dos objetos iguales produzcan siempre el mismo valor. El test verifica explícitamente cada cláusula del contrato: reflexividad, simetría, transitividad, comparación con `null` y con tipo distinto. El ejemplo de referencia con el que comparar la solución es `u01/Punto.java`.

---

### Ejercicio 8 — Animal (clase abstracta)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjAnimal.java`, `ejercicios/u01/EjPerro.java`, `ejercicios/u01/EjGato.java` |
| Test     | `ejercicios/u01/EjAnimalTest.java` |

`EjAnimal` no puede instanciarse directamente — `new EjAnimal(...)` da error de compilación. Las subclases **deben** implementar `hacerSonido()` o el compilador las marcará también como abstractas. El test `variableAbstractaEjecutaMetodoDelSubtipo` es el más importante: una variable de tipo `EjAnimal` apunta a un `EjPerro` y `hacerSonido()` devuelve `"Guau"` — el mismo dynamic dispatch que con `EjFigura`, pero esta vez la clase base ni siquiera puede devolver un valor por defecto porque el método es abstracto.

---

### Ejercicio 10 — Vehículo (clase abstracta sencilla)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjVehiculo.java`, `ejercicios/u01/EjCoche.java`, `ejercicios/u01/EjBicicleta.java` |
| Test     | `ejercicios/u01/EjVehiculoTest.java` |

`EjVehiculo` es la versión mínima de una clase abstracta: un único atributo (`marca`), un getter heredado y un solo método abstracto (`moverme()`). Las subclases `EjCoche` y `EjBicicleta` solo tienen constructor y `@Override moverme()` — nada más. La diferencia con `EjFigura` (Ejercicio 3) es que aquí el compilador **no puede** proporcionar un valor por defecto: si una subclase no implementa `moverme()`, el compilador la marca también como abstracta y la impide instanciar. El test `variableAbstractaEjecutaMetodoDelSubtipo` repite el mismo concepto de dynamic dispatch que en ejercicios anteriores, aplicado ahora a una clase abstracta.

---

### Ejercicio 11 — Describible (interfaz)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjDescribible.java`, `ejercicios/u01/EjProducto.java`, `ejercicios/u01/EjServicio.java` |
| Test     | `ejercicios/u01/EjDescribibleTest.java` |

`EjProducto` y `EjServicio` no tienen ninguna relación de herencia entre sí, pero las dos cumplen el contrato `EjDescribible`. Una variable de tipo `EjDescribible` puede apuntar a cualquiera de las dos — polimorfismo por interfaz. A diferencia de la clase abstracta, la interfaz no aporta estado ni implementación: solo define el contrato. Esto es la distinción clave entre `extends` (herencia, "es un tipo de") e `implements` (contrato, "sabe hacer").

---

### Ejercicio 7 — Atributos y métodos estáticos: aparcamiento
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjParking.java` |
| Test     | `ejercicios/u01/EjParkingTest.java` |

`CAPACIDAD` es `public static final`: constante de clase accesible sin objeto y usada directamente en los tests (`EjParking.CAPACIDAD`) para evitar "números mágicos". `plazasOcupadas` es `private static`: un único valor compartido — todos ven el mismo estado del aparcamiento. `setPlazasLibres(int)` traduce "plazas libres" a "plazas ocupadas" (`plazasOcupadas = CAPACIDAD - libres`) porque el atributo interno registra las ocupadas, no las libres; el test interactúa con el concepto de "libres" sin conocer ese detalle. La clase no tiene instancias ni constructor — toda la lógica es estática. El test usa `@Before` con `resetear()` para que cada prueba parta de cero: sin ese reset el estado estático se acumula entre tests y los resultados dependerían del orden de ejecución. El ejemplo de referencia es `u01/Contador.java`.

---

## u02 — Tipos, estructuras de control, cadenas y colecciones

### Ejercicio 1 — Variables y tipos básicos
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjTipos.java` |
| Test     | `ejercicios/u02/EjTiposTest.java` |

Cada método devuelve un tipo distinto: `int`, `double`, `boolean`, `char` y `String`. `esPar` usa el operador módulo (`% 2 == 0`). `primeraLetra` introduce `charAt(0)` como la forma más directa de obtener un carácter concreto. `String.valueOf(n)` es la conversión canónica de primitivo a `String`, preferible a concatenar con `""`.

---

### Ejercicio 2 — Condicionales
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjCondicionales.java` |
| Test     | `ejercicios/u02/EjCondicionalesTest.java` |

`maximo` usa un `if` simple con `return` inmediato — sin `else` innecesario. `clasificarNota` encadena `else if` en orden ascendente: cuando se llega a cada rama ya se sabe que la condición anterior no se cumplió, por lo que no hay que repetir el límite inferior. `signo` demuestra que `else` sin condición cubre el único caso restante.

---

### Ejercicio 3 — Bucles
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjBucles.java` |
| Test     | `ejercicios/u02/EjBuclesTest.java` |

`sumar` usa `for` clásico con índice — el acumulador `total` empieza en 0 y suma cada valor del rango. `factorial` usa `while` con la variable `i` que decrece: muestra que `for` y `while` son intercambiables, pero `while` es más natural cuando la condición de salida no es un contador simple. `contarPares` usa `for-each` que es la forma idiomática de recorrer un array cuando no se necesita el índice.

---

### Ejercicio 4 — Cadenas de caracteres
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjCadenas.java` |
| Test     | `ejercicios/u02/EjCadenasTest.java` |

`contarCaracter` recorre la cadena con `charAt(i)` en un `for` clásico porque necesita el índice. `invertir` acumula con `+=` sobre un `String` vacío para que quede claro qué ocurre, aunque en código de producción se usaría `StringBuilder` (se verá más adelante). `contiene` convierte ambos operandos a minúsculas antes de llamar a `contains` — la forma más legible de ignorar mayúsculas sin regex.

---

### Ejercicio 5 — List
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjLista.java` |
| Test     | `ejercicios/u02/EjListaTest.java` |

`primerosN` usa `for` con índice y comprueba dos condiciones en el `&&` para no salirse del tamaño real de la lista. `filtrarPositivos` recorre con `for-each` y añade solo los que pasan la condición — el patrón clásico "crear lista resultado + bucle + add condicional". `unir` gestiona el separador comprobando si `i > 0` para no añadirlo antes del primer elemento.

---

### Ejercicio 6 — Map
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjMapa.java` |
| Test     | `ejercicios/u02/EjMapaTest.java` |

`contarOcurrencias` usa `getOrDefault(palabra, 0) + 1` — el patrón estándar para contar sin comprobar si la clave existe previamente. `obtenerODefecto` y `existeClave` son envoltorios mínimos de `getOrDefault` y `containsKey`, aquí usados para practicar esa API de forma directa.

---

### Ejercicio 7 — Set
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjConjunto.java` |
| Test     | `ejercicios/u02/EjConjuntoTest.java` |

`sinDuplicados` usa un `HashSet<String> vistos` como guardia: `vistos.add(elemento)` devuelve `false` si el elemento ya estaba, por lo que en una sola instrucción se comprueba y registra. `tieneDuplicados` hace lo mismo pero sale en cuanto encuentra el primer duplicado. `comunes` convierte la primera lista en un `HashSet` para que las búsquedas sean O(1) en lugar de O(n).

---

## u03 — Excepciones

### Ejercicio 1 — Excepción personalizada checked
| | Fichero |
|--|---------|
| Solución | `ejercicios/u03/EjSaldoInsuficienteException.java` |
| Test     | `ejercicios/u03/EjSaldoInsuficienteExceptionTest.java` |

Extiende `Exception` (checked): el compilador obliga al llamador a declarar `throws` o envolver en `try/catch`. Almacena `saldoActual` e `importeSolicitado` para que el receptor pueda reaccionar sin parsear el mensaje de texto.

---

### Ejercicio 2 — Caja fuerte
| | Fichero |
|--|---------|
| Solución | `ejercicios/u03/EjCajaFuerte.java` |
| Test     | `ejercicios/u03/EjCajaFuerteTest.java` |

`retirar` usa dos tipos de excepción:
- `IllegalArgumentException` (unchecked): importe inválido — error de programación, no se declara.
- `EjSaldoInsuficienteException` (checked): escenario de negocio — se declara en `throws`, el llamador decide qué hacer.

El contador de intentos solo se incrementa en el bloque de excepción y se reinicia tras un éxito.

---

## u04 — JDBC

### Ejercicio 1 — Repositorio de productos
| | Fichero |
|--|---------|
| Solución | `ejercicios/u04/EjProducto.java`, `ejercicios/u04/EjProductoRepository.java` |
| Test     | `ejercicios/u04/EjProductoRepositoryTest.java` (H2 en memoria) |

Sigue el mismo patrón que `ClienteRepository`: `DataSource` inyectado, `PreparedStatement` con `?` para evitar SQL injection, `try-with-resources` en cada método y un row mapper privado que convierte `ResultSet` → `EjProducto`. El test crea y destruye la tabla en `@Before` para garantizar aislamiento.

---

## u05 — Programación funcional y Java 8

### Ejercicio 1 — Procesador de pedidos
| | Fichero |
|--|---------|
| Solución | `ejercicios/u05/EjProcesadorPedidos.java` |
| Test     | `ejercicios/u05/EjProcesadorPedidosTest.java` |

Cada método es un pipeline de Stream independiente para que se vea claramente la operación que demuestra. `mapToDouble(...).sum()` evita el boxing de Double que haría `map(...).reduce(0.0, Double::sum)`.

---

### Ejercicio 2 — Buscador de usuarios
| | Fichero |
|--|---------|
| Solución | `ejercicios/u05/EjBuscadorUsuario.java` |
| Test     | `ejercicios/u05/EjBuscadorUsuarioTest.java` |

`buscarPorNombre` devuelve `Optional` en lugar de `null` — el llamador sabe en tiempo de compilación que el resultado puede estar ausente. `emailSiMayorDeEdad` encadena `filter + map + orElse` sin ningún `if (x != null)`.

---

### Ejercicio 3 — Agenda de citas
| | Fichero |
|--|---------|
| Solución | `ejercicios/u05/EjAgendaCitas.java` |
| Test     | `ejercicios/u05/EjAgendaCitasTest.java` |

`ZonedDateTime` es inmutable: `enZona` devuelve una nueva instancia, no modifica la original. `withZoneSameInstant` traslada el mismo instante absoluto a otra zona — el test verifica que los dos `Instant` son iguales aunque las horas locales difieran.
