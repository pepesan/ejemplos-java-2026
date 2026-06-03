package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-7: atributos y métodos estáticos
// Todos los miembros son static: la clase gestiona un único aparcamiento compartido.
// No se crean instancias — toda la interacción es a través del nombre de la clase.
public class EjParking {

    public static final int CAPACIDAD = 5;

    private static int plazasOcupadas = 0;

    // ── Consultas ────────────────────────────────────────────────────────────

    public static int getPlazasLibres() {
        return CAPACIDAD - plazasOcupadas;
    }

    public static boolean hayPlazas() {
        return plazasOcupadas < CAPACIDAD;
    }

    // ── Modificación ─────────────────────────────────────────────────────────

    // Establece directamente cuántas plazas quedan libres
    public static void setPlazasLibres(int libres) {
        plazasOcupadas = CAPACIDAD - libres;
    }

    public static void resetear() {
        plazasOcupadas = 0;
    }
}
