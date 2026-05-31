package com.cursosdedesarrollo.java.u05;

import org.junit.Test;
import java.util.*;
import java.util.function.*;
import static org.junit.Assert.*;

public class LambdasTest {

    @Test
    public void predicadoEsParFunciona() {
        Predicate<Integer> esPar = n -> n % 2 == 0;
        assertTrue(esPar.test(4));
        assertFalse(esPar.test(3));
    }

    @Test
    public void predicadoAndCombinaDosCondiciones() {
        Predicate<Integer> esPar      = n -> n % 2 == 0;
        Predicate<Integer> esPositivo = n -> n > 0;
        Predicate<Integer> esParPos   = esPar.and(esPositivo);
        assertTrue(esParPos.test(4));
        assertFalse(esParPos.test(-4));
        assertFalse(esParPos.test(3));
    }

    @Test
    public void functionAndThenEncadena() {
        Function<String, Integer> longitud = String::length;
        Function<Integer, String> intToStr = n -> "num:" + n;
        Function<String, String>  pipeline = longitud.andThen(intToStr);
        assertEquals("num:4", pipeline.apply("hola"));
    }

    @Test
    public void supplierCreaNuevaLista() {
        Supplier<List<String>> nueva = ArrayList::new;
        List<String> l1 = nueva.get();
        List<String> l2 = nueva.get();
        assertNotSame(l1, l2);
    }

    @Test
    public void methodReferenceOrdenaPorLongitud() {
        List<String> nombres = Arrays.asList("Carmen", "Ana", "Bob");
        nombres.sort(Comparator.comparing(String::length));
        assertEquals("Ana", nombres.get(0));
        assertEquals("Carmen", nombres.get(2));
    }
}
