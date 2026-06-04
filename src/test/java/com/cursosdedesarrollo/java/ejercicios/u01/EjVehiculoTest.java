package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjVehiculoTest {

    // ── moverme() ────────────────────────────────────────────────────────────

    @Test
    public void cocheSeConMotor() {
        assertEquals("Con motor", new EjCoche("Toyota").moverme());
    }

    @Test
    public void bicicletaConPedales() {
        assertEquals("Con pedales", new EjBicicleta("BH").moverme());
    }

    // ── Atributo heredado ────────────────────────────────────────────────────

    @Test
    public void getMarcaDevuelveLaMarcaDelCoche() {
        assertEquals("Toyota", new EjCoche("Toyota").getMarca());
    }

    @Test
    public void getMarcaDevuelveLaMarcaDeLaBicicleta() {
        assertEquals("BH", new EjBicicleta("BH").getMarca());
    }

    // ── Dynamic dispatch ─────────────────────────────────────────────────────

    @Test
    public void variableAbstractaEjecutaMetodoDelSubtipo() {
        // La variable es de tipo EjVehiculo, pero el objeto es un EjCoche.
        // Java ejecuta EjCoche.moverme() — eso es el dynamic dispatch.
        EjVehiculo v = new EjCoche("Toyota");
        assertEquals("Con motor", v.moverme());
    }

    // ── Herencia ─────────────────────────────────────────────────────────────

    @Test
    public void cocheEsSubtipoDeVehiculo() {
        assertTrue(new EjCoche("Toyota") instanceof EjVehiculo);
    }

    @Test
    public void bicicletaEsSubtipoDeVehiculo() {
        assertTrue(new EjBicicleta("BH") instanceof EjVehiculo);
    }
}
