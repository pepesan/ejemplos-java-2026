package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-10: clase abstracta — define la estructura común de todos los vehículos.
// No se puede hacer "new EjVehiculo()" directamente; hay que usar una subclase concreta.
// El método moverme() es abstracto: cada subclase DEBE implementarlo.
public abstract class EjVehiculo {

    private final String marca;

    public EjVehiculo(String marca) {
        this.marca = marca;
    }

    public String getMarca() { return marca; }

    // Método abstracto: no tiene cuerpo aquí. Cada subclase decide cómo moverse.
    public abstract String moverme();

    @Override
    public String toString() {
        return marca + " se mueve: " + moverme();
    }
}