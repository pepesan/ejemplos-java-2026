package com.cursosdedesarrollo.java.ejercicios.u01;

import com.cursosdedesarrollo.java.u01.ClaseLombok;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClaseLombokTest {
    @Test
    public void testClaseLombok() {
        ClaseLombok objeto = new ClaseLombok(1L, "hola", "adios");
        assertEquals((Long)1L, objeto.getId());
        assertEquals("hola", objeto.getNombre());
        assertEquals("adios", objeto.getApellido());
    }
    @Test
    public void testClaseLombokSinParametros() {
        ClaseLombok objeto = new ClaseLombok();
        assertEquals((Long)0L, objeto.getId());
        assertEquals("", objeto.getNombre());
        assertEquals("", objeto.getApellido());
    }
}

