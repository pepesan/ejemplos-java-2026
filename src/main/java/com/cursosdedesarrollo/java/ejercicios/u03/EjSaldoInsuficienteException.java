package com.cursosdedesarrollo.java.ejercicios.u03;

// Ejercicio u03-1: excepción personalizada checked.
// Extiende Exception (no RuntimeException): el llamador está OBLIGADO a manejarla o propagarla.
// Lleva contexto de dominio: cuánto había y cuánto se pidió.
public class EjSaldoInsuficienteException extends Exception {

    private final double saldoActual;
    private final double importeSolicitado;

    public EjSaldoInsuficienteException(double saldoActual, double importeSolicitado) {
        super(String.format("Saldo insuficiente: disponible %.2f, solicitado %.2f",
              saldoActual, importeSolicitado));
        this.saldoActual       = saldoActual;
        this.importeSolicitado = importeSolicitado;
    }

    public double getSaldoActual()       { return saldoActual; }
    public double getImporteSolicitado() { return importeSolicitado; }
}
