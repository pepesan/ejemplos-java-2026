package com.cursosdedesarrollo.java.u01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonaTest {

    @Before
    public void resetContador() {
        Persona.resetTotal();
    }

    @Test
    public void constructorDirectoAsignaNombreYEdad() {
        Persona p = new Persona("Ana", 30);
        assertEquals("Ana", p.getNombre());
        assertEquals(30, p.getEdad());
    }

    @Test
    public void contadorEstaticoCreceCadaInstancia() {
        new Persona("Ana", 30);
        new Persona("Bob", 25);
        assertEquals(2, Persona.getTotal());
    }

    @Test
    public void saludarDevuelveTextoConNombre() {
        assertTrue(new Persona("Eva", 28).saludar().contains("Eva"));
    }

    @Test
    public void builderConstruyePersonaCorrectamente() {
        Persona p = new Persona.Builder().nombre("Carlos").edad(40).build();
        assertEquals("Carlos", p.getNombre());
        assertEquals(40, p.getEdad());
    }
}
