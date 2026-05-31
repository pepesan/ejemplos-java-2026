package com.cursosdedesarrollo.java.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {

    private final Calc calc = new Calc();

    @Test
    public void sobrecargarDosEnteros() {
        assertEquals(5, calc.sumar(2, 3));
    }

    @Test
    public void sobrecargarDosDoubles() {
        assertEquals(5.5, calc.sumar(2.0, 3.5), 0.001);
    }

    @Test
    public void sobrecargarTresEnteros() {
        assertEquals(6, calc.sumar(1, 2, 3));
    }
}
