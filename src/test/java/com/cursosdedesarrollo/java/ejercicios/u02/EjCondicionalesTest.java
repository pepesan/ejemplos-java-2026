package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjCondicionalesTest {

    // ── maximo ───────────────────────────────────────────────────────────────

    @Test
    public void maximoCuandoPrimeroEsMayor() {
        assertEquals(8, EjCondicionales.maximo(8, 3));
    }

    @Test
    public void maximoCuandoSegundoEsMayor() {
        assertEquals(9, EjCondicionales.maximo(4, 9));
    }

    @Test
    public void maximoCuandoSonIguales() {
        assertEquals(5, EjCondicionales.maximo(5, 5));
    }

    // ── clasificarNota ───────────────────────────────────────────────────────

    @Test
    public void notaMenorDe5EsSuspenso() {
        assertEquals("Suspenso", EjCondicionales.clasificarNota(3));
    }

    @Test
    public void nota5EsAprobado() {
        assertEquals("Aprobado", EjCondicionales.clasificarNota(5));
    }

    @Test
    public void nota7EsNotable() {
        assertEquals("Notable", EjCondicionales.clasificarNota(7));
    }

    @Test
    public void nota9EsSobresaliente() {
        assertEquals("Sobresaliente", EjCondicionales.clasificarNota(9));
    }

    // ── signo ────────────────────────────────────────────────────────────────

    @Test
    public void signoPositivo() {
        assertEquals("positivo", EjCondicionales.signo(10));
    }

    @Test
    public void signoNegativo() {
        assertEquals("negativo", EjCondicionales.signo(-3));
    }

    @Test
    public void signoCero() {
        assertEquals("cero", EjCondicionales.signo(0));
    }
}
