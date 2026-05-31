package com.cursosdedesarrollo.java.u05;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Unidad 05 — Stream API: pipeline de operaciones intermedias y terminales
public class StreamDemo {

    // filter + map + collect: pipeline completo
    public static List<String> nombresMayoresQue(List<String> nombres, int longMin) {
        return nombres.stream()
            .filter(n -> n.length() > longMin)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    // groupingBy: agrupar en un Map según un criterio
    public static Map<Integer, List<String>> agruparPorLongitud(List<String> nombres) {
        return nombres.stream()
            .collect(Collectors.groupingBy(String::length));
    }

    // mapToInt + sum: operación de reducción sobre primitivos (sin boxing)
    public static int sumaDeLongitudes(List<String> nombres) {
        return nombres.stream().mapToInt(String::length).sum();
    }

    // count: terminal que devuelve el número de elementos que superan el filtro
    public static long contarConLongitudPar(List<String> nombres) {
        return nombres.stream().filter(n -> n.length() % 2 == 0).count();
    }
}
