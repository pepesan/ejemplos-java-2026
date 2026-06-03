package com.cursosdedesarrollo.java.u00;

// Unidad 00 — Entorno de desarrollo
// Estructura mínima de un programa Java.
// Compilar: javac HolaMundo.java  →  HolaMundo.class (bytecode) (mira en el directorio del HolaMundo)
// Ejecutar: java -classpath /ruta/ejemplos-java-2026/target/classes com.cursosdedesarrollo.java.u00.HolaMundo
public class HolaMundo {
    public static void main(String[] args) {
        String cadena = "Hola, Java!"; // inicio y reserva de memoria

        System.out.println(cadena);
        // llamada mét0do estático
        System.out.println(saludo());
    }
    // Cuando termina la aplicación borra el objeto de memoria
    // Java tiene un mecanismo automático de liberación de memoria
    // Cuando un objeto sale de ámbito se libera
    // Pero no lo hae inmediatamente
    // Sino que es proceso paralelo a la ejecución de la aplicación llamado Garbage Collector

    public static String saludo() {
        return "Hola, Java!";
    }
}
