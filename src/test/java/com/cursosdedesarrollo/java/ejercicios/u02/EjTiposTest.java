package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjTiposTest {

    @Test
    public void duplicarEntero() {
        assertEquals(10, EjTipos.duplicar(5));
    }

    @Test
    public void duplicarCero() {
        assertEquals(0, EjTipos.duplicar(0));
    }

    @Test
    public void mitadDecimal() {
        assertEquals(2.5, EjTipos.mitad(5.0), 0.001);
    }

    @Test
    public void esParConNumeroParDevuelveTrue() {
        assertTrue(EjTipos.esPar(4));
    }

    @Test
    public void esParConNumeroImparDevuelveFalse() {
        assertFalse(EjTipos.esPar(7));
    }

}
