package com.cursosdedesarrollo.java.u02;

import org.junit.Test;

public class PerroTest {
    @Test
    public void testClase() {
        Perro c = new Perro("Podenco");
        c.setRaza("Labrador");
        Perro c2 = null;
        c2.setRaza("Podenco");
    }
}
