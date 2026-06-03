package com.cursosdedesarrollo.java.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class PuntoTest {

    // ── Constructor y getters ────────────────────────────────────────────────

    @Test
    public void constructorAsignaCoordenas() {
        Punto p = new Punto(3.0, 4.0);
        assertEquals(3.0, p.getX(), 0.0);
        assertEquals(4.0, p.getY(), 0.0);
    }

    // ── Setters ──────────────────────────────────────────────────────────────

    @Test
    public void settersActualizanCoordenadas() {
        Punto p = new Punto(0.0, 0.0);
        p.setX(7.5);
        p.setY(-2.0);
        assertEquals(7.5, p.getX(), 0.0);
        assertEquals(-2.0, p.getY(), 0.0);
    }

    // ── toString ─────────────────────────────────────────────────────────────

    @Test
    public void toStringContieneXeY() {
        String s = new Punto(1.0, 2.0).toString();
        assertTrue(s.contains("1.0"));
        assertTrue(s.contains("2.0"));
    }

    // ── equals: casos del contrato ───────────────────────────────────────────

    @Test
    public void equalsReflexivo() {
        Punto p = new Punto(1.0, 2.0);
        assertEquals(p, p);
    }

    @Test
    public void equalsSimetrico() {
        Punto a = new Punto(1.0, 2.0);
        Punto b = new Punto(1.0, 2.0);
        assertEquals(a, b);
        assertEquals(b, a);
    }

    @Test
    public void equalsTransitivo() {
        Punto a = new Punto(1.0, 2.0);
        Punto b = new Punto(1.0, 2.0);
        Punto c = new Punto(1.0, 2.0);
        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c);
    }

    @Test
    public void equalsConNullDevuelveFalse() {
        assertNotEquals(new Punto(1.0, 2.0), null);
    }

    @Test
    public void equalsConTipoDistintoDevuelveFalse() {
        assertNotEquals(new Punto(1.0, 2.0), "1.0,2.0");
    }

    @Test
    public void equalsCoordenadasDistintasDevuelveFalse() {
        assertNotEquals(new Punto(1.0, 2.0), new Punto(1.0, 9.0));
    }

    // ── hashCode: objetos iguales → mismo hash ───────────────────────────────

    @Test
    public void hashCodeIgualParaObjetosIguales() {
        Punto a = new Punto(1.0, 2.0);
        Punto b = new Punto(1.0, 2.0);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void hashCodeDistintoParaObjetosDiferentes() {
        // No está garantizado, pero sería una colisión muy mala para (1,2) y (2,1)
        assertNotEquals(new Punto(1.0, 2.0).hashCode(), new Punto(2.0, 1.0).hashCode());
    }
}
