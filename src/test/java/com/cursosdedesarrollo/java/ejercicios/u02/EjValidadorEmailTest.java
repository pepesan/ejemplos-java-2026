package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjValidadorEmailTest {

    @Test public void emailValidoDevuelveTrue()          { assertTrue(EjValidadorEmail.esValido("user@example.com")); }
    @Test public void emailConSubdominioEsValido()       { assertTrue(EjValidadorEmail.esValido("a@b.co.uk")); }
    @Test public void nullEsInvalido()                   { assertFalse(EjValidadorEmail.esValido(null)); }
    @Test public void sinArrobaEsInvalido()              { assertFalse(EjValidadorEmail.esValido("userexample.com")); }
    @Test public void arrobaAlInicioEsInvalido()         { assertFalse(EjValidadorEmail.esValido("@example.com")); }
    @Test public void arrobaAlFinalEsInvalido()          { assertFalse(EjValidadorEmail.esValido("user@")); }
    @Test public void sinPuntoEnDominioEsInvalido()      { assertFalse(EjValidadorEmail.esValido("user@example")); }
    @Test public void puntoAlFinalDeDominioEsInvalido()  { assertFalse(EjValidadorEmail.esValido("user@example.")); }
    @Test public void conEspacioEsInvalido()             { assertFalse(EjValidadorEmail.esValido("us er@example.com")); }

    @Test
    public void normalizarEliminaEspaciosYPoneEnMinusculas() {
        assertEquals("user@example.com", EjValidadorEmail.normalizar("  User@EXAMPLE.com  "));
    }
}
