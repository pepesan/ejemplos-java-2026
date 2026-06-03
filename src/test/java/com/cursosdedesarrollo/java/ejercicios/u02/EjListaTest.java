package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class EjListaTest {

    // ── primerosN ────────────────────────────────────────────────────────────

    @Test
    public void primerosNDevuelveLosNPrimeros() {
        List<String> entrada = Arrays.asList("a", "b", "c", "d");
        assertEquals(Arrays.asList("a", "b"), EjLista.primerosN(entrada, 2));
    }

    @Test
    public void primerosNConNMayorQueTamano() {
        List<String> entrada = Arrays.asList("x", "y");
        assertEquals(Arrays.asList("x", "y"), EjLista.primerosN(entrada, 10));
    }

    // ── filtrarPositivos ─────────────────────────────────────────────────────

    @Test
    public void filtrarPositivosEliminaNegativos() {
        List<Integer> entrada = Arrays.asList(-1, 2, -3, 4, 0);
        assertEquals(Arrays.asList(2, 4), EjLista.filtrarPositivos(entrada));
    }

    @Test
    public void filtrarPositivosListaVacia() {
        assertEquals(Collections.emptyList(), EjLista.filtrarPositivos(Collections.emptyList()));
    }

    // ── unir ─────────────────────────────────────────────────────────────────

    @Test
    public void unirConComa() {
        List<String> entrada = Arrays.asList("uno", "dos", "tres");
        assertEquals("uno, dos, tres", EjLista.unir(entrada, ", "));
    }

    @Test
    public void unirConUnSoloElemento() {
        assertEquals("solo", EjLista.unir(Arrays.asList("solo"), "-"));
    }
}
