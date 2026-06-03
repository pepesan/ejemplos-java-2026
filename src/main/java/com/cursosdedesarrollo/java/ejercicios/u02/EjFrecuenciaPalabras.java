package com.cursosdedesarrollo.java.ejercicios.u02;

import java.util.LinkedHashMap;
import java.util.Map;

// Ejercicio u02-1: autoboxing + Map — contar frecuencia de cada palabra en un texto.
// Integer autoboxea al hacer put/get; getOrDefault evita el null-check manual.
public class EjFrecuenciaPalabras {

    public static Map<String, Integer> contar(String texto) {
        Map<String, Integer> frecuencias = new LinkedHashMap<>();
        if (texto == null || texto.isEmpty()) return frecuencias;

        for (String token : texto.toLowerCase().split("\\s+")) {
            String palabra = token.replaceAll("[^a-záéíóúüñ]", "");
            if (!palabra.isEmpty()) {
                frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
            }
        }
        return frecuencias;
    }

    public static String masRepetida(Map<String, Integer> frecuencias) {
        String maxPalabra = null;
        int    maxVeces   = 0;
        for (Map.Entry<String, Integer> e : frecuencias.entrySet()) {
            if (e.getValue() > maxVeces) {
                maxVeces   = e.getValue();
                maxPalabra = e.getKey();
            }
        }
        return maxPalabra;
    }
}
