package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjTermostatoTest {

    @Test
    public void temperaturaInicialDentroDeRango() {
        EjTermostato t = new EjTermostato(20);
        assertEquals(20.0, t.getTemperatura(), 0.001);
    }

    @Test
    public void temperaturaDemasiadoBajaSeAcotaAlMinimo() {
        assertEquals(EjTermostato.TEMP_MIN, new EjTermostato(-5).getTemperatura(), 0.001);
    }

    @Test
    public void temperaturaDemasiadoAltaSeAcotaAlMaximo() {
        assertEquals(EjTermostato.TEMP_MAX, new EjTermostato(50).getTemperatura(), 0.001);
    }

    @Test
    public void subirNoSuperaElMaximo() {
        EjTermostato t = new EjTermostato(28);
        t.subir(5);
        assertEquals(EjTermostato.TEMP_MAX, t.getTemperatura(), 0.001);
    }

    @Test
    public void bajarNoSuperaElMinimo() {
        EjTermostato t = new EjTermostato(12);
        t.bajar(5);
        assertEquals(EjTermostato.TEMP_MIN, t.getTemperatura(), 0.001);
    }
}
