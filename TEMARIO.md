# Java 8+ Fundamentales

## Duración

24 Horas.

## Objetivos

- Comprender la plataforma Java (JVM, JDK) y configurar un entorno de desarrollo profesional con Maven, Gradle y SDKMAN.
- Dominar el modelo orientado a objetos: clases, herencia, polimorfismo, encapsulamiento, interfaces y patrones de relación entre clases.
- Manejar los tipos de datos, colecciones estándar (List, Set, Map) y la gestión de ficheros y memoria de la JVM.
- Gestionar correctamente la jerarquía de excepciones y diseñar contratos de error para aplicaciones de producción.
- Implementar la capa de acceso a datos con JDBC: conexiones, PreparedStatement, ResultSet, transacciones y mapeo objeto-relacional manual.
- Escribir código moderno y declarativo con lambdas, Stream API, interfaces funcionales, Optional y la API de fechas java.time.

## Contenidos

### 0. Entorno de desarrollo

- La plataforma Java: JVM, JDK y evolución de versiones.
- Instalación del JDK en Linux y Windows con distribuciones OpenJDK.
- Gestión de múltiples versiones con SDKMAN.
- Maven y Gradle: build, dependencias y ciclo de vida del proyecto.
- IDEs disponibles para desarrollo Java.

### 1. Modelo de objetos

- Clases, objetos, atributos y métodos; los cuatro pilares de la POO.
- Herencia, encapsulamiento, polimorfismo y abstracción.
- Composición frente a herencia: asociación, agregación y composición.
- Modificadores de acceso y sistema de paquetes.
- Clases anidadas, interfaces vs clases abstractas y default methods.
- Sobrecarga y sobreescritura de métodos.

### 2. Tipos y colecciones

- Sistema de tipos: primitivos, referencias, autoboxing y conversiones.
- Sintaxis básica: getters/setters, control de flujo e iteración.
- E/S estándar (System.out, Scanner) y arrays.
- Collections Framework: List, Set y Map con sus implementaciones habituales.
- Ficheros con streams de E/S y gestión de recursos con try-with-resources.
- Generics para código reutilizable y seguro en tipos.
- Enums tipados con campos y comportamiento.

### 3. Gestión de excepciones

- Jerarquía de excepciones: Throwable, Error y Exception.
- Checked exceptions frente a unchecked (RuntimeException).
- Uso correcto de try-catch-finally y try-with-resources.
- Lanzar excepciones con `throw` y declarar contratos con `throws`.
- Diseño de excepciones personalizadas para el dominio de la aplicación.

### 4. Acceso a datos con JDBC

- Repaso del modelo relacional y sentencias SQL esenciales (CRUD).
- Arquitectura JDBC: drivers, DriverManager y Connection.
- Statement y PreparedStatement; prevención de SQL injection.
- Navegación de ResultSet y mapeo de filas a objetos Java.
- Implementación de un repositorio CRUD completo.
- Transacciones: commit, rollback, savepoints y niveles de aislamiento.
- Serialización Java y mapeo objeto-relacional manual.

### 5. Java Funcional

- Lambdas y referencias a métodos para pasar comportamiento como argumento.
- Interfaces funcionales del JDK: Predicate, Function, Consumer y Supplier.
- Procesamiento declarativo de colecciones con la Stream API.
- Optional para representar valores potencialmente ausentes sin null.
- API de fechas java.time: LocalDate, LocalDateTime y ZonedDateTime.
