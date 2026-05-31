package com.cursosdedesarrollo.java.u01;

// Clase abstracta: esqueleto con estado compartido
public abstract class Empleado implements Pagable {
    private String nombre;
    private double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre      = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre()      { return nombre; }
    public double getSalarioBase() { return salarioBase; }

    @Override
    public abstract double calcularPago(); // obliga a las subclases
}
