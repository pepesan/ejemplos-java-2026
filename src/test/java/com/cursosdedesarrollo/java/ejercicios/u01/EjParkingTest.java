package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EjParkingTest {

    @Before
    public void resetar() {
        EjParking.resetear();
    }

    // ── Estado inicial ───────────────────────────────────────────────────────

    @Test
    public void aparcamientoVacioTieneCAPACIDADPlazasLibres() {
        assertEquals(EjParking.CAPACIDAD, EjParking.getPlazasLibres());
    }

    @Test
    public void aparcamientoVacioTienePlazas() {
        assertTrue(EjParking.hayPlazas());
    }

    // ── entrar() ─────────────────────────────────────────────────────────────

    @Test
    public void entrarReducePlazasLibres() {
        new EjParking("1234ABC").entrar();
        assertEquals(EjParking.CAPACIDAD - 1, EjParking.getPlazasLibres());
    }

    @Test
    public void entrarDevuelveTrueCuandoHayPlazas() {
        assertTrue(new EjParking("1234ABC").entrar());
    }

    @Test
    public void entrarDevuelveFalseCuandoEstaLleno() {
        for (int i = 0; i < EjParking.CAPACIDAD; i++) {
            new EjParking("000" + i).entrar();
        }
        assertFalse(EjParking.hayPlazas());
        assertFalse(new EjParking("9999ZZZ").entrar());
    }

    @Test
    public void noSuperaCapacidadConEntradasExtra() {
        for (int i = 0; i < EjParking.CAPACIDAD + 3; i++) {
            new EjParking("000" + i).entrar();
        }
        assertEquals(0, EjParking.getPlazasLibres());
    }

    // ── salir() ──────────────────────────────────────────────────────────────

    @Test
    public void salirIncrementaPlazasLibres() {
        EjParking v = new EjParking("1234ABC");
        v.entrar();
        v.salir();
        assertEquals(EjParking.CAPACIDAD, EjParking.getPlazasLibres());
    }

    @Test
    public void salirConAparcamientoVacioNoProduceNegativos() {
        new EjParking("1234ABC").salir();
        assertEquals(EjParking.CAPACIDAD, EjParking.getPlazasLibres());
    }

    // ── Estado compartido entre instancias ───────────────────────────────────

    @Test
    public void dosVehiculosCompartenElMismoContador() {
        new EjParking("1111AAA").entrar();
        new EjParking("2222BBB").entrar();
        assertEquals(EjParking.CAPACIDAD - 2, EjParking.getPlazasLibres());
    }
}
