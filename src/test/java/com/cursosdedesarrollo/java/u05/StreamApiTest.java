package com.cursosdedesarrollo.java.u05;

import org.junit.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.Assert.*;

public class StreamApiTest {

    private final List<String> nombres = Arrays.asList("Ana", "Bob", "Carmen", "David", "Eva");

    @Test
    public void filterMapCollectFunciona() {
        List<String> resultado = nombres.stream()
            .filter(n -> n.length() > 3)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        assertTrue(resultado.contains("CARMEN"));
        assertTrue(resultado.contains("DAVID"));
        assertFalse(resultado.contains("ANA"));
    }

    @Test
    public void groupingByAgrupaCorrectamente() {
        Map<Integer, List<String>> porLongitud = nombres.stream()
            .collect(Collectors.groupingBy(String::length));
        assertTrue(porLongitud.get(3).contains("Ana"));
        assertTrue(porLongitud.get(6).contains("Carmen"));
    }

    @Test
    public void mapToIntSumaSumaLongitudes() {
        int total = nombres.stream()
            .mapToInt(String::length)
            .sum();
        assertEquals(20, total); // Ana(3)+Bob(3)+Carmen(6)+David(5)+Eva(3)
    }

    @Test
    public void countCuentaElementosFiltrados() {
        long pares = nombres.stream()
            .filter(n -> n.length() % 2 == 0)
            .count();
        assertEquals(1, pares); // solo Carmen(6)
    }
}
