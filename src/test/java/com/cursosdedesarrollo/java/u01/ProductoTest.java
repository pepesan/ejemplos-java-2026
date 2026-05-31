package com.cursosdedesarrollo.java.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTest {

    @Test
    public void gettersDevuelvenValoresDelConstructor() {
        Producto p = new Producto("Café", 2.5);
        assertEquals("Café", p.getNombre());
        assertEquals(2.5, p.getPrecio(), 0.001);
    }

    @Test
    public void setPrecioPositivoActualiza() {
        Producto p = new Producto("Té", 1.0);
        p.setPrecio(3.0);
        assertEquals(3.0, p.getPrecio(), 0.001);
    }

    @Test
    public void setPrecioNegativoIgnorado() {
        Producto p = new Producto("Té", 1.0);
        p.setPrecio(-5.0);
        assertEquals(1.0, p.getPrecio(), 0.001);
    }

    @Test
    public void toStringContieneNombreYPrecio() {
        String s = new Producto("Leche", 0.9).toString();
        assertTrue(s.contains("Leche"));
        assertTrue(s.contains("0.9"));
    }
}
