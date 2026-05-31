package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class CollectionsTest {

    @Test
    public void listPermiteDuplicados() {
        List<String> lista = new ArrayList<>();
        lista.add("Ana"); lista.add("Bob"); lista.add("Ana");
        assertEquals(3, lista.size());
    }

    @Test
    public void setEliminaDuplicados() {
        List<String> lista = Arrays.asList("Ana", "Bob", "Ana");
        Set<String> conjunto = new HashSet<>(lista);
        assertEquals(2, conjunto.size());
    }

    @Test
    public void mapGetOrDefaultDevuelveDefectoCuandoFaltaClave() {
        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 30);
        assertEquals(0, (int) edades.getOrDefault("Nadie", 0));
    }

    @Test
    public void mapEntrySetIteraTodosLosPares() {
        Map<String, Integer> edades = new LinkedHashMap<>();
        edades.put("Ana", 30);
        edades.put("Bob", 25);
        List<String> claves = new ArrayList<>();
        for (Map.Entry<String, Integer> e : edades.entrySet()) {
            claves.add(e.getKey());
        }
        assertEquals(Arrays.asList("Ana", "Bob"), claves);
    }

    @Test
    public void mapKeySetDevuelveTodasLasClaves() {
        Map<String, Integer> m = new HashMap<>();
        m.put("x", 1); m.put("y", 2);
        assertTrue(m.keySet().contains("x"));
        assertTrue(m.keySet().contains("y"));
    }

    @Test
    public void mapValuesDevuelveTodosLosValores() {
        Map<String, Integer> m = new HashMap<>();
        m.put("a", 10); m.put("b", 20);
        List<Integer> vals = new ArrayList<>(m.values());
        Collections.sort(vals);
        assertEquals(Arrays.asList(10, 20), vals);
    }
}
