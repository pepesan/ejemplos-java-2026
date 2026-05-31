package com.cursosdedesarrollo.java.u05;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class StreamApiTest {

    private final List<String> nombres = Arrays.asList("Ana", "Bob", "Carmen", "David", "Eva");

    @Test
    public void filterMapCollectFunciona() {
        List<String> resultado = StreamDemo.nombresMayoresQue(nombres, 3);
        assertTrue(resultado.contains("CARMEN"));
        assertTrue(resultado.contains("DAVID"));
        assertFalse(resultado.contains("ANA"));
    }

    @Test
    public void groupingByAgrupaCorrectamente() {
        Map<Integer, List<String>> porLongitud = StreamDemo.agruparPorLongitud(nombres);
        assertTrue(porLongitud.get(3).contains("Ana"));
        assertTrue(porLongitud.get(6).contains("Carmen"));
    }

    @Test
    public void mapToIntSumaSumaLongitudes() {
        int total = StreamDemo.sumaDeLongitudes(nombres);
        assertEquals(20, total); // Ana(3)+Bob(3)+Carmen(6)+David(5)+Eva(3)
    }

    @Test
    public void countCuentaElementosFiltrados() {
        long pares = StreamDemo.contarConLongitudPar(nombres);
        assertEquals(1, pares); // solo Carmen(6)
    }
}
