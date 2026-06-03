package com.cursosdedesarrollo.java.ejercicios.u00;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjCalculadoraMainTest {

    @Test
    public void sumar() {
        assertEquals(13.0, EjCalculadoraMain.sumar(10, 3), 0.001);
    }

    @Test
    public void restar() {
        assertEquals(7.0, EjCalculadoraMain.restar(10, 3), 0.001);
    }

    @Test
    public void multiplicar() {
        assertEquals(30.0, EjCalculadoraMain.multiplicar(10, 3), 0.001);
    }

    @Test
    public void dividir() {
        assertEquals(5.0, EjCalculadoraMain.dividir(10, 2), 0.001);
    }
}
