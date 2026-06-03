package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjBuclesTest {

    // ── sumar ────────────────────────────────────────────────────────────────

    @Test
    public void sumarDel1Al5() {
        assertEquals(15, EjBucles.sumar(1, 5));
    }

    @Test
    public void sumarUnSoloValor() {
        assertEquals(7, EjBucles.sumar(7, 7));
    }

    // ── factorial ────────────────────────────────────────────────────────────

    @Test
    public void factorialDe0Es1() {
        assertEquals(1L, EjBucles.factorial(0));
    }

    @Test
    public void factorialDe1Es1() {
        assertEquals(1L, EjBucles.factorial(1));
    }

    @Test
    public void factorialDe5Es120() {
        assertEquals(120L, EjBucles.factorial(5));
    }

    // ── contarPares ──────────────────────────────────────────────────────────

    @Test
    public void contarParesEnArrayMixto() {
        assertEquals(3, EjBucles.contarPares(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void contarParesEnArraySinPares() {
        assertEquals(0, EjBucles.contarPares(new int[]{1, 3, 5}));
    }

    @Test
    public void contarParesArrayVacio() {
        assertEquals(0, EjBucles.contarPares(new int[]{}));
    }
}
