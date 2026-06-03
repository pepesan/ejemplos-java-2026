package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;

public class EjConjuntoTest {

    // ── sinDuplicados ────────────────────────────────────────────────────────

    @Test
    public void sinDuplicadosEliminaRepetidos() {
        List<String> entrada = Arrays.asList("a", "b", "a", "c", "b");
        assertEquals(Arrays.asList("a", "b", "c"), EjConjunto.sinDuplicados(entrada));
    }

    @Test
    public void sinDuplicadosSinRepetidosNoAlteraNada() {
        List<String> entrada = Arrays.asList("x", "y", "z");
        assertEquals(Arrays.asList("x", "y", "z"), EjConjunto.sinDuplicados(entrada));
    }

    // ── tieneDuplicados ──────────────────────────────────────────────────────

    @Test
    public void tieneDuplicadosConRepetidosDevuelveTrue() {
        assertTrue(EjConjunto.tieneDuplicados(Arrays.asList("a", "b", "a")));
    }

    @Test
    public void tieneDuplicadosSinRepetidosDevuelveFalse() {
        assertFalse(EjConjunto.tieneDuplicados(Arrays.asList("a", "b", "c")));
    }

    // ── comunes ──────────────────────────────────────────────────────────────

    @Test
    public void comunesDevuelveElementosEnAmbas() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        List<Integer> b = Arrays.asList(3, 4, 5, 6);
        Set<Integer> esperado = new HashSet<>(Arrays.asList(3, 4));
        assertEquals(esperado, EjConjunto.comunes(a, b));
    }

    @Test
    public void comunesSinElementosEnComunDevuelveVacio() {
        List<Integer> a = Arrays.asList(1, 2);
        List<Integer> b = Arrays.asList(3, 4);
        assertTrue(EjConjunto.comunes(a, b).isEmpty());
    }
}
