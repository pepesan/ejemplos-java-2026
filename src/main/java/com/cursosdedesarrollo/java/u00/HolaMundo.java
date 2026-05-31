package com.cursosdedesarrollo.java.u00;

// Unidad 00 — Entorno de desarrollo
// Estructura mínima de un programa Java.
// Compilar: javac HolaMundo.java  →  HolaMundo.class (bytecode)
// Ejecutar: java  com.cursosdedesarrollo.java.u00.HolaMundo
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Hola, Java!");
    }

    public static String saludo() {
        return "Hola, Java!";
    }
}
