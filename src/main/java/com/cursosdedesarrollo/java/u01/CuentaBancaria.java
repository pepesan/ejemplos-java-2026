package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Encapsulamiento: invariante saldo >= 0
public class CuentaBancaria {
    private double saldo; // invariante: saldo >= 0

    public double getSaldo() { return saldo; }

    public void depositar(double importe) {
        if (importe > 0) saldo += importe;
    }

    public boolean retirar(double importe) {
        if (importe <= 0 || importe > saldo) return false;
        saldo -= importe;
        return true;
    }
}
