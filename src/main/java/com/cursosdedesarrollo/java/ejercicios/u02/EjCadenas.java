package com.cursosdedesarrollo.java.ejercicios.u02;

// Ejercicio u02-4: métodos básicos de String.
public class EjCadenas {

    public static String mayusculas(String s) {
        return s.toUpperCase();
    }

    // Cuenta cuántas veces aparece el carácter c (distingue mayúsculas/minúsculas).
    public static int contarCaracter(String s, char c) {
        int cuenta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) cuenta++;
        }
        return cuenta;
    }

    public static String invertir(String s) {
        String resultado = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            resultado += s.charAt(i);
        }
        return resultado;
    }

    // Comprueba si frase contiene palabra ignorando mayúsculas/minúsculas.
    public static boolean contiene(String frase, String palabra) {
        return frase.toLowerCase().contains(palabra.toLowerCase());
    }
}
