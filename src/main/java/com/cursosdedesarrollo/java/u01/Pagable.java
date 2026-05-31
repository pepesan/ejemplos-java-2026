package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Interfaces vs clases abstractas
public interface Pagable {
    double calcularPago(); // abstracto: cada tipo lo implementa

    default String resumen() { // default: comportamiento compartido
        return "Pago: " + calcularPago();
    }
}
