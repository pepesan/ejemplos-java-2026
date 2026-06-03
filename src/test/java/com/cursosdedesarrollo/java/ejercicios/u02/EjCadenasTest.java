package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjCadenasTest {

    // ── mayusculas ───────────────────────────────────────────────────────────

    @Test
    public void mayusculasConvierteTexto() {
        assertEquals("HOLA MUNDO", EjCadenas.mayusculas("hola mundo"));
    }

    // ── contarCaracter ───────────────────────────────────────────────────────

    @Test
    public void contarCaracterEncontradoVariasVeces() {
        assertEquals(3, EjCadenas.contarCaracter("banana", 'a'));
    }

    @Test
    public void contarCaracterNoEncontrado() {
        assertEquals(0, EjCadenas.contarCaracter("hola", 'z'));
    }

    // ── invertir ─────────────────────────────────────────────────────────────

    @Test
    public void invertirCadena() {
        assertEquals("aloh", EjCadenas.invertir("hola"));
    }

    @Test
    public void invertirUnSoloCaracter() {
        assertEquals("a", EjCadenas.invertir("a"));
    }

    // ── contiene ─────────────────────────────────────────────────────────────

    @Test
    public void contieneIgnorandoMayusculas() {
        assertTrue(EjCadenas.contiene("Hola Mundo", "mundo"));
    }

    @Test
    public void contieneDevuelveFalseSiNoEsta() {
        assertFalse(EjCadenas.contiene("Hola Mundo", "adios"));
    }
}
