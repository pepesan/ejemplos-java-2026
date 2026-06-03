package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class EjAgrupadorTest {

    @Test
    public void agrupa_porPrimeraLetra() {
        List<String> palabras = Arrays.asList("Ana", "Bob", "Alberto", "Carlos");
        Map<Character, List<String>> grupos = EjAgrupador.porPrimeraLetra(palabras);
        assertTrue(grupos.get('A').contains("Ana"));
        assertTrue(grupos.get('A').contains("Alberto"));
        assertTrue(grupos.get('B').contains("Bob"));
    }

    @Test
    public void ordenarPorLongitudMantieneLasMasCortas() {
        List<String> entrada  = Arrays.asList("Carmen", "Ana", "Bob", "Eva");
        List<String> ordenada = EjAgrupador.ordenarPorLongitud(entrada);
        assertEquals("Ana", ordenada.get(0));
        assertEquals("Carmen", ordenada.get(3));
    }

    @Test
    public void empateEnLongitudSeOrdenaPorAlfabeto() {
        List<String> entrada  = Arrays.asList("Bob", "Ana", "Eve");
        List<String> ordenada = EjAgrupador.ordenarPorLongitud(entrada);
        assertEquals(Arrays.asList("Ana", "Bob", "Eve"), ordenada);
    }
}
