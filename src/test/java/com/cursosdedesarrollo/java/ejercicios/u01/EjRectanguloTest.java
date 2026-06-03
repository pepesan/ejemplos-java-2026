package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjRectanguloTest {

    @Test
    public void constructorAsignaValores() {
        EjRectangulo r = new EjRectangulo(3L, 4L);
        assertEquals((Object) 3L, r.getAncho());
        assertEquals((Object) 4L, r.getAlto());
    }

    @Test
    public void setterActualizaAncho() {
        EjRectangulo r = new EjRectangulo(3L, 4L);
        r.setAncho(10L);
        assertEquals((Object) 10L, r.getAncho());
    }

    @Test
    public void setterActualizaAlto() {
        EjRectangulo r = new EjRectangulo(3L, 4L);
        r.setAlto(20L);
        assertEquals((Object) 20L, r.getAlto());
    }

    @Test
    public void toStringContieneAnchoYAlto() {
        String s = new EjRectangulo(3L, 4L).toString();
        assertTrue(s.contains("3"));
        assertTrue(s.contains("4"));
    }
}
