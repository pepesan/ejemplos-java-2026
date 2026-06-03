package com.cursosdedesarrollo.java.ejercicios.u02;

// Ejercicio u02-2: métodos de String — validar el formato básico de un email.
// Usa indexOf, substring, lastIndexOf, contains — sin regex — para demostrar la API de String.
public class EjValidadorEmail {

    public static boolean esValido(String email) {
        if (email == null || email.isEmpty()) return false;

        int arroba = email.indexOf('@');
        if (arroba <= 0)                   return false; // sin @ o @ al inicio
        if (arroba == email.length() - 1)  return false; // @ al final
        if (email.contains(" "))           return false; // espacios no permitidos

        String dominio = email.substring(arroba + 1);
        int punto = dominio.lastIndexOf('.');
        if (punto <= 0)                    return false; // sin punto en el dominio
        if (punto == dominio.length() - 1) return false; // punto al final

        return true;
    }

    public static String normalizar(String email) {
        if (email == null) return null;
        return email.trim().toLowerCase();
    }
}
