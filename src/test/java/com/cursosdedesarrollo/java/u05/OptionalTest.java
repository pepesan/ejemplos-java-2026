package com.cursosdedesarrollo.java.u05;

import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.*;

public class OptionalTest {

    @Test
    public void ofCreaPresenteYofNullableVacioConNull() {
        assertTrue(Optional.of("hola").isPresent());
        assertFalse(Optional.ofNullable(null).isPresent());
    }

    @Test
    public void filterYMapTransforman() {
        String res = Optional.of("hola")
            .filter(s -> s.length() > 2)
            .map(String::toUpperCase)
            .orElse("DEFAULT");
        assertEquals("HOLA", res);
    }

    @Test
    public void orElseDevuelveDefectoCuandoVacio() {
        String res = Optional.<String>empty().orElse("default");
        assertEquals("default", res);
    }

    @Test(expected = IllegalStateException.class)
    public void orElseThrowLanzaExcepcionCuandoVacio() {
        Optional.<String>empty().orElseThrow(() -> new IllegalStateException("vacío"));
    }
}
