package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EjSesionTest {

    @Before
    public void resetar() {
        EjSesion.resetear();
    }

    @Test
    public void sinSesionesTotalEsCero() {
        assertEquals(0, EjSesion.getTotalSesiones());
    }

    @Test
    public void cadaNuevaSesionIncrementaElTotal() {
        new EjSesion("ana");
        assertEquals(1, EjSesion.getTotalSesiones());
        new EjSesion("bea");
        assertEquals(2, EjSesion.getTotalSesiones());
    }

    @Test
    public void totalEsCompartidoPorTodasLasInstancias() {
        new EjSesion("ana");
        new EjSesion("bea");
        assertEquals(2, EjSesion.getTotalSesiones());
    }

    @Test
    public void cadaSesionTieneSuPropioId() {
        EjSesion s1 = new EjSesion("ana");
        EjSesion s2 = new EjSesion("bea");
        assertEquals(1, s1.getId());
        assertEquals(2, s2.getId());
    }

    @Test
    public void modificarUsuarioNoAfectaAOtraSesion() {
        EjSesion s1 = new EjSesion("ana");
        EjSesion s2 = new EjSesion("bea");
        s1.setUsuario("ana2");
        assertEquals("ana2", s1.getUsuario());
        assertEquals("bea",  s2.getUsuario());
    }

    @Test
    public void metodoEstaticoSinNecesidadDeObjeto() {
        assertEquals(0, EjSesion.getTotalSesiones());
    }

    @Test
    public void toStringContieneIdYUsuario() {
        EjSesion s = new EjSesion("demo");
        assertTrue(s.toString().contains("1"));
        assertTrue(s.toString().contains("demo"));
    }
}
