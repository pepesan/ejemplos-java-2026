package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class CajaTest {

    @Test
    public void cajaStringDevuelveValor() {
        Caja<String> c = new Caja<>("hola");
        assertEquals("hola", c.getValor());
    }

    @Test
    public void cajaIntegerDevuelveValor() {
        Caja<Integer> c = new Caja<>(42);
        assertEquals(Integer.valueOf(42), c.getValor());
    }

    @Test
    public void maximoEntreDosCadenas() {
        assertEquals("z", Caja.maximo("a", "z"));
    }

    @Test
    public void maximoEntreEnteros() {
        assertEquals(Integer.valueOf(10), Caja.maximo(3, 10));
    }
}
