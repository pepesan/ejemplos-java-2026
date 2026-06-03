package com.cursosdedesarrollo.java.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class VehiculoTest {

    @Test
    public void constructorPrincipalAsignaMarcaYAño() {
        Vehiculo v = new Vehiculo("Toyota", 2014);
        assertEquals("Toyota", v.getMarca());
        assertEquals(2014, v.getAño());
    }

    @Test
    public void constructorAlternativoUsa2026PorDefecto() {
        Vehiculo v = new Vehiculo("Honda");
        assertEquals("Honda", v.getMarca());
        assertEquals(2026, v.getAño());
    }

    @Test
    public void constructorSinParametros() {
        Vehiculo v = new Vehiculo();
        assertEquals("", v.getMarca());
        assertEquals(2026, v.getAño());
    }

    @Test
    public void probamosSetterDeMarca() {
        Vehiculo v = new Vehiculo();
        v.setMarca("Honda");
        assertEquals("Honda", v.getMarca());
    }

    @Test
    public void probamosSetterDeAno() {
        Vehiculo v = new Vehiculo();
        v.setAño(2014);
        assertEquals(2014, v.getAño());
    }

    @Test
    public void toStringContienesMarcaYAño() {
        String s = new Vehiculo("Ford", 2019).toString();
        System.out.println(s);
        assertTrue(s.contains("Ford"));
        assertTrue(s.contains("2019"));
    }
}
