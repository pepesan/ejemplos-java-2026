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

Atributos `private final` — se asignan una sola vez en el constructor. En lugar de lanzar excepción para dimensiones negativas (concepto de u03), el constructor usa `Math.abs` para convertirlas en positivas. `esCuadrado()` usa `Double.compare` para comparar doubles con precisión.

---

### Ejercicio 2 — Termostato (encapsulamiento)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjTermostato.java` |
| Test     | `ejercicios/u01/EjTermostatoTest.java` |

El método privado `acotar(double)` centraliza la lógica de límites. Todos los puntos de entrada (`setTemperatura`, `subir`, `bajar`) lo invocan, lo que garantiza que la invariante `TEMP_MIN ≤ temperatura ≤ TEMP_MAX` nunca se rompe.

---

### Ejercicio 3 — Figuras geométricas (herencia + polimorfismo)
| | Fichero |
|--|---------|
| Solución | `ejercicios/u01/EjFiguraGeometrica.java` |
| Test     | `ejercicios/u01/EjFiguraGeometricaTest.java` |

`Figura` es abstracta con `area()` y `perimetro()` abstractos. `Circulo` usa `Math.abs` para radio negativo. `areaTotal(Figura... figuras)` usa varargs — característica del lenguaje que no requiere importar nada — para recibir cualquier número de figuras y demostrar el dynamic dispatch sin necesitar `List` (que se ve en u02).

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

## u02 — Sistema de tipos, colecciones y ficheros

### Ejercicio 1 — Frecuencia de palabras
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjFrecuenciaPalabras.java` |
| Test     | `ejercicios/u02/EjFrecuenciaPalabrasTest.java` |

`getOrDefault(palabra, 0) + 1` aprovecha el autoboxing: el `0` se autoboxea a `Integer` al pasar al mapa, y se desboxea al sumar. `LinkedHashMap` preserva el orden de inserción.

---

### Ejercicio 2 — Validador de email
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjValidadorEmail.java` |
| Test     | `ejercicios/u02/EjValidadorEmailTest.java` |

Cada regla de validación usa un método distinto de `String`: `indexOf`, `lastIndexOf`, `substring`, `contains`, `length`. Cada `return false` temprano evita chequeos innecesarios (cláusulas de guarda).

---

### Ejercicio 3 — Estadísticas de array
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjEstadisticasArray.java` |
| Test     | `ejercicios/u02/EjEstadisticasArrayTest.java` |

`Arrays.copyOf` crea una copia antes de ordenar, preservando el array original. El cast `(double) suma / arr.length` es necesario porque la división entera truncaría el resultado.

---

### Ejercicio 4 — Agrupador de palabras
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjAgrupador.java` |
| Test     | `ejercicios/u02/EjAgrupadorTest.java` |

`TreeMap` mantiene las claves en orden natural (alfabético) sin esfuerzo adicional. El `Comparator` anónimo en `ordenarPorLongitud` encadena dos criterios: longitud primero, alfabético como desempate.

---

### Ejercicio 5 — Par genérico
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjParGenerico.java` |
| Test     | `ejercicios/u02/EjParGenericoTest.java` |

El factory method `de(A, B)` es estático y genérico — el compilador infiere `A` y `B` de los argumentos, evitando repetir los tipos en `new EjParGenerico<String, Integer>(...)`. Los atributos son `final` porque un par no debería mutar.

---

### Ejercicio 6 — Estaciones del año
| | Fichero |
|--|---------|
| Solución | `ejercicios/u02/EjEstacion.java` |
| Test     | `ejercicios/u02/EjEstacionTest.java` |

El enum lleva la lógica consigo: cada constante sabe sus meses y si es fría. `deMes(int)` recorre `values()` con un caso especial para `INVIERNO` porque su rango cruza el año (diciembre → febrero). Para mes fuera de rango devuelve `null` en lugar de lanzar excepción — ese mecanismo se introduce en u03.

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
