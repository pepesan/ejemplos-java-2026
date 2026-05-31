package com.cursosdedesarrollo.java.u01;

public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, double precioHora, int horas) {
        super(nombre, precioHora);
        this.horasTrabajadas = horas;
    }

    @Override
    public double calcularPago() { return getSalarioBase() * horasTrabajadas; }
}
