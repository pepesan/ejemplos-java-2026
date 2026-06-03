package com.cursosdedesarrollo.java.ejercicios.u00;

// Ejercicio u00-1: primer programa — variable String, concatenación y System.out.println.
// No se usa if ni lógica condicional: solo declarar, asignar e imprimir.
public class EjSaludoArg {

    public static void main(String[] args) {
        String nombre = new String("Andrés");
        String nombre2 = nombre;
        if (nombre.equals(nombre2)) {
            System.out.println("Son iguales");
        }else{
            System.out.println("No iguales");
        }
    }

    // Concatena sin condiciones: lo que entra sale en el mensaje
    public static String saludo(String nombre) {
        return "Hola, " + nombre + "!";
    }
}
