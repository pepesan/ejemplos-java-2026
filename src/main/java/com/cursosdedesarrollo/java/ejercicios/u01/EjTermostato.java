package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-2: encapsulamiento — Termostato con temperatura acotada entre límites.
// La invariante "TEMP_MIN <= temperatura <= TEMP_MAX" nunca puede romperse desde fuera.
public class EjTermostato {

    public static final double TEMP_MIN = 10.0;
    public static final double TEMP_MAX = 30.0;

    private double temperatura;

    public EjTermostato(double temperaturaInicial) {
        this.temperatura = acotar(temperaturaInicial);
    }

    public void setTemperatura(double t) {
        this.temperatura = acotar(t);
    }

    public double getTemperatura() { return temperatura; }

    public void subir(double grados) { setTemperatura(temperatura + grados); }
    public void bajar(double grados) { setTemperatura(temperatura - grados); }

    // Privado: detalle de implementación, no forma parte del contrato público
    private double acotar(double t) {
        return Math.min(TEMP_MAX, Math.max(TEMP_MIN, t));
    }
}
