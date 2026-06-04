package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class CollectionsTest {

    // ── Recorrer List ────────────────────────────────────────────────────────

    @Test
    public void recorrerListConFor() {
        // for clásico: útil cuando necesitamos el índice (p.ej. para acceder al elemento anterior).
        List<String> nombres = Arrays.asList("Ana", "Bob", "Carlos");
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < nombres.size(); i++) {
            resultado.append(nombres.get(i));
            if (i < nombres.size() - 1) resultado.append(", ");
        }
        assertEquals("Ana, Bob, Carlos", resultado.toString());
    }

    @Test
    public void recorrerListConForEach() {
        // for-each: la forma más limpia cuando no necesitamos el índice.
        List<String> nombres = Arrays.asList("Ana", "Bob", "Carlos");
        List<String> mayusculas = new ArrayList<>();
        for (String nombre : nombres) {
            mayusculas.add(nombre.toUpperCase());
        }
        assertEquals(Arrays.asList("ANA", "BOB", "CARLOS"), mayusculas);
    }

    // ── Recorrer Set ─────────────────────────────────────────────────────────

    @Test
    public void recorrerSetConForEach() {
        // Set no garantiza orden, así que solo comprobamos que están todos los elementos.
        Set<String> conjunto = new HashSet<>(Arrays.asList("Ana", "Bob", "Carlos"));
        int contador = 0;
        for (String elemento : conjunto) {
            assertFalse(elemento.isEmpty());
            contador++;
        }
        assertEquals(3, contador);
    }

    // ── Recorrer Map ─────────────────────────────────────────────────────────

    @Test
    public void recorrerMapPorClaves() {
        // keySet(): cuando solo necesitamos las claves.
        Map<String, Integer> edades = new LinkedHashMap<>();
        edades.put("Ana", 30); edades.put("Bob", 25);
        List<String> claves = new ArrayList<>();
        for (String clave : edades.keySet()) {
            claves.add(clave);
        }
        assertEquals(Arrays.asList("Ana", "Bob"), claves);
    }

    @Test
    public void recorrerMapPorValores() {
        // values(): cuando solo necesitamos los valores.
        Map<String, Integer> edades = new LinkedHashMap<>();
        edades.put("Ana", 30); edades.put("Bob", 25);
        List<Integer> valores = new ArrayList<>();
        for (int valor : edades.values()) {
            valores.add(valor);
        }
        assertEquals(Arrays.asList(30, 25), valores);
    }

    @Test
    public void recorrerMapPorEntradas() {
        // entrySet(): cuando necesitamos clave Y valor a la vez — la forma más completa.
        Map<String, Integer> edades = new LinkedHashMap<>();
        edades.put("Ana", 30); edades.put("Bob", 25);
        List<String> resumen = new ArrayList<>();
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            resumen.add(entrada.getKey() + "=" + entrada.getValue());
        }
        assertEquals(Arrays.asList("Ana=30", "Bob=25"), resumen);
    }

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

    // ── List básico ──────────────────────────────────────────────────────────

    @Test
    public void listBasicoOperaciones() {
        // List: colección ordenada que permite duplicados y acceso por índice.
        List<String> lista = new ArrayList<>();
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");

        assertEquals(3, lista.size());
        assertEquals("dos", lista.get(1));
        assertTrue(lista.contains("tres"));

        lista.remove("uno");
        assertEquals(2, lista.size());
        assertFalse(lista.contains("uno"));
    }

    // ── ArrayList básico ─────────────────────────────────────────────────────

    @Test
    public void arrayListBasicoOperaciones() {
        // ArrayList: List respaldada por un array dinámico; acceso O(1) por índice.
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        assertEquals(Integer.valueOf(20), numeros.get(1));

        numeros.set(1, 99);
        assertEquals(Integer.valueOf(99), numeros.get(1));

        numeros.remove(Integer.valueOf(10));
        assertEquals(2, numeros.size());
    }

    // ── LinkedList básico ────────────────────────────────────────────────────

    @Test
    public void linkedListBasicoOperaciones() {
        // LinkedList: List doblemente enlazada; inserción/borrado en extremos O(1).
        LinkedList<String> lista = new LinkedList<>();
        lista.add("centro");
        lista.addFirst("primero");
        lista.addLast("ultimo");

        assertEquals("primero", lista.getFirst());
        assertEquals("ultimo", lista.getLast());
        assertEquals(3, lista.size());

        lista.removeFirst();
        assertEquals("centro", lista.getFirst());
    }

    // ── Map básico ───────────────────────────────────────────────────────────

    @Test
    public void mapBasicoOperaciones() {
        // Map: asocia claves únicas a valores; ninguna clave puede repetirse.
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("manzana", 3);
        mapa.put("pera", 5);
        mapa.put("manzana", 10); // sobreescribe el valor anterior

        assertEquals(2, mapa.size());
        assertEquals(Integer.valueOf(10), mapa.get("manzana"));
        assertFalse(mapa.containsKey("naranja"));

        mapa.remove("pera");
        assertFalse(mapa.containsKey("pera"));
    }

    // ── HashMap básico ───────────────────────────────────────────────────────

    @Test
    public void hashMapBasicoOperaciones() {
        // HashMap: implementación de Map con tabla hash; orden de claves no garantizado.
        HashMap<String, String> capitales = new HashMap<>();
        capitales.put("España", "Madrid");
        capitales.put("Francia", "París");
        capitales.put("Italia", "Roma");

        assertEquals("Madrid", capitales.get("España"));
        assertTrue(capitales.containsValue("París"));

        capitales.putIfAbsent("España", "Barcelona"); // no sobreescribe porque ya existe
        assertEquals("Madrid", capitales.get("España"));
    }

    // ── Set básico ───────────────────────────────────────────────────────────

    @Test
    public void setBasicoOperaciones() {
        // Set: colección sin duplicados; add() devuelve false si el elemento ya existe.
        Set<String> conjunto = new HashSet<>();
        conjunto.add("rojo");
        conjunto.add("verde");
        conjunto.add("azul");
        boolean añadido = conjunto.add("rojo"); // duplicado, no se añade

        assertFalse(añadido);
        assertEquals(3, conjunto.size());
        assertTrue(conjunto.contains("verde"));

        conjunto.remove("verde");
        assertFalse(conjunto.contains("verde"));
    }

    // ── HashSet básico ───────────────────────────────────────────────────────

    @Test
    public void hashSetBasicoOperaciones() {
        // HashSet: implementación de Set con tabla hash; sin orden garantizado.
        HashSet<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(2); // duplicado ignorado

        assertEquals(3, numeros.size());

        HashSet<Integer> otros = new HashSet<>(Arrays.asList(2, 3, 4));
        numeros.retainAll(otros); // intersección: {2, 3}
        assertEquals(2, numeros.size());
        assertTrue(numeros.contains(2));
        assertTrue(numeros.contains(3));
    }

    // ── SortedSet básico ─────────────────────────────────────────────────────

    @Test
    public void sortedSetBasicoOperaciones() {
        // SortedSet (TreeSet): Set que mantiene los elementos en orden natural ascendente.
        SortedSet<String> nombres = new TreeSet<>();
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Beatriz");

        assertEquals("Ana", nombres.first());
        assertEquals("Carlos", nombres.last());

        // headSet devuelve los elementos estrictamente menores que el dado
        SortedSet<String> antesDeCarlos = nombres.headSet("Carlos");
        assertEquals(2, antesDeCarlos.size());
        assertTrue(antesDeCarlos.contains("Ana"));
        assertTrue(antesDeCarlos.contains("Beatriz"));
    }
}
