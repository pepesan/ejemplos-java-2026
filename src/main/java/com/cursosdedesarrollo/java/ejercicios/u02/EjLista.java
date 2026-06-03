package com.cursosdedesarrollo.java.ejercicios.u02;

import java.util.ArrayList;
import java.util.List;

// Ejercicio u02-5: operaciones básicas con List.
public class EjLista {

    // Devuelve los primeros n elementos (o todos si la lista es más corta).
    public static List<String> primerosN(List<String> lista, int n) {
        List<String> resultado = new ArrayList<>();
        for (int i = 0; i < n && i < lista.size(); i++) {
            resultado.add(lista.get(i));
        }
        return resultado;
    }

    // Devuelve solo los números mayores que cero.
    public static List<Integer> filtrarPositivos(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        for (int num : numeros) {
            if (num > 0) resultado.add(num);
        }
        return resultado;
    }

    // Une los elementos de la lista con el separador dado.
    public static String unir(List<String> lista, String separador) {
        String resultado = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i > 0) resultado += separador;
            resultado += lista.get(i);
        }
        return resultado;
    }
}
