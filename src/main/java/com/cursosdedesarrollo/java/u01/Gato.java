package com.cursosdedesarrollo.java.u01;

public class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public String hacerSonido() { return "Miau!"; }
}
