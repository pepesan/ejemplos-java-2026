package com.cursosdedesarrollo.java.ejercicios.u01;

import com.cursosdedesarrollo.java.u01.ClaseEquals;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClaseEqualsTest {
    @Test
    public void testEqualsObjetosIguales() {
        ClaseEquals objeto1 = new ClaseEquals("Hola", "Adios");
        ClaseEquals objeto2 = new ClaseEquals("Hola", "Adios");
        assertTrue(objeto1.equals(objeto2));
        assertEquals(objeto1, objeto2);
    }

    @Test
    public void testEqualsObjetosDiferentes() {
        ClaseEquals objeto1 = new ClaseEquals("Hola", "Adios");
        ClaseEquals objeto2 = new ClaseEquals("Hol", "Adios");
        org.junit.Assert.assertFalse(objeto1.equals(objeto2));
    }

    @Test
    public void testHashCode() {
        ClaseEquals objeto1 = new ClaseEquals("Hola", "Adios");
    }

    @Test
    public void testToString() {
        ClaseEquals objeto1 = new ClaseEquals("Hola", "Adios");
        ClaseEquals objeto2 = new ClaseEquals("Hol", "Adios");
        System.out.println(objeto1.toString());
        System.out.println(objeto2.toString());
    }
}
