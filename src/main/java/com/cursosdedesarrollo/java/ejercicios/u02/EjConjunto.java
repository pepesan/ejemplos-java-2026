package com.cursosdedesarrollo.java.ejercicios.u02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Ejercicio u02-7: operaciones básicas con Set.
public class EjConjunto {

    // Elimina duplicados preservando el orden de primera aparición.
    public static List<String> sinDuplicados(List<String> lista) {
        Set<String> vistos = new HashSet<>();
        List<String> resultado = new ArrayList<>();
        for (String elemento : lista) {
            if (vistos.add(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    // Devuelve true si la lista tiene algún elemento repetido.
    public static boolean tieneDuplicados(List<String> lista) {
        Set<String> vistos = new HashSet<>();
        for (String elemento : lista) {
            if (!vistos.add(elemento)) return true;
        }
        return false;
    }

    // Devuelve los elementos que aparecen en las dos listas.
    public static Set<Integer> comunes(List<Integer> a, List<Integer> b) {
        Set<Integer> conjuntoA = new HashSet<>(a);
        Set<Integer> resultado = new HashSet<>();
        for (int elemento : b) {
            if (conjuntoA.contains(elemento)) resultado.add(elemento);
        }
        return resultado;
    }
}
