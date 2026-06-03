package com.cursosdedesarrollo.java.ejercicios.u02;

import java.util.Arrays;

// Ejercicio u02-3: arrays — calcular estadísticas básicas sobre un array de enteros.
// Muestra: recorrido con for-each, cast para división real, Arrays.copyOf, Arrays.sort.
public class EjEstadisticasArray {

    public static int maximo(int[] arr) {

        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static int minimo(int[] arr) {

        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    public static double media(int[] arr) {

        long suma = 0;
        for (int n : arr) suma += n;
        return (double) suma / arr.length; // cast para no perder decimales
    }

    // Devuelve una copia ordenada sin modificar el original
    public static int[] ordenadoAscendente(int[] arr) {
        int[] copia = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copia);
        return copia;
    }
}
