package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjConversorTest {

    private final EjConversor c = new EjConversor();

    @Test
    public void convertirKmAMillas() {
        assertEquals(62.1371, c.convertir(100.0), 0.001);
    }

    @Test
    public void convertirLitrosPrecio() {
        assertEquals(75.0, c.convertir(50.0, 1.5), 0.001);
    }

    @Test
    public void convertirEurosTasaCambio() {
        assertEquals(110.0, c.convertir(100.0, 1.1, "USD"), 0.001);
    }

    @Test
    public void sobrecargaSeleccionaMetodoCorrecto() {
        // El compilador elige convertir(double) para 1 arg, convertir(double,double) para 2
        double millas = c.convertir(1.0);
        double coste  = c.convertir(1.0, 2.0);
        assertNotEquals(millas, coste, 0.001);
    }
}
