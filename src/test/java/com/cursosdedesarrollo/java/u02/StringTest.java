package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringTest {

    @Test
    public void trimEliminaEspacios() {
        assertEquals("Hola Mundo", "  Hola Mundo  ".trim());
    }

    @Test
    public void containsEncuentraSubcadena() {
        assertTrue("Hola Mundo".contains("Mundo"));
    }

    @Test
    public void replaceSubstituye() {
        assertEquals("Hola Java", "Hola Mundo".replace("Mundo", "Java"));
    }

    @Test
    public void splitDivideCorrectamente() {
        String[] partes = "a,b,c".split(",");
        assertEquals(3, partes.length);
        assertEquals("b", partes[1]);
    }

    @Test
    public void equalsCompararContenidoNoReferencia() {
        String a = new String("hola");
        String b = new String("hola");
        assertFalse(a == b);     // referencias distintas
        assertTrue(a.equals(b)); // mismo contenido
    }

    @Test
    public void stringBuilderConcatenaEficientemente() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) sb.append(i).append("-");
        assertEquals("1-2-3-", sb.toString());
    }

    @Test
    public void switchConString() {
        String dia = "LUNES";
        String tipo;
        switch (dia) {
            case "SABADO": case "DOMINGO": tipo = "Fin de semana"; break;
            default: tipo = "Laborable";
        }
        assertEquals("Laborable", tipo);
    }
}
