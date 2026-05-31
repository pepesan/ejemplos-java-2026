package com.cursosdedesarrollo.java.u05;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

// Unidad 05 — Lambdas e interfaces funcionales: Predicate, Function, Consumer, Supplier
public class FuncionalesDemo {

    // Predicate: criterio de selección — true/false sobre un elemento
    public static <T> List<T> filtrar(List<T> lista, Predicate<T> criterio) {
        return lista.stream().filter(criterio).collect(Collectors.toList());
    }

    // Function: transformar cada elemento de un tipo a otro
    public static <T, R> List<R> transformar(List<T> lista, Function<T, R> mapeador) {
        return lista.stream().map(mapeador).collect(Collectors.toList());
    }

    // Consumer: ejecutar un efecto secundario sobre cada elemento (sin retorno)
    public static <T> void procesar(List<T> lista, Consumer<T> accion) {
        lista.forEach(accion);
    }

    // Supplier: fábrica que produce instancias sin argumentos
    public static <T> T crear(Supplier<T> fabrica) {
        return fabrica.get();
    }
}
