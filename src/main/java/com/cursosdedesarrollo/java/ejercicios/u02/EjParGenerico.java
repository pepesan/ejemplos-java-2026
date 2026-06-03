package com.cursosdedesarrollo.java.ejercicios.u02;

// Ejercicio u02-5: generics — clase Par<A, B> para almacenar dos valores de tipos distintos.
// El factory method estático "de" aprovecha la inferencia de tipos del compilador.
public class EjParGenerico<A, B> {

    private final A primero;
    private final B segundo;

    public EjParGenerico(A primero, B segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public A getPrimero() { return primero; }
    public B getSegundo() { return segundo; }

    // Permite escribir EjParGenerico.de("nombre", 30) en lugar de new EjParGenerico<>(...)
    public static <A, B> EjParGenerico<A, B> de(A a, B b) {
        return new EjParGenerico<>(a, b);
    }

    @Override
    public String toString() { return "(" + primero + ", " + segundo + ")"; }
}
