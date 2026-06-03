package com.cursosdedesarrollo.java.ejercicios.u00;

// Ejercicio u00-2: variables numéricas y las cuatro operaciones aritméticas básicas.
// Un método por operación, sin condiciones, sin entrada del usuario.
public class EjCalculadoraMain {

    public static void main(String[] args) {
        double a = 10.0;
        double b = 3.0;
        System.out.println("Suma:     " + sumar(a, b));
        System.out.println("Resta:    " + restar(a, b));
        System.out.println("Producto: " + multiplicar(a, b));
        System.out.println("Cociente: " + dividir(a, b));
    }

    public static double sumar(double a, double b)       { return a + b; }
    public static double restar(double a, double b)      { return a - b; }
    public static double multiplicar(double a, double b) { return a * b; }
    public static double dividir(double a, double b)     { return a / b; }
}
