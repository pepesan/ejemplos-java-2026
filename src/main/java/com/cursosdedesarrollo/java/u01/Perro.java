package com.cursosdedesarrollo.java.u01;

public class Perro extends Animal {

    String raza;

    public Perro(String nombre,  String raza) {
        super(nombre);
        this.raza = raza;
    }

    @Override
    public String hacerSonido() { return "Guau!"; }
}
