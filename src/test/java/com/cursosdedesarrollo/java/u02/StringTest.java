package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringTest {

    @Test
    public void testToString() {
        String cadena = "Valor";
        assertEquals("Valor", cadena);
        assertEquals(5, cadena.length());
        assertEquals('V', cadena.charAt(0));
    }

    // ── Recorrido de cadena ──────────────────────────────────────────────────

    @Test
    public void recorrerCadenaConFor() {
        // for clásico: necesitamos el índice para acceder a cada carácter con charAt.
        String texto = "Hola";
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            resultado.append(texto.charAt(i));
        }
        assertEquals("Hola", resultado.toString());
    }

    @Test
    public void recorrerCadenaConForEach() {
        // for-each sobre toCharArray(): más legible cuando no necesitamos el índice.
        String texto = "Hola";
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            resultado.append(c);
        }
        assertEquals("Hola", resultado.toString());
    }

    // ── Comparación ──────────────────────────────────────────────────────────

    @Test
    public void equalsCompararContenidoNoReferencia() {
        String a = new String("hola");
        String b = new String("hola");
        assertFalse(a == b);      // referencias distintas
        assertTrue(a.equals(b));  // mismo contenido
    }

    @Test
    public void equalsIgnoreCaseIgnoraMayusculas() {
        assertTrue("Hola".equalsIgnoreCase("HOLA"));
    }

    // ── Búsqueda ─────────────────────────────────────────────────────────────

    @Test
    public void containsEncuentraSubcadena() {
        assertTrue("Hola Mundo".contains("Mundo"));
    }

    @Test
    public void startsWithYEndsWith() {
        String url = "https://ejemplo.com";
        assertTrue(url.startsWith("https"));
        assertTrue(url.endsWith(".com"));
    }

    @Test
    public void indexOfDevuelvePosicion() {
        assertEquals(5, "Hola Mundo".indexOf("Mundo")); // empieza en posición 5
        assertEquals(-1, "Hola Mundo".indexOf("Java")); // -1 si no existe
    }

    // ── Transformación ───────────────────────────────────────────────────────

    @Test
    public void toUpperCaseYToLowerCase() {
        assertEquals("HOLA", "hola".toUpperCase());
        assertEquals("hola", "HOLA".toLowerCase());
    }

    @Test
    public void trimEliminaEspacios() {
        assertEquals("Hola Mundo", "  Hola Mundo  ".trim());
    }

    @Test
    public void replaceSubstituye() {
        assertEquals("Hola Java", "Hola Mundo".replace("Mundo", "Java"));
    }

    @Test
    public void substringExtraeFragmento() {
        String texto = "Hola Mundo";
        assertEquals("Mundo", texto.substring(5));       // desde posición 5 hasta el final
        assertEquals("Hola",  texto.substring(0, 4));    // desde 0 hasta 4 (excluido)
    }

    // ── División y unión ─────────────────────────────────────────────────────

    @Test
    public void splitDivideCorrectamente() {
        String[] partes = "a,b,c".split(",");
        assertEquals(3, partes.length);
        assertEquals("b", partes[1]);
    }

    @Test
    public void joinUneConSeparador() {
        assertEquals("a-b-c", String.join("-", "a", "b", "c"));
    }

    // ── Comprobaciones de vacío ──────────────────────────────────────────────

    @Test
    public void isEmptyYIsBlank() {
        assertTrue("".isEmpty());
        assertFalse("  ".isEmpty());
        assertFalse("hola".isEmpty());

        assertTrue("   ".isBlank());   // isBlank considera espacios como vacío
        assertTrue("".isBlank());
        assertFalse("hola".isBlank());
    }

    // ── Formato y construcción ───────────────────────────────────────────────

    @Test
    public void formatComponeMensaje() {
        String msg = String.format("Hola %s, tienes %d años", "Ana", 30);
        assertEquals("Hola Ana, tienes 30 años", msg);
    }

    @Test
    public void stringBuilderConcatenaEficientemente() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) sb.append(i).append("-");
        assertEquals("1-2-3-", sb.toString());
    }
}
