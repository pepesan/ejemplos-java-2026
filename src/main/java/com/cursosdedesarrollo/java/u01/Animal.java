package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Herencia y polimorfismo
public class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null || !nombre.equals("")) {
            this.nombre = nombre;
        }
    }

    public String hacerSonido() { return "..."; }
}
