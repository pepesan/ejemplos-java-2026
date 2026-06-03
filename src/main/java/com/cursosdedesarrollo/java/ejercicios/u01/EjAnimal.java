package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-8: clase abstracta — no se puede instanciar directamente.
// Las subclases están obligadas a implementar hacerSonido().
public abstract class EjAnimal {

    private final String nombre;

    public EjAnimal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public abstract String hacerSonido();

    @Override
    public String toString() {
        return nombre + " dice: " + hacerSonido();
    }
}
