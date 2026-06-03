package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;

public class EjFrecuenciaPalabrasTest {

    @Test
    public void contarPalabrasUnicas() {
        Map<String, Integer> f = EjFrecuenciaPalabras.contar("hola mundo");
        assertEquals(Integer.valueOf(1), f.get("hola"));
        assertEquals(Integer.valueOf(1), f.get("mundo"));
    }

    @Test
    public void contarPalabrasRepetidas() {
        Map<String, Integer> f = EjFrecuenciaPalabras.contar("java es java");
        assertEquals(Integer.valueOf(2), f.get("java"));
        assertEquals(Integer.valueOf(1), f.get("es"));
    }

    @Test
    public void ignoraMayusculasYMinusculas() {
        Map<String, Integer> f = EjFrecuenciaPalabras.contar("Java JAVA java");
        assertEquals(Integer.valueOf(3), f.get("java"));
    }

    @Test
    public void masRepetidaDevuelveLaPalabraCorrecta() {
        Map<String, Integer> f = EjFrecuenciaPalabras.contar("a b a c a b");
        assertEquals("a", EjFrecuenciaPalabras.masRepetida(f));
    }

    @Test
    public void textoVacioDevuelveMapa() {
        assertTrue(EjFrecuenciaPalabras.contar("").isEmpty());
    }
}
