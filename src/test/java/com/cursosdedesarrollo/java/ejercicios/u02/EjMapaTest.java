package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class EjMapaTest {

    // ── contarOcurrencias ────────────────────────────────────────────────────

    @Test
    public void contarOcurrenciasCuentaCorrectamente() {
        String[] palabras = {"hola", "mundo", "hola", "java"};
        Map<String, Integer> resultado = EjMapa.contarOcurrencias(palabras);
        assertEquals(2, (int) resultado.get("hola"));
        assertEquals(1, (int) resultado.get("mundo"));
        assertEquals(1, (int) resultado.get("java"));
    }

    @Test
    public void contarOcurrenciasArrayVacio() {
        assertTrue(EjMapa.contarOcurrencias(new String[]{}).isEmpty());
    }

    // ── obtenerODefecto ──────────────────────────────────────────────────────

    @Test
    public void obtenerODefectoDevuelveValorExistente() {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("edad", 25);
        assertEquals(25, EjMapa.obtenerODefecto(mapa, "edad", 0));
    }

    @Test
    public void obtenerODefectoDevuelveDefectoSiNoExiste() {
        Map<String, Integer> mapa = new HashMap<>();
        assertEquals(99, EjMapa.obtenerODefecto(mapa, "noexiste", 99));
    }

    // ── existeClave ──────────────────────────────────────────────────────────

    @Test
    public void existeClaveDevuelveTrueSiExiste() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("nombre", "Ana");
        assertTrue(EjMapa.existeClave(mapa, "nombre"));
    }

    @Test
    public void existeClaveDevuelveFalseSiNoExiste() {
        Map<String, String> mapa = new HashMap<>();
        assertFalse(EjMapa.existeClave(mapa, "apellido"));
    }
}
