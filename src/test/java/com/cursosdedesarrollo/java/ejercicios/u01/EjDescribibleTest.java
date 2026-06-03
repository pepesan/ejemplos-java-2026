package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjDescribibleTest {

    // ── Implementaciones concretas ────────────────────────────────────────────

    @Test
    public void productoDevuelveDescripcionConPrecio() {
        assertEquals("Teclado (29.99€)", new EjProducto("Teclado", 29.99).getDescripcion());
    }

    @Test
    public void servicioDevuelveDescripcionConHoras() {
        assertEquals("Consultoría (3h)", new EjServicio("Consultoría", 3).getDescripcion());
    }

    // ── Polimorfismo por interfaz ─────────────────────────────────────────────

    @Test
    public void variableInterfazApuntaAProducto() {
        // EjProducto y EjServicio no tienen relación de herencia entre sí,
        // pero los dos cumplen el contrato EjDescribible.
        EjDescribible d = new EjProducto("Ratón", 15.00);
        assertEquals("Ratón (15.00€)", d.getDescripcion());
    }

    @Test
    public void variableInterfazApuntaAServicio() {
        EjDescribible d = new EjServicio("Soporte", 2);
        assertEquals("Soporte (2h)", d.getDescripcion());
    }

    // ── instanceof ───────────────────────────────────────────────────────────

    @Test
    public void productoImplementaDescribible() {
        assertTrue(new EjProducto("X", 1.0) instanceof EjDescribible);
    }

    @Test
    public void servicioImplementaDescribible() {
        assertTrue(new EjServicio("X", 1) instanceof EjDescribible);
    }
}
