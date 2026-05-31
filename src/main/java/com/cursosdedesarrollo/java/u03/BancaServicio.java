package com.cursosdedesarrollo.java.u03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Unidad 03 — throw, throws y contratos
public class BancaServicio {

    private double saldo;

    public BancaServicio(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() { return saldo; }

    // throw: lanzar excepciones para proteger invariantes
    public void retirar(double importe) {
        if (importe <= 0)
            throw new IllegalArgumentException("Importe debe ser positivo");
        if (importe > saldo)
            throw new IllegalStateException("Saldo insuficiente");
        saldo -= importe;
    }

    // throws: declarar checked exception en la firma
    public List<String> leerMovimientos(Path ruta) throws IOException {
        return Files.readAllLines(ruta, StandardCharsets.UTF_8);
    }
}
