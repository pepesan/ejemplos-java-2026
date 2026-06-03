package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EjParkingTest {

    @Before
    public void resetar() {
        EjParking.resetear();
    }

    @Test
    public void inicialmenteTieneCAPACIDADPlazasLibres() {
        assertEquals(EjParking.CAPACIDAD, EjParking.getPlazasLibres());
    }

    @Test
    public void inicialmenteHayPlazas() {
        assertTrue(EjParking.hayPlazas());
    }

    @Test
    public void setPlazasLibresEstableceElValor() {
        EjParking.setPlazasLibres(4);
        assertEquals(4, EjParking.getPlazasLibres());
    }

    @Test
    public void hayPlazasDespuesDeSetPlazasLibres() {
        EjParking.setPlazasLibres(4);
        assertTrue(EjParking.hayPlazas());
    }

    @Test
    public void sinPlazasLibresHayPlazasDevuelveFalse() {
        EjParking.setPlazasLibres(0);
        assertFalse(EjParking.hayPlazas());
    }
}
