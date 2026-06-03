package com.cursosdedesarrollo.java.ejercicios.u00;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjSaludoArgTest {

    @Test
    public void saludoConNombreConcreto() {
        assertEquals("Hola, Ana!", EjSaludoArg.saludo("Ana"));
    }

    @Test
    public void saludoConMundo() {
        assertEquals("Hola, Mundo!", EjSaludoArg.saludo("Mundo"));
    }

    @Test
    public void saludoConcatenaCorrectamente() {
        // Verifica el patrón "Hola, X!" para cualquier nombre
        String resultado = EjSaludoArg.saludo("Java");
        assertTrue(resultado.startsWith("Hola, "));
        assertTrue(resultado.endsWith("!"));
        assertTrue(resultado.contains("Java"));
    }
}
