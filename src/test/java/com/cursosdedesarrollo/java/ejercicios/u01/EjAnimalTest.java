package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjAnimalTest {

    // ── Sonidos ──────────────────────────────────────────────────────────────

    @Test
    public void perroHaceGuau() {
        assertEquals("Guau", new EjPerro("Rex").hacerSonido());
    }

    @Test
    public void gatoHaceMiau() {
        assertEquals("Miau", new EjGato("Luna").hacerSonido());
    }

    // ── Atributo heredado ────────────────────────────────────────────────────

    @Test
    public void getNombreDevuelveElNombreDelPerro() {
        assertEquals("Rex", new EjPerro("Rex").getNombre());
    }

    @Test
    public void getNombreDevuelveElNombreDelGato() {
        assertEquals("Luna", new EjGato("Luna").getNombre());
    }

    // ── Dynamic dispatch ─────────────────────────────────────────────────────

    @Test
    public void variableAbstractaEjecutaMetodoDelSubtipo() {
        // La variable es de tipo EjAnimal, pero el objeto es un EjPerro.
        // Java ejecuta EjPerro.hacerSonido(), no puede usar un valor por defecto
        // porque el método es abstracto — obliga a que cada subclase lo defina.
        EjAnimal a = new EjPerro("Rex");
        assertEquals("Guau", a.hacerSonido());
    }

    // ── Herencia ─────────────────────────────────────────────────────────────

    @Test
    public void perroEsSubtipoDeAnimal() {
        assertTrue(new EjPerro("Rex") instanceof EjAnimal);
    }

    @Test
    public void gatoEsSubtipoDeAnimal() {
        assertTrue(new EjGato("Luna") instanceof EjAnimal);
    }
}
