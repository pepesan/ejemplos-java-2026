package com.cursosdedesarrollo.java.ejercicios.u02;

import java.util.HashMap;
import java.util.Map;

// Ejercicio u02-6: operaciones básicas con Map.
public class EjMapa {

    // Cuenta cuántas veces aparece cada palabra en el array.
    public static Map<String, Integer> contarOcurrencias(String[] palabras) {
        Map<String, Integer> mapa = new HashMap<>();
        for (String palabra : palabras) {
            mapa.put(palabra, mapa.getOrDefault(palabra, 0) + 1);
        }
        return mapa;
    }

    // Devuelve el valor asociado a la clave, o defecto si no existe.
    public static int obtenerODefecto(Map<String, Integer> mapa, String clave, int defecto) {
        return mapa.getOrDefault(clave, defecto);
    }

    // Devuelve true si la clave existe en el mapa.
    public static boolean existeClave(Map<String, String> mapa, String clave) {
        return mapa.containsKey(clave);
    }
}
