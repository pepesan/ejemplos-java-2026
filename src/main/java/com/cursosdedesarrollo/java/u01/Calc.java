package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Sobrecarga: mismo nombre, distintos parámetros
public class Calc {
    public int    sumar(int a, int b)          { return a + b; }
    public double sumar(double a, double b)    { return a + b; }
    public int    sumar(int a, int b, int c)   { return a + b + c; }
}
