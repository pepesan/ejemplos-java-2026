package com.cursosdedesarrollo.java.u01;

public class Gato extends Animal {

    Long cascabeles;
    public Gato(String nombre, Long cascabeles) {
        super(nombre);
        this.cascabeles = cascabeles;
    }

    @Override
    public String hacerSonido() { return "Miau!"; }
}
