package com.cursosdedesarrollo.java.ejercicios.u02;

// Ejercicio u02-2: if / else if / else.
public class EjCondicionales {

    public static int maximo(int a, int b) {
        if (a >= b) return a;
        return b;
    }

    public static String clasificarNota(int nota) {
        if (nota < 5)       return "Suspenso";
        else if (nota < 7)  return "Aprobado";
        else if (nota < 9)  return "Notable";
        else                return "Sobresaliente";
    }

    public static String signo(int n) {
        if (n > 0)      return "positivo";
        else if (n < 0) return "negativo";
        else            return "cero";
    }
}
