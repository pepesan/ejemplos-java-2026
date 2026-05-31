package com.cursosdedesarrollo.java.u02;

// Unidad 02 — Generics: clase genérica con bound
public class Caja<T> {
    private T valor;

    public Caja(T valor) { this.valor = valor; }
    public T getValor()  { return valor; }

    public static <T extends Comparable<T>> T maximo(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
}
