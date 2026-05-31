package com.cursosdedesarrollo.java.u05;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class LambdasTest {

    @Test
    public void filtrarConPredicadoLambda() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> pares = FuncionalesDemo.filtrar(numeros, n -> n % 2 == 0);
        assertEquals(Arrays.asList(2, 4, 6), pares);
    }

    @Test
    public void filtrarCombinandoPredicadosConAnd() {
        List<Integer> numeros = Arrays.asList(-4, -2, 1, 3, 4, 6);
        List<Integer> paresPositivos = FuncionalesDemo.filtrar(numeros,
            ((java.util.function.Predicate<Integer>) (n -> n % 2 == 0)).and(n -> n > 0));
        assertEquals(Arrays.asList(4, 6), paresPositivos);
    }

    @Test
    public void transformarConFunctionEncadenada() {
        List<String> nombres = Arrays.asList("ana", "bob");
        List<String> mayus = FuncionalesDemo.transformar(nombres, String::toUpperCase);
        assertEquals(Arrays.asList("ANA", "BOB"), mayus);
    }

    @Test
    public void transformarConAndThen() {
        // andThen encadena dos Function: longitud y luego prefijo
        java.util.function.Function<String, Integer> longitud = String::length;
        java.util.function.Function<Integer, String> prefijo  = n -> "num:" + n;
        List<String> resultado = FuncionalesDemo.transformar(
            Arrays.asList("hola"), longitud.andThen(prefijo));
        assertEquals(Collections.singletonList("num:4"), resultado);
    }

    @Test
    public void crearConSupplierDevuelveInstanciaDistintaCadaVez() {
        List<String> l1 = FuncionalesDemo.crear(ArrayList::new);
        List<String> l2 = FuncionalesDemo.crear(ArrayList::new);
        assertNotSame(l1, l2);
    }

    @Test
    public void procesarConConsumerEjecutaEfectoSecundario() {
        List<String> registrados = new ArrayList<>();
        FuncionalesDemo.procesar(Arrays.asList("a", "b", "c"), registrados::add);
        assertEquals(Arrays.asList("a", "b", "c"), registrados);
    }

    @Test
    public void methodReferenceOrdenaPorLongitud() {
        List<String> nombres = new ArrayList<>(Arrays.asList("Carmen", "Ana", "Bob"));
        nombres.sort(Comparator.comparing(String::length));
        assertEquals("Ana", nombres.get(0));
        assertEquals("Carmen", nombres.get(2));
    }
}
