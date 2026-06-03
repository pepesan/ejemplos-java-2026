package com.cursosdedesarrollo.java.ejercicios.u02;

import java.util.*;

// Ejercicio u02-4: Collections — agrupar y ordenar strings usando List, Map y Comparator.
public class EjAgrupador {

    // Agrupa palabras por su primera letra (clave en mayúscula)
    public static Map<Character, List<String>> porPrimeraLetra(List<String> palabras) {
        Map<Character, List<String>> grupos = new TreeMap<>(); // TreeMap mantiene orden alfabético
        for (String p : palabras) {
            if (p == null || p.isEmpty()) continue;
            char clave = Character.toUpperCase(p.charAt(0));
            if (!grupos.containsKey(clave)) grupos.put(clave, new ArrayList<>());
            grupos.get(clave).add(p);
        }
        return grupos;
    }

    // Ordena por longitud; en caso de empate, orden alfabético
    public static List<String> ordenarPorLongitud(List<String> palabras) {
        List<String> resultado = new ArrayList<>(palabras);
        Collections.sort(resultado, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int cmp = Integer.compare(a.length(), b.length());
                return cmp != 0 ? cmp : a.compareTo(b);
            }
        });
        return resultado;
    }
}
