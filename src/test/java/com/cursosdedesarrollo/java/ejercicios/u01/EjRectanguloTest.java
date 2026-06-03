package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjRectanguloTest {

    @Test
    public void areaEsAnchoporAlto() {
        assertEquals(12.0, new EjRectangulo(3, 4).area(), 0.001);
    }

    @Test
    public void perimetroEsCorrecto() {
        assertEquals(14.0, new EjRectangulo(3, 4).perimetro(), 0.001);
    }

    @Test
    public void cuadradoReconocido() {
        assertTrue(new EjRectangulo(5, 5).esCuadrado());
        assertFalse(new EjRectangulo(3, 4).esCuadrado());
    }

    @Test
    public void dimensionNegativaSeConvierteEnAbsoluta() {
        EjRectangulo r = new EjRectangulo(-3, 4);
        assertEquals(3.0, r.getAncho(), 0.001);
        assertEquals(12.0, r.area(), 0.001);
    }

    @Test
    public void dimensionCeroProduceAreaCero() {
        assertEquals(0.0, new EjRectangulo(0, 4).area(), 0.001);
    }
}
