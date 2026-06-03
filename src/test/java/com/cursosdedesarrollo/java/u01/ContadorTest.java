package com.cursosdedesarrollo.java.u01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContadorTest {

    // Se ejecuta antes de CADA test para dejar el estado de clase limpio.
    // Sin esto, el orden de ejecución de los tests afectaría a totalCreados.
    @Before
    public void resetar() {
        Contador.resetear();
    }

    // ── Atributo estático ────────────────────────────────────────────────────

    @Test
    public void sinObjetosTotalEsCero() {
        // Antes de crear ningún objeto el contador de clase vale 0
        assertEquals(0, Contador.getTotalCreados());
    }

    @Test
    public void cadaNuevoObjetoIncrementaElTotal() {
        new Contador("A");
        assertEquals(1, Contador.getTotalCreados());

        new Contador("B");
        assertEquals(2, Contador.getTotalCreados());

        new Contador("C");
        assertEquals(3, Contador.getTotalCreados());
    }

    @Test
    public void totalEsCompartidoPorTodasLasInstancias() {
        // Tanto c1 como c2 ven el mismo totalCreados porque es de la clase
        Contador c1 = new Contador("X");
        Contador c2 = new Contador("Y");

        assertEquals(Contador.getTotalCreados(), 2);
        // El total no depende de a través de qué objeto se acceda —
        // ambas referencias apuntan al mismo contador
    }

    // ── Atributo de instancia ────────────────────────────────────────────────

    @Test
    public void cadaObjetoTieneSuPropioId() {
        Contador c1 = new Contador("Primero");
        Contador c2 = new Contador("Segundo");

        // id es individual: el primer objeto recibe 1, el segundo 2
        assertEquals(1, c1.getId());
        assertEquals(2, c2.getId());
    }

    @Test
    public void modificarNombreNoAfectaAOtroObjeto() {
        Contador c1 = new Contador("Alpha");
        Contador c2 = new Contador("Beta");

        c1.setNombre("AlphaModificado");

        // nombre es de instancia: cambiar c1 no toca c2
        assertEquals("AlphaModificado", c1.getNombre());
        assertEquals("Beta",            c2.getNombre());
    }

    // ── Método estático ──────────────────────────────────────────────────────

    @Test
    public void metodoEstaticoNecesitaNingunObjeto() {
        // Se llama directamente sobre la clase, sin new
        int total = Contador.getTotalCreados();
        assertEquals(0, total);
    }

    // ── toString ─────────────────────────────────────────────────────────────

    @Test
    public void toStringContieneIdYNombre() {
        Contador c = new Contador("Demo");
        String s = c.toString();
        assertTrue(s.contains("1"));
        assertTrue(s.contains("Demo"));
    }
}
