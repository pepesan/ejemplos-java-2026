package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjCoordenadaTest {

    @Test
    public void constructorYGetters() {
        EjCoordenada c = new EjCoordenada(40.4168, -3.7038);
        assertEquals(40.4168, c.getLatitud(),  0.0);
        assertEquals(-3.7038, c.getLongitud(), 0.0);
    }

    @Test
    public void settersActualizanValores() {
        EjCoordenada c = new EjCoordenada(0.0, 0.0);
        c.setLatitud(48.8566);
        c.setLongitud(2.3522);
        assertEquals(48.8566, c.getLatitud(),  0.0);
        assertEquals(2.3522,  c.getLongitud(), 0.0);
    }

    @Test
    public void toStringContieneLatYLon() {
        String s = new EjCoordenada(40.4168, -3.7038).toString();
        assertTrue(s.contains("40.4168"));
        assertTrue(s.contains("-3.7038"));
    }

    // ── Contrato equals ──────────────────────────────────────────────────────

    @Test
    public void equalsReflexivo() {
        EjCoordenada c = new EjCoordenada(40.0, -3.0);
        assertEquals(c, c);
    }

    @Test
    public void equalsSimetrico() {
        EjCoordenada a = new EjCoordenada(40.0, -3.0);
        EjCoordenada b = new EjCoordenada(40.0, -3.0);
        assertEquals(a, b);
        assertEquals(b, a);
    }

    @Test
    public void equalsTransitivo() {
        EjCoordenada a = new EjCoordenada(40.0, -3.0);
        EjCoordenada b = new EjCoordenada(40.0, -3.0);
        EjCoordenada c = new EjCoordenada(40.0, -3.0);
        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c);
    }

    @Test
    public void equalsConNullDevuelveFalse() {
        assertNotEquals(new EjCoordenada(40.0, -3.0), null);
    }

    @Test
    public void equalsConTipoDistintoDevuelveFalse() {
        assertNotEquals(new EjCoordenada(40.0, -3.0), "40.0,-3.0");
    }

    @Test
    public void equalsCoordenadasDistintasDevuelveFalse() {
        assertNotEquals(new EjCoordenada(40.0, -3.0), new EjCoordenada(40.0, 0.0));
    }

    // ── hashCode ─────────────────────────────────────────────────────────────

    @Test
    public void hashCodeIgualParaObjetosIguales() {
        EjCoordenada a = new EjCoordenada(40.0, -3.0);
        EjCoordenada b = new EjCoordenada(40.0, -3.0);
        assertEquals(a.hashCode(), b.hashCode());
    }
}
