package com.cursosdedesarrollo.java.u01;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ColeccionTest {

    // Implementación de prueba de Coleccion<String>
    static class ListaSimple implements Coleccion<String> {
        final List<String> elementos = new ArrayList<>();

        @Override
        public void agregar(String s) { elementos.add(s); }
    }

    @Test
    public void agregarTodosUsaDefaultMethod() {
        ListaSimple lista = new ListaSimple();
        lista.agregarTodos(Arrays.asList("a", "b", "c"));
        assertEquals(3, lista.elementos.size());
        assertEquals("a", lista.elementos.get(0));
    }
}
