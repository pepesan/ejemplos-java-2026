package com.cursosdedesarrollo.java.u00;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class HolaMundoTest {

    // Verifica que el método saludo() devuelve el texto esperado
    @Test
    public void saludoDevuelveTextoEsperado() {
        assertEquals("Hola, Java!", HolaMundo.saludo());
    }

    // Verifica que main() imprime algo por consola (prueba de integración mínima)
    @Test
    public void mainImprimePorConsola() {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            HolaMundo.main(new String[]{});
        } finally {
            System.setOut(original);
        }
        String salida = buffer.toString();
        assertTrue(salida.contains("Hola, Java!"));
    }
}
