package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjRectanguloTest {

    @Test
    public void areaEsAnchoporAlto() {
        assertEquals((Object) 12L, new EjRectangulo(3L, 4L).area());
    }

    @Test
    public void perimetroEsCorrecto() {
        assertEquals((Object) 14L, new EjRectangulo(3L, 4L).perimetro());
    }

    @Test
    public void cuadradoReconocido() {
        assertTrue(new EjRectangulo(5L, 5L).esCuadrado());
        assertFalse(new EjRectangulo(3L, 4L).esCuadrado());
    }

    @Test
    public void dimensionNegativaSeConvierteEnAbsoluta() {
        EjRectangulo r = new EjRectangulo(-3L, 4L);
        assertEquals((Object) 3L, r.getAncho());
        assertEquals((Object) 12L, r.area());
    }

    @Test
    public void dimensionCeroProduceAreaCero() {
        assertEquals((Object) 0L, new EjRectangulo(0L, 4L).area());
    }
}
