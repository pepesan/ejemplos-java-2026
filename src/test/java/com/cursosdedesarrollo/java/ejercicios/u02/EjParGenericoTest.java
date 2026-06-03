package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjParGenericoTest {

    @Test
    public void gettersDevuelvenLosValores() {
        EjParGenerico<String, Integer> par = new EjParGenerico<>("edad", 30);
        assertEquals("edad", par.getPrimero());
        assertEquals(Integer.valueOf(30), par.getSegundo());
    }

    @Test
    public void factoryMethodInfiereTipos() {
        EjParGenerico<String, Boolean> par = EjParGenerico.de("activo", true);
        assertEquals("activo", par.getPrimero());
        assertTrue(par.getSegundo());
    }

    @Test
    public void toStringFormatoCorrecto() {
        assertEquals("(a, 1)", EjParGenerico.de("a", 1).toString());
    }

    @Test
    public void tiposDistintos_StringYDouble() {
        EjParGenerico<String, Double> par = EjParGenerico.de("precio", 9.99);
        assertEquals(9.99, par.getSegundo(), 0.001);
    }
}
