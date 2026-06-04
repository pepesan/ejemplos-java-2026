package com.cursosdedesarrollo.java.ejercicios.u02;

// Ejercicio u02-3: for y while.
public class EjBucles {

    // Suma todos los enteros entre desde y hasta (ambos inclusive).
    public static int sumar(int desde, int hasta) {
        int total = 0;
        for (int i = desde; i <= hasta; i++) total += i;
        return total;
    }

    // Calcula n! iterativamente con while.
    public static long factorial(int n) {
        long resultado = 1;
        int i = n;
        while (i > 1) {
            resultado *= i;
            i--;
        }
        return resultado;
    }

}
