package com.cursosdedesarrollo.java.u01;

public class EmpleadoFijo extends Empleado {
    public EmpleadoFijo(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularPago() { return getSalarioBase(); }
}
