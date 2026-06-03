package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-7: atributos y métodos estáticos
// CAPACIDAD y plazasOcupadas pertenecen a la clase (un solo valor compartido).
// matricula pertenece a cada vehículo (un valor distinto por instancia).
public class EjParking {

    public static final int CAPACIDAD = 5;

    private static int plazasOcupadas = 0;

    private final String matricula;

    public EjParking(String matricula) {
        this.matricula = matricula;
    }

    // ── Métodos estáticos — no necesitan objeto ──────────────────────────────

    public static int getPlazasLibres() {
        return CAPACIDAD - plazasOcupadas;
    }

    public static boolean hayPlazas() {
        return plazasOcupadas < CAPACIDAD;
    }

    public static void resetear() {
        plazasOcupadas = 0;
    }

    // ── Métodos de instancia — modifican el estado compartido ────────────────

    public boolean entrar() {
        if (!hayPlazas()) {
            return false;
        }
        plazasOcupadas++;
        return true;
    }

    public void salir() {
        if (plazasOcupadas > 0) {
            plazasOcupadas--;
        }
    }

    public String getMatricula() {
        return matricula;
    }
}
