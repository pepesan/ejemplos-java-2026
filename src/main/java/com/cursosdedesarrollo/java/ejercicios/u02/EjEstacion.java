package com.cursosdedesarrollo.java.ejercicios.u02;

// Ejercicio u02-6: enum con campos y comportamiento — Estaciones del año.
// Cada constante lleva sus meses de inicio y fin; el método deMes() centraliza la lógica.
public enum EjEstacion {
    PRIMAVERA(3,  5),
    VERANO   (6,  8),
    OTONO    (9, 11),
    INVIERNO (12,  2); // Invierno cruza el cambio de año (dic → feb)

    private final int mesInicio;
    private final int mesFin;

    EjEstacion(int mesInicio, int mesFin) {
        this.mesInicio = mesInicio;
        this.mesFin    = mesFin;
    }

    public int getMesInicio() { return mesInicio; }
    public int getMesFin()    { return mesFin; }

    public boolean esFria() { return this == OTONO || this == INVIERNO; }

    // Devuelve null para mes fuera de rango (1-12) — sin excepciones en esta fase
    public static EjEstacion deMes(int mes) {
        if (mes < 1 || mes > 12) return null;
        for (EjEstacion e : values()) {
            if (e == INVIERNO) {
                if (mes == 12 || mes <= 2) return e;
            } else {
                if (mes >= e.mesInicio && mes <= e.mesFin) return e;
            }
        }
        return null;
    }
}
