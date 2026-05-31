package com.cursosdedesarrollo.java.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class VehiculoTest {

    @Test
    public void constructorPrincipalAsignaMarcaYAño() {
        Vehiculo v = new Vehiculo("Toyota", 2020);
        assertEquals("Toyota", v.getMarca());
        assertEquals(2020, v.getAño());
    }

    @Test
    public void constructorAlternativoUsa2026PorDefecto() {
        Vehiculo v = new Vehiculo("Honda");
        assertEquals("Honda", v.getMarca());
        assertEquals(2026, v.getAño());
    }

    @Test
    public void toStringContienesMarcaYAño() {
        String s = new Vehiculo("Ford", 2019).toString();
        assertTrue(s.contains("Ford"));
        assertTrue(s.contains("2019"));
    }
}
