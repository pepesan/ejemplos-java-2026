package com.cursosdedesarrollo.java.u01;

import java.util.concurrent.atomic.AtomicInteger;

// Unidad 01 — Atributos de instancia, estáticos y patrón Builder
public class Persona {
    private final String nombre;
    private final int    edad;
    private static final AtomicInteger total = new AtomicInteger(0); // thread-safe

    public Persona(String nombre, int edad) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("nombre no puede ser nulo o vacío");
        this.nombre = nombre;
        this.edad   = edad;
        total.incrementAndGet();
    }

    private Persona(Builder b) {
        this(b.nombre, b.edad);
    }

    public String getNombre()      { return nombre; }
    public int    getEdad()        { return edad; }
    public static int getTotal()   { return total.get(); }
    public static void resetTotal(){ total.set(0); }

    public String saludar() {
        return "Hola, soy " + nombre;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }

    // Static nested: Builder pattern (no necesita instancia externa)
    public static class Builder {
        private String nombre;
        private int    edad;

        public Builder nombre(String n) { this.nombre = n; return this; }
        public Builder edad(int e)      { this.edad   = e; return this; }
        public Persona build() {
            if (nombre == null || nombre.isBlank())
                throw new IllegalStateException("nombre es obligatorio");
            return new Persona(this);
        }
    }
}
