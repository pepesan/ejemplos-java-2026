package com.cursosdedesarrollo.java.ejercicios.u01;

public class EjGato extends EjAnimal {

    public EjGato(String nombre) {
        super(nombre);
    }

    @Override
    public String hacerSonido() { return "Miau"; }
}
