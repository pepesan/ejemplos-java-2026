package com.cursosdedesarrollo.java.u01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerroLadradorTest {
    @Test
    public void perroLadradorTest() {
        PerroLadrador perroLadrador = new PerroLadrador("Nyska", "Podenco");
        String nombre = perroLadrador.getNombre();
        assertEquals("Nyska", nombre);
        perroLadrador.ladrar();
    }
}
