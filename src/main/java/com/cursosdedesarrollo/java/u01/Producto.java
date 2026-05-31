package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Getters, setters y toString
public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio >= 0 ? precio : 0;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public void setNombre(String n) { this.nombre = n; }
    public void setPrecio(double p) { if (p >= 0) precio = p; }

    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', precio=" + precio + "}";
    }
}
