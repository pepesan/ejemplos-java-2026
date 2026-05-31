package com.cursosdedesarrollo.java.u05;

import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.*;

public class OptionalTest {

    @Test
    public void buscarPorIndiceValidoDevuelvePresente() {
        String[] arr = {"uno", "dos", "tres"};
        Optional<String> resultado = OptionalDemo.buscarPorIndice(arr, 1);
        assertTrue(resultado.isPresent());
        assertEquals("dos", resultado.get());
    }

    @Test
    public void buscarPorIndiceInvalidoDevuelveVacio() {
        String[] arr = {"uno"};
        assertFalse(OptionalDemo.buscarPorIndice(arr, 5).isPresent());
        assertFalse(OptionalDemo.buscarPorIndice(arr, -1).isPresent());
    }

    @Test
    public void obtenerEnMayusculasTransformaStringLargo() {
        assertEquals("HOLA", OptionalDemo.obtenerEnMayusculas(Optional.of("hola")));
    }

    @Test
    public void obtenerEnMayusculasDevuelveDefaultSiStringCorto() {
        // "ab" tiene longitud <= 2: no supera el filter
        assertEquals("DEFAULT", OptionalDemo.obtenerEnMayusculas(Optional.of("ab")));
    }

    @Test
    public void obtenerEnMayusculasDevuelveDefaultSiVacio() {
        assertEquals("DEFAULT", OptionalDemo.obtenerEnMayusculas(Optional.empty()));
    }

    @Test(expected = IllegalStateException.class)
    public void orElseThrowLanzaExcepcionCuandoVacio() {
        Optional.<String>empty().orElseThrow(() -> new IllegalStateException("vacío"));
    }
}
