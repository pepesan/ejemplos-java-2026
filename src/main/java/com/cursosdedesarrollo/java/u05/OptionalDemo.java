package com.cursosdedesarrollo.java.u05;

import java.util.Optional;

// Unidad 05 — Optional: representar ausencia de valor sin null explícito
public class OptionalDemo {

    // Búsqueda que puede no encontrar resultado: devuelve Optional vacío si idx fuera de rango
    public static Optional<String> buscarPorIndice(String[] arr, int idx) {
        if (idx < 0 || idx >= arr.length) return Optional.empty();
        return Optional.ofNullable(arr[idx]);
    }

    // Encadenar filter + map + orElse: transforma si presente y cumple condición
    public static String obtenerEnMayusculas(Optional<String> opt) {
        return opt.filter(s -> s.length() > 2)
                  .map(String::toUpperCase)
                  .orElse("DEFAULT");
    }
}
