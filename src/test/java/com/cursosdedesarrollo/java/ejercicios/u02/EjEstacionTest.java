package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjEstacionTest {

    @Test public void marzoEsPrimavera()  { assertEquals(EjEstacion.PRIMAVERA, EjEstacion.deMes(3)); }
    @Test public void julioEsVerano()     { assertEquals(EjEstacion.VERANO,    EjEstacion.deMes(7)); }
    @Test public void octubreEsOtono()   { assertEquals(EjEstacion.OTONO,     EjEstacion.deMes(10)); }
    @Test public void diciembreEsInvierno(){ assertEquals(EjEstacion.INVIERNO, EjEstacion.deMes(12)); }
    @Test public void eneroEsInvierno()   { assertEquals(EjEstacion.INVIERNO, EjEstacion.deMes(1)); }

    @Test
    public void estacionesFrias() {
        assertTrue(EjEstacion.INVIERNO.esFria());
        assertTrue(EjEstacion.OTONO.esFria());
        assertFalse(EjEstacion.VERANO.esFria());
        assertFalse(EjEstacion.PRIMAVERA.esFria());
    }

    @Test
    public void mesInvalidoDevuelveNull() {
        assertNull(EjEstacion.deMes(13));
        assertNull(EjEstacion.deMes(0));
    }
}
